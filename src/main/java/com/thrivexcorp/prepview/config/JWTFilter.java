package com.thrivexcorp.prepview.config;

import com.thrivexcorp.prepview.service.impl.JWTService;
import com.thrivexcorp.prepview.service.impl.MyUserDetailService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTFilter extends OncePerRequestFilter {

    @Autowired
    private JWTService jwtService;

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //Extract the token from authorization headers
        String authHeader = request.getHeader("Authorization");
        String token =  null;
        String username = null;

        if(authHeader !=  null && authHeader.startsWith("Bearer")){
            token = authHeader.substring(7);
            username = jwtService.extractUserNameFromToken(token);
        }

        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = applicationContext.getBean(MyUserDetailService.class).loadUserByUsername(username);
            if(jwtService.validateToken(token, userDetails)){

                //prepare UsernmaePassswordAuthentication bean
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                //Add this token into spring filter chain
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }else {
                logger.warn("Invalid JWT Token");
            }

        }

        // Continue the filter chain
        filterChain.doFilter(request, response);
    }
}

package com.thrivexcorp.prepview.database.impl;

import com.thrivexcorp.prepview.database.PostgresService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class PostgresServiceImpl implements PostgresService {


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PostgresServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createTable(String tableName) throws SQLException {
        String createTableQuery = String.format("CREATE TABLE IF NOT EXISTS %s (id SERIAL PRIMARY KEY)", tableName);
        jdbcTemplate.execute(createTableQuery);
    }

    @Override
    public void addFieldToTable(String tableName, String fieldName, String fieldType) throws SQLException {
        String columnDefinition = getColumnDefinitionByType(fieldType);
        String addColumnQuery = String.format("ALTER TABLE %s ADD COLUMN IF NOT EXISTS %s %s", tableName, fieldName, columnDefinition);
        jdbcTemplate.execute(addColumnQuery);
    }


    private String getColumnDefinitionByType(String fieldType) {
        switch (fieldType.toUpperCase()) {
            case "STRING":
                return "VARCHAR(255)";
            case "CURRENCY":
                return "NUMERIC(15, 2)";
            case "NUMBER":
                return "INT";
            case "BOOLEAN":
                return "BOOLEAN";
            case "DATE":
                return "DATE";
            case "URL":
                return "TEXT";
            case "DATE_TIME":
                return "TIMESTAMP";
            case "PICKLIST":
                return "VARCHAR(255)"; // or could be an ENUM
            case "MULTI_PICKLIST":
                return "TEXT"; // or JSON/ARRAY based on requirements
            case "PERCENTAGE":
                return "NUMERIC(5, 2)";
            default:
                throw new IllegalArgumentException("Unsupported field type: " + fieldType);
        }
    }

}

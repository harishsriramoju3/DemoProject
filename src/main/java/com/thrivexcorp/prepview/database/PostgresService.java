package com.thrivexcorp.prepview.database;

import java.sql.SQLException;


public interface PostgresService {

        void createTable(String tableName) throws SQLException;
        void addFieldToTable(String tableName, String fieldName, String fieldType) throws SQLException;

}

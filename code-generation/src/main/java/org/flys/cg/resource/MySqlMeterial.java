package org.flys.cg.resource;

import org.flys.cg.Column;
import org.flys.cg.MetaTable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlMeterial implements RawMaterial {
    public static final String url = "jdbc:mysql://localhost:3306/information_schema";
    public static final String userName = "root";
    public static final String passWord = "root";
    private static final String tableName = "table_name";
    private static final String database = "jst-mes";

    @Override
    public List<String> getTables() {
        String sql = "SELECT table_name FROM `TABLES` WHERE TABLE_SCHEMA='" + database + "'";
        Connection connection = getConnection();
        Statement statement = null;
        ArrayList<String> list = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            list = new ArrayList<String>();
            while (resultSet.next()) {
                list.add(resultSet.getString(tableName));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public MetaTable getTable(String tableName) {
        String sql = "SELECT column_name,is_nullable,data_type,CHARACTER_MAXIMUM_LENGTH,COLUMN_COMMENT,COLUMN_KEY FROM `COLUMNS`" +
                " WHERE TABLE_SCHEMA='" + database + "' AND table_name='" + tableName + "'";
        Connection connection = getConnection();
        Statement statement = null;
        MetaTable table = new MetaTable(tableName);
        try {
            List<Column> columns = table.getColumns();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Column column = new Column();
                column.setName(resultSet.getString("column_name"));
                column.setNotes(resultSet.getString("COLUMN_COMMENT"));
                column.setType(resultSet.getString("data_type"));
                column.setLength(resultSet.getInt("CHARACTER_MAXIMUM_LENGTH"));
                column.setNotEmpty(!"NO".equals(resultSet.getString("is_nullable")));
                column.setPrimaryKey("PRI".equals(resultSet.getString("COLUMN_KEY")));
                columns.add(column);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return table;
    }

    private Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(url, userName, passWord);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

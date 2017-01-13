/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Třída dědící z Database slouží k napojení na SQLite databázi.
 * 
 * @author Eva Baščíková
 */
public class SqliteDatabase extends Database {

    /**
     * Konstruktor, který nastavuje typ databáze a cestu k ní
     * 
     * @param connectionString cesta k databázi
     */
    public SqliteDatabase(String connectionString) {
        try {
            Class.forName("org.sqlite.JDBC");
            super.connection = DriverManager.getConnection(connectionString);
        } 
        catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Rozhraní pro vytvoření databázové třídy, zahrnuje všechny důležité metody (funkce).
 * 
 * @author Eva Bascikova
 */
public interface IDatabase {
    
    /**
     * Vrací odkaz na spojení s databází.
     * @return spojení s databází
     */
    public Connection getConnection();
    
    /**
     * Delete příkaz.
     * 
     * @param table z jaké tabulky se bude mazat
     * @param condition podmínka pro mazání (nelze smazat celou tabulku)
     * @param param parametry
     * @return návratový kód
     * @throws SQLException 
     */
    public int delete(String table, String condition, Object[] param) throws SQLException;
    
    /**
     * Insert příkaz.
     * 
     * @param table do jaké tabulky se bude vkládat
     * @param params parametry, které chceme vložit
     * @return návratový kód
     * @throws SQLException 
     */
    public int insert(String table, Object[] params) throws SQLException;
    
    /**
     * Update příkaz.
     * 
     * @param table tabulka, která bude aktualizována
     * @param columns sloupce, které aktualizujeme
     * @param condition podmínka (co chceme aktualizovat -> nelze aktualizovat všechny záznamy)
     * @param params hodnoty, které budeme aktualizovat
     * @return návratový kód
     * @throws SQLException 
     */
    public int update(String table, String[] columns, String condition, Object[] params) throws SQLException;
     
    /**
     * Select příkaz
     * 
     * @param table z jaké tabulky budeme brát
     * @param columns jaké hodnoty
     * @param condition podmínka
     * @param params parametry k podmínce
     * @return množina výsledků
     * @throws SQLException 
     */
    public ResultSet select(String table, String[] columns, String condition, Object[] params) throws SQLException;
    
    /**
     * Select příkaz bez podmínky.
     * 
     * @param table z jaké tabulky budeme brát
     * @param columns které sloupce
     * @return množina výsledků
     * @throws SQLException 
     */
    public ResultSet select(String table, String[] columns) throws SQLException;
    
    /**
     * Zjišťuje první volné id v databázi.
     * 
     * @param table v jaké tabulce
     * @return nejnižší volné id
     * @throws SQLException 
     */
    public int freeId(String table) throws SQLException;
}

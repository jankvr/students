/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Třída implementuje základní rozhraní IDatabase. 
 * Slouží k základní implementaci CreateReadUpdateDelete operací.
 * Třída je nezávislá na konkrétním SQL ovladači, její potomci můžou používat jak 
 * MySQL ovladač, tak i SQLite například.
 * 
 * @author Eva Baščíková
 */
public abstract class Database implements IDatabase {
    // spojení s databází
    protected Connection connection;

    /**
     * Vrací odkaz na spojení s databází.
     * 
     * @return spojení s databází
     */
    @Override
    public Connection getConnection() {
        return connection;
    }
    
    /**
     * Privátní metoda, která připojuje případné parametry k dotazu.
     * 
     * @param query
     * @param params
     * @return
     * @throws SQLException 
     */
    private int query(String query, Object[] params) throws SQLException{
        PreparedStatement ps = connection.prepareStatement(query);
        
        if (params != null) {
            int index = 1;
            for(Object param : params){
                ps.setObject(index, param);
                index++;
            }
        }
        return ps.executeUpdate();
    }
    
    /**
     * Delete příkaz.
     * 
     * @param table z jaké tabulky se bude mazat
     * @param condition podmínka pro mazání (nelze smazat celou tabulku)
     * @param param parametry
     * @return návratový kód
     * @throws SQLException 
     */
    @Override
    public int delete(String table, String condition, Object[] param) throws SQLException {
        Query query = new Query();
        
        query.delete(table).where(condition);
        
        return query(query.getQuery(), param);
    }
    
    /**
     * Insert příkaz.
     * 
     * @param table do jaké tabulky se bude vkládat
     * @param params parametry, které chceme vložit
     * @return návratový kód
     * @throws SQLException 
     */
    @Override
    public int insert(String table, Object[] params) throws SQLException {
        Query query = new Query();
        
        query.insert(table).values(params);
        System.out.println(query.getQuery());
        return query(query.getQuery(), params);
    }
    
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
    @Override
    public int update(String table, String[] columns, String condition, Object[] params) throws SQLException {
        Query query = new Query();

        query.update(table).set(columns).where(condition);
            
        return query(query.getQuery(), params);
    }
    
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
    @Override
    public ResultSet select(String table, String[] columns, String condition, Object[] params) throws SQLException {
        Query query = new Query();
        
        query.select(columns).from(table).where(condition);

        PreparedStatement ps = connection.prepareStatement(query.getQuery());
        
        if(params != null){
            int index = 1;
            
            for(Object param : params){
                ps.setObject(index, param);
                index++;
            }
        }

        ResultSet rs = ps.executeQuery();
        return rs;
    }
    
    /**
     * Select příkaz bez podmínky.
     * 
     * @param table z jaké tabulky budeme brát
     * @param columns které sloupce
     * @return množina výsledků
     * @throws SQLException 
     */
    @Override
    public ResultSet select(String table, String[] columns) throws SQLException {
        Query query = new Query();
        
        query.select(columns).from(table);
        PreparedStatement ps = connection.prepareStatement(query.getQuery());
        
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    
    /**
     * Zjišťuje první volné id v databázi.
     * 
     * @param table v jaké tabulce
     * @return nejnižší volné id
     * @throws SQLException 
     */
    @Override
    public int freeId(String table) throws SQLException {
        Query query = new Query();
        
        query.select(null).from(table).orderBy("1");
        PreparedStatement ps = connection.prepareStatement(query.getQuery());
        
        ResultSet rs = ps.executeQuery();
        
        int index = 1;
        while (rs.next()) {
            if (index != rs.getInt(1)) {
                return index;
            }
            else {
                index++;
            }
        }
     
        return index;
    }
}

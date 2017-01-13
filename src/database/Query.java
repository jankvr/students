/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 * Třída slouží k vytváření jednotlivých dotazů, které jsou použity v databázi
 * 
 * @author Eva Baščíková
 */
public class Query {
    
    private StringBuilder query;
    
    /**
     * Select příkaz.
     * 
     * @param columns sloupce, které chceme vypsat
     * @return odkaz na tuto instanci
     */
    public Query select(String[] columns) {
        query = new StringBuilder();
        query.append("SELECT ");
        
        if (columns != null && columns.length > 0) {
            for (String column : columns) {
                query.append(column);
                query.append(",");
            }
            query.deleteCharAt(query.lastIndexOf(","));
            query.append(" ");
        }
        else {
            query.append("* ");
        }
        
        return this;
    }
    
    /**
     * Insert příkaz.
     * 
     * @param table do které tabulky se bude vkládat
     * @return odkaz na tuto instanci
     */
    public Query insert(String table){
        query = new StringBuilder();
        query.append("INSERT INTO ");
        query.append(table);
        return this;
    }
    
    /**
     * Update příkaz.
     * 
     * @param table kterou tabulku budeme updatovat
     * @return odkaz na tuto instanci
     */
    public Query update(String table){
        query = new StringBuilder();
        query.append("UPDATE ");
        query.append(table);
        query.append(" ");
        return this;
    }
    
    /**
     * Delete příkaz.
     * 
     * @param table z které tabulky budeme mazat
     * @return odkaz na tuto instanci
     */
    public Query delete(String table){
        query = new StringBuilder();
        query.append("DELETE FROM ");
        query.append(table);
        query.append(" ");
        return this;
    }
    
    /**
     * Klíčové slovo FROM.
     * 
     * @param table z které tabulky se bude vybírat
     * @return odkaz na tuto instanci
     */
    public Query from(String table){ 
        query.append("FROM ");
        query.append(table);
        query.append(" ");
        
        return this;
    }
    
    /**
     * Klíčové slovo FROM s prefixem.
     * 
     * @param table z které tabulky se bude vybírat
     * @param prefix prefix tabulky
     * @return odkaz na tuto instanci
     */
    public Query from(String table, String prefix){ 
        query.append("FROM ");
        query.append(table);
        query.append(" ");
        query.append(prefix);
        query.append(" ");
        
        return this;
    }
    
    /**
     * Klíčové slovo JOIN.
     * 
     * @param table která tabulka se bude připojovat
     * @param prefix prefix připojované tabulky
     * @return odkaz na tuto instanci
     */
    public Query join(String table, String prefix) {
        query.append("JOIN ");
        query.append(table);
        query.append(" ");
        query.append(prefix);
        query.append(" ");
        
        return this;
    }
    
    /**
     * Klíčové slovo ON.
     * 
     * @param attribute1 atribut na levé straně
     * @param attribute2 atribut na pravé straně
     * @return odkaz na tuto instanci
     */
    public Query on(String attribute1, String attribute2) {
        query.append("ON ");
        query.append(attribute1);
        query.append("=");
        query.append(attribute2);
        
        return this;
    }
    
    /**
     * Klíčové slovo SET.
     * 
     * @param columns sloupc, které se budou nastavovat
     * @return odkaz na tuto instanci
     */
    public Query set(String[] columns){
        query.append("SET ");
        if(columns.length == 0) {
            throw new IllegalArgumentException("Neplatný počet parametrů");
        }
        
        for(String column : columns){
           query.append(column);
           query.append(" = ");
           query.append("?");
           query.append(",");
        }
        query.deleteCharAt(query.lastIndexOf(","));
        query.append(" ");
        return this;
    }
    
    /**
     * Klíčové slovo WHERE.
     * 
     * @param condition znění podmínky (místo proměnných vkládat znak otazníku ?)
     * @return odkaz na tuto instanci
     */
    public Query where(String condition) {
        query.append("WHERE ");
        query.append(condition);
        
        return this;
    }
    
    /**
     * Klíčové slovo VALUES.
     * 
     * @param params následující hodnoty se uloží do db.
     * @return odkaz na tuto instanci
     */
    public Query values(Object[] params){
        query.append(" VALUES(");

        int count = params.length;

        if(count == 0)
            throw new IllegalArgumentException("Neplatný počet parametrů");

        for (int i = 0; i<count; i++) {
            query.append("?,");
        }
        //odstaníme poslední čárku
        query.deleteCharAt(query.lastIndexOf(","));
        query.append(");");
        return this;
    }
    
    /**
     * Konec dotazu (řazení).
     * 
     * @param column řazení podle sloupce
     * @return odkaz na tuto instanci
     */
    public Query orderBy(String column) {
        query.append(" ORDER BY ");
        query.append(column);
        query.append(" ASC;");
        
        return this;
    }
    
    /**
     * Převede celý dotaz do stringové podoby.
     * 
     * @return výsledný řetězec
     */
    public String getQuery() {
        return query.toString();
    }
  
}

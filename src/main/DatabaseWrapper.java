/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import database.IDatabase;
import database.MySqlDatabase;
import database.SqliteDatabase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import models.Student;
import repositories.StudentRepository;

/**
 * Testovací třída
 * 
 * @author Eva Baščíková
 */
public class DatabaseWrapper {

    /**
     * Příklad použití 
     * 
     * Pozn.: Pro správné používání insertů je třeba VŽDY mít id na prvním místě!
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // vytvoření instance databázové třídy s její absolutní cestou
        //IDatabase db = new SqliteDatabase("jdbc:sqlite:C:\\Users\\User\\Desktop\\DB\\sampledb.db");
        //IDatabase db = new MySqlDatabase("jdbc:mysql://localhost:3306/students?user=root&password=root");
        StudentRepository rep = new StudentRepository();
        
        List<Student> asdf = rep.getAllStudents();
        
        asdf.stream().forEach((s) -> {
            System.out.println("hello " + s.getFirstName());
        });
        
        System.out.println(rep.getStudent(1).getFirstName());
        
        // všechny příkazy musí být uvozeny v try-catch
        //try {
            // příklad insert, update a delete operací
            //int i = db.insert("sample", new Object[]{db.freeId("sample"),"ahoj", null});
            //int i = db.update("sample", new String[] {"name"}, "id = ?", new Object[] {"Johnzinek", 1});         
            //int i = db.delete("sample", "id = ?", new Object[]{8});
            
            // příklad selectu
            //ResultSet rs = db.select("department_member", null);

            // příklad vypsání dat ze selectu nahoře
            //while (rs.next()) {
//                System.out.println(rs.getInt(1) + ", " + rs.getString(2));
//            }
//        } 
//        catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }

    }
    
    
}

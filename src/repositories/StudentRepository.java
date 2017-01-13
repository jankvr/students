/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import models.Helper;
import database.IDatabase;
import database.MySqlDatabase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Student;

/**
 *
 * @author User
 */
public class StudentRepository {
    
    
    private final IDatabase db;
    private final RepositoryHelper helper;

    public StudentRepository() {
        db = new MySqlDatabase(Helper.CONNECTION_STRING);
        helper = new RepositoryHelper();
    }
    
    public List<Student> getAllStudents() {
        try {
            List<Student> list = new ArrayList<>();
            ResultSet rs = db.select(Helper.STUDENT_TABLE, null);
            
            while (rs.next()) {
                list.add(helper.saveIntoStudent(rs));
            }
            
            return list;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return null;
    }
    
    public Student getStudent(int id) {
        try {
            Student student = new Student(id);
            ResultSet rs = db.select(Helper.STUDENT_TABLE, null, Helper.STUDENT_ID + " = ?", new Object[] { id });
            
            while (rs.next()) {
                student = helper.saveIntoStudent(rs);
            }
            
            return student;
            
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return null;
    }
    
    
    
}

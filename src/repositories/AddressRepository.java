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
import models.Address;
import models.Student;

/**
 *
 * @author User
 */
public class AddressRepository {
    
    private final IDatabase db;
    private final RepositoryHelper helper;

    public AddressRepository() {
        db = new MySqlDatabase(Helper.CONNECTION_STRING);
        helper = new RepositoryHelper();
    }
    
    public Address getStudentAddress(int id) {
        try {
            Address address = new Address(id);
            ResultSet rs = db.select(Helper.ADDRESS_TABLE, null, Helper.STUDENT_ID + " = ?", new Object[] { id });
            
            while (rs.next()) {
                address = helper.saveIntoAddress(rs);
            }
            
            return address;
            
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return null;
    }
    
}

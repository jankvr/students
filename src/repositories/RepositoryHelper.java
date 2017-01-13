/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import database.IDatabase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.*;
import models.enums.*;

/**
 *
 * @author User
 */
public class RepositoryHelper {

    //private final IDatabase db;
    
    public RepositoryHelper(){//IDatabase db) {
        //this.db = db;
    }
    
    //hotovo
    public Address saveIntoAddress(ResultSet rs) throws SQLException {
        Address address = new Address(rs.getInt("ID_ADDRESS"));
        
        address.setStreet(rs.getString("STREET"));
        address.setNumber(rs.getInt("NUMBER"));
        address.setZipCode(rs.getInt("ZIP"));
        address.setCity(rs.getString("CITY"));
        
        return address;
    }
    
    public DepartmentMember saveIntoDepartmentMember(ResultSet rs) throws SQLException {
        DepartmentMember member = new DepartmentMember(rs.getInt("ID_MEMBER"));
        
        member.setFirstName(rs.getString("FIRST_NAME"));
        member.setLastName(rs.getString("LAST_NAME"));
        member.setDepartment(rs.getString("DEPARTMENT"));
        
//        ResultSet relationshipRs = db.select("relationship", null, "ID_MEMBER = ?", new Object[] { member.getIdMember()});
//        
//        while (relationshipRs.next()) {
//            Student student = new Student(rs.getInt("ID_STUDENT"));
//        
//            student.setFirstName(rs.getString("FIRST_NAME"));
//            student.setLastName(rs.getString("LAST_NAME"));
//                
//            if (RoleType.valueOf(relationshipRs.getString("MEMBER_ROLE")) == RoleType.KONZULTANT) {
//                member.getConsultantList().add(student);
//            }
//            else {
//                member.getTrainerList().add(student);
//            }
//            
//        }
        
        return member;
    }
    
    //hotovo
    public ScienceGrant saveIntoScienceGrant(ResultSet rs) throws SQLException {
        ScienceGrant grant = new ScienceGrant(rs.getInt("ID_GRANT"));
        
        grant.setName(rs.getString("NAME"));
        grant.setValue(rs.getInt("VALUE"));
        
        return grant;
    }
    
    //hotovo
    public Student saveIntoStudent(ResultSet rs) throws SQLException {
        Student student = new Student(rs.getInt("ID_STUDENT"));
        
        student.setFirstName(rs.getString("FIRST_NAME"));
        student.setLastName(rs.getString("LAST_NAME"));
        student.setTitle(rs.getString("TITLE"));
        student.setXname(rs.getString("XNAME"));
        student.setBirthYear(rs.getInt("BIRTH_YEAR"));
        student.seteMail(rs.getString("E_MAIL"));
        student.setPhoneNumber(rs.getInt("PHONE_NUMBER"));
        student.setUniversity(rs.getString("UNIVERSITY"));

        return student;
    }
    
    //hotovo
    public Study saveIntoStudy(ResultSet rs) throws SQLException {
        try {
            Study study = new Study(rs.getInt("ID_STUDY"));
            DateFormat format = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
            
            study.setStartDate(format.parse(rs.getString("START_DATE")));
            study.setStudyType(StudyType.valueOf(rs.getString("TYPE")));
            
            study.setInterruptionFrom(format.parse(rs.getString("INTERRUPTION_FROM")));
            study.setInterruptionTo(format.parse(rs.getString("INTERRUPTION_TO")));

            return study;
        } catch (ParseException ex) {
            Logger.getLogger(RepositoryHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Thesis saveIntoThesis(ResultSet rs) throws SQLException {
        Thesis thesis = new Thesis(rs.getInt("ID_THESIS"));
        
        thesis.setTopic(rs.getString("TOPIC"));

        return thesis;
    }
    
    //hotovo
    public ThesisDefense saveIntoThesisDefense(ResultSet rs) throws SQLException {
        try {
            ThesisDefense defense = new ThesisDefense(rs.getInt("ID_DEFENSE"));
            
            defense.setRating(rs.getInt("RATING"));
            defense.setThesisDefenseType(ThesisDefenseType.valueOf(rs.getString("DEFENSE_TYPE")));
            DateFormat format = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
            defense.setDate(format.parse(rs.getString("DATE")));
            
            return defense;
        } catch (ParseException ex) {
            Logger.getLogger(RepositoryHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Student {
    
    private int idStudent;
    private String firstName;
    private String lastName;
    private String title;
    private String xname;
    private int birthYear;
    private String eMail;
    private int phoneNumber;
    private String university;
    private Thesis thesis;
    private Address address;
    private List<DepartmentMember> trainers;
    private List<DepartmentMember> consultants;
    private List<ScienceGrant> grants;

    public Student(int id) {
        idStudent = id;
        trainers = new ArrayList();
        consultants = new ArrayList();
        grants = new ArrayList();
    }

    public int getIdStudent() {
        return idStudent;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTitle() {
        return title;
    }

    public String getXname() {
        return xname;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String geteMail() {
        return eMail;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getUniversity() {
        return university;
    }

    public Address getAddress() {
        return address;
    }

    public List<DepartmentMember> getTrainers() {
        return trainers;
    }

    public List<DepartmentMember> getConsultants() {
        return consultants;
    }

    public List<ScienceGrant> getGrants() {
        return grants;
    }

    public Thesis getThesis() {
        return thesis;
    }

    public void setThesis(Thesis thesis) {
        this.thesis = thesis;
    }
    
    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setXname(String xname) {
        this.xname = xname;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setTrainers(List<DepartmentMember> trainers) {
        this.trainers = trainers;
    }

    public void setConsultants(List<DepartmentMember> consultants) {
        this.consultants = consultants;
    }

    public void setGrants(List<ScienceGrant> grants) {
        this.grants = grants;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + this.idStudent;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        return this.idStudent == other.idStudent;
    }
    
    
}

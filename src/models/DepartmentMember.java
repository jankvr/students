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
public class DepartmentMember {
    
    private int idMember;
    private String firstName;
    private String lastName;
    private String department;
    private List<Thesis> thesisList;
    private List<Student> trainerList;
    private List<Student> consultantList;

    public DepartmentMember(int id) {
        idMember = id;
        thesisList = new ArrayList();
        trainerList = new ArrayList();
        consultantList = new ArrayList();
    }

    public int getIdMember() {
        return idMember;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartment() {
        return department;
    }

    public List<Thesis> getThesisList() {
        return thesisList;
    }

    public List<Student> getTrainerList() {
        return trainerList;
    }

    public List<Student> getConsultantList() {
        return consultantList;
    }

    public void setIdMember(int idMember) {
        this.idMember = idMember;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setThesisDefenseList(List<Thesis> thesisList) {
        this.thesisList = thesisList;
    }

    public void setTrainerList(List<Student> trainerList) {
        this.trainerList = trainerList;
    }

    public void setConsultantList(List<Student> consultantList) {
        this.consultantList = consultantList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.idMember;
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
        final DepartmentMember other = (DepartmentMember) obj;
        if (this.idMember != other.idMember) {
            return false;
        }
        return true;
    }
    
    
    
}

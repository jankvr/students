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
public class ScienceGrant {
    private int idGrant;
    private String name;
    private int value;
    private List<Student> studentsList;

    public ScienceGrant(int id) {
        idGrant = id;
        studentsList = new ArrayList();
    }

    public int getIdGrant() {
        return idGrant;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public void setIdGrant(int idGrant) {
        this.idGrant = idGrant;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idGrant;
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
        final ScienceGrant other = (ScienceGrant) obj;
        if (this.idGrant != other.idGrant) {
            return false;
        }
        return true;
    }
    
    
}

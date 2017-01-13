/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import models.enums.ThesisDefenseType;
import java.util.Date;

/**
 *
 * @author User
 */
public class ThesisDefense {
    
    private int idDefense;
    private Date date;
    private ThesisDefenseType thesisDefenseType;
    private int rating;
    private Thesis thesis;
    private DepartmentMember member;
    
    public ThesisDefense(int id) {
        idDefense = id;
    }
    
    public int getIdDefense() {
        return idDefense;
    }

    public Date getDate() {
        return date;
    }

    public ThesisDefenseType getThesisDefenseType() {
        return thesisDefenseType;
    }

    public int getRating() {
        return rating;
    }

    public Thesis getThesis() {
        return thesis;
    }

    public DepartmentMember getMember() {
        return member;
    }

    public void setMember(DepartmentMember member) {
        this.member = member;
    }

    public void setThesis(Thesis thesis) {
        this.thesis = thesis;
    }
    
    public void setIdDefense(int idDefense) {
        this.idDefense = idDefense;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setThesisDefenseType(ThesisDefenseType thesisDefenseType) {
        this.thesisDefenseType = thesisDefenseType;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.idDefense;
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
        final ThesisDefense other = (ThesisDefense) obj;
        if (this.idDefense != other.idDefense) {
            return false;
        }
        return true;
    }
    
    
}

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
public class Thesis {
    private int idThesis;
    private String topic;
    private List<ThesisDefense> thesisDefenseList;

    public Thesis(int id) {
        idThesis = id;
        thesisDefenseList = new ArrayList();
    }

    public int getIdThesis() {
        return idThesis;
    }

    public String getTopic() {
        return topic;
    }

    public List<ThesisDefense> getThesisDefenseList() {
        return thesisDefenseList;
    }

    public void setIdThesis(int idThesis) {
        this.idThesis = idThesis;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setThesisDefenseList(List<ThesisDefense> thesisDefenseList) {
        this.thesisDefenseList = thesisDefenseList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.idThesis;
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
        final Thesis other = (Thesis) obj;
        if (this.idThesis != other.idThesis) {
            return false;
        }
        return true;
    }
    
    
}

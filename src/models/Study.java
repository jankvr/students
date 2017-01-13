/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import models.enums.StudyType;
import java.util.Date;

/**
 *
 * @author User
 */
public class Study {
    private int idStudy;
    private Date startDate;
    private Date interruptionFrom;
    private Date interruptionTo;
    private StudyType studyType;

    public Study(int id) {
        idStudy = id;
    }

    
    
    public int getIdStudy() {
        return idStudy;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getInterruptionFrom() {
        return interruptionFrom;
    }

    public Date getInterruptionTo() {
        return interruptionTo;
    }

    public StudyType getStudyType() {
        return studyType;
    }

    public void setIdStudy(int idStudy) {
        this.idStudy = idStudy;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setInterruptionFrom(Date interruptionFrom) {
        this.interruptionFrom = interruptionFrom;
    }

    public void setInterruptionTo(Date interruptionTo) {
        this.interruptionTo = interruptionTo;
    }

    public void setStudyType(StudyType studyType) {
        this.studyType = studyType;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.idStudy;
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
        final Study other = (Study) obj;
        if (this.idStudy != other.idStudy) {
            return false;
        }
        return true;
    }
    
    
}

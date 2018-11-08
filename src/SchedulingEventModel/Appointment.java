/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SchedulingEventModel;

import UserModel.Patient;
import UserModel.Address;
import UserModel.Physician;
import java.util.Date;

/**
 *
 * @author Group 3 - Jonathan Celestin, Cynthia Hilgeman, Karin Martin, and Christopher Morris
 */
public class Appointment {
    
    private Address office;
    private Patient patient;
    private String purposeOfVisitNotes;
    private Date date;
    private Physician physician;

    public Address getOffice() {
        return office;
    }

    public void setOffice(Address office) {
        this.office = office;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getPurposeOfVisitNotes() {
        return purposeOfVisitNotes;
    }

    public void setPurposeOfVisitNotes(String purposeOfVisitNotes) {
        this.purposeOfVisitNotes = purposeOfVisitNotes;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public Physician getPhysician() {
        return physician;
    }

    public void setPhysician(Physician physician) {
        this.physician = physician;
    }
}

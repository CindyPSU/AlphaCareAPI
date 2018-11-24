/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SchedulingEventModel;

import UserModel.Patient;
import UserModel.*;

/**
 *
 * @author chrismorris
 */
public class Visit {
    
    private Appointment appointment;
    private Patient patient;
    private Physician physician;
    private Nurse nurse;
    private Practice practice;

    public Visit(Appointment appointment, Patient patient, Physician physician, Nurse nurse, Practice practice) {
        this.appointment = appointment;
        this.patient = patient;
        this.physician = physician;
        this.nurse = nurse;
        this.practice = practice;
    }
    
    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Physician getPhysician() {
        return physician;
    }

    public void setPhysician(Physician physician) {
        this.physician = physician;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    public Practice getPractice() {
        return practice;
    }

    public void setPractice(Practice practice) {
        this.practice = practice;
    }
}

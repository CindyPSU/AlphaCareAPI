/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MedicalRecordModel;

import UserModel.Patient;

/**
 *
 * @author chrismorris
 */
public class PatientDetailModel {
    
    private final Patient patient;
    
    public PatientDetailModel(Patient patient) {
        this.patient = patient;
    }
    
    /**
     * @return the patient
     */
    public Patient getPatient() {
        return patient;
    }
    
    public void updatePatientRecord() {
        getPatient().setPreferredName("My New PreferredName");
    }
}

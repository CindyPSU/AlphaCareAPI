/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MedicalRecordModel;

/**
 *
 * @author chrismorris
 */
public class PatientDetailModel {
    
    private final PatientProfile patient;
    
    public PatientDetailModel(PatientProfile patient) {
        this.patient = patient;
    }
    
    /**
     * @return the patient
     */
    public PatientProfile getPatient() {
        return patient;
    }
    
    public void updatePatientRecord() {
        getPatient().setPatientPreferredName("My New PreferredName");
    }
}

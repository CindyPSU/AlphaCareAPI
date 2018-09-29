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
public class PatientDetailController {
    
    private final PatientProfile patient;
    private final PatientDetailControllerDelegate delegate;
    
    public PatientDetailController(PatientProfile patient, PatientDetailControllerDelegate delegate) {
        this.patient = patient;
        this.delegate = delegate;
    }
    
    /**
     * @return the patient
     */
    public PatientProfile getPatient() {
        return patient;
    }
    
    /**
     * @return the delegate
     */
    public PatientDetailControllerDelegate getDelegate() {
        return delegate;
    }
    
    void show() {
        System.out.println("Loading patient into the detail screen: " + getPatient());
    }
    
    // Public for the sake of TestHarness
    public void updateRecord() {
        PatientProfile patient = getPatient();
        patient.setPatientPreferredName("My New PreferredName");
        System.out.println("Updated the patients record. The preferred name changed to " + patient.getPatientPreferredName());
        getDelegate().patientDetailControllerDidUpdateRecord(this, patient);
    }
    
}

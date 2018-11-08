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
    
    private final PatientDetailModel model;
    private final PatientDetailControllerDelegate delegate;
    
    public PatientDetailController(PatientDetailModel model, PatientDetailControllerDelegate delegate) {
        this.model = model;
        this.delegate = delegate;
    }
    
    /**
     * @return the model
     */
    public PatientDetailModel getModel() {
        return model;
    }
    
    /**
     * @return the delegate
     */
    public PatientDetailControllerDelegate getDelegate() {
        return delegate;
    }
    
    void show() {
        System.out.println("Loading patient into the detail screen: " + getModel().getPatient());
    }
    
    // Public for the sake of TestHarness
    public void updateRecord() {
        getModel().updatePatientRecord();
        System.out.println("Updated the patients record. The preferred name changed to " + getModel().getPatient().getPreferredName());
        getDelegate().patientDetailControllerDidUpdateRecord(this, getModel());
    }
    
}

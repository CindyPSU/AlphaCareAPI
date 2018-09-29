/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MedicalRecordModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author chrismorris
 */
public class PatientListController implements PatientDetailControllerDelegate {
    
    private ArrayList<PatientProfile> patients;
    
    /**
     * @return the patients
     */
    public ArrayList<PatientProfile> getPatients() {
        return patients;
    }
    
    public void show() {
        loadPatients();
        System.out.println("Showing patient list with patients: " + getPatients());
    }
    
    // Made public for the sake of TestHarness
    public PatientDetailController selectPatient() {
        PatientProfile patient = getPatients().get(1);
        System.out.println("Selected patient named: " + patient.getPatientFirstName());
        PatientDetailController controller = new PatientDetailController(patient, this);
        controller.show();
        return controller;
    }
    
    public void closeDetailController() {
        System.out.println("Closing patient detail controller");
    }
    
    private void loadPatients() {
        patients = new ArrayList();
        PatientProfile patient = new PatientProfile(
                "123456789", 
                "Marty",
                "McFly", 
                "CK", 
                "Marty", 
                new SimpleDateFormat(), 
                "5556778", 
                "9303 Roslyndale Ave, Pacoima, CA 91331", 
                "bttf@gmail.com"
        );
        getPatients().add(patient);
        getPatients().add(patient);
        getPatients().add(patient);
    }

    @Override
    public void patientDetailControllerDidUpdateRecord(PatientDetailController controller, PatientProfile updatedProfile) {
        System.out.println("The Patient detail screen communicated its "
                + "completion back to the list screen with an updated profile.");
        closeDetailController();
    }
}

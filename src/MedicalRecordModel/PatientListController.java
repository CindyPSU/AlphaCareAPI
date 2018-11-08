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
public class PatientListController implements PatientDetailControllerDelegate {
    
    private final PatientListModel model = new PatientListModel();
    
    public void show() {
        model.loadPatients();
        System.out.println("Showing patient list with patients: " + model.getPatients());
    }
    
    // Made public for the sake of TestHarness
    public PatientDetailController selectPatient() {
        Patient patient = model.getPatients().get(1);
        System.out.println("Selected patient named: " + patient.getFirstName());
        PatientDetailController controller = new PatientDetailController(
                new PatientDetailModel(patient), 
                this
        );
        controller.show();
        return controller;
    }
    
    public void closeDetailController() {
        System.out.println("Closing patient detail controller");
    }

    @Override
    public void patientDetailControllerDidUpdateRecord(PatientDetailController controller, PatientDetailModel model) {
        System.out.println("The Patient detail screen communicated its "
                + "completion back to the list screen with an updated profile.");
        closeDetailController();
    }
}

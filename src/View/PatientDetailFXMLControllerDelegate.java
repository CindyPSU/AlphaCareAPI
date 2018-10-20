/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import MedicalRecordModel.PatientProfile;
import javafx.stage.Stage;

/**
 *
 * @author chrismorris
 */
public interface PatientDetailFXMLControllerDelegate {
    void patientDetailFXMLControllerDidSavePatientProfile(PatientDetailFXMLController controller, Stage stage, PatientProfile profile);
}

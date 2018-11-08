/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import MedicalRecordModel.PatientDetailController;
import MedicalRecordModel.PatientDetailControllerDelegate;
import MedicalRecordModel.PatientDetailModel;
import MedicalRecordModel.PatientStoreStub;
import UserModel.Patient;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Princess_ktwo
 */
public class DashboardFXMLController implements Initializable, PatientDetailFXMLControllerDelegate {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    public void displayPatientSearchView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PatientMasterListDetailFXML.fxml"));
            Parent root = loader.load();
            PatientMasterListDetailFXMLController controller = loader.<PatientMasterListDetailFXMLController>getController();
            controller.load(new PatientStoreStub());
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException error) {
            System.out.println(error);
        }
    }
    
    public void displayCreateNewPatientView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PatientDetailFXML.fxml"));
            Parent root = loader.load();
            PatientDetailFXMLController controller = loader.<PatientDetailFXMLController>getController();
            controller.setContext(new PatientDetailFXMLControllerContextCreate());
            controller.setDelegate(this);
            controller.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException error) {
            System.out.println(error);
        }
    }
    
    public void displayAppointmentCalendar(){
        
    }
    
    public void displayInternalMessageView(){
        
    }
    
    public void displayLoginView(){
        
    }
    
    // PatientDetailFXMLControllerDelegate

    @Override
    public void patientDetailFXMLControllerDidSavePatientProfile(PatientDetailFXMLController controller, Stage stage, Patient profile) {
        PatientStoreStub.savedPatients.add(profile);
        stage.close();
        displayPatientSearchView();
    }
    
}

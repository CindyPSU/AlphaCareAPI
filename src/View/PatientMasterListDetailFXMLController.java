/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import MedicalRecordModel.PatientStoreStub;
import UserModel.Patient;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import MedicalRecordModel.PatientStore;

/**
 * FXML Controller class
 *
 * @author chrismorris
 */
public class PatientMasterListDetailFXMLController implements Initializable, PatientDetailFXMLControllerDelegate, PatientListXMLControllerDelegate {
    
    @FXML private GridPane root;
    
    private PatientListXMLController listController;
    private PatientDetailFXMLController detailController;
    private PatientStore patientLoader;
    
    /**
     * @return the root
     */
    public GridPane getRoot() {
        return root;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void load(PatientStore patientLoader) {
        this.patientLoader = patientLoader;
        loadList(patientLoader);
        loadDetail();
    }
    
    private void loadList(PatientStore patientLoader) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PatientListXML.fxml"));
            Parent root = loader.load();
            PatientListXMLController controller = loader.<PatientListXMLController>getController();
            controller.setPatientLoader(patientLoader);
            controller.setDelegate(this);
            controller.load();
            listController = controller;
            getRoot().add(root, 0, 0);
        } catch (IOException error) {
            System.out.println(error);
        }
    }
    
    private void loadDetail() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PatientDetailFXML.fxml"));
            Parent root = loader.load();
            PatientDetailFXMLController controller = loader.<PatientDetailFXMLController>getController();
            controller.setContext(new PatientDetailFXMLControllerContextCreate());
            controller.setDelegate(this);
            controller.load();
            detailController = controller;
            getRoot().add(root, 1, 0);
        } catch (IOException error) {
            System.out.println(error);
        }
    }

    @Override
    public void patientDetailFXMLControllerDidSavePatientProfile(PatientDetailFXMLController controller, Stage stage, Patient profile) {
        patientLoader.updatePatient(profile);
        listController.load();
    }

    @Override
    public void patientListXMLControllerDidSelectPatient(Patient profile) {
        detailController.setContext(new PatientDetailFXMLControllerContextEdit(profile));
    }

}

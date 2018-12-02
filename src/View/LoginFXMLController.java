/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DBModel.SQLite_PatientProfile;
import UserModel.Patient;
import MedicalRecordModel.PatientStoreStub;
import UserModel.InvalidCredentialsException;
import UserModel.MedicalAdministrator;
import UserModel.User;
import UserModel.UserLoginController;
import UserModel.UserLoginCredentials;
import alphacareapi.AlphaCareAPI;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author chrismorris
 */
public class LoginFXMLController implements Initializable {
    
    @FXML private TextField username;
    @FXML private PasswordField password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        username.setText("Patient");
        password.setText("IST412FTW");
    }    
    
    @FXML 
    protected void didSelectLogin(ActionEvent event) {
        UserLoginController controller = new UserLoginController();
        String usernameText = username.getText();
        UserLoginCredentials credentials = new UserLoginCredentials(usernameText, password.getText());
        try {
            User user = controller.login(credentials);
            if (user.getClass().equals(MedicalAdministrator.class)) {
                PatientStoreStub.initiate();
                showDashboard();
            } else if (user.getClass().equals(Patient.class)) {
//                showPatientDetail(usernameText);
                showPatientDashboard();
            }
        } catch (Exception ex) {
            Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void showDashboard() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/DashboardFXML.fxml"));
        AlphaCareAPI.stage.setScene(new Scene(root));
    }
    
    private void showPatientDashboard() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/PatientDashboardFXML.fxml"));
        AlphaCareAPI.stage.setScene(new Scene(root));
    }
    
    private void showPatientDetail(String username) {
        List<Patient> patients = SQLite_PatientProfile.loadPatients().stream().filter((p) -> p.getFirstName().equals("Jonathan")).collect(Collectors.toList());
        if (patients.size() != 1) {
            return;
        }
        Patient patient = patients.get(0);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CompleteMedicalRecordFXML.fxml"));
            Parent root = loader.load();
            CompleteMedicalRecordFXMLController controller = loader.<CompleteMedicalRecordFXMLController>getController();
            patient.refreshData();
            controller.setProfile(patient);
            
            Stage stage = new Stage();
            controller.setStage(stage);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException error) {
            System.out.println(error);
        }
    }

}

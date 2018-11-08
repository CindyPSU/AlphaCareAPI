/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import UserModel.Patient;
import MedicalRecordModel.PatientStoreStub;
import UserModel.InvalidCredentialsException;
import UserModel.MedicalAdministrator;
import UserModel.UserLoginController;
import UserModel.UserLoginCredentials;
import alphacareapi.AlphaCareAPI;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

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
        username.setText("MedicalAdministrator");
        password.setText("IST412FTW");
    }    
    
    @FXML 
    protected void didSelectLogin(ActionEvent event) {
        UserLoginController<MedicalAdministrator> controller = new UserLoginController();
        UserLoginCredentials credentials = new UserLoginCredentials(username.getText(), password.getText());
        try {
            MedicalAdministrator user = controller.login(credentials, MedicalAdministrator.class);
            showDashboard();
            PatientStoreStub.initiate();
        } catch (Exception ex) {
            Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void showDashboard() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/DashboardFXML.fxml"));
        AlphaCareAPI.stage.setScene(new Scene(root));
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DBModel.SQLite_PatientProfile;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import UserModel.Patient;
import java.util.List;
import java.util.stream.Collectors;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author JCELE
 */
public class PatientDashboardFXMLController implements Initializable
{
    @FXML TextField welcomeTxt;
    @FXML SplitPane splitPane;
    @FXML AnchorPane rightAnchor;
    @FXML Pane profilePane,medicalHistoryPane, immunizationPane,
                prescriptionPane, appointmentPane, vitalsPane, labResultPane;
    
    String patientID;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
        
      patientID = "111223336";
        List<Patient> patientq = SQLite_PatientProfile.loadPatients().stream().filter((p) -> p.getIdentifier().equals(patientID)).collect(Collectors.toList());
        welcomeTxt.setText("Welcome, " + patientq.get(0).getFirstName() );
        splitPane.getItems().set(1, profilePane);
    }    
    
    
//    public void changeDisplay(ActionEvent event) throws IOException{
//        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/test.fxml")); 
//        splitPane.getItems().set(1, pane); }
    
    @FXML 
    protected void showProfile(ActionEvent event) {
        System.out.println("Profile");
        splitPane.getItems().set(1, profilePane);
    }
    
     @FXML 
    protected void showMedicalHistory(ActionEvent event) {
         System.out.println("Medical History");
         splitPane.getItems().set(1, medicalHistoryPane);
    }
    
     @FXML 
    protected void showImmunization(ActionEvent event) {
        splitPane.getItems().set(1, immunizationPane);
        
    }
    
     @FXML 
    protected void showPrescription(ActionEvent event) {
        splitPane.getItems().set(1, prescriptionPane);
    }
    
     @FXML 
    protected void showAppointment(ActionEvent event) {
        splitPane.getItems().set(1, appointmentPane);
    }
    
     @FXML 
    protected void showVitals(ActionEvent event) {
        splitPane.getItems().set(1, vitalsPane);
    }
    
     @FXML 
    protected void showLabResult(ActionEvent event) {
        splitPane.getItems().set(1, labResultPane);
    }
    

    
    
}

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
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author JCELE
 */
public class PatientDashboardFXMLController implements Initializable
{
    @FXML TextField welcomeTxt;
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
        
    }    
    
    
//    public void changeDisplay(ActionEvent event) throws IOException{
//        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/test.fxml")); 
//        splitPane.getItems().set(1, pane); }
    
    @FXML 
    protected void showProfile(ActionEvent event) {
        System.out.println("Profile");
        
    }
    
     @FXML 
    protected void showMedicalHistory(ActionEvent event) {
        
    }
    
     @FXML 
    protected void showImmunization(ActionEvent event) {
        
    }
    
     @FXML 
    protected void showPrescription(ActionEvent event) {
        
    }
    
     @FXML 
    protected void showAppointment(ActionEvent event) {
        
    }
    
     @FXML 
    protected void showVitals(ActionEvent event) {
        
    }
    
     @FXML 
    protected void showLabResult(ActionEvent event) {
        
    }
    
    private void getPatientInfo(String patientID) {
        List<Patient> patients = SQLite_PatientProfile.loadPatients().stream().filter((p) -> p.getFirstName().equals("Jonathan")).collect(Collectors.toList());
        if (patients.size() != 1) {
            return;
        }
        Patient patient = patients.get(0);
        
    }
    
    
}

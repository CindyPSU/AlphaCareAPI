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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
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
    @FXML ScrollPane profilePane,medicalHistoryPane, immunizationPane,
                prescriptionPane, appointmentPane, vitalsPane, labResultPane;
        @FXML
    private TextField patientID;
    @FXML
    private TextField patient_first_name;
    @FXML
    private TextField patient_last_name;
    @FXML
    private TextField patient_middle_initial;
    @FXML
    private TextField patient_preferred_name;
    @FXML
    private TextField patient_home_address;
    @FXML
    private TextField patient_phone_number;
    @FXML
    private TextField patient_email;
    @FXML
    private DatePicker patient_dob;
    @FXML
    private Label patient_contact;
    
    
    String pID = "111223336";
    List<Patient> patientq = SQLite_PatientProfile.loadPatients().stream().filter((p) -> p.getIdentifier().equals(pID)).collect(Collectors.toList());
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
        
     loadPatient();
        
        welcomeTxt.setText("Welcome, " + patientq.get(0).getFirstName() );
        splitPane.getItems().set(1, profilePane);
    }    
    

    
        public void loadPatient(){
        // Load Patient Profile Data
        this.patientID.setText(patientq.get(0).getIdentifier());
        
        if(this.patientq.get(0).getIdentifier() != null)
        {
            this.patientID.setDisable(true);
        }

        this.patient_dob.setValue(patientq.get(0).getBirthdate());
        this.patient_first_name.setText(patientq.get(0).getFirstName());
        this.patient_last_name.setText(patientq.get(0).getLastName());
        this.patient_middle_initial.setText(patientq.get(0).getMiddleInitial());
        this.patient_preferred_name.setText(patientq.get(0).getPreferredName());
        this.patient_home_address.setText(patientq.get(0).getAddress());
        this.patient_phone_number.setText(patientq.get(0).getPhoneNumber());
        this.patient_email.setText(patientq.get(0).getEmail());
        
                
//        // Load Appointment History Data
//        loadAppointmentHistories();
//        
//        // Load Immunization History Data
//        loadImmunizationHistories();
//        
//        // Load Medical Histories
//        loadMedicalHistories();
//        
//        // Load Prescription Histories
//        loadPrescriptionHistories();
//        
//        this.loadTestLabResults();
//        this.loadVitalSigns();
//        
//        if (getDashboardController() == null) {
//            return_to_dashboard.setText("Logout");
//            save_all.setVisible(false);
//        }
    }
    
    
    
    
    
    
    
    
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

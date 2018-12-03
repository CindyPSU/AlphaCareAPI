/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DBModel.SQLite_PatientProfile;
import MedicalRecordModel.AppointmentHistory;
import MedicalRecordModel.ImmunizationHistory;
import MedicalRecordModel.MedicalHistory;
import MedicalRecordModel.PrescriptionHistory;
import MedicalRecordModel.TestLabResults;
import MedicalRecordModel.VitalSigns;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import UserModel.Patient;
import alphacareapi.AlphaCareAPI;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

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
    private TextField patientID, patient_first_name,
                      patient_last_name, patient_middle_initial,
                      patient_preferred_name, patient_home_address,
                      patient_phone_number, patient_email;
    @FXML
    private DatePicker patient_dob;
    @FXML
    private Label patient_contact;
    
    @FXML
    private Button saveBttn, editBttn, cancelBttn;
    
      @FXML
    private VBox appointmentHistories1;    
    private ArrayList<AppointmentHistoryFXMLController> appointmentHistoryControllers;
    private int appointmentRows = 5;
    
    @FXML
    private VBox immunizationHistories1;
    private ArrayList<ImmunizationHistoryFXMLController> immunizationHistoryControllers;
    private int immunizationHistoryRows = 5;

    @FXML
    private VBox medicalHistories1;
    private ArrayList<MedicalHistoryFXMLController> medicalHistoryControllers;
    private int medicalHistoryRows = 5;

    @FXML
    private VBox prescriptionHistories1;
    private ArrayList<PrescriptionHistoryFXMLController> prescriptionHistoryControllers;
    private int prescriptionHistoryRows = 5;

    @FXML
    private VBox labResults1;
    private ArrayList<TestLabResultsFXMLController> testLabResultsControllers;
    private int testLabResultsRows = 5;

    @FXML
    private VBox vitalSigns1;
    private ArrayList<VitalSignsFXMLController> vitalSignsControllers;
    private int vitalSignsRows = 5;
    
    
    String pID = "111223336";
    List<Patient> patientq = SQLite_PatientProfile.loadPatients().stream().filter((p) -> p.getIdentifier().equals(pID)).collect(Collectors.toList());
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
     welcomeTxt.setText("Welcome, " + patientq.get(0).getFirstName() );
     splitPane.getItems().set(1, profilePane);
     
       try
        {
        // Initialize Medical History Rows
            medicalHistoryControllers = new ArrayList<>();
            for(int i = 0; i < medicalHistoryRows; i++)
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("MedicalHistoryFXML.fxml"));
                Parent root = loader.load();
                MedicalHistoryFXMLController controller = loader.<MedicalHistoryFXMLController>getController();
                medicalHistoryControllers.add(controller);
                medicalHistories1.getChildren().add(root);
            }
     
            
            // Initialize Immunization History Rows
            immunizationHistoryControllers = new ArrayList<>();
            for(int i = 0; i < immunizationHistoryRows; i++)
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ImmunizationHistoryFXML.fxml"));
                Parent root = loader.load();
                ImmunizationHistoryFXMLController controller = loader.<ImmunizationHistoryFXMLController>getController();
                immunizationHistoryControllers.add(controller);
                immunizationHistories1.getChildren().add(root);
            }
            
            
             // Initialize Prescription History Rows
            prescriptionHistoryControllers = new ArrayList<>();
            for(int i = 0; i < prescriptionHistoryRows; i++)
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("PrescriptionHistoryFXML.fxml"));
                Parent root = loader.load();
                PrescriptionHistoryFXMLController controller = loader.<PrescriptionHistoryFXMLController>getController();
                prescriptionHistoryControllers.add(controller);
                prescriptionHistories1.getChildren().add(root);
            }
            
            // Initialize Appointment History Rows
            appointmentHistoryControllers = new ArrayList<>();
            for(int i = 0; i < appointmentRows; i++)
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AppointmentHistoryFXML.fxml"));
                Parent root = loader.load();
                AppointmentHistoryFXMLController controller = loader.<AppointmentHistoryFXMLController>getController();
                appointmentHistoryControllers.add(controller);
                appointmentHistories1.getChildren().add(root);
            }   
            
            
             // Initialize Vital Signs Rows
            vitalSignsControllers = new ArrayList<>();
            for(int i = 0; i < vitalSignsRows; i++)
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("VitalSignsFXML.fxml"));
                Parent root = loader.load();
                VitalSignsFXMLController controller = loader.<VitalSignsFXMLController>getController();
                vitalSignsControllers.add(controller);
                vitalSigns1.getChildren().add(root);
            }
            
             // Initialize Test Lab Results Rows
            testLabResultsControllers = new ArrayList<>();
            for(int i = 0; i < testLabResultsRows; i++)
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("TestLabResultsFXML.fxml"));
                Parent root = loader.load();
                TestLabResultsFXMLController controller = loader.<TestLabResultsFXMLController>getController();
                testLabResultsControllers.add(controller);
                labResults1.getChildren().add(root);
            }
            
             } catch (IOException error) {
            error.printStackTrace();
        }
    
        
         loadPatient();
        
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
        
                
        // Load Appointment History Data
        loadAppointmentHistories();
        
        // Load Immunization History Data
        loadImmunizationHistories();
        
        // Load Medical Histories
        loadMedicalHistories();
        
        // Load Prescription Histories
        loadPrescriptionHistories();
        
        this.loadTestLabResults();
        this.loadVitalSigns();

    }
    
    
    
     private void loadMedicalHistories()
    {
        
        for(int counter = 0; counter < medicalHistoryControllers.size(); counter++)
        {
          // Ensure the profile is initialized with the objects
          while(this.patientq.get(0).medicalData.size() < (counter + 1))
          {
              
              MedicalHistory entry = new MedicalHistory();
              entry.setPatient(this.patientq.get(0));
              this.patientq.get(0).medicalData.add(entry);
          }

          // Get the controller for the row
          MedicalHistoryFXMLController controller = medicalHistoryControllers.get(counter);

          // Load the entry into the controller (which will load up the view)
          controller.load(this.patientq.get(0).medicalData.get(counter));
            
            
        }           
    }
    
     
      private void loadImmunizationHistories()
    {
        for(int counter = 0; counter < immunizationHistoryControllers.size(); counter++)
        {
          // Ensure the profile is initialized with the objects
          while(this.patientq.get(0).immunizations.size() < (counter + 1))
          {
              ImmunizationHistory entry = new ImmunizationHistory();
              entry.setPatient(this.patientq.get(0));
              this.patientq.get(0).immunizations.add(entry);
          }

          // Get the controller for the row
          ImmunizationHistoryFXMLController controller = immunizationHistoryControllers.get(counter);

          // Load the entry into the controller (which will load up the view)
          controller.load(this.patientq.get(0).immunizations.get(counter));
        }           
    }
    
    
          private void loadPrescriptionHistories()
    {
        for(int counter = 0; counter < prescriptionHistoryControllers.size(); counter++)
        {
          // Ensure the profile is initialized with the objects
          while(this.patientq.get(0).prescriptions.size() < (counter + 1))
          {
              PrescriptionHistory entry = new PrescriptionHistory();
              entry.setPatient(this.patientq.get(0));
              this.patientq.get(0).prescriptions.add(entry);
          }

          // Get the controller for the row
          PrescriptionHistoryFXMLController controller = prescriptionHistoryControllers.get(counter);

          // Load the entry into the controller (which will load up the view)
          controller.load(this.patientq.get(0).prescriptions.get(counter));
        }           
    }
      
      
          private void loadAppointmentHistories()
    {
        for(int ahCounter = 0; ahCounter < appointmentHistoryControllers.size(); ahCounter++)
        {
          // Ensure the profile is initialized with the appointment history objects
          while(this.patientq.get(0).appointments.size() < (ahCounter + 1))
          {
              AppointmentHistory ahEntry = new AppointmentHistory();
              ahEntry.setPatient(this.patientq.get(0));
              this.patientq.get(0).appointments.add(ahEntry);
          }

          // Get the controller for the row
          AppointmentHistoryFXMLController ahController = appointmentHistoryControllers.get(ahCounter);

          // Load the appointment history entry into the controller (which will load up the view)
          ahController.load(this.patientq.get(0).appointments.get(ahCounter));
        }
    }
          
          
           private void loadVitalSigns()
    {
        for(int counter = 0; counter < this.vitalSignsControllers.size(); counter++)
        {
          // Ensure the profile is initialized with the objects
          while(this.patientq.get(0).vitalSignsData.size() < (counter + 1))
          {
              VitalSigns entry = new VitalSigns();
              entry.setPatient(this.patientq.get(0));
              this.patientq.get(0).vitalSignsData.add(entry);
          }

          // Get the controller for the row
          VitalSignsFXMLController controller = vitalSignsControllers.get(counter);

          // Load the entry into the controller (which will load up the view)
          controller.load(this.patientq.get(0).vitalSignsData.get(counter));
        }           
    }
           
           
               private void loadTestLabResults()
    {
        for(int counter = 0; counter < this.testLabResultsControllers.size(); counter++)
        {
          // Ensure the profile is initialized with the objects
          while(this.patientq.get(0).labResults.size() < (counter + 1))
          {
              TestLabResults entry = new TestLabResults();
              entry.setPatient(this.patientq.get(0));
              this.patientq.get(0).labResults.add(entry);
          }

          // Get the controller for the row
          TestLabResultsFXMLController controller = testLabResultsControllers.get(counter);

          // Load the entry into the controller (which will load up the view)
          controller.load(this.patientq.get(0).labResults.get(counter));
        }           
    }
      
      
      
    
    @FXML 
    protected void showProfile(ActionEvent event) {
        splitPane.getItems().set(1, profilePane);
    }
    
     @FXML 
    protected void showMedicalHistory(ActionEvent event) {
         splitPane.getItems().set(1, medicalHistoryPane);
          loadMedicalHistories();
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
    

    @FXML
    public void displayLoginView() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/LoginFXML.fxml"));
        AlphaCareAPI.stage.setScene(new Scene(root));
    }
    
    
    @FXML
    public void didPressEdit(ActionEvent event) {
    patient_first_name.setEditable(true);
    patient_last_name.setEditable(true);
    patient_middle_initial.setEditable(true);
    patient_preferred_name.setEditable(true);
    patient_home_address.setEditable(true);
    patient_phone_number.setEditable(true);
    patient_email.setEditable(true);
    patient_dob.setEditable(true);
    saveBttn.setVisible(true);
    cancelBttn.setVisible(true);
    editBttn.setVisible(false);
    }
    
      @FXML
    public void didPressSave(ActionEvent event) {
    
    
    patient_first_name.setEditable(false);
    patient_last_name.setEditable(false);
    patient_middle_initial.setEditable(false);
    patient_preferred_name.setEditable(false);
    patient_home_address.setEditable(false);
    patient_phone_number.setEditable(false);
    patient_email.setEditable(false);
    patient_dob.setEditable(false);
    saveBttn.setVisible(false);
    cancelBttn.setVisible(false);
    editBttn.setVisible(true);
        
    }
    
      @FXML
    public void didPressCancel(ActionEvent event) {
        patient_first_name.setEditable(false);
    patient_last_name.setEditable(false);
    patient_middle_initial.setEditable(false);
    patient_preferred_name.setEditable(false);
    patient_home_address.setEditable(false);
    patient_phone_number.setEditable(false);
    patient_email.setEditable(false);
    patient_dob.setEditable(false);
    saveBttn.setVisible(false);
    cancelBttn.setVisible(false);
    editBttn.setVisible(true);
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DBModel.*;
import MedicalRecordModel.*;
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
    private Label patient_contact, headerLabel, welcomeTxt, welcomeLabel;
    
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
    
     private Patient profile;
    
    String pID = "111223333";
    List<Patient> patientq = SQLite_PatientProfile.loadPatients().stream().filter((p) -> p.getIdentifier().equals(pID)).collect(Collectors.toList());
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
        
        
     welcomeTxt.setText("Hello, " + patientq.get(0).getFirstName() + "   ");
     profile = patientq.get(0);
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
        this.patientID.setText(profile.getIdentifier());
        
        if(this.profile.getIdentifier() != null)
        {
            this.patientID.setDisable(true);
        }

        this.patient_dob.setValue(profile.getBirthdate());
        this.patient_first_name.setText(profile.getFirstName());
        this.patient_last_name.setText(profile.getLastName());
        this.patient_middle_initial.setText(profile.getMiddleInitial());
        this.patient_preferred_name.setText(profile.getPreferredName());
        this.patient_home_address.setText(profile.getAddress());
        this.patient_phone_number.setText(profile.getPhoneNumber());
        this.patient_email.setText(profile.getEmail());
      //  SQLite_MedicalHistory.initializeTable();
        SQLite_MedicalHistory.loadPatientData(profile);
        SQLite_AppointmentHistory.loadPatientData(profile);
        SQLite_ImmunizationHistory.loadPatientData(profile);
        SQLite_PrescriptionHistory.loadPatientData(profile);
        SQLite_TestLabResults.loadPatientData(profile);
        SQLite_VitalSigns.loadPatientData(profile);
                
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
          while(this.profile.medicalData.size() < (counter + 1))
          {
              MedicalHistory entry = new MedicalHistory();
              entry.setPatient(this.profile);
              this.profile.medicalData.add(entry);
          }

          // Get the controller for the row
          MedicalHistoryFXMLController controller = medicalHistoryControllers.get(counter);

          // Load the entry into the controller (which will load up the view)
          controller.load(this.profile.medicalData.get(counter));
        }            
    }
    
     
      private void loadImmunizationHistories()
    {
        for(int counter = 0; counter < immunizationHistoryControllers.size(); counter++)
        {
          // Ensure the profile is initialized with the objects
          while(this.profile.immunizations.size() < (counter + 1))
          {
              ImmunizationHistory entry = new ImmunizationHistory();
              entry.setPatient(this.profile);
              this.profile.immunizations.add(entry);
          }

          // Get the controller for the row
          ImmunizationHistoryFXMLController controller = immunizationHistoryControllers.get(counter);

          // Load the entry into the controller (which will load up the view)
          controller.load(this.profile.immunizations.get(counter));
        }             
    }
    
    
          private void loadPrescriptionHistories()
    {
        for(int counter = 0; counter < prescriptionHistoryControllers.size(); counter++)
        {
          // Ensure the profile is initialized with the objects
          while(this.profile.prescriptions.size() < (counter + 1))
          {
              PrescriptionHistory entry = new PrescriptionHistory();
              entry.setPatient(this.profile);
              this.profile.prescriptions.add(entry);
          }

          // Get the controller for the row
          PrescriptionHistoryFXMLController controller = prescriptionHistoryControllers.get(counter);

          // Load the entry into the controller (which will load up the view)
          controller.load(this.profile.prescriptions.get(counter));
        }              
    }
      
      
          private void loadAppointmentHistories()
    {
         for(int ahCounter = 0; ahCounter < appointmentHistoryControllers.size(); ahCounter++)
        {
          // Ensure the profile is initialized with the appointment history objects
          while(this.profile.appointments.size() < (ahCounter + 1))
          {
              AppointmentHistory ahEntry = new AppointmentHistory();
              ahEntry.setPatient(this.profile);
              this.profile.appointments.add(ahEntry);
          }

          // Get the controller for the row
          AppointmentHistoryFXMLController ahController = appointmentHistoryControllers.get(ahCounter);

          // Load the appointment history entry into the controller (which will load up the view)
          ahController.load(this.profile.appointments.get(ahCounter));
        }
    }
          
          
           private void loadVitalSigns()
    {
          for(int counter = 0; counter < this.vitalSignsControllers.size(); counter++)
        {
          // Ensure the profile is initialized with the objects
          while(this.profile.vitalSignsData.size() < (counter + 1))
          {
              VitalSigns entry = new VitalSigns();
              entry.setPatient(this.profile);
              this.profile.vitalSignsData.add(entry);
          }

          // Get the controller for the row
          VitalSignsFXMLController controller = vitalSignsControllers.get(counter);

          // Load the entry into the controller (which will load up the view)
          controller.load(this.profile.vitalSignsData.get(counter));
        }     
    }
           
           
               private void loadTestLabResults()
    {
       for(int counter = 0; counter < this.testLabResultsControllers.size(); counter++)
        {
          // Ensure the profile is initialized with the objects
          while(this.profile.labResults.size() < (counter + 1))
          {
              TestLabResults entry = new TestLabResults();
              entry.setPatient(this.profile);
              this.profile.labResults.add(entry);
          }

          // Get the controller for the row
          TestLabResultsFXMLController controller = testLabResultsControllers.get(counter);

          // Load the entry into the controller (which will load up the view)
          controller.load(this.profile.labResults.get(counter));
        }           
    }
      
      
      
    
    @FXML 
    protected void showProfile(ActionEvent event) {
        splitPane.getItems().set(1, profilePane);
        headerLabel.setText("My Profile");
        welcomeLabel.setVisible(false);
    }
    
     @FXML 
    protected void showMedicalHistory(ActionEvent event) {
         splitPane.getItems().set(1, medicalHistoryPane);
         headerLabel.setText("Medical History");
         welcomeLabel.setVisible(false);
    }
    
     @FXML 
    protected void showImmunization(ActionEvent event) {
        splitPane.getItems().set(1, immunizationPane);
        headerLabel.setText("Immunization History");
        welcomeLabel.setVisible(false);
    }
    
     @FXML 
    protected void showPrescription(ActionEvent event) {
        splitPane.getItems().set(1, prescriptionPane);
        headerLabel.setText("Prescription History");
        welcomeLabel.setVisible(false);
    }
    
     @FXML 
    protected void showAppointment(ActionEvent event) {
        splitPane.getItems().set(1, appointmentPane);
        headerLabel.setText("Appointment History");
        welcomeLabel.setVisible(false);
    }
    
     @FXML 
    protected void showVitals(ActionEvent event) {
        splitPane.getItems().set(1, vitalsPane);
        headerLabel.setText("Vital Signs");
        welcomeLabel.setVisible(false);
    }
    
     @FXML 
    protected void showLabResult(ActionEvent event) {
        splitPane.getItems().set(1, labResultPane);
        headerLabel.setText("Lab Results");
        welcomeLabel.setVisible(false);
    }
    

    @FXML
    public void displayLoginView() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/LoginFXML.fxml"));
        AlphaCareAPI.stage.setScene(new Scene(root));
    }
    
    
    @FXML
    public void didPressEdit(ActionEvent event) {
    setProfile(patientq.get(0));
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
    
     if(this.profile.getIdentifier() == null)
        {
            this.profile.setIdentifier(this.patientID.getText());
        }
        this.profile.setFirstName(this.patient_first_name.getText());
        this.profile.setLastName(this.patient_last_name.getText());
        this.profile.setBirthdate(this.patient_dob.getValue());
        this.profile.setMiddleInitial(this.patient_middle_initial.getText());
        this.profile.setPreferredName(this.patient_preferred_name.getText());
        this.profile.setAddress(this.patient_home_address.getText());
        this.profile.setPhoneNumber(this.patient_phone_number.getText());
        this.profile.setEmail(this.patient_email.getText());
        
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
    
    PatientStoreStub.save(this.profile);
        
        
    }
    
      @FXML
    public void didPressCancel(ActionEvent event) {
        loadPatient();
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
    
    
    
    public Patient getProfile(){
        return profile;
    }
    public void setProfile(Patient _profile){
        this.profile = _profile;
        loadPatient();
    }
}

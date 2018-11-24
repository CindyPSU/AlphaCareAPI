package View;

import MedicalRecordModel.AppointmentHistory;
import MedicalRecordModel.Appt.ApptCategories;
import MedicalRecordModel.ImmunizationHistory;
import MedicalRecordModel.MedicalHistory;
import MedicalRecordModel.Appt.ApptCategory;
import MedicalRecordModel.Appt.ApptOptions;
import MedicalRecordModel.Appt.ApptStatusOptions;
import MedicalRecordModel.PatientStoreStub;
import MedicalRecordModel.PrescriptionHistory;
import MedicalRecordModel.RX.RXCategories;
import MedicalRecordModel.RX.RXCategory;
import MedicalRecordModel.RX.RXOptions;
import MedicalRecordModel.TestLab.TestCategories;
import MedicalRecordModel.TestLab.TestCategory;
import MedicalRecordModel.TestLab.TestOptions;
import MedicalRecordModel.TestLabResults;
import MedicalRecordModel.VitalSigns;
import UserModel.Patient;
import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author Cindy Hilgeman (cdh5367)
 */
public class CompleteMedicalRecordFXMLController implements Initializable {

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
    @FXML
    private Button save_all;
    @FXML
    private Button return_to_dashboard;

    private Stage stage;

    @FXML
    private VBox appointmentHistories1;    
    private ArrayList<AppointmentHistoryFXMLController> appointmentHistoryControllers;
    private int appointmentRows = 5;
    
    @FXML
    private VBox immunizationHistories1;
    private ArrayList<ImmunizationHistoryFXMLController> immunizationHistoryControllers;
    private int immunizationHistoryRows = 8;

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
    
    @FXML
    private TitledPane patientInfoPane;
    
    @FXML
    private Accordion accordion;
    
    private DashboardFXMLController dashboardController;
    
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try
        {
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

            // Make the patient info pane expand by default
            accordion.setExpandedPane(patientInfoPane);
            
        } catch (IOException error) {
            error.printStackTrace();
        }
    }  
        
    @FXML
    private void saveAll(ActionEvent event) {
        /*
        if(this.profile == null)
        {
          this.profile = new Patient();
        }
        */
        // save patient profile
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
        
        
        // Save Appointment History Data
        for(int ahCounter = 0; ahCounter < appointmentHistoryControllers.size(); ahCounter++)
        {
          appointmentHistoryControllers.get(ahCounter).save();
        }

        // Save Immunization History Data
        for(int counter = 0; counter < immunizationHistoryControllers.size(); counter++)
        {
          immunizationHistoryControllers.get(counter).save();
        }

        // Save Medical History Data
        for(int counter = 0; counter < medicalHistoryControllers.size(); counter++)
        {
          medicalHistoryControllers.get(counter).save();
        }
        
        // Save Prescription History Data
        for(int counter = 0; counter < prescriptionHistoryControllers.size(); counter++)
        {
          prescriptionHistoryControllers.get(counter).save();
        }

        // Save Lab Results Data
        for(int counter = 0; counter < testLabResultsControllers.size(); counter++)
        {
          testLabResultsControllers.get(counter).save();
        }
        
        // Save Vital Signs Data
        for(int counter = 0; counter < vitalSignsControllers.size(); counter++)
        {
          vitalSignsControllers.get(counter).save();
        }


        PatientStoreStub.save(this.profile);
        this.dashboardController.refreshAppointments();
    }

    @FXML
    private void returnToDashboard(ActionEvent event) {
        this.stage.close();
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
    
    
    
    private Patient profile;
    public Patient getProfile(){
        return profile;
    }
    public void setProfile(Patient _profile){
        this.profile = _profile;
        loadPatient();
    }
    
    /**
     * @return the stage
     */
    public Stage getStage() {
        return stage;
    }

    /**
     * @param stage the stage to set
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * @return the dashboardController
     */
    public DashboardFXMLController getDashboardController() {
        return dashboardController;
    }

    /**
     * @param dashboardController the dashboardController to set
     */
    public void setDashboardController(DashboardFXMLController dashboardController) {
        this.dashboardController = dashboardController;
    }
}


package View;

import MedicalRecordModel.AppointmentHistory;
import MedicalRecordModel.ImmunizationHistory;
import MedicalRecordModel.MedicalHistory;
import MedicalRecordModel.PatientStoreStub;
import MedicalRecordModel.PrescriptionHistory;
import MedicalRecordModel.RX.RXCategories;
import MedicalRecordModel.RX.RXCategory;
import MedicalRecordModel.RX.RXOptions;
import MedicalRecordModel.TestLabResults;
import MedicalRecordModel.VitalSigns;
import UserModel.Patient;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author Cindy Hilgeman (cdh5367)
 */
public class CompleteMedicalRecordFXMLController implements Initializable {

    @FXML
    private Label patientID;
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
    private TextField current_notes;
    @FXML
    private TextField current_med_condition;
    @FXML
    private TextField past_med_condition;
    @FXML
    private TextField past_notes;
    @FXML
    private TextField proc_name_recent;
    @FXML
    private TextField proc_age_recent;
    @FXML
    private TextField proc_age_next;
    @FXML
    private TextField proc_name_next;
    @FXML
    private TextField proc_age_next_next;
    @FXML
    private TextField proc_name_next_next;
    @FXML
    private TextField allergy_one;
    @FXML
    private TextField allergy_one_desc;
    @FXML
    private TextField allergy_two;
    @FXML
    private TextField allergy_two_desc;
    @FXML
    private TextField allergy_three;
    @FXML
    private TextField allergy_three_desc;
    @FXML
    private DatePicker current_date;
    @FXML
    private DatePicker proc_date_recent;
    @FXML
    private DatePicker proc_date_next;
    @FXML
    private DatePicker proc_date_next_next;
    @FXML
    private TextField im_time_one;
    @FXML
    private TextField im_givenby_one;
    @FXML
    private TextField im_title_one;
    @FXML
    private TextField im_id_one;
    @FXML
    private TextField im_type_one;
    @FXML
    private DatePicker im_date_one;
    @FXML
    private DatePicker im_date_two;
    @FXML
    private TextField im_time_two;
    @FXML
    private TextField im_givenby_two;
    @FXML
    private TextField im_title_two;
    @FXML
    private TextField im_id_two;
    @FXML
    private TextField im_type_two;
    @FXML
    private DatePicker im_date_three;
    @FXML
    private DatePicker im_date_four;
    @FXML
    private TextField im_time_three;
    @FXML
    private TextField im_time_four;
    @FXML
    private TextField im_givenby_three;
    @FXML
    private TextField im_givenby_fourt;
    @FXML
    private TextField im_title_three;
    @FXML
    private TextField im_title_four;
    @FXML
    private TextField im_id_four;
    @FXML
    private TextField im_id_three;
    @FXML
    private TextField im_type_three;
    @FXML
    private TextField im_type_four;
    @FXML
    private DatePicker presc_order_date_one;
    @FXML
    private DatePicker presc_order_date_two;
    @FXML
    private DatePicker presc_order_date_three;
    @FXML
    private DatePicker presc_order_date_four;
    @FXML
    private TextField presc_order_time_one;
    @FXML
    private TextField presc_order_time_two;
    @FXML
    private TextField presc_order_time_three;
    @FXML
    private TextField presc_order_time_four;
    @FXML
    private TextField presc_order_physician_one;
    @FXML
    private TextField presc_order_physician_two;
    @FXML
    private TextField presc_order_physician_three;
    @FXML
    private TextField presc_order_physician_four;
    @FXML
    private ChoiceBox<RXCategory> presc_id_four;
    @FXML
    private ChoiceBox<RXOptions> presc_name_four;
    @FXML
    private ChoiceBox<RXCategory> presc_id_three;
    @FXML
    private ChoiceBox<RXOptions> presc_name_three;
    @FXML
    private ChoiceBox<RXCategory> presc_id_one;
    @FXML
    private ChoiceBox<RXOptions> presc_name_one;
    @FXML
    private ChoiceBox<RXCategory> presc_id_two;
    @FXML
    private ChoiceBox<RXOptions> presc_name_two;
    @FXML
    private Label presc_refills_one;
    @FXML
    private Label presc_refills_two;
    @FXML
    private Label presc_refills_three;
    @FXML
    private Label presc_refills_four;
    @FXML
    private DatePicker app_date_one;
    @FXML
    private DatePicker app_date_two;
    @FXML
    private DatePicker app_date_three;
    @FXML
    private TextField app_time_one;
    @FXML
    private TextField app_time_two;
    @FXML
    private TextField app_time_three;
    @FXML
    private TextField app_physician_one;
    @FXML
    private TextField app_physician_two;
    @FXML
    private TextField app_physician_three;
    @FXML
    private ChoiceBox<?> app_code_three;
    @FXML
    private ChoiceBox<?> app_desc_three;
    @FXML
    private ChoiceBox<?> app_code_two;
    @FXML
    private ChoiceBox<?> app_desc_two;
    @FXML
    private ChoiceBox<?> app_code_one;
    @FXML
    private ChoiceBox<?> app_desc_one;
    @FXML
    private ChoiceBox<?> app_status_one;
    @FXML
    private TextField app_medical_practice_one;
    @FXML
    private ChoiceBox<?> app_status_three;
    @FXML
    private TextField app_medical_practice_three;
    @FXML
    private ChoiceBox<?> app_status_two;
    @FXML
    private TextField app_medical_practice_two;
    @FXML
    private TextField vs_time_one;
    @FXML
    private TextField vs_checkedby_one;
    @FXML
    private TextField hr_one;
    @FXML
    private TextField bp_one;
    @FXML
    private DatePicker vs_date_one;
    @FXML
    private DatePicker vs_date_two;
    @FXML
    private TextField vs_time_two;
    @FXML
    private TextField vs_checkedby_two;
    @FXML
    private TextField hr_two;
    @FXML
    private TextField bp_two;
    @FXML
    private DatePicker vs_date_three;
    @FXML
    private DatePicker vs_date_four;
    @FXML
    private TextField vs_time_three;
    @FXML
    private TextField vs_time_four;
    @FXML
    private TextField vs_checkedby_three;
    @FXML
    private TextField vs_checkedby_four;
    @FXML
    private TextField hr_four;
    @FXML
    private TextField hr_three;
    @FXML
    private TextField bp_three;
    @FXML
    private TextField bp_four;
    @FXML
    private TextField o2_one;
    @FXML
    private TextField bpm_one;
    @FXML
    private TextField o2_two;
    @FXML
    private TextField bpm_two;
    @FXML
    private TextField o2_three;
    @FXML
    private TextField bpm_three;
    @FXML
    private TextField o2_four;
    @FXML
    private TextField bpm_four;
    @FXML
    private DatePicker tL_date_one;
    @FXML
    private DatePicker tL_date_two;
    @FXML
    private DatePicker tL_date_three;
    @FXML
    private DatePicker tL_date_four;
    @FXML
    private TextField tL_time_one;
    @FXML
    private TextField tL_time_two;
    @FXML
    private TextField tL_time_three;
    @FXML
    private TextField tL_time_four;
    @FXML
    private TextField tL_physician_one;
    @FXML
    private TextField tL_physician_two;
    @FXML
    private TextField tL_physician_three;
    @FXML
    private TextField tL_physician_four;
    @FXML
    private ChoiceBox<?> test_id_four;
    @FXML
    private ChoiceBox<?> test_name_four;
    @FXML
    private ChoiceBox<?> test_id_three;
    @FXML
    private ChoiceBox<?> test_name_three;
    @FXML
    private ChoiceBox<?> test_id_one;
    @FXML
    private ChoiceBox<?> test_name_one;
    @FXML
    private ChoiceBox<?> test_id_two;
    @FXML
    private ChoiceBox<?> test_name_two;
    @FXML
    private TextField test_result_one;
    @FXML
    private TextField test_result_two;
    @FXML
    private TextField test_result_three;
    @FXML
    private TextField test_result_four;
    @FXML
    private Button save_all;
    @FXML
    private Button return_to_dashboard;
    private RXCategories rxCategories = new RXCategories();
    private Stage stage;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setupRXChoiceBoxes(this.presc_id_one, this.presc_name_one);
        setupRXChoiceBoxes(this.presc_id_two, this.presc_name_two);
        setupRXChoiceBoxes(this.presc_id_three, this.presc_name_three);
        setupRXChoiceBoxes(this.presc_id_four, this.presc_name_four);
    }  
    
    private void setupRXChoiceBoxes(ChoiceBox<RXCategory> rxIDChoiceBox, ChoiceBox<RXOptions> rxNameChoiceBox){
        rxIDChoiceBox.setItems(rxCategories.getRxCategory()); //= new ChoiceBox<RXCategory>(rxCategories.getRxCategory());
        ChangeListener<RXCategory> changeListener = new ChangeListener<RXCategory>() {

            @Override
            public void changed(ObservableValue<? extends RXCategory> observable, RXCategory oldValue, RXCategory newValue) {
                rxNameChoiceBox.setItems(newValue.getRxOptions());
            }
        };
        // Selected Item Changed.
        rxIDChoiceBox.getSelectionModel().selectedItemProperty().addListener(changeListener);
    }

    @FXML
    private void saveAll(ActionEvent event) {
        if(this.profile == null)
        {
          this.profile = new Patient();
        }
        this.profile.setFirstName(this.patient_first_name.getText());
        this.profile.setLastName(this.patient_last_name.getText());
        this.profile.setBirthdate(this.patient_dob.getValue());
        // finishing adding in all record fields to save   
        PatientStoreStub.save(this.profile);
    }

    @FXML
    private void returnToDashboard(ActionEvent event) {
        this.stage.close();
    }
    
    public void loadPatient(){
        // Load Patient Profile Data
        this.patientID.setText(profile.getIdentifier());
        this.patient_dob.setValue(profile.getBirthdate());
        this.patient_first_name.setText(profile.getFirstName());
        this.patient_last_name.setText(profile.getLastName());
        this.patient_middle_initial.setText(profile.getMiddleInitial());
        this.patient_preferred_name.setText(profile.getPreferredName());
        this.patient_home_address.setText(profile.getAddress().toString());
        this.patient_phone_number.setText(profile.getPhoneNumber());
        this.patient_email.setText(profile.getEmail());
        
        // Load Medical History Data
        this.current_date.setValue(LocalDate.now());
        this.current_notes.setText("Current Medical Notes");
        this.past_notes.setText("Past Medical Notes");
        if(medicalHistory != null)
        {
        this.current_med_condition.setText(medicalHistory.getCurrentMedicalCondition());
        this.past_med_condition.setText(medicalHistory.getPastMedicalCondition());
        
        // Load Procedure History Data
        this.proc_date_recent.setValue(medicalHistory.getProcedureDate());
        this.proc_age_recent.setText(medicalHistory.getProcedureAgeString()); 
        this.proc_name_recent.setText(medicalHistory.getProcedureName());
        
        this.proc_date_next.setValue(medicalHistory.getProcedureDate());
        this.proc_age_next.setText(medicalHistory.getProcedureAgeString()); 
        this.proc_name_next.setText(medicalHistory.getProcedureName());
        
        this.proc_date_next_next.setValue(medicalHistory.getProcedureDate());
        this.proc_age_next_next.setText(medicalHistory.getProcedureAgeString()); 
        this.proc_name_next_next.setText(medicalHistory.getProcedureName());
        
        // Load Allergy Data
        this.allergy_one.setText(medicalHistory.getAllergyName());
        this.allergy_one_desc.setText(medicalHistory.getAllergyDescription());
        
        this.allergy_two.setText(medicalHistory.getAllergyName());
        this.allergy_two_desc.setText(medicalHistory.getAllergyDescription());
        
        this.allergy_three.setText(medicalHistory.getAllergyName());
        this.allergy_three_desc.setText(medicalHistory.getAllergyDescription());
        }
        
        // Load Immunization History Data
        if(immunizationHistory != null)
        {
        this.im_date_one.setValue(immunizationHistory.getImmunizeDate());
        this.im_time_one.setText(immunizationHistory.getImmunizeTime().toString());
        this.im_givenby_one.setText(immunizationHistory.getGivenByName());
        this.im_title_one.setText(immunizationHistory.getGivenByTitle());
        this.im_id_one.setText(immunizationHistory.getImmunizationIDString()); 
        this.im_type_one.setText(immunizationHistory.getImmunizationName());
        
        this.im_date_two.setValue(immunizationHistory.getImmunizeDate());
        this.im_time_two.setText(immunizationHistory.getImmunizeTime().toString());
        this.im_givenby_two.setText(immunizationHistory.getGivenByName());
        this.im_title_two.setText(immunizationHistory.getGivenByTitle());
        this.im_id_two.setText(immunizationHistory.getImmunizationIDString()); 
        this.im_type_two.setText(immunizationHistory.getImmunizationName());
        
        this.im_date_three.setValue(immunizationHistory.getImmunizeDate());
        this.im_time_three.setText(immunizationHistory.getImmunizeTime().toString());
        this.im_givenby_three.setText(immunizationHistory.getGivenByName());
        this.im_title_three.setText(immunizationHistory.getGivenByTitle());
        this.im_id_three.setText(immunizationHistory.getImmunizationIDString()); 
        this.im_type_three.setText(immunizationHistory.getImmunizationName());
        
        this.im_date_four.setValue(immunizationHistory.getImmunizeDate());
        this.im_time_four.setText(immunizationHistory.getImmunizeTime().toString());
        this.im_givenby_fourt.setText(immunizationHistory.getGivenByName());
        this.im_title_four.setText(immunizationHistory.getGivenByTitle());
        this.im_id_four.setText(immunizationHistory.getImmunizationIDString());
        this.im_type_four.setText(immunizationHistory.getImmunizationName());
        }
        
        // Load Prescription History Data
        if(this.profile.prescriptions != null)
        {
            if(this.profile.prescriptions.size() >= 1)
            {
                loadPrescriptionHistory(this.profile.prescriptions.get(0), presc_id_one, presc_name_one, presc_order_date_one, presc_order_time_one, presc_order_physician_one, presc_refills_one);
            }
            if(this.profile.prescriptions.size() >= 2)
            {
                loadPrescriptionHistory(this.profile.prescriptions.get(1), presc_id_two, presc_name_two, presc_order_date_two, presc_order_time_two, presc_order_physician_two, presc_refills_two);
            }
            if(this.profile.prescriptions.size() >= 3)
            {
                loadPrescriptionHistory(this.profile.prescriptions.get(2), presc_id_three, presc_name_three, presc_order_date_three, presc_order_time_three, presc_order_physician_three, presc_refills_three);
            }
            if(this.profile.prescriptions.size() >= 4)
            {
                loadPrescriptionHistory(this.profile.prescriptions.get(3), presc_id_four, presc_name_four, presc_order_date_four, presc_order_time_four, presc_order_physician_four, presc_refills_four);
            }        
        }
        
        // Load Appointment History Data
        if(appointmentHistory != null)
        {
        this.app_date_one.setValue(appointmentHistory.getAppointmentDate());
        this.app_time_one.setText(appointmentHistory.getAppointmentTime().toString());
        this.app_physician_one.setText(appointmentHistory.getPhysicianName());
        //this.app_code_one.setText(appointmentHistory.getAppointmentCode());
        //this.app_desc_one.setText(appointmentHistory.getAppCodeDescription());
        //this.app_status_one.setText(appointmentHistory.getStatus()); 
        this.app_medical_practice_one.setText(appointmentHistory.getPracticeString());
        
        this.app_date_two.setValue(appointmentHistory.getAppointmentDate());
        this.app_time_two.setText(appointmentHistory.getAppointmentTime().toString());
        this.app_physician_two.setText(appointmentHistory.getPhysicianName());
        //this.app_code_two.setText(appointmentHistory.getAppointmentCode());
        //this.app_desc_two.setText(appointmentHistory.getAppCodeDescription());
        //this.app_status_two.setText(appointmentHistory.getStatus()); 
        this.app_medical_practice_two.setText(appointmentHistory.getPracticeString());
        
        this.app_date_three.setValue(appointmentHistory.getAppointmentDate());
        this.app_time_three.setText(appointmentHistory.getAppointmentTime().toString());
        this.app_physician_three.setText(appointmentHistory.getPhysicianName());
        //this.app_code_three.setText(appointmentHistory.getAppointmentCode());
        //this.app_desc_three.setText(appointmentHistory.getAppCodeDescription());
        //this.app_status_three.setText(appointmentHistory.getStatus()); 
        this.app_medical_practice_three.setText(appointmentHistory.getPracticeString());
        }
        
        // Load Vital Signs Data
        if(vitalSigns != null)
        {
        this.vs_date_one.setValue(vitalSigns.getVitalSignsDate());
        this.vs_time_one.setText(vitalSigns.getVitalSignsTime().toString());
        this.vs_checkedby_one.setText(vitalSigns.getCheckedBy());
        this.hr_one.setText(vitalSigns.getHeartRate());
        this.bp_one.setText(vitalSigns.getBloodPressure());
        this.o2_one.setText(vitalSigns.getOxygenSat());
        this.bpm_one.setText(vitalSigns.getBreathsPerMinute());
        
        this.vs_date_two.setValue(vitalSigns.getVitalSignsDate());
        this.vs_time_two.setText(vitalSigns.getVitalSignsTime().toString());
        this.vs_checkedby_two.setText(vitalSigns.getCheckedBy());
        this.hr_two.setText(vitalSigns.getHeartRate());
        this.bp_two.setText(vitalSigns.getBloodPressure());
        this.o2_two.setText(vitalSigns.getOxygenSat());
        this.bpm_two.setText(vitalSigns.getBreathsPerMinute());
        
        this.vs_date_three.setValue(vitalSigns.getVitalSignsDate());
        this.vs_time_three.setText(vitalSigns.getVitalSignsTime().toString());
        this.vs_checkedby_three.setText(vitalSigns.getCheckedBy());
        this.hr_three.setText(vitalSigns.getHeartRate());
        this.bp_three.setText(vitalSigns.getBloodPressure());
        this.o2_three.setText(vitalSigns.getOxygenSat());
        this.bpm_three.setText(vitalSigns.getBreathsPerMinute());
        
        this.vs_date_four.setValue(vitalSigns.getVitalSignsDate());
        this.vs_time_four.setText(vitalSigns.getVitalSignsTime().toString());
        this.vs_checkedby_four.setText(vitalSigns.getCheckedBy());
        this.hr_four.setText(vitalSigns.getHeartRate());
        this.bp_four.setText(vitalSigns.getBloodPressure());
        this.o2_four.setText(vitalSigns.getOxygenSat());
        this.bpm_four.setText(vitalSigns.getBreathsPerMinute());
        }
        
        // Load Test & Lab Results Data
        if(testLabResults != null)
        {
        this.tL_date_one.setValue(testLabResults.getTestOrderDate());
        this.tL_time_one.setText(testLabResults.getTestOrderTime().toString());
        this.tL_physician_one.setText(testLabResults.getPhysicianName());
        //this.test_id_one.setText(testLabResults.getTestID());
        //this.test_name_one.setText(testLabResults.getTestName());
        this.test_result_one.setText(testLabResults.getTestResult()); 
        
        this.tL_date_two.setValue(testLabResults.getTestOrderDate());
        this.tL_time_two.setText(testLabResults.getTestOrderTime().toString());
        this.tL_physician_two.setText(testLabResults.getPhysicianName());
        //this.test_id_two.setText(testLabResults.getTestID());
        //this.test_name_two.setText(testLabResults.getTestName());
        this.test_result_two.setText(testLabResults.getTestResult());
        
        this.tL_date_three.setValue(testLabResults.getTestOrderDate());
        this.tL_time_three.setText(testLabResults.getTestOrderTime().toString());
        this.tL_physician_three.setText(testLabResults.getPhysicianName());
        //this.test_id_three.setText(testLabResults.getTestID());
        //this.test_name_three.setText(testLabResults.getTestName());
        this.test_result_three.setText(testLabResults.getTestResult());
        
        this.tL_date_four.setValue(testLabResults.getTestOrderDate());
        this.tL_time_four.setText(testLabResults.getTestOrderTime().toString());
        this.tL_physician_four.setText(testLabResults.getPhysicianName());
        //this.test_id_four.setText(testLabResults.getTestID());
        //this.test_name_four.setText(testLabResults.getTestName());
        this.test_result_four.setText(testLabResults.getTestResult());
        }
    }
    
    // loadPrescriptionHistory(prescriptionHistory1, presc_id_one, presc_name_one, presc_order_date_one, presc_order_time_one, presc_order_physician_one, presc_refills_one);
    private void loadPrescriptionHistory(PrescriptionHistory prescriptionHistory, ChoiceBox<RXCategory> rxIDChoiceBox, ChoiceBox<RXOptions> rxNameChoiceBox, 
            DatePicker dpOrderDate, TextField txtOrderTime, TextField txtPhysician, Label txtRefills)
    {
        // Sets text fields
        dpOrderDate.setValue(prescriptionHistory.getRXOrderDate());
        txtOrderTime.setText(prescriptionHistory.getRXOrderTime().toString());
        txtPhysician.setText(prescriptionHistory.getPhysicianName());
        txtRefills.setText(prescriptionHistory.getRefillCountString()); 
        
        // Set the choicebox options
        RXCategory category = this.rxCategories.find(prescriptionHistory.getRXID());
        if(category != null)
        {
            // RX ID
            rxIDChoiceBox.setValue(category);
            RXOptions option = category.findOption(prescriptionHistory.getrXName());
            if(option != null)
            {
                // RX Name
                rxNameChoiceBox.setValue(option);
            }
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
    
    MedicalHistory medicalHistory;
    public MedicalHistory getMedicalHistory(){
        return medicalHistory;
    }
    
    ImmunizationHistory immunizationHistory;
    public ImmunizationHistory getImmunizationHistory(){
        return immunizationHistory;
    }
    
    PrescriptionHistory prescriptionHistory;
    public PrescriptionHistory getPrescriptionHistory(){
        return prescriptionHistory;
    }
    
    AppointmentHistory appointmentHistory;
    public AppointmentHistory getAppointmentHistory(){
        return appointmentHistory;
    }
    
    VitalSigns vitalSigns;
    public VitalSigns getVitalSigns(){
        return vitalSigns;
    }
    
    TestLabResults testLabResults;
    public TestLabResults getTestLabResults(){
        return testLabResults;
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
}

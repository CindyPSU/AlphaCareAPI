/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import MedicalRecordModel.AppointmentHistory;
import MedicalRecordModel.Appt.ApptCategories;
import MedicalRecordModel.Appt.ApptCategory;
import MedicalRecordModel.Appt.ApptOptions;
import MedicalRecordModel.Appt.ApptPractices;
import MedicalRecordModel.Appt.ApptStatusOptions;
import MedicalRecordModel.Appt.ApptStatuses;
import UserModel.AppointmentStatus;
import UserModel.Practice;
import java.net.URL;
import java.sql.Time;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Princess_ktwo
 */
public class AppointmentHistoryFXMLController implements Initializable {

    @FXML
    private DatePicker app_date;
    @FXML
    private TextField app_time;
    @FXML
    private TextField app_physician;
    @FXML
    private ChoiceBox<ApptCategory> app_code;
    @FXML
    private ChoiceBox<ApptOptions> app_desc;
    @FXML
    private ChoiceBox<AppointmentStatus> app_status;
    @FXML
    private ChoiceBox<Practice> app_medical_practice;

    private ApptPractices apptPractices = new ApptPractices();
    private ApptCategories apptCategories = new ApptCategories();
    private ApptStatuses apptStatusOptions = new ApptStatuses();
    
    // The AppointmentHistory object associated with the current row
    private AppointmentHistory appointmentHistory;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setupChoiceBoxes();
    }
    
    private void setupChoiceBoxes(){
        app_status.setItems(apptStatusOptions.getOptions());
        app_medical_practice.setItems(apptPractices.getOptions());
        app_code.setItems(apptCategories.getApptCategory()); //= new ChoiceBox<RXCategory>(rxCategories.getRxCategory());
        ChangeListener<ApptCategory> changeListener = new ChangeListener<ApptCategory>() {

            @Override
            public void changed(ObservableValue<? extends ApptCategory> observable, ApptCategory oldValue, ApptCategory newValue) {
                app_desc.setItems(newValue.getApptOptions());
            }
        };
        // Selected Item Changed.
        app_code.getSelectionModel().selectedItemProperty().addListener(changeListener);
    }

    public void load(AppointmentHistory appointmentHistory)
    {
        // Save to the property
        this.appointmentHistory = appointmentHistory;
        
        // Sets text fields
        app_date.setValue(appointmentHistory.getAppointmentDate());
        Time apptTime = appointmentHistory.getAppointmentTime();
        if(apptTime != null)
        {
          app_time.setText(apptTime.toString());
        }
        app_physician.setText(appointmentHistory.getPhysicianName());
        app_medical_practice.setValue(apptPractices.find(appointmentHistory.getPracticeString())); 
        
        // Set the choicebox options
        ApptCategory category = this.apptCategories.find(appointmentHistory.getAppointmentCode());
        if(category != null)
        {
            // Appt Code
            app_code.setValue(category);
            ApptOptions option = category.findOption(appointmentHistory.getAppCodeDescription());
            if(option != null)
            {
                // Appt Description
                app_desc.setValue(option);
            }
        }
        
        if(appointmentHistory.getStatus() != null)
        {
            this.app_status.setValue(appointmentHistory.getStatus());
        }
    }
    
    public void save()
    {
      if(this.appointmentHistory == null)
      {
          // Don't save anything
          return;
      }
      
      appointmentHistory.setAppointmentDate(app_date.getValue());
      String timeText = app_time.getText();
      if((timeText != null) && !timeText.isEmpty())
      {
        appointmentHistory.setAppointmentTime(Time.valueOf(timeText));
      }
      appointmentHistory.setPhysicianName(app_physician.getText());
      if(app_medical_practice.getValue() != null)
      {
        appointmentHistory.setPractice(app_medical_practice.getValue());
      }
      if(app_code.getValue() != null)
      {
        appointmentHistory.setAppointmentCode(app_code.getValue().toString());
      }
      if(app_desc.getValue() != null)
      {
        appointmentHistory.setAppCodeDescription(app_desc.getValue().getApptName());
      }
      if(app_status.getValue() != null)
      {
        appointmentHistory.setStatus(app_status.getValue());
      }
    }
    
}

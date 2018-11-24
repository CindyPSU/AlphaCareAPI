/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import MedicalRecordModel.ImmunizationHistory;
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
public class ImmunizationHistoryFXMLController implements Initializable {

    // The AppointmentHistory object associated with the current row
    private ImmunizationHistory immunizationHistory;
    @FXML
    private DatePicker im_date;
    @FXML
    private TextField im_time;
    @FXML
    private TextField im_givenby;
    @FXML
    private TextField im_title;
    @FXML
    private TextField im_id;
    @FXML
    private TextField im_type;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    public void load(ImmunizationHistory immunizationHistory)
    {
        // Save to the property
        this.immunizationHistory = immunizationHistory;
        
        // Sets text fields
        im_date.setValue(immunizationHistory.getImmunizeDate());
        Time ihTime = immunizationHistory.getImmunizeTime();
        if(ihTime != null)
        {
          im_time.setText(ihTime.toString());
        }
        im_givenby.setText(immunizationHistory.getGivenByName());
        im_title.setText(immunizationHistory.getGivenByTitle());
        im_id.setText(immunizationHistory.getImmunizationID());
        im_type.setText(immunizationHistory.getImmunizeName());
    }
    
    public void save()
    {
      if(this.immunizationHistory == null)
      {
          // Don't save anything
          return;
      }
      
      immunizationHistory.setImmunizeDate(im_date.getValue());
      String timeText = im_time.getText();
      if((timeText != null) && !timeText.isEmpty())
      {
        immunizationHistory.setImmunizeTime(Time.valueOf(timeText));
      }
      if(im_givenby.getText() != null)
      {
        immunizationHistory.setGivenByName(im_givenby.getText());
      }
      if(im_title.getText() != null)
      {
        immunizationHistory.setGivenByTitle(im_title.getText());
      }
      if(im_id.getText() != null)
      {
        immunizationHistory.setImmunizationID(im_id.getText());
      }
      if(im_type.getText() != null)
      {
        immunizationHistory.setImmunizeName(im_type.getText());
      }
    }
    
}

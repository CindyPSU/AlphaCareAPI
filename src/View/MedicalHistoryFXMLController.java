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
import MedicalRecordModel.MedicalHistory;
import UserModel.AppointmentStatus;
import UserModel.Practice;
import java.net.URL;
import java.sql.Time;
import java.time.LocalDate;
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
public class MedicalHistoryFXMLController implements Initializable {
    
    // The MediclaHistory object associated with the current row
    private MedicalHistory medicalHistory;
    
    @FXML
    private TextField proc_name;
    @FXML
    private TextField proc_age;
    @FXML
    private DatePicker proc_date;
    @FXML
    private TextField allergy;
    @FXML
    private TextField allergy_desc;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    public void load(MedicalHistory medicalHistory)
    {
        // Save to the property
        this.medicalHistory = medicalHistory;
        
        // Sets text fields
        proc_date.setValue(medicalHistory.getProcedureDate());

        if(medicalHistory.getProcedureName() != null)
        {
            proc_name.setText(medicalHistory.getProcedureName());
        }
        if(medicalHistory.getProcedureAge() != -1)
        {
            proc_age.setText(Integer.toString(medicalHistory.getProcedureAge()));
        }
        if(medicalHistory.getAllergyName() != null)
        {
            this.allergy.setText(medicalHistory.getAllergyName());
        }
        if(medicalHistory.getAllergyDescription() != null)
        {
            this.allergy_desc.setText(medicalHistory.getAllergyDescription());
        }
    }
    
    public void save()
    {
      if(this.medicalHistory == null)
      {
          // Don't save anything
          return;
      }
      
      medicalHistory.setProcedureDate(proc_date.getValue());
      if(allergy_desc.getText() != null)
      {
        medicalHistory.setAllergyDescription(allergy_desc.getText());
      }
      if(allergy.getText() != null)
      {
        medicalHistory.setAllergyName(allergy.getText());
      }
      if((proc_age.getText() != null) && !proc_age.getText().isEmpty())
      {
        medicalHistory.setProcedureAge(Integer.valueOf(proc_age.getText()));
      }
      if(proc_name.getText() != null)
      {
        medicalHistory.setProcedureName(proc_name.getText());
      }
    }
    
}

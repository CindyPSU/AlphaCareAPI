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
import MedicalRecordModel.VitalSigns;
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
public class VitalSignsFXMLController implements Initializable {

    // The AppointmentHistory object associated with the current row
    private VitalSigns vitalSigns;
    @FXML
    private DatePicker vs_date;
    @FXML
    private TextField vs_time;
    @FXML
    private TextField vs_checkedby;
    @FXML
    private TextField hr;
    @FXML
    private TextField bp;
    @FXML
    private TextField o2;
    @FXML
    private TextField bpm;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void load(VitalSigns vitalSigns) {
        // Save to the property
        this.vitalSigns = vitalSigns;

        // Sets text fields
        vs_date.setValue(vitalSigns.getVitalSignsDate());
        Time apptTime = vitalSigns.getVitalSignsTime();
        if (apptTime != null) {
            vs_time.setText(apptTime.toString());
        }
        vs_checkedby.setText(vitalSigns.getCheckedBy());
        hr.setText(vitalSigns.getHeartRate());
        bp.setText(vitalSigns.getBloodPressure());
        o2.setText(vitalSigns.getOxygenSat());
        bpm.setText(vitalSigns.getBreathsPerMinute());
    }

    public void save() {
        if (this.vitalSigns == null) {
            // Don't save anything
            return;
        }

        vitalSigns.setVitalSignsDate(vs_date.getValue());
        String timeText = vs_time.getText();
        if ((timeText != null) && !timeText.isEmpty()) {
            vitalSigns.setVitalSignsTime(Time.valueOf(timeText));
        }
        vitalSigns.setCheckedBy(vs_checkedby.getText());
        vitalSigns.setHeartRate(hr.getText());
        vitalSigns.setBloodPressure(bp.getText());
        vitalSigns.setOxygenSat(o2.getText());
        vitalSigns.setBreathsPerMinute(bpm.getText());

    }

}

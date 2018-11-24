/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import MedicalRecordModel.PrescriptionHistory;
import MedicalRecordModel.RX.*;
import java.net.URL;
import java.sql.Time;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Princess_ktwo
 */
public class PrescriptionHistoryFXMLController implements Initializable {

    // The PrescriptionHistory object associated with the current row
    private PrescriptionHistory prescriptionHistory;

    private RXCategories rxCategories = new RXCategories();
    private RXOptions rxOptions = new RXOptions();

    @FXML
    private DatePicker presc_order_date;
    @FXML
    private TextField presc_order_time;
    @FXML
    private TextField presc_order_physician;
    @FXML
    private ChoiceBox<RXCategory> presc_id;
    @FXML
    private ChoiceBox<RXOptions> presc_name;
    @FXML
    private TextField presc_refills;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setupChoiceBoxes();
    }

    private void setupChoiceBoxes() {
        ChangeListener<RXCategory> changeListener = new ChangeListener<RXCategory>() {

            @Override
            public void changed(ObservableValue<? extends RXCategory> observable, RXCategory oldValue, RXCategory newValue) {
                presc_name.setItems(newValue.getRxOptions());
            }
        };

        // Selected Item Changed.
        presc_id.setItems(rxCategories.getRxCategory());
        presc_id.getSelectionModel().selectedItemProperty().addListener(changeListener);
    }

    public void load(PrescriptionHistory prescriptionHistory) {
        // Save to the property
        this.prescriptionHistory = prescriptionHistory;

        // Sets text fields
        presc_order_date.setValue(prescriptionHistory.getrXorderDate());
        Time time = prescriptionHistory.getrXorderTime();
        if (time != null) {
            presc_order_time.setText(time.toString());
        }
        if (prescriptionHistory.getPhysicianName() != null) {
            presc_order_physician.setText(prescriptionHistory.getPhysicianName());
        }
        if (prescriptionHistory.getRefillCount() != -1) {
            presc_refills.setText(prescriptionHistory.getRefillCountString());
        }

        // Set the choicebox options
        if (prescriptionHistory.getrXID() != null) {
            RXCategory category = rxCategories.find(prescriptionHistory.getrXID());
            if (category != null) {
                // RX ID
                presc_id.setValue(category);
                if (prescriptionHistory.getrXName() != null) {
                    RXOptions option = category.findOption(prescriptionHistory.getrXName());
                    if (option != null) {
                        // RX Name
                        presc_name.setValue(option);
                    }
                }
            }
        }

    }

    public void save() {
        if (this.prescriptionHistory == null) {
            // Don't save anything
            return;
        }

        prescriptionHistory.setrXorderDate(presc_order_date.getValue());
        String timeText = presc_order_time.getText();
        if ((timeText != null) && !timeText.isEmpty()) {
            prescriptionHistory.setrXorderTime(Time.valueOf(timeText));
        }
        if (presc_order_physician.getText() != null) {
            prescriptionHistory.setPhysicianName(presc_order_physician.getText());
        }
        if ((presc_refills.getText() != null) && !presc_refills.getText().isEmpty()) {
            prescriptionHistory.setRefillCount(Integer.valueOf(presc_refills.getText()));
        }
        if (presc_id.getValue() != null) {
            prescriptionHistory.setrXID(presc_id.getValue().toString());
        }
        if (presc_name.getValue() != null) {
            prescriptionHistory.setrXName(presc_name.getValue().toString());
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Utilities.PatientInputException;
import UserModel.Address;
import UserModel.Patient;
import Utilities.PatientInputValidator;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author chrismorris
 */
public class PatientDetailFXMLController implements Initializable {

    @FXML TextField firstName;
    @FXML TextField lastName;
    @FXML TextField middleInitial;
    @FXML TextField preferredName;
    @FXML DatePicker birthday;
    @FXML TextField phoneNumber;
    @FXML TextField emailAddress;
    @FXML TextField line1;
    @FXML TextField line2;
    @FXML TextField city;
    @FXML TextField state;
    @FXML TextField zipCode;
    @FXML Button saveButton;
    
    private PatientDetailFXMLControllerContext context;
    private PatientDetailFXMLControllerDelegate delegate;
    private CompleteMedicalRecordFXMLController medicalRecordController;
    
    private boolean hasInitialized = false;
    
     /**
     * @return the context
     */
    public PatientDetailFXMLControllerContext getContext() {
        return context;
    }

    /**
     * @param context the context to set
     */
    public void setContext(PatientDetailFXMLControllerContext context) {
        this.context = context;
        if (hasInitialized) {
            context.populateController(this);
            saveButton.setText(getContext().saveButtonTitle());
        }
    }
    
    /**
     * @return the delegate
     */
    public PatientDetailFXMLControllerDelegate getDelegate() {
        return delegate;
    }

    /**
     * @param delegate the delegate to set
     */
    public void setDelegate(PatientDetailFXMLControllerDelegate delegate) {
        this.delegate = delegate;
    }

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        saveButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    }    
    
    public void load() {
        getContext().populateController(this);
        hasInitialized = true;
        saveButton.setText(getContext().saveButtonTitle());
    }
    
    @FXML 
    protected void didSelectSaveButton(ActionEvent event) {
        try {
            Stage stage = (Stage)saveButton.getScene().getWindow();
            Patient profile = generateProfile();
            getDelegate().patientDetailFXMLControllerDidSavePatientProfile(this, stage, profile);
        } catch (PatientInputException exception) {
            Alert alert = new Alert(AlertType.ERROR, exception.toString(), ButtonType.CANCEL);
            alert.showAndWait();
        }
    }
    
    private Patient generateProfile() throws PatientInputException {
        PatientInputValidator validator = new PatientInputValidator(
                firstName.getText(), 
                lastName.getText(), 
                middleInitial.getText(), 
                preferredName.getText(), 
                birthday.getValue(), 
                phoneNumber.getText(), 
                line1.getText(), 
                line2.getText(), 
                city.getText(), 
                state.getText(), 
                zipCode.getText(), 
                emailAddress.getText()
        );
        return validator.validated();
    }

    /**
     * @return the medicalRecordController
     */
    public CompleteMedicalRecordFXMLController getMedicalRecordController() {
        return medicalRecordController;
    }

    /**
     * @param medicalRecordController the medicalRecordController to set
     */
    public void setMedicalRecordController(CompleteMedicalRecordFXMLController medicalRecordController) {
        this.medicalRecordController = medicalRecordController;
    }
}

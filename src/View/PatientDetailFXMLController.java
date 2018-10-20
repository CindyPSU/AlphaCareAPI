/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import MedicalRecordModel.PatientProfile;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
    @FXML TextField address;
    @FXML TextField emailAddress;
    @FXML Button saveButton;
    
    private PatientDetailFXMLControllerContext context;
    private PatientDetailFXMLControllerDelegate delegate;
    
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
            PatientProfile profile = generateProfile();
            getDelegate().patientDetailFXMLControllerDidSavePatientProfile(this, stage, profile);
        } catch (PatientDetailControllerException exception) {
            // show error
            System.out.println(exception);
        }
    }
    
    private PatientProfile generateProfile() throws PatientDetailControllerException {
        String identifierValue = "my_random_id";
        
        String firstNameValue = firstName.getText();
        if (firstNameValue == null) {
            throw new PatientDetailControllerException(PatientDetailControllerException.ERROR_CODE_INVALID_FIRST_NAME);
        }
        
        String lastNameValue = lastName.getText();
        if (lastNameValue == null) {
            throw new PatientDetailControllerException(PatientDetailControllerException.ERROR_CODE_INVALID_LAST_NAME);
        }
        
        String middleInitialValue = middleInitial.getText();
        if (middleInitialValue == null) {
            throw new PatientDetailControllerException(PatientDetailControllerException.ERROR_CODE_INVALID_MIDDLE_INITIAL);
        }
        
        String preferredNameValue = preferredName.getText();
        if (preferredNameValue == null) {
            throw new PatientDetailControllerException(PatientDetailControllerException.ERROR_CODE_INVALID_PREFERRED_NAME);
        }
        
        LocalDate birthdayLocalDateValue = birthday.getValue();
        if (birthdayLocalDateValue == null) {
            throw new PatientDetailControllerException(PatientDetailControllerException.ERROR_CODE_INVALID_BIRTHDATE);
        }
        Date birthdayValue = Date.from(birthdayLocalDateValue.atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        String phoneNumberValue = phoneNumber.getText();
        if (phoneNumberValue == null) {
            throw new PatientDetailControllerException(PatientDetailControllerException.ERROR_CODE_INVALID_PHONE_NUMBER);
        }
        
        String addressValue = address.getText();
        if (addressValue == null) {
            throw new PatientDetailControllerException(PatientDetailControllerException.ERROR_CODE_INVALID_ADDRESS);
        }
        
        String emailAddressValue = emailAddress.getText();
        if (emailAddressValue == null) {
            throw new PatientDetailControllerException(PatientDetailControllerException.ERROR_CODE_INVALID_EMAIL_ADDRESS);
        }
        
        return new PatientProfile(
                identifierValue, 
                firstNameValue, 
                lastNameValue,
                middleInitialValue, 
                preferredNameValue, 
                birthdayValue, 
                phoneNumberValue, 
                addressValue, 
                emailAddressValue
        );
    }
}
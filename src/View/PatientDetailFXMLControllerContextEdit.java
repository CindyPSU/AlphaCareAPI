/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import MedicalRecordModel.PatientProfile;
import java.text.SimpleDateFormat;
import java.time.ZoneId;

/**
 *
 * @author chrismorris
 */
public class PatientDetailFXMLControllerContextEdit implements PatientDetailFXMLControllerContext {

    /**
     * @return the profile
     */
    public PatientProfile getProfile() {
        return profile;
    }
    
    private final PatientProfile profile;

    public PatientDetailFXMLControllerContextEdit(PatientProfile profile) {
        this.profile = profile;
    }

    @Override
    public void populateController(PatientDetailFXMLController controller) {
        PatientProfile profile = getProfile();
        controller.firstName.setText(profile.getPatientFirstName());
        controller.lastName.setText(profile.getPatientLastName());
        controller.middleInitial.setText(profile.getPatientMiddleInitial());
        controller.preferredName.setText(profile.getPatientPreferredName());
        controller.address.setText(profile.getPatientAddress());
        SimpleDateFormat format = new SimpleDateFormat();
        controller.birthday.setValue(profile.getPatientDOB().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        controller.address.setText(profile.getPatientAddress());
        controller.emailAddress.setText(profile.getPatientEmailAddress());
    }
    
    @Override
    public String saveButtonTitle() {
        return "Update";
    }
    
}

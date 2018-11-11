/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import UserModel.Address;
import UserModel.Patient;
import java.text.SimpleDateFormat;

/**
 *
 * @author chrismorris
 */
public class PatientDetailFXMLControllerContextEdit implements PatientDetailFXMLControllerContext {

    /**
     * @return the profile
     */
    public Patient getProfile() {
        return profile;
    }
    
    private final Patient profile;

    public PatientDetailFXMLControllerContextEdit(Patient profile) {
        this.profile = profile;
    }

    @Override
    public void populateController(PatientDetailFXMLController controller) {
        Patient profile = getProfile();
        controller.firstName.setText(profile.getFirstName());
        controller.lastName.setText(profile.getLastName());
        controller.middleInitial.setText(profile.getMiddleInitial());
        controller.preferredName.setText(profile.getPreferredName());
        /*Address address = profile.getAddress();
        controller.line1.setText(address.getLine1());
        controller.line2.setText(address.getLine2());
        controller.city.setText(address.getCity());
        controller.state.setText(address.getState());
        controller.zipCode.setText(address.getZipCode());
*/
        SimpleDateFormat format = new SimpleDateFormat();
        controller.birthday.setValue(profile.getBirthdate());
        controller.emailAddress.setText(profile.getEmail());
    }
    
    @Override
    public String saveButtonTitle() {
        return "Update";
    }
    
}

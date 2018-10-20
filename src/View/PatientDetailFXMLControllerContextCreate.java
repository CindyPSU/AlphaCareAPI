/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author chrismorris
 */
public class PatientDetailFXMLControllerContextCreate implements PatientDetailFXMLControllerContext {

    @Override
    public void populateController(PatientDetailFXMLController controller) {
        // Doing nothing here on purpose. Though it could be to preload data
        // that somehow the application has captured.
    }

    @Override
    public String saveButtonTitle() {
        return "Save";
    }
    

    
}

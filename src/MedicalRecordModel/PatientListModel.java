/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MedicalRecordModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author chrismorris
 */
public class PatientListModel {
    
    private ArrayList<PatientProfile> patients;
    
    /**
     * @return the patients
     */
    public ArrayList<PatientProfile> getPatients() {
        return patients;
    }
    
    void loadPatients() {
        patients = new ArrayList();
        PatientProfile patient = new PatientProfile(
                "123456789", 
                "Marty",
                "McFly", 
                "CK", 
                "Marty", 
                new SimpleDateFormat(), 
                "5556778", 
                "9303 Roslyndale Ave, Pacoima, CA 91331", 
                "bttf@gmail.com"
        );
        getPatients().add(patient);
        getPatients().add(patient);
        getPatients().add(patient);
        
        System.out.println("Patient List Model loaded patients. Would typically "
                + "load from a persistence layer.");
    }
}

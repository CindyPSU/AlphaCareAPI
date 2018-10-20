/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MedicalRecordModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author chrismorris
 */
public class PatientStoreStub implements PatientStore {
    
    public static final List<PatientProfile> savedPatients = new ArrayList();
    
    public static void initiate() {
        savedPatients.add(new PatientProfile(
                "123456789", 
                "Marty",
                "McFly", 
                "CK", 
                "Marty", 
                new Date(), 
                "5556778", 
                "9303 Roslyndale Ave, Pacoima, CA 91331", 
                "bttf@gmail.com"
        ));
        savedPatients.add(new PatientProfile(
                "987654321", 
                "Jeffery",
                "Rosendale", 
                "K", 
                "Jeff", 
                new Date(), 
                "5552132", 
                "3822 Upstreet Drive, Pacoima, CA 91331", 
                "jeff.is.the.man@gmail.com"
        ));
        savedPatients.add(new PatientProfile(
                "3768487", 
                "Jimmy",
                "Buffet", 
                "A", 
                "", 
                new Date(), 
                "5551111", 
                "123 UFC Road, Las Vegas, NV 89104", 
                "bttf@gmail.com"
        ));
    }

    @Override
    public List<PatientProfile> loadPatients() {
        return PatientStoreStub.savedPatients;
    }

    @Override
    public void updatePatient(PatientProfile profile) {
        List<PatientProfile> filtered = PatientStoreStub.savedPatients.stream().filter(
                _profile -> _profile.getPatientID().equals(profile.getPatientID())
        ).collect(Collectors.toList());
        if (filtered.size() != 1) {
            return;
        }
        PatientProfile matchingProfile = filtered.get(0);
        matchingProfile = profile;
    }    

}

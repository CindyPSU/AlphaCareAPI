/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MedicalRecordModel;

import DBModel.SQLite;
import DBModel.SQLite_PatientProfile;
import UserModel.Address;
import UserModel.Patient;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author chrismorris
 */
public class PatientStoreStub implements EntityStore<Patient> {
    
    public static final List<Patient> savedPatients = new ArrayList();
    
    public static void initiate() {
        Address addressOne = new Address();
        addressOne.setLine1("9303 Roslyndale Ave");
        addressOne.setCity("Pacoima");
        addressOne.setState("CA");
        addressOne.setZipCode("91331");
        savedPatients.add(new Patient(
                "123456789", 
                "Marty",
                "McFly", 
                "CK", 
                "Marty", 
                LocalDate.now(), 
                "5556778", 
                addressOne.toString(), 
                "bttf@gmail.com"
        ));
        
        Address addressTwo = new Address();
        addressTwo.setLine1("3822 Upstreet Drive");
        addressTwo.setCity("Pacoima");
        addressTwo.setState("CA");
        addressTwo.setZipCode("91331");
        savedPatients.add(new Patient(
                "987654321", 
                "Jeffery",
                "Rosendale", 
                "K", 
                "Jeff", 
                LocalDate.now(), 
                "5552132", 
                addressTwo.toString(), 
                "jeff.is.the.man@gmail.com"
        ));
        
        Address addressThree = new Address();
        addressThree.setLine1("123 UFC Road");
        addressThree.setCity("Las Vegas");
        addressThree.setState("NV");
        addressThree.setZipCode("89104");
        savedPatients.add(new Patient(
                "3768487", 
                "Jimmy",
                "Buffet", 
                "A", 
                "", 
                LocalDate.now(), 
                "5551111", 
                addressThree.toString(), 
                "bttf@gmail.com"
        ));
    }

    @Override
    public List<Patient> load() {
        List<Patient> results = SQLite_PatientProfile.loadPatients();
        return results;
        // return PatientStoreStub.savedPatients;
    }

    @Override
    public void update(Patient profile) {
        List<Patient> filtered = PatientStoreStub.savedPatients.stream().filter(
                _profile -> _profile.getIdentifier().equals(profile.getIdentifier())
        ).collect(Collectors.toList());
        if (filtered.size() != 1) {
            return;
        }
        Patient matchingProfile = filtered.get(0);
        matchingProfile = profile;
    }
    
    public static void save(Patient profile)
    {
        boolean foundPatient = false;
        for(Patient p: savedPatients)
        {
            if(p == profile)
            {
                foundPatient = true;
                break;
            }
        }
        if(!foundPatient)
        {
            savedPatients.add(profile);
        }
        SQLite_PatientProfile.save(profile);
    }
    
    
    

}

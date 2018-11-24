/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MedicalRecordModel;

import MedicalRecordModel.AppointmentHistory;
import UserModel.Address;
import UserModel.AppointmentStatus;
import UserModel.Practice;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author chrismorris
 */
public class PracticeStoreStub implements EntityStore<Practice> {

    @Override
    public List<Practice> load() {
        List<Practice> list = new ArrayList();

        list.add(new Practice("Cheep Medissin, Ink.", 
                        new Address(), 
                        new ArrayList(), 
                        new ArrayList(), 
                        new ArrayList(), 
                        new ArrayList()
                ));
        list.add(new Practice("Termite Meadows Clinic", 
                        new Address(), 
                        new ArrayList(), 
                        new ArrayList(), 
                        new ArrayList(), 
                        new ArrayList()
                ));

        list.add(new Practice("Diamond Care Hospital", 
                        new Address(), 
                        new ArrayList(), 
                        new ArrayList(), 
                        new ArrayList(), 
                        new ArrayList()
                ));
        return list;
    }

    @Override
    public void update(Practice practice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

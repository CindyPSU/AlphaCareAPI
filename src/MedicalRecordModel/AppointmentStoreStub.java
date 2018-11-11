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
public class AppointmentStoreStub implements EntityStore<AppointmentHistory> {

    @Override
    public List<AppointmentHistory> load() {
        List<AppointmentHistory> list = new ArrayList();
        AppointmentHistory appointment = new AppointmentHistory(
                "", 
                0, 
                LocalDate.now(), 
                new Time(System.currentTimeMillis()), 
                "Dr. Kevorkian", 
                "appointment_code", 
                "appCodeDesc", 
                AppointmentStatus.PENDING, 
                new Practice("", 
                        new Address(), 
                        new ArrayList(), 
                        new ArrayList(), 
                        new ArrayList(), 
                        new ArrayList()
                )
        );
        list.add(appointment);
        return list;
    }

    @Override
    public void update(AppointmentHistory profile) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SchedulingEventModel;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author JCELE
 */
public class EventCalendar
{
    
    ArrayList<HealthClasses> healthClassList;
    ArrayList<Appointment> appointmentList;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    LocalDateTime today = LocalDateTime.now(); 
    
    public EventCalendar(){
        healthClassList = new ArrayList();
        appointmentList = new ArrayList();
    }
    
    public void addHealthClass(HealthClasses healthClass){
        healthClassList.add(healthClass);
    }
    
    
    public void addAppointment(Appointment appointment){
        appointmentList.add(appointment);
    }
    
    
    public void printAppointmentEvent(){
        System.out.println("Here are you Appointments");
        appointmentList.stream().forEach((appt) ->
        {
            System.out.println(appt);
        });
    }
    
    public void printHealthClassesEvent(){
        System.out.println("Here are your Health Classes");
        healthClassList.stream().forEach((hc) ->
        {
            System.out.println(hc);
        });
    }
    
    
    public void showCurrentEvent(){
        for (int i=0; i<=0; i++){
        if(dateFormat.format(today).equals(dateFormat.format(healthClassList.get(i).getStartDate()))  ){
            System.out.println("Today event is: " + healthClassList.get(i).getClassName());
        }
                                 }
    }
    
}

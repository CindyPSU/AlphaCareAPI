/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SchedulingEventModel;

import java.util.Date;

/**
 *
 * @author JCELE
 */
public interface HealthClasses
{
    
    
    String getClassName();
    void setClassName(String className);
    
    String getClassType();
    void setClassType(String classType);
    
    Date getStartDate();
    void setStartDate(Date startDate);
    
    int getStartTime();
    void setStartTime(int startTime);
    
    Date getEndDate();
    void setEndDate(Date endDate);
    
    int getEndTime();
    void setEndTime(int endTime);
    
    String getClassLocation();
    void setClassLocation(String classLocation);
    
    String getClassDetails();
    void setClassDetails(String classDetails);
    
    String getRegistrationRoster();
    void setRegistrationRoster(String registrationRoster);
    
    int getRegistrationCount();
    void setRegistrationCount(int registrationCount);

    
    
    
    
}

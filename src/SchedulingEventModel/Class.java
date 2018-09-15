/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SchedulingEventModel;

import java.util.Date;

/**
 *
 * @author Group 3 - Jonathan Celestin, Cynthia Hilgeman, Karin Martin, and Christopher Morris
 */
public class Class {
    private String className;
    private String classType;
    private Date startDate;
    private int startTime;
    private Date endDate;
    private int endTime;
    private double classCost;
    private String classLocation;
    private String classDetails;
    private String registrationRoster; //
    private int registrationCount;
    
    public Class(String className, String classType, Date startDate, 
                    Date endDate,int startTime, int endTime, double classCost, 
                    String classLocation, String classDetails)
    {
        this.className = className;
        this.classType = classType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.classCost = classCost;
        this.classLocation = classLocation;
        this.classDetails = classDetails;
    }

    /**
     * @return the className
     */
    public String getClassName()
    {
        return className;
    }

    /**
     * @param className the className to set
     */
    public void setClassName(String className)
    {
        this.className = className;
    }

    /**
     * @return the classType
     */
    public String getClassType()
    {
        return classType;
    }

    /**
     * @param classType the classType to set
     */
    public void setClassType(String classType)
    {
        this.classType = classType;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate()
    {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }

    /**
     * @return the startTime
     */
    public int getStartTime()
    {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(int startTime)
    {
        this.startTime = startTime;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate()
    {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }

    /**
     * @return the endTime
     */
    public int getEndTime()
    {
        return endTime;
    }

    /**
     * @param endTime the endTime to set
     */
    public void setEndTime(int endTime)
    {
        this.endTime = endTime;
    }

    /**
     * @return the classCost
     */
    public double getClassCost()
    {
        return classCost;
    }

    /**
     * @param classCost the classCost to set
     */
    public void setClassCost(double classCost)
    {
        this.classCost = classCost;
    }

    /**
     * @return the classLocation
     */
    public String getClassLocation()
    {
        return classLocation;
    }

    /**
     * @param classLocation the classLocation to set
     */
    public void setClassLocation(String classLocation)
    {
        this.classLocation = classLocation;
    }

    /**
     * @return the classDetails
     */
    public String getClassDetails()
    {
        return classDetails;
    }

    /**
     * @param classDetails the classDetails to set
     */
    public void setClassDetails(String classDetails)
    {
        this.classDetails = classDetails;
    }

    /**
     * @return the registrationRoster
     */
    public String getRegistrationRoster()
    {
        return registrationRoster;
    }

    /**
     * @param registrationRoster the registrationRoster to set
     */
    public void setRegistrationRoster(String registrationRoster)
    {
        this.registrationRoster = registrationRoster;
    }

    /**
     * @return the registrationCount
     */
    public int getRegistrationCount()
    {
        return registrationCount;
    }

    /**
     * @param registrationCount the registrationCount to set
     */
    public void setRegistrationCount(int registrationCount)
    {
        this.registrationCount = registrationCount;
    }
    
}

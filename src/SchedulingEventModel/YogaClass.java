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
public class YogaClass implements HealthClasses {
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
    
    public YogaClass(String className, String classType, Date startDate)
    {
        this.className = className;
        this.classType = classType;
        this.startDate = startDate;
    }

    /**
     * @return the className
     */
    @Override
    public String getClassName()
    {
        return className;
    }

    /**
     * @param className the className to set
     */
    @Override
    public void setClassName(String className)
    {
        this.className = className;
    }

    /**
     * @return the classType
     */
    @Override
    public String getClassType()
    {
        return classType;
    }

    /**
     * @param classType the classType to set
     */
    @Override
    public void setClassType(String classType)
    {
        this.classType = classType;
    }

    /**
     * @return the startDate
     */
    @Override
    public Date getStartDate()
    {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    @Override
    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }

    /**
     * @return the startTime
     */
    @Override
    public int getStartTime()
    {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    @Override
    public void setStartTime(int startTime)
    {
        this.startTime = startTime;
    }

    /**
     * @return the endDate
     */
    @Override
    public Date getEndDate()
    {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    @Override
    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }

    /**
     * @return the endTime
     */
    @Override
    public int getEndTime()
    {
        return endTime;
    }

    /**
     * @param endTime the endTime to set
     */
    @Override
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
    @Override
    public String getClassLocation()
    {
        return classLocation;
    }

    /**
     * @param classLocation the classLocation to set
     */
    @Override
    public void setClassLocation(String classLocation)
    {
        this.classLocation = classLocation;
    }

    /**
     * @return the classDetails
     */
    @Override
    public String getClassDetails()
    {
        return classDetails;
    }

    /**
     * @param classDetails the classDetails to set
     */
    @Override
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

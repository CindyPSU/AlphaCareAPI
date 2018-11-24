/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserModel;

import java.util.ArrayList;

/**
 * The location where all medical personal work and patients go for visits
 * @author chrismorris
 */
public class Practice {
    
    private String name;
    private Address address;
    private ArrayList<Physician> physicians;
    private ArrayList<Nurse> nurses;
    private ArrayList<MedicalAdministrator> medicalAdministrators;
    private ArrayList<Patient> patients;

    public Practice()
    {
    }
    
    public Practice(String name, Address address, ArrayList<Physician> physicians, ArrayList<Nurse> nurses, ArrayList<MedicalAdministrator> medicalAdministrators, ArrayList<Patient> patients) {
        this.name = name;
        this.address = address;
        this.physicians = physicians;
        this.nurses = nurses;
        this.medicalAdministrators = medicalAdministrators;
        this.patients = patients;
    }

    @Override
    public String toString(){
        return name;
    }
    
    /**
     * Returns the list of physicians for Practice
     * @return 
     */
    public ArrayList<Physician> getPhysicians() {
        return physicians;
    }

    /**
     * Sets the list of physicians for Practice
     * @param physicians 
     */
    public void setPhysicians(ArrayList<Physician> physicians) {
        this.physicians = physicians;
    }

    /**
     * Returns the list of nurses for Practice
     * @return 
     */
    public ArrayList<Nurse> getNurses() {
        return nurses;
    }

    /**
     * Sets the list of nurses for Practice
     * @param nurses 
     */
    public void setNurses(ArrayList<Nurse> nurses) {
        this.nurses = nurses;
    }

    /**
     * Returns the list of administrators for Practice
     * @return 
     */
    public ArrayList<MedicalAdministrator> getMedicalAdministrators() {
        return medicalAdministrators;
    }

    /**
     * Sets the list of administrators for Practice
     * @param medicalAdministrators 
     */
    public void setMedicalAdministrators(ArrayList<MedicalAdministrator> medicalAdministrators) {
        this.medicalAdministrators = medicalAdministrators;
    }

    /**
     * Returns the list of patients for Practice
     * @return 
     */
    public ArrayList<Patient> getPatients() {
        return patients;
    }

    /**
     * Sets the list of patients for Practice
     * @param patients 
     */
    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }

    /**
     * Returns the address for Practice
     * @return 
     */
    public Address getAddress() {
        return address;
    }
    
    /**
     * @param address the address to set
     */
    public void setAddress(Address address) {
        this.address = address;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}

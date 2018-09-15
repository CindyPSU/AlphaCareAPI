/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserModel;

import java.util.ArrayList;

/**
 * The insurance company, typically in relation to the insurance used by a 
 * patient.
 * @author chrismorris
 */
public class InsuranceCompany {
    
    private String name;
    private Address address;
    private ArrayList<InsuranceType> types;

    /**
     * Returns the name for InsuranceCompany
     * @return 
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name for InsuranceCompany
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the address for InsuranceCompany
     * @return 
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the address for InsuranceCompany
     * @param address 
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Returns the types of insurance for InsuranceCompany
     * @return 
     */
    public ArrayList<InsuranceType> getTypes() {
        return types;
    }

    /**
     * Sets the types of insurance for InsuranceCompany
     * @param types 
     */
    public void setTypes(ArrayList<InsuranceType> types) {
        this.types = types;
    }
    
}

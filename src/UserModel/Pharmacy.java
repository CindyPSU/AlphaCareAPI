/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserModel;

import java.util.ArrayList;

/**
 * The entity that medication is sent to for patients to continue their medication
 * @author chrismorris
 */
public class Pharmacy {
    
    private Address address;
    private ArrayList<String> services;
    
    /**
     * Returns the address for Pharmacy
     * @return 
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the address for Pharmacy
     * @param address 
     */
    public void setAddress(Address address) {
        this.address = address;
    }
    
    /**
     * Returns the services for Pharmacy
     * @return 
     */
    public ArrayList<String> getServices() {
        return services;
    }

    /**
     * Sets the services for Pharmacy
     * @param services 
     */
    public void setServices(ArrayList<String> services) {
        this.services = services;
    }
}

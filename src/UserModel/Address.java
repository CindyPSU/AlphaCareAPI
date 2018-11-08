/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserModel;

/**
 * The Address model represents the address of a physical geographical location.
 * @author chrismorris
 */
public class Address {
    
    private String line1;
    private String line2;
    private String city;
    private String state;
    private String zipCode;

    /**
     * Returns the first line of the street address for for an Address.
     * @return line1
     */
    public String getLine1() {
        return line1;
    }

    /**
     * Sets the first line of the street address for for an Address.
     * @param line1 
     */
    public void setLine1(String line1) {
        this.line1 = line1;
    }

    /**
     * Returns the second line of the street address for for an Address.
     * @return line1
     */
    public String getLine2() {
        return line2;
    }

    /**
     * Sets the second line of the street address for for an Address.
     * @param line2 
     */
    public void setLine2(String line2) {
        this.line2 = line2;
    }

    /**
     * Returns the city for for an Address.
     * @return 
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city for for an Address.
     * @param city 
     */
    public void setCity(String city) {
        this.city = city;
    }

    /** 
     * Returns the state for for an Address.
     * @return 
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state for for an Address.
     * @param state 
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Returns the zip code for for an Address.
     * @return
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Sets the zip code for for an Address.
     * @param zipCode 
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserModel;

/**
 *
 * @author chrismorris
 */
public enum AppointmentStatus {
    UPCOMING("UPCOMING"), CHECKED_IN("CHECKED_IN"), PENDING("PENDING"), CANCELED("CANCELED");
    
    private final String value;
    
    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }
    
    private AppointmentStatus(String value) {
        this.value = value;
    }
    
}

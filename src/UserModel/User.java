
package UserModel;

import Utilities.PKI;
import Utilities.UserDigitalSigner;
import java.security.KeyPair;
import java.security.cert.X509Certificate;

/**
 * An Abstract class that represents a user. 
 * @author chrismorris
 */
public abstract class User {

    protected String firstName;
    protected String lastName;
    protected String middleInitial;
    protected String preferredName;
    
    /**
     * Returns the first name of User
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of User
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the last name of User
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of User
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the middle name of User
     * @return the middleInitial
     */
    public String getMiddleInitial() {
        return middleInitial;
    }

    /**
     * Sets the middle name of User
     * @param middleInitial the middleInitial to set
     */
    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    /**
     * Returns the preferred name (nickname) of User
     * @return the preferredName
     */
    public String getPreferredName() {
        return preferredName;
    }

    /**
     * Sets the preferred name (nickname) of User
     * @param preferredName the preferredName to set
     */
    public void setPreferredName(String preferredName) {
        this.preferredName = preferredName;
    }
    
    public String getClassName() {
        return getClass().getSimpleName();
    }
    
    public String getFullName(){
        String fullName = getFirstName();
        String middleInitial = getMiddleInitial();
        if (middleInitial != null) {
            fullName += " " + middleInitial + ".";
        }
        return fullName + " " + getLastName();
    }
}

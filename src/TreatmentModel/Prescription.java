
package TreatmentModel;

import UserModel.Pharmacy;
import java.util.ArrayList;
import java.util.Date;
import Utilities.IDigitalSigner;

/**
 *
 * @author Group 3 - Jonathan Celestin, Cynthia Hilgeman, Karin Martin, and Christopher Morris
 */

/**
 * The Prescription model represents all of the necessary components of a prescription.
 */
public class Prescription extends Pharmacy {
    
    private Pharmacy pharmacy; 
    private int rXID;
    private String drugName;
    ArrayList<Drug> drug;
    private int quantity;
    private int refills;
    private Date written;
    private Date reorder;
    private Date discard;
    private String digitalSignature;
    
    /**
     * @param pharm
     * @param rx
     * @param drgNm
     * @param numRef
     * @param qty
     * @param writ
     * @param reord
     * @param disc
     */
    public Prescription(Pharmacy pharm, int rx, String drgNm, int numRef, int qty, Date writ, Date reord, Date disc) {
        pharmacy = pharm;
        rXID = rx;
        drugName = drgNm;
        refills = numRef;
        quantity = qty;
        written = writ;
        reorder = reord;
        discard = disc;   
    }

    // Example #1
    // prescription p = new prescription(...);
    // User u = new User(...);
    // p.DigitallySign(u.getDigitalSigner());
    // Example #2
    // prescription p = new prescription(...);
    // PowerOfAttorneyAdapter poa = new PowerOfAttorneyAdapter("Robert Smith, 123 Main Street, New York, NY 20012");
    // p.DigitallySign(poa);
    public void DigitallySign(IDigitalSigner signer) throws Exception{
        digitalSignature = signer.digitalSign(this.toString());
    }
    
    /**
     * Returns the name of the pharmacy.
     * @return
     */
    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    /**
     * Sets the name of the pharmacy.
     * @param pharmacy
     */
    public void setPharmName(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    /**
     * Returns the prescription identification number.
     * @return
     */
    public long getRxID() {
        return rXID;
    }

    /**
     * Sets the prescription identification number.
     * @param rXID
     */
    public void setRXID(int rXID) {
        this.rXID = rXID;
    }

    /**
     * Returns the number of allowable refills.
     * @return
     */
    public int getNumberRefills() {
        return refills;
    }

    /**
     * Sets the number of allowable refills.
     * @param refills
     */
    public void setNumberRefills(int refills) {
        this.refills = refills;
    }

    /**
     * Returns the quantity to be filled.
     * @return
     */
    public int getQtyFilled() {
        return quantity;
    }

    /**
     * Sets the quantity to be filled.
     * @param quantity
     */
    public void setQtyFilled(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns the name of the prescribed drug.
     * @return
     */
    public String getDrugName() {
        return drugName;
    }

    /**
     * Sets the name of the prescribed drug.
     * @param drugName
     */
    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    /**
     * Returns the date of when the physician wrote the prescription.
     * @return
     */
    public Date getWritten() {
        return written;
    }

    /**
     * Sets the date of when the physician wrote the prescription.
     * @param written
     */
    public void setWritten(Date written) {
        this.written = written;
    }

    /**
     * Returns the date that the patient can refill the prescription.
     * @return
     */
    public Date getReorder() {
        return reorder;
    }

    /**
     * Sets the date that the patient can refill the prescription.
     * @param reorder
     */
    public void setReorder(Date reorder) {
        this.reorder = reorder;
    }

    /**
     * Returns the date that the prescription should be discarded.
     * @return
     */
    public Date getDiscard() {
        return discard;
    }

    /**
     * Sets the date that the prescription should be discarded.
     * @param discard
     */
    public void setDiscard(Date discard) {
        this.discard = discard;
    }
    
}
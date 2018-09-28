
package TreatmentModel;

import UserModel.Pharmacy;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Group 3 - Jonathan Celestin, Cynthia Hilgeman, Karin Martin, and Christopher Morris
 */

/**
 * The Prescription model represents all of the necessary components of a prescribed drug or 
 * piece of durable equipment.
 */
public class Prescription extends Pharmacy {
    
    private String pharmName;
    private String pharmAddress;
    private String pharmPhone;
    private long rxIdentificationNbr;
    private int numberRefills;
    private String doctorName;
    private int qtyFilled;
    private String drugName;
    private String drugStrength;
    private String equipmentName;
    private Boolean drugNotEquipment;
    private String instructions;
    private String pillMarkings;
    private String manufacturerName;
    private String manufacturerLocation;
    private Date written;
    private Date filled;
    private Date reorder;
    private Date discard;
    ArrayList<Drug> drug;
    ArrayList<DurableMedicalEquipment> durableMedEquip;
    ArrayList<Referral> referral;
    ArrayList<Therapy> therapy;
    
    /**
     * If the prescribed item is a drug.
     * @param phName
     * @param phAdd
     * @param phPhn
     * @param rxID
     * @param numRef
     * @param mdName
     * @param qtyF
     * @param drgNm
     * @param drgStr
     * @param drgNotEquip whether prescription is a drug
     * @param instr
     * @param pillMrk
     * @param manu
     * @param manuLoc
     * @param writ
     * @param fill
     * @param reord
     * @param disc
     */
    public Prescription(String phName, String phAdd, String phPhn, long rxID, int numRef, String mdName, 
            int qtyF, String drgNm, String drgStr, Boolean drgNotEquip, String instr, String pillMrk, String manu, String manuLoc, 
            Date writ, Date fill, Date reord, Date disc) {
        pharmName = phName;
        pharmAddress = phAdd;
        rxIdentificationNbr = rxID;
        numberRefills = numRef;
        doctorName = mdName;
        qtyFilled = qtyF;
        drugName = drgNm;
        drugStrength = drgStr;
        drugNotEquipment = drgNotEquip;
        instructions = instr;
        pillMarkings = pillMrk;
        manufacturerName = manu;
        manufacturerLocation = manuLoc;
        written = writ;
        filled = fill;
        reorder = reord;
        discard = disc;
        
    }

     /**
     * If the prescribed item is a piece of durable equipment.
     * @param phName
     * @param phAdd
     * @param phPhn
     * @param rxID
     * @param numRef
     * @param mdName
     * @param qtyF
     * @param equipNm
     * @param drgNotEquip whether prescription is a drug
     * @param instr
     * @param pillMrk
     * @param manu
     * @param manuLoc
     * @param writ
     * @param fill
     * @param reord
     * @param disc
     */
    public Prescription(String phName, String phAdd, String phPhn, long rxID, int numRef, String mdName, 
            int qtyF, String equipNm, Boolean drgNotEquip, String instr, String pillMrk, String manu, String manuLoc, 
            Date writ, Date fill, Date reord, Date disc) {
        pharmName = phName;
        pharmAddress = phAdd;
        rxIdentificationNbr = rxID;
        numberRefills = numRef;
        doctorName = mdName;
        qtyFilled = qtyF;
        equipmentName = equipNm;
        drugNotEquipment = drgNotEquip;
        instructions = instr;
        pillMarkings = pillMrk;
        manufacturerName = manu;
        manufacturerLocation = manuLoc;
        written = writ;
        filled = fill;
        reorder = reord;
        discard = disc; 
    }
    
    /**
     * Returns the name of the pharmacy.
     * @return
     */
    public String getPharmName() {
        return pharmName;
    }

    /**
     * Sets the name of the pharmacy.
     * @param pharmName
     */
    public void setPharmName(String pharmName) {
        this.pharmName = pharmName;
    }

    /**
     * Returns the address of the pharmacy.
     * @return 
     */
    public String getPharmAddress() {
        return pharmAddress;
    }

    /**
     * Sets the address of the pharmacy.
     * @param pharmAddress
     */
    public void setPharmAddress(String pharmAddress) {
        this.pharmAddress = pharmAddress;
    }

    /**
     * Returns the phone number of the pharmacy.
     * @return
     */
    public String getPharmPhone() {
        return pharmPhone;
    }

    /**
     * Sets the phone number of the pharmacy.
     * @param pharmPhone
     */
    public void setPharmPhone(String pharmPhone) {
        this.pharmPhone = pharmPhone;
    }

    /**
     * Returns the prescription identification number.
     * @return
     */
    public long getRxIdentificationNbr() {
        return rxIdentificationNbr;
    }

    /**
     * Sets the prescription identification number.
     * @param rxIdentificationNbr
     */
    public void setRxIdentificationNbr(long rxIdentificationNbr) {
        this.rxIdentificationNbr = rxIdentificationNbr;
    }

    /**
     * Returns the number of allowable refills.
     * @return
     */
    public int getNumberRefills() {
        return numberRefills;
    }

    /**
     * Sets the number of allowable refills.
     * @param numberRefills
     */
    public void setNumberRefills(int numberRefills) {
        this.numberRefills = numberRefills;
    }

    /**
     * Returns the name of the doctor.
     * @return
     */
    public String getDoctorName() {
        return doctorName;
    }

    /**
     * Sets the name of the doctor.
     * @param doctorName
     */
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    /**
     * Returns the quantity to be filled.
     * @return
     */
    public int getQtyFilled() {
        return qtyFilled;
    }

    /**
     * Sets the quantity to be filled.
     * @param qtyFilled
     */
    public void setQtyFilled(int qtyFilled) {
        this.qtyFilled = qtyFilled;
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
     * Returns the strength of the prescribed drug.
     * @return
     */
    public String getDrugStrength() {
        return drugStrength;
    }

    /**
     * Sets the strength of the prescribed drug.
     * @param drugStrength
     */
    public void setDrugStrength(String drugStrength) {
        this.drugStrength = drugStrength;
    }

    /**
     * Returns the instructions for taking the prescription.
     * @return
     */
    public String getInstructions() {
        return instructions;
    }

    /**
     * Sets the instructions for taking the prescription.
     * @param instructions
     */
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    /**
     * Returns the identification of the prescribed drug.
     * @return
     */
    public String getPillMarkings() {
        return pillMarkings;
    }

    /**
     * Sets the identification of the prescribed drug.
     * @param pillMarkings
     */
    public void setPillMarkings(String pillMarkings) {
        this.pillMarkings = pillMarkings;
    }

    /**
     * Returns the name of the manufacturer of the prescribed drug.
     * @return
     */
    public String getManufacturerName() {
        return manufacturerName;
    }

    /**
     * Sets the name of the manufacturer of the prescribed drug.
     * @param manufacturerName
     */
    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    /**
     * Returns the location of the manufacturer drug.
     * @return
     */
    public String getManufacturerLocation() {
        return manufacturerLocation;
    }

    /**
     * Sets the location of the manufacturer of the drug.
     * @param manufacturerLocation
     */
    public void setManufacturerLocation(String manufacturerLocation) {
        this.manufacturerLocation = manufacturerLocation;
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
     * Returns the date that the prescription was filled by the patient.
     * @return
     */
    public Date getFilled() {
        return filled;
    }

    /**
     * Sets the date that the prescription was filled by the patient.
     * @param filled
     */
    public void setFilled(Date filled) {
        this.filled = filled;
    }

    /**
     * Returns the quantity of allowable refills of the prescription.
     * @return
     */
    public Date getReorder() {
        return reorder;
    }

    /**
     * Sets the quantity of allowable refills of the prescription.
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

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public Boolean getDrugNotEquipment() {
        return drugNotEquipment;
    }

    public void setDrugNotEquipment(Boolean drugNotEquipment) {
        this.drugNotEquipment = drugNotEquipment;
    }
    
    
}
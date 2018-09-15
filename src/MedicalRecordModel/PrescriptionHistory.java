
package MedicalRecordModel;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Group 3 - Jonathan Celestin, Cynthia Hilgeman, Karin Martin, and Christopher Morris
 */
public class PrescriptionHistory {
    PatientProfile patientID;
    Date rXorderDate;
    Time rXorderTime;
    String physicianName;
    int rXID;
    String rXName;
    //int preferredPharmacyID;
    //String preferredPharmacyName;
    //String preferredPharmacyAddress;
    
    public PrescriptionHistory(PatientProfile linkPatientID, Date rxDate, Time rxTime, String docName,
            int rxID, String rxName){
        patientID = linkPatientID;
        rXorderDate = rxDate;
        rXorderTime = rxTime;
        physicianName = docName;
        rXID = rxID;
        rXName = rxName;
    }
}

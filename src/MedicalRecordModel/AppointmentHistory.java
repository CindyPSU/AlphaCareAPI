
package MedicalRecordModel;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Group 3 - Jonathan Celestin, Cynthia Hilgeman, Karin Martin, and Christopher Morris
 */
public class AppointmentHistory {
    PatientProfile patientID;
    Date appointmentDate;
    Time appointmentTime;
    String physicianName;
    String appointmentCode;
    String appCodeDescription;
    
    public AppointmentHistory(PatientProfile linkPatientID, Date appDate, Time appTime, 
            String docName, String appCode, String appCodeDesc){
        patientID = linkPatientID;
        appointmentDate = appDate;
        appointmentTime = appTime;
        physicianName = docName;
        appointmentCode = appCode;
        appCodeDescription = appCodeDesc;
    }
    
    
}

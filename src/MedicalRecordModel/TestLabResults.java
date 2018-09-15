
package MedicalRecordModel;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Group 3 - Jonathan Celestin, Cynthia Hilgeman, Karin Martin, and Christopher Morris
 */
public class TestLabResults {
    PatientProfile patientID;
    Date testOrderDate;
    Time testOrderTime;
    String physicianName;
    int testID;
    String testName;
    String testResult;
    
    public TestLabResults(PatientProfile linkPatientID, Date testDate, Time testTime, String docName,
            int enterTestID, String testType, String testRelease){
        patientID = linkPatientID;
        testOrderDate = testDate;
        testOrderTime = testTime;
        physicianName = docName;
        testID = enterTestID;
        testName = testType;
        testResult = testRelease;
    }
}

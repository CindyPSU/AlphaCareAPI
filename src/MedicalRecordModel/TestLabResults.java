
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
    
    /**
     * 
     * @param linkPatientID
     * @param testDate
     * @param testTime
     * @param docName
     * @param enterTestID
     * @param testType
     * @param testRelease 
     * 
     * This is the constructor for the TestLabResults Class.
     */
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
    
    /**
     * Returns the test order date.
     * @return A test order date.
     */
    public Date getTestOrderDate(){
        return testOrderDate;
    }
    
    /**
     * Returns the test order time.
     * @return A test order time.
     */
    public Time getTestOrderTime(){
        return testOrderTime;
    }
    
    /**
     * Returns the test ordering physician's name.
     * @return A physician's name.
     */
    public String getPhysicianName(){
        return physicianName;
    }
    
    /**
     * Returns the ID for the test.
     * @return A test ID.
     */
    public int getTestID(){
        return testID;
    }
    
    /**
     * Returns the test name tied to the test ID.
     * @return A test name.
     */
    public String getTestName(){
        return testName;
    }
      
    /**
     * Returns the test result tied to the test ID.
     * @return A test result.
     */
    public String getTestResult(){
        return testResult;
    }       
}

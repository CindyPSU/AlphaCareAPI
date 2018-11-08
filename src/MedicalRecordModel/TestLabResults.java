
package MedicalRecordModel;

import UserModel.Patient;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Group 3 - Jonathan Celestin, Cynthia Hilgeman, Karin Martin, and Christopher Morris
 */
public class TestLabResults {
    private Patient patientID;
    private Date testOrderDate;
    private Time testOrderTime;
    private String physicianName;
    private int testID;
    private String testName;
    private String testResult;
    
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
    public TestLabResults(Patient linkPatientID, Date testDate, Time testTime, String docName,
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

    /**
     * @return the patientID
     */
    public Patient getPatientID() {
        return patientID;
    }

    /**
     * @param patientID the patientID to set
     */
    public void setPatientID(Patient patientID) {
        this.patientID = patientID;
    }

    /**
     * @param testOrderDate the testOrderDate to set
     */
    public void setTestOrderDate(Date testOrderDate) {
        this.testOrderDate = testOrderDate;
    }

    /**
     * @param testOrderTime the testOrderTime to set
     */
    public void setTestOrderTime(Time testOrderTime) {
        this.testOrderTime = testOrderTime;
    }

    /**
     * @param physicianName the physicianName to set
     */
    public void setPhysicianName(String physicianName) {
        this.physicianName = physicianName;
    }

    /**
     * @param testID the testID to set
     */
    public void setTestID(int testID) {
        this.testID = testID;
    }

    /**
     * @param testName the testName to set
     */
    public void setTestName(String testName) {
        this.testName = testName;
    }

    /**
     * @param testResult the testResult to set
     */
    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }
    
    /**
     * Returns the patient's complete Test/Lab Results history that matches the patientID provided.
     * The patient ID is the same as the patient SSN.
     * @param patientID
     * @return An ArrayList of Test/Lab Results objects.
     */
    public static ArrayList<TestLabResults> getLabResults(String patientID){
        ArrayList<TestLabResults> labResults = new ArrayList<TestLabResults>();
        System.out.println("Test/Lab Results History will come from the DB.");
        return labResults;
    }
}

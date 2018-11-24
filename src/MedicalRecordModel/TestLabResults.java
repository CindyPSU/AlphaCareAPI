
package MedicalRecordModel;

import UserModel.Patient;
import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

/**
 *
 * @author Group 3 - Jonathan Celestin, Cynthia Hilgeman, Karin Martin, and Christopher Morris
 */
public class TestLabResults extends DatabaseObjectModel  {
    private Patient patient;
    private LocalDate testOrderDate;
    private Time testOrderTime;
    private String physicianName;
    private String testID;
    private String testName;
    private String testResult;
    
    /**
     * 
     * @param linkPatient
     * @param testDate
     * @param testTime
     * @param docName
     * @param enterTestID
     * @param testType
     * @param testRelease 
     * 
     * This is the constructor for the TestLabResults Class.
     */
    public TestLabResults(Patient linkPatient, LocalDate testDate, Time testTime, String docName,
            int enterTestID, String testType, String testRelease){
        patient = linkPatient;
        testOrderDate = testDate;
        testOrderTime = testTime;
        physicianName = docName;
        ID = enterTestID;
        testName = testType;
        testResult = testRelease;
    }

    public TestLabResults()
    {
    }

    /**
     * Returns the test order date.
     * @return A test order date.
     */
    public LocalDate getTestOrderDate(){
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
     * Returns the test ID.
     * @return A test ID.
     */
    public String getTestID(){
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
     * @return the patient
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * @param patient the patient to set
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * @param testOrderDate the testOrderDate to set
     */
    public void setTestOrderDate(LocalDate testOrderDate) {
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
     * @param testName the testName to set
     */
    public void setTestName(String testName) {
        this.testName = testName;
    }

    /**
     * @param testID the testIDto set
     */
    public void setTestID(String testID) {
        this.testID = testID;
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

    /**
     * Checks to see if the model has all the required data filled out
     * @return boolean True if the model does have all the required data filled out, false if anything is missing 
     */
    @Override
    public boolean hasAllData()
    {
        if(this.patient == null) { return false; }
        if(this.testOrderDate == null) { return false; }
        if(this.testOrderTime == null) { return false; }
        if((this.physicianName == null) || (this.physicianName.isEmpty())) { return false; }
        if((this.testID == null) || (this.testID.isEmpty())) { return false; }
        if((this.testName == null) || (this.testName.isEmpty())) { return false; }
        if((this.testResult == null) || (this.testResult.isEmpty())) { return false; }
        return true;
    }
    
    /**
     * Maps values from the model to the fields in the database
     * @return A Hashtable of fields and mapped values
     */
    @Override
    public Hashtable getMappedData()
    {
      Hashtable h = new Hashtable();
      h.put("patientID", getPatient().getIdentifier());
      h.put("testOrderDate", getTestOrderDate().format(DateTimeFormatter.ISO_LOCAL_DATE));
      h.put("testOrderTime", getTestOrderTime().toString());
      h.put("physicianName", getPhysicianName());
      h.put("testID", getTestID());
      h.put("testName", getTestName());
      h.put("testResult", getTestResult());
      return h;
    }

}

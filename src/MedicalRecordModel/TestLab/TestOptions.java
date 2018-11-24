/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MedicalRecordModel.TestLab;

/**
 *
 * @author Cindy Hilgeman (cdh5367)
 */
public class TestOptions {
    private String testName;
    
    /**
     * @return the testName
     */
    public String getTestName() {
        return testName;
    }

    /**
     * @param testName the testName to set
     */
    public void setTestName(String testName) {
        this.testName = testName;
    }
    
    @Override
    public String toString(){
        return testName;
    }
}

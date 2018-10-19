
package Utilities;

/**
 *
 * @author Cindy Hilgeman (cdh5367)
 */
public class PowerOfAttorneyAdapter implements IDigitalSigner{
    String poaContactInformation;
    
    public PowerOfAttorneyAdapter(String contactInfo){
        poaContactInformation = contactInfo; 
    }
    
    @Override
    public String digitalSign(String data) throws Exception {
        return "POA Override: "+poaContactInformation;
    }
    
}


package Utilities;

import java.security.KeyPair;
import java.security.cert.X509Certificate;

/**
 *
 * @author Cindy Hilgeman (cdh5367)
 */
public class UserDigitalSigner implements IDigitalSigner {

    private KeyPair keyPair;
    private X509Certificate certificate;
    
    public UserDigitalSigner(KeyPair pair, X509Certificate cert){
        keyPair = pair;
        certificate = cert;
    }
    
    @Override
    public String digitalSign(String data) throws Exception {
        return PKI.signData(data, keyPair, certificate);
    }
    
    // Instance of user named "Jon"
    // Anytime you need Jon's digital signature on something
    // You would call Jon.digitalSign(content that he's signing)
    public static UserDigitalSigner digitalSigner(String value) throws Exception {
        KeyPair keyPair = PKI.generateKeyPair();
        X509Certificate certificate = PKI.generateCertificate(keyPair, value);
        return new UserDigitalSigner(keyPair, certificate);
    }
}

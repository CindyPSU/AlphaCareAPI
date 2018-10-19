
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
}

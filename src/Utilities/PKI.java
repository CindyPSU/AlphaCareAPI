
package Utilities;

import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import sun.misc.BASE64Encoder;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.BasicConstraints;

import org.bouncycastle.cert.jcajce.JcaCertStore;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.cms.CMSProcessableByteArray;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.cms.CMSSignedDataGenerator;
import org.bouncycastle.cms.CMSTypedData;
import org.bouncycastle.cms.jcajce.JcaSignerInfoGeneratorBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.operator.jcajce.JcaDigestCalculatorProviderBuilder;
import org.bouncycastle.util.Store;

/**
 *
 * @author Cindy Hilgeman (cdh5367)
 */
public class PKI {
    
    // Best Practice would be to store the private key locally, but given the project application
    // it will be generated dynamically
    public static KeyPair generateKeyPair()throws Exception{
        Security.addProvider(new BouncyCastleProvider());
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(1024);
        KeyPair key = keyGen.generateKeyPair();
        return key;
    }
    
    public static X509Certificate generateCertificate(KeyPair keyPair, String name) throws OperatorCreationException, CertificateException, IOException {
    Provider bcProvider = new BouncyCastleProvider();
    Security.addProvider(bcProvider);

    long now = System.currentTimeMillis();
    Date startDate = new Date(now);

    X500Name dnName = new X500Name("CN="+name);
    BigInteger certSerialNumber = new BigInteger(Long.toString(now)); // <-- Using the current timestamp as the certificate serial number

    Calendar calendar = Calendar.getInstance();
    calendar.setTime(startDate);
    calendar.add(Calendar.YEAR, 1); // <-- 1 Yr validity

    Date endDate = calendar.getTime();

    String signatureAlgorithm = "SHA256WithRSA"; // <-- Use appropriate signature algorithm based on your keyPair algorithm.

    ContentSigner contentSigner = new JcaContentSignerBuilder(signatureAlgorithm).build(keyPair.getPrivate());

    JcaX509v3CertificateBuilder certBuilder = new JcaX509v3CertificateBuilder(dnName, certSerialNumber, startDate, endDate, dnName, keyPair.getPublic());

    // Extensions --------------------------

    // Basic Constraints
    BasicConstraints basicConstraints = new BasicConstraints(true); // <-- true for CA, false for EndEntity

    certBuilder.addExtension(new ASN1ObjectIdentifier("2.5.29.19"), true, basicConstraints); // Basic Constraints is usually marked as critical.

    // -------------------------------------

    return new JcaX509CertificateConverter().setProvider(bcProvider).getCertificate(certBuilder.build(contentSigner));
        
    }
    
    public static String signData(String data, KeyPair key, X509Certificate cert)throws Exception{
        //Sign
        PrivateKey privKey = key.getPrivate();
        Signature signature = Signature.getInstance("SHA1WithRSA", "BC");
        signature.initSign(privKey);
        signature.update(data.getBytes());

        //Build CMS
        List certList = new ArrayList();
        CMSTypedData msg = new CMSProcessableByteArray(signature.sign());
        certList.add(cert);
        Store certs = new JcaCertStore(certList);
        CMSSignedDataGenerator gen = new CMSSignedDataGenerator();
        ContentSigner sha1Signer = new JcaContentSignerBuilder("SHA1withRSA").setProvider("BC").build(privKey);
        gen.addSignerInfoGenerator(new JcaSignerInfoGeneratorBuilder(new JcaDigestCalculatorProviderBuilder().setProvider("BC").build()).build(sha1Signer, cert));
        gen.addCertificates(certs);
        CMSSignedData sigData = gen.generate(msg, false);

        BASE64Encoder encoder = new BASE64Encoder();

        String signedContent = encoder.encode((byte[]) sigData.getSignedContent().getContent());
        return signedContent;
    }
}

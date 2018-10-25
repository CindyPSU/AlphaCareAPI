Cindy Hilgeman (cdh5367)
M03-A04 Implemented Design Patterns

Object-Oriented pattern implementation: Structural, Adapter
Jar files: bcpkix-jdk15on-160.jar, bcprov-jdk15on-160.jar
Classes: UserDigitalSigner.java, PowerOfAttorneyAdapter.java, PKI.java, IDigitalSigner.java (Interface), User.java

The PKI.java class handles the generation of the public and private keys and the X509 certificate. The UserDigitalSigner 
class implements the IDigitalSigner Interface which provides access to the digitalSign method needed to obtain the digital signature 
for the user. In the User Class there is a method called getDigitalSigner that obtains the keyPair and the certificate, and allows the user
to obtain and add their digital signature to an action. There may be some circumstances where a user is unable to sign an action item, so 
there may be a neeed to have a Power of Attorney (POA) Signature in place of a user's; therefore, the PowerOfAttorneyAdapter implements 
the IDigitalSigner Interface to provide access to the digitalSign method in order to create the POA signature.

A user example of this pattern entails a physician submitting a prescription request. Only physicians can write prescriptions, so the action
will require a digital signature on the part of the physician user. Therefore, 
// prescription p = new prescription(...);
// Physician phys1 = new Physician(...);
// p.DigitallySign(phys1.getDigitalSigner());

User interface pattern implementation: Dashboard
Classes: DashboardFXML.fxml, DashboardFXMLController.java, dashboardfxml.css, AlphaCareAPI.java

When the application runs, in this present iteration, the Dashboard will be the first view to load. 
The Dashboard User Interface was built using JavaFXML (DashboardFXML.fxml) and the paired 
Controller (DashboardFXMLController.java) will handle all of the actions connected to the Dashboard. 
This current dashboard design is a skeleton of what the final will look like, as I believe I can make
it look a lot better by incorporating some css. The Controller methods are still being worked out and will
be adjusted with each use case we implement over the next few weeks. 


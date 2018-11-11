# AlphaCareAPI
M02-A01 Project Module and API Design 

**Don't forget to include JavaDoc comments to document the members of your classes in each package.**

GitHub Process
1) Create a new branch
2) git pull
3) Make sure you have selected your branch 
4) Make edits to code
5) git commit
6) git push
7) Create pull request
8) Verify that there are no code conflicts
9) Merge your branch with the master

Good Times :)

README FILE FOR REFACTORING NOTES

Chris:
1. Adding the status field to appointments
	- AppointmentStatus: A new enum that has the list of different statuses of appointments.
	- AppointmentHistory: Refactored to add an AppointmentStatus property to maintain the current status of an appointment.
	- AppointmentStoreStub: A new class that loads stubbed data on screen for testing.
	- DashboardFXMLController: Refactored to add appointment history data to the dashboard and loading stubbed data to show on screen.
2. Improve data input validation:
	- PatientInputException: Refactored by adding user-facing messages mapped from each of the error status codes.
	- PatientInputValidator: A new class that validates data inputs related to a patient.
	- PatientDetailFXMLController: Refactored to show an error message to the user when input is invalid.
3. Remove redundant patient classes:
	- Patient became PatientProfile. PatientProfile was then renamed to Patient. All of the renamed Patient’s properties were also renamed to remove the redundant naming “patient” that led each of the variable names; since they are properties inside of the Patient class, they do not need the prepending “patient,” that is inferred by their context. Finally, the User class changed its access modifiers to protected to allow Patient to access the properties when subclassing User.
4. Add an Address property to Patient:
	- Added an address property to Patient and replaced the implementations that were using a String object for the address with an Address instance.
5. Move digital signing to UserDigitalSigner
	- UserDigitalSigner: Added the signing functionality to UserDigitalSigner. The new static method takes a String argument, signs it, and returns an instance of UserDigitalSigner.
	- User: Removed the signing method all together.

Cindy - Items to Refactor
1) **System Reports** - Simplify requirement to address new system usage by medical staff
Initially, several system reports were outlined in the requirements ascertained from stakeholders; however, to ensure appropriate and consistent system usage, stakeholders have agreed to begin with system usage reporting before proceeding with more complex reporting.
2) **Tabbed or Accordion View for Patient Medical Record Interface**
Given the non-definitive aesthetic preference for either design option, the development team will proceed with the most user-friendly and pragmatic design option. To make the final decision, the development team will implement both designs and then make the aesthetic selection for the interface.

REFACTORING IN TREATMENTMODEL BY KARIN MARTIN:

DISPENSABLES - UNNECESSARY CODE/LAZY CODE
1. Removed unused class DurableMedicalEquipment.java and references to it in Prescription.java. 
2. Removed unused class Referral.java and references to it in Prescription.java.
3. Removed unused class Therapy.java and references to it in Prescription.java.
4. Removed instance variables in Prescription.java associated with DurableMedicalEquipmentljava, Referral.java and Therapy.java classes: drugName, drugStrength, equipmentName, drugNotEquipment, instructions.

BLOATER - LARGE CLASS (TOO MANY INSTANCE VARIABLES)
1. Removed unnecessary pharmName, pharmAddress, and pharmPhone variables. Replaced with Pharmacy object. Removed all the getters/setters for these.
2. Moved manufacturer name variable to Drug.java class and deleted manufacturer location after researching that it isn't on most prescription labels. Deleted getters/setters. Added getters/setters for manufacturer in Drug.java class.
3. Deleted unnecessary pillMarkings variable (duplicate code) as it is already included in Drug.java class as "drugIdentification". Deleted getters/setters.
4. Deleted unnecessary instructions variable (duplicate code) as it is already included in Drug.java class as "drugInstructions". Deleted getters/setters. 
5. Deleted doctorName variable. Info can be pulled from user currently logged in. Deleted getters/setters.
6. Renamed rxIdentificationNbr to rXID to correspond with the variable being used in the Medical Record and changed it from long to int to match as well. Changed all the getters/setters to match.
7. Deleted unnecessary variable Date filled, as that information won't be known at the time the physician writes the prescription. Deleted getters/setters.
8. Renamed qtyFilled to quantity to make more sense to the process. Changed getters/setters to match.

BLOATER - LONG PARAMETER LIST
1. Removed unnecessary parameters that corresponded to items removed from Bloater - Large Class: pharmName, pharmAdd, pharmPhn, drugNm, drgStr, drgNotEquip, instructions, pillMarkings, manufacturer name and location.
2. Added Pharmacy object parameter to replace pharmacy name, address and phone number. Edited method to match updated list of parameters.

OBJECT-ORIENTATION ABUSER - SWITCH STATEMENT (IF/ELSE IN THIS CASE)
1. 












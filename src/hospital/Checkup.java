package hospital;

public class Checkup {
private int checkupID;                                             //Encapsulation
private String patientName;
private String doctorName;
private String symptoms;
private String diagnosis;
private String medicines;
private String checkupDate;

//constructor
public Checkup(int checkupID,String patientName,String doctorName, String checkupDate) {
	this.checkupID=checkupID;
	this.patientName=patientName;
	this.doctorName=doctorName;
	this.checkupDate=checkupDate;
	this.symptoms="";
	this.diagnosis="";
	this.medicines="";
}
public int getCheckupID() {                    //getter,setter
	return checkupID;
}
public String getPatientName() {
	return patientName;

}
public void setPatientName(String patientName) {
	this.patientName=patientName;
}
public String getDoctorName() {
	return doctorName;
}
public void setDoctorName(String doctorName) {
	this.doctorName=doctorName;
}
public String getSymptoms() {
	return symptoms;
}
public void setSymptoms(String symptoms) {
	this.symptoms=symptoms;
}
public String getDiagnosis() {
	return diagnosis;
}
public void setDiagnosis(String diagnosis) {
	this.diagnosis=diagnosis;
}
public String getMedicine() {
	return medicines;
}
public void setMedicines(String medicines) {
	this.medicines=medicines;
}
public String getcheckupDate() {
	return checkupDate;
}
public void setCheckupDate(String checkupDate) {
	this.checkupDate=checkupDate;
}

public void displayCheckup() {                         // display method
	System.out.println("Checkup ID: "+ checkupID);
	System.out.println("Patient Name: " + patientName);
	System.out.println("Doctor Name: "+ doctorName);
	System.out.println("Symptoms: "+ symptoms);
	System.out.println("Diagnosis: "+ diagnosis);
	System.out.println("Medicines Prescribed: "+ medicines);
	System.out.println("Checkup Date: "+ checkupDate);
}
}

package hospital;

public class Appointment {
private int appointmentNo;                                    //Encapsulation(private)
private String patientName;
private String doctorName;
private String date;
private String time;

//parameterized constructur
public Appointment(int appointmentNo,String patientName,String doctorName,String date,String time) {    
this.appointmentNo=appointmentNo;
this.patientName=patientName;
this.doctorName=doctorName;
this.date=date;
this.time=time;
}
public int getAppointmentNo() {                           //encapsulation(getter, setter)
	return appointmentNo;
}
public void setAppointmentNO(int appointmentNo) {
	this.appointmentNo=appointmentNo;
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
	this.doctorName=doctorName;}

public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date=date;}

public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time=time;
	}
public void getDetails() {                        //Method to display details
	System.out.println("Appointment No: "+ appointmentNo);
	System.out.println("Patient Name: "+ patientName);
	System.out.println("Doctor Name: "+ doctorName);
	System.out.println("Appointment Date: "+ date);
	System.out.println("Appointment Time: " + time);
}

}


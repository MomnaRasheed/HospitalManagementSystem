package hospital;

public class Bill {
private int billID;                        //encspsulation
private String patientName;
private double checkupFee;
private double medicineFee;
private int admitDays;
private double chargesPerDay;
private double totalBill;
private boolean isPaid;

//getter and setter
public int getBillID() {                                       // no setter because value does not change
return billID;
}

public String getPatientName() {
return patientName;
}
public void setPatientName(String patientName) {
	this.patientName=patientName;
}

public double getCheckupFee() {
return checkupFee;
}
public void setCheckupFee(double checkupFee) {
	this.checkupFee=checkupFee;
}

public double getmedicineFee() {
return medicineFee;
}
public void setMedicineFee(double medicineFee) {
	this.medicineFee=medicineFee;
}

public int getAdmitDays() {
	return admitDays;
}
public void setAdmitDays(int admitDays) {
	this.admitDays=admitDays;
}

public double getchargesPerDay() {
	return chargesPerDay;
}
public void  setChargesPerDay(double chargesPerDay) {
	this.chargesPerDay=chargesPerDay;
}

public double getTotalBill() {             //no setter because value is calculated
	return totalBill;
}

public boolean getISPaid() {
	return isPaid;
}
public void setIsPaid(boolean isPaid) {
	this.isPaid=isPaid;
}




public Bill(int billID,String patientName,double checkupFee, double medicineFee)    //constructor1(for checkup)
{
	this.billID=billID;
	this.patientName=patientName;
	this.checkupFee=checkupFee;
	this.medicineFee=medicineFee;
	this.admitDays=0;
	this.chargesPerDay=0;
	this.isPaid=false;}
//constructor 2 (for admitted patient)
public Bill(int billID,String patientName,double checkupFee, double medicineFee,int admitDays,double chargesPerDay)
{
	this.billID=billID;
	this.patientName=patientName;
	this.checkupFee=checkupFee;
	this.medicineFee=medicineFee;
	this.admitDays=admitDays;
	this.chargesPerDay=chargesPerDay;
	this.isPaid=false;
}
public void calculateBill(double checkupFee, double medicineFee) {       //method to calculate bill(for only checkup)
	totalBill=checkupFee+medicineFee;
}
//method to calculate bill(for admitted patient)
public void calculateBill(double checkupFee, double medicineFee,int admitDays,double chargesPerDay)
{totalBill=checkupFee+medicineFee+(admitDays*chargesPerDay);
}

public void displayBill() {                            //method to display details
	System.out.println("Bill ID: "+billID);
	System.out.println("Patient Name: "+ patientName);
	System.out.println("Chekup Fee: "+checkupFee);
	System.out.println("Medicine Fee: "+medicineFee);
	System.out.println("Admit Days: "+ admitDays);
	System.out.println("Charges Per Day:"+chargesPerDay);
	System.out.println("Total Bill: "+ totalBill);
	System.out.println("Bill Status: "+isPaid);
	}
}

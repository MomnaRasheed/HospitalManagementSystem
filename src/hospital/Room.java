package hospital;

public class Room {
private int roomNo;                                  //Encapsulation
private String roomType;
private double chargesPerDay;

public Room(int roomNo,String roomType,double chargesPerDay) {    //Constructor
	this.roomNo=roomNo;
	this.roomType=roomType;
	this.chargesPerDay=chargesPerDay;
	
}
public int getRoomNo() {                  //Encapsulation(getter,setter)
	return roomNo;
}
public void setRoomNo(int roomNO) {
	this.roomNo=roomNo;
	
}
public String getRoomType()
{
	return roomType;
	}
public void setRoomType(String roomType) {
	this.roomType=roomType;
	
}
public double getChargesPerDay() {
	return chargesPerDay;
}
public void setChargesPerDay(double chargesPerDay) {
	this.chargesPerDay=chargesPerDay;
}
public void displayDetails() {                        //display method
	System.out.println("Room No: "+ roomNo);
	System.out.println("Room Type(General,Private,ICU): " + roomType);
	System.out.println("ChargesPerDay: "+chargesPerDay);
}
}

package hospital;

public class Patient extends Person {
private String disease;                                  //Encapsulation(private fields)
private int roomNo;

public Patient(String name,int id) {
	setName(name);
	setId(id);
}
public Patient(String name,int id,String disease,int roomNo) {
	setName(name);
	setId(id);
	this.disease=disease;                                        //this keyword: to call child object
	this.roomNo=roomNo;
}
public String getDisease() {                                     //encapsulation( getter,setters)
	return disease;
}
public void setDisease(String disease) {
	this.disease=disease;
}
public int getroomNo() {
	return roomNo;
}
public void setroomNo(int roomNo) {
	this.roomNo=roomNo;
}
@Override                                                  // Overriding parent method(function override)
public String getRole() {
	return "Patient";}
@Override                                //overriding 2nd method of Parent class(displayInfo).Polymorphism
	public void displayInfo() {          //polymorphism: method behave differently than parent class
		super.displayInfo();                                        //super: to call parent method 
		System.out.println("Disease: " + disease);
		System.out.println("RoomNo:" + roomNo);
	}
	
	
}


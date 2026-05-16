package hospital;

public class Doctor extends Person{                        //inheritance
private String specialization;                             //Encapsulation(private fields)
private double fee;
public String getSpecialization() {
	return specialization;
}
public void setSpecialization(String Specialization) {
	this.specialization=Specialization;
	
}
public double getFee() {                                 //Encapsulaton(getter,setters)
	return fee;
}
public void setFee(double fee) {
	this.fee=fee;
}
public Doctor(String name,int Id) {                     //overloading constructor 1
setName(name);
setId(Id);
}
public Doctor(String name,int id, String Specialization,double fee) {      //overloading constructor 2
	setName(name);
	setId(id);
	this.specialization=Specialization;
	this.fee=fee;
}
@Override                                        //override base classmethod(getRole)(Function overriding)
public String getRole() {
	return "Doctor";
	
}
@Override                                         //override base class method(displayInfo)(Polymorphism)
public void displayInfo() {
	super.displayInfo();
	System.out.println("specialization: " + specialization);
	System.out.println("Consultation Fee: " + fee);
}

}


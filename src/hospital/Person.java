package hospital;

abstract class Person {                     //Encapsulation(private fields)
private String name;
private  int id;
private int age;
private int phone;


public String getName()                      //getter and setter methods
{
	return name;
}
public void setName(String name) 
{
	this.name=name;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id=id;
}

public int getAge()
{
	return age;
}
public void setAge(int age) 
{
	this.age=age;
if (age<0) {
	System.out.println("invalid age,cannot be negative");
}
else
{System.out.println(this.age=age);}
}

public int getPhone(){
	return phone;
}
public void setPhone(int phone) {
    if(phone <= 0) {
        System.out.println("Invalid phone!");
    } else {
        this.phone = phone;
    }
}


 public abstract String getRole();             //abstract method to get role of person
 public void displayInfo() {                    // display method
System.out.println("Name: " + name);
System.out.println("ID: " + id);
System.out.println("Age: "+ age);
System.out.println("Phone no: " + phone);
}

}
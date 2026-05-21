package hospital;
import java.util.ArrayList;
public class Hospital {
	private ArrayList<Patient> patients;
private ArrayList<Doctor> doctors;
private ArrayList<Appointment> appointments;
private ArrayList<Checkup> checkups;
private ArrayList<Bill> bills;
private ArrayList<Room> rooms;

//Methods for all fields in MAinGUi
public ArrayList<Patient> getPatients() {
    return patients;
}

public ArrayList<Doctor> getDoctors() {
    return doctors;
}

public ArrayList<Appointment> getAppointments() {
    return appointments;
}

public ArrayList<Checkup> getCheckups() {
    return checkups;
}

public ArrayList<Bill> getBills() {
    return bills;
}

public ArrayList<Room> getRooms() {
    return rooms;
}

public Hospital() {
	patients=new ArrayList<>();
	doctors=new ArrayList<>();
	appointments=new ArrayList<>();
	checkups=new ArrayList<>();
	bills=new ArrayList<>();
	rooms=new ArrayList<>();
	
}
public void addPatient(Patient p) {                          //methods for details related to patient
	patients.add(p);
}
public Patient searchPatient(int ID) {
	for(Patient p : patients) {
        if(p.getId() == ID) {
            return p;
        }
    }
    return null;
}
public void deletePatient(int ID) {
	for(Patient p: patients) {
		if(p.getId()==ID) {
			patients.remove(p);
			break;
		}
	}

}
public void displayAllPatients() {
	for(Patient p:patients) {
		p.displayInfo();
	}
}


public void addDoctor(Doctor d) {                              //methods for details related to doctor
	doctors.add(d);
}
public Doctor searchDoctor(int ID) {
	for(Doctor d:doctors) {
		if(d.getId()==ID) {
			return d;
		}
		
	}
	return null;
}
public void deleteDoctor(int ID) {
	for(Doctor d :doctors) {
		if(d.getId()==ID) {
			doctors.remove(d);
			break;
		}
	}
}
public void displayAllDoctors() {
	for(Doctor d :doctors) {
		d.displayInfo();
	}
}


                                          
public void addAppointment(Appointment a) {                                  //methos for Appontment
	appointments.add(a);
}
public Appointment searchAppointment(int ID) {
	for(Appointment a :appointments) {
		if(a.getAppointmentNo()==ID) {
			return a;
		}
	}
	return null;
}
public void deleteAppointment(int ID) {
	for(Appointment a:appointments) {
		if(a.getAppointmentNo()==ID) {
			appointments.remove(a);
			break;
		}
	}
}
public void displayAllAppointments() {
	for(Appointment a: appointments) {
		a.getDetails();
	}
}



public void addCheckup(Checkup c) {
	checkups.add(c);
}
public Checkup searchCheckup(int ID) {
	for(Checkup c : checkups) {
		if(c.getCheckupID()==ID) {
			return c;
		}
	}
	return null;
}
public void deleteCheckup(int ID) {
	for(Checkup c:checkups) {
		if(c.getCheckupID()==ID) {
			checkups.remove(c);
			break;
		}
	}
}
public void displayAllCheckups() {
	for(Checkup c: checkups) {
		c.displayCheckup();
	}
}


public void addBill(Bill b) {                           //methods for bill
	bills.add(b);

}
public Bill searchBill(int ID) {
	for(Bill b : bills) {
		if(b.getBillID()==ID) {
			return b;
		}
	}
	return null;
}
public void deleteBill(int ID) {
	for(Bill b:bills) {
		if(b.getBillID()==ID) {
			bills.remove(b);
			break;
		}
	}
}
public void displayAllBills() {
	for(Bill b: bills) {
		b.displayBill();
	}
}



public void addRoom(Room r) {                // methods for room
	rooms.add(r);
}
public Room searchRoom(int ID) {
	for(Room r: rooms) {
		if(r.getRoomNo()==ID) {
			return r;
		}
	}
	return null;
}
public void deleteRoom(int ID) {
	for(Room r: rooms) {
		if(r.getRoomNo()==ID) {
			rooms.remove(r);
			break;
		}
	}
}
public void displayAllRooms() {
	for(Room r: rooms) {
		r.displayDetails();
	}
}
}


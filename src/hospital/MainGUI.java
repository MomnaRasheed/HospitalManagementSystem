package hospital;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainGUI extends JFrame{
	Hospital hospital;
	public MainGUI() {                              //Constructor
		hospital=new Hospital();
		setTitle("Hospital Management System");
		setSize(500,450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		//panel label
		JPanel mainPanel=new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBackground(Color.BLACK);
		
		//title label
		JLabel titleLabel = new JLabel("Hospital Management System",JLabel.CENTER);
		titleLabel.setFont(new Font("Times New Roman",Font.BOLD,24));
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));
		mainPanel.add(titleLabel,BorderLayout.NORTH);
		
		//small inside Panel
				JPanel centerPanel=new JPanel();
				centerPanel.setLayout(new GridLayout(6,1,5,5));
				centerPanel.setBackground(Color.BLACK);
				centerPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
				centerPanel.setPreferredSize(new Dimension(250,300));
				
				//create buttons
				JButton patientBtn=new JButton("Manage Patients");
				JButton doctorBtn=new JButton("Manage Doctor");
				JButton appointmentBtn=new JButton("Manage Appointment");
				JButton checkupBtn=new JButton("Manage Checkups");
				JButton billBtn=new JButton("Manage Bills");
				JButton roomBtn=new JButton("Manage Rooms");
				
				//color for buttons
				Color darkBlue=new Color(0,51,102);
				patientBtn.setBackground(darkBlue);
				patientBtn.setForeground(Color.WHITE);
				patientBtn.setFont(new Font("Times New Roman",Font.BOLD,14));
				
				doctorBtn.setBackground(darkBlue);
				doctorBtn.setForeground(Color.WHITE);
				doctorBtn.setFont(new Font("Times New Roman",Font.BOLD,14));
				
				appointmentBtn.setBackground(darkBlue);
				appointmentBtn.setForeground(Color.WHITE);
				appointmentBtn.setFont(new Font("Times New Roman",Font.BOLD,14));
				
				checkupBtn.setBackground(darkBlue);
				checkupBtn.setForeground(Color.WHITE);
				checkupBtn.setFont(new Font("Times New Roman",Font.BOLD,14));
				
				billBtn.setBackground(darkBlue);
				billBtn.setForeground(Color.WHITE);
				billBtn.setFont(new Font("Times New Roman",Font.BOLD,14));
				
				roomBtn.setBackground(darkBlue);
				roomBtn.setForeground(Color.WHITE);
				roomBtn.setFont(new Font("Times New Roman",Font.BOLD,14));
				
//adding buttons to panel
		centerPanel.add(patientBtn);
		centerPanel.add(doctorBtn);
		centerPanel.add(appointmentBtn);
		centerPanel.add(checkupBtn);
		centerPanel.add(billBtn);
		centerPanel.add(roomBtn);
		
		//wrap panel
		JPanel wrapperPanel=new JPanel(new GridBagLayout());
		wrapperPanel.setBackground(Color.BLACK);
		wrapperPanel.add(centerPanel);
		mainPanel.add(wrapperPanel,BorderLayout.CENTER);
		add(mainPanel);
		setVisible(true);
		 
		//Action listeners for buttons
		patientBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openPatientWindow();
			}
		});
		
		doctorBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        openDoctorWindow();
		    }
		});

		appointmentBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        openAppointmentWindow();
		    }
		});

		checkupBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        openCheckupWindow();
		    }
		});

		billBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        openBillWindow();
		    }
		});

		roomBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        openRoomWindow();
		    }
		});
		
		
	}
	// display of patient button
		public void openPatientWindow() {
		    JDialog dialog = new JDialog(this, "Manage Patients", true);
		    dialog.setSize(500, 400);
		    dialog.setLocationRelativeTo(null);
		    dialog.setLayout(new BorderLayout());

		    // Input Panel
		    JPanel inputPanel = new JPanel(new GridLayout(5, 2, 5, 5));

		    JLabel nameLabel = new JLabel("Name:");
		    JTextField nameField = new JTextField();

		    JLabel idLabel = new JLabel("ID:");
		    JTextField idField = new JTextField();

		    JLabel ageLabel = new JLabel("Age:");
		    JTextField ageField = new JTextField();

		    JLabel diseaseLabel = new JLabel("Disease:");
		    JTextField diseaseField = new JTextField();

		    inputPanel.add(nameLabel);
		    inputPanel.add(nameField);
		    inputPanel.add(idLabel);
		    inputPanel.add(idField);
		    inputPanel.add(ageLabel);
		    inputPanel.add(ageField);
		    inputPanel.add(diseaseLabel);
		    inputPanel.add(diseaseField);

		    // Button Panel
		    JPanel btnPanel = new JPanel();
		    JButton addBtn = new JButton("Add");
		    JButton searchBtn = new JButton("Search");
		    JButton deleteBtn = new JButton("Delete");
		    JButton displayBtn = new JButton("Display All");

		    btnPanel.add(addBtn);
		    btnPanel.add(searchBtn);
		    btnPanel.add(deleteBtn);
		    btnPanel.add(displayBtn);

		    // Output Area
		    JTextArea outputArea = new JTextArea(10, 40);
		    outputArea.setEditable(false);
		    JScrollPane scrollPane = new JScrollPane(outputArea);

		    dialog.add(inputPanel, BorderLayout.NORTH);
		    dialog.add(btnPanel, BorderLayout.CENTER);
		    dialog.add(scrollPane, BorderLayout.SOUTH);
		    addBtn.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            try {
		                String name = nameField.getText();
		                int id = Integer.parseInt(idField.getText());
		                int age = Integer.parseInt(ageField.getText());
		                String disease = diseaseField.getText();
		                if(name.isEmpty() || disease.isEmpty()) {
		                    JOptionPane.showMessageDialog(dialog,
		                        "Please fill all fields!");
		                    return;
		                }
		                Patient p = new Patient(name, id, disease, age);
		                hospital.addPatient(p);
		                outputArea.append("Patient added: " + name + "\n");
		                nameField.setText("");
		                idField.setText("");
		                ageField.setText("");
		                diseaseField.setText("");
		            } catch(NumberFormatException ex) {
		                JOptionPane.showMessageDialog(dialog,
		                    "Please enter valid ID and Age!");
		            }
		        }
		    });

		    searchBtn.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            try {
		                int id = Integer.parseInt(idField.getText());
		                Patient p = hospital.searchPatient(id);
		                if(p != null) {
		                    outputArea.append("Found: " + p.getName() +
		                        " Disease: " + p.getDisease() + "\n");
		                } else {
		                    JOptionPane.showMessageDialog(dialog,
		                        "Patient not found!");
		                }
		            } catch(NumberFormatException ex) {
		                JOptionPane.showMessageDialog(dialog,
		                    "Please enter valid ID!");
		            }
		        }
		    });

		    deleteBtn.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            try {
		                int id = Integer.parseInt(idField.getText());
		                hospital.deletePatient(id);
		                outputArea.append("Patient deleted!\n");
		            } catch(NumberFormatException ex) {
		                JOptionPane.showMessageDialog(dialog,
		                    "Please enter valid ID!");
		            }
		        }
		    });

		    displayBtn.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            outputArea.setText("");
		            for(Patient p : hospital.getPatients()) {
		                outputArea.append(
		                    "ID: " + p.getId() +
		                    " Name: " + p.getName() +
		                    " Disease: " + p.getDisease() + "\n");
		            }
		        }
		    });

		    dialog.setVisible(true);
		
		
	}
	// for doctor button
		public void openDoctorWindow() {
		    JDialog dialog = new JDialog(this, "Manage Doctors", true);
		    dialog.setSize(500, 400);
		    dialog.setLocationRelativeTo(null);
		    dialog.setLayout(new BorderLayout());

		    JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));

		    JLabel nameLabel = new JLabel("Name:");
		    JTextField nameField = new JTextField();
		    JLabel idLabel = new JLabel("ID:");
		    JTextField idField = new JTextField();
		    JLabel specLabel = new JLabel("Specialization:");
		    JTextField specField = new JTextField();
		    JLabel feeLabel = new JLabel("Fee:");
		    JTextField feeField = new JTextField();

		    inputPanel.add(nameLabel); inputPanel.add(nameField);
		    inputPanel.add(idLabel); inputPanel.add(idField);
		    inputPanel.add(specLabel); inputPanel.add(specField);
		    inputPanel.add(feeLabel); inputPanel.add(feeField);

		    JPanel btnPanel = new JPanel();
		    JButton addBtn = new JButton("Add");
		    JButton searchBtn = new JButton("Search");
		    JButton deleteBtn = new JButton("Delete");
		    JButton displayBtn = new JButton("Display All");

		    btnPanel.add(addBtn);
		    btnPanel.add(searchBtn);
		    btnPanel.add(deleteBtn);
		    btnPanel.add(displayBtn);

		    JTextArea outputArea = new JTextArea(10, 40);
		    outputArea.setEditable(false);
		    JScrollPane scrollPane = new JScrollPane(outputArea);

		    // Add Button Action
		    addBtn.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            try {
		                String name = nameField.getText();
		                int id = Integer.parseInt(idField.getText());
		                String spec = specField.getText();
		                double fee = Double.parseDouble(feeField.getText());
		                if(name.isEmpty() || spec.isEmpty()) {
		                    JOptionPane.showMessageDialog(dialog,
		                        "Please fill all fields!");
		                    return;
		                }
		                Doctor d = new Doctor(name, id, spec, fee);
		                hospital.addDoctor(d);
		                outputArea.append("Doctor added: " + name + "\n");
		                nameField.setText("");
		                idField.setText("");
		                specField.setText("");
		                feeField.setText("");
		            } catch(NumberFormatException ex) {
		                JOptionPane.showMessageDialog(dialog,
		                    "Please enter valid ID and Fee!");
		            }
		        }
		    });

		    // Search Button Action
		    searchBtn.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            try {
		                int id = Integer.parseInt(idField.getText());
		                Doctor d = hospital.searchDoctor(id);
		                if(d != null) {
		                    outputArea.append("Found: " + d.getName() + "\n");
		                } else {
		                    JOptionPane.showMessageDialog(dialog,
		                        "Doctor not found!");
		                }
		            } catch(NumberFormatException ex) {
		                JOptionPane.showMessageDialog(dialog,
		                    "Please enter valid ID!");
		            }
		        }
		    });

		    // Delete Button Action
		    deleteBtn.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            try {
		                int id = Integer.parseInt(idField.getText());
		                hospital.deleteDoctor(id);
		                outputArea.append("Doctor deleted!\n");
		            } catch(NumberFormatException ex) {
		                JOptionPane.showMessageDialog(dialog,
		                    "Please enter valid ID!");
		            }
		        }
		    });

		    // Display Button Action
		    displayBtn.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            outputArea.setText("");
		            for(Doctor d : hospital.getDoctors()) {
		                outputArea.append(
		                    "ID: " + d.getId() +
		                    " Name: " + d.getName() +
		                    " Spec: " + d.getSpecialization() +
		                    " Fee: " + d.getFee() + "\n");
		            }
		        }
		    });

		    dialog.add(inputPanel, BorderLayout.NORTH);
		    dialog.add(btnPanel, BorderLayout.CENTER);
		    dialog.add(scrollPane, BorderLayout.SOUTH);
		    dialog.setVisible(true);
		}
		// for Appointment btn
		public void openAppointmentWindow() {
		    JDialog dialog = new JDialog(this, "Manage Appointments", true);
		    dialog.setSize(500, 400);
		    dialog.setLocationRelativeTo(null);
		    dialog.setLayout(new BorderLayout());

		    JPanel inputPanel = new JPanel(new GridLayout(5, 2, 5, 5));

		    JLabel appNoLabel = new JLabel("Appointment No:");
		    JTextField appNoField = new JTextField();
		    JLabel patientLabel = new JLabel("Patient Name:");
		    JTextField patientField = new JTextField();
		    JLabel doctorLabel = new JLabel("Doctor Name:");
		    JTextField doctorField = new JTextField();
		    JLabel dateLabel = new JLabel("Date:");
		    JTextField dateField = new JTextField();
		    JLabel timeLabel = new JLabel("Time:");
		    JTextField timeField = new JTextField();

		    inputPanel.add(appNoLabel); inputPanel.add(appNoField);
		    inputPanel.add(patientLabel); inputPanel.add(patientField);
		    inputPanel.add(doctorLabel); inputPanel.add(doctorField);
		    inputPanel.add(dateLabel); inputPanel.add(dateField);
		    inputPanel.add(timeLabel); inputPanel.add(timeField);

		    JPanel btnPanel = new JPanel();
		    JButton addBtn = new JButton("Add");
		    JButton searchBtn = new JButton("Search");
		    JButton deleteBtn = new JButton("Delete");
		    JButton displayBtn = new JButton("Display All");

		    btnPanel.add(addBtn); btnPanel.add(searchBtn);
		    btnPanel.add(deleteBtn); btnPanel.add(displayBtn);

		    JTextArea outputArea = new JTextArea(10, 40);
		    outputArea.setEditable(false);
		    JScrollPane scrollPane = new JScrollPane(outputArea);

		    addBtn.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            try {
		                int appNo = Integer.parseInt(appNoField.getText());
		                String patient = patientField.getText();
		                String doctor = doctorField.getText();
		                String date = dateField.getText();
		                String time = timeField.getText();
		                if(patient.isEmpty() || doctor.isEmpty()) {
		                    JOptionPane.showMessageDialog(dialog,
		                        "Please fill all fields!");
		                    return;
		                }
		                Appointment a = new Appointment(
		                    appNo, patient, doctor, date, time);
		                hospital.addAppointment(a);
		                outputArea.append("Appointment added!\n");
		                appNoField.setText(""); patientField.setText("");
		                doctorField.setText(""); dateField.setText("");
		                timeField.setText("");
		            } catch(NumberFormatException ex) {
		                JOptionPane.showMessageDialog(dialog,
		                    "Please enter valid Appointment No!");
		            }
		        }
		    });

		    displayBtn.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            outputArea.setText("");
		            for(Appointment a : hospital.getAppointments()) {
		                outputArea.append(
		                    "No: " + a.getAppointmentNo() +
		                    " Patient: " + a.getPatientName() +
		                    " Doctor: " + a.getDoctorName() +
		                    " Date: " + a.getDate() + "\n");
		            }
		        }
		    });

		    dialog.add(inputPanel, BorderLayout.NORTH);
		    dialog.add(btnPanel, BorderLayout.CENTER);
		    dialog.add(scrollPane, BorderLayout.SOUTH);
		    searchBtn.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            try {
		                int id = Integer.parseInt(appNoField.getText());
		                Appointment a = hospital.searchAppointment(id);
		                if(a != null) {
		                    outputArea.append("Found: No=" + a.getAppointmentNo() +
		                        " Patient=" + a.getPatientName() + "\n");
		                } else {
		                    JOptionPane.showMessageDialog(dialog,
		                        "Appointment not found!");
		                }
		            } catch(NumberFormatException ex) {
		                JOptionPane.showMessageDialog(dialog,
		                    "Please enter valid ID!");
		            }
		        }
		    });

		    deleteBtn.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            try {
		                int id = Integer.parseInt(appNoField.getText());
		                hospital.deleteAppointment(id);
		                outputArea.append("Appointment deleted!\n");
		            } catch(NumberFormatException ex) {
		                JOptionPane.showMessageDialog(dialog,
		                    "Please enter valid ID!");
		            }
		        }
		    });
		    dialog.setVisible(true);
		}
		//for checkup btn
		public void openCheckupWindow() {
		    JDialog dialog = new JDialog(this, "Manage Checkups", true);
		    dialog.setSize(500, 400);
		    dialog.setLocationRelativeTo(null);
		    dialog.setLayout(new BorderLayout());

		    JPanel inputPanel = new JPanel(new GridLayout(7, 2, 5, 5));

		    JLabel idLabel = new JLabel("Checkup ID:");
		    JTextField idField = new JTextField();
		    JLabel patientLabel = new JLabel("Patient Name:");
		    JTextField patientField = new JTextField();
		    JLabel doctorLabel = new JLabel("Doctor Name:");
		    JTextField doctorField = new JTextField();
		    JLabel symptomsLabel = new JLabel("Symptoms:");
		    JTextField symptomsField = new JTextField();
		    JLabel diagnosisLabel = new JLabel("Diagnosis:");
		    JTextField diagnosisField = new JTextField();
		    JLabel medicineLabel = new JLabel("Medicine:");
		    JTextField medicineField = new JTextField();
		    JLabel dateLabel = new JLabel("Date:");
		    JTextField dateField = new JTextField();

		    inputPanel.add(idLabel); inputPanel.add(idField);
		    inputPanel.add(patientLabel); inputPanel.add(patientField);
		    inputPanel.add(doctorLabel); inputPanel.add(doctorField);
		    inputPanel.add(symptomsLabel); inputPanel.add(symptomsField);
		    inputPanel.add(diagnosisLabel); inputPanel.add(diagnosisField);
		    inputPanel.add(medicineLabel); inputPanel.add(medicineField);
		    inputPanel.add(dateLabel); inputPanel.add(dateField);

		    JPanel btnPanel = new JPanel();
		    JButton addBtn = new JButton("Add");
		    JButton searchBtn = new JButton("Search");
		    JButton deleteBtn = new JButton("Delete");
		    JButton displayBtn = new JButton("Display All");

		    btnPanel.add(addBtn); btnPanel.add(searchBtn);
		    btnPanel.add(deleteBtn); btnPanel.add(displayBtn);

		    JTextArea outputArea = new JTextArea(10, 40);
		    outputArea.setEditable(false);
		    JScrollPane scrollPane = new JScrollPane(outputArea);

		    addBtn.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            try {
		                int id = Integer.parseInt(idField.getText());
		                String patient = patientField.getText();
		                String doctor = doctorField.getText();
		                String date = dateField.getText();
		                if(patient.isEmpty() || doctor.isEmpty()) {
		                    JOptionPane.showMessageDialog(dialog,
		                        "Please fill all fields!");
		                    return;
		                }
		                Checkup c = new Checkup(id, patient, doctor, date);
		                c.setSymptoms(symptomsField.getText());
		                c.setDiagnosis(diagnosisField.getText());
		                c.setMedicines(medicineField.getText());
		                hospital.addCheckup(c);
		                outputArea.append("Checkup added!\n");
		                idField.setText(""); patientField.setText("");
		                doctorField.setText(""); dateField.setText("");
		                symptomsField.setText(""); diagnosisField.setText("");
		                medicineField.setText("");
		            } catch(NumberFormatException ex) {
		                JOptionPane.showMessageDialog(dialog,
		                    "Please enter valid ID!");
		            }
		        }
		    });
		    searchBtn.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            try {
		                int id = Integer.parseInt(idField.getText());
		                Checkup c = hospital.searchCheckup(id);
		                if(c != null) {
		                    outputArea.append("Found: ID=" + c.getCheckupID() +
		                        " Patient=" + c.getPatientName() + "\n");
		                } else {
		                    JOptionPane.showMessageDialog(dialog,
		                        "Checkup not found!");
		                }
		            } catch(NumberFormatException ex) {
		                JOptionPane.showMessageDialog(dialog,
		                    "Please enter valid ID!");
		            }
		        }
		    });

		    deleteBtn.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            try {                                                      // error handling
		                int id = Integer.parseInt(idField.getText());
		                hospital.deleteCheckup(id);
		                outputArea.append("Checkup deleted!\n");
		            } catch(NumberFormatException ex) {
		                JOptionPane.showMessageDialog(dialog,
		                    "Please enter valid ID!");
		            }
		        }
		    });

		    displayBtn.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            outputArea.setText("");
		            for(Checkup c : hospital.getCheckups()) {
		                outputArea.append(
		                    "ID: " + c.getCheckupID() +
		                    " Patient: " + c.getPatientName() +
		                    " Doctor: " + c.getDoctorName() +
		                    " Date: " + c.getcheckupDate() + "\n");
		            }
		        }
		    });

		    dialog.add(inputPanel, BorderLayout.NORTH);
		    dialog.add(btnPanel, BorderLayout.CENTER);
		    dialog.add(scrollPane, BorderLayout.SOUTH);
		    dialog.setVisible(true);
		}
		
		//for bill btn
		public void openBillWindow() {
		    JDialog dialog = new JDialog(this, "Manage Bills", true);
		    dialog.setSize(500, 400);
		    dialog.setLocationRelativeTo(null);
		    dialog.setLayout(new BorderLayout());

		    JPanel inputPanel = new JPanel(new GridLayout(6, 2, 5, 5));

		    JLabel idLabel = new JLabel("Bill ID:");
		    JTextField idField = new JTextField();
		    JLabel patientLabel = new JLabel("Patient Name:");
		    JTextField patientField = new JTextField();
		    JLabel checkupFeeLabel = new JLabel("Checkup Fee:");
		    JTextField checkupFeeField = new JTextField();
		    JLabel medicineFeeLabel = new JLabel("Medicine Fee:");
		    JTextField medicineFeeField = new JTextField();
		    JLabel daysLabel = new JLabel("Admit Days:");
		    JTextField daysField = new JTextField();
		    JLabel chargesLabel = new JLabel("Charges Per Day:");
		    JTextField chargesField = new JTextField();

		    inputPanel.add(idLabel); inputPanel.add(idField);
		    inputPanel.add(patientLabel); inputPanel.add(patientField);
		    inputPanel.add(checkupFeeLabel); inputPanel.add(checkupFeeField);
		    inputPanel.add(medicineFeeLabel); inputPanel.add(medicineFeeField);
		    inputPanel.add(daysLabel); inputPanel.add(daysField);
		    inputPanel.add(chargesLabel); inputPanel.add(chargesField);

		    JPanel btnPanel = new JPanel();
		    JButton addBtn = new JButton("Add");
		    JButton searchBtn = new JButton("Search");
		    JButton deleteBtn = new JButton("Delete");
		    JButton displayBtn = new JButton("Display All");

		    btnPanel.add(addBtn); btnPanel.add(searchBtn);
		    btnPanel.add(deleteBtn); btnPanel.add(displayBtn);

		    JTextArea outputArea = new JTextArea(10, 40);
		    outputArea.setEditable(false);
		    JScrollPane scrollPane = new JScrollPane(outputArea);

		    addBtn.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            try {                                                              // error handlimg (try catch)
		                int id = Integer.parseInt(idField.getText());
		                String patient = patientField.getText();
		                double checkupFee = Double.parseDouble(
		                    checkupFeeField.getText());
		                double medicineFee = Double.parseDouble(
		                    medicineFeeField.getText());
		                int days = Integer.parseInt(daysField.getText());
		                double charges = Double.parseDouble(
		                    chargesField.getText());
		                Bill b = new Bill(id, patient, checkupFee,
		                    medicineFee, days, charges);
		                b.calculateBill(checkupFee, medicineFee,
		                    days, charges);
		                hospital.addBill(b);
		                outputArea.append("Bill added! Total: " +
		                    b.getTotalBill() + "\n");
		                idField.setText(""); patientField.setText("");
		                checkupFeeField.setText(""); medicineFeeField.setText("");
		                daysField.setText(""); chargesField.setText("");
		            } catch(NumberFormatException ex) {                  
		                JOptionPane.showMessageDialog(dialog,
		                    "Please enter valid numbers!");
		            }
		        }
		    });
		    searchBtn.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            try {
		                int id = Integer.parseInt(idField.getText());
		                Bill b = hospital.searchBill(id);
		                if(b != null) {
		                    outputArea.append("Found: ID=" + b.getBillID() +
		                        " Patient=" + b.getPatientName() +
		                        " Total=" + b.getTotalBill() + "\n");
		                } else {
		                    JOptionPane.showMessageDialog(dialog,
		                        "Bill not found!");
		                }
		            } catch(NumberFormatException ex) {                 // error handling
		                JOptionPane.showMessageDialog(dialog,
		                    "Please enter valid ID!");
		            }
		        }
		    });

		    deleteBtn.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            try {
		                int id = Integer.parseInt(idField.getText());
		                hospital.deleteBill(id);
		                outputArea.append("Bill deleted!\n");
		            } catch(NumberFormatException ex) {
		                JOptionPane.showMessageDialog(dialog,
		                    "Please enter valid ID!");
		            }
		        }
		    });

		    displayBtn.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            outputArea.setText("");
		            for(Bill b : hospital.getBills()) {
		                outputArea.append(
		                    "ID: " + b.getBillID() +
		                    " Patient: " + b.getPatientName() +
		                    " Total: " + b.getTotalBill() + "\n");
		            }
		        }
		    });

		    dialog.add(inputPanel, BorderLayout.NORTH);
		    dialog.add(btnPanel, BorderLayout.CENTER);
		    dialog.add(scrollPane, BorderLayout.SOUTH);
		    dialog.setVisible(true);
		}
		
		//for room btn
		public void openRoomWindow() {
		    JDialog dialog = new JDialog(this, "Manage Rooms", true);
		    dialog.setSize(500, 400);
		    dialog.setLocationRelativeTo(null);
		    dialog.setLayout(new BorderLayout());

		    JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));

		    JLabel roomNoLabel = new JLabel("Room No:");
		    JTextField roomNoField = new JTextField();
		    JLabel roomTypeLabel = new JLabel("Room Type:");
		    JTextField roomTypeField = new JTextField();
		    JLabel chargesLabel = new JLabel("Charges Per Day:");
		    JTextField chargesField = new JTextField();

		    inputPanel.add(roomNoLabel); inputPanel.add(roomNoField);
		    inputPanel.add(roomTypeLabel); inputPanel.add(roomTypeField);
		    inputPanel.add(chargesLabel); inputPanel.add(chargesField);

		    JPanel btnPanel = new JPanel();
		    JButton addBtn = new JButton("Add");
		    JButton searchBtn = new JButton("Search");
		    JButton deleteBtn = new JButton("Delete");
		    JButton displayBtn = new JButton("Display All");

		    btnPanel.add(addBtn); btnPanel.add(searchBtn);
		    btnPanel.add(deleteBtn); btnPanel.add(displayBtn);

		    JTextArea outputArea = new JTextArea(10, 40);
		    outputArea.setEditable(false);
		    JScrollPane scrollPane = new JScrollPane(outputArea);

		    addBtn.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            try {
		                int roomNo = Integer.parseInt(roomNoField.getText());
		                String roomType = roomTypeField.getText();
		                double charges = Double.parseDouble(
		                    chargesField.getText());
		                if(roomType.isEmpty()) {
		                    JOptionPane.showMessageDialog(dialog,
		                        "Please fill all fields!");
		                    return;
		                }
		                Room r = new Room(roomNo, roomType, charges);
		                hospital.addRoom(r);
		                outputArea.append("Room added: " + roomNo + "\n");
		                roomNoField.setText(""); roomTypeField.setText("");
		                chargesField.setText("");
		            } catch(NumberFormatException ex) {
		                JOptionPane.showMessageDialog(dialog,
		                    "Please enter valid numbers!");
		            }
		        }
		    });
		    searchBtn.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            try {
		                int roomNo = Integer.parseInt(roomNoField.getText());
		                Room r = hospital.searchRoom(roomNo);
		                if(r != null) {
		                    outputArea.append("Found: RoomNo=" + r.getRoomNo() +
		                        " Type=" + r.getRoomType() + "\n");
		                } else {
		                    JOptionPane.showMessageDialog(dialog,
		                        "Room not found!");
		                }
		            } catch(NumberFormatException ex) {
		                JOptionPane.showMessageDialog(dialog,
		                    "Please enter valid Room No!");
		            }
		        }
		    });

		    deleteBtn.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            try {
		                int roomNo = Integer.parseInt(roomNoField.getText());
		                hospital.deleteRoom(roomNo);
		                outputArea.append("Room deleted!\n");
		            } catch(NumberFormatException ex) {
		                JOptionPane.showMessageDialog(dialog,
		                    "Please enter valid Room No!");
		            }
		        }
		    });
		    displayBtn.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            outputArea.setText("");
		            for(Room r : hospital.getRooms()) {
		                outputArea.append(
		                    "Room No: " + r.getRoomNo() +
		                    " Type: " + r.getRoomType() +
		                    " Charges: " + r.getChargesPerDay() + "\n");
		            }
		        }
		    });

		    dialog.add(inputPanel, BorderLayout.NORTH);
		    dialog.add(btnPanel, BorderLayout.CENTER);
		    dialog.add(scrollPane, BorderLayout.SOUTH);
		    dialog.setVisible(true);
		}
		
		
		
	

	public static void main(String[] args) {
		new MainGUI();
		// TODO Auto-generated method stub
	}

}

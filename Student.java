import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class HostelManagementSystem extends Frame implements ActionListener {
    private ArrayList<Student> students = new ArrayList<Student>();
    private Hostel hostel = new Hostel(100, "Single", 50);

    private Label nameLabel, ageLabel, genderLabel, phoneLabel, roomLabel;
    private TextField nameField, ageField, genderField, phoneField, roomField;
    private Button addButton, removeButton, updateButton, displayButton, searchButton;

    public HostelManagementSystem() {
        setLayout(new GridLayout(6, 1));

        nameLabel = new Label("Name:");
        add(nameLabel);
        nameField = new TextField(20);
        add(nameField);

        ageLabel = new Label("Age:");
        add(ageLabel);
        ageField = new TextField(20);
        add(ageField);

        genderLabel = new Label("Gender:");
        add(genderLabel);
        genderField = new TextField(20);
        add(genderField);

        phoneLabel = new Label("Phone:");
        add(phoneLabel);
        phoneField = new TextField(20);
        add(phoneField);

        roomLabel = new Label("Room No.:");
        add(roomLabel);
        roomField = new TextField(20);
        add(roomField);

        addButton = new Button("Add Student");
        addButton.addActionListener(this);
        add(addButton);

        removeButton = new Button("Remove Student");
        removeButton.addActionListener(this);
        add(removeButton);

        updateButton = new Button("Update Student");
        updateButton.addActionListener(this);
        add(updateButton);

        displayButton = new Button("Display Details");
        displayButton.addActionListener(this);
        add(displayButton);

        searchButton = new Button("Search Student");
        searchButton.addActionListener(this);
        add(searchButton);

        setTitle("Hostel Management System");
        setSize(800, 800);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String gender = genderField.getText();
            String phone = phoneField.getText();
            int roomNo = Integer.parseInt(roomField.getText());
            Student student = new Student(name, age, gender, phone, roomNo);
            students.add(student);
            hostel.addOccupancy(roomNo);
            System.out.println("Student added successfully!");
        } else if (e.getSource() == removeButton) {
            int roomNo = Integer.parseInt(roomField.getText());
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getRoomNo() == roomNo) {
                    students.remove(i);
                    hostel.removeOccupancy(roomNo);
                    System.out.println("Student removed successfully!");
                    break;
                }
            }
        } else if (e.getSource() == updateButton) {
            int roomNo = Integer.parseInt(roomField.getText());
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getRoomNo() == roomNo) {
                    students.get(i).setName(nameField.getText());
                    students.get(i).setAge(Integer.parseInt(ageField.getText()));
                    students.get(i).setGender(genderField.getText());
                    students.get(i).setPhone(phoneField.getText());
                    System.out.println("Student details updated successfully!");
                    break;
                }
            }
        } else if (e.getSource() == displayButton) {
            System.out.println("Hostel Details:");
            System.out.println("No. of rooms: " + hostel.getNoOfRooms());
           
            System.out.println("Room type: " + hostel.getRoomType());
            System.out.println("Occupancy: " + hostel.getOccupancy());
            System.out.println("Available rooms: " + hostel.getAvailableRooms());
            System.out.println("Student Details:");
            for (Student student : students) {
                System.out.println("Name: " + student.getName());
                System.out.println("Age: " + student.getAge());
                System.out.println("Gender: " + student.getGender());
                System.out.println("Phone: " + student.getPhone());
                System.out.println("Room No.: " + student.getRoomNo());
            }
        } else if (e.getSource() == searchButton) {
            int roomNo = Integer.parseInt(roomField.getText());
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getRoomNo() == roomNo) {
                    nameField.setText(students.get(i).getName());
                    ageField.setText(Integer.toString(students.get(i).getAge()));
                    genderField.setText(students.get(i).getGender());
                    phoneField.setText(students.get(i).getPhone());
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        HostelManagementSystem hostelManagementSystem = new HostelManagementSystem();
    }
}

class Hostel {
    private int noOfRooms;
    private String roomType;
    private int occupancy;

    public Hostel(int noOfRooms, String roomType, int occupancy) {
        this.noOfRooms = noOfRooms;
        this.roomType = roomType;
        this.occupancy = occupancy;
    }

    public int getNoOfRooms() {
        return noOfRooms;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getOccupancy() {
        return occupancy;
    }

    public int getAvailableRooms() {
        return noOfRooms - occupancy;
    }

    public void addOccupancy(int roomNo) {
        occupancy++;
    }

    public void removeOccupancy(int roomNo) {
        occupancy--;
    }
}

class Student {
    private String name;
    private int age;
    private String gender;
    private String phone;
    private int roomNo;

    public Student(String name, int age, String gender, String phone, int roomNo) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.roomNo = roomNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRoomNo() {
        return roomNo;
    }
}


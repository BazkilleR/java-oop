package two;

import java.io.*;

// Student class represents a student with ID, name, and money balance
public class Student implements Serializable {

    private String name;
    private int ID;
    private int money;

    // Default constructor
    public Student() {
        this("", 0, 0);
    }

    // Constructor with parameters
    public Student(String name, int ID, int money) {
        this.name = name;
        this.ID = ID;
        this.money = money;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    // Deposit money (+100)
    public void deposit() {
        this.money += 100;
    }

    // Withdraw money (-100), ensuring balance doesn't go negative
    public void withdraw() {
        if (this.money >= 100) {
            this.money -= 100;
        } else {
            System.out.println("Not enough balance!");
        }
    }

    // Save student object to a file
    public static void saveStudent(Student student, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load student object from a file (returns a new student if file doesn't exist)
    public static Student loadStudent(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            return new Student();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (Student) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new Student();
        }
    }
}

package Baitap.Bai10;

import java.io.Serializable;
import java.util.Scanner;

public class Student implements Serializable {
    private static int isSequece = 0;
    private int id;
    private String name;
    private String major;
    private double gpa;

    public Student() {
        this.id = ++isSequece;
    }

    public Student(String name, String majpr, double gpa) {
        this.id = ++isSequece;
        this.name = name;
        this.major = majpr;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void getMajor(String major) {
        this.major = this.major;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void inputData(Scanner scanner) {
        System.out.print("Nhập tên học sinh: ");
        this.name = scanner.nextLine();
        System.out.print("Nhập chuyên ngành sinh viên: ");
        this.major = scanner.nextLine();
        System.out.println("Nhập điểm trung bình của học sinh: ");
        this.gpa = Double.parseDouble(scanner.nextLine());
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Majpr: " + major + ", GPA: " + gpa;
    }
}

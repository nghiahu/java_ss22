package Baitap.Bai10;

import java.io.*;
import java.util.*;

public class StudentManager {
    static List<Student> students = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("*******************MENU******************");
            System.out.println("1. Thêm sinh viên vào danh sách.");
            System.out.println("2. Ghi toàn bộ danh sách ra file nhị phân.");
            System.out.println("3. Đọc danh sách từ file.");
            System.out.println("4. Tìm sinh viên có GPA cao nhất.");
            System.out.println("5. Tìm danh sách sinh viên theo chuyên ngành.");
            System.out.println("6. Tính điểm trung bình GPA của toàn bộ danh sách.");
            System.out.println("7. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    saveToFile("students.dat");
                    break;
                case 3:
                    loadFromFile("students.dat");
                    break;
                case 4:
                    findTopStudent();
                    break;
                case 5:
                    System.out.print("Nhập chuyên ngành cần tìm");
                    String major = scanner.nextLine();
                    List<Student> temp = searchByMajor(major);
                    for (Student s : temp) {
                        System.out.println(s.toString());
                    }
                    break;
                case 6:
                    System.out.print("Điểm trung bình: ");
                    double gpa = calculateAverageGpa();
                    System.out.print(gpa);
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }while (true);
    }
    public static void addStudent(Scanner scanner) {
        Student student = new Student();
        student.inputData(scanner);
        students.add(student);
    }
    public static void saveToFile(String fileName) {
        try(FileOutputStream fos = new FileOutputStream(fileName)){
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            System.out.println("Đã ghi vào file thành công!");
        }catch (IOException e){
            System.out.println(e.getMessage());;
        }
    }
    public static void loadFromFile(String fileName) {
        try(FileInputStream fis = new FileInputStream(fileName)) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<Student> fileStudent = (List<Student>) ois.readObject();
            fileStudent.forEach(student -> {
                System.out.println(student.toString());
            });
        }catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    public static Student findTopStudent(){
       Optional<Student> maxStudent = students.stream().max(Comparator.comparingDouble(s->s.getGpa()));
       System.out.print("Sinh viên có điểm trung bình lớn nhât: ");
       return maxStudent.orElse(null);
    }
    public static List<Student> searchByMajor(String major) {
        List<Student> listByMajor = students.stream()
                .filter(student -> student.getMajor().equals(major)).toList();
        return listByMajor.isEmpty() ? null : listByMajor;
    }
    public static double calculateAverageGpa(){
        double sum = 0;
        for (Student s : students) {
            sum += s.getGpa();
        }
        return sum / students.size();
    }
}

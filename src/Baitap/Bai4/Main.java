package Baitap.Bai4;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Sinh viên A",19,8.5);
        try (FileOutputStream fos = new FileOutputStream("student.dat")){
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(student);
            oos.flush();
            System.out.println("Đã ghi đối tượng vào file student.dat");
        }catch (IOException e){
            System.out.println(e.getMessage());;
        }
        try(FileInputStream fis = new FileInputStream("student.dat")){
            ObjectInputStream ois = new ObjectInputStream(fis);
            Student student1 = (Student) ois.readObject();
            System.out.println("Đã đọc đối tượng từ file student.dat");
            System.out.println(student1.toString());
        }catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());;
        }
    }
}

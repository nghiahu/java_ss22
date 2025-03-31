package Baitap;

import java.io.*;
import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào một chuỗi: ");
        String str = scanner.nextLine();
        File file = new File("output.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))){
            writer.write(str);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        try (BufferedReader reader = new BufferedReader(new FileReader("output.txt"))){
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}

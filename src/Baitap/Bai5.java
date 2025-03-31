package Baitap;

import java.io.*;

public class Bai5 {
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("input.txt"))){
            writer.write("Văn Lâm");
            writer.newLine();
            writer.write("Tiến Linh");
            writer.newLine();
            writer.write("Xuân Son");
            writer.newLine();
            writer.write("Hoàng Đức");
            writer.newLine();
            writer.write("Văn Hậu");
            writer.newLine();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))){
            String line;
            String maxLine = "";
            while ((line = reader.readLine()) != null){
                if (line.length() > maxLine.length()){
                    maxLine = line;
                }
            }
            System.out.println("Cầu thử có tên dài nhất: " + maxLine + ", độ dài: " + maxLine.length());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}

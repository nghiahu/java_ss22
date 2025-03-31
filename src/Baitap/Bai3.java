package Baitap;

import java.io.*;

public class Bai3 {
    public static void main(String[] args) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("input.txt"))){
            writer.write("Nội dung của file input.txt");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))){
            String line;
            while ((line = reader.readLine()) != null){
                try(BufferedWriter writer = new BufferedWriter(new FileWriter("copy.txt"))){
                    writer.write(line);
                }catch (IOException e){
                    System.out.println(e.getMessage());
                }
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        try (BufferedReader reader = new BufferedReader(new FileReader("copy.txt"))){
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}

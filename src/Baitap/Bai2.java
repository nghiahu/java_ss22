package Baitap;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) throws IOException {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập vào tệp muốn tạo: ");
            String fileName = scanner.nextLine();
            File file = new File(fileName);
            if (file.exists()){
                System.out.print("Tệp đã tồn tại");
            }else {
                if(file.createNewFile()){
                    System.out.println("File đã được tạo!");
                }else {
                    System.out.println("Không thể tạo tệp");
                }
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}

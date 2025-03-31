package Baitap.Bai8;

import Baitap.Bai4.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        Product product1 = new Product(101,"Laptop Asus",15000000);
        Product product2 = new Product(102,"Chuột Logitech",500000);
        Product product3 = new Product(103,"Màn hình LG Gaming",20000000);
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        try(FileOutputStream fos = new FileOutputStream("products.dat")){
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(productList);
        }catch (IOException e){
            System.out.println(e.getMessage());;
        }
        try(FileInputStream fis = new FileInputStream("products.dat")){
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<Product> productList1 = (List<Product>) ois.readObject();
            productList1.forEach(product -> {
                System.out.printf("ID: %d\t | Name: %s\t | Price: %.2f VND\n", product.getId(), product.getName(), product.getPrice());
            });
        }catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());;
        }
    }
}

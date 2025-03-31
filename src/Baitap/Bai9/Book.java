package Baitap.Bai9;

import java.io.Serializable;
import java.util.Scanner;

public class Book implements Serializable {
    private static int isSequece = 0;
    private int id;
    private String name;
    private String author;
    private String publisher;
    private double price;

    public Book() {
        this.id = ++isSequece;
    }
    public Book(String name, String author, String publisher, double price) {
        this.id = ++isSequece;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void inputData(Scanner scanner){
        System.out.print("Nhập vào tên sách: ");
        this.name = scanner.nextLine();
        System.out.print("Nhập vào tên tác giả: ");
        this.author = scanner.nextLine();
        System.out.print("Nhập vào nhà suất bản: ");
        this.publisher = scanner.nextLine();
        System.out.print("Nhập vào giá sách");
        this.price = Double.parseDouble(scanner.nextLine());
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Author: " + author + ", Publisher: " + publisher + ", Price: " + price;
    }
}

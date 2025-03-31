package Baitap.Bai9;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManager {
    private static List<Book> bookList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try(FileInputStream fis = new FileInputStream("books.dat")) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<Book> fileBook = (List<Book>) ois.readObject();
            bookList = fileBook;
        }catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        do {
            System.out.println("************************MENU***********************");
            System.out.println("1. Thêm sách");
            System.out.println("2. Cập nhật thông tin sách");
            System.out.println("3. Xóa sách bằng title");
            System.out.println("4. Hiển thị các cuốn sách");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    updateBook(scanner);
                    break;
                case 3:
                    deleteBook(scanner);
                    break;
                case 4:
                    displayBook();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ vui lòng chọn lại");
            }
        }while (true);
    }
    public static void addBook(Scanner scanner) {
        Book book = new Book();
        book.inputData(scanner);
        bookList.add(book);
        try(FileOutputStream fos = new FileOutputStream("books.dat")){
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(bookList);
        }catch (IOException e){
            System.out.println(e.getMessage());;
        }
    }
    public static void updateBook(Scanner scanner) {
        System.out.print("Nhập vào id sách cần sửa: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean found = false;
        for (Book book : bookList) {
            if (book.getId() == id) {
                found = true;
                boolean Exit = false;
                do {
                    System.out.println("************************MENU***********************");
                    System.out.println("1. Sửa tên sách");
                    System.out.println("2. Sửa tên tác giả");
                    System.out.println("3. Sủa nhà suất bản");
                    System.out.println("4. Sủa giá sách");
                    System.out.println("5. Thoát");
                    System.out.print("Lựa chọn cửa bạn: ");
                    int choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            System.out.print("Nhập vào tên sách: ");
                            book.setName(scanner.nextLine());
                            break;
                        case 2:
                            System.out.print("Nhập vào tác giả: ");
                            book.setAuthor(scanner.nextLine());
                            break;
                        case 3:
                            System.out.print("Nhập vào nhà suất bản: ");
                            book.setPublisher(scanner.nextLine());
                            break;
                        case 4:
                            System.out.print("Nhập vào giá sách: ");
                            book.setPrice(Double.parseDouble(scanner.nextLine()));
                            break;
                        case 5:
                            Exit = true;
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ vui lòng chọn lại!");
                    }
                }while (!Exit);
                try(FileOutputStream fos = new FileOutputStream("books.dat")){
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(bookList);
                }catch (IOException e){
                    System.out.println(e.getMessage());;
                }
                break;
            }
        }
        if (!found) {
            System.out.println("Sách không tồn tại!");
        }
    }
    public static void deleteBook(Scanner scanner) {
        System.out.print("Nhập vào tên sách cần xóa: ");
        String title = scanner.nextLine();
        boolean found = false;
        for (Book book : bookList) {
            if (book.getName().equals(title)) {
                found = true;
                break;
            }
        }
        if (found) {
            bookList.removeIf(b -> b.getName().equals(title));
        }else {
            System.out.println("Sách không tồn tại!");
        }
        try(FileOutputStream fos = new FileOutputStream("books.dat")){
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(bookList);
        }catch (IOException e){
            System.out.println(e.getMessage());;
        }
    }
    public static void displayBook() {
        try(FileInputStream fis = new FileInputStream("books.dat")) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<Book> fileBook = (List<Book>) ois.readObject();
            bookList = fileBook;
        }catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        if (bookList.isEmpty()) {
            System.out.println("Chưa có cuốn sách nào!");
        }else {
            for (Book book : bookList) {
                System.out.println(book.toString());
            }
        }
    }
}

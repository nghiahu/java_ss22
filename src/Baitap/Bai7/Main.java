package Baitap.Bai7;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"))){
            writer.write("1,\"AU\",\"Australia");
            writer.newLine();
            writer.write("2,\"CN\",\"Canada");
            writer.newLine();
            writer.write("3,\"AU\",\"Australia");
            writer.newLine();
            writer.write("4,\"CN\",\"Canada");
            writer.newLine();
            writer.write("5,\"JP\",\"Japan");
            writer.newLine();
            writer.write("6,\"CN\",\"China");
            writer.newLine();
            writer.write("7,\"JP\",\"Japan");
            writer.newLine();
            writer.write("8,\"TH\",\"Thailand");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        List<Country> countryList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] split = line.split(",");
                Country country = new Country();
                country.setId(Integer.parseInt(split[0]));
                country.setCode(split[1]);
                country.setName(split[2]);
                countryList.add(country);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        countryList.forEach(country -> {
            System.out.printf("[ ID: %d \t| CODE: %s\t | NAME: %s \t]\n", country.getId(), country.getCode(), country.getName());
        });
    }
}

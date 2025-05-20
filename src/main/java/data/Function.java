/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import util.Validator;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author phamm
 */
public class Function {

    ArrayList<Hotel> hotel = new ArrayList<>();
    Validator valid = new Validator();
    String id = null, phone = null, name = null, address = null;
    Integer rating = null, available = null;
    Scanner sc = new Scanner(System.in);

    public void enterHotel(int choice) {
        int count = 1;
        while (true) {
            try {
                switch (count) {
                    case 1:
                        System.out.println("Enter your Hotel Id");
                        id = sc.nextLine();
                        if (id.isEmpty()) {
                            id = null;
                        }
                        if (valid.isDuplicateId(id, hotel) && choice == 1) {
                            System.out.println("ID is duplicated");
                            break;
                        } else {
                            count++;
                        }
                    case 2:
                        System.out.println("Enter your Hotel Name");
                        name = sc.nextLine();
                        if (name.isEmpty()) {
                            name = null;
                        }
                        count++;
                    case 3:
                        System.out.println("Enter your Room Available");
                        String Available = sc.nextLine();
                        if (Available.isEmpty()) {
                            available = null;
                        } else {
                            available = Integer.valueOf(Available);
                        }
                        count++;
                    case 4:
                        System.out.println("Enter your Hotel Address");
                        address = sc.nextLine();
                        if (address.isEmpty()) {
                            address = null;
                        }
                        count++;
                    case 5:
                        System.out.println("Enter your Phone number (Press Enter to skip):");
                        String phoneNumberInput = sc.nextLine();
                        if (!phoneNumberInput.isEmpty()) {
                            if (!valid.isValidPhoneNumber(phoneNumberInput)) {
                                System.out.print("Phone must be a number including 0-9");
                                System.out.println("");
                                break;
                            }
                            phone = phoneNumberInput;
                        }
                        count++;
                        break;
                    case 6:
                        System.out.println("Enter your Rating (Press Enter to skip):");
                        String ratingInput = sc.nextLine();
                        if (!ratingInput.isEmpty()) {
                            try {
                                int parsedRating = Integer.parseInt(ratingInput);
                                if (!valid.isValidRating(ratingInput)) {
                                    System.out.println("Rating must be between 1 and 6");
                                    break;
                                } else {
                                    rating = parsedRating;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input, You must enter a number");
                                break;
                            }
                        }
                        count++;
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input, You must enter numbers");
            } finally {
                if (count == 7) {
                    break;
                }
            }
        }
    }

    public boolean continueTask(Scanner scanner) {
        System.out.println("Do you want to add another hotel? (Y/N)");
        String choice = scanner.nextLine().trim().toLowerCase();
        return choice.equals("y");
    }

    public void addHotel() {
        do {
            enterHotel(1);
            if (valid.checkAtLeastNull(phone, name, address, id, rating, available)) {
                System.out.println("Create failed, each info must be filled");
            } else {
                hotel.add(new Hotel(id, name, available, address, phone, rating));
                fileWriterNew(hotel);
                System.out.println("Create successfully");
                id = null;
                name = null;
                available = null;
                address = null;
                phone = null;
                rating = null;
            }
        } while (continueTask(sc));
    }

    public void fileWriterNew(ArrayList<Hotel> hotel) {
        try (FileWriter fw = new FileWriter("D:\\niufolder\\labb\\src\\main\\java\\data\\Hotel.txt"); BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write("");

            if (hotel.size() > 0) {
                for (Hotel o : hotel) {
                    if (o != null) {
                        bw.write(o.toString());
                        bw.newLine();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error please check file again");
        }
    }

    public void loadAllData() {
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\niufolder\\labb\\src\\main\\java\\data\\Hotel.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\t");
                String id = data[0];
                String name = data[1];
                int available = Integer.parseInt(data[2]);
                String address = data[3];
                String phone = data[4];
                int rating = Integer.parseInt(data[5]);

                Hotel loadedHotel = new Hotel(id, name, available, address, phone, rating);
                hotel.add(loadedHotel);
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading data from file.");
        }
    }

    public ArrayList<String> fileSearch(Object searchWord) {
        ArrayList<String> result = new ArrayList<>();
        String line = null;

        try (BufferedReader br = new BufferedReader(new FileReader("D:\\niufolder\\labb\\src\\main\\java\\data\\Hotel.txt"))) {
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\t");
                for (String word : words) {
                    if (word.equals(searchWord.toString())) {
                        result.add(line);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error please check file again");
        }
        return result;
    }

    public void fileRead() {
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\New Folder\\labb\\src\\main\\java\\data\\Hotel.txt"))) {
            String line = null;
            String[] words;
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                words = line.split("\t");
            }
        } catch (Exception e) {
            System.out.println("Error please check file again");
        }
    }

    public int checkExistHotel() {
        System.out.println("Please enter your id to check");
        String id = sc.nextLine();
        int count = 0, index = 0;
        if (fileSearch(id).isEmpty()) {
            System.out.println("Not found");
        } else {
            String[] words;
            for (String o : fileSearch(id)) {
                words = o.split("\t");
                if (words[0].equals(id)) {
                    System.out.println("Hotel exists");
                    count++;
                    return index;
                }
                index++;
                System.out.println(index);
            }
        }

        if (count == 0) {
            System.out.println("Not found");
        }
        return -1;
    }

    public void updateHotel() {
        while (true) {
            System.out.println("Please input Hotel_ID");
            String check = sc.nextLine();
            if (valid.isDuplicateId(check, hotel) == true) {
                System.out.println("Hotel is exist");
                enterHotel(3);
                if (valid.checkNullAll(id, phone, name, address, rating, available) == true) {
                    System.out.println("Nothing to change");
                    break;
                } else {
                    int i = valid.isDuplicateId(check, hotel, true);
                    if (id != null) {
                        hotel.get(i).setId((id));
                    }
                    if (name != null) {
                        hotel.get(i).setName(name);
                    }
                    if (available != null) {
                        hotel.get(i).setAvailable(available);
                    }
                    if (address != null) {
                        hotel.get(i).setAddress(address);
                    }
                    if (phone != null) {
                        hotel.get(i).setPhone(phone);
                    }
                    if (rating != null) {
                        hotel.get(i).setRating(rating);
                    }
                    System.out.println(hotel.get(i).toString());
                }
                fileWriterNew(hotel);
                break;
            } else {
                System.out.println("Hotel is not exist");
            }
            break;
        }
    }

    public void deleteHotel() {
        System.out.println("Enter id");
        String idd = sc.nextLine();
        int index = valid.isDuplicateId(idd, hotel, true);
        if (index != -1) {
            hotel.remove(index);
            System.out.println(index);
            System.out.println("Delete success");
            fileWriterNew(hotel);
        }
    }

    public ArrayList<Hotel> getHotel() {
        return hotel;
    }

    public void searchHotel() {
        System.out.println("1. Search Hotel By ID");
        System.out.println("2. Search Hotel By Name");
        System.out.println("Please input your choice");
        try {
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    sc.nextLine();
                    searchHotelById();
                    break;
                case 2:
                    sc.nextLine();
                    searchHotelByName();
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            System.out.println("Wrong input");
        }
    }

    public void searchHotelById() {
        System.out.println("Please input your id to check");
        String checkId = sc.nextLine();
        ArrayList<Hotel> sortById = new ArrayList<>();
        for (Hotel result : hotel) {
            if (result.getId().equals(checkId)) {
                sortById.add(new Hotel(result.getId(), result.getName(), result.getAvailable(), result.getAddress(), result.getPhone(), result.getRating()));
            }
        }
        //searchHotel(searchString);
        Collections.sort(sortById, Comparator.comparing(Hotel::getId).thenComparing(Hotel::getName));
        for (Hotel result : sortById) {
            System.out.println(result.toString());
        }
    }

    public void searchHotelByName() {
        //searchHotel(searchString);
        System.out.println("Please input your Hotel_Name");
        String checkName = sc.nextLine();
        for (String result : fileSearch(checkName)) {
            System.out.println(result.toString());
        }
    }

    public void display() {
        ArrayList<Hotel> sortByName = new ArrayList<>();
        for (Hotel result : hotel) {
            sortByName.add(new Hotel(result.getId(), result.getName(), result.getAvailable(), result.getAddress(), result.getPhone(), result.getRating()));
        }
        Collections.sort(sortByName, Comparator.comparing(Hotel::getName).thenComparing(Hotel::getAvailable).thenComparing(Hotel::getPhone));
        for (Hotel result : sortByName) {
            System.out.println(result.toString());
        }
    }
}

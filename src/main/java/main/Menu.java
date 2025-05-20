package main;

import data.Function;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author phamm
 */
public class Menu {

    public static void main(String args[]) {
        boolean cont = true;
        Scanner sc = new Scanner(System.in);
        Function function = new Function();
        function.loadAllData();

        while (cont) {
            System.out.println(" ---------------------------------------------");
            System.out.println("|        1. Add new hotel                     |");
            System.out.println("|        2. Check exit hotel                  |");
            System.out.println("|        3. Update hotel information          |");
            System.out.println("|        4. Delete hotel                      |");
            System.out.println("|        5. Search hotel                      |");
            System.out.println("|        6. Displaying a hotel list           |");
            System.out.println("|        7. Exit the program                  |");
            System.out.println(" ---------------------------------------------");
            System.out.print("Enter your choice: ");

            try {
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        function.addHotel();
                        break;
                    case 2:
                        function.checkExistHotel();
                        break;
                    case 3:
                        function.updateHotel();
                        break;
                    case 4:
                        function.deleteHotel();
                        break;
                    case 5:
                        function.searchHotel();
                        break;
                    case 6:
                        function.display();
                        break;
                    case 7:
                        System.out.println();
                        System.out.println("Close program.");
                        break;
//                    case 8:
//                        function.findHotell();
//                        break;
                    default:
                        System.out.println("Not valid choice. Please enter a number between 1 and 7.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.nextLine();
            }
        }
        System.out.println("Thank you!");
    }
}

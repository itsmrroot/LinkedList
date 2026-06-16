import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
  //  public static LinkedList<String> myLinkedList = new LinkedList<String>(); // Building LinkedList

    public static List myList = new List();


    public static void main(String[] args) {


            addItem();

            while (true){
                switch (menu()){
                    case "S":
                        System.out.println("\nSorting.......");
                        sort();
                        break;
                    case "D":
                       delete();
                        break;
                    case "L":
                        System.out.println("\nItems in the List = "+myList);
                        break;
                    case "P":
                     previous();
                        break;
                    case "N":
                        next();
                        break;
                    case "Q":
                        System.out.println("\nCIAO......🫡");
                        return ;
                    default:
                        System.out.println("Invalid option. Please try again.");

                }

            }



    }
    public static void addItem() {
        while (true) {
            System.out.print("Please enter the item (X to stop the program): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("X")) {
                break;
            }
            if (!input.matches("[a-zA-ZäöüÄÖÜß ]+")) {
                System.out.println("Please enter only STRING items. Numbers and special characters are not allowed.");
                continue;
            }
            myList.add(new Node(input));

        }
        System.out.println("\nItems in the List = "+myList);

    }
    public static String menu(){
        System.out.println("\n-----Available Actions-----");
        String block=("""
                (S)orting
                (D)elete
                (L)ist
                (P)revious
                (N)ext
                (Q)uit
                select your option by typing letter:""");
        System.out.print(block + "");
        String option = scanner.nextLine().toUpperCase();
        return option;
    }
    public static void sort(){
        myList.sort();
        System.out.println("Sorted List = " + myList);
    }
    public static void delete(){
        try {
            System.out.println("Write the item(s) to delete from list, separated by commas: ");
            String[] items = scanner.nextLine().split(",");
            for (String i: items){
                String trimmed = i.trim();
                myList.remove(trimmed);
            }

        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number.");
            System.out.println();
            scanner.nextLine(); // Clear the invalid input
            // Exit the method to show the menu again
        }
        System.out.println("\nItems in the List = "+myList);
    }
    public static void next() {
        String val = myList.next();
        if (val == null) System.out.println("Already at the end.");
        else System.out.println("Next item: " + val);
    }

    public static void previous() {
        String val = myList.previous();
        if (val == null) System.out.println("Already at the beginning.");
        else System.out.println("Previous item: " + val);
    }

}
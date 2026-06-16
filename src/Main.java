import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static List myList = new List();

    public static void main(String[] args) {
        addItem();

        while (true) {
            switch (menu()) {
                case "S":
                    System.out.println("\nSorting.......");
                    sort();
                    break;
                case "D":
                    delete();
                    break;
                case "L":
                    System.out.println("\nItems in the List = " + myList);
                    break;
                case "P":
                    previous();
                    break;
                case "N":
                    next();
                    break;
                case "Q":
                    System.out.println("\nCIAO......🫡");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void addItem() {
        while (true) {
            System.out.print("Please enter the item (X to stop): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("X")) break;

            if (input.isEmpty()) {
                System.out.println("Input cannot be empty. Please enter a name.");
                continue;
            }

            if (!input.matches("[a-zA-ZäöüÄÖÜß ]+")) {
                System.out.println("Please enter only STRING items. Numbers and special characters are not allowed.");
                continue;
            }

            myList.add(new Node(input));
        }
        System.out.println("\nItems in the List = " + myList);
    }

    public static String menu() {
        System.out.println("\n-----Available Actions-----");
        System.out.print("""
                (S)orting
                (D)elete
                (L)ist
                (P)revious
                (N)ext
                (Q)uit
                Select your option by typing letter: """);
        return scanner.nextLine().trim().toUpperCase();
    }

    public static void sort() {
        if (myList.head == null) {
            System.out.println("The list is empty, nothing to sort.");
            return;
        }
        myList.sort();
        System.out.println("Sorted List = " + myList);
    }

    public static void delete() {
        if (myList.head == null) {
            System.out.println("The list is already empty.");
            return;
        }
        System.out.print("Write the item(s) to delete, separated by commas: ");
        String line = scanner.nextLine().trim();

        if (line.isEmpty()) {
            System.out.println("No input entered. Returning to menu.");
            return;
        }

        String[] items = line.split(",");
        for (String i : items) {
            String trimmed = i.trim();
            if (!trimmed.isEmpty()) {
                myList.remove(trimmed);
            }
        }
        System.out.println("\nItems in the List = " + myList);
    }

    public static void next() {
        if (myList.head == null) {
            System.out.println("The list is empty.");
            return;
        }
        String val = myList.next();
        if (val == null) System.out.println("Already at the end of the list.");
        else System.out.println("Next item: " + val);
    }

    public static void previous() {
        if (myList.head == null) {
            System.out.println("The list is empty.");
            return;
        }
        String val = myList.previous();
        if (val == null) System.out.println("Already at the beginning of the list.");
        else System.out.println("Previous item: " + val);
    }
}
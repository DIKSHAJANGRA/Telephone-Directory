import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TelephoneDirectory {
    private Map<String, String> contacts;

    public TelephoneDirectory() {
        contacts = new HashMap<>();
    }

    public void addContact(String number, String name) {
        if (contacts.containsKey(number)) {
            System.out.println("Contact with this number already exists.");
        } else {
            contacts.put(number, name);
            System.out.println("Contact added successfully.");
        }
    }

    public void searchContactByNumber(String number) {
        if (contacts.containsKey(number)) {
            System.out.println("Name of the contact: " + contacts.get(number));
        } else {
            System.out.println("Contact not found.");
        }
    }

    public void searchContactByName(String name) {
        boolean found = false;
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(name)) {
                System.out.println("Number of the contact: " + entry.getKey());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    public void deleteContact(String number) {
        if (contacts.containsKey(number)) {
            contacts.remove(number);
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }
        System.out.println("Contacts:");
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            System.out.println("Number: " + entry.getKey() + ", Name: " + entry.getValue());
        }
    }

    public void startDirectory() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\nTelephone Directory System");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact by Number");
            System.out.println("3. Search Contact by Name");
            System.out.println("4. Delete Contact");
            System.out.println("5. Display Contacts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter contact number: ");
                    String number = scanner.nextLine();
                    System.out.print("Enter contact name: ");
                    String name = scanner.nextLine();
                    addContact(number, name);
                    break;
                case 2:
                    System.out.print("Enter contact number to search: ");
                    number = scanner.nextLine();
                    searchContactByNumber(number);
                    break;
                case 3:
                    System.out.print("Enter contact name to search: ");
                    name = scanner.nextLine();
                    searchContactByName(name);
                    break;
                case 4:
                    System.out.print("Enter contact number to delete: ");
                    number = scanner.nextLine();
                    deleteContact(number);
                    break;
                case 5:
                    displayContacts();
                    break;
                case 6:
                    System.out.println("Exiting directory.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void main(String[] args) {
        TelephoneDirectory directory = new TelephoneDirectory();
        directory.startDirectory();
    }
}

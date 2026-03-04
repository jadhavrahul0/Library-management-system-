
import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String name;
    boolean isIssued;

    Book(int id, String name) {
        this.id = id;
        this.name = name;
        this.isIssued = false;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Book Name: ");
                    String name = sc.nextLine();
                    books.add(new Book(id, name));
                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    System.out.println("\n--- Book List ---");
                    for (Book b : books) {
                        System.out.println("ID: " + b.id +
                                " | Name: " + b.name +
                                " | Status: " + (b.isIssued ? "Issued" : "Available"));
                    }
                    break;

                case 3:
                    System.out.print("Enter Book ID to issue: ");
                    int issueId = sc.nextInt();
                    for (Book b : books) {
                        if (b.id == issueId && !b.isIssued) {
                            b.isIssued = true;
                            System.out.println("Book issued successfully!");
                            break;
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = sc.nextInt();
                    for (Book b : books) {
                        if (b.id == returnId && b.isIssued) {
                            b.isIssued = false;
                            System.out.println("Book returned successfully!");
                            break;
                        }
                    }
                    break;

                case 5:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}

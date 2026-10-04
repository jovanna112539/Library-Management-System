/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package library.management.system;
import java.util.*;

class Book {
    int id;
    String title;
    String author;
    String category;
    boolean available;

    Book(int id, String title, String author, String category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.available = true;
    }

    public String toString() {
        return id + " | " + title + " | " + author + " | "+ category + " | "+ (available ? "Available" : "Issued");
                
                
    }
}


public class LibraryManagementSystem {
    static Scanner sc = new Scanner(System.in);

    static List<Book> books = new ArrayList<>();
    static Set<String> categories = new HashSet<>();
    static Map<Integer, Book> bookMap = new HashMap<>();
    static Queue<String> waitingList = new LinkedList<>();

    static void addBook() {

        System.out.print("Enter book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter book title: ");
        String title = sc.nextLine();

        System.out.print("Enter author: ");
        String author = sc.nextLine();

        System.out.print("Enter category: ");
        String category = sc.nextLine();

        Book book = new Book(id, title, author, category);

        books.add(book);
        bookMap.put(id, book);
        categories.add(category);

        System.out.println("Book added successfully.");
    }

    static void displayBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("\n--- BOOKS ---");

        for (Book book : books) {
            System.out.println(book);
        }
    }

    static void searchBook() {

        System.out.print("Enter book ID: ");
        int id = sc.nextInt();

        Book book = bookMap.get(id);

        if (book != null) {
            System.out.println("Book found:");
            System.out.println(book);
        } else {
            System.out.println("Book not found.");
        }
    }

    static void issueBook() {

        System.out.print("Enter book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter student name: ");
        String student = sc.nextLine();

        Book book = bookMap.get(id);

        if (book == null) {
            System.out.println("Invalid book ID.");
        } else if (book.available) {
            book.available = false;
            System.out.println("Book issued to " + student);
        } else {
            waitingList.add(student);
            System.out.println("Book unavailable. " +student + " added to waiting list.");
                    
                    
            
        }
    }

    static void returnBook() {

        System.out.print("Enter book ID: ");
        int id = sc.nextInt();

        Book book = bookMap.get(id);

        if (book == null) {
            System.out.println("Invalid book ID.");
            return;
        }

        book.available = true;

        System.out.println("Book returned successfully.");

        if (!waitingList.isEmpty()) {
            String student = waitingList.poll();
            book.available = false;

            System.out.println("Book issued to waiting student: "+ student);
                    
                    
            
        }
    }

    static void displayCategories() {

        System.out.println("\n--- CATEGORIES ---");

        for (String category : categories) {
            System.out.println(category);
        }
    }

    static void displayWaitingList() {

        System.out.println("\n--- WAITING LIST ---");

        if (waitingList.isEmpty()) {
            System.out.println("Waiting list is empty.");
        } else {
            for (String student : waitingList) {
                System.out.println(student);
            }
        }
    }

    
    public static void main(String[] args) {
         int choice;

        do {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM ====="            );

                    

            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Display Categories");
            System.out.println("7. Display Waiting List");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addBook();
                    break;

                case 2:
                    displayBooks();
                    break;

                case 3:
                    searchBook();
                    break;

                case 4:
                    issueBook();
                    break;

                case 5:
                    returnBook();
                    break;

                case 6:
                    displayCategories();
                    break;

                case 7:
                    displayWaitingList();
                    break;

                case 8:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 8);
    }
    
}

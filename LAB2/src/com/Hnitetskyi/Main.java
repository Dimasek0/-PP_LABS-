package com.Hnitetskyi;

import com.Hnitetskyi.Books.Books;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        int choice, year;
        String author, publisher;
        Books[] myBook = new Books[7];

        CreateArrayOfObjects(myBook);
        ReadFromFile(myBook);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n\nChoose sort type with menu:");
            System.out.println("1. Sort type: author, book's name, price.");
            System.out.println("2. Sort type: publisher, year, amount of pages.");
            System.out.println("3. Sort type: author, publisher, year.");
            System.out.println("4. Exit.");
            System.out.print("\nEnter your choice (1-4): ");
            choice = scanner.nextInt();
            if (choice == 4) break;
            System.out.println("\n");
            System.out.println("Sorted list:");

            DifferentData(choice, myBook);

            scanner.nextLine();
            System.out.print("\n\nEnter author: ");
            author = scanner.nextLine();
            System.out.print("Enter year: ");
            year = scanner.nextInt();
            System.out.print("Enter publisher: ");
            scanner.nextLine();
            publisher = scanner.nextLine();

            BooksOfAuthors(author, myBook);
            BooksOfPublisher(publisher, myBook);
            BooksAfterYear(year, myBook);
            scanner.nextLine();
        }
    }

    private static void BooksOfAuthors(String author, Books[] myBook) {
        System.out.println("\n\nAuthor: " + author + " and list of his books:");
        for (int i = 0; i < 7; i++) {
            if (author.equals(myBook[i].getAuthor())) {
                System.out.println("" + myBook[i].getName());
            }
        }
    }

    private static void BooksOfPublisher(String publisher, Books[] myBook) {
        System.out.println("\n\nPublisher: " + publisher + " and list of his books:");
        for (int i = 0; i < 7; i++) {
            if (publisher.equals(myBook[i].getPublisher())) {
                System.out.println("" + myBook[i].getName());
            }
        }
    }

    private static void BooksAfterYear(int year, Books[] myBook) {
        System.out.println("\n\nBooks that were published after " + year + " year:");
        for (int i = 0; i < 7; i++) {
            if (year < myBook[i].getYear()) {
                System.out.println("" + myBook[i].getName());
            }
        }
    }

    private static void CreateArrayOfObjects(Books[] myBook) {
        for (int i = 0; i < 7; i++) {
            myBook[i] = new Books();
        }
    }

    private static void SortOne(Books[] myBook) {
        for (int i = 0; i < 7; i++) {
            System.out.println("Author: " + myBook[i].getAuthor() + " book's name: " + myBook[i].getName()
                    + " price: " + myBook[i].getPrice());
        }
    }

    private static void SortTwo(Books[] myBook) {
        for (int i = 0; i < 7; i++) {
            System.out.println("Publisher: " + myBook[i].getPublisher() + " year: " + myBook[i].getYear()
                    + " amount of pages: " + myBook[i].getAmountOfPages());
        }
    }

    private static void SortThree(Books[] myBook) {
        for (int i = 0; i < 7; i++) {
            System.out.println("Author: " + myBook[i].getAuthor() + " publisher: " + myBook[i].getPublisher()
                    + " year: " + myBook[i].getYear());
        }
    }

    private static void ReadFromFile(Books[] myBook) throws Exception {
        File file = new File("src\\books.txt");
        Scanner fileScanner = new Scanner(file);

        try {
            while (fileScanner.hasNextLine()) {
                for (int i = 0; i < 7; i++) {
                    myBook[i].setId(fileScanner.nextInt());
                    if (myBook[0].getId() < 0) {
                        System.out.println("Error of reading... Id is negative.");
                    }
                    fileScanner.nextLine();
                    myBook[i].setName(fileScanner.nextLine());
                    myBook[i].setAuthor(fileScanner.nextLine());
                    myBook[i].setPublisher(fileScanner.nextLine());
                    myBook[i].setYear(fileScanner.nextInt());
                    if (myBook[i].getYear() < 0) {
                        System.out.println("Error of reading... Year is negative.");
                    }
                    myBook[i].setAmountOfPages(fileScanner.nextInt());
                    if (myBook[i].getAmountOfPages() < 0) {
                        System.out.println("Error of reading... Amount of pages is negative.");
                    }
                    myBook[i].setPrice(fileScanner.nextInt());
                    if (myBook[i].getPrice() < 0) {
                        System.out.println("Error of reading... Price is negative.");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        fileScanner.close();
        for (int i = 0; i < 7; i++) {
            System.out.println(myBook[i].toString());
        }
    }

    private static void DifferentData(int choice, Books[] myBook) {
        switch (choice) {
            case 1:
                SortOne(myBook);
                break;
            case 2:
                SortTwo(myBook);
                break;
            case 3:
                SortThree(myBook);
                break;
            case 4:
                break;
        }
    }
}
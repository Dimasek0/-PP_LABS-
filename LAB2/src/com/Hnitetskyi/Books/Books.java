package com.Hnitetskyi.Books;

public class Books {
    private int id;
    private String name;
    private String author;
    private String publisher;
    private int year;
    private int amountOfPages;
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int ID) {
        this.id = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String Author) {
        this.author = Author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String Publisher) {
        this.publisher = Publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int Year) {
        this.year = Year;
    }

    public int getAmountOfPages() {
        return amountOfPages;
    }

    public void setAmountOfPages(int AmountOfPages) {
        this.amountOfPages = AmountOfPages;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int Price) {
        this.price = Price;
    }

    public void Books(int ID, String Name, String Author, String Publisher, int Year, int AmountOfPages, int Price) {
        this.id = ID;
        this.name = Name;
        this.author = Author;
        this.publisher = Publisher;
        this.year = Year;
        this.amountOfPages = AmountOfPages;
        this.price = Price;
    }

    public String toString() {
        return "Id of book: " + this.id + ", " + "book's name: " + this.name
                + ", " + "author: " + this.author + ", " + " publisher: " + this.publisher
                + ", " + "year: " + this.year + ", " + "amount of pages: " + this.amountOfPages
                + ", " + "price: " + this.price + "$";
    }
}
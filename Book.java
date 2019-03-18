package bookstore;

class Book extends Item {

    String author;

    Book(String name, String author, double cost){
        super(name, cost);
        this.author = author;
    }



}

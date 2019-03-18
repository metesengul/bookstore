package bookstore;

// This class is for interacting with the book file.
public class BookData extends Data{

    static Book[] books = new Book[100];
    static int bookAmount = 0;

    static void addBook(String name, String author, double cost){
        File.append("books.txt", name + ", " + author + ", " + cost + "\n");
        BookData.update();
    }

    static void update(){
        String books[] = File.read("books.txt").split("\n");
        BookData.bookAmount = books.length;
        for (int i = 0; i < books.length; i++){
            String[] book = books[i].split(", ");
            BookData.books[i] = new Book(book[0], book[1], Double.parseDouble(book[2]));
        }
    }

    @Override
    void showInformation() {
        System.out.println("Book Data is being used.");
    }
}

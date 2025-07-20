import java.util.ArrayList;

public class Library {

    private ArrayList<Book> _bookList;
    private int _bookCount;

    // Constructor
    public Library() {
        _bookList = new ArrayList<>();
        _bookCount = 0;
    }

    public int get_bookCount(){
        return _bookCount;
    }

    // Add book
    public void addBook(String title, String author, String isbn) {
        _bookList.add(new Book(title, author, isbn));
        _bookCount += 1;
    }

    // find book by title
    public Book findBookByTitle(String title) {
        for (int i = 0; i < _bookCount; i++) {
            if (_bookList.get(i).get_title().equalsIgnoreCase(title)) {
                return _bookList.get(i);
            }
        }
        return null;
    }

    // borrow book
    public String borrowBook(String title) {
        Book book = findBookByTitle(title);
        if (book.is_available()) {
            book.set_available(false);
            return title + " successfully borrowed";
        } else {
            return title + " is already borrowed";
        }
    }

    // return book
    public String returnBook(String title) {
        Book book = findBookByTitle(title);
        if (book == null) {
            return "Book not found";
        }

        if (!book.is_available()) {
            book.set_available(true);
            return "Successfully returned";
        } else {
            return "This book originally not borrow yet";
        }
    }

    // display available book
    public void displayAvailableBook() {
        System.out.println("\n=== AVAILABLE BOOKS ===");
        boolean hasBook = false;

        for (int i = 0; i < _bookCount; i++) {
            if (_bookList.get(i).is_available()) {
                System.out.println(_bookList.get(i));
                hasBook = true;
            }
        }

        if (!hasBook) {
            System.out.println("No books available.");
        }
    }

    // display borrowed book
    public void displayBorrowedBook() {
        System.out.println("\n=== BORROWED BOOKS ===");
        boolean noBook = true;

        for (int i = 0; i < _bookCount; i++) {
            if (!_bookList.get(i).is_available()) {
                System.out.println(_bookList.get(i));
                noBook = false;
            }
        }

        if (noBook) {
            System.out.println("No books available.");
        }
    }
}

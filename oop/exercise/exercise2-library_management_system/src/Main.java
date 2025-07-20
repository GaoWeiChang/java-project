public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        System.out.println("=== LIBRARY MANAGEMENT SYSTEM ===\n");

        // Add books to the library
        library.addBook("Java Programming", "James Gosling", "978-0134685991");
        library.addBook("Data Structures", "Robert Sedgewick", "978-0321573513");
        library.addBook("Algorithms", "Thomas Cormen", "978-0262033848");
        library.addBook("Clean Code", "Robert Martin", "978-0132350884");

        // borrow the books
        library.borrowBook("Java Programming");
        library.borrowBook("Algorithms");

        // Display all books
        library.displayAvailableBook();

        // return the books
        library.returnBook("Java Programming");
        library.returnBook("Algorithms");

        library.displayAvailableBook();
        library.displayBorrowedBook();
    }
}

import org.junit.*;
import static org.junit.Assert.*;

public class Library_UnitTest {
    private Library library;

    @BeforeClass
    public static void setUpClass(){
        System.out.println("=== Starting Library Class Unit Tests ===");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("=== All Library Class Tests Completed ===");
    }

    @Before
    public void setUp() {
        library = new Library();
    }

    @After
    public void tearDown() {
        library = null;
    }

    @Test
    public void testAddMultipleBooks(){
        library.addBook("Java Programming", "James Gosling", "978-0134685991");
        library.addBook("Data Structures", "Robert Sedgewick", "978-0321573513");
        library.addBook("Algorithms", "Thomas Cormen", "978-0262033848");

        assertEquals(3, library.get_bookCount());
    }

    @Test
    public void testFindExistingBook(){
        library.addBook("Java Programming", "James Gosling", "978-0134685991");
        library.addBook("Algorithms", "Thomas Cormen", "978-0262033848");

        Book found_java_book = library.findBookByTitle("Java Programming");
        assertNotNull("Book should be found", found_java_book);
        assertEquals("Java Programming", found_java_book.get_title());
        assertEquals("James Gosling", found_java_book.get_author());
        assertEquals("978-0134685991", found_java_book.get_isbn());

        Book found_algo_book = library.findBookByTitle("Algorithms");
        assertNotNull("Book should be found", found_algo_book);
        assertEquals("Algorithms", found_algo_book.get_title());
        assertEquals("Thomas Cormen", found_algo_book.get_author());
        assertEquals("978-0262033848", found_algo_book.get_isbn());
    }

    @Test
    public void testBorrowBook() {
        library.addBook("Java Programming", "James Gosling", "978-0134685991");

        assertEquals("Java Programming successfully borrowed", library.borrowBook("Java Programming"));

        Book book = library.findBookByTitle("Java Programming");
        assertFalse(book.is_available());
        assertEquals("Java Programming is already borrowed", library.borrowBook("Java Programming"));
    }

    @Test
    public void testReturnBook(){
        library.addBook("Java Programming", "James Gosling", "978-0134685991");
        library.addBook("Algorithms", "Thomas Cormen", "978-0262033848");

        assertEquals("Book not found", library.returnBook("My Little Pony"));
        assertEquals("This book originally not borrow yet", library.returnBook("Java Programming"));

        library.borrowBook("Algorithms");
        assertEquals("Successfully returned", library.returnBook("Algorithms"));
    }


}

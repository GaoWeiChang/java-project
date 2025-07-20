import org.junit.*;
import static org.junit.Assert.*;

public class Book_UnitTest {
    private Book _book;

    @BeforeClass
    public static void setUpClass(){
        System.out.println("=== Starting Book Class Unit Tests ===");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("=== All Book Class Tests Completed ===");
    }

    @Before
    public void setup(){
        _book = new Book("Java Programming", "James Gosling", "978-0134685991");
    }

    @After
    public void teardown(){
        _book = null;
    }

    /* CONSTRUCTOR TESTS */
    @Test
    public void testConstructor(){
        assertEquals("Java Programming", _book.get_title());
        assertEquals("James Gosling", _book.get_author());
        assertEquals("978-0134685991", _book.get_isbn());
        assertTrue(_book.is_available());
    }

    /* SETTER TEST */
    @Test
    public void testSetter(){
        Book algo_book = new Book("Algorithms", "Thomas Cormen", "978-0262033848");

        assertTrue(algo_book.is_available());
        algo_book.set_available(false);
        assertFalse(algo_book.is_available());
    }

    /* TEST toString */
    @Test
    public void testtoString(){
        assertEquals("Java Programming by James Gosling [Available]", _book.toString());
        _book.set_available(false);
        assertEquals("Java Programming by James Gosling [Borrowed]", _book.toString());
    }
}

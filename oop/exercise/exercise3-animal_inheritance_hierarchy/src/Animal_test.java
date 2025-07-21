import org.junit.*;
import static org.junit.Assert.*;

public class Animal_test {
    private Animal animal;

    @BeforeClass
    public static void setUpClass(){
        System.out.println("=== Starting Animal Class Unit Tests ===");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("=== All Animal Class Tests Completed ===");
    }

    @Before
    public void setup(){
        animal = new Animal("Generic", 5);
    }

    @After
    public void teardown(){
        animal = null;
    }

    /* CONSTRUCTOR TEST */
    @Test
    public void testConstructor() {
        assertEquals("Generic", animal._name);
        assertEquals(5, animal._age);
    }

    /* METHOD TEST */
    @Test
    public void testGetInfo() {
        String expected = "Generic (5 years old)";
        assertEquals(expected, animal.getInfo());
    }
}

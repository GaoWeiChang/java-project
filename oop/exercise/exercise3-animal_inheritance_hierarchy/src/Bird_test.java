import org.junit.*;
import static org.junit.Assert.*;

public class Bird_test {
    private Bird flyingBird;
    private Bird nonFlyingBird;

    @BeforeClass
    public static void setUpClass(){
        System.out.println("=== Starting Bird Class Unit Tests ===");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("=== All Bird Class Tests Completed ===");
    }

    @Before
    public void setup(){
        flyingBird = new Bird("Tweety", 1, true);
        nonFlyingBird = new Bird("Penguin", 4, false);
    }

    @After
    public void teardown(){
        flyingBird = null;
        nonFlyingBird = null;
    }

    /* CONSTRUCTOR TEST */
    @Test
    public void testConstructor() {
        assertEquals("Tweety", flyingBird._name);
        assertEquals(1, flyingBird._age);
        assertEquals("Penguin", nonFlyingBird._name);
        assertEquals(4, nonFlyingBird._age);
    }

}

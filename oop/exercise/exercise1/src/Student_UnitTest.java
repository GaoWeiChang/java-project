import org.junit.*;
import static org.junit.Assert.*;

public class Student_UnitTest {
    private Student student;

    @BeforeClass // จะรัน “ครั้งเดียว” ก่อน test ทั้งหมดใน class นั้น เรียกใช้แบบ static เท่านั้น
    public static void setUpClass() {
        System.out.println("=== Starting Student Class Unit Tests ===");
    }

    @AfterClass // จะรัน “ครั้งเดียว” หลังจาก test ทั้งหมดจบแล้ว
    public static void tearDownClass() {
        System.out.println("=== All Student Class Tests Completed ===");
    }

    @Before // จะรันก่อน @Test ทุกอัน ใช้สำหรับ setup เช่น สร้าง object
    public void setUp(){
        student = new Student();
    }

    @After // จะรันหลัง @Test ทุกอัน ใช้สำหรับเคลียร์ค่า ลบไฟล์ ปิดการเชื่อมต่อ
    public void tearDown() {
        student = null;
    }

    /* CONSTRUCTOR TESTS */
    @Test // ใช้กับเมธอดที่เราต้องการทดสอบ
    public void testConstructor(){
        Student default_student = new Student();
        Student param_student = new Student("Alice Johnson", 20, "ST001");

        assertEquals("Default constructor name should be empty string", "", default_student.get_name());
        assertEquals("Default constructor age should be 0", 0, default_student.get_age());
        assertEquals("Default constructor id should be empty string", "", default_student.get_id());

        assertEquals("Param constructor name should be Alice Johnson", "Alice Johnson", param_student.get_name());
        assertEquals("Param constructor age should be 20", 20, param_student.get_age());
        assertEquals("Param constructor id should be ST001", "ST001", param_student.get_id());
    }

    /* GETTER & SETTER TEST */
    @Test
    public void testGameName(){
        student.set_name("Mike");
        assertEquals("get_name() should return the correct name", "Mike", student.get_name());
    }

    @Test
    public void testGetAge(){
        student.set_age(12);
        assertEquals("get_age() should return the correct age", 12, student.get_age());
    }

    @Test
    public void testGetId(){
        student.set_id("CS123");
        assertEquals("get_id() should return the correct age", "CS123", student.get_id());
    }
}

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("John Doe", 20, "CS001");
        Student student2 = new Student("Jane Smith", 19, "CS002");
        Student student3 = new Student("Mike Johnson", 21, "CS003");

        student1.displayInfo();
        student2.displayInfo();
        student3.displayInfo();
    }
}

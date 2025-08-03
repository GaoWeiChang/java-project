public class Main {
    public static void main(String[] args) {
        // collection
        StudentCollection gradebook = new StudentCollection();

        Student[] sampleStudents = {
                new Student("S001", "Alice Johnson", "Freshman", 3.8, "Computer Science"),
                new Student("S002", "Bob Smith", "Sophomore", 3.2, "Mathematics"),
                new Student("S003", "Carol Davis", "Junior", 3.9, "Physics"),
                new Student("S004", "David Wilson", "Senior", 2.8, "Chemistry"),
                new Student("S005", "Emma Brown", "Freshman", 3.6, "Biology"),
                new Student("S006", "Frank Miller", "Junior", 3.4, "Computer Science"),
                new Student("S007", "Grace Lee", "Senior", 3.7, "Mathematics"),
                new Student("S008", "Henry Clark", "Sophomore", 2.9, "Physics"),
                new Student("S009", "Iris Taylor", "Freshman", 3.5, "Engineering"),
                new Student("S010", "Jack Anderson", "Senior", 3.1, "Biology")
        };

        for(Student student: sampleStudents){
            gradebook.addStudent(student);
        }

        // Test 1: All Students Iterator
        System.out.println("=== All Students ===");
        StudentIterator allStudents = gradebook.createAllStudentsIterator();
        int count = 0;
        while (allStudents.hasNext()) {
            System.out.println(allStudents.next());
            count++;
        }
        System.out.println("Total students: " + count + "\n");



        // Test 2: Grade Level Iterator
        System.out.println("=== Junior Students ===");
        StudentIterator juniorStudents = gradebook.createGradeLevelIterator("Junior");
        count = 0;
        while (juniorStudents.hasNext()) {
            System.out.println(juniorStudents.next());
            count++;
        }
        System.out.println("Total Junior students: " + count + "\n");



        // Test 3: High GPA Iterator
        System.out.println("=== High GPA Students (≥ 3.5) ===");
        StudentIterator highGpaStudents = gradebook.createHighGpaIterator(3.5);
        count = 0;
        while (highGpaStudents.hasNext()) {
            System.out.println(highGpaStudents.next());
            count++;
        }
        System.out.println("Total high GPA students: " + count + "\n");



        // Test 4: Multiple Simultaneous Iterations
        System.out.println("=== Testing Multiple Simultaneous Iterations ===");
        StudentIterator iter1 = gradebook.createAllStudentsIterator();
        StudentIterator iter2 = gradebook.createGradeLevelIterator("Senior");
        StudentIterator iter3 = gradebook.createHighGpaIterator(3.0);

        System.out.println("First student from each iterator:");
        if (iter1.hasNext()) System.out.println("All Students: " + iter1.next().getName());
        if (iter2.hasNext()) System.out.println("Senior Students: " + iter2.next().getName());
        if (iter3.hasNext()) System.out.println("High GPA Students: " + iter3.next().getName());

        System.out.println("\nSecond student from each iterator:");
        if (iter1.hasNext()) System.out.println("All Students: " + iter1.next().getName());
        if (iter2.hasNext()) System.out.println("Senior Students: " + iter2.next().getName());
        if (iter3.hasNext()) System.out.println("High GPA Students: " + iter3.next().getName());



        // Test 5: Reset Functionality
        System.out.println("\n=== Testing Reset Functionality ===");
        StudentIterator resetTest = gradebook.createHighGpaIterator(3.5);
        System.out.println("First iteration:");
        while (resetTest.hasNext()) {
            System.out.println("- " + resetTest.next().getName());
        }

        resetTest.reset();
        System.out.println("\nAfter reset - Second iteration:");
        while (resetTest.hasNext()) {
            System.out.println("- " + resetTest.next().getName());
        }
    }
}

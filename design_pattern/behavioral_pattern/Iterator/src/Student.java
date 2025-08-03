public class Student {
    private String studentId;
    private String name;
    private String gradeLevel;
    private double gpa;
    private String major;

    public Student(String studentId, String name, String gradeLevel, double gpa, String major){
        this.studentId = studentId;
        this.name = name;
        this.gradeLevel = gradeLevel;
        this.gpa = gpa;
        this.major = major;
    }

    // getter & setter
    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public String getGradeLevel() { return gradeLevel; }
    public double getGpa() { return gpa; }
    public String getMajor() { return major; }

    public void setStudentId(String studentId) { this.studentId = studentId; }
    public void setName(String name) { this.name = name; }
    public void setGradeLevel(String gradeLevel) { this.gradeLevel = gradeLevel; }
    public void setGpa(double gpa) { this.gpa = gpa; }
    public void setMajor(String major) { this.major = major; }

    @Override
    public String toString(){
        return String.format("%s: %s (%s, GPA: %.1f, Major: %s)",
                studentId, name, gradeLevel, gpa, major);
    }
}

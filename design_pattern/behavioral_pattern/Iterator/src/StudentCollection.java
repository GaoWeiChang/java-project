import java.util.ArrayList;
import java.util.List;

public class StudentCollection {
    List<Student> students;

    public StudentCollection(){
        students = new ArrayList<>();
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public int getSize(){
        return students.size();
    }

    public Student getStudent(int index){
        if (index < 0 || index >= students.size()){
            throw new IndexOutOfBoundsException("Invalid student index: " + index);
        }
        return students.get(index);
    }
}

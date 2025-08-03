import java.util.NoSuchElementException;

public class GradeLevelIterator implements StudentIterator {
    private StudentCollection collection;
    private String targetGradeLevel;
    private int currentIndex;

    public GradeLevelIterator(StudentCollection collection, String targetGradeLevel) {
        this.collection = collection;
        this.targetGradeLevel = targetGradeLevel;
        currentIndex = 0;
        findNextMatch(); // position at first matched student
    }

    @Override
    public boolean hasNext(){
        return currentIndex < collection.getSize() &&
                collection.getStudent(currentIndex).getGradeLevel().equals(targetGradeLevel);
    }

    @Override
    public Student next(){
        if(!hasNext()){
            throw new NoSuchElementException("No more" + targetGradeLevel + "students to iterate");
        }
        Student student = collection.getStudent(currentIndex++);
        findNextMatch();
        return student;
    }

    @Override
    public void reset(){
        currentIndex = 0;
        findNextMatch();
    }

    private void findNextMatch() {
        while (currentIndex < collection.getSize() &&
               !collection.getStudent(currentIndex).getGradeLevel().equals(targetGradeLevel)){
            currentIndex += 1;
        }
    }
}
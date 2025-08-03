import java.util.NoSuchElementException;

public class HighGpaIterator implements StudentIterator {
    private StudentCollection collection;
    private double minGpa;
    private int currentIndex;

    public HighGpaIterator(StudentCollection collection, double minGpa){
        this.collection = collection;
        this.minGpa = minGpa;
        this.currentIndex = 0;
        findNextMatch();
    }

    @Override
    public boolean hasNext(){
        return currentIndex < collection.getSize() &&
                collection.getStudent(currentIndex).getGpa() >= minGpa;
    }

    @Override
    public Student next(){
        if (!hasNext()){
            throw new NoSuchElementException("No more high GPA students to iterate");
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

    private void findNextMatch(){
        while (currentIndex < collection.getSize() &&
                minGpa > collection.getStudent(currentIndex).getGpa()){
            currentIndex += 1;
        }
    }
}

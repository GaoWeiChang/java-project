import java.util.NoSuchElementException;

public class AllStudentsIterator implements StudentIterator {
    private StudentCollection collection;
    private int currentIndex;

    public AllStudentsIterator(StudentCollection collection){
        this.collection = collection;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext(){
        return currentIndex < collection.getSize();
    }

    @Override
    public Student next(){
        if(!hasNext()){
            throw new NoSuchElementException("No more students to iterate");
        }
        return collection.getStudent(currentIndex++);
    }

    @Override
    public void reset(){
        currentIndex = 0;
    }
}

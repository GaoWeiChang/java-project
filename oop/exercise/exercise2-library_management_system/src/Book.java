public class Book {

    private String _title;
    private String _author;
    private String _isbn;
    private boolean _isavailable;

    // Constructor
    public Book(String title, String author, String isbn) {
        _title = title;
        _author = author;
        _isbn = isbn;
        _isavailable = true;
    }

    // Getter
    public String get_title() {
        return _title;
    }

    public String get_author() {
        return _author;
    }

    public String get_isbn() {
        return _isbn;
    }

    public boolean is_available() {
        return _isavailable;
    }

    public void set_available(Boolean is_available) {
        _isavailable = is_available;
    }

    @Override
    public String toString() {
        return _title + " by " + _author + " [" + (_isavailable ? "Available" : "Borrowed") + "]";
    }
}
public class Student {
    private String _name;
    private int _age;
    private String _id;

    // constructor
    public Student(){
        _name = "";
        _age = 0;
        _id = "";
    }

    public Student(String name, int age, String id){
        _name = name;
        _age = age;
        _id = id;
    }

    // getter and setter
    public String get_name(){
        return _name;
    }

    public int get_age(){
        return _age;
    }

    public String get_id(){
        return _id;
    }

    public void set_name(String name){
        _name = name;
    }

    public void set_age(int age){
        _age = age;
    }

    public void set_id(String id){
        _id = id;
    }

    // display student info
    public void displayInfo(){
        System.out.println("=====Student Information=====");
        System.out.println("Student ID : " + _id);
        System.out.println("Student Name : " + _name);
        System.out.println("Student Age : " + _age);
        System.out.println("=============================");
    }
}

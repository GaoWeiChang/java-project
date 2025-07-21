public class Animal {
    protected String _name;
    protected int _age;

    // constructor
    public Animal(){
        _name = "";
        _age = 0;
    }

    public Animal(String name, int age){
        _name = name;
        _age = age;
    }

    public void makeSound(){
        System.out.println(_name + " make a generic animal sound");
    }

    public void eat(){
        System.out.println(_name + " is eating");
    }

    public String getInfo(){
        return _name + " (" + _age + " years old)";
    }
}
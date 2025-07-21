public class Dog extends Animal{
    private String _breed;

    public Dog(String name, int age, String breed){
        super(name, age);
        _breed = breed;
    }

    @Override
    public void makeSound(){
        System.out.println(getInfo() + " says: Woof! Woof!");
    }

    @Override
    public void eat(){
        System.out.println(_name + " is eating dog food");
    }

    public void displayBreed(){
        System.out.println(_name + " is a "+_breed+" breed");
    }
}

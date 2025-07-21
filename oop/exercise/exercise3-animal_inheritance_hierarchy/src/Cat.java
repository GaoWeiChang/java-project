public class Cat extends Animal{

    public Cat(String name, int age){
        super(name, age);
    }

    @Override
    public void makeSound(){
        System.out.println(getInfo() + " says: Meow! Meow!");
    }

    @Override
    public void eat(){
        System.out.println(_name + " is eating fish");
    }

    public void groom(){
        System.out.println(_name + " is grooming itself");
    }
}
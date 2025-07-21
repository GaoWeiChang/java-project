public class Bird extends Animal {
    private boolean _canFly;

    public Bird(String name, int age, boolean canFly){
        super(name, age);
        _canFly = canFly;
    }

    @Override
    public void makeSound(){
        System.out.println(getInfo() + " says: Tweet! Tweet!");
    }

    @Override
    public void eat(){
        System.out.println(_name + " is eating seeds");
    }

    public void displayCanFly(){
        System.out.println(_name + " can fly: " + _canFly);
    }
}

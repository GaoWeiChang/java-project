public class Main {
    public static void main(String[] args) {

        Animal[] animals = new Animal[3];
        animals[0] = new Dog("Buddy", 2, "Golden Retriever");
        animals[1] = new Cat("Whiskers", 3);
        animals[2] = new Bird("Tweety", 1, true);

        System.out.println("=== POLYMORPHISM DEMONSTRATION ===");

        for (Animal animal : animals) {
            animal.makeSound();
            animal.eat();

            if (animal instanceof Dog) {
                ((Dog) animal).displayBreed();
            } else if (animal instanceof Cat) {
                ((Cat) animal).groom();
            } else if (animal instanceof Bird) {
                ((Bird) animal).displayCanFly();
            }

            System.out.println();
        }

        System.out.println("=== DIRECT OBJECT CREATION ===");

        Dog dog = new Dog("Max", 4, "Labrador");
        Cat cat = new Cat("Fluffy", 2);
        Bird bird = new Bird("Robin", 1, true);
        dog.makeSound();
        dog.eat();
        dog.displayBreed();

        System.out.println();

        cat.makeSound();
        cat.eat();
        cat.groom();

        System.out.println();

        bird.makeSound();
        bird.eat();
        bird.displayCanFly();
    }
}

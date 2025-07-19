import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String item;
        double price;
        int quantity;
        double total;
        char currency = '$';

        System.out.print("What item you want to buy : ");
        item = scanner.nextLine();

        System.out.print("What is price for each : ");
        price = scanner.nextDouble();

        System.out.print("How many would you like : ");
        quantity = scanner.nextInt();

        total = quantity * price;

        System.out.println("\nYou have bought "+ quantity +" "+ item);
        System.out.println("Total price : "+currency+total);

        scanner.close();
    }
}

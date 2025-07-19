import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numOfDice;
        int total = 0;

        System.out.print("Enter the number of dice to roll : ");
        numOfDice = scanner.nextInt();

        // roll the dice
        if(numOfDice > 0){
            for(int i=0;  i<numOfDice; i++){
                int roll = random.nextInt(1, 7);
                total += roll;
                printDie(roll);
            }
            System.out.println("Total : " + total);
        }else{
            System.out.println("Number of dice must greater than zero");
        }

        scanner.close();
    }

    static void printDie(int roll){
        String dice1 = """
                        _______
                       |       |
                       |   ●   |
                       |       |
                        -------
                       """;

        String dice2 = """
                        _______
                       |●      |
                       |       |
                       |      ●|
                        -------
                       """;

        String dice3 = """
                        _______
                       |●      |
                       |   ●   |
                       |      ●|
                        -------
                       """;

        String dice4 = """
                        _______
                       |●     ●|
                       |       |
                       |●     ●|
                        -------
                       """;

        String dice5 = """
                        _______
                       |●     ●|
                       |   ●   |
                       |●     ●|
                        -------
                       """;

        String dice6 = """
                        _______
                       |●     ●|
                       |●     ●|
                       |●     ●|
                        -------
                       """;

        switch (roll){
            case 1 -> System.out.print(dice1);
            case 2 -> System.out.print(dice2);
            case 3 -> System.out.print(dice3);
            case 4 -> System.out.print(dice4);
            case 5 -> System.out.print(dice5);
            case 6 -> System.out.print(dice6);
            default -> System.out.println("Invalid roll");
        }
    }
}

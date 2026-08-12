import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        // Generate a random number between 1 and 100
        int number = random.nextInt(100)+1;

        int guess = 0;
        int attempts = 0;

        System.out.println("===== Number Guessing Game=====");
        System.out.println("I have chosen a number between 1 and 100.");
        System.out.println("Try to guess it!");

        while(guess!=number){

            System.out.print("Enter your guess: ");
            guess = sc.nextInt();
            attempts++;

            if(guess < number){
                System.out.println("Too loo! Try again.");
            }
            else if(guess > number){
                System.out.println("Too high! Try again.");
            }
            else{
                System.out.println("Congratulations! Your guess was correct.");
                System.out.println("Number of Attempts: "+ attempts);
            }

        }
        sc.close();
    }
}
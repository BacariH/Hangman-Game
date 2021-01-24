package oof.company;
import java.util.Scanner;

public class Prompter {
    //importing game and all of its method to be used by this class
    private Game game;

    //making a constructor that will use the game class
    public Prompter(Game game){
        this.game = game;
    }

    //this method takes asks the user for a guess in the console.
    //when the user enters in a string, letter, or null value it tries to see if it is a valid param

    public boolean promptForGuess(){
        Scanner scanner = new Scanner(System.in);
        boolean isHit = false;
        boolean isAcceptable = false;

        do {
            System.out.print("Enter a letter: ");
            String guessInput = scanner.nextLine();
            try {
                isHit = game.applyGuess(guessInput);
                isAcceptable = true;
            }catch(IllegalArgumentException iae) {
                System.out.printf("%s. Please try again. %n", iae.getMessage());
            }
        }while(!isAcceptable);
        return isHit;
        }

        public void displayProgress(){
            System.out.printf("You have %d tries left to solve: Try to solve: %s%n", game.getRemainingTries(), game.getCurrentProgress());
        }

        public void displayOutcome(){
                if (game.isWon()) {
                System.out.printf("Congratulations you won with %d number of tries left. %n", game.getRemainingTries());
                } else {
                System.out.printf("You lost..You do not have anymore tries left. The word was %S%n", game.getAnswer());
                }
            }
        }
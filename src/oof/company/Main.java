package oof.company;

public class Main {

    public static void main(String[] args) {
        //this allows the user to push a String into a the console as a argument
	if(args.length == 0){
        System.out.println("Usage: java Hangman <answer>");
        System.err.println("Guessing word is required.");
        System.exit(1);
    }
	//making a new game instance that takes the guessing word(answer) in as a param
	Game game = new Game(args[0]);

	//the prompter class is initialized and takes in the game as a param
	Prompter prompter = new Prompter(game);
	while(game.getRemainingTries() > 0 && !game.isWon()){
	    prompter.displayProgress();
	    prompter.promptForGuess();
	 }
	prompter.displayOutcome();
    }
}

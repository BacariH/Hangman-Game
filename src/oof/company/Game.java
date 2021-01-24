package oof.company;

public class Game {
    //this class contains our game logic
    //Defining or variables
    public static final int MAX_MISSES = 7;
    private String answer;
    private String hits;
    private String misses;

    //Building the constructor
    public Game(String answer){
        this.answer = answer;
        this.misses = "";
        this.hits = "";
    }

    //building a getter to retreive the answer

    public String getAnswer() {
        return this.answer;
    }

    //making a method to check for valid letters and if the letter has already been used.
    //this method can only be used on this class.
    private char normalizeGuess(char letter){

        if(!Character.isLetter(letter)){
            throw new IllegalArgumentException("A letter is required.");
        }
        letter = Character.toLowerCase(letter);
        if(misses.indexOf(letter) != -1 || hits.indexOf(letter) != -1){
            throw new IllegalArgumentException(letter + " has already benn guessed");
        }
        return letter;
    }

    //this method will return a true or false value based on the result of normalizedGuess
    //it then will apply logic to see if the letter that was guessed is correct or wrong.
    public boolean applyGuess(char letter){
        letter = normalizeGuess(letter);
        boolean isHit = answer.indexOf(letter) != -1;
        if(isHit){
            hits += letter;
        } else {
            misses += letter;
        }
        return isHit;
    }

    //this method will check to see if the answer field is blank and if it is throw an error
    //after checking to see if the field is blank or not the it converts the String into a Char and since it is a truthy value it returns true.
    public boolean applyGuess(String letters){
        if(letters.length() == 0){
            throw new IllegalArgumentException("No letter found.");
        }
        return applyGuess(letters.charAt(0));
    }

    //making a method that returns the number of remaining tries a user has
    public int getRemainingTries(){
        int a;
        a = MAX_MISSES - misses.length();
        return a;
    }

    //this method returns a string based on the answer. If a player gets a correct letter
    //then display updates to show the letter
    public String getCurrentProgress(){
        String progress = "";
        for (char letter : answer.toCharArray()){
            char display = '_';
            if(hits.indexOf(letter) != -1){
                display = letter;
            }
            progress += display;
        }
        return progress;
    }

    //this method is just to show if the user has won or not.
    public boolean isWon(){
        //when all of the blanks are gone then we know the user has won, if not then this method returns falsey.
        return getCurrentProgress().indexOf('_') == -1;
    }



}

import java.util.Random;
import java.util.Scanner;
/**
 * Write a guessing game which prompts a user to guess a mystery number within some range.
After every guess the program should display some variation of "too large", "too small", "correct guess", respectively.
Upon termination, the program should display the number of guesses before successfully guessing correctly.
A number that is input consecutively, should register as a single guess.
 *
 * @author Caleb Powell
 * @version 5.22.19
 */
public class Game{
    private int mysteryNum;
    private int lastGuess, currentGuess;
    private int numberOfGuesses;
    private int lowerBound, upperBound;
    
    private boolean victory;
    
    private Scanner input = new Scanner(System.in);

    /**
     * Constructor for objects of class Game
     */
    public Game(){
        this(1,10);
    }

    public Game(int lowNum, int highNum){
        if (lowNum < highNum) {
            lowerBound = lowNum;
            upperBound = highNum;
        } else if (lowNum > highNum){
            lowerBound = highNum;
            upperBound = lowNum;
            System.out.println("Lower bound was bigger than upper bound, flipping them.");
        } else {
            System.out.println("Lower bound and upper should be different. Setting to 1 and 10.");
            lowerBound = 1;
            upperBound = 10;
        }
        
        Random randomGen = new Random();
        mysteryNum = randomGen.nextInt(upperBound - lowerBound + 1) + lowerBound;
        
        //lastGuess = 0;
        numberOfGuesses = 0;
        
        victory = false;
    }
    
    public void check(){
        System.out.printf("Enter and integer guess between %d and %d", lowerBound, upperBound);
        currentGuess = input.nextInt();
        numberOfGuesses++;
        
        if(currentGuess == lastGuess) {
            System.out.printf("Your guess %d, was the same as the last guess. Choose again\n", lastGuess);
            numberOfGuesses--;
        } else if(currentGuess > mysteryNum){
            if(currentGuess > upperBound){
                numberOfGuesses--;
                System.out.printf("Your guess of %d was higher than the upper bound of %d.\nTry again (no penalty)\n", currentGuess, upperBound);
                showGuesses(false);
            } else {
                System.out.printf("Your guess of %d was too high.\n", currentGuess);
                showGuesses(false);
            }
        } else if(currentGuess < mysteryNum){
            if(currentGuess < lowerBound){
                numberOfGuesses--;
                System.out.printf("Your guess of %d was lower than the lower bound of %d.\nTry again (no penalty)\n", currentGuess, lowerBound);
                showGuesses(false);
            } else {
                System.out.printf("Your guess of %d was too low.\n", currentGuess);
                showGuesses(false);
            }
        } else if(currentGuess == mysteryNum){
            victory = true;
            System.out.println("You guessed it!");
            showGuesses(true);
        }
        
        lastGuess = currentGuess;
    }
    
    public boolean getVictory(){
        return victory;
    }
    
    public void showGuesses(boolean win){
        if(win){
            System.out.printf("You took %d guesses to win. Nice.\n",numberOfGuesses);
        } else {
            System.out.printf("You've guessed %d times so far.\n",numberOfGuesses);
        }
    }
}

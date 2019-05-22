import java.util.Scanner;
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    // instance variables - replace the example below with your own
    private static Game currentGame;
    private static int low, high;
    
    private static Scanner input;

    /**
     * Constructor for objects of class Main
     */
    public Main(){
    }

    public static void main(String[] args)
    {
        input = new Scanner(System.in);
        
        System.out.println("Enter the lower bound (inclusive)");
            low = input.nextInt();
            input.reset();
        System.out.println("Enter the upper bound (inclusive)");
            high = input.nextInt();
            input.reset();
            
        currentGame = new Game(low, high);
        
        
        while(!currentGame.getVictory()){
            currentGame.check();
        }
        
    }
}

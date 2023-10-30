/*
 * Activity 2.5.2
 *
 *  The PhraseSolver class the PhraseSolverGame
 */
import java.util.Scanner;
  
public class PhraseSolver
{
  /* your code here - attributes */
  private Player player1; 
  private Player player2; 
  private Board board; 
  private boolean solved; 

  /* your code here - constructor(s) */ 
  public PhraseSolver() {
    player1 = new Player(); 
    player2 = new Player(); 
    board = new Board(); 
    solved = false; 
  }

  public void play()
  {
    boolean solved = false;
    int currentPlayer = 1;

    Scanner input = new Scanner(System.in);
    
    boolean correct = true;
    while (!solved) 
    {
      String guess = input.nextLine(); 
      /* your code here - game logic */
      solved = board.guessLetter(guess); 
    } 
   
  }
  
}
/*
 * Activity 2.5.2
 *
 * A Board class the PhraseSolverGame
 */
import java.util.Scanner;
import java.io.File;

public class  Board
{
  private String solvedPhrase;
  private String phrase;
  private int currentLetterValue; 

  // constructor that sets the initial values of the instance variables 
  public Board() {
    solvedPhrase = ""; 
    phrase = loadPhrase(); 
    currentLetterValue = 0;
  }

  public String getPhrase() {
    return phrase; 
  }
  public String getSolvedPhrase(){
    return solvedPhrase;
  }


  /* ---------- provided code, do not modify ---------- */
  public void setLetterValue()
  {
    int randomInt = (int) ((Math.random() * 10) + 1) * 100;    
    currentLetterValue = randomInt;
  }

  public boolean isSolved(String guess)
  {
    if (phrase.equals(guess))
    {
      return true;
    }
    return false;
  }

  private String loadPhrase()
  {
    String tempPhrase = "";
    
    int numOfLines = 0;
    try 
    {
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        tempPhrase = sc.nextLine().trim();
        numOfLines++;
      }
    } catch(Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
		int randomInt = (int) ((Math.random() * numOfLines) + 1);
    
    try 
    {
      int count = 0;
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        count++;
        String temp = sc.nextLine().trim();
        if (count == randomInt)
        {
          tempPhrase = temp;
        }
      }
    } catch (Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
    for (int i = 0; i < tempPhrase.length(); i++)
    {
      if (tempPhrase.substring(i, i + 1).equals(" "))
      {
        solvedPhrase += "  ";
      }  
      else
      {
        solvedPhrase += "_ ";
      }
    }  

    return tempPhrase;
  }  

  public boolean guessLetter(String guess)
  {
    /* Preconditions 
     * guess is an actual letter 
     * solvedPhrase has underscores in the right places 
     * Postconditions 
     * foundLetter is true 
     * solvedPhrase has the letters guessed along with the underscores for other places 
     */

    // initial values of variables 
    // foundLetter is false beause the right letter has not been found 
    // newSolvedPhrase is empty because nothing has been guessed yet 
    boolean foundLetter = false;
    String newSolvedPhrase = "";
    
    // for each letter in the chosen phrase, check if any letter is equivalent to the guess 
    for (int i = 0; i < phrase.length(); i++)
    {
      if (phrase.substring(i, i + 1).equals(guess)) // if the letters are equal, add it to the newSolvedPhrase
      {
        newSolvedPhrase += guess + " ";
        foundLetter = true;
      }
      else
      {
        newSolvedPhrase += solvedPhrase.substring(i * 2, i * 2 + 1) + " ";  // if not, copy the underscores 
      }
    }
    solvedPhrase = newSolvedPhrase; // set new value of solvedPhrase 
    return foundLetter; // return the boolean value 
  } 
} 

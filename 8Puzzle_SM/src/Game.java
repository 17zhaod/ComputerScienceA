import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Game
{
  public static void main(String[] args)
  {
    int choice = 0;
    ArrayList<Integer> scores = new ArrayList<Integer>();
    System.out.println("Welcome to the N-puzzle!");
    //plays the game
    while(true)
    {
      int size = 0;
      int moves = 0;
      Scanner keyboard = new Scanner(System.in);
      System.out.println("How big of a puzzle do you want?");
      if(keyboard.hasNextInt())
      {
        size = keyboard.nextInt();
        if(size < 2)
        {
          System.out.println("That's not a valid size. Let's just go with 3.");
          size = 3;
        }
      }
      Board game = new Board(size);
      //continues making moves until you win
      while(true)
      {
        game.randomize();
        if(game.isWinnable())
        {
          break;
        }
      }
      game.print();
      int move = 0;
      while(true)
      {
        if(haveWon(game))
        {
          System.out.println("You've Finished!");
          System.out.println("You used " + moves + " moves.");
          if(moves == 0)
          {
            System.out.println("You were really lucky on that one (;");
          }
          break;
        }
        System.out.println("Which tile would you like to move?");
        if(keyboard.hasNextInt())
        {
          move = keyboard.nextInt();
        }
        game.moveTile(move);
        moves++;
        game.print();
      }
      scores.add(moves);
      sort(scores);
      printScores(scores);
      System.out.println("Press 1 to play again, 2 to stop");
      if(keyboard.hasNextInt())
      {
        choice = keyboard.nextInt();
      }
      if(choice == 2)
      {
        keyboard.close();
        break;
      }
    }
    
  }
  
  //checks for win
  private static boolean haveWon(Board b)
  {
    for(int i=0;i<b.board.length;i++)
    {
        for(int j=0;j<b.board[i].length;j++)
        {
            if(b.board[i][j].getValue() != (i+1+b.dim*(j))%(b.dim*b.dim))
            {
              return false;
            }
        }
    }
    return true;
  }
  
  private static void printScores(ArrayList<Integer> l)
  {
    System.out.print("High Scores: | ");
    for(int i=0;i<l.size();i++)
    {
      System.out.print(l.get(i) + " | ");
    }
    System.out.println("");
  }
  
  private static void sort(ArrayList<Integer> l)
  {
    Collections.sort(l);
  }
  
}

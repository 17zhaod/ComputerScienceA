import java.util.Scanner;

public class Game
{
  public static void main(String[] args)
  {
    int size = 0;
    int moves = 0;
    Scanner keyboard = new Scanner(System.in);
    System.out.println("How big of a puzzle do you want?");
    if(keyboard.hasNextInt())
    {
      size = keyboard.nextInt();
    }
    Board game = new Board(size);
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
      System.out.println("Which tile would you like to move?");
      if(keyboard.hasNextInt())
      {
        move = keyboard.nextInt();
      }
      game.moveTile(move);
      moves++;
      game.print();
      if(haveWon(game))
      {
        System.out.println("You've Finished!");
        System.out.println("You used " + moves + " moves.");
        break;
      }
    }
    
    keyboard.close();
  }
  
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
}

import java.util.ArrayList;

public class Board
{
  public int dim;
  public Tile[][] board;


  public Board(int size)
  {
    dim = size;
    board = new Tile[dim][dim];
    for(int i=0;i<board.length;i++)
    {
        for(int j=0;j<board[i].length;j++)
        {
             board[i][j] = new Tile((i+1+dim*(j))%(dim*dim), i, j);
       }
    }
  }
  
  public void randomize()
  {
    ArrayList<Integer> allValues = new ArrayList<Integer>();
    allValues.clear();
    for(int a=0;a<dim*dim;a++)
    {
      allValues.add(a);
    } 
    for (int k = allValues.size() - 1; k > 0; k--) {
      int howMany = k + 1;
      int start = 0;
      int randPos = (int) (Math.random() * howMany) + start;
      int temp = allValues.get(k);
      allValues.set(k, allValues.get(randPos));
      allValues.set(randPos, temp);
    }
    for(int i=0; i<board.length;i++)
    {
      for(int j=0; j<board[i].length;j++)
      {
        board[i][j].setValue(allValues.get(dim*i+j));
      }
    }
  }
  
  //not working for even?
  public boolean isWinnable()
  {
    ArrayList<Integer> existingValues = new ArrayList<Integer>();
    for(int i=0;i<board.length;i++)
    {
        for(int j=0;j<board[i].length;j++)
        {
            if(board[j][i].getValue()!=0)
            {
              System.out.print(board[j][i].getValue());
              existingValues.add(board[j][i].getValue());
            }
        }
    }
    //number of inversions (ignoring 0)
    int inversions = 0;
    for(int i=0;i<existingValues.size()-1;i++)
    {
        for(int j=i+1;j<existingValues.size();j++)
        {
            if(existingValues.get(i)>existingValues.get(j))
            {
              inversions++;
            }
        }
    }
    
    int blankY = findTile(0).getYPosition();
    
    System.out.println("");
    System.out.println(inversions);
    if(dim%2==1)
    {
      return (inversions%2==1);
    }
    else
    {
      if(blankY%2==0)
      {
        return (inversions%2==1);
      }
      else
      {
        return (inversions%2==0);
      }
    }
  }


  public void moveTile(int number)
  {
    Tile t = findTile(number);
    Tile z = findTile(0); 
    if(hasOpen(t).equals("N") || number > dim*dim-1)
    {
      System.out.println("Invalid Move");
    }
    else
    {
      z.setValue(t.getValue());
      t.setValue(0);
    }
  }
 
  public String hasOpen(Tile t)
  {
    int x1 = t.getXPosition()-1;
    int x2 = t.getXPosition()+1;
    int y1 = t.getYPosition()-1;
    int y2 = t.getYPosition()+1;
    if(x1!=-1)
    {
      if(findTile(x1, t.getYPosition()).getValue()==0)
      {
        return "L";
      }
    }
    if(x2!=dim)
    {
      if(findTile(x2, t.getYPosition()).getValue()==0)
      {
        return "R";
      }
    }
    if(y1!=-1)
    {
      if(findTile(t.getXPosition(), y1).getValue()==0)
      {
        return "D";
      }
    }
    if(y2!=dim)
    {
      if(findTile(t.getXPosition(), y2).getValue()==0)
      {
        return "U";
      }
    }
      return "N";
  }
  
  public Tile findTile(int number)
  { 
    for(int i=0;i<board.length;i++)
    {
        for(int j=0;j<board[i].length;j++)
        {
            if(board[i][j].getValue() == number)
            {
              return board[i][j];
            }
        }
    }
      return null;
  }

  public Tile findTile(int x, int y)
  {
    for(int i=0;i<board.length;i++)
    {
        for(int j=0;j<board[i].length;j++)
        {
            if(board[i][j].getXPosition() == x && board[i][j].getYPosition() == y)
            {
              return board[i][j];
            }
        }
    }

    return null;
  }
  
  public void print() {
    System.out.println("*===========*");
    for(int j = 0; j < dim; j++)
    {
        System.out.print("||");
        for(int i = 0; i < dim; i++)
        {
            if(findTile(i, j).getValue() == 0)
            {
              System.out.print("  ");
            }
            else if(findTile(i, j) != null)
            {
              if(findTile(i, j).getValue()<10)
              {
                System.out.print(" " + findTile(i, j).getValue());
              }
              else
              {
                System.out.print(findTile(i, j).getValue());
              }
            }
        }
        System.out.println("||");
    }
    System.out.println("*===========*");
  }

}




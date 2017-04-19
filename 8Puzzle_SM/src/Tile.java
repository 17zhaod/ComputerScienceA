
public class Tile
{
  private int value;
  private int x;
  private int y;
  
  public Tile(int value, int x, int y)
  {
    this.value = value;
    this.x = x;
    this.y = y;
  }
  
  public void setPos(int x, int y)
  {
    this.x = x;
    this.y = y;
  }

  public int getXPosition()
  {
      return x;
  }
  
  public int getYPosition()
  {
      return y;
  }
  
  public void setValue(int value)
  {
      this.value = value;
  }
  
  public int getValue()
  {
      return value;
  }

}

public class SelectionSort
{
  public static void main(String[] args)
  {
    int[] first = {1, 4, 5, 3, 2};
    for(int index = 0; index < first.length - 1; index++)
    {
      int minIndex = index;
      for(int i = minIndex; i < first.length; i++)
        {
            if(first[i] < first[minIndex])
            {
               minIndex = i;
            }
        }
      int temp = first[index];
      first[index] = first[minIndex];
      first[minIndex] = temp;
    }
    
    for(int i = 0; i<first.length; i++)
    {
      System.out.println(first[i]);
    }
  }
}

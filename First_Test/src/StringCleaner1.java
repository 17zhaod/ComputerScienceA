import java.util.Scanner;

public class StringCleaner1
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Enter a string: ");
    String input = keyboard.nextLine();
    System.out.println("Type 'l' to remove letters, 'n' to remove numbers, 'p' to remove punctuation");
    String choice = keyboard.nextLine();
    String output = "";
    
    for(int i=0;i<input.length();i++)
    {
      int ascii = (int) input.charAt(i);
      
      if(choice.equals("l"))
      {
        if(!((ascii > 64 && ascii < 91) || (ascii > 96 && ascii < 123)))
        {
          output += input.charAt(i);
        }
      }
      else if(choice.equals("n"))
      {
        if(!(ascii > 47 && ascii < 58))
        {
          output += input.charAt(i);
        }
      }
      else if(choice.equals("p"))
      {
        if(!((ascii > 32 && ascii < 48) || (ascii > 57 && ascii < 65) || (ascii > 90 && ascii < 97) || (ascii > 122 && ascii < 127)))
        {
          output += input.charAt(i);
        }
      }
    }
    System.out.println(output);
    keyboard.close();
  }
}

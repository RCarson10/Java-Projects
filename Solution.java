/**
* Gaj Carson
* Loops
*/
import java.util.*;

public class Solution
{
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);

		System.out.print("Give me an integer: ");
		int num1 = kb.nextInt();



			for(int i = 0 ; i < num1 ; i++)
			{
				for( int row = 0; i > row ; row++)
				{
					System.out.print(" ");
				}

				for(int column = num1 ; column > i ; column--)
			{
					System.out.print("*");
			}
			System.out.println();
		    }
			System.out.println();

			}
}
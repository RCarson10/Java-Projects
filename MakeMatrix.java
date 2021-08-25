/**
 * Ask the user for a number n.  Create an n by n matrix.  Number the values consecutively
 * starting in the upper left-hand corner.  Print the result to the screen.
 * For example, if n were 4:
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * 13 14 15 16
 */

import java.util.*;
public class MakeMatrix
{
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter a number: ");

        //Uncomment and complete the following lines of code:

		int n = Math.abs(kb.nextInt());
		System.out.println();

		int [][] m = new int[3][4];

		fillMatrix(m);

		printMatrix(m);

	}

    //Your methods go here
	public static void fillMatrix(int[][] m)
	{
	    int counter = 1;
	    for(int r = 0; r < m.length; r++)
	    {
	        for(int c = 0; c < m[r].length; c++)
	        {
	            m[r][c] = counter;
	            counter++;
	        }
	    }
	}
	public static void printMatrix(int[][] m)
	{
	    for(int r = 0; r < m.length; r++)
	    {
    	    for(int c = 0; c < m[r].length; c++)
    	    {
    	        System.out.print(m[r][c] + " ");
    	    }
	        System.out.println(m[2][2]);
	    }
	}
}
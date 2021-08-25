/**
 * Ask the user for a number n.  Create an array with the numbers from 1 to n
 * in positions 0 through n-1.  Write a method to display an array.  Display
 * the array to the screen in the given format: [1, 2, 3, 4, 5, 6, 7].
 * Hint - displaying in this format is tricky.  You're going to have to do
 * some of the work outside of your loop.
 * Gaj Carson
 */

import java.util.*;
public class DisplayArray
{
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);

		System.out.print("Give me a number: ");
		int n = kb.nextInt();

        //Create array of length n, named a
		//YOUR CODE HERE
        int[]a = new int[n];
        //Fill the array with numbers 1 - n
        fillArray(a);
        
        //print the array in the specified format: [1, 2, 3, 4, ... n]
        //Remember, this is tricky.  You'll have to do some of the work outside
        //of the loop
		System.out.print("["); 
		printArray(a); 
	}

    //Write your methods here
    public static void fillArray(int[] a)
	{
		for(int i = 0; i < a.length; i++)
		{
			a[i] = i+1;
		}
	}

	public static void printArray(int[] a)
	{
		for(int i = 0; i < a.length; i++)
		{
		   if(i < a.length - 1)
		    System.out.print(a[i] + ", ");
			else
			System.out.println(a[i] + "]");
		}
		System.out.println();
	}
}
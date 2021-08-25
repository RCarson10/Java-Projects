import java.util.*;
import java.text.NumberFormat;

public class DiceGame
{
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);

		System.out.println("How many sides should the second die have?\n"); //Grabbing the size of the second dice
		int NumSides = kb.nextInt();

		System.out.println("How many times should we roll the dice?\n"); //Asking how many times to execute
		int rolls = kb.nextInt();

		System.out.println("How many times should we print the results?\n"); //Asking how many times they'd like to see the answer
		int prntRes = kb.nextInt();

		System.out.println();//Flush out the enter stuck in the input stream

		System.out.println("What is your name?\n "); //Grabbing their name
		String uName = kb.nextLine();
		int uLength = uName.length();

		Die myDie = new Die(); 	//Creating an instance of the die
		Die myDie2 = new Die(NumSides);

		int dTotal = 0 ;

		if( uLength > 5)	//Printing the name, if it's more than 5 chars then print a substring
		System.out.println("Experiment by:\n " + uName.substring(0,5) + "\n");
		else
		System.out.println("Experiment by:\n " + uName + "\n");

		NumberFormat money = NumberFormat.getCurrencyInstance();//Creating the currency instance to make the output look like a currency

		double mTotal = 0.0;
		double uAverage = 0.0;


		for(int i = 1; i < rolls; i++)
		{
			dTotal = myDie.roll() + myDie2.roll(); //Rolling both die as much as the user requested

			if(dTotal == 5)
			{
				mTotal += 8;
			}
			if(dTotal < 5)
			{
				mTotal += 3;
			}
			if(dTotal > 5)
			{
				mTotal -= 2;
			}

			uAverage = (double)mTotal/i;

			if(i % prntRes == 0) //This makes sure the output will only print as much as the user had requested
			System.out.println("Rolls: " + i + " Average winning per roll: " + money.format(uAverage)+ "\n" );
		}
		System.out.println("Rolls: " + rolls + " Average winning per roll: " + money.format(uAverage)+ "\n" );
	}
}
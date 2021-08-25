//This class will show the use of ArrayLists with a bit of Generics in the mix as well

import java.util.*;
import java.util.ArrayList;

public class EvenDeck
{
	private ArrayList<Integer> nList;
	public EvenDeck(int n)
	{
		if( n%2==1 || n <= 0)
			throw new IllegalArgumentException("Input invalid good sir");
		this.nList = new java.util.ArrayList<Integer>(); //Creating an array list that specifically holds strings

		for(int i = 1; i <= n;i++)//At i, the loop should add whatever i is to the i spot
		{
			this.nList.add(i);
		}
	}
	public EvenDeck()//The default will be a list of numbers from 1 to 8
	{
		this.nList = new java.util.ArrayList<Integer>(8);
		for(int i = 1; i <= 8;i++)//At i, the loop should add whatever i is to the i spot
		{
			this.nList.add(i);
		}
	}
	public String toString()//Array list has it's own toString method
	{
		return nList.toString();
	}
	public boolean equals(Object obj)//ArrayList has it's own equals method
	{
		if(obj == null)
			return false;

		if(this.getClass() != obj.getClass())
			return false;

		EvenDeck objList = (EvenDeck)obj;

		return objList.toString().equals(nList.toString());
	}
	public void perfectShuffle()//Creating the shuffle using nList and the algorithim from the rosetta site
	{

		int count = 0;
		ArrayList<Integer> temp = new java.util.ArrayList<Integer>();
		int half = nList.size()/2;

			for (int i = 0; i < half ; i++)
			{
				temp.add(nList.get(i));
				temp.add(nList.get(i + half));
			}

				nList = temp;
     }


	public int numShuffles()//Return how many shuffles it took to obtain a perfect shuffle
	{
		ArrayList<Integer> another = new ArrayList<Integer>(nList);
		int result = 0;
		do
		{
			perfectShuffle();
			result++;
		}
		while(another.equals(nList)==false);


		return result;
	}
}





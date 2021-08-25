//This class will showcase a Doubly Linked List that can hold very large numbers without using too much memory
import java.util.*;
import java.util.StringTokenizer;

public class InfiniteInt extends DLList<Integer> implements Comparable<InfiniteInt>
{

	public InfiniteInt()//Creates a new DLList and then sets it to empty
	{
			super();
	}
	public InfiniteInt(String iNumstr)//Creates a tokenizer and then breaks up the string into number tokens and then adds it into the List
	{
		try
		{
			StringTokenizer tokenizer = new StringTokenizer(iNumstr , ",");
			tokenizer.countTokens();


			while(tokenizer.hasMoreTokens())
			{
				String token = tokenizer.nextToken();
				this.addLast(Integer.parseInt(token));

			}
		}
		catch(NumberFormatException e)
		{
			throw new IllegalArgumentException("The integer parsing will only work with a string that contains number and comma's in the correct format");
		}

	}
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;

		if(this.getClass() != obj.getClass())
			return false;

		InfiniteInt objIint = (InfiniteInt)obj;

		return this.toString().equals(objIint.toString());



	}

	public String superToString() //Calling the parents toString method
	{
		return super.toString();
	}
	public String toString()//This toString will override the supertoString in the case that the add method in this class is used
	{
		if(this.isEmpty() == true)
			throw new IllegalStateException("There is no number to print");

		String intToStr = "";
		DLLNode<Integer> cursor = this.head;
		while( cursor != null)
		{
			if(cursor == head && cursor == tail)
			{
			  if((cursor.data < 100 && cursor.data >= 10) && cursor.data % 10 == 0)
				  intToStr += cursor.data + "0";
			  else if(cursor.data > 100 && cursor.data % 100 == 0)
				  intToStr += cursor.data + "00,";
			  else
			      intToStr += cursor.data;
			}
			else if(cursor == tail)
			{
			   if(cursor.data < 10)
			 	 intToStr += "00" + cursor.data;
			   else if(cursor.data < 100 && cursor.data >= 10)
			   	 intToStr += "0" + cursor.data;
			   else if((cursor.data < 100 && cursor.data >= 10) && cursor.data % 10 == 0)
			 	  intToStr += "0" + cursor.data + "0";
			   else if(cursor.data > 100 && cursor.data % 100 == 0)
			  	  intToStr += cursor.data + "00";
			   else
			  	 intToStr += cursor.data;
		  	}
			else if(cursor == head)
			{
			  if((cursor.data < 100 && cursor.data >= 10) && cursor.data % 10 == 0)
			 	  intToStr += cursor.data + "0";
			  else if(cursor.data > 100 && cursor.data % 100 == 0)
			  	  intToStr += cursor.data + "00,";
			  else
			      intToStr += cursor.data + ",";
		  	}
			else if(cursor.data > 100 && cursor.data % 100 == 0)
			  	intToStr += cursor.data + "00,";
			else if(cursor.data < 10)
			   intToStr += "00" + cursor.data + ",";
			else if(cursor.data < 100 && cursor.data >= 10)
			   intToStr += "0" + cursor.data + ",";
			else if((cursor.data < 100 && cursor.data >= 10) && cursor.data % 10 == 0)
			 		intToStr += "0" + cursor.data + "0,";
			else
				intToStr += cursor.data + ",";

				cursor = cursor.next;
		}

		return intToStr;

	}
	public static InfiniteInt add(InfiniteInt int1, InfiniteInt int2 )//This method will add two infinite ints together and return them as one infinite int
	{
		int carry = 0;
		int sum = 0;


		DLLNode<Integer> cursor1 = int1.tail;
		DLLNode<Integer> cursor2 = int2.tail;


		InfiniteInt int3 = new InfiniteInt();


		while(cursor1 != null || cursor2 != null)
		{
			if(cursor2 == null && cursor1 != null)
				sum = carry + cursor1.data;
			else if(cursor2 != null && cursor1 == null)
				sum = carry + cursor2.data;
			else
				sum = carry + cursor1.data + cursor2.data;
			if( sum > 999)
			{
				carry = 1;
				sum = (sum - 1000) ;
			}
			else
			{
				carry = 0;
			}
			int3.addFirst(sum);



		   	if(cursor1 != null)
		   		cursor1 = cursor1.prev;
		   	if(cursor2 != null)
				cursor2 = cursor2.prev;
		}
		if( carry == 1)
			int3.addFirst(carry);

		return int3;

}

		public int compareTo(InfiniteInt o)// A compareTo method that returns positve if Infiniteint is bigger, negative if smaller, and zero if the same.
		{
			if(this.size() != o.size())
				return this.size() - o.size();

			else if(this.equals(o))
				return 0;

			else
			{
				DLLNode<Integer> cursor1 = this.head;
				DLLNode<Integer> cursor2 = o.head;
				while(cursor1.data == cursor2.data)
				{
					cursor1 = cursor1.next;
					cursor2 = cursor2.next;
				}
				return cursor1.data - cursor2.data;
			}
		}
			public boolean isDivisibleBy5()//Checking the tail see if divisible by 5, since to be divisible by 5 it has to end in a 5 or 0
			{
				if(this.tail.data % 5 == 0)
					return true;
				else
					return false;
			}
			public boolean isDivisibleBy1000()//Can only be divisible by 1000 if it ends with three zeroes
			{
				if(this.tail.data == 000)
					return true;
				else
					return false;
			}


}

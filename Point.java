/*
This class will generate a point , set a point, and will also perform a variety
of given commands
*/

public class Point implements PointInterface
{
	private int x;	//Declaring ints in the beginning
	private int y;

	public Point(int x1, int y1) //Introducing variables, parameterized constructor
	{
			this.x = x1;
			this.y = y1;
	}

	public Point() //Setting private ints to the number value, default constructor
	{
			this.x = 2;
			this.y = -7;
	}

	public Point(Point another)//Copy constructor, copying x and y
	{
		this.x = another.x;
		this.y = another.y;
	}

	public String toString ()
	{
		return "(" + this.x + "," + this.y + ")";

	}

		// distanceTo
		//		throws a new IllegalArgumentException(<your descriptive String> if null is received
		//		returns the distance from this Point to the Point that was received
		//		NOTE:  there is a static method in the Math class called hypot can be useful for this method
		public double distanceTo(Point otherPoint)
		{
				if(otherPoint == null)
				throw new IllegalArgumentException("There must be values for a distance to be calculated");

				else
				return Math.sqrt(Math.pow(otherPoint.x-this.x,2)+ Math.pow(otherPoint.y-this.y,2));


		}

		//equals - returns true if it is equal to what is received (as an Object)
		public boolean equals(Object obj)
		{
			if(obj == null)
			return false;

			if(this.getClass() != obj.getClass())
			return false;

			Point objPoint = (Point)obj;


			return this.x == objPoint.x && this.y == objPoint.y;
		}


		// inQuadrant
		//			returns true if this Point is in the quadrant specified
		//			throws a new IllegalArgumentException if the quadrant is out of range (not 1-4)
		public boolean inQuadrant(int quadrant)
		{
			if((x == 0 && y == 0)||(quadrant > 4 || quadrant < 1) )
				throw new IllegalArgumentException("Quadrant is out of range\n"); //The origin should be the only point not in any quadrant

			else if(x > 0 && y > 0&&quadrant == 1)
				return true;

			else if(x<0 && y>0 && quadrant == 2)
				return true;

			else if(x < 0 && y<0 && quadrant == 3)
				return true;

			else if( x>0 && y<0 && quadrant==4)
				return true;
			else
				return false;
		}

		// translate
		//		changes this Point's x and y value by the what is received (thus "translating" it)
		//		returns nothing
		public void translate(int xMove, int yMove)//Will add whatver translation to x and/or y's current position
		{
			x = xMove + x;
			y = yMove + y;
		}

		// onXAxis
		//		returns true if this Point is on the x-axis
		public boolean onXAxis() //If x is any value but 0 and y is zero then it will be on the axis
		{
			if( y == 0 && x != 0)
			{
				return true;
			}
			else return false;
		}

		// onYAxis
		//		returns true if this Point is to the on the y-axis
		public boolean onYAxis()//If y is any value but 0 and x is zero then it will be on the axis
		{
			if( x == 0 && y != 0)
			{
				return true;
			}
			else
			return false;
		}


}


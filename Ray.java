//This class will create an array using the point class
import java.util.*;

public class Ray
{
	protected Point eP1; //Declaring the first endpoint privately
	protected int D;//Declaring the direction privately as well

	public Ray(Point eP1, int D)//Parameterized Constructor
	{
		if(eP1 == null) //Making sure that the recieved point is not void and the distance is a valid angle
			throw new IllegalArgumentException("The given inputs are not valid");
		if(D<0||D > 359)
			throw new IllegalArgumentException("The given inputs are not valid");

		this.eP1 = eP1;
		this.D   = D;
	}

	public Ray() //Default constructor, assigning values to the new variables
	{
		this.eP1 = new Point(3,4);
		this.D = 135;
	}

	public Ray(Ray another)//Copy constructor
	{
		if(another == null)
			throw new IllegalArgumentException("The given ray does not exist");

		this.eP1 = new Point(another.eP1);
		this.D = another.D;
	}

	public String toString()
	{
		return eP1 + "----->" + D  ;
	}
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;

		if(this.getClass() != obj.getClass())
			return false;

		Ray objRay = (Ray)obj;

		return this.eP1.equals(objRay.eP1) && this.D == objRay.D;
	}

	public void translate(int xmove, int ymove)//Moves the points using Points translate method
	{
		this.eP1.translate(xmove,ymove);
	}

	public void rotate(int angle)//Rotates the ray but not the endpoint
	{
		if(angle < 0)
			throw new IllegalArgumentException("Given input is invalid");
		D = D + angle;
		if(D + angle > 359)//As long as the endpoint is over 359, it will keep subtracting 360 until it's not
		{
			while(D > 359)
			{
				D = D - 360;
			}
		}
	}

	public boolean goesAboveXAxis()//Using Points quadrant method to check if it goes above x =0
	{
		if(this.eP1.inQuadrant(2)== true ||this.eP1.inQuadrant(1)== true)
			return true;
		else if(D < 180 && D > 0)
			return true;
		else if(D == 180||D == 0)
			return false;
		else
			return false;
	}
}
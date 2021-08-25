//This is the Segment class, the segment class will implement two points and use them as a segment
import java.util.*;

public class Segment implements SegmentInterface
{
	//------- data
	private Point eP1;
	private Point eP2;


	public Segment() //Default constructor, introducing two new points from the previous "Point" class
	{
		this.eP1 = new Point(1,1);
		this.eP2 = new Point(7,7);
	}

	public Segment(Point eP1,Point eP2) //Parameterized constructor, sets the two new points to the given values after making sure it has two different point values
	{
		if(eP1 == null || eP2 == null)
			throw new IllegalArgumentException("The given point has no testable value");
		if(eP1.equals(eP2))
			throw new IllegalArgumentException("A segment must include two points with DIFFERENT values");

		this.eP1 = eP1;
		this.eP2 = eP2;
	}
	public Segment(Point eP2)//Creating the segment, making sure that the two points are different and that they have actual values
	{
		if(eP2 == null)
			throw new IllegalArgumentException(" Can't pass null to constructor !");

		this.eP1 = new Point(0,0);

		if(eP1.equals(eP2))
			throw new IllegalArgumentException("A segment must include two points with DIFFERENT values");

		this.eP2 = eP2;
	}
	public Segment(Segment another)//Copy constructor comparing the first and second endpoints
	{
		if(another == null)
			throw new IllegalArgumentException(" Can't pass null to copy consturtor!");
		this.eP1 = new Point(another.eP1);//Deep Copies
		this.eP2 = new Point(another.eP2);
	}

	//toString - returns its representation as a String in the form "Segment" then endpoint1 then endpoint2
	public String toString()
	{

		return "Segment" + eP1 + eP2;
	}

	//length - returns the length
	public double length()
	{
		return eP1.distanceTo(eP2);
	}


	//translate - shifts the whole segment by xmove (in x direction) and ymove (in y direction)
	public void translate(int xmove, int ymove)
	{
		this.eP1.translate(xmove,ymove);
		this.eP2.translate(xmove,ymove);
	}

	//isAnEndpoint - returns true if the received Point is an endpoint of this Segment
	public boolean isAnEndpoint(Point p)
	{
		if(p == null)
			throw new IllegalArgumentException(" Can't pass null to the method !");
		if((p.equals(eP1))||(p.equals(eP2)))
			return true;
		else
			return false;

	}

	//equals - returns true if this Segment is equal to the one that is passed in (endpoints can be in either order)
	public boolean equals(Object obj)
	{

		if(obj == null)
			return false;

		if(this.getClass() != obj.getClass())
			return false;

		Segment objSegment = (Segment)obj;


		return (this.eP1.equals(objSegment.eP1) && this.eP2.equals(objSegment.eP2))||(this.eP1.equals(objSegment.eP2) && this.eP2.equals(objSegment.eP1));

	}
}

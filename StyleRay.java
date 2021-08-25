//This is a class that is a subclass oof ray and it will evaluate Ray's style
import java.util.*;

public class StyleRay extends Ray //"extends" declares it as a subclass
{
	protected String sty; //Exclusive to Style Ray since we will be looking at the style of the ray
	//Since eP1 and D are protected in Ray they will be inherited


	public StyleRay(Point eP1,int D,String sty)//Parameterized Constructor, constructors wil be similar to Ray's but we are adding style into the mix
	{
		if(eP1 == null || sty == null) //Making sure that the recieved point is not void and the distance is a valid angle
			throw new IllegalArgumentException("The given inputs are not valid");
		if(D < 0||D > 359)
			throw new IllegalArgumentException("The given inputs are not valid");
		if((sty.equals("dashed")== false)&&(sty.equals("dotted")== false)&&(sty.equals("double")== false))//Throwing an exception if none of those options are chosen
			throw new IllegalArgumentException("The given inputs are not valid");
		this.sty = sty;
		this.eP1 = eP1;
		this.D= D;
	}

	public StyleRay() //Default constructor, assigning values to the new variables
	{
		this.sty = "double";
		this.eP1 = new Point(3,4);
		this.D = 135;

	}

	public StyleRay(StyleRay another)//Copy constructor, must be a deep copy
	{
		if(another == null)
			throw new IllegalArgumentException("The given ray does not exist");
		this.sty = another.sty;//Exclusive to styleray, but the program must account for all data
		this.eP1 = new Point(another.eP1);
		this.D = another.D;
	}
	public String toString()//This is where the style will be shown, must test the boolean to determine which style to print
	{
		if(sty.equals("double")==true)
			return  eP1 + "=====>"+ D ;

		if(sty.equals("dashed")==true)
			return eP1 + "- - ->" + D;

		if(sty.equals("dotted")==true)
			return eP1 + ".....>"+ D;
		else
			return eP1 + "----->" + D;
	}
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;

		if(this.getClass() != obj.getClass())
			return false;

		StyleRay objSRay = (StyleRay)obj;

		return this.eP1.equals(objSRay.eP1)&& this.D == objSRay.D;
	}

	public boolean isDotted()//Returning true if the string "sty" dotted, false if not
	{
		if(sty.equals("dotted")==true)
			return true;
		return false;
	}
	public boolean isDashed()//Returning true if the string "sty" dashed, false if not
	{
		if(sty.equals("dashed")==true)
			return true;
		return false;
	}
	public boolean isDouble()//Returning true if the string "sty" double, false if not
	{
		if(sty.equals("double")==true)
			return true;
		return false;
	}


}
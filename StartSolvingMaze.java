//This class will begin the program, it will pass in the rows and columns and then tell MazeSolve to solve
import java.util.*;
import java.io.*;
public class StartSolvingMaze implements java.io.Serializable
{
	public static void main(String[] args)throws FileNotFoundException, IOException, ClassNotFoundException
		{
			Scanner kb = new Scanner(System.in);

			System.out.println("How many rows and columns would you like? ");
			int rows = kb.nextInt();
			int columns = kb.nextInt();

			MazeSolver mySolver = new MazeSolver(rows,columns); //Starting a new MazeSolver and let MazeSolver do the rest

			mySolver.solve();

		}
}
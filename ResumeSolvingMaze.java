//This class will resume the Serialized program, it will pass in a serilized MazeSolver to continue
import java.util.*;
import java.io.*;
public class ResumeSolvingMaze implements java.io.Serializable
{
	public static void main(String[] args)throws FileNotFoundException, IOException, ClassNotFoundException
		{
			Scanner kb = new Scanner(System.in);

			System.out.println("Which file would you like to use to resume? ");
			String filename = kb.nextLine();

			ObjectInputStream oisVar = new ObjectInputStream(new FileInputStream(filename));
			MazeSolver resMaze = (MazeSolver)oisVar.readObject();

			oisVar.close();

			resMaze.solve();

		}
}
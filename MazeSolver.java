//This class will implement the solver associated with the maze, maze Display, and the enum classes
import java.util.*;
import java.io.*;

public class MazeSolver implements java.io.Serializable //making sure file is able to be Serialized and that all checked exceptions are dealt with
{
	protected boolean[][] ifVisited;
	protected Stack prevDirection;
	protected Maze myMaze;


	public MazeSolver(int rows, int columns)//Parameterized Constructor, where the maze is generated along with stack and 2d boolean array(the data structure I used).
	{
		this.myMaze = new Maze(rows,columns);
		myMaze.buildMaze(0);
		myMaze.setSolveAnimationDelay(0);

		this.prevDirection = new Stack();
		this.ifVisited = new boolean[rows][columns];

	}
	public void solve()throws FileNotFoundException, IOException, ClassNotFoundException //This is where solve method will run through the boolean array while also running through the maze to figure out the next spot to go.
	{
		Scanner kb = new Scanner(System.in);

		MazeDisplay mDisplay = new MazeDisplay(myMaze);

		ifVisited[0][0] = true;
		String uReply = "";

		do
		{
			System.out.println(" Enter Q to Quit, S to save, or just hit enter to move:");
			uReply = kb.nextLine();


			this.ifVisited[myMaze.getCurrentRow()][myMaze.getCurrentCol()] = true;

			if(uReply.equals("s")||uReply.equals("s"))
				{
					System.out.println("What file should we serialize to?");
					String fileName = kb.nextLine();

					ObjectOutputStream oosVar = new ObjectOutputStream(new FileOutputStream(fileName));
					oosVar.writeObject(this);
					oosVar.close();
					System.out.println("Maze has been saved, Goodbye!"); //Breaking to make sure code quits after entering S or Q
					break;
				}
			else if(uReply.equals("q")||uReply.equals("Q"))
				{
					System.out.println("Goodbye");
					break;
				}

			else if(myMaze.isOpen(Direction.UP)== true && this.ifVisited[myMaze.getCurrentRow()-1][myMaze.getCurrentCol()] == false)
				{
					prevDirection.push(Direction.UP);
					myMaze.move(Direction.UP);
				}

			else if(myMaze.isOpen(Direction.DOWN)== true && this.ifVisited[myMaze.getCurrentRow()+1][myMaze.getCurrentCol()] == false)
				{
					prevDirection.push(Direction.DOWN);
					myMaze.move(Direction.DOWN);
				}
			else if(myMaze.isOpen(Direction.LEFT)== true && this.ifVisited[myMaze.getCurrentRow()][myMaze.getCurrentCol()-1] == false)
				{
					prevDirection.push(Direction.LEFT);
					myMaze.move(Direction.LEFT);
				}
			else if(myMaze.isOpen(Direction.RIGHT) == true && this.ifVisited[myMaze.getCurrentRow()][myMaze.getCurrentCol()+1] == false)
				{
					prevDirection.push(Direction.RIGHT);
					myMaze.move(Direction.RIGHT);
				}
			else
				{


				if(prevDirection.peek()== Direction.UP)
					{
						myMaze.move(Direction.DOWN);
						prevDirection.pop();
					}
				else if(prevDirection.peek()== Direction.DOWN)
					{
						myMaze.move(Direction.UP);
						prevDirection.pop();
					}
				else if(prevDirection.peek()== Direction.LEFT)
					{
						myMaze.move(Direction.RIGHT);
						prevDirection.pop();
					}
				else
					{
						myMaze.move(Direction.LEFT);
						prevDirection.pop();
					}


				}

}while(myMaze.goalReached() == false && (!uReply.equals("q")||!uReply.equals("Q")));





	}


}
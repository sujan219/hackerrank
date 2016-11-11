package nishant;

public class Main {

	public static void main(String[] args) {
		
		int[][] maze = {{0,0,0,0,1},
						{0,1,0,1,0},
						{0,0,1,0,0},
						{0,0,1,0,1},
						{0,0,0,0,0}};
		int endRow = 2;
		int endCol = 3;
		int rows = 5;
		int cols = 5;
		
		MazeSolution m = new MazeSolution(maze, endRow, endCol, rows, cols);
		System.out.println(m.solve());
	}
}
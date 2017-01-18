package nishant;

import java.util.HashMap;

public class Main {
	private static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	public static void main(String[] args) {
		for(int i=1; i<=100; ++i){
			System.out.print(haconachi(i)%2 + " ");
			if(i%7==0){
				System.out.println();
			}
		}
	}
	
	private static int haconachi(int no){
        if(no == 1 || no == 2 || no == 3){
            return (int)no;
        }else{
            if(map.containsKey(no)){
                return map.get(no);
            }else{
                int hac = haconachi(no-1)%10 + (2*haconachi(no-2))%10 + (3*haconachi(no-3))%10;
                map.put(no, hac);
                return hac;
            }
        }
    }
	
	public static void main1(String[] args) {
		
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
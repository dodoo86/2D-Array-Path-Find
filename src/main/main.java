package main;

import main.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class main {

	
	

	public static void main(String[] args) {
		
		int width = 6;
        int height = 6;
		
		int[][] image = { { 1, 1, 1, 0, 1, 0 },
						  { 0, 0, 1, 1, 1, 1 },
						  { 1, 1, 1, 1, 0, 0 },
						  { 0, 1, 1, 0, 0, 0 },
						  { 0, 1, 1, 0, 0, 1 },
						  { 1, 1, 1, 1, 0, 1 } };

		Path obj = new Path();
		int[][] ans = obj.floodFill(image, 0, 0, 2);
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[i].length; j++)
				System.out.print(ans[i][j] + " ");
			System.out.println();
		}

	
		
		System.out.println("\n");
		int[][] ind =obj.firstLastIndex(ans);
		
		
		
		Grid grid = new Grid(width, height, ans);
		
		System.out.println("\n");
		Point start  = new Point(0, ind[0][0]);
        Point target = new Point(0, ind[0][1]);

        // Last argument will make this search be 4 directional
        List<Point> pathh = Path.findPath(grid, start, target, false);

        // Print the path
        for (Point point : pathh) System.out.println(point);
        
        System.out.println("\n");
		Point start1  = new Point(0, ind[0][1]);
        Point target1 = new Point(1, ind[1][0]);

        // Last argument will make this search be 4 directional
        List<Point> path = Path.findPath(grid, start1, target1, false);

        // Print the path
        for (Point point : path) System.out.println(point);
        
        System.out.println("\n");
		Point start2  = new Point(1, ind[1][0]);
        Point target2 = new Point(1, ind[1][1]);

        // Last argument will make this search be 4 directional
        List<Point> path2 = Path.findPath(grid, start2, target2, false);

        // Print the path
        for (Point point : path2) System.out.println(point);
        
        System.out.println("\n");
		Point start3  = new Point(1, ind[1][1]);
        Point target3 = new Point(2, ind[2][0]);

        // Last argument will make this search be 4 directional
        List<Point> path3 = Path.findPath(grid, start3, target3, false);

        // Print the path
        for (Point point : path3) System.out.println(point);
        
        System.out.println("\n");
		Point start4  = new Point(1, ind[2][0]);
        Point target4 = new Point(2, ind[2][1]);

        // Last argument will make this search be 4 directional
        List<Point> path4 = Path.findPath(grid, start4, target4, false);

        // Print the path
        for (Point point : path4) System.out.println(point);
        
        System.out.println("\n");
		Point start5  = new Point(2, ind[2][1]);
        Point target5 = new Point(3, ind[3][0]);

        // Last argument will make this search be 4 directional
        List<Point> path5 = Path.findPath(grid, start5, target5, false);

        // Print the path
        for (Point point : path5) System.out.println(point);
        
        System.out.println("\n");
		Point start6  = new Point(3, ind[3][0]);
        Point target6 = new Point(3, ind[3][1]);

        // Last argument will make this search be 4 directional
        List<Point> path6 = Path.findPath(grid, start6, target6, false);

        // Print the path
        for (Point point : path6) System.out.println(point);
        
        System.out.println("\n");
		Point start7  = new Point(3, ind[3][1]);
        Point target7 = new Point(4, ind[4][0]);

        // Last argument will make this search be 4 directional
        List<Point> path7 = Path.findPath(grid, start7, target7, false);

        // Print the path
        for (Point point : path7) System.out.println(point);
        
        System.out.println("\n");
		Point start8  = new Point(4, ind[4][0]);
        Point target8 = new Point(4, ind[4][1]);

        // Last argument will make this search be 4 directional
        List<Point> path8 = Path.findPath(grid, start8, target8, false);

        // Print the path
        for (Point point : path8) System.out.println(point);
        
        System.out.println("\n");
		Point start9  = new Point(4, ind[4][1]);
        Point target9 = new Point(5, ind[5][0]);

        // Last argument will make this search be 4 directional
        List<Point> path9 = Path.findPath(grid, start9, target9, false);

        // Print the path
        for (Point point : path9) System.out.println(point);
        
        System.out.println("\n");
		Point start10  = new Point(5, ind[5][0]);
        Point target10 = new Point(5, ind[5][1]);

        // Last argument will make this search be 4 directional
        List<Point> path10 = Path.findPath(grid, start10, target10, false);

        // Print the path
        for (Point point : path10) System.out.println(point);
		
	}
}
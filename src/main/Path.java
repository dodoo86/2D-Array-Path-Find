package main;
import main.Point;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import main.*;
public class Path {
	
	static int a = 0;
	static int b = 0;
	static int end[][] = new int[a][b];
	
	Path() {
		
	}
	
	private void dfs(int row, int col, int[][] ans, int[][] image, int newColor, int delRow[], int delCol[],
			int iniColor) {

		ans[row][col] = newColor;
		int n = image.length;
		int m = image[0].length;

		for (int i = 0; i < 4; i++) {
			int nrow = row + delRow[i];
			int ncol = col + delCol[i];

			if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == iniColor
					&& ans[nrow][ncol] != newColor) {
				dfs(nrow, ncol, ans, image, newColor, delRow, delCol, iniColor);
//		               
			}
		}
	}

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

		int iniColor = image[sr][sc];
		int[][] ans = image;

		int delRow[] = { -1, 0, +1, 0 };
		int delCol[] = { 0, +1, 0, -1 };
		dfs(sr, sc, ans, image, newColor, delRow, delCol, iniColor);
		return ans;
	}
	
	public int[][] firstLastIndex(int[][] image) {
		
		int[][] ans = floodFill(image, 0, 0, 2);
		int[][] sep = new int[6][2];
		int a = -1;
		int z = 0;
		int x = ans.length;
		int y = ans[0].length;
		
		while(a -1 <= 5) {
			a++;
			if(ans[0][a] == 2) {
				sep[0][0] = a;
				break;
			}
		}
		a = -1;
		
		while(a -1 <= 5) {
			a++;
			if(ans[1][a] == 2) {
				sep[1][0] = a;
				break;
			}
		}
		a = -1;
		
		while(a -1 <= 5) {
			a++;
			if(ans[2][a] == 2) {
				sep[2][0] = a;
				break;
			}
		}
		a = -1;
		
		while(a -1 <= 5) {
			a++;
			if(ans[3][a] == 2) {
				sep[3][0] = a;
				break;
			}
		}
		a = -1;
		
		while(a -1 <= 5) {
			a++;
			if(ans[4][a] == 2) {
				sep[4][0] = a;
				break;
			}
		}
		a = -1;
		
		while(a -1 <= 5) {
			a++;
			if(ans[5][a] == 2) {
				sep[5][0] = a;
				break;
			}
		}
		a = -1;
		
		while(y -1 >= 0) {
			y--;
			if(ans[0][y] == 2) {
				sep[0][1] = y;
				break;
			}
		}
		
		
		y = ans[0].length;
		while(y -1 >= 0) {
			y--;
			if(ans[1][y] == 2) {
				sep[1][1] = y;
				break;
			}
		}
		
		y = ans[0].length;
		while(y -1 >= 0) {
			y--;
			if(ans[2][y] == 2) {
				sep[2][1] = y;
				break;
			}
		}
		
		y = ans[0].length;
		while(y -1 >= 0) {
			y--;
			if(ans[3][y] == 2) {
				sep[3][1] = y;
				break;
			}
		}
		
		y = ans[0].length;
		while(y -1 >= 0) {
			y--;
			if(ans[4][y] == 2) {
				sep[4][1] = y;
				break;
			}
		}
		
		y = ans[0].length;
		while(y -1 >= 0) {
			y--;
			if(ans[5][y] == 2) {
				sep[5][1] = y;
				break;
			}
		}
		
		for (int i = 0; i < sep.length; i++) {
			for (int j = 0; j < sep[i].length; j++)
			System.out.print(sep[i][j] + " ");
		System.out.println();
	}
		return sep;
		
	}

	public static List<Point> findPath(Grid grid, Point startPos, Point targetPos, boolean allowDiagonals) {
        // Find path
        List<Node> pathInNodes = findPathNodes(grid, startPos, targetPos, allowDiagonals);

        // Convert to a list of points and return
        List<Point> pathInPoints = new ArrayList<Point>();

        if (pathInNodes != null)
            for (Node node : pathInNodes)
                pathInPoints.add(new Point(node.x, node.y));

        return pathInPoints;
    }
	
	private static List<Node> findPathNodes(Grid grid, Point startPos, Point targetPos, boolean allowDiagonals) {
        Node startNode = grid.nodes[startPos.x][startPos.y];
        Node targetNode = grid.nodes[targetPos.x][targetPos.y];

        List<Node> openSet = new ArrayList<Node>();
        HashSet<Node> closedSet = new HashSet<Node>();
        openSet.add(startNode);

        while (openSet.size() > 0) {
            Node currentNode = openSet.get(0);

            for (int k = 1; k < openSet.size(); k++) {
                Node open = openSet.get(k);

                if (open.getFCost() < currentNode.getFCost() ||
                        open.getFCost() == currentNode.getFCost() &&
                                open.hCost < currentNode.hCost)
                    currentNode = open;
            }

            openSet.remove(currentNode);
            closedSet.add(currentNode);

            if (currentNode == targetNode)
                return retracePath(startNode, targetNode);

            List<Node> neighbours;
            if (allowDiagonals) neighbours = grid.get8Neighbours(currentNode);
            else neighbours = grid.get4Neighbours(currentNode);

            for (Node neighbour : neighbours) {
                if (!neighbour.walkable || closedSet.contains(neighbour)) continue;

                int newMovementCostToNeighbour = currentNode.gCost + getDistance(currentNode, neighbour) * (int) (10.0f * neighbour.price);
                if (newMovementCostToNeighbour < neighbour.gCost || !openSet.contains(neighbour)) {
                    neighbour.gCost = newMovementCostToNeighbour;
                    neighbour.hCost = getDistance(neighbour, targetNode);
                    neighbour.parent = currentNode;

                    if (!openSet.contains(neighbour)) openSet.add(neighbour);
                }
            }
        }

        return null;
    }
	
	private static List<Node> retracePath(Node startNode, Node endNode) {
        List<Node> path = new ArrayList<Node>();
        Node currentNode = endNode;

        while (currentNode != startNode) {
            path.add(currentNode);
            currentNode = currentNode.parent;
        }

        Collections.reverse(path);
        return path;
    }

    private static int getDistance(Node nodeA, Node nodeB) {
        int distanceX = Math.abs(nodeA.x - nodeB.x);
        int distanceY = Math.abs(nodeA.y - nodeB.y);

        if (distanceX > distanceY)
            return 14 * distanceY + 10 * (distanceX - distanceY);
        return 14 * distanceX + 10 * (distanceY - distanceX);
    }
	
}

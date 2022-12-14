package main;

import java.util.ArrayList;
import java.util.List;

import main.Node;

/**
 * The grid of nodes we use to find path
 */
public class Grid {
    public Node[][] nodes;
    int gridWidth, gridHeight;

    /**
     * Create a new Grid with tile prices.
     *
     * @param width      Grid width
     * @param height     Grid height
     * @param tile_costs 2d array of floats, representing the cost of every tile.
     *                   0.0f = unwalkable tile.
     *                   1.0f = normal tile.
     */
    public Grid(int width, int height, int[][] tile_costs) {
        gridWidth = width;
        gridHeight = height;
        nodes = new Node[width][height];

        for (int x = 0; x < width; x++) 
            for (int y = 0; y < height; y++) 
                nodes[x][y] = new Node(x, y, tile_costs[x][y]);
         
            
    }

    /**
     * Create a new grid of just walkable / unwalkable tiles.
     *
     * @param width         Grid width
     * @param height        Grid height
     * @param walkableTiles the tilemap. true for walkable, false for blocking.
     */
    public Grid(int width, int height, boolean[][] walkableTiles) {
        gridWidth = width;
        gridHeight = height;
        nodes = new Node[width][height];

        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++)
                nodes[x][y] = new Node(x, y, walkableTiles[x][y] ? 1.0f : 0.0f);
    }

    public List<Node> get8Neighbours(Node node) {
        List<Node> neighbours = new ArrayList<Node>();

        for (int x = -1; x <= 1; x++)
            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0) continue;

                int checkX = node.x + x;
                int checkY = node.y + y;

                if (checkX >= 0 && checkX < gridWidth && checkY >= 0 && checkY < gridHeight)
                    neighbours.add(nodes[checkX][checkY]);
            }

        return neighbours;
    }

    public List<Node> get4Neighbours(Node node) {
        List<Node> neighbours = new ArrayList<Node>();

        if (node.y + 1 >= 0 && node.y + 1  < gridHeight) {
        	//System.out.println("UP");
        	neighbours.add(nodes[node.x][node.y + 1]); // N
        }
        if (node.y - 1 >= 0 && node.y - 1  < gridHeight) {
        	neighbours.add(nodes[node.x][node.y - 1]); // S
        }
        if (node.x + 1 >= 0 && node.x + 1  < gridHeight) {
        	neighbours.add(nodes[node.x + 1][node.y]); // E
        }
        if (node.x - 1 >= 0 && node.x - 1  < gridHeight) {
        	neighbours.add(nodes[node.x - 1][node.y]); // W
        }

        return neighbours;
    }
}
package Recurssion.MazeProblem;

import java.util.ArrayList;
import java.util.List;

//TODO 1 . return the total count of the path in the maze
//TODO 2 . return the each paths directions -> Left and Right
//TODO 3 . return the each paths directions including diagonals
public class MazeProblem {

    public static void main(String[] args) {
        int[][] maze = new int[2][2];
        int count = findPaths(maze, 3, 3);
        System.out.println(count);

        List<String> allDirections = new ArrayList<>();
//        findAllDirections(3, 3, "", allDirections);
//        System.out.println(allDirections.size());

        findIncludingDaigonalPaths(2, 2, "", allDirections);
        System.out.println(allDirections);
    }
    public static int findPaths(int[][] maze, int row, int col) {
        if (row == 0 || col == 0) {
            return 1;
        }

        int rowCount = findPaths(maze, row - 1, col);
        int colCount = findPaths(maze, row, col - 1);
        return rowCount + colCount;
    }

    public static void findAllDirections(int row, int col, String direction, List<String> allDirections) {
        if (row == 0 && col == 0) {
            allDirections.add(direction);
            return;
        }

        if (row != 0) {
            findAllDirections(row - 1, col, direction + "R", allDirections);
        }

        if (col != 0) {
            findAllDirections(row, col -1, direction + "L" , allDirections);
        }
    }

    public static void findIncludingDaigonalPaths(int row, int col, String direction, List<String> allDirections) {
        if (row == 0 && col == 0) {
            allDirections.add(direction);
            return;
        }

        if (row > 0 && col > 0) {
            findIncludingDaigonalPaths(row -1, col -1, direction + "D", allDirections);
        }

        if (row > 0){
            findIncludingDaigonalPaths(row -1, col, direction + "R", allDirections);
        }

        if (col > 0) {
            findIncludingDaigonalPaths(row, col - 1, direction + "L", allDirections);
        }
    }
}

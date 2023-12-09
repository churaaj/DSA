package Recurssion.MazeProblem;

import java.util.ArrayList;
import java.util.List;

public class AllDirectionsWithObstacles {

    public static void main(String[] args) {
        boolean[][] arr = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };
        List<String> directions = new ArrayList<>();
        findPathsWithAllDirections(arr, 0, 0, "", directions);
        System.out.println(directions);
    }
   /*
    What if we all the directions like UP DOWN RIGHT LEFT DIAGONAL
    This were backtracking comes in picture.
    --> Make the visit to false
    --> while returning revert back the cell to its original state --> true
    */

    public static void findPathsWithAllDirections(boolean[][] arr, int row, int col, String path, List<String> directions) {
        if (row >= arr.length -1 && col >= arr[row].length - 1) {
            directions.add(path);
            return;
        }

        if (!arr[row][col]) {
            return;
        }

        //making the visited cell to false
        arr[row][col] = false;

        if (row < arr.length - 1) {
            findPathsWithAllDirections(arr, row + 1, col, path + "D", directions);
        }

        if (col < arr[row].length -1) {
            findPathsWithAllDirections(arr, row, col + 1, path + "R", directions);
        }

        if (row < arr.length - 1 && col < arr[row].length -1) {
            findPathsWithAllDirections(arr, row + 1, col + 1, path + "C", directions);
        }

        if (row > 0) {
            findPathsWithAllDirections(arr, row - 1, col, path + "U", directions);
        }

        if (col > 0) {
            findPathsWithAllDirections(arr, row, col - 1, path + "L", directions);
        }
        //while the function call is going to get over
        // make the cell as true
        arr[row][col] = true;
    }

    //TODO : This below function is to find the path with the directions down right diagonal
    public static void findPaths(boolean[][] arr, int row, int col, String path, List<String> directions) {
        if (row >= arr.length -1 && col >= arr[row].length - 1) {
            directions.add(path);
            return;
        }

        if (!arr[row][col]) {
            return;
        }

        if (row < arr.length - 1) {
            findPaths(arr, row + 1, col, path + "DO", directions);
        }

        if (col < arr[row].length -1) {
            findPaths(arr, row, col + 1, path + "R", directions);
        }

        if (row < arr.length - 1 && col < arr[row].length -1) {
            findPaths(arr, row + 1, col + 1, path + "DD", directions);
        }
    }
}

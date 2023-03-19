// Given an integer numRows, return the first numRows of Pascal's triangle.

import java.util.*;

public class Easy_Pascal {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of rows of the Pascal's Triangle to print: ");
        int numRows = in.nextInt();

        List<List<Integer>> pascalTriangle = new ArrayList<List<Integer>>(); // pascalTriangle holds the final values of the triangle to be printed
        pascalTriangle = GeneratePascalTriangle(numRows);

        System.out.println("\nThe Pascal's Triangle for the given number of rows is: ");
        System.out.println(pascalTriangle);
        in.close();
    }

    public static List<List<Integer>> GeneratePascalTriangle(int numRows) { // function to generate the Pascal's triangle

        List<List<Integer>> pascalList = new ArrayList<List<Integer>>();
        List<Integer> curRow, prevRow = null; // curRow and prevRow hold the values of the current and the previews rows of the pascal triangle respectively

        for (int i = 0; i < numRows; i++) {
            curRow = new ArrayList<Integer>(); // creating a new row to add to the Pascal's triangle

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) { // checking for edges of the triangle
                    curRow.add(1);
                } else {
                    curRow.add(prevRow.get(j - 1) + prevRow.get(j)); // generating the middle values of the rows with the help of prevRow
                }
            }
            prevRow = curRow;
            pascalList.add(curRow); // adding curRow to the Pascal's triangle
        }

        return pascalList;
    }
}

/*
 * 
 * Complexity of the code written:
 * 
 * Time complexity - O(N^2)
 * Space complexity - O(N^2)
 * 
 */
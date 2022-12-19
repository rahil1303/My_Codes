// Problem Statement:
// Write the code such that given the destination in terms of the x and y coordinates, your code prints the minimum cost to reach the destination.

// The input format should take values as the x coordinate of the destination in the first line followed by its y coordinate in the next.
// The output should print the minimum cost to reach the destination taken from the input.

import java.util.*;
 
class Source {
    /* A utility function that returns minimum of 3 integers
     */
    private static int min(int x, int y, int z)
    {
        if (x < y)
            return (x < z) ? x : z;
        else
            return (y < z) ? y : z;
    }
 
    private static int minCost(int cost[][], int m, int n)
    {
        int i, j;
        int tc[][] = new int[m + 1][n + 1];
 
        tc[0][0] = cost[0][0];
 
        /* Initialize first column of total cost(tc) array
         */
        for (i = 1; i <= m; i++)
            tc[i][0] = tc[i - 1][0] + cost[i][0];
 
        /* Initialize first row of tc array */
        for (j = 1; j <= n; j++)
            tc[0][j] = tc[0][j - 1] + cost[0][j];
 
        /* Construct rest of the tc array */
        for (i = 1; i <= m; i++)
            for (j = 1; j <= n; j++)
                tc[i][j] = min(tc[i - 1][j - 1],
                               tc[i - 1][j], tc[i][j - 1])
                           + cost[i][j];
 
        return tc[m][n];
    }
 
 
    public static void main(String args[])
    {
        int cost[][]= {{1, 2, 3},
                       {4, 8, 2},
                       {1, 5, 3}};
        Scanner scan = new Scanner(System.in);
        int xCoordinate = scan.nextInt();
        int yCoordinate = scan.nextInt();
        System.out.println(minCost(cost,xCoordinate,yCoordinate));
    }
}

package day23;

import java.util.*;

public class FindTheCityWithLeastNumberOfNeighboursAtThresholdDistance_1334 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        // Sample Input
        // n = number of cities
        // e = number of edges
        int n = read.nextInt();
        int e = read.nextInt();
        int[][] edges = new int[e][3];

        for (int i = 0; i < e; i++) {
            edges[i][0] = read.nextInt(); // from
            edges[i][1] = read.nextInt(); // to
            edges[i][2] = read.nextInt(); // weight
        }

        int distanceThreshold = read.nextInt();
        read.close();

        int result = FindTheCityWithLeastNumberOfNeighbourAtThresholdDistanceSolution(n, edges, distanceThreshold);
        System.out.println(result);
    }

    public static int FindTheCityWithLeastNumberOfNeighbourAtThresholdDistanceSolution(int n, int[][] edges,
            int distanceThreshold) {
        int[][] d = new int[n][n];

        // Initialize distance matrix
        for (int i = 0; i < n; i++) {
            Arrays.fill(d[i], Integer.MAX_VALUE);
            d[i][i] = 0;
        }

        // Populate direct edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            d[u][v] = w;
            d[v][u] = w;
        }

        // Floyd-Warshall Algorithm
        for (int src = 0; src < n; src++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (d[i][src] != Integer.MAX_VALUE && d[src][j] != Integer.MAX_VALUE
                            && d[i][j] > d[i][src] + d[src][j]) {
                        d[i][j] = d[i][src] + d[src][j];
                    }
                }
            }
        }

        int res = 0;
        int min = n;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && d[i][j] <= distanceThreshold)
                    count++;
            }
            if (count <= min) {
                min = count;
                res = i; // prefer larger index in case of tie
            }
        }

        return res;
    }
}

package day23;

import java.util.*;

public class ffloydWarshalAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // number of nodes
        int e = sc.nextInt(); // number of edges

        int[][] d = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(d[i], Integer.MAX_VALUE);
            d[i][i] = 0; // distance to self is 0
        }

        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            d[u][v] = w;
        }
        sc.close();

        floydWarshall(d, n);

        // Output the final distance matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (d[i][j] == Integer.MAX_VALUE)
                    System.out.print("INF ");
                else
                    System.out.print(d[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void floydWarshall(int[][] d, int n) {
        // Standard Floyd-Warshall triple nested loop
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (d[i][k] != Integer.MAX_VALUE && d[k][j] != Integer.MAX_VALUE
                            && d[i][j] > d[i][k] + d[k][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                    }
                }
            }
        }
    }
}

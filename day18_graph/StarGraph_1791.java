package day18_graph;

import java.util.*;

public class StarGraph_1791 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int e = read.nextInt();
        int[][] edges = new int[e][2];
        for (int i = 0; i < e; i++) {
            edges[i][0] = read.nextInt();
            edges[i][1] = read.nextInt();
        }
        System.out.println("Center of the star graph: " + findCenter(edges));
        read.close();
    }

    public static int findCenter(int[][] edges) {
        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) {
            return edges[0][0];
        } else {
            return edges[0][1];
        }
    }
}

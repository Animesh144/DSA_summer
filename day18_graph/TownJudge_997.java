package day18_graph;

import java.util.*;

public class TownJudge_997 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int n = read.nextInt(); // number of people
        int e = read.nextInt(); // number of trust relationships

        int[][] trust = new int[e][2];
        for (int i = 0; i < e; i++) {
            trust[i][0] = read.nextInt();
            trust[i][1] = read.nextInt();
        }

        System.out.println(findJudge(n, trust));
        read.close();
    }

    public static int findJudge(int n, int[][] trust) {
        int[] trustCount = new int[n + 1];
        for (int[] edge : trust) {
            int s = edge[0];
            int d = edge[1];
            trustCount[s]--;
            trustCount[d]++;
        }
        for (int i = 1; i <= n; i++) {
            if (trustCount[i] == n - 1)
                return i;
        }
        return -1;
    }
}

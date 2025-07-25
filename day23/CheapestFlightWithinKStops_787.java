package day23;

import java.util.*;

public class CheapestFlightWithinKStops_787 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        // Sample input
        // Number of cities
        int n = read.nextInt();

        // Number of flights
        int m = read.nextInt();

        int[][] flights = new int[m][3];
        for (int i = 0; i < m; i++) {
            flights[i][0] = read.nextInt(); // source
            flights[i][1] = read.nextInt(); // destination
            flights[i][2] = read.nextInt(); // cost
        }

        // Source city, Destination city, and maximum stops
        int src = read.nextInt();
        int dst = read.nextInt();
        int k = read.nextInt();

        int result = cheapestFlightWithinKStopsSolution(n, flights, src, dst, k);
        System.out.println(result);
        read.close();
    }

    public static int cheapestFlightWithinKStopsSolution(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(cost, n);
            for (int[] flight : flights) {
                int s = flight[0];
                int d = flight[1];
                int w = flight[2];
                if (cost[s] != Integer.MAX_VALUE && cost[s] + w < temp[d]) {
                    temp[d] = cost[s] + w;
                }
            }
            cost = temp;
        }

        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}

package day18_graph;

import java.util.*;

public class TypesAndRepresentationOfGraph {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int v = read.nextInt();
        int e = read.nextInt();
        int[][] MatrixGraph = new int[v][v];
        AsjcencyMatrixRepresentation(MatrixGraph, v, e, read);
        AdjcencyListRepresentation(graph, v, e, read);
        read.close();
    }

    public static void AdjecencyMatrixRepresentation(int[][] graph, int v, int e, Scanner read) {
        for (int i = 0; i < e; i++) {
            int s = read.nextInt();
            int d = read.nextInt();
            graph[s][d] = 1;
            graph[d][s] = 1;
        }
    }

    public static void AdjcencyListRepresentation(ArrayList<ArrayList<Integer>> graph, int v, int e, Scanner read) {
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            int s = read.nextInt();
            int d = read.nextInt();
            graph.get(s).add(d);
            graph.get(d).add(s);
        }
    }
}

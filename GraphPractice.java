import java.util.*;
import java.util.ArrayList;
// import java.util.Queue;
// import java.util.LinkedList;

public class GraphPractice {
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int v = read.nextInt();
        int e = read.nextInt();
        System.out.println("AdjcencyList representation of graph: ");
        System.out.println("Give input: ");
        adjecencyListRepresentation(graph, v, e, read);
        boolean[] vis = new boolean[v];
        System.out.println("Give starting index for DFS traversal using AdjcencyList: ");
        int index = read.nextInt();
        for(int i=0;i<v;i++){
            if(vis[i] == false){
                DFSAdjcencyList(graph, v, e, vis,index);
            }
        }
        int[][] graphMatrix = new int[v][v];
        System.out.println("AdjcencyMatrix representation of graph: ");
        System.out.println("Give input: ");
        AdjcencyMatrixRepresentation(graphMatrix, v, e, read);
        boolean[] visMatrix = new boolean[v];
        DFSADjcencyMatrix(graphMatrix, v, e, visMatrix, index);

        read.close();

    }
    public static void DFSADjcencyMatrix(int[][] graph, int v,int e,boolean[] vis,int index){
        vis[index] = true;
        System.out.print(index+" ");
        for(int i=0;i<v;i++){
            if(graph[index][i]==1 && !vis[i]){
                DFSADjcencyMatrix(graph, v, e, vis, i);
            }
        }


    }
    public static void DFSAdjcencyList(ArrayList<ArrayList<Integer>> graph,int v, int e,boolean[] vis,int index){
        vis[index] = true;
        System.out.print(index+" ");
        for(int i=0;i<graph.get(index).size();i++){
            if(vis[graph.get(index).get(i)]==false){
                DFSAdjcencyList(graph, v, e, vis, graph.get(index).get(i));
            }
        }
    }
    public static void adjecencyListRepresentation(ArrayList<ArrayList<Integer>> graph,int v,int e,Scanner read){
        for(int i=0;i<v;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<e;i++){
            int s = read.nextInt();
            int d = read.nextInt();
            graph.get(s).add(d);
            graph.get(d).add(s);
        }
        for(int i=0;i<v;i++){
            System.out.print(i+": ");
            for(int j=0;j<graph.get(i).size();j++){
                System.out.print(graph.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
    public static void AdjcencyMatrixRepresentation(int[][] graph,int v,int e, Scanner read){
        for(int i=0;i<e;i++){
            int s = read.nextInt();
            int d = read.nextInt();
            graph[s][d] = 1;
            graph[d][s] = 1;
        }
        System.out.print("  ");

        for(int i=0;i<v;i++){
            System.out.print(i+" ");
        }
        System.out.println();
        for(int i=0;i<v;i++){
            System.out.print(i+" ");
            for(int j=0;j<v;j++){
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();

        }
    }
}

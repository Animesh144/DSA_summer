import java.util.*;

public class GraphPractice2 {
    public static void main(String[] args){
        Scanner read = new Scanner (System.in);
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        int v = read.nextInt();
        int e = read.nextInt();
        int[][] graphMatrix = new int [v][v];
        // WeightedAdjMatrix(graphMatrix, v, e, read);
        WeightedAdjList(graph, v, e, read);

        read.close();
    }
    public static void WeightedAdjList(ArrayList<ArrayList<Edge>> graph, int v, int e, Scanner read){
        for(int i=0;i<v;i++){
            graph.add(new ArrayList<Edge>());
        }
        for(int i=0;i<e;i++){
            int s = read.nextInt();
            int d = read.nextInt();
            int w = read.nextInt();
            Edge unit1 = new Edge(s, d, w);
            graph.get(s).add(unit1);
            Edge unit2 = new Edge(d, s, w);
            graph.get(d).add(unit2);
        }
        for(int i=0;i<v;i++){
            System.out.print("Source "+i+" : ");
            for(int j=0;j<graph.get(i).size();j++){
                System.out.print("Dest->"+graph.get(i).get(j).d+" Weight->"+graph.get(i).get(j).w+"|");            
            }System.out.println();
        }
    }
    public static void WeightedAdjMatrix(int[][] graph, int v, int e, Scanner read){
        for(int i=0;i<e;i++){
            int s = read.nextInt();
            int d = read.nextInt();
            int w = read.nextInt();

            graph[s][d] = w;
            graph[d][s] = w;
        }
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
    }
    
}
class Edge{
    int s,d,w;
    Edge(int s,int d,int w){
        this.s = s;
        this.d = d;
        this.w = w;
    }
}
package day23;
import java.util.*;
import java.util.ArrayList;
// 5 7
// 0 1 6
// 0 2 5
// 1 3 -1
// 2 4 3
// 2 1 -2
// 2 3 4 
// 3 4 3
// 0
public class bellmanFordAlgorithm {
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        ArrayList<Edge> graph = new ArrayList<>();
        int v = read.nextInt();
        int e = read.nextInt();

        for(int i=0;i<e;i++){
            int s = read.nextInt();
            int d = read.nextInt();
            int w = read.nextInt();
            graph.add(new Edge(s, d, w));
        }
        int src = read.nextInt();
        int res[] = BellmanFordAlgorithm(v,graph,src);
        for(int i=0;i<v;i++){
            System.out.print(res[i]+" ");
        }
        read.close();
    }
    public static int[] BellmanFordAlgorithm(int v, ArrayList<Edge> graph, int src){
        int[] d = new int[v];
        for(int i=0;i<v;i++){
            d[i] = Integer.MAX_VALUE;
        }
        // we can also use Arrays.fill(d,Integer.MAX_VALUE);
        d[src] = 0;

        for(int i=0;i<v;i++){
            for(Edge edge: graph){
                if(d[edge.s]!=Integer.MAX_VALUE && d[edge.s]+edge.w<d[edge.d]){
                    d[edge.d] = d[edge.s]+edge.w;
                }
            }
        }
        return d;
    }
    
}

class Edge{
    int s,d,w;
    Edge(int s, int d, int w){
        this.s = s;
        this.d = d;
        this.w = w;
    }
}
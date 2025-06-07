package day21;
import java.util.*;
import java.util.ArrayList;

public class kruskalAlgorithm {
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        int v = read.nextInt();
        int e = read.nextInt();
        ArrayList<Edge> graph = new ArrayList<>();
        for(int i=0;i<e;i++){
            int s = read.nextInt();
            int d = read.nextInt();
            int w = read.nextInt();
            // edge list graph
            graph.add(new Edge(s,d,w));
        }
        int res = kruskal(graph,v);
        System.out.println(res);
        read.close();
    }
    public static int kruskal(ArrayList<Edge> graph,int v){
        graph.sort(Comparator.comparingInt(e->e.w));
        int[] vertex = new int[v];
        for(int i=0;i<v;i++) vertex[i]=i;
        int sum = 0;

        for(Edge edge: graph){
            int s = findEndNode(vertex,edge.s);
            int d = findEndNode(vertex,edge.d);

            if(s!=d){
                sum+=edge.w;
                vertex[s] = d;
            }
        }
        return sum;
    }
    public static int findEndNode(int[] vertex, int index){
        if(vertex[index] == index){
            return index;
        }
        return findEndNode(vertex,vertex[index]);
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
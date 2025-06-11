package algorithms;
// union find algorithm is used to find if there is a cycle present 
// it is used in kruskals algorithm

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class UnionFindAlgorithm {
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        read.close();
    }
    public static int kruskalsAlgorithm(ArrayList<EdgeList> graph, int v, int e){
        int sum = 0;
        graph.sort(Comparator.comparingInt(ed->ed.w));
        int[] vertex = new int[v];
        for(int i=0;i<v;i++){
            vertex[i] = i;
        }
        for(EdgeList edge : graph){
            int s = FindEndNode(vertex,edge.s);
            int d = FindEndNode(vertex,edge.d);

            if(s!=d){
                sum += edge.w;
                vertex[s] = d;
            }
        }
        return sum;
    }
    public static int FindEndNode(int[] vertex, int index){
        if(vertex[index] == index ) return index;
        return FindEndNode(vertex, vertex[index]);
    }
}
class EdgeList {
    int s,d,w;
    EdgeList(int s,int d,int w){
        this.s = s;
        this.d = d;
        this.w = w;
    }
}
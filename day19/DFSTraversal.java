package day19;
import java.util.*;
import java.util.ArrayList;

public class DFSTraversal {
    public static void main(String[] args){
        Scanner read = new Scanner (System.in);
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int v = read.nextInt();
        int e = read.nextInt();
        for (int i=0;i<v;i++){
            graph.add(new ArrayList<>());
        }
        for (int i=0;i<e;i++){
            int s = read.nextInt();
            int d = read.nextInt();
            graph.get(s).add(d);
            graph.get(d).add(s);
        }
        boolean[] vis = new boolean[v];
        for(int i=0;i<v;i++){
            if(vis[i]==false){
                DFS(graph,i,v,e,vis);
            }
        }
        read.close();
    }
    public static void DFS(ArrayList<ArrayList<Integer>> graph,int s,int v,int e,boolean vis[]){
        vis[s] = true;
        System.out.print(s+" ");
        for(int i=0;i<graph.get(s).size();i++){
            if(vis[graph.get(s).get(i)]==false){
                DFS(graph,graph.get(s).get(i),v,e,vis);
            }
        }

    }
    
}

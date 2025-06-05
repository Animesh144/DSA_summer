package day19;
import java.util.*;
import java.util.ArrayList;
public class AdjecencyListRepresentation {
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int v = read.nextInt();
        int e = read.nextInt();
        for(int i=0; i<v; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<e; i++){
            int s = read.nextInt();
            int d = read.nextInt();
            graph.get(s).add(d);
            graph.get(d).add(s);
        }
        for(int i=0; i<v; i++){
            System.out.print("Vertex "+i+": ");
            for(int j=0;j<graph.get(i).size();j++){
                System.out.print(graph.get(i).get(j)+" ");
            }
            System.out.println();
        }
        read.close();
    }
    
}

package day19;

import java.util.ArrayList;
import java.util.List;

public class MinimumNoOfVerticesToReach_1557 {
    ArrayList<Integer> res = new ArrayList<>();

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (List<Integer> edge : edges) {
            int s = edge.get(0);
            int d = edge.get(1);
            graph.get(d).add(s);
        }
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 0)
                res.add(i);
        }
        return res;
    }
}

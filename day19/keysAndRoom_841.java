package day19;

import java.util.*;

public class keysAndRoom_841 {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        int n = read.nextInt(); // number of rooms
        List<List<Integer>> rooms = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int k = read.nextInt(); // number of keys in room i
            List<Integer> keys = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                keys.add(read.nextInt());
            }
            rooms.add(keys);
        }

        keysAndRoom_841 obj = new keysAndRoom_841();
        boolean result = obj.canVisitAllRooms(rooms);

        System.out.println(result ? "All rooms are accessible." : "Not all rooms are accessible.");

        read.close();
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];

        dfs(rooms, 0, vis);

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                return false;
            }
        }
        return true;
    }

    public void dfs(List<List<Integer>> rooms, int s, boolean[] vis) {
        vis[s] = true;
        for (int i = 0; i < rooms.get(s).size(); i++) {
            int key = rooms.get(s).get(i);
            if (!vis[key]) {
                dfs(rooms, key, vis);
            }
        }
    }
}

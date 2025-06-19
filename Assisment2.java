// public class Assisment2 {
//     public static void main(String[] args) {

//     }
// }
// import java.util.*;

// class EmployeeNode {
//     int id;
//     EmployeeNode left, right;

//     public EmployeeNode(int id) {
//         this.id = id;
//         this.left = this.right = null;
//     }
// }

// public class EmployeeHierarchy {

//     // Function to insert a new employee into the BST
//     public static EmployeeNode insert(EmployeeNode root, int id) {
//         if (root == null) return new EmployeeNode(id);
//         if (id < root.id) root.left = insert(root.left, id);
//         else root.right = insert(root.right, id);
//         return root;
//     }

//     // Function to find the lowest common ancestor
//     public static EmployeeNode findLCA(EmployeeNode root, int p, int q) {
//         if (root == null) return null;

//         // If both p and q are less than root, LCA lies in left
//         if (p < root.id && q < root.id)
//             return findLCA(root.left, p, q);

//         // If both p and q are greater than root, LCA lies in right
//         if (p > root.id && q > root.id)
//             return findLCA(root.right, p, q);

//         // Otherwise, root is the LCA
//         return root;
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         // Input: number of employees
//         int n = sc.nextInt();
//         int[] ids = new int[n];

//         // Input: employee IDs
//         for (int i = 0; i < n; i++) {
//             ids[i] = sc.nextInt();
//         }

//         // Input: employees to find LCA for
//         int p = sc.nextInt();
//         int q = sc.nextInt();

//         // Build the BST
//         EmployeeNode root = null;
//         for (int id : ids) {
//             root = insert(root, id);
//         }

//         // Find and print LCA
//         EmployeeNode lca = findLCA(root, p, q);
//         System.out.println(lca.id);
//     }
// }
import java.util.*;

public class Assisment2 {
    static int[] parent;
    
    public static int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]); // Path compression
        return parent[x];
    }

    public static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb)
            parent[pa] = pb;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // nodes
        int m = sc.nextInt(); // edges
        int k = sc.nextInt(); // required components

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        int[][] edges = new int[m][2];
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            edges[i][0] = u;
            edges[i][1] = v;
            union(u, v);
        }

        // Count initial components
        Set<Integer> components = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            components.add(find(i));
        }
        int initialComponents = components.size();

        if (initialComponents > k) {
            System.out.println(-1);
        } else {
            int maxRemovable = m - (n - k);
            System.out.println(maxRemovable);
        }
    }
}
package day17;

import java.util.*;

public class AllElementsInTwoBinarySearchTrees_1305 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        // Read input for first tree
        TreeNode root1 = null;
        while (true) {
            int val = read.nextInt();
            if (val == -1)
                break;
            root1 = insertionInBST(root1, val);
        }

        // Read input for second tree
        TreeNode root2 = null;
        while (true) {
            int val = read.nextInt();
            if (val == -1)
                break;
            root2 = insertionInBST(root2, val);
        }

        read.close();

        AllElementsInTwoBinarySearchTrees_1305 obj = new AllElementsInTwoBinarySearchTrees_1305();
        List<Integer> result = obj.getAllElements(root1, root2);

        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        inorder(root1, l1);
        inorder(root2, l2);
        return merge(l1, l2);
    }

    public void inorder(TreeNode root, List<Integer> l) {
        if (root == null)
            return;
        inorder(root.left, l);
        l.add(root.val);
        inorder(root.right, l);
    }

    public List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i != list1.size() && j != list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                res.add(list1.get(i));
                i++;
            } else {
                res.add(list2.get(j));
                j++;
            }
        }
        if (i != list1.size()) {
            while (i != list1.size()) {
                res.add(list1.get(i));
                i++;
            }
        }
        if (j != list2.size()) {
            while (j != list2.size()) {
                res.add(list2.get(j));
                j++;
            }
        }
        return res;
    }

    public static TreeNode insertionInBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        if (val < root.val)
            root.left = insertionInBST(root.left, val);
        else
            root.right = insertionInBST(root.right, val);
        return root;
    }

    // method 1
    // public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
    // PriorityQueue<Integer> pq = new PriorityQueue<>();
    // inorder(root1, pq);
    // inorder(root2, pq);
    // List<Integer> res = new ArrayList<>();
    // int size = pq.size();
    // for (int i = 0; i < size; i++) {
    // res.add(pq.poll());
    // }
    // return res;
    // }

    // public static void inorder(TreeNode root, PriorityQueue<Integer> pq) {
    // if (root == null)
    // return;
    // inorder(root.left, pq);
    // pq.add(root.val);
    // inorder(root.right, pq);
    // }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
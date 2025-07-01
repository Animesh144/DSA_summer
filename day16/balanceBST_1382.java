package day16;

import java.util.*;

public class balanceBST_1382 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        TreeNode root = null;
        while (true) {
            int val = read.nextInt();
            if (val == -1)
                break;
            root = insertionInBST(root, val);
        }
        read.close();
    }

    static ArrayList<Integer> l1 = new ArrayList<>();

    public static TreeNode balanceBST(TreeNode root) {
        inorder(root);
        TreeNode res = rec(l1, 0, l1.size() - 1);
        return res;
    }

    public static void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        l1.add(root.val);
        inorder(root.right);
    }

    public static TreeNode rec(ArrayList<Integer> l1, int l, int r) {
        if (l > r)
            return null;
        int mid = (l + r) / 2;
        // int value = l1.get(mid);
        TreeNode root = new TreeNode(l1.get(mid));
        root.left = rec(l1, l, mid - 1);
        root.right = rec(l1, mid + 1, r);
        return root;
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

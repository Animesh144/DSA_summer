package day16;

import java.util.*;

public class recoverBST_99 {
    static TreeNode prev, f, s;

    public static void main(String[] arge) {
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

    public static void recoverTree(TreeNode root) {
        if (root == null)
            return;
        inorder(root);
        int temp = f.val;
        f.val = s.val;
        s.val = temp;

    }

    public static void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        if (prev != null && root.val < prev.val && f == null) {
            f = prev;
        }
        if (prev != null && root.val < prev.val && f != null) {
            s = root;
        }
        prev = root;
        inorder(root.right);
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

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
// class Solution {
// TreeNode prev, f, s;

// public void recoverTree(TreeNode root) {
// if (root == null)
// return;
// inorder(root);
// int temp = f.val;
// f.val = s.val;
// s.val = temp;

// }

// public void inorder(TreeNode root) {
// if (root == null)
// return;
// inorder(root.left);
// if (prev != null && root.val < prev.val && f == null) {
// f = prev;
// }
// if (prev != null && root.val < prev.val && f != null) {
// s = root;
// }
// prev = root;
// inorder(root.right);
// }
// }
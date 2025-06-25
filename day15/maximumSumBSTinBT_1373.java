package day15;

import java.util.*;

public class maximumSumBSTinBT_1373 {
    class unit {
        boolean bst;
        int sum;
        int max, min;

        unit(boolean bst, int sum, int min, int max) {
            this.bst = bst;
            this.sum = sum;
            this.min = min;
            this.max = max;
        }
    }

    int Msum = 0;

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        maximumSumBSTinBT_1373 obj = new maximumSumBSTinBT_1373();
        TreeNode root = null;

        System.out.println("Enter number of nodes:");
        int n = read.nextInt();
        System.out.println("Enter " + n + " node values (use -1 to skip a node):");

        for (int i = 0; i < n; i++) {
            int val = read.nextInt();
            if (val != -1) {
                root = insertionInBST(root, val);
            }
        }

        int result = obj.maximumSumBSTinBTSolution(root);
        System.out.println("Maximum Sum BST in Binary Tree: " + result);
        read.close();
    }

    public int maximumSumBSTinBTSolution(TreeNode root) {
        postorder(root);
        return Msum;
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

    public unit postorder(TreeNode curr) {
        if (curr == null) {
            return new unit(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        if (curr.left == null && curr.right == null) {
            if (curr.val > Msum)
                Msum = curr.val;
            return new unit(true, curr.val, curr.val, curr.val);
        }
        unit l = postorder(curr.left);
        unit r = postorder(curr.right);

        if (l.bst == true && r.bst == true && curr.val > l.max && curr.val < r.min) {
            int tempsum = l.sum + r.sum + curr.val;
            if (Msum < tempsum)
                Msum = tempsum;
            int m = (curr.left == null) ? curr.val : l.min;
            int M = (curr.right == null) ? curr.val : r.max;
            return new unit(true, tempsum, m, M);
        } else {
            return new unit(false, Math.max(l.sum, r.sum), 0, 0);
        }

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

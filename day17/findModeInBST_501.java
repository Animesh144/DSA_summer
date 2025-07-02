package day17;

import java.util.*;

public class findModeInBST_501 {

    static TreeNode prev = null;
    static int count = 1;
    static int maxCount = 0;
    static List<Integer> modes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        TreeNode root = null;

        // Input until -1 is entered
        while (true) {
            int val = read.nextInt();
            if (val == -1)
                break;
            root = insertionInBST(root, val);
        }
        read.close();

        int[] result = findMode(root);
        System.out.println("Mode(s) of the BST:");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }

    public static int[] findMode(TreeNode root) {
        inorder(root);
        int[] res = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            res[i] = modes.get(i);
        }
        return res;
    }

    public static void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);

        if (prev != null) {
            if (root.val == prev.val) {
                count++;
            } else {
                count = 1;
            }
        }

        if (count > maxCount) {
            maxCount = count;
            modes.clear();
            modes.add(root.val);
        } else if (count == maxCount) {
            modes.add(root.val);
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

// TreeNode class definition
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

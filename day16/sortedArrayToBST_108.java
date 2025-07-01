package day16;

import java.util.*;

public class sortedArrayToBST_108 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("Enter sorted integers to convert to BST (-1 to end):");
        List<Integer> inputList = new ArrayList<>();

        while (true) {
            int val = read.nextInt();
            if (val == -1)
                break;
            inputList.add(val);
        }
        read.close();

        // Convert List to array
        int[] nums = new int[inputList.size()];
        for (int i = 0; i < inputList.size(); i++) {
            nums[i] = inputList.get(i);
        }

        // Convert sorted array to BST
        TreeNode root = sortedArrayToBST(nums);

        // Print the in-order traversal of the BST
        System.out.println("Inorder traversal of constructed BST:");
        inorder(root);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return rec(nums, 0, nums.length - 1);
    }

    public static TreeNode rec(int[] nums, int l, int r) {
        if (l > r)
            return null;
        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = rec(nums, l, mid - 1);
        root.right = rec(nums, mid + 1, r);
        return root;
    }

    public static void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.val + " ");
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

package day17;

import java.util.*;

public class numberOfWaysToReorderArrayToGetSameBST_1569 {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("Enter the elements of the array (-1 to end):");

        List<Integer> inputList = new ArrayList<>();
        while (true) {
            int val = read.nextInt();
            if (val == -1)
                break;
            inputList.add(val);
        }
        read.close();

        int[] nums = new int[inputList.size()];
        for (int i = 0; i < inputList.size(); i++) {
            nums[i] = inputList.get(i);
        }

        numberOfWaysToReorderArrayToGetSameBST_1569 sol = new numberOfWaysToReorderArrayToGetSameBST_1569();
        int result = sol.numOfWays(nums);
        System.out.println("Number of ways to reorder the array to get the same BST: " + result);
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

    int MOD = (int) 1e9 + 7;
    int[][] pascal;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        pascal = new int[n][n];
        pascal[0][0] = 1;

        for (int i = 1; i < n; i++) {
            pascal[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                pascal[i][j] = (pascal[i - 1][j] + pascal[i - 1][j - 1]) % MOD;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        return preorder(list) - 1;
    }

    public int preorder(List<Integer> list) {
        if (list.size() < 2)
            return 1;

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(0))
                left.add(list.get(i));
            else
                right.add(list.get(i));
        }

        int lval = preorder(left);
        int rval = preorder(right);
        int n = left.size() + right.size();

        return (int) (((long) lval * rval % MOD) * pascal[n][right.size()] % MOD);
    }
}

class TreeNode {
    int val;
    TreeNode right;
    TreeNode left;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

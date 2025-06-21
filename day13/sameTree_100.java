package day13;

import java.util.*;

public class sameTree_100 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        int root1Val = read.nextInt();
        TreeNode root1 = new TreeNode(root1Val);
        levelOrderInsertion(root1, read);
        int root2Val = read.nextInt();
        TreeNode root2 = new TreeNode(root2Val);
        levelOrderInsertion(root2, read);
        sameTree_100 obj = new sameTree_100();
        boolean result = obj.sameTreeSolution(root1, root2);
        System.out.println(result);

        read.close();

    }

    public boolean sameTreeSolution(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;
        return (sameTreeSolution(p.left, q.left) && sameTreeSolution(p.right, q.right));
    }

    public static void levelOrderInsertion(TreeNode root, Scanner read) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            int l = read.nextInt();
            if (l != -1) {
                TreeNode ln = new TreeNode(l);
                curr.left = ln;
                q.add(ln);
            }
            int r = read.nextInt();
            if (r != -1) {
                TreeNode rn = new TreeNode(r);
                curr.right = rn;
                q.add(rn);
            }
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
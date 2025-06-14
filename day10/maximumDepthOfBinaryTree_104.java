package day10;

import java.util.*;

public class maximumDepthOfBinaryTree_104 {
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        int val = read.nextInt();
        TreeNode root = new TreeNode(val);
        levelOrderInsertion(root, read);
        System.out.println(maximumDepthOfBinaryTreeSolution(root, 0));
        read.close();
    }
    public static int maximumDepthOfBinaryTreeSolution(TreeNode root, int depth){
        if(root == null) return depth;
        int l = maximumDepthOfBinaryTreeSolution(root.left, depth+1);
        int r = maximumDepthOfBinaryTreeSolution(root.right, depth+1);
        return (l>r?l:r);
    }
    public static void levelOrderInsertion(TreeNode root, Scanner read){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            int l = read.nextInt();
            if(l!=-1){
                TreeNode ln = new TreeNode(l);
                curr.left = ln;
                q.add(ln);
            }
            int r = read.nextInt();
            if(r!=-1){
                TreeNode rn = new TreeNode(r);
                curr.right = rn;
                q.add(rn);
            }
        }
    }
}
class TreeNode {
    int val;
    TreeNode left ;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

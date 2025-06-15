package day11;
import java.util.*;

public class LowestCommonAncestor {
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        int rootVal = read.nextInt();
        TreeNode root = new TreeNode(rootVal);
        levelOrderInsertion(root, read);

        int pVal = read.nextInt();
        int qVal = read.nextInt();

        TreeNode pNode = findNode(root, pVal);
        TreeNode qNode = findNode(root, qVal);

        TreeNode lca = LowestCommonAncestorSolution(root, pNode, qNode);
        if(lca != null)
            System.out.println("Lowest Common Ancestor: " + lca.val);
        else
            System.out.println("One or both nodes not found in the tree.");

        read.close();
    }
    public static TreeNode LowestCommonAncestorSolution(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root == p || root == q) return root;
        TreeNode ln = LowestCommonAncestorSolution(root.left, p, q);
        TreeNode rn = LowestCommonAncestorSolution(root.right, p, q);
        if(ln != null && rn != null) return root;
        if(ln == null) return rn;
        else return ln;
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
    // Helper function to find a node by value
    public static TreeNode findNode(TreeNode root, int val){
        if(root == null) return null;
        if(root.val == val) return root;
        TreeNode left = findNode(root.left, val);
        if(left != null) return left;
        return findNode(root.right, val);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

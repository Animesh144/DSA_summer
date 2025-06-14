package day10;
import java.util.*;

public class pathSum_112 {
    static boolean flag = false;
    public static void main(String[] args){
        Scanner read = new Scanner (System.in);
        int target = read.nextInt();
        int val = read.nextInt();
        TreeNode root = new TreeNode(val);
        levelOrderInsertion(root, read);
        pathSumSolution(root,target,0);
        if(flag == true){
            System.out.println("true");
        }else {
            System.out.println("false");

        }
        read.close();
    }
    public static void pathSumSolution(TreeNode root, int target,int sum){
        if(root == null ) return;
        sum+=root.val;
        if(sum == target && root.left == null && root.right == null ) {
            flag = true;
            return;
        }
        pathSumSolution(root.left, target, sum);
        pathSumSolution(root.right, target, sum);
        
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

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

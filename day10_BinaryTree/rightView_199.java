package day10_BinaryTree;
import java.util.*;

public class rightView_199 {
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        int val = read.nextInt();
        TreeNode root = new TreeNode(val);
        levelOrderInsertion(root,read);
        List<Integer> res = new ArrayList<>();
        res = rightViewSolution(root);
        System.out.print(res);
        read.close();
    }
    public static List<Integer> rightViewSolution(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=1;i<=size;i++){
                TreeNode curr = q.poll();
                if(i == size) list.add(curr.val);
                System.out.print(curr.val+" ");
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            System.out.println();
        }
        return list;
    }
    public static void levelOrderInsertion(TreeNode root,Scanner read){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            int l = read.nextInt();
            if(l != -1 ){
                TreeNode ln = new TreeNode(l);
                curr.left = ln;
                q.add(ln);
            }
            int r = read.nextInt();
            if(r != -1){
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
    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}


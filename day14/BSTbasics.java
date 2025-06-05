package day14;
import java.util.*;
public class BSTbasics {
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        Node root = null;
        while(true){
            int val = read.nextInt();
            if(val == -1) break;
            root = insert(root,val);
        }
        read.close();
    }
    public static Node insert(Node root, int val){
        if(root == null){
            return new Node(val);
        }else if(root.val >val){
            root.left = insert(root.left, val);
        }else{
            root.left = insert(root.left, val);
        }
        return root;
    }
    public void preorder(Node root){
        if(root == null ) return ;
        preorder(root.left);
        System.out.print(root.val+" ");
        preorder(root.right);
    }
    
}

class Node {
    int val;
    Node left;
    Node right;
    Node (int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }   
}

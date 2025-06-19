package day13;

import java.util.Scanner;

public class sameTree_100 {
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        read.close();
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
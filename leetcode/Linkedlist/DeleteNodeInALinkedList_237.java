package leetcode.Linkedlist;

import java.util.Scanner;

public class DeleteNodeInALinkedList_237 {
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        read.close();
    }
    public void deleteNode(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        while(curr.next!=null){
            int temp = curr.val;
            curr.val = curr.next.val;
            curr.next.val = temp;
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
    }
    
}
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        this.next = null;
    }

}
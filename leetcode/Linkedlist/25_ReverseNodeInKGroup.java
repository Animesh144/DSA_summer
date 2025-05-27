package leetcode.Linkedlist;

// public class 25_ReverseNodeInKGroup {
    
// }
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev =null;
        ListNode curr=head;
        ListNode temp=null;
        int count = 0;
        while(curr!=null && count!=k){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
            count++;
        }
        if(exists(curr,k)){
            head.next=reverseKGroup(curr,k);
        }else {
            head.next=curr;
        }
        
        return prev;
    }

    public boolean exists(ListNode curr,int k){
        int c=0;
        while(curr!=null){
            c++;
            if(c==k) return true;
            curr=curr.next;
        }
        return false;
    }
}
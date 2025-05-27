package leetcode.Linkedlist;

// public class 92_ReverseLL2 {
    
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode tail = dummy;
        for(int i=1;i<left;i++){
            tail=tail.next;
        }
        ListNode prev=null;
        ListNode curr=tail.next;
        ListNode temp=null;
        for (int i=left;i<=right;i++){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        tail.next.next=curr;
        tail.next=prev;
        return dummy.next;
    }
}
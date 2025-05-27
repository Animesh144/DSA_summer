package leetcode.Linkedlist;

// public class 203_RemoveLLElement {
    
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
    public ListNode removeElements(ListNode head, int val) {
        if(head==null) return head;
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode prev=dummy;
        ListNode curr=head;

        while(curr!=null){
            if(curr.val==val){
                prev.next=prev.next.next;
                curr=curr.next;
            }else{
                curr=curr.next;
                prev=prev.next;
            }
        }
        return dummy.next;
    }
}
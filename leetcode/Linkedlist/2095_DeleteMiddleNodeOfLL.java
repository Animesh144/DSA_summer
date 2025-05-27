package leetcode.Linkedlist;
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

//  method 1;
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head.next==null){
            head=null;
            return head;
        }
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;
        while(fast!=null&&fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=slow.next;
        return head;
    }
}
// method 2
class Solution2 {
    public ListNode deleteMiddle(ListNode head) {
        if(head.next==null){
            head=null;
            return head;
        }
        ListNode slow=head;
        ListNode fast=head.next.next;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        slow.next=slow.next.next;
        return head;
    }
}
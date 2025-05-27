package leetcode.Linkedlist;

// public class 234_PalindromeLL {
    
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
    public boolean isPalindrome(ListNode head) {
        if (head.next==null) return true;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode h2=slow;

        ListNode prev=null,curr=h2,temp=null;
        while(curr!=null){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        h2=prev;
        while(h2!=null){
            if(head.val!=h2.val) return false;
            head=head.next;
            h2=h2.next;
        }
        return true;
        
    }
}
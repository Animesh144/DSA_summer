package leetcode.Linkedlist;

// public class 83_RemoveDuplicateFromSortedLL {
    
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        ListNode tail=head;
        while(tail!=null && tail.next!=null){
            if(tail.val==tail.next.val){
                ListNode p2=tail.next;
                while(p2!=null && tail.val==p2.val){
                    p2=p2.next;
                }
                tail.next=p2;
            }else{
                tail=tail.next;
            }
        }
        return head;
    }
}
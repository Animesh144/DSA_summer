package leetcode.Linkedlist;

// public class 328_oddEvenLL {
    
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
    public ListNode oddEvenList(ListNode head) {
        // zero node       single node     two node
        if(head==null || head.next==null || head.next.next==null) return head;
        ListNode ot =head;
        ListNode et =head.next;
        ListNode eh =head.next;

        while(et!= null && et.next!=null){
            ot.next=ot.next.next;
            et.next=et.next.next;
            et=et.next;
            ot=ot.next;
        }
        ot.next=eh;
        return head;
    }
}
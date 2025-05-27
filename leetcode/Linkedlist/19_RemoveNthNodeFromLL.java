package leetcode.Linkedlist;
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null){
            head=null;
            return head;
        }
        ListNode p1=head;
        ListNode p2=head;
        while(n>0){
            p2=p2.next;
            n--;
        }
        // gap is greater then number of elements
        if(p2==null){
            head=head.next;
            return head;
        }
        while(p2.next!=null){
            p1=p1.next;
            p2=p2.next;
        }
        p1.next=p1.next.next;
        return head;
    }
}
class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
   
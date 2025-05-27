package leetcode.Linkedlist;

class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode current=head;
        ListNode temp = head.next;
        while(temp!=null){
            int gcd= GCD(current.val,temp.val);
            ListNode newNode = new ListNode(gcd);
            newNode.next=temp;
            current.next=newNode;
            temp=temp.next;
            current=current.next.next;
        }
        return head;
    }
    public int GCD(int a,int b){
        if (b==0){
            return a;
        }else{
            return GCD(b,a%b);
        }
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
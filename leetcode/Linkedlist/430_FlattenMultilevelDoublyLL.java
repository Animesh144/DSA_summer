package leetcode.Linkedlist;

// public class 430_FlattenMultilevelDoublyLL {
    
// }

// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};


class Solution {
    public Node flatten(Node head) {
        Node curr = head;
        while(curr!=null){
            if(curr.child!=null){
                Node temp=curr.next;
                Node tail=curr.child;
                while(tail.next!=null){
                    tail=tail.next;
                }
                curr.next=curr.child;
                curr.child.prev=curr;
                if(temp!=null){
                    temp.prev=tail;
                    tail.next=temp;
                }
                curr.child=null;
            }
            curr=curr.next;
        }
        return head;
    }
}

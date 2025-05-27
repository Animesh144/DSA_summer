package leetcode.Linkedlist;
import java.util.HashSet;
// public class 160_IntersectionOfLL {
    
// }
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> insect = new HashSet<>();
        ListNode temp =headA;
        while(temp!=null){
            insect.add(temp);
            temp=temp.next;
        }
        temp=headB;
        while(temp!=null){
            if(insect.contains(temp)) return temp;
            temp=temp.next;
        }
        return null;


    }
}
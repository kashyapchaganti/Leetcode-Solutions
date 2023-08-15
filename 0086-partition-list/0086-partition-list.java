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
    public ListNode partition(ListNode head, int x) {
        ListNode before = new ListNode(0);ListNode after = new ListNode(0);
        ListNode x1 =before, x2= after;
        while(head!=null){
            if(head.val<x){
                x1.next= new ListNode(head.val);
                x1=x1.next;
            }else{
                x2.next= new ListNode(head.val);
                x2=x2.next;
            }
            head= head.next;
        }
        x1.next=after.next;
        return before.next;
        
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        ListNode nextnext =null;
        if(next!=null){
            nextnext = next.next;
            node.val= next.val;
            node.next=nextnext;
        }else{
            node = null;
        }
        return;
        
        
    }
}
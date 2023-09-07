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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int i=0;
        ListNode current=head;
        ListNode firstPrev=null;
        while(i<left-1 && current!=null){
            firstPrev=current;
            current=current.next;
            i++;
        }
        ListNode secondPrev=null;
        ListNode lastNode=current;
        for(i=0;current!=null && i<right-left+1;i++ ){
            ListNode next =current.next;
            current.next=secondPrev;
            secondPrev=current;
            current=next;
        }
        if(firstPrev!=null){
            firstPrev.next = secondPrev;
        }else{
            head=secondPrev;
        }
        lastNode.next =current;
        return head;
        
        
    }
}
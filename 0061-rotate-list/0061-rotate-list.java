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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0) return head;
        int len = 0;
        ListNode d = head;
        ListNode last =null;
        while(d!=null){
            len++;
            if(d.next==null){
                d.next=head;
                last= d;
                break;
            }
            d=d.next;
        }
        k=k%len;
        k= len-k;
        
        while(head!=null && k>0){
            k--;
            if(k==0) {
                last= head.next;
                head.next=null;
            }
            head =head.next;
        }
        return last;
    }
}
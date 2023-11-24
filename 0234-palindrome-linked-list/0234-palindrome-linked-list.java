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
    public boolean isPalindrome(ListNode head) {
        ListNode slow =head;
        ListNode fast =head;
        ListNode x=null;
        while(fast!=null && fast.next!=null){
            x = slow;
            fast = fast.next.next;
            slow =slow.next;
            
        }
        ListNode mid = reverse(slow);
        if(x!=null){
            x.next= null;
        }
        while(head!=null && mid!=null){
            if(head.val!=mid.val){
                return false;
            }
            head=head.next;
            mid=mid.next;
        }
        return true;
        
    }
    public static ListNode reverse(ListNode head){
        ListNode prev= null;
        while(head!=null){
            ListNode next = head.next;
            head.next= prev;
            prev= head;
            head= next;
        }
        return prev;
    }
}
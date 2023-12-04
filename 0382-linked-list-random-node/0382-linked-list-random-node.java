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
    private ListNode dummy;
    public Solution(ListNode head) {
       dummy= head;
        
    }
    
    public int getRandom() {
        int scope =1, choosen=0;
        ListNode d=dummy;
        while(d!=null){
            if(Math.random() < 1.0/scope){
                choosen=d.val;
                
            }
            scope++;
            d=d.next;
        }
        return choosen;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode x= head;
        int c=0;
        while(x!=null){
            c++;
            x=x.next;
        }
        ListNode[] ans = new ListNode[k];
        // int i=0,j=0;
        int size=c/k;
        int rem = c%k;
        
       
        
        boolean f=false;
        for(int i=0;i<k;i++){
            ListNode cur = new ListNode(0), write =cur;
            for(int j=0;j<size +(i<rem?1:0);j++){
                write =write.next= new ListNode(head.val);
                if(head!=null){
                    head=head.next;
                }
            }
            ans[i]=cur.next;
            
        }
        return ans;
    }
}
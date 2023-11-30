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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res= new ListNode(-1);
        ListNode x = res;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)->(a.val-b.val));
        for(ListNode l: lists){
            if(l!=null)
            minHeap.add(l);
            
        }
        while(!minHeap.isEmpty()){
            ListNode cur= minHeap.poll();
            ListNode next= cur.next;
            cur.next=null;
            x.next=cur;
            x=x.next;
            if(next!=null){
                cur=next;
                minHeap.add(cur);    
            }
            
        }
        return res.next;
        
    }
}
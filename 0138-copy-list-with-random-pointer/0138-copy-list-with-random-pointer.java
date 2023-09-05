/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> m = new HashMap<>();
        if(head==null) return null;
        
        // copy of old node
        Node oldNode = head;
        Node newNode =new Node(oldNode.val);
        m.put(oldNode, newNode); // oldnode : newnode 
        while(oldNode!=null){
            
            Node random = oldNode.random;
            Node next = oldNode.next;
            if(random!=null ){
                if(!m.containsKey(random))
                m.put(random,new Node(random.val));
                newNode.random= m.get(random);
                
            }else{
                newNode.random= null;
            }
            if(next!=null){
                if(!m.containsKey(next))
                m.put(next,new Node(next.val));
                newNode.next=m.get(next);
            }else{
                newNode.next= null;
            }
            newNode = newNode.next;
            oldNode= oldNode.next;
            
        }
        return m.get(head);
        
        
    }
}
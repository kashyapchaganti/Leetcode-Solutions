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

// class Solution {
//     public Node copyRandomList(Node head) {
//         Node x= new Node(-1);
//         Node y = new Node(0);
//         x.next=y;
//         while(head!=null){
//             y.val= head.val;
//             Node r=head.random;
//             if(r!=null)
//             y.random = new Node(r.val);
//             Node next = head.next;
//             if(next!=null){
//                 y.next= new Node(next.val);
//             }
//             head= head.next;
//             y=y.next;
//         }
       
//         return x.next;
//     }
// }

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
public class Solution {
  public Node copyRandomList(Node head) {

    if (head == null) {
      return null;
    }

    // Creating a new weaved list of original and copied nodes.
    Node ptr = head;
    while (ptr != null) {

      // Cloned node
      Node newNode = new Node(ptr.val);

      // Inserting the cloned node just next to the original node.
      // If A->B->C is the original linked list,
      // Linked list after weaving cloned nodes would be A->A'->B->B'->C->C'
      newNode.next = ptr.next;
      ptr.next = newNode;
      ptr = newNode.next;
    }

    ptr = head;

    // Now link the random pointers of the new nodes created.
    // Iterate the newly created list and use the original nodes' random pointers,
    // to assign references to random pointers for cloned nodes.
    while (ptr != null) {
      ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
      ptr = ptr.next.next;
    }

    // Unweave the linked list to get back the original linked list and the cloned list.
    // i.e. A->A'->B->B'->C->C' would be broken to A->B->C and A'->B'->C'
    Node ptr_old_list = head; // A->B->C
    Node ptr_new_list = head.next; // A'->B'->C'
    Node head_old = head.next;
    while (ptr_old_list != null) {
      ptr_old_list.next = ptr_old_list.next.next;
      ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : null;
      ptr_old_list = ptr_old_list.next;
      ptr_new_list = ptr_new_list.next;
    }
    return head_old;
  }
}
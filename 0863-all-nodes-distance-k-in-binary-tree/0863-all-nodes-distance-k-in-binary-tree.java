/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k){
		if(root==null) return new ArrayList<>();
    HashMap<Integer,List<Integer>> adjacencyList = new HashMap<>(); 
    buildGraph(root, null,adjacencyList);
    List<Integer> result = new ArrayList<>();
    if(!adjacencyList.containsKey(target.val)) return new ArrayList<>();
    
    dfsTraversal(target.val,-1, 0, k, result,adjacencyList);
    return result;
}
public void dfsTraversal(int src, int p, int dis, int k, List<Integer> result, HashMap<Integer,List<Integer>> adjacencyList){ // o(n)

	if(dis==k){
  		result.add(src);
      return;
  }
    for(int child: adjacencyList.get(src)){
    		if(child!=p){
        		dfsTraversal(child, src, dis+1, k, result,adjacencyList);
        }
    }
}
public void buildGraph(TreeNode root, TreeNode parent, HashMap<Integer,List<Integer>> adjacencyList){ // o(n) n -> nodes  
		if(root==null) return ;
    
    // Adding the node to the adj list
    adjacencyList.put(root.val, new ArrayList<>());
    
    if(parent!=null)
    adjacencyList.get(root.val).add(parent.val);
    
    if(root.left!=null){
    	adjacencyList.get(root.val).add(root.left.val);
    }
    
    if(root.right!=null){
    	adjacencyList.get(root.val).add(root.right.val); 
    }
    buildGraph(root.left, root, adjacencyList);
    buildGraph(root.right, root, adjacencyList);
    
}
}


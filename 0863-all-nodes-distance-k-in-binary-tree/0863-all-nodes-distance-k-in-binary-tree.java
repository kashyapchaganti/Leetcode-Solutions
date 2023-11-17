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
    List<Integer> finalOutput ;
    HashMap<Integer,HashSet<Integer>> adjacencyList; 

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        finalOutput= new ArrayList<>(); 
         adjacencyList= new HashMap<>();
	buildGraph(root,-1); 
	calculateDistanceFromSource(target.val, 0, k, -1);
	return finalOutput;
    }
    public void buildGraph(TreeNode root, int parent){
 if(root==null){
	return ; 
}
adjacencyList.put(root.val, adjacencyList.getOrDefault(root.val, new HashSet<>()));
if(parent!=-1) adjacencyList.get(root.val).add(parent);
if(root.left!=null)
adjacencyList.get(root.val).add(root.left.val);
if(root.right!=null)
adjacencyList.get(root.val).add(root.right.val);

buildGraph(root.left, root.val);
buildGraph(root.right, root.val);

    }

public void calculateDistanceFromSource(int source, int distance, int requiredDistance, int parent){
	if(distance == requiredDistance) finalOutput.add(source);
	for(int child: adjacencyList.get(source)){
		if(child == parent) continue;
		calculateDistanceFromSource(child, distance+1, requiredDistance, source);

	}
	

}
    
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        Queue<TreeNode> q= new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(root);
        sb.append(root.val +",");
        while(!q.isEmpty()){
            int n = q.size();
            for(int i=0;i<n;i++){
                TreeNode cur = q.poll();
                
                if(cur.left==null){
                    sb.append("#"+",");
                }else{
                    sb.append(cur.left.val+",");
                    q.add(cur.left);
                }
                
                if(cur.right==null){
                    sb.append("#"+",");
                }else{
                    sb.append(cur.right.val+",");
                    q.add(cur.right);
                }
            }
        }
        
        return sb.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<TreeNode> q= new LinkedList<>();
        if(data.length()==0) return null;
        String[] arr = data.split(",");
        
        TreeNode root =new TreeNode(Integer.parseInt(arr[0]));
        q.add(root);
        int index =0;
        while(!q.isEmpty()){
            int n =q.size();
            for(int i=0;i<n;i++){
                TreeNode cur = q.poll();
                String left = arr[2*index+1];
                String right = arr[2*index+2];
                if(left.equals("#")){
                    cur.left=null;
                }else{
                    cur.left= new TreeNode(Integer.parseInt(left));
                    q.add(cur.left);
                }
                
                if(right.equals("#")){
                    cur.right=null;
                }else{
                    
                    cur.right= new TreeNode(Integer.parseInt(right));
                    q.add(cur.right);
                }
                index++;
                
            }
        }
        return root;
        
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
class Solution {
    int n,m,wL;
    int[] dr = {-1,0,1,0}, dc={0,1,0,-1};
    HashSet<String> ans=new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {

        n= board.length; m=board[0].length; wL=words.length;
        Node trie= new Node();
        
        for(int i=0;i<wL;i++){
            String s= words[i];
            Node dummy = trie;
            for(int j=0;j<s.length();j++){
                if(dummy.arr[s.charAt(j)-'a']==null){
                    dummy.arr[s.charAt(j)-'a']=new Node();
                    dummy= dummy.arr[s.charAt(j)-'a'];
                }else{
                    dummy= dummy.arr[s.charAt(j)-'a'];
                }
            }
            dummy.addWord(s);
        }
        
        for(int i=0;i<n;i++){
            
            for(int j= 0;j<m;j++){
                int[][] vis= new int[n][m];
                if(trie.arr[board[i][j]-'a']!=null){
                    
                    check(i,j,board,vis,trie.arr[board[i][j]-'a']);    
                }
                
            }
        }
        
        
        return new ArrayList<>(ans);
    }
    public void check(int i, int j, char[][] b, int[][] vis, Node trie){ // tc -> o(n*3^L*(num of words)) -> 244*3^10*10^5
        vis[i][j]=1;
        if(trie.isThereAWord()){
            ans.add(trie.word);
        }
        for(int k=0;k<4;k++){
            int x= i+dr[k];
            int y= j+dc[k];
            if(x>=0 && x<n && y>=0 && y<m && vis[x][y]==0 && trie.arr[b[x][y]-'a']!=null){
                check(x,y,b,vis, trie.arr[b[x][y]-'a']);
            }
        }
        vis[i][j]=0;
        return;
        
        
    }
    
}
class Node{
    Node[] arr;
    String word="";
    
    public Node(){    
        arr= new Node[26];
        
    }
    public void addWord(String s){
        word=s;
        
    }
    public boolean isThereAWord(){
        return word.length()>0;
    }
}

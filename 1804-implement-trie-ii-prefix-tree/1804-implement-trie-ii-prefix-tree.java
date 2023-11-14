class Trie {
    Node root;
    public Trie() {
            root=new Node();
    }
    
    public void insert(String word) {
        Node r1=root;
        int n =word.length();
        for(int i=0;i<n;i++){
            char ch= word.charAt(i);
            
            if(r1.arr[ch-'a']==null){
                r1.arr[ch-'a']=new Node();
                
            }
            r1.arr[ch-'a'].r++;
            r1=r1.arr[ch-'a'];
            
        }
        r1.c++;
        
    }
    
    public int countWordsEqualTo(String word) {
        Node r1=root;
        int n =word.length();
        int c=0;
        for(int i=0;i<n;i++){
            char ch= word.charAt(i);
            
            if(r1.arr[ch-'a']==null){
               return 0;
            }
            
            r1=r1.arr[ch-'a'];
        }
        return r1.c;
        
        
    }
    
    public int countWordsStartingWith(String word) {
          Node r1=root;
        int n =word.length();
        int c=0;
        for(int i=0;i<n;i++){
            char ch= word.charAt(i);
            
            if(r1.arr[ch-'a']==null){
               return 0;
            }
            c=r1.arr[ch-'a'].r;
            r1=r1.arr[ch-'a'];
        }
        return c;
    }
    
    public void erase(String word) {
        Node r1 = root;
        int n = word.length();
        for(int i=0;i<n;i++){
            char ch =word.charAt(i);
            r1.arr[ch-'a'].r--;
            r1=r1.arr[ch-'a'];
        }
        r1.c--;
    }
}
class Node{
    
    Node[] arr ;
    int r,c;
    public Node(){
        
        arr = new Node[26];
        
        
    }
    public String toString(){
        return Arrays.toString(arr)+" "+r;
    }
}
class Pair{
    int r;
    Node[] a;
    public Pair(){
        a= new Node[26];
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */
class Trie {
    Node root ;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node r1= root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(r1.arr[ch-'a']==null){
                r1.arr[ch-'a']=new Node();
            }
            r1=r1.arr[ch-'a'];
        }
        r1.f=true;
    }
    
    public boolean search(String word) {
          Node r1= root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(r1.arr[ch-'a']==null){
                return false;
            }
            r1=r1.arr[ch-'a'];
        }
        if(r1.f)return true;
        return false;
    }
    
    public boolean startsWith(String prefix) {
         Node r1= root;
        for(int i=0;i<prefix.length();i++){
            char ch = prefix.charAt(i);
            if(r1.arr[ch-'a']==null){
                return false;
            }
            r1=r1.arr[ch-'a'];
        }
        return true;
    }
}

class Node{
    boolean f;
    Node[] arr; 
    public Node(){
        arr =new Node[26];
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
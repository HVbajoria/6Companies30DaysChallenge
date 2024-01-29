class WordDictionary {
    public class Node{
        Node[] children;
        boolean isEnd;
        Node(){
            children=new Node[26];
            isEnd=false;
        }
    }
    private Node root;
    public WordDictionary() {
        root=new Node();
    }
    
    public void addWord(String word) {
        Node ptr=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(ptr.children[ch-'a']==null){
                Node nn=new Node();
                ptr.children[ch-'a']=nn;
            }
            ptr=ptr.children[ch-'a'];
        }
        ptr.isEnd=true;
    }
    public boolean find(Node node,String word,int index){
        if(index==word.length()){
            return node.isEnd;
        }
            char ch=word.charAt(index);
            if(ch=='.'){
                for(int i=0;i<26;i++){
                    if(node.children[i]!=null && find(node.children[i],word,index+1)){
                        return true;
                    }
                }
            }else if(node.children[ch-'a']!=null){
                return find(node.children[ch-'a'],word,index+1);
            }
        return false;
    }
    public boolean search(String word) {
        return find(root,word,0);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

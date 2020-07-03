package tree;

import search.backtracking.Trie;

public class WordDictionary {
    class TrieNode{
        TrieNode[]children;
        boolean flag;
        public TrieNode(){
            flag = false;
            children = new TrieNode[26];
            for (int i = 0;i < 26;i++){
                children[i] = null;
            }
        }
    }
    TrieNode root;
    public WordDictionary(){
        root = new TrieNode();
    }
    public void addWord(String word){
        TrieNode cur = root;
        for (int i = 0;i < word.length();i++){
            if (cur.children[word.charAt(i) - 'a'] == null){
                cur.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            cur = cur.children[word.charAt(i) - 'a'];
        }
        cur.flag = true;
    }
    public boolean search(String word){
        return search(word,root);
    }
    private boolean search(String word,TrieNode node){
        TrieNode cur = node;
        for (int i = 0;i < word.length();i++){
            if (word.charAt(i) == '.'){
                for (int j = 0;j < 26;j++){
                    if (cur.children[j] != null){
                        if (search(word.substring(i+1),cur.children[j]))
                            return true;
                    }
                }
                return false;
            }
            if (cur.children[word.charAt(i) - 'a'] == null)
                return false;
            cur = cur.children[word.charAt(i) - 'a'];
        }
        return cur.flag;
    }
}

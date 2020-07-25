package daily;

import search.backtracking.Trie;

public class RespaceII {
    class TrieNode{
        TrieNode[]children;
        boolean isWord;
        public TrieNode(){
            children = new TrieNode[26];
            isWord = false;
        }
    }
    TrieNode root;
    public int respace(String[]dictionary,String sentence){
        root = new TrieNode();
        buildTrie(dictionary);
        int len = sentence.length();
        int[]dp = new int[len+1];
        for (int i = len-1;i >= 0;i--){
            dp[i] = len - i;
            TrieNode cur = root;
            for (int j = i;j < len;j++){
                int idx = sentence.charAt(i) - 'a';
                if (cur.children[idx] == null){
                    dp[i] = Math.min(dp[i],j-i+1+dp[j+1]);
                    break;
                }
                if (cur.children[idx].isWord){
                    dp[i] = Math.min(dp[i],dp[j+1]);
                }
                else {
                    dp[i] = Math.min(dp[i],j-i+1+dp[j+1]);
                }
                cur = cur.children[idx];
            }
        }
        return dp[len];
    }

    public void buildTrie(String[]dictionary){
        for (String word : dictionary){
            TrieNode cur = root;
            for (int i = 0;i < word.length();i++){
                if (cur.children[word.charAt(i)-'a'] == null){
                    cur.children[word.charAt(i) - 'a'] = new TrieNode();
                }
                cur = cur.children[word.charAt(i) - 'a'];
            }
            cur.isWord = true;
        }
    }
}

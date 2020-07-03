package search.backtracking;

import java.util.ArrayList;
import java.util.List;

class TrieNode{
    TrieNode[]children;
    String word;
    public TrieNode(){
        children = new TrieNode[26];
        for (int i = 0;i < 26;i++){
            children[i] = null;
        }
        word = null;
    }
}
class Tries{
    TrieNode root;
    public Tries(){
        root = new TrieNode();
    }
    public void insert(String word){
        TrieNode cur = root;
        for (int i = 0;i < word.length();i++){
            if (cur.children[word.charAt(i) - 'a'] == null){
                cur.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            cur = cur.children[word.charAt(i) - 'a'];
            cur.word = word;
        }
    }
}
public class Solution {
    private int [][] direction = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
    private int m;
    private int n;
    public List<String>findWords(char[][]board,String[]words){
        List<String> result = new ArrayList<>();
        if (board == null || board.length == 0)
            return result;
        Tries tries = new Tries();
        for (String word : words)
            tries.insert(word);
        m = board.length;
        n = board[0].length;
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                backtracking(board,tries.root,result,i,j);
            }
        }
        return result;
    }
    private void backtracking(char[][]board,TrieNode node,List<String>result,int r,int c){
        if (r < 0 || r >= m || c < 0 || c >= n)
            return;
        char cur = board[r][c];
        if (cur == '$' || node.children[cur-'a'] == null)
            return;
        node = node.children[cur - 'a'];
        if (node.word != null){
            result.add(node.word);
            node.word = null;
        }
        char temp = board[r][c];
        board[r][c] = '$';
        for (int[]d : direction){
            backtracking(board,node,result,r + d[0],c + d[1]);
        }
        board[r][c] = temp;
    }
}

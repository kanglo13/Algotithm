package daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePairs {
   class TrieNode{
       TrieNode[]children;
       int index;
       List<Integer>suffix;
       public TrieNode(){
           this.children = new TrieNode[26];
           this.index = -1;
           this.suffix = new ArrayList<>();
       }
   }
   TrieNode root;
   public List<List<Integer>>palindromePairs(String[]words){
       this.root = new TrieNode();
       int n = words.length;
       List<List<Integer>>result = new ArrayList<>();
       for (int i = 0;i < n;i++){
           String word = new StringBuilder(words[i]).reverse().toString();
           TrieNode cur = root;
           if (isPalindrome(word.substring(0)))
               cur.suffix.add(i);
           for (int j = 0;j < word.length();j++){
               int index = word.charAt(j)-'a';
               if (cur.children[index] == null){
                   cur.children[index] = new TrieNode();
               }
               cur = cur.children[index];
               if (isPalindrome(word.substring(j+1)))
                   cur.suffix.add(i);
           }
           cur.index = i;
       }
       for (int i = 0;i < n;i++){
           String word = words[i];
           TrieNode cur = root;
           int j = 0;
           for (;j < word.length();j++){
               if (isPalindrome(word.substring(j)) && cur.index != -1)
                   result.add(Arrays.asList(i,cur.index));
               int index = word.charAt(j);
               if (cur.children[index] == null)
                   break;
               cur = cur.children[index];
           }
           if(j == word.length()){
               for (int k : cur.suffix){
                   if(k != i)
                       result.add(Arrays.asList(i,k));
               }
           }
       }
       return result;
   }
   private boolean isPalindrome(String s){
       int i = 0;
       int j = s.length()-1;
        while(i < j){
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
   }
}

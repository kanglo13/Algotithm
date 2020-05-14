package search.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Partition {
    public List<List<String>> partition(String s){
        List<List<String>> partitions = new ArrayList<>();
        if (s == null || s.length() == 0)
            return partitions;
        List<String>partitionList = new ArrayList<>();
        backtracking(partitions,partitionList,s);
        return partitions;
    }
    private void backtracking(List<List<String>>partitions,List<String>partitionList,String s){
        if (s.length() == 0){
            partitions.add(new ArrayList<>(partitionList));
            return;
        }
        for (int i = 0;i < s.length();i++){
            if (isPalindrome(s,0,i)){
                partitionList.add(s.substring(0,i+1));
                backtracking(partitions,partitionList,s.substring(i+1));
                partitionList.remove(partitionList.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s,int start,int end){
        while (start < end){
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}

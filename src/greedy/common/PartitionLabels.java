package greedy.common;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s){
        int[]lastIndex = new int[26];
        for(int i = 0;i < s.length();i++){
            lastIndex[s.charAt(i) -'a'] = i;
        }
        int left = 0;
        List<Integer> partitions = new ArrayList<>();
        while (left < s.length()){
            int right = left;
            for (int i = left;i < s.length() && i <= right;i++){
                int index = lastIndex[s.charAt(i) - 'a'];
                if (index > right){
                    right = index;
                }
            }
            partitions.add(right-left+1);
            left = right + 1;
        }
        return partitions;
    }
    public List<Integer>partitionLabel(String s){
        List<Integer>result = new ArrayList<>();
        int[]hash = new int[26];
        int n = s.length();
        for (int i = 0;i < n;i++){
            hash[s.charAt(i)-'a'] = i;
        }
        int last = 0, start = 0;
        for (int i = 0;i < n;i++){
            last = Math.max(last,hash[s.charAt(i)-'a']);
            if (i == last){
                result.add(i-start+1);
                start = i + 1;
            }
        }
        return result;
    }
}

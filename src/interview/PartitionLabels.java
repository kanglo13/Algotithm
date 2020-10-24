package interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kanglo
 * @create 2020-10-2020/10/22 11:14
 */
public class PartitionLabels {
    public List<Integer>partitonLabels(String S){
        List<Integer>result = new ArrayList<>();
        if (S == null || S.length() == 0)
            return result;
        int[]hash = new int[26];
        for (int i = 0;i < S.length();i++) {
            hash[S.charAt(i)-'a'] = i;
        }
        int last = 0;
        int start = 0;
        for (int i = 0;i < S.length();i++){
            last = Math.max(last,hash[S.charAt(i)]);
            if (last == i){
                result.add(i-start+1);
                start = i + 1;
            }
        }
        return result;
    }
}

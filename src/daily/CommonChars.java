package daily;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kanglo
 * @create 2020-10-2020/10/14 10:04
 */
public class CommonChars {
    public List<String>commonChars(String[]A){
        List<String>result = new ArrayList<>();
        int[]count = new int[26];
        for (char ch : A[0].toCharArray())
            count[ch-'a']++;
        for (int i = 1;i < A.length;i++){
            int[]temp = new int[26];
            for (char ch : A[i].toCharArray())
                temp[ch-'a']++;
            for (int j = 0;j < 26;j++)
                count[j] = Math.min(count[j],temp[j]);
        }
        for (int i = 0;i < 26;i++){
            if (count[i] > 0){
                for (int j = 0;j < count[i];j++){
                    result.add((char)(i+'a')+"");
                }
            }
        }
        return result;
    }
}

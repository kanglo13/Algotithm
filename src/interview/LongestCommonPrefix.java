package interview;

/**
 * @author kanglo
 * @create 2020-10-2020/10/16 14:17
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[]strs){
        if (strs == null || strs.length == 0)
            return "";
        String result = strs[0];
        for (int i = 1;i < strs.length;i++){
            int j = 0;
            while (j < result.length() && j < strs[i].length() && result.charAt(j) == strs[i].charAt(j))
                j++;
            result = result.substring(0,j);
            if (result.equals(""))
                return result;
        }
        return result;
    }
}

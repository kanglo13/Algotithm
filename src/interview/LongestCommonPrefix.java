package interview;

/**
 * @author kanglo
 * @create 2020-09-2020/9/26 18:08
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[]strs){
        if (strs == null || strs.length == 0)
            return "";
        String result = strs[0];
        for (int i = 1;i < strs.length;i++){
            int j = 0;
            for (;j < result.length() && j < strs[i].length();j++){
                if (result.charAt(j) != strs[i].charAt(j))
                    break;
            }
            result = strs[i].substring(0,j);
            if (result.equals(""))
                return result;
        }
        return result;
    }
}

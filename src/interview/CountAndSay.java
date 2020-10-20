package interview;

/**
 * @author kanglo
 * @create 2020-10-2020/10/18 16:20
 */
public class CountAndSay {
    public String countAndSay(int n){
        if (n == 1)
            return "1";
        String str = countAndSay(n-1);
        StringBuilder result = new StringBuilder();
        int pre = 0;
        for (int i = 0;i <= str.length();i++){
            if (i == str.length()){
                result.append(i-pre).append(str.charAt(pre));
                return result.toString();
            }
            else if (str.charAt(i) != str.charAt(pre)){
                result.append(i-pre).append(str.charAt(pre));
                pre = i;
            }

        }
        return result.toString();
    }
}

package string;

public class CountAndSay {
    public String countAndSay(int n){
        if (n == 1)
            return "1";
        String str = countAndSay(n-1);
        StringBuilder result = new StringBuilder();
        int pre = 0;
        for (int i = 0;i <= str.length();i++){
            if (i == str.length()){
                return result.append(i-pre).append(str.charAt(pre)).toString();
            }
            else if (str.charAt(pre) != str.charAt(i)){
                result.append(i-pre).append(str.charAt(pre));
                pre = i;
            }
        }
        return result.toString();
    }
}

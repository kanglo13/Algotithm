package interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kanglo
 * @create 2020-09-2020/9/30 20:54
 */
public class LetterCombinations {
    private String[]dictionary = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits){
        List<String>result = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return result;
        backtracking(result,new StringBuilder(),digits,0);
        return result;
    }
    private void backtracking(List<String>result,StringBuilder tempString,String digits,int start){
        if (tempString.length() == digits.length()){
            result.add(tempString.toString());
            return;
        }
        int index = Integer.parseInt(digits.substring(start,start+1));
        for (char ch : dictionary[index].toCharArray()){
            tempString.append(ch);
            backtracking(result,tempString,digits,start+1);
            tempString.deleteCharAt(tempString.length()-1);
        }
    }
}

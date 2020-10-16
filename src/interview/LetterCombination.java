package interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kanglo
 * @create 2020-10-2020/10/16 15:03
 */
public class LetterCombination {
        private String[]dictionary = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        public List<String>letterCombinations(String digits){
            List<String>result = new ArrayList<>();
            if (digits == null || digits.length() == 0)
                return result;
            backtracking(result,new StringBuilder(),digits,0);
            return result;
        }
        private void backtracking(List<String>result,StringBuilder tempString,String digits,int curIndex){
            if (tempString.length() == digits.length()){
                result.add(tempString.toString());
                return;
            }
                int index = Integer.parseInt(digits.substring(curIndex,curIndex+1));
                String str = dictionary[index];
                for (char ch : str.toCharArray()){
                    tempString.append(ch);
                    backtracking(result,tempString,digits,curIndex+1);
                    tempString.deleteCharAt(tempString.length()-1);
                }

        }
}

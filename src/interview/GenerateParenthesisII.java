package interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kanglo
 * @create 2020-10-2020/10/16 22:28
 */
public class GenerateParenthesisII {
    public List<String>generateParenthesis(int n){
        List<String>result = new ArrayList<>();
        if (n == 0)
            return result;
        backtracking(result,new StringBuilder(),n,n);
        return result;
    }
    private void backtracking(List<String>result,StringBuilder tempString,int left,int right){
        if (right < left)
            return;
        if (right < 0 || left < 0)
            return;
        if (left == 0 && right == 0){
            result.add(tempString.toString());
            return;
        }
        tempString.append("(");
        backtracking(result,tempString,left-1,right);
        tempString.deleteCharAt(tempString.length()-1);

        tempString.append(")");
        backtracking(result,tempString,left,right-1);
        tempString.deleteCharAt(tempString.length()-1);
    }
}

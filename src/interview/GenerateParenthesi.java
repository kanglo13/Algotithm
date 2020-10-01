package interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kanglo
 * @create 2020-09-2020/9/30 22:56
 */
public class GenerateParenthesi {
    public List<String>generateParenthesi(int n){
        List<String>result = new ArrayList<>();
        if (n <= 0)
            return result;
        backtracking(result,new StringBuilder(),n,n);
        return result;
    }
    private void backtracking(List<String>result,StringBuilder temp,int left,int right){
        if (right < left)
            return;
        if (right < 0 || left < 0)
            return;
        if (left == 0 && right == 0){
            result.add(temp.toString());
            return;
        }
        temp.append("(");
        backtracking(result,temp,left-1,right);
        temp.deleteCharAt(temp.length()-1);
        temp.append(")");
        backtracking(result,temp,left,right-1);
        temp.deleteCharAt(temp.length()-1);

    }
}

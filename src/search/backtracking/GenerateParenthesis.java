package search.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String>generateParenthesis(int n){
        List<String> result = new ArrayList<>();
        if (n == 0)
            return result;
        StringBuilder sb = new StringBuilder();
        backtracking(result,sb,n,n);
        return result;
    }
    private void backtracking(List<String>result,StringBuilder sb,int left,int right){
        if (right < left)
            return;
        if (right < 0 || left < 0)
            return;
        if (left == 0 && right == 0){
            result.add(sb.toString());
            return;
        }
        sb.append('(');
        backtracking(result,sb,left-1,right);
        sb.deleteCharAt(sb.length()-1);

        sb.append(')');
        backtracking(result,sb,left,right-1);
        sb.deleteCharAt(sb.length()-1);
    }
}

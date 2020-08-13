package search.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public String[]permutation(String s){
        if (s == null || s.length() == 0)
            return new String[0];
        char[]chars = s.toCharArray();
        Arrays.sort(chars);
        boolean[]hasVisited = new boolean[chars.length];
        List<String>result = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        backtracking(result,stringBuilder,chars,hasVisited);
        int n = result.size();
        String[]strings = new String[n];
        for (int i = 0;i < n;i++){
            strings[i] = result.get(i);
        }
        return strings;
    }
    private void backtracking(List<String>result,StringBuilder stringBuilder,char[]chars,boolean[]hasVisited){
        if (stringBuilder.length() == chars.length){
            result.add(stringBuilder.toString());
            return;
        }
        for (int i = 0;i < chars.length;i++){
            if (i != 0 && chars[i] == chars[i-1] && !hasVisited[i-1])
                continue;
            if (hasVisited[i])
                continue;
            stringBuilder.append(chars[i]);
            hasVisited[i] = true;
            backtracking(result,stringBuilder,chars,hasVisited);
            hasVisited[i] = false;
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }
}

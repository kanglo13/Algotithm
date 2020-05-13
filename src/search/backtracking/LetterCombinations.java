package search.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> lettersCombinations(String digits){
        List<String>combinations = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return combinations;
        backtracking(new StringBuilder(),combinations,digits);
        return combinations;
    }
    private void backtracking(StringBuilder prefix,List<String>combinations,final String digits){
        if (prefix.length() == digits.length()){
            combinations.add(prefix.toString());
            return;
        }
        int curDigits = digits.charAt(prefix.length()) - '0';
        String letters = KEYS[curDigits];
        for (char c :letters.toCharArray()){
            prefix.append(c);
            backtracking(prefix,combinations,digits);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }
}

package search.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JudgePoint24 {
    public boolean judgePoint24(int[]nums){
        List<Double>numbers = new ArrayList<>();
        for (int num : nums)
            numbers.add((double)num);
        return backtracking(numbers);
    }
    private boolean backtracking(List<Double>numbers){
        if (numbers.size() == 1)
            return Math.abs(numbers.get(0) - 24) < 1e-6;
        for (int i = 0;i < numbers.size();i++){
            for (int j = 0;j < numbers.size();j++){
                if (i != j){
                    List<Double>nums = new ArrayList<>();
                    for (int k = 0;k < numbers.size();k++){
                        if (i != k && j != k){
                            nums.add(numbers.get(k));
                        }
                    }
                    Set<Double>doubles = calculate(numbers.get(i),numbers.get(j));
                    for (Double aDouble : doubles){
                        nums.add(aDouble);
                        if (backtracking(nums))
                            return true;
                        nums.remove(nums.size()-1);
                    }
                }
            }
        }
        return false;
    }
    private Set<Double>calculate(double a,double b){
        Set<Double> result = new HashSet<>();
        result.add(a+b);
        result.add(a-b);
        result.add(b-a);
        result.add(a*b);
        if (a != 0)
            result.add(b/a);
        if (b != 0)
            result.add(a / b);
        return result;
    }
}

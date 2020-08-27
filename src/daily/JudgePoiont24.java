package daily;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author kanglo
 * @create 2020-08-2020/8/22 7:33
 */
public class JudgePoiont24 {
    public boolean JudgePoiont24(int[]nums){
        List<Double>lis = new ArrayList<>();
        for (int num: nums)
            lis.add((double)num );
        return backtracking(lis);
    }
    private boolean backtracking(List<Double>numbers){
        if (numbers.size() == 1)
            return Math.abs(numbers.get(0)-24) < 1e-6;
        for (int i = 0;i < numbers.size();i++){
            for (int j = 0;j < numbers.size();j++){
                if (i != j){
                    List<Double>nums = new ArrayList<>();
                    for (int k = 0;k < numbers.size();k++){
                        if (k != i && k != j){
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
        Set<Double>set = new HashSet<>();
        set.add(a+b);
        set.add(a-b);
        set.add(a*b);
        set.add(b-a);
        if (a != 0)
            set.add(b/a);
        if (b != 0)
            set.add(a/b);
        return  set;
    }
}

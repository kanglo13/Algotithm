package daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kanglo
 * @create 2021-01-2021/1/14 10:03
 */
public class PrefixesDivBy5 {
    public List<Boolean> prefixesDivBy5(int[]A) {
        List<Boolean> result = new ArrayList<>();
        int num = 0;
        for (int j : A) {
            num <<= 1;
            num += j;
            num %= 10;
            result.add((num % 5 == 0));
        }
        return result;
    }
}

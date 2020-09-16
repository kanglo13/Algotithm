package interview;

/**
 * @author kanglo
 * @create 2020-09-2020/9/15 15:47
 */
public class Reverse {
    public int reverse(int x){
        int result = 0;
        while (x != 0){
            int rest = x % 10;
            int newResult = result*10 + rest;
            if ((newResult-rest)/10 != result)
                return 0;
            result = newResult;
            x /= 10;
        }
        return result;

    }
}

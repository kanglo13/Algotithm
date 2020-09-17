package interview;

/**
 * @author kanglo
 * @create 2020-09-2020/9/16 15:52
 */
public class IsPalindrome {
    public boolean isPalindrome(int x){
        if (x < 0)
            return false;
        int div = 1;
        while (x / div >= 10){
            div *= 10;
        }
        while (x > 0){
            int head = x / div;
            int tail = x % 10;
            if (head != tail)
                return false;
            x = (x%div)/10;
            div /= 100;
        }
        return true;

    }
}

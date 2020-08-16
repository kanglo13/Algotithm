package math;

public class IsPalindrome {
    public boolean isPalindrome(int x){
        if (x < 0)
            return false;
        int div = 1;
        while(x/div >= 10)
            div *= 10;
        while(x > 0){
            int left = x / div;
            int right = x % 10;
            if (left != right)
                return false;
            x = (x%div)/10;
            div /= 100;
        }
        return true;
    }
    public boolean isPalindromes(int x){
        if (x < 10)
            return false;
        int reverse = 0;
        int copy = x;
        while(copy > 0){
            int rest = copy % 10;
            reverse = reverse * 10 + rest;
            rest /= 10;
        }
        return reverse == x;
    }
}

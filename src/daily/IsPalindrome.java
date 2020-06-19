package daily;

public class IsPalindrome {
    public boolean isPalindrome(int x){
        if (x < 0)
            return false;
        int div = 1;
        while (x / div >= 10){
            div *= 10;
        }
        while (x > 0){
            int left = x / div;
            int right = x % 10;
            if (left != right)
                return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }
    public boolean isPalindrome(String s){
        if (s.isEmpty())
            return true;
        int left = 0,right = s.length() - 1;
        while (left < right){
            while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
                left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right)))
                right--;
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                return false;
            left++;
            right--;
        }
        return true;
    }
}

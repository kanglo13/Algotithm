package array;

import java.util.Arrays;

public class PlusOne {
    public int[]plusOne(int[]digits){
        int carry = 1;
        int n = digits.length;
        int[]result = new int[n+1];
        for (int i = n;i > 0;i--){
            int sum = digits[i-1] + carry;
            result[i] = sum % 10;
            carry = sum / 10;
        }
        if (carry == 1){
            result[0] = 1;
            return result;
        }
        else
            return Arrays.copyOfRange(result,1,n+1);
    }
}

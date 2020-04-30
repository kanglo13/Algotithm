package daily;

public class IsHappy {
    public boolean isHappy(int n){
        int fast = n, slow = n;
        do {
            slow = bitSquareSum(slow);
            fast = bitSquareSum(fast);
            fast = bitSquareSum(fast);
        }while (fast != slow);
        return slow == 1;
    }
    private int bitSquareSum(int n){
        int sum = 0;
        while (n > 0){
            int bit = n % 10;
            sum += bit * bit;
            n /= 10;
        }
        return sum;
    }
}

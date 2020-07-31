package array;

public class ProductExceptSelf {
    public int[] ProductExceptSelf(int[]nums){
        int n = nums.length;
        int[]productL = new int[n];
        int[]productR = new int[n];
        productL[0] = 1;
        productR[n-1] = 1;
        for (int i = 1;i < n;i++){
            productL[i] = productL[i-1] * nums[i-1];
            productR[n-1-i] = productR[n-i] * nums[n-i];
        }
        for (int i = 0;i < n;i++){
            productL[i] = productL[i] * productR[i];
        }
        return productL;
    }
}

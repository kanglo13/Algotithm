package binarySearch;

public class SplitArray {
    public int splitArray(int[]nums,int m){
        int max = 0, sum = 0;
        for (int num : nums){
            max = Math.max(num,max);
            sum += num;
        }
        int left = max, right = sum;
        while (left < right){
            int mid = (left + right) >>> 1;
            int splits = split(nums,mid);
            if (splits > m)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
    private int split(int[]nums,int maxIntervalSum){
        int splits = 1;
        int curSum = 0;
        for (int num : nums){
            if (curSum + num > maxIntervalSum){
                curSum = 0;
                splits++;
            }
            curSum += num;
        }
        return splits;
    }
}

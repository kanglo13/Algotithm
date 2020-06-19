package twoPointer;

import java.util.Map;

public class Trap {
    public int trap(int[]height){
        int n = height.length;
        int res = 0;
        for (int i = 0;i < n-1;i++){
            int lMax = 0,rMax = 0;
            for (int j = i;j < n-1;j++){
                rMax = Math.max(height[j],rMax);
            }
            for (int j = i;j >= 0;j--){
                lMax = Math.max(lMax,height[j]);
            }
            res += Math.min(lMax,rMax) -height[i];
        }
        return res;
    }
    public int trapI(int[]height){
        if (height == null)
            return 0;
        int n = height.length;
        int[]lMax = new int[n];
        int[]rMax = new int[n];
        int res = 0;
        lMax[0] = height[0];
        rMax[0] = height[n-1];
        for (int i = 1;i < n;i++)
            lMax[i] = Math.max(height[i],lMax[i-1]);
        for (int i = n-2;i >= 0;i--)
            rMax[i] = Math.max(height[i],rMax[i+1]);
        for (int i = 1;i < n-1;i++)
            res += Math.min(lMax[i],rMax[i]) - height[i];
        return res;
    }
    public int trapII(int[]height){
        if (height == null || height.length == 0)
            return 0;
        int n = height.length;
        int left = 0,right = n-1;
        int ans = 0;
        int lMax = height[0],rMax = height[n-1];
        while (left <= right){
            lMax = Math.max(lMax,height[left]);
            rMax = Math.max(rMax,height[right]);

            if (lMax < rMax){
                ans += lMax - height[left];
                left++;
            }
            else {
                ans += rMax - height[right];
                right--;
            }
        }
        return ans;
    }
}

package interview;

/**
 * @author kanglo
 * @create 2020-09-2020/9/16 16:19
 */
public class MaxAera {
    public int maxAera(int[]height){
        int left = 0,right = height.length-1;
        int result = 0;
        while (left < right){
            int area = (right-left) * Math.min(height[left],height[right]);
            result = Math.max(result,area);
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return result;
    }
}

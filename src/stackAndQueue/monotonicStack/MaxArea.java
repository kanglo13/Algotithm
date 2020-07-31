package stackAndQueue.monotonicStack;

public class MaxArea {
    public int maxArea(int[]height){
        int result = 0;
        int left = 0, right = height.length - 1;
        while (left < right){
            int area = (right - left) * Math.min(height[left],height[right]);
            result = Math.max(result,area);
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return result;
    }
}

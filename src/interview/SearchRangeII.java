package interview;

/**
 * @author kanglo
 * @create 2020-10-2020/10/18 15:19
 */
public class SearchRangeII {
        public int[]searchRange(int[]nums,int target){
            if (nums == null || nums.length == 0)
                return new int[]{-1,-1};
            int left = searchLeftBound(nums,target);
            if (left == nums.length|| nums[left] != target)
                return new int[]{-1,-1};
            int right = searchLeftBound(nums,target+1) - 1;
            return new int[]{left,right};
        }
        public int searchLeftBound(int[]nums,int target){
            int left = 0, right = nums.length-1;
            while (left <= right){
                int mid = (left + right) >>> 1;
                if(nums[mid] >= target)
                    right = mid - 1;
                else
                    left = mid + 1;

            }
            return  left;
    }
}

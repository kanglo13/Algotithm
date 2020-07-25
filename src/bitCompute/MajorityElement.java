package bitCompute;

public class MajorityElement {
    public int majorityElement(int[]nums){
        int major = nums[0];
        int cnt = 0;
        for (int i = 0;i < nums.length;i++){
            cnt = major == nums[i] ? cnt + 1 : cnt - 1;
            if (cnt == 0){
                major = nums[i];
                cnt = 1;
            }
        }
        cnt = 0;
        for (int num : nums){
            if (num == major)
                cnt++;
        }
        return cnt >= nums.length / 2 ? major : 0;
    }
}

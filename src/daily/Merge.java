package daily;

import java.util.Arrays;

/**
 * @author kanglo
 * @create 2021-04-2021/4/5 10:41
 */
public class Merge {
    public void merge(int[]nums1,int m,int[] nums2,int n){
        int index = m-- + n-- -1;
        while (m >= 0 && n >=0){
            nums1[index--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
        while (n-- >= 0)
            nums1[index--] = nums2[n--];
    }
}

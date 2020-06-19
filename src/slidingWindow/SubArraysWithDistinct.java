package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class SubArraysWithDistinct {
    public int subarraysWithKDistinct(int[] A, int K) {
        if(A == null || A.length == 0 || K > A.length || K<=0) {
            return 0;
        }
        int n = A.length;
        int ans = 0, start=0, end=0;
        Map<Integer, Integer> map = new HashMap<>();
        while(end < n) {
            map.put(A[end], map.getOrDefault(A[end], 0) + 1);
            if(map.size() > K) {
                //收缩左边界，直到 map.size()=K
                for(; start<=end; start++) {
                    map.put(A[start], map.get(A[start])-1);
                    if(map.get(A[start]) == 0) {
                        map.remove(A[start]);
                        start++;
                        break;
                    }
                }
            }
            if(map.size() == K) {
                //计算当前end下，有多少符合的子数组
                Map<Integer, Integer> temp = new HashMap<>(map);
                for(int i=start; i<=end; i++) {
                    ans++;
                    temp.put(A[i], temp.get(A[i])-1);
                    if(temp.get(A[i]) == 0) {
                        break;
                    }
                }
                //   System.out.println(start+"," + end + "," + ans);
            }
            end++;
        }
        return ans;
    }

}

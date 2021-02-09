package daily;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kanglo
 * @create 2021-02-2021/2/9 15:57
 */
public class SubarraysWithKDistinct {
    public int subarraysWithKDistinct(int[]A,int K){
        Window window1 = new Window();
        Window window2 = new Window();
        int result = 0,left = 0,right = 0;
        for (int i = 0;i < A.length;i++){
            window1.add(A[i]);
            window2.add(A[i]);
            while (window1.different() > K)
                window1.remove(A[left++]);
            while (window2.different() >= K)
                window2.remove(A[right++]);
            result += right - left;
        }
        return result;
    }
    static class Window{
        Map<Integer,Integer>count;
        int nonzero;
        Window(){
            count = new HashMap<>();
            nonzero = 0;
        }
        void add(int x){
            count.put(x,count.getOrDefault(x,0)+1);
            if (count.get(x) == 1)
                nonzero++;
        }
        void remove(int x){
            count.put(x,count.get(x)-1);
            if (count.get(x) == 0)
                nonzero--;
        }
        int different(){
            return nonzero;
        }

    }
}

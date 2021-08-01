package daily;

import java.util.Arrays;

/**
 * @author kanglo
 * @create 2021-08-2021/8/1 21:35
 */
public class KWeakestRows {
    public int[] kWeakestRows(int[][]mat,int k){
        int m = mat.length;
        int n = mat[0].length;
        int[]res = new int[m];
        for (int i = 0;i < m;i++){
            int l = 0, r = n - 1;

            while (l <= r){
                int mid = l + (r -l)/2;
                if (mat[i][mid] == 1){
                    l = mid + 1;
                }
                else {
                    r = mid - 1;
                }
            }
            res[i] = 100 * (l+1) + i;
        }
        Arrays.sort(res);
        int[]ans = new int[k];
        for (int i = 0;i < k;i++){
            ans[i] = res[i]%100;
        }
        return ans;
    }
}

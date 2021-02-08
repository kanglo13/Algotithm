package daily;

/**
 * @author kanglo
 * @create 2021-02-2021/2/8 11:29
 */
public class MaxTurbulenceSize {
    public int maxTurbulenceSize(int[]arr){
        int len = arr.length;
        int up = 1,down = 1;
        int result = 1;
        for (int i = 1;i < len;i++){
            if (arr[i] > arr[i-1]){
                up = down + 1;
                down = 1;
            }else if (arr[i] < arr[i-1]){
                down = up + 1;
                up = 1;
            }
            else {
                up = 1;
                down = 1;
            }
            result = Math.max(result,Math.max(up,down));
        }
        return result;
    }
}

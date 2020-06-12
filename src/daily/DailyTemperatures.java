package daily;

public class DailyTemperatures {
    public int[]dailyTemperatures(int[]T){
        int n = T.length;
        int []result = new int[n];
        for (int i = 0;i < n;i++){
            int current = T[i];
            if (current < 100){
                for (int j = i + 1;j < n;j++){
                    if (T[j] > current){
                        result[i] = j - i;
                        break;
                    }
                }
            }
        }
        return result;
    }
    public int[] dailyTemperaturesII(int[]T){
        int n = T.length;
        int[]result = new int[n];
        for (int i = n - 2;i >= 0;i--){
            for (int j = i + 1;j < n;j += result[j]){
                if (T[j] > T[i]){
                    result[i] = j - i;
                    break;
                }
                else if(result[j] == 0){
                    result[i] = 0;
                    break;
                }
            }
        }
        return result;
    }
}

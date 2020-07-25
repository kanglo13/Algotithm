package daily;

public class Divingboard {
    public int[] divingBoard(int shorter,int longer,int k){
        if (k == 0)
            return new int[0];
        int[]result = new int[k+1];
        if (shorter == longer)
            return new int[]{shorter * k};
        else {
            result[0] = shorter * k;
            for (int i = 1;i < result.length;i++){
                result[i] = result[i-1] + longer - shorter;
            }
        }
        return result;
    }
}

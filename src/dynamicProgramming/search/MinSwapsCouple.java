package dynamicProgramming.search;

public class MinSwapsCouple {
    public int minSwapsCouples(int[]row){
        int ans  = 0;
        int n = row.length;
        int[]index = new int[n];
        for (int i = 0;i < n;i++){
            index[row[i]] = i;
        }
        int next = 0;
        for (int i = 0;i < n; i += 2){
            next = (row[i] & 1) == 0 ? row[i] + 1 : row[i] - 1;
            if (next == row[i+1])
                continue;
            int swapIndex = index[next];
            index[row[i+1]] = swapIndex;
            row[swapIndex] = row[i+1];
            ans++;
        }
        return ans;
    }
}

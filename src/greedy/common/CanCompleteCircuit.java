package greedy.common;

import java.net.HttpURLConnection;

public class CanCompleteCircuit {
    public int canCompleteCircuit(int[]gas,int[]cost){
        int n = gas.length;
        for (int i = 0;i < n;i++){
            int j = i;
            int remain = gas[j];
            while (remain - cost[j] >= 0){
                remain = remain - cost[j] + gas[(j+1) %n];
                j = (j + 1) % n;
                if (j == i)
                    return i;
            }
        }
        return -1;
    }
}

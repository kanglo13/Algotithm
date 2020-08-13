package tree;

public class FindKthNumber {
    public int findKthNumber(int n,int k){
        int prefix = 1;
        int count = 1;
        while (count < k){
            int curCount = countNode(prefix,n);
            if(curCount + count > k){
                prefix *= 10;
                count++;
            }
            else {
                prefix++;
                count += curCount;
            }
        }
        return prefix;
    }
    private int countNode(int prefix,int n){
        int nextPrefix = prefix + 1;
        int count = 0;
        while(prefix <= n){
            count += Math.min(n+1,nextPrefix)-prefix;
            if (prefix <= n/10){
                prefix *= 10;
                nextPrefix *= 10;
            }
            else
                break;
        }
        return count;
    }
}

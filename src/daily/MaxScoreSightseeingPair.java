package daily;

public class MaxScoreSightseeingPair {
    public int maxScoreSightseeingPair(int[]A){
        int maxScore = Integer.MIN_VALUE;
        int maxNextScore = Integer.MIN_VALUE;
        for (int i = 1;i < A.length;i++){
            if (i > 0 && A[i] - i + maxNextScore > maxScore){
                maxScore = A[i] - i + maxNextScore;
            }
            if (A[i] + i > maxNextScore){
                maxNextScore = A[i] + i;
            }
        }
        return maxScore;
    }
}

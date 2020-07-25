package dynamicProgramming.search;

public class Jump {
        public int jump(int[]nums){
            int maxPosition = 0;
            int end = 0;
            int steps = 0;
            for (int i = 0;i < nums.length;i++){
                maxPosition = Math.max(maxPosition,nums[i]+i);
                if (i == end){
                    end = maxPosition;
                    steps++;
                }
            }
            return steps;
        }
}

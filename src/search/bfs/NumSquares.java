package search.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumSquares {
    public int numSquares(int n){
        List<Integer> squareList = generateSquares(n);
        Queue<Integer> queue = new LinkedList<>();
        boolean[]marked = new boolean[n+1];
        int level = 0;
        queue.add(n);
        while (!queue.isEmpty()){
            int size = queue.size();
            level++;
            while (size-- > 0){
                int cur = queue.poll();
                for (int square : squareList){
                    int next = cur -square;
                    if (next < 0)
                        continue;
                    if (next == 0)
                        return level;
                    if (marked[next])
                        continue;
                    marked[next] = true;
                    queue.add(next);
                }
            }

        }
        return -1;
    }
    private List<Integer>generateSquares(int n){
        int square = 1;
        int diff = 3;
        List<Integer>squareList = new ArrayList<>();
        while (square <= n){
            squareList.add(square);
            square +=  diff;
            diff += 2;
        }
        return squareList;
    }
}

package search.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LadderLengthII {
    public int ladderLength(String beginWord,String endWord,List<String>wordList){
        wordList.add(beginWord);
        int N = wordList.size();
        int start = N - 1;
        int end = 0;
        while (end < N && wordList.get(end) != endWord)
            end++;
        if (end == N)
            return 0;
        List<Integer>[]graphic = buildGraphic(wordList);
        return getShortestPath(graphic,start,end);

    }
    private List<Integer>[] buildGraphic(List<String>wordList){
        int n = wordList.size();
        List<Integer>[]graphic = new List[n];
        for (int i = 0;i < n;i++){
            graphic[i] = new ArrayList<>();
            for (int j = 0;j < n;j++){
                if (isConnected(wordList.get(i),wordList.get(j)))
                    graphic[i].add(j);
            }
        }
        return graphic;
    }
    private boolean isConnected(String s1,String s2){
        int diffCount = 0;
        for (int i = 0;i < s1.length();i++){
            if (s1.charAt(i) != s2.charAt(i))
                diffCount++;
        }
        return diffCount == 1;
    }
    public int getShortestPath(List<Integer>[]graphic,int start,int end){
        Queue<Integer>queue = new LinkedList<>();
        boolean[]marked = new boolean[graphic.length];
        queue.add(start);
        int path = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            path++;
            while (size-- > 0){
                int cur = queue.poll();
                for (int next : graphic[cur]){
                    if (next == end)
                        return path;
                    if (marked[next])
                        continue;
                    marked[next] = true;
                    queue.add(next);
                }
            }
        }
        return 0;
    }
}

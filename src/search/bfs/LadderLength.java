package search.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LadderLength {
    public int ladderLength(String beginWord, String endWord, List<String>wordList){
        wordList.add(beginWord);
        int N = wordList.size();
        int start = N - 1;
        int end = 0;
        while (end < N && !wordList.get(end).equals(endWord)){
            end++;
        }
        if (end == N)
            return 0;
        List<Integer>[]graphic = buildGraphic(wordList);
        return getShortestPath(graphic,start,end);
    }
    private boolean isConnected(String word1,String word2){
        int diffCnt = 0;
        for (int i = 0;i < word1.length() && diffCnt <= 1;i++){
            if (word1.charAt(i) != word2.charAt(i))
                diffCnt++;
        }
        return diffCnt == 1;
    }
    private List<Integer>[] buildGraphic(List<String> wordList){
        int N = wordList.size();
        List<Integer>[] graphic = new List[N];
        for (int i = 0;i < N;i++){
            graphic[i] = new ArrayList<>();
            for (int j = 0;j < N;j++){
                if (isConnected(wordList.get(i),wordList.get(j))){
                    graphic[i].add(j);
                }
            }
        }
        return graphic;
    }
    private int getShortestPath(List<Integer>[]graphic,int start,int end){
        Queue<Integer> queue = new LinkedList<>();
        boolean[]marked = new boolean[graphic.length];
        int pathLen = 0;
        queue.add(start);
        marked[start] = true;
        while (!queue.isEmpty()){
            int size = queue.size();
            pathLen++;
            while (size-- > 0){
                int cur = queue.poll();
                for (int next : graphic[cur]){
                    if (next == end)
                        return pathLen;
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

package search.bfs.ladder;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LadderLength {
    public int ladderLength(String beginWord, String endWord, List<String>wordList){
        wordList.add(beginWord);
        int n = wordList.size();
        int start = n - 1;
        int end = 0;
        while (end < n){
            if (!wordList.get(end).equals(endWord))
                end++;
        }
        if (end == n)
            return 0;
        List<Integer>[]graphic = buildGraphic(wordList);
        return bfs(graphic,start,end);
    }
    private int bfs(List<Integer>[]graphic,int start,int end){
        Queue<Integer>queue = new LinkedList<>();
        boolean[]marked = new boolean[graphic.length];

        queue.add(start);
        marked[start] = true;
        int path = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            path++;
            while (size-- > 0){
                int cur = queue.poll();
                for (int next :graphic[cur]){
                    if (next == end)
                        return path;
                    if (marked[next])
                        continue;
                    marked[next] = true;
                    queue.offer(next);
                }
            }
        }
        return 0;
    }
    private List<Integer>[] buildGraphic(List<String>wordList){
        List<Integer>[] graphic = new List[wordList.size()];
        for (int i = 0;i <wordList.size();i++){
            graphic[i] = new ArrayList<>();
            for (int j = 0;j < wordList.size();j++){
                if (isConnected(wordList.get(i),wordList.get(j))){
                    graphic[i].add(j);
                }
            }
        }
        return graphic;
    }
    private boolean isConnected(String s1,String s2){
        int i = 0, j = 0;
        int cnt = 0;
        while (i < s1.length() && j < s2.length()){
            if (s1.charAt(i) != s2.charAt(j)){
                cnt++;
                if (cnt > 1)
                    return false;
            }
            i++;
            j++;
        }
        return cnt == 1;
    }
}

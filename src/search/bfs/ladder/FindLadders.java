package search.bfs.ladder;

import java.util.*;

public class FindLadders {
    public List<List<String>>findLadders(String beginWord,String endWord,List<String>wordList){
        List<List<String>>result = new ArrayList<>();
        wordList.add(beginWord);
        int n = wordList.size();
        int start = n - 1;
        int end = 0;
        while (end < n && !wordList.get(end).equals(endWord))
            end++;
        if (end == n)
            return result;
        List<Integer>[]graph = buildGraph(wordList);
        return bfs(graph,wordList,start,end);
    }
    private List<List<String>>bfs(List<Integer>[]graph,List<String>wordList,int start,int end){
        int n = graph.length;
        int[]cost = new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        Queue<List<Integer>>queue = new LinkedList<>();
        List<Integer>path = new ArrayList<>();
        path.add(start);
        queue.add(path);
        cost[start] = 0;
        List<List<String>>result = new ArrayList<>();
        while (!queue.isEmpty()){
            path = queue.poll();
            int last = path.get(path.size()-1);
            if (last == end){
                List<String>temp = new ArrayList<>();
                for (int val : path)
                    temp.add(wordList.get(val));
                result.add(temp);
            }
            else {
                for (int next : graph[last]){
                    if (cost[last] + 1 <= cost[next]){
                        cost[next] = cost[last] + 1;
                        List<Integer>temp = new ArrayList<>(path);
                        temp.add(next);
                        queue.offer(temp);
                    }
                }
            }
        }
        return result;
    }
    private List<Integer>[]buildGraph(List<String>wordList){
        int n = wordList.size();
        List<Integer>[] graph = new List[n];
        for (int i = 0;i < n;i++){
            graph[i] = new ArrayList<>();
            for (int j = 0;j < n;j++){
                if (isConnected(wordList.get(i),wordList.get(j))){
                    graph[i].add(j);
                }
            }
        }
        return graph;
    }
    private boolean isConnected(String s1,String s2){
        int diffCnt = 0;
        for (int i = 0;i < s1.length() && diffCnt <= 1;i++)
            if (s1.charAt(i) != s2.charAt(i))
                diffCnt++;
        return diffCnt == 1;
    }
}

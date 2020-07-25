package search.bfs;

import java.util.*;

public class FindLadders {
    public List<List<String>>findLaddes(String beginWord,String endWord,List<String>wordList){
        List<List<String>>ladders = new ArrayList<>();
        List<String>ladderList = new ArrayList<>();
        wordList.add(beginWord);
        int N = wordList.size();
        boolean[]marked = new boolean[N];
        int start = N - 1;
        int end = 0;
        while (end < N && !wordList.get(end).equals(endWord))
            end++;
        if (end == N)
            return ladders;
        List<Integer>[] graphic = buildGraphic(wordList);
        return bfs(graphic,start,end,wordList);
    }
    private boolean isConnected(String s1,String s2){
        int diffCount = 0;
        for (int i = 0;i < s1.length();i++){
            if (s1.charAt(i) != s2.charAt(i))
                diffCount++;
        }
        return diffCount == 1;
    }
    private List<Integer>[] buildGraphic(List<String> wordList){
        int n = wordList.size();
        List<Integer>[] graphic = new List[n];
        for (int i = 0;i < n;i++){
            graphic[i] = new ArrayList<>();
            for (int j = 0;j < n;j++){
                if (isConnected(wordList.get(i),wordList.get(j)))
                    graphic[i].add(j);
            }
        }
        return graphic;
    }

    private List<List<String>>bfs(List<Integer>[]graphic,int start,int end,List<String>wordList){
        boolean[]marked = new boolean[graphic.length];
        Queue<List<Integer>>queue = new LinkedList<>();
        ArrayList<Integer>head = new ArrayList<>();
        head.add(start);
        queue.add(head);
        List<List<String>>ladders = new ArrayList<>();
        while (!queue.isEmpty()){
            List<Integer>cur = queue.poll();
            int last = cur.get(cur.size()-1);
            if (last == end){
                List<String>temp = new ArrayList<>();
                for (int index : cur){
                    temp.add(wordList.get(index));
                }
                ladders.add(temp);
            }
            else{
                List<Integer>nexts = graphic[last];
                for (int next : nexts){
                    if (marked[next])
                        continue;
                    ArrayList<Integer>temp = new ArrayList<>();
                    temp.add(next);
                    queue.add(temp);
                    marked[next] = true;
                }
            }
        }
        return ladders;
    }
}

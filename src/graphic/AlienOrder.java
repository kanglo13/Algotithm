package graphic;

import java.util.*;

public class AlienOrder {
    public String alienOrder(String[]words){
        Map<Character, Set<Character>> graphic = new HashMap<>();
        Queue<Character>queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        int[]indegrees = new int[26];
        Arrays.fill(indegrees,-1);
        int count = 0;
        for (String word :words){
            for (char c : word.toCharArray()){
                if (indegrees[c-'a'] == -1){
                    indegrees[c-'a'] = 0;
                    graphic.put(c,new HashSet<>());
                    count++;
                }
            }
        }
        for (int i = 0;i < words.length-1;i++){
            String cur = words[i],next = words[i+1];
            for (int j = 0;j < cur.length()&& j < next.length();j++){
                char a = cur.charAt(j),b = next.charAt(j);
                if (j != 0 && j == cur.length() - 1&& cur.length() > next.length())
                    return "";
                if (a != b){
                    if (!graphic.get(a).contains(b)){
                        indegrees[b-'a']++;
                        graphic.get(a).add(b);
                    }
                    break;
                }
            }
        }
        for (int i = 0;i < 26;i++){
            if (indegrees[i] == 0)
                queue.add((char)(i+'a'));
        }
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0){
                char cur = queue.poll();
                result.append(cur);
                for (char next : graphic.get(cur)){
                    if (--indegrees[next-'a'] == 0){
                        queue.add(next);
                    }
                }
            }
        }
        return result.length() == count ? result.toString() : "";
    }
}

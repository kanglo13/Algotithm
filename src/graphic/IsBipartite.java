package graphic;

import java.util.Arrays;

/*
先找到一个没被染色的节点u，把它染上一种颜色，之后遍历所有与它相连的节点v，如果节点v已被染色并且颜色和节点u一样，
那么就不是二分图。如果这个节点v没有被染色，先把它染成与节点u不同颜色的颜色，然后遍历所有与节点v相连的节点...如此递归下去。
 */
public class IsBipartite {
    public boolean isBipartite(int[][]graph){
        if (graph == null || graph.length == 0)
            return false;
        int[]colors = new int[graph.length];
        Arrays.fill(colors,-1);
        for (int i = 0;i < graph.length;i++){
            if (colors[i] == -1 && !isBipartite(i,0,colors,graph))
                return false;
        }
        return true;
    }
    private boolean isBipartite(int curNode,int curColor,int[]colors,int[][]graph){
        if (colors[curNode] != -1)
            return colors[curNode] == curColor;
        colors[curNode] = curColor;
        for(int nextNode : graph[curNode]){
            if (!isBipartite(nextNode,1-curColor,colors,graph))
                return false;
        }
        return true;
    }
}

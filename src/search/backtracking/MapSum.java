package search.backtracking;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

public class MapSum {
    private class Node{
        Node[]childs = new Node[26];
        int value;
    }
    private Node root = new Node();

    public MapSum(){

    }
    public void insert(String key,int val){
        insert(key,root,val);
    }
    private void insert(String key,Node node,int val){
        if (node == null)
            return;
        if (key.length() == 0){
            node.value = val;
            return;
        }
        int index = indexForChar(key.charAt(0));
        if (node.childs[index] == null){
            node.childs[index] = new Node();
        }
        insert(key.substring(1),node.childs[index],val);

    }
    public int sum(String prefix){
        return sum(prefix,root);
    }
    private int sum(String prefix,Node node){
        if (node == null)
            return 0;
        if (prefix.length() != 0){
            int index = indexForChar(prefix.charAt(0));
            return sum(prefix.substring(1),node.childs[index]);
        }
        int sum = node.value;
        for (Node child : node.childs){
            sum += sum(prefix,child);
        }
        return sum;
    }
    private int indexForChar(char ch){
        return ch - 'a';
    }
}

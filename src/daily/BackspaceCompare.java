package daily;

import java.util.Stack;

/**
 * @author kanglo
 * @create 2020-10-2020/10/19 9:34
 */
public class BackspaceCompare {
    public static void main(String[] args) {
        System.out.println(new BackspaceCompare().backsapceCompare("abc#c","ac#c"));
    }
    public boolean backsapceCompare(String S,String T){
        return back(S).equals(back(T));
    }
    private String back(String S){
       Stack<Character>stack = new Stack<>();
       for (char ch : S.toCharArray()){
           if (ch == '#'){
               if (!stack.isEmpty())
                   stack.pop();
               continue;
           }
           stack.push(ch);
       }
       StringBuilder sb = new StringBuilder();
       while (!stack.isEmpty())
           sb.append(stack.pop());
       return sb.toString();
    }
}

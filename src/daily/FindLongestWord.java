package daily;

import java.util.Collections;
import java.util.List;

/**
 * @author kanglo
 * @create 2021-09-2021/9/14 20:42
 */
public class FindLongestWord {
    public String findLongestWord(String s, List<String>dictionary){
        dictionary.sort((o1, o2) -> o2.length() == o1.length() ? o1.compareTo(o2) : o2.length() - o1.length());
        for (String str : dictionary){
            if (isSubSequence(s,str))
                return str;
        }
        return "";
    }
    private boolean isSubSequence(String s,String t){
        int index = -1;
        for (char ch : t.toCharArray()){
            index = s.indexOf(ch,index+1);
            if (index == -1)
                return false;
        }
        return true;
    }
}

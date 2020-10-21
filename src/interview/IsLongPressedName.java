package interview;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author kanglo
 * @create 2020-10-2020/10/21 11:34
 */
public class IsLongPressedName {
    public boolean isLongPressedName(String name,String typed){
       int len1 = name.length();
       int len2 = typed.length();
       if (len1 > len2)
           return false;
       int i = 0, j = 0;
       while (i < len1 && j < len2){
           if (name.charAt(i) == typed.charAt(j)){
               i++;
               j++;
           }
           else if (j != 0 && typed.charAt(j) == typed.charAt(j-1))
               j++;
           else
               return false;
       }
       while (j < len2){
           if (typed.charAt(j) != typed.charAt(j-1))
               return false;
           j++;
       }
       return i == len1 && j == len2;
    }
}

package daily;

/**
 * @author kanglo
 * @create 2020-10-2020/10/8 9:12
 */
public class ReverseString {
    public void reverseString(char[] s){
        char temp;
        int left = 0,right = s.length-1;
        while (left < right){
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            right--;
            left++;
        }
    }
}

package string;

public class Mutiply {
    public String mutiply(String num1,String num2){
        int m = num1.length(),n = num2.length();
        if (m == 0 || n == 0)
            return "";
        int[]res = new int[m+n];
        for (int i = m -1;i >= 0;i--){
            for (int j = n -1;j >= 0;j--){
                int result = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                result += res[i+j+1];
                res[i+j+1] = result % 10;
                res[i+j] = result / 10;
            }
        }
        int index = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (index < res.length-1 && res[index] == 0)
            index++;
        while (index < res.length)
            stringBuilder.append(index++);
        return stringBuilder.toString();
    }
}

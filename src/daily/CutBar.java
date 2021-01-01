package daily;

/**
 * @author kanglo
 * @create 2020-12-2020/12/24 11:03
 */
public class CutBar {
    public int cutBar(int m,int n){
        int cout = 0;
        int k = 1;
        while (k < n){
            cout++;
            k += Math.min(k,m);
        }
        return cout;
    }

    public static void main(String[] args) {
        CutBar cutBar = new CutBar();
        System.out.println(cutBar.cutBar(3,20) + " "+ cutBar.cutBar(5,100));
    }
}

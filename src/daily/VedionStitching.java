package daily;

/**
 * @author kanglo
 * @create 2020-10-2020/10/24 8:50
 */
public class VedionStitching {
    public int vedioStitching(int[][]clips,int T){
        int start = 0,end = 0,count = 0;
        while (start <= T){
            end = 0;
            for (int j = 0;j < clips.length;j++){
                if (clips[j][0] <= start){
                    end = Math.max(clips[j][1],end);
                }
            }
            count++;
            if (end >= T)
                return count;
            if (end == start)
                return  -1;
            start = end;
        }
        return -1;

    }
}

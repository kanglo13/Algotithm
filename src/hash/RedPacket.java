package hash;

import java.util.*;

/**
 * @author kanglo
 * @create 2020-10-2020/10/12 9:13
 */
public class RedPacket {
    public static void main(String[] args) {
        RedPacket redPacket = new RedPacket();
       // List<Integer>packets = redPacket.generaePackets(5,10);
        List<Integer>packets = redPacket.generatePacketsByLineCutting(10,5);
        for (int packet : packets){
            System.out.println(packet);
        }
    }
    public List<Integer> generaePackets(int people, int money) {
        List<Integer> packets = new ArrayList<>();
        Random random = new Random();
        while (people > 1) {
            int p = random.nextInt(2 * money / people);
            packets.add(p);
            money -= p;
            people--;
        }
        packets.add(money);
        return packets;
    }
    public List<Integer>generatePacketsByLineCutting(int money,int people){
        List<Integer>packets = new ArrayList<>();
        Random random = new Random();
        Set<Integer>set = new TreeSet<>();
        while (set.size() < people-1){
            set.add(random.nextInt(money-1));
        }
        set.add(money);
        int pre = 0;
        for (int point : set){
            packets.add(point-pre);
            pre = point;
        }
        return packets;

    }
}
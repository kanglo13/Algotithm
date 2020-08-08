package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindRepeatedDnaSequences {
    public List<String>findRepeatedDnaSequences(String s){
        Map<String,Integer>map = new HashMap<>();
        List<String>result = new ArrayList<>();
        for (int i = 0;i <= s.length()-10;i++){
            String key = s.substring(i,i+10);
            map.put(key,map.getOrDefault(key,0)+1);
        }
        for(Map.Entry<String,Integer>entry : map.entrySet()){
            if (entry.getValue() > 1)
                result.add(entry.getKey());
        }
        return result;
    }
}

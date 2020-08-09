package daily;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddress {
    public List<String>restoreIpAddress(String s){
        List<String>addresses = new ArrayList<>();
        StringBuilder tempAddress = new StringBuilder();
        bakctracking(addresses,tempAddress,0,s);
        return addresses;
    }
    private void bakctracking(List<String>addresses,StringBuilder tempAddress,int k,String s){
        if (k == 4 || s.length() == 0){
            if (k == 4 && s.length() == 0){
                addresses.add(tempAddress.toString());
            }
            return;
        }
        for (int i = 0;i < s.length() && i <= 2;i++){
            if (i != 0 && s.charAt(0) == 0)
                break;
            String part = s.substring(0,i+1);
            if (Integer.parseInt(part) <= 255){
                if (tempAddress.length() != 0)
                    part = "." + part;
                tempAddress.append(part);
                bakctracking(addresses,tempAddress,k+1,s.substring(i+1));
                tempAddress.delete(tempAddress.length()-part.length(),tempAddress.length());
            }
        }
    }
}

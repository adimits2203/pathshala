package recurssion;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    String s;

    List<String> ans = new ArrayList<>();



    public List<String> restoreIpAddresses(String str) {

        s = str;

        String news = "";

        getIPAddress(news,3,0);

        return ans;

    }

    private void getIPAddress(String str, int dots, int ix){

        if(ix==s.length()){

            if(dots==0){

                if(isIPAddressValid(str)) {

                    str = str.replaceAll(" ",".");

                    ans.add(str);

                }

                return;

            }

            return;

        }

        String news = str + s.charAt(ix);

        getIPAddress(news,dots,ix+1);

        if(dots > 0){

            news = str+" ";

            getIPAddress(news,dots-1,ix);

        }

    }



    private boolean isIPAddressValid(String str){

        String allInt[] = str.split(" ");

        for(int i=0; i<allInt.length; i++){

            if(allInt[i].equals("")) return false;

            long num = Long.parseLong(allInt[i]);

            if(num > 0L && allInt[i].charAt(0)=='0') return false;

            if(num == 0L && allInt[i].length()>1) return false;

            if(num >= 0L && num <= 255L) continue;

            else return false;

        }

        return true;

    }

}

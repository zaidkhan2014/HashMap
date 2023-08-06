package org.example;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public static int method(String str){
        int len=0;
        int pans;
        int ans=0;
        HashMap<Character,Integer> map1=new HashMap<>();
        for (int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            map1.put(ch, map1.getOrDefault(ch,0)+1);

        }
        HashMap<Character,Integer> map2=new HashMap<>();
        int count= map1.size();
        int i=-1;
        int j=-1;
        while(true){
            boolean f1=false;
            boolean f2=false;
            //acquire
            while(i<str.length()-1 && len<count){
                i++;
                char ch=str.charAt(i);
                if (map2.containsKey(ch)==false){
                    len++;
                }
                map2.put(ch,map2.getOrDefault(ch,0)+1);

                f1=true;
            }
            //collect and release
            while (j<i && len==count){
                pans=i-j;
                if (ans==0 || pans<ans) {
                    ans=pans;
                }
                j++;
                char ch=str.charAt(j);
                if (map2.get(ch)>1){
                    map2.put(ch,map2.get(ch)-1);
                }else{
                    map2.remove(ch);
                }
                if (map2.containsKey(ch)==false){
                    len--;
                }
                f2=true;

            }
            if (f1==false && f2==false){
                break;
            }

        }
        return ans;
    }
    public static void main(String[] args) {
        String s="aabcbcdjbca";
        System.out.println(method(s));
        //System.out.println("Hello world!");
    }
}
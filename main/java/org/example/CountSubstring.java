package org.example;

import java.util.HashMap;

public class CountSubstring {
    public static int countSubstring(String str){
        int answer=0;
        int i=-1;
        int j=-1;
        HashMap<Character,Integer> map=new HashMap<>();
        while(true){
            boolean f1=false;
            boolean f2=false;
            while(i<str.length()-1){
                f1=true;
                i++;
                char ch=str.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);
                if(map.get(ch)==2){
                    break;
                }else{
                    answer+=i-j;
                }

            }
            while(j<i){
                f2=true;
                j++;
                char ch =str.charAt(j);
               map.put(ch,map.get(ch)-1);
               if (map.get(ch)==1){
                   answer+=i-j;
                   break;
               }
            }
            if (f1==false && f2==false){
                break;
            }

        }
        return answer;
    }
    public static void main(String[] args) {
        String str="aabcbcdbca";
        System.out.println(countSubstring(str));
    }
}

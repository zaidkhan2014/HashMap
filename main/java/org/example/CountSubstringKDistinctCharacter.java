package org.example;

import java.util.HashMap;

public class CountSubstringKDistinctCharacter {
    public static int countSusbtringKDistinctCharacter(String s,int k){
        HashMap<Character,Integer> map=new HashMap<>();
        int i=-1;
        int j=-1;
        int ans=0;
        while(true){
            boolean b1=false;
            boolean b2=false;
            while (i<s.length()-1){
                b1=true;
                i++;
                char ch =s.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);
                if (map.size()>k){
                    map.remove(ch);
                    i--;
                    break;
                }else {
                    ans+=i-j;
                }
            }
            while(j<i){
                b2=true;
                j++;
                char ch=s.charAt(j);
                if (map.get(ch)==1){
                    map.remove(ch);
                }else{
                    map.put(ch,map.get(ch)-1);
                }
                if (map.size()<k){
                    break;
                }
            }
            if (b1==false && b2==false){
                break;
            }
        }
        return  ans;
    }
    public static void main(String[] args) {
            String str="aabcbcdbca";
            int k =2;
        System.out.println(countSusbtringKDistinctCharacter(str,k));
    }
}

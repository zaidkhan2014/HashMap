package org.example;

import java.util.HashMap;

public class LongestSubstringKCharacter {
    public static int longestSubstring(String str,int k){
        int ans=-1;
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
                if (map.size()==k){
                    int len=i-j;
                    ans=Math.max(ans,len);

                }
                if (map.size()>k){
                    break;
                }
            }
            while (j<i){
                f2=true;
                j++;
                char ch=str.charAt(j);
                if (map.get(ch)==1){
                    map.remove(ch);
                }else{
                    map.put(ch,map.get(ch)-1);
                }
                if (map.size()==k){
                    int len=i-j;
                    ans=Math.max(ans,len);
                    break;
                }
            }
            if (f1==false && f2==false){
                break;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        String str="aabcbcdbca";
        System.out.println(longestSubstring(str,2));
    }
}

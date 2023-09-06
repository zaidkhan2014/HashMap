package org.example;

import java.util.HashMap;

public class CountSubstringKCharacter {
    public static int countSubstringK(String str,int k){
        int ans=0;
        int ib=-1;
        int is=-1;
        int j=-1;
        HashMap<Character,Integer> bigmap=new HashMap<>();
        HashMap<Character,Integer> shortmap=new HashMap<>();
        while(true){
            boolean f1=false;
            boolean f2=false;
            boolean f3=false;
            while (ib<str.length()-1){
                f1=true;
                ib++;
                char ch=str.charAt(ib);
                bigmap.put(ch, bigmap.getOrDefault(ch,0)+1);
                if (bigmap.size()==k+1){
                    removeCharacter(bigmap,ch);
                    ib--;
                    break;
                }
            }
            while(is<ib ){
                f2=true;
                is++;
                char ch =str.charAt(is);
                shortmap.put(ch,shortmap.getOrDefault(ch,0)+1);
                if(shortmap.size()==k){
                    removeCharacter(shortmap,ch);
                    is--;
                    break;
                }
            }
            while(j<is){
                f3=true;
                if (shortmap.size()==k-1 && bigmap.size()==k){
                    ans+=ib-is;
                }
                j++;
                char ch=str.charAt(j);
                removeCharacter(shortmap,ch);
                removeCharacter(bigmap,ch);
                if (shortmap.size()<k-1 || bigmap.size()<k){
                    break;
                }
            }
            if (f1==false && f2==false && f3==false){
                break;
            }
        }

        return ans;
    }
    private static  void removeCharacter(HashMap<Character,Integer>map,char ch){
        if (map.get(ch)>1){
            map.put(ch,map.get(ch)-1);
        }else{
            map.remove(ch);
        }
    }
    public static void main(String[] args) {
        String str="aabcbcdbca";
        System.out.println(countSubstringK(str,2));

    }
}

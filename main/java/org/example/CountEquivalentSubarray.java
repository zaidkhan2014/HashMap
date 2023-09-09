package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CountEquivalentSubarray {
    public static int countEquivalentSubarray(int [] arr){
        int ans=0;
        int i=-1;
        int j=-1;
        Set<Integer> set=new HashSet<>();
        for(int k=0;k<arr.length;k++){
            set.add(arr[k]);
        }
        int characters=set.size();
        HashMap<Integer,Integer> map=new HashMap<>();
        while(true){
            boolean b1=false;
            boolean b2=false;
            while (i<arr.length-1){
                b1=true;
                i++;
                map.put(arr[i],map.getOrDefault(arr[i],0)+1);
                if (map.size()==characters){
                    ans+=arr.length-i;
                    break;
                }
            }
            while(j<i){
                b2=true;
                j++;
                if (map.get(arr[j])==1){
                    map.remove(arr[j]);
                }else {
                    map.put(arr[j],map.get(arr[j])-1);
                }
                if (map.size()==characters){
                    ans+=arr.length-i;
                }else {
                    break;
                }
            }
            if (b1==false && b2==false){
                break;
            }

        }
        return ans;
    }
    public static void main(String[] args) {
        int []arr={2,1,3,2,3};
        System.out.println(countEquivalentSubarray(arr));

    }
}

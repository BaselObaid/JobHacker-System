package com.JH;
import java.util.HashMap;

/*
 *@BaselObaid
 * in this method i use hashMap to take the value from array and make a key for each one
 * if the map contain a key (target-nums[i]), then get the value by this key and assign it in the array
 * then assign the key value in the same array
 */
public class Main {

    public static int[] twoSum(int[] nums, int target) {
        int size = nums.length;
        int [] array = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < size; i++){

            if(map.containsKey(target-nums[i])){
                array[0]= map.get(target-nums[i]);
                array[1]=i;
                return array;
            }
            map.put(nums[i],i);
        }
        return null;
    }
    public static void main(String[] args) {
	    int [] a = {2,3,6,7};
        int [] array = twoSum(a,9);
        for (int s : array){
            System.out.println(s);
        }
    }
}

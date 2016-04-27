// Given an array of size n, find the majority element. 
// The majority element is the element that appears more than ⌊ n/2 ⌋ times.
--BruteForce. time complexity O(n2), space O(1)
public class Solution {
    public int majorityElement(int[] num) {
        int i;
        int j;
        int n = num.length;
        
        for(i = 0;i<= n-2; i++)
        {
            int count = 0;
            for(j = 0; j<= n-2; j++)
            {
                if(num[i] == num[j])
                count++;
            }
             if(count > n/2)
             return num[i];
        }
        return -1;
    }
}
public class Solution {
    public int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        int num = nums[0];
        for(int i = 0; i < nums.length; i++) {
            if(num == nums[i]) {
                count++;
            }
            else {
                count--;
            }
            if(count == 0) {
                num = nums[i];
                count = 1;
            }
        }
        return num;
    }
}
--HashMap time complexity O(n), space O(n)
public class Solution {
    public int majorityElement(int[] num) {
        int n = num.length;
          HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
          for (int elem : num) {
              if (map.containsKey(elem)) {
                  map.put(elem, map.get(elem)+1);
              }
              else {
                 map.put(elem, 1);
             }
         }
         for (int item : map.keySet()) {
             if (map.get(item) > n/2) {
                 return item;
             }
        }
       return -1;
    }
}

--Hashtable

import java.util.Hashtable;
public class Solution {
    public int majorityElement(int[] num) {
        Hashtable<Integer, Integer> hashtable = new Hashtable<Integer, Integer>();
        if(num.length == 1)
            return num[0];
        int result = 0;
        for(int i = 0; i < num.length; i++)
            {
                if(!hashtable.containsKey(num[i]))
                    hashtable.put(num[i], 1);
                else {
                    hashtable.put(num[i], hashtable.get(num[i])+1);
                    if(hashtable.get(num[i]) > n/2)
                    result = num[i];
                }
            }
        return result;
    }
}




//second write, bug free, time complexity O(n), space O(n)
public class Solution{
  public int majorityElement(int[] nums){
    if(nums == null || nums.length == 0)
      return -1;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for(int i =0;i<nums.length;i++){
      if(map.containsKey(nums[i])){
        map.put(nums[i],map.get(nums[i])+1);
      }
      else{
        map.put(nums[i],1);
      }
    }
    for(int i =0;i<nums.length;i++){
      if(map.get(nums[i]) *2 > nums.length){
        return nums[i];
      }
    }
    return -1;
  }
}


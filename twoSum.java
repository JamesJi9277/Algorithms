//using HashMap can not import the jar, but using Hashtable should add import.java.util.Hashtable
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int length = numbers.length;
        if(length <2 || numbers == null)
        return null;
        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        for(int i = 0;i<=length -1;i++)
        // to check first, can grantee the index1 is less than index2
        {
            if(hashmap.containsKey(target - numbers[i]))
            {
                res[0] = hashmap.get(target - numbers[i])+1;
                res[1] = i +1;//这里不能够写成number[i]+1,因为不知道numberi是不是包含在里面，如果不包含的话，就在else语句中来操作了
                return res;
            }
            else
            hashmap.put(numbers[i],i);
        }
        return null;
    }
}

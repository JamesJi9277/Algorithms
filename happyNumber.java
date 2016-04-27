public class Solution {
    /**
     * @param n an integer
     * @return true if this is a happy number or false
     */
    public boolean isHappy(int n) {
        // Write your code here
        HashSet<Integer> set = new HashSet<Integer>();
        while(!set.contains(n)) {
        	set.add(n);
        	n = helper(n);
        	if(n == 1) {
        		return true;
        	}
        }
        return false;
    }
    private int helper(int num) {
        int res = 0;
        while(num != 0) {
            int digit = num % 10;
            res += digit * digit;
            num /= 10;
        }
        return res;
    }
}
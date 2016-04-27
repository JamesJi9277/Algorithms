Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.
有两个地方需要注意，一个是倒序的for循环，还有一个就是最后append的时候，
只有sb.length大于0或者nums【i】!= 0的时候，我才去append上去，不然append一长串0没有意义
public class Solution {
    public String multiply(String nums1, String nums2) {
        if(nums1 == null || nums2 == null) {
            return (nums1 == null) ? nums2 : nums1;
        }
        int length1 = nums1.length();
        int length2 = nums2.length();
        int[] nums = new int[length1 + length2];
        for(int i = length1 - 1; i >= 0; i--) {
            for(int j = length2 - 1; j >= 0; j--) {
                int temp = (nums1.charAt(i) - '0') * (nums2.charAt(j) - '0');
                nums[i + j] += (nums[i + j + 1] + temp) / 10;
                nums[i + j + 1] = (nums[i + j + 1] + temp) % 10;
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int i : nums) {
            if(sb.length() > 0 || i > 0) {
                sb.append(i);
            }
        }
        return (sb.length() == 0) ? "0" : sb.toString();
    }
}

public class Solution {
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null) {
            return num1 == null ? num2 : num1;
        }
        int length1 = num1.length();
        int length2 = num2.length();
        int[] nums = new int[length1 + length2];
        for(int i = length1 - 1; i >= 0; i--) {
            for(int j = length2 - 1; j >= 0; j--) {
                int temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                nums[i + j] += (nums[i + j + 1] + temp) / 10;
                nums[i + j + 1] = (nums[i + j + 1] + temp) % 10;
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < nums.length; i++) {
            if(sb.length() > 0 || nums[i] > 0) {
                sb.append(nums[i]);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
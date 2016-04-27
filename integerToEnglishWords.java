Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

For example,
123 -> "One Hundred Twenty Three"
12345 -> "Twelve Thousand Three Hundred Forty Five"
1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"

public class Solution {
    public String numberToWords(int num) {
        StringBuffer res = new StringBuffer();
        String[] ones = {"Zero", "One", "Two", "Three", "Four", "Five", "Six","Seven","Eight","Nine"};
        String[] tens = {"Zero","Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty","Seventy","Eighty","Ninety"};
        String[] teens = {"Ten","Eleven", "Twelve", "Thirteen", "Fourteen","Fifteen", "Sixteen","Seventeen","Eighteen","Nineteen"};
        int i = 0;
        if(num == 0) {
        	return "Zero";
        }
        while(num > 0) {
        	int cur = num % 1000;
        	num /= 1000;
        	if(i == 1 && cur > 0) {
        		res.insert(0, "Thousand ");
        	}
        	if(i == 2 && cur > 0) {
        		res.insert(0, "Million ");
        	}
        	if(i == 3 && cur > 0) {
        		res.insert(0, "Billion ");
        	}
        	int o = cur % 10;
        	cur /= 10;//ones
        	int t = cur % 10;
        	cur /= 10;//tens
        	int h = cur % 10;
        	if(t == 1) {//handle evelen, twelve
        		res.insert(0, teens[o] + " ");
        	}
        	else {
        		if(o > 0) {
        			res.insert(0, ones[o] + " ");
        		}
        		if(t > 0) {
        			res.insert(0, tens[t] + " ");
        		}
        	}
        	if(h > 0) {
        		res.insert(0, ones[h] + " Hundred ");
        	}
        	i++;
        }
        return res.toString().trim();
    }
}
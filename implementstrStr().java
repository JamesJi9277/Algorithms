// Implement strStr().

// Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
//时间复杂度O(mn), 空间复杂度O(1)
public class Solution{
	public int strStr(String haystack, String needle){
		if(haystack == null || haystack.length() == 0|| needle == null || needle.length()==0)
			return -1;
		if(haystack == null&&needle == null)
			return 0;
		if(needle.length() > haystack.length())
			return -1;
		for(int i =0; i<= haystack.length() - needle.length(); i++)
		{
			boolean flag = true;
			for(int j =0; j< needle.length(); j++)
			{
				if(haystack.charAt(i+j) != needle.charAt(j)){
					flag = false;
					break;
				}
			}
			if(flag)
				return i;
		}
		return -1;
	}
}
//Java API来做
public class Solution{
	public int strStr(String haystack, String needle){
		if(haystack == null || needle == null)
			return -1;
		else if(haystack.length() == 0 && needle.length()!=0)
			return -1;
		else if(haystack.length() != 0 && needle.length() ==0)
			return 0;
		else if(haystack.length() ==0 && haystack.length() == 0)
			return 0;
		if(haystack.contains(needle))
			return haystack.indexOf(needle);
		else
			return -1;
	}
}
//second write,ac but not bug free
public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null){
			return -1;
		}
        int i = 0;
        for(i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int j = 0;
            for(j = 0; j < needle.length(); j++) {
                if(haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if(j == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}
//second write using API,bug free
public class Solution{
	public int strStr(String haystack, String needle){
		if(haystack == null || needle == null)
			return -1;
		if(haystack.contains(needle))
			return haystack.indexOf(needle);
		else
			return -1;
	}
}




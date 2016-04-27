//Implement atoi to convert a string to an integer.
//先对string进行trim处理，然后在设立一个boolean来判断是不是带有正负号
public class Solution {
    public int myAtoi(String str) {
        if(str == null||str.length() ==0)
        	return 0;
        str = str.trim();
        boolean isNeg = false;
        int i = 0;
        if(str.charAt(0) == '-' || str.charAt(0) == '+')
        {
        	i++;
        	if(str.charAt(0) == '-')
        		isNeg = true;
        }
        int res = 0;
        while(i<str.length())
        {
        	if(str.charAt(i) < '0' || str.charAt(i) >'9')
        		break;
        	int digit = (int)(str.charAt(i) - '0');
        	if(isNeg && res> -((Integer.MIN_VALUE + digit)/10))
        		return Integer.MIN_VALUE;
        	if(!isNeg&&res>(Integer.MAX_VALUE-digit)/10)
        		return Integer.MAX_VALUE;
        	res = res*10 +digit;
        	i++;
        }
        return isNeg?-res:res;
    }
}
i// Given two integers representing the numerator and denominator of a fraction,
// return the fraction in string format.

// If the fractional part is repeating, enclose the repeating part in parentheses.

// For example,

// Given numerator = 1, denominator = 2, return "0.5".
// Given numerator = 2, denominator = 1, return "2".
// Given numerator = 2, denominator = 3, return "0.(6)".
//用一个哈希表存储：key = 余数， value = 当前数位在小数得数中的位置。
//一旦找到重复的余数，就可以通过查找哈希表获得循环节的起点，从而得到小数的循环节。
//执行除法的过程中，余数可能变为0。此时说明小数是有限小数，可以立即返回得数
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(denominator == 0) {
            return String.valueOf(Integer.MAX_VALUE);
        }
        if(numerator == 0 || denominator == 1) {
            return String.valueOf(numerator);
        }
        boolean isNeg = false;
        if((numerator < 0) ^ (denominator < 0) == true) {
            isNeg = true;
        }
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        long q = num / den;
        long rem = num % den;
        StringBuffer sb = new StringBuffer();
        if(isNeg == true) {
            sb.append("-");
        }
        sb.append(q + "");
        if(rem == 0) {
            return sb.toString();
        }
        sb.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        while(rem != 0) {
            if(map.containsKey(rem)) {
                int index = map.get(rem);
                sb.insert(index, '(');
                sb.append(')');
                break;
            }
            else {
                sb.append(rem * 10 / den);
                map.put(rem, sb.length() - 1);
            }
            rem = rem * 10 % den;
        }
        return sb.toString();
    }
}

public class Solution {
	public String fractionToDecimal(int numerator, int denominator) {
		if(denominator == 0) {
			return new String();
		}
		if(numerator == 0) {
			return String.valueOf(0);
		}
		//如果两个数符号不同，那么结果为负数
		String sign = ((numerator < 0) ^ (denominator < 0) == true) ? "-" : "";
		//先把除数和被除数转换成long， 避免了-Integer.MIN_VALUE 除以 -1 的时候所产生的溢出
		//这里一定要先进行转换后，再求绝对值
		long num = numerator;
		long den = denominator;
		num = Math.abs(num);
		den = Math.abs(den);
		long major = num / den;
		long rem = num % den;
		if(rem == 0) {
			return sign + major;
		}
		StringBuffer sb = new StringBuffer(sign + major + '.');
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		while(rem != 0) {
			//如果余数已经出现过了一次，那么循环要开始了，直接人为加上 ()
			if(map.containsKey(rem)) {
				int index = map.get(rem);
				sb.insert(index, '(');
				sb.append(')');
				//已经找到了循环小数，就可以直接break
				break;
			}
			else {
				sb.append(rem * 10 / den);
				map.put(rem, sb.length() - 1);
			}
			rem = rem * 10 % den;
		}
		return sb.toString();
	}
}

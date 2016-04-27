// 这道题和Integer to Roman一样，也是整数和罗马数字的转换。
// 思路也比较简单，就是维护一个整数，然后如果1下一个字符是对应位的5或者10则减对应位的1，否则加之。
// 遇到5或者10就直接加上对应位的5或者10。时间复杂度是O(字符串的长度)，空间复杂度是O(1)。
// I ->1
// V ->5
// X ->10
// L ->50
// C ->100
// D ->500
// M ->1000
// 1、基本数字Ⅰ、X 、C 中的任何一个，自身连用构成数目，或者放在大数的右边连用构成数目，都不能超过三个；
//    放在大数的左边只能用一个。
// 2、不能把基本数字V 、L 、D 中的任何一个作为小数放在大数的左边采用相减的方法构成数目；
//    放在大数的右边采用相加的方式构成数目，只能使用一个。
// 3、V 和X 左边的小数字只能用Ⅰ。
// 4、L 和C 左边的小数字只能用X。
// 5、D 和M 左边的小数字只能用C。
public class Solution1{
	public int romanToInt(String s){
		if(s == null || s.length() == 0)
			return 0;
		int res = 0;
		for(int i =0; i < s.length(); i++)
		{
			switch(s.charAt(i))
			{
				case 'I':
				//I搭配作为减一的情况出现是IV或者IX
				if(i < s.length()-1 && (s.charAt(i +1)=='V'|| s.charAt(i+1) == 'X'))
					res -= 1;
				else res += 1;
				break;
				case 'V':
				res += 5;
				break;
				case 'X':
				//X搭配作为减10的情况出现是XL与XC
				if(i < s.length()-1 && (s.charAt(i +1) == 'L'||s.charAt(i+1) == 'C'))
					res -= 10;
				else
					res += 10;
				break;
				case 'L':
				res += 50;
				break;
				case 'C':
				//C搭配作为减100出现的情况是CD与CM
				if(i < s.length()-1 && (s.charAt(i+1) == 'D'|| s.charAt(i+1)=='M'))
					res -= 100;
				else
					res += 100;
				break;
				case 'D':
				res += 500;
				break;
				case 'M':
				res += 1000;
				break;
				default:
				return 0;
			}
		}
		return res;
	}
}

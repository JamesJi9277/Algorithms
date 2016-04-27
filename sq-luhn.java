luhn算法，也成为模10算法，是一种简单的校验和算法，一般用于验证身份识别码。
不是一种安全的加密哈希函数，设计的目的只是防止意外出错而不是恶意攻击
public class luhn {
	public int getLuhn(int x) {
		int res = 0;
		String s = String.valueOf(x);
		for(int i = s.length() - 1; i >= 0; i -= 2) {
			res += getNum(s.charAt(i) - '0');
		}
		return 10 - res % 10;
	}
	private int getNum(int x) {
		long num = (long)2 * x;
		int res = 0;
		while(num != 0) {
			long digit = num % 10;
			res += (int)digit;
			num /= 10;
		}
		return res;
	}
}
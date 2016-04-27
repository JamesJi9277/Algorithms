首先可以直接变为string来做
public class reverse {
	public String reverse(double nums) {
		String res = nums + "";
		StringBuffer sb = new StringBuffer();
		for(int i = nums.length() - 1; i >= 0; i--) {
			sb.append(res.charAt(i));
		}
		return sb.toString();
	}
}
public class reverse {
	public String reverse(double nums) {
		boolean isNeg = false;
		if(nums < 0) {
			isNeg = true;
		}
		if(nums == 0) {
			return String.valueOf(0);
		}
		nums = Math.abs(nums);
		String s = nums + "";
		String[] res = s.split("\\.");
		int m = doReverse(Integer.valueOf(res[0]));
		int n = doReverse(Integer.valueOf(res[1]));
		StringBuffer sb = new StringBuffer();
		if(isNeg) {
			sb.append("-");
		}
		sb.append(n + "");
		sb.append(".");
		sb.append(m + "");
		return sb.toString();
	}
	private int doReverse(int num) {
		int res = 0;
		while(num > 0) {
			int digit = num % 10;
			res = res * 10 + digit;
			num /= 10;
		}
		return res;
	}
	public static void main(String[] args) {
		reverse r = new reverse();
		double m = 31.456;
		System.out.println(r.reverse(m));
	}
}






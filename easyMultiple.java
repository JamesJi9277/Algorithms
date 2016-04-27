public class easyMultiple {
	public int doMultiple(int a, int b) {
		if(b == 1) {
			return a;
		}
		if((b & 1) == 1) {
			return doMultiple(a << 1, b >> 1) + a;
		}
		return doMultiple(a << 1, b >> 1);
	}
	public static void main(String args[]) {
		easyMultiple mul = new easyMultiple();
		System.out.println(mul.doMultiple(3, 3));
	}
}

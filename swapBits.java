
public class swapBits {
	public static void main(String[] args) {
		int a = 128 + 16 + 8 + 2 + 1;
		System.out.println(Integer.toBinaryString(a));
		int res = ((a >>1) & 01010101) | ((a << 1) & 10101010);
		//a >> 1将所有奇数位移动到偶数位（假设从0开始），然后&01010101是将所有移动后的偶数位全部留下
		//同理， (a << 1) & 10101010是将偶数位移动到奇数位后再留下，最后将两个不同位的并起来即使最后解
		System.out.println(Integer.toBinaryString(res));
	}
}

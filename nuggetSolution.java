// 麦当劳有6个，9个或者20个包装的chicken nuggests, 让我写code测试一个整数能否正好用这些包装装起来。。。
// 比如（109可以用20个*5盒+9)比如（22就不行), 其实这道题很简单，
// 但是楼主傻逼的想起了一道DP的题（这两题根本没关系，楼主串题了），
// 于是先用DP的方法解了，然后那个面试官一下子蒙了。安慰楼主说方法很好，
// 但是能不能不用extra space。楼主突然想到了用CC上硬币的方法，于是开始写，刚一写for loop
// ，然后就被面试官叫停，他说不要for loop,然后在他的引导下写出了最优解
public class nuggests {
	public boolean canFit(int n) {
		if(n < 6) {
			return false;
		}
		if(n % 6 == 0 || n % 9 == 0 || n % 20 == 0) {
			return true;
		}
		while(n >= 20) {
			n -= 20;
		}
		while(n >= 9) {
			n -= 9;
		}
		while(n >= 6) {
			n -= 6;
		}
		return n == 0;
	}
	public static void main(String[] args) {
		nuggests n = new nuggests();
		System.out.println(n.canFit(100));
		System.out.println(n.canFit(109));
		System.out.println(n.canFit(20));
		System.out.println(n.canFit(110));
	}
}
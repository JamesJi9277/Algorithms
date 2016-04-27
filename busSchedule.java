// 一个bus station里面有很多terminal，每一个terminal在同一时间只能够停一辆bus，输入一组bus schedule
// 让你判断至少要多少个terminal
// 比如[1,2],[3,5], [4,5],[6,8]代表进站时间，这里[3,5]和[4,5]overlap了，所以最少就需要两个terminal
import java.util.ArrayList;

public class busSchedule {
	public int schedule(ArrayList<ArrayList<Integer>> timeTable) {
		if(timeTable == null || timeTable.size() == 0) {
			return 0;
		}
		int max = 0;
		int count = 1;
		for(int i = 0; i < timeTable.size(); i++) {
			for(int j = 0; j < timeTable.get(i).size(); j++) {
				max = Math.max(max, timeTable.get(i).get(j));
			}
		}
		int[] isOccupied = new int[max + 1];
		for(int i = 0; i < isOccupied.length; i++) {
			isOccupied[i] = 0;
		}
		for(int i = 0; i < timeTable.size(); i++) {
			for(int k = timeTable.get(i).get(0); k <= timeTable.get(i).get(1); k++) {
				isOccupied[k]++;
			}
		}
		for(int i = 0; i < isOccupied.length; i++) {
			count = Math.max(count, isOccupied[i]);
			System.out.print(isOccupied[i] + " ");
		}
		System.out.println(" ");
		return count;
	}
	public static void main(String[] args) {
		busSchedule bs = new busSchedule();
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		ArrayList<Integer> c = new ArrayList<Integer>();
		ArrayList<Integer> d = new ArrayList<Integer>();
		ArrayList<Integer> e = new ArrayList<Integer>();
		ArrayList<Integer> f = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		a.add(1);a.add(2);
		b.add(3);b.add(5);
		c.add(4);c.add(5);
		d.add(6); d.add(8);
		e.add(6);e.add(7);
		f.add(3);f.add(5);
		res.add(a);res.add(b);res.add(c);res.add(d);res.add(e);res.add(f);
		System.out.println("The result is: " + bs.schedule(res));
		
	}
}
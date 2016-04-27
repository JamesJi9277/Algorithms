卖车票，n个车票窗口，每个窗口里有a_i张票，票价和窗口内剩的票数一样。
需要卖掉m张票。问卖m张票得到的最多的总钱数（max profit）
import java.util.Comparator;
import java.util.PriorityQueue;

public class ticket {
	public int maxProfit(int[] tickets, int m) {
		if(tickets == null || tickets.length == 0) {
			return 0;
		}
		if(tickets.length == 1 && tickets[0] > m) {
			return (tickets[0] + tickets[0] - m + 1) * m / 2;
		}
		Comp cmp = new Comp();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(tickets.length, cmp);
		for(int i = 0; i < tickets.length; i++) {
			maxHeap.offer(tickets[i]);
		}
		int maxProfit = 0;
		while(m-- > 0) {
			int temp = maxHeap.poll();
			maxProfit += temp;
			maxHeap.offer(temp - 1);
		}
		return maxProfit;
	}
	class Comp implements Comparator<Integer> {
		public int compare(Integer o1, Integer o2) {
			return (o2 - o1);
		}
	}
	public static void main(String[] args) {
		int[] tickets = {5};
		int m = 2;
		ticket t = new ticket();
		System.out.println(t.maxProfit(tickets, m));
	}
}


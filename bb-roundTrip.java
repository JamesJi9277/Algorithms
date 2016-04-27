class ticket {
	int start;
	int end;
	ticket(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class round {
	public void sort(ticket[] tickets) {
		int origin = Integer.MAX_VALUE;
		int des = Integer.MIN_VALUE;
		for(int i = 0; i < tickets.length; i++) {
			origin = Math.min(origin, tickets[i].start);
		}
		for(int i = 0; i < tickets.length; i++) {
			des = Math.max(des, tickets[i].end);
		}
		
	}
}
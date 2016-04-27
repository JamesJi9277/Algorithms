class Interval {
	int start;
	int end;
	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
public class Solution {
	private class Comp implements Comparator<Interval> {
		public int compare(Interval o1, Interval o2) {
			if(o1.start > o2.start) {
				return 1;
			}

			else if(o1.start < o2.start) {
				return -1;
			}

			else {
				return o1.end - o2.end;
			}
		}
	}
	public int getNum(ArrayList<Interval> intervals) {
		if(intervals == null || intervals.size() == 0) {
			return 0;
		}
		int length = Integer.MIN_VALUE;
		for(int i = 0; i < intervals.size(); i++) {
			length = Math.max(length, intervals[i].start);
            length = Math.max(length, intervals[i].end);
		}
		int[] res = new int[length + 1];
		int[] res1 = new int[length + 1];
		for(Interval interval : intervals) {
			for(int i = interval.start; i <= interval.end; i++) {
				res[i]++;
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < length; i++) {
			max = Math.max(max, res[i]);
		}
		return max;
	}
}

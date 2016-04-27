/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
	public class Comp implements Comparator<Interval> {
		public int compare(Interval e1, Interval e2) {
			if(e1.start > e2.start) {
				return 1;
			}
			else if(e1.start < e2.start) {
				return -1;
			}
			else {
				return e1.end - e2.end;
			}
		}
	}
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        Comp cmp = new Comp();
        if(intervals == null || intervals.size() == 0) {
        	return res;
        }
        if(intervals.size() == 1) {
        	return intervals;
        }
        Collections.sort(intervals, cmp);
        res.add(intervals.get(0));
        for(int i = 1; i < intervals.size(); i++) {
        	Interval temp = intervals.get(i);
        	if(temp.start > res.get(res.size() - 1).end) {
        		res.add(temp);
        	}
        	else {
        		res.get(res.size() - 1).end = Math.max(res.get(res.size() - 1).end, temp.end);
        	}
        }
        return res;
    }
}
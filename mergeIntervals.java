//time O(nlogn+n) = O(nlogn), space O(n)
//首先要使得intervals有序，这样子的话就可以直接建立一个res，逐个将interval的元素与res最后一个元素来进行对比，比较结尾和开头的关系，如果结尾小于开头，那么直接添加，如果结尾大于开头，那么就选取结尾大的作为新的结尾
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0) {
            return res;
        }
        IntervalComp cmp = new IntervalComp();
        Collections.sort(intervals, cmp);
        res.add(intervals.get(0));
        for(int i = 1; i < intervals.size(); i++) {
            if(res.get(res.size() - 1).end >= intervals.get(i).start) {
                res.get(res.size() - 1).end = Math.max(res.get(res.size() - 1).end, intervals.get(i).end);
            }
            else {
                res.add(intervals.get(i));
            }
        }
        return res;
    }
    private class IntervalComp implements Comparator<Interval> {
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
}
/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals: Sorted interval list.
     * @return: A new sorted interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        List<Interval> res = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0) {
        	return res;
        }
        IntervalComp cmp = new IntervalComp();
        Collections.sort(intervals, cmp);
        res.add(intervals.get(0));
        for(int i = 1; i < intervals.size(); i++) {
        	if(res.get(res.size() - 1).end >= intervals.get(i).start) {
        		res.get(res.size() - 1).end = Math.max(res.get(res.size() - 1).end, intervals.get(i).end);
        	}
        	else {
        		res.add(intervals.get(i));
        	}
        }
        return res;
    }
    private class IntervalComp implements Comparator<Interval> {
    	public int compare(Interval o1, Interval o2) {
    		if(o1.start - o2.start > 0) {
    			return 1;
    		}
    		else if(o1.start - o2.start < 0) {
    			return -1;
    		}
    		else {
    			return o1.end - o2.end;
    		}
    	}
    }
}
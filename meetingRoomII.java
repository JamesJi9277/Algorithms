Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.

应该按照结束时间来排序，有可能先结束的再后面的任务可以接上去，这样就会使得总的时间减少

时间On2，空间On
public class Solution {
	public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) {
            return 0;
        }
        int length = Integer.MIN_VALUE;
        for(int i = 0; i < intervals.length; i++) {
            length = Math.max(length, intervals[i].start);
            length = Math.max(length, intervals[i].end);
        }
        int[] res = new int[length + 1];
        for(Interval interval : intervals) {
            for(int i = interval.start; i < interval.end; i++) {
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
On2时间
public class Solution {
	private class Comp implements Comparator<Interval> {
		public int compare(Interval o1, Interval o2) {
			return o1.end - o2.end;
		}
	}
	public int minMeetingRooms(Interval[] intervals) {
		if(intervals == null || intervals.length == 0) {
			return 0;
		}
		int max = 1;
		Comp cmp = new Comp();
		Arrays.sort(intervals, cmp);
		for(int i = 0; i < intervals.length; i++) {
			int count = 1;
			for(int j = i + 1; j < intervals.length; j++) {
				if(intervals[j].start < intervals[i].end) {
					count++;
				}
			}
			max = Math.max(max, count);
		}
		return max;
	}
}
时间Onlogn，空间On
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
    private class Comp1 implements Comparator<Interval> {
    	public int compare(Interval o1, Interval o2) {
    		return o1.end - o2.end;
    	}
    }
    public int minMeetingRooms(Interval[] intervals) {
    	if(intervals == null || intervals.length == 0) {
    		return 0;
    	}
    	Comp cmp = new Comp();
    	Comp1 cmp1 = new Comp1();
    	Arrays.sort(intervals, cmp);
    	PriorityQueue<Interval> heap = new PriorityQueue<Interval>(cmp1);
    	heap.offer(intervals[0]);
    	for(int i = 1; i < intervals.length; i++) {
    		Interval temp = heap.peek();
    		if(temp.end <= intervals[i].start) {
    		    heap.poll();
    			heap.offer(intervals[i]);
    		}
    		else if(temp.end > intervals[i].start) {
    			heap.offer(intervals[i]);
    		}
    	}
    	return heap.size();
    }
}

时间Onlogn，空间On
public class Solution {
	public int minMeetingRooms(Interval[] intervals) {
		if(intervals == null || intervals.length == 0) {
			return 0;
		}
		int[] starts = new int[intervals.length];
		int[] ends = new int[intervals.length];
		for(int i = 0; i < intervals.length; i++) {
			starts[i] = intervals[i].start;
			ends[i] = intervals[i].end;
		}
		Arrays.sort(starts);
		Arrays.sort(ends);
		int rooms = 0;
		int endsItr = 0;
		for(int i = 0; i < starts.length; i++) {
			if(starts[i] < ends[endsItr]) {
				rooms++;
			}
			else {
				endsItr++;
			}
		}
		return rooms;
	}
}

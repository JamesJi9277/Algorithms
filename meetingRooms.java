Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return false.

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
时间复杂度Onlogn，空间复杂度O1
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) {
        	return true;
        }
        IntervalCom cmp = new IntervalCom();
        Arrays.sort(intervals, cmp);
        for(int i = 0; i < intervals.length - 1; i++) {
        	if(intervals[i].end > intervals[i + 1].start) {
        		return false;
        	}
        }
        return true;
    }
    private class IntervalCom implements Comparator<Interval> {
        public int compare(Interval o1, Interval o2) {
            if(o1.start > o2.start) {
                return 1;
            }
            else if(o1.start < o2.start) {
                return -1;
            }
            else {
                return 0;
            }
        }
    }
}


时间复杂度On2，空间复杂度On
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
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) {
            return true;
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < intervals.length; i++) {
            max = Math.max(max, intervals[i].end);
        }
        int[] bit = new int[max + 1];
        for(int i = 0; i < intervals.length; i++) {
            for(int j = intervals[i].start; j < intervals[i].end; j++) {
                if(bit[j] != 0) {
                    return false;
                }
                bit[j] = 1;
            }
        }
        return true;
    }
}
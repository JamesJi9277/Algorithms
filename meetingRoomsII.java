Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.


/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
时间复杂度On2，空间复杂度On
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for(Interval item : intervals) {
            max = Math.max(max, item.end);
        }
        int[] bit = new int[max + 1];
        for(int i = 0; i < intervals.length;i++) {
            for(int j = intervals[i].start; j < intervals[i].end; j++) {
                bit[j]++;
            }
        }
        int res = 0;
        for(int i = 0; i < bit.length; i++) {
            res = Math.max(res, bit[i]);
        }
        return res;
    }
}


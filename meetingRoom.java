Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return false.


public class Solution {
    private class Comp implements Comparator<Interval> {
        public int compare(Interval v1, Interval v2) {
            if(v1.start > v2.start) {
                return 1;
            }
            else if(v1.start < v2.start) {
                return -1;
            }
            else {
                return v1.end - v2.end;
            }
        }
    }
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) {
            return true;
        }
        Comp cmp = new Comp();
        Arrays.sort(intervals, cmp);
        for(int i = 0; i < intervals.length - 1; i++) {
            if(intervals[i + 1].start < intervals[i].end) {
                return false;
            }
        }
        return true;
    }
}
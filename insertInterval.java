Given a non-overlapping interval list which is sorted by start point.

Insert a new interval into it, make sure the list is still in order and non-overlapping (merge intervals if necessary).

Have you met this question in a real interview? Yes
Example
Insert [2, 5] into [[1,2], [5,9]], we get [[1,9]].

Insert [3, 4] into [[1,2], [5,9]], we get [[1,2], [3,4], [5,9]].

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }
        //要维护一个inserPos，这样子在扫描的时候，一方面是把小的加在前面，二是把大的加在后面，三是遇到合并的就合并，合并完所有可能合并的之后再插入
        int insertPos = 0;
        for(Interval interval : intervals) {
            //遇到小的就直接加，insertPos也对应++
            if(interval.end < newInterval.start) {
                res.add(interval);
                insertPos++;
            }
            //遇到大的也是直接加，只不过insertPos不变
            else if(interval.start > newInterval.end) {
                res.add(interval);
            }
            //合并能够合并的，将所有可以合并的全部合并
            else {
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
            }
        }
        res.add(insertPos, newInterval);
        return res;
    }
}
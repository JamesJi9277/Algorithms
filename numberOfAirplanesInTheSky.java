// Given an interval list which are flying and landing time of the flight. How many airplanes are on the sky at most?

// Have you met this question in a real interview? Yes
// Example
// For interval list [[1,10],[2,3],[5,8],[4,7]], return 3

// Note
// If landing and flying happens at the same time, we consider landing should happen at first.
/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
//brute force, time O(nk), space O(n)
class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) { 
        // write your code here
        if(airplanes == null || airplanes.size() == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int res = 1;
        for(Interval interval : airplanes) {
            max = Math.max(max, interval.end);
        }
        int length = max;
        int[] time = new int[length + 1];
        time[0] = 1;
        for(Interval interval : airplanes) {
            for(int i = interval.start; i < interval.end; i++) {
                time[i]++;
            }
        }
        for(int i = 0; i <= length; i++) {
            res = Math.max(res, time[i]);
        }
        return res;
    }
}




时间复杂度Onlogn，空间复杂度O1
class Point {
    int time;
    int flag;
    Point(int t, int s) {
        this.time = t;
        this.flag = s;
    }
    public static Comparator<Point> PointComparator = new Comparator<Point>() {
        public int compare(Point p1, Point p2) {
            if(p1.time == p2.time) {
                return p1.flag - p2.flag;
            }
            else {
                return p1.time - p2.time;
            }
        }
    };
}

public class Solution {
    public int countOfAirplanes(List<Interval> airplanes) {
        List<Point> list = new ArrayList<>(airplanes.size() * 2);
        for(Interval i : airplanes) {
            list.add(new Point(i.start, 1));
            list.add(new Point(i.end, 0));
        }

        Collections.sort(list, Point.PointComparator);
        int count = 0;
        int res = 0;
        for(Point p : list) {
            if(p.flag == 1) {
                count++;
            }
            else {
                count--;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
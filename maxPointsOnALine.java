// Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

// Have you met this question in a real interview? Yes
// Example
// Given 4 points: (1,2), (3,6), (0,0), (1,3).

// The maximum number is 3.
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
算法描述： 先选一个点，根据这个点，来建一个hashmap，key是斜率value是node number，再对剩下的点进行遍历，先判断samePos，
然后判断与Y轴平行的点，维护一个res分别与samePos月sameX进行两次对比，注意斜率应该选择用double来存储
public class Solution {
    /**
     * @param points an array of point
     * @return an integer
     */
    public int maxPoints(Point[] points) {
        // Write your code here
        if(points == null || points.length < 1) {
            return 0;
        }
        if(points.length < 3) {
            return points.length;
        }
        int res = 0;
        for(int i = 0; i < points.length; i++) {
            //每次不断地新建hashmap来找到新的k和点，y = kx + b，同样的斜率可以对应到不同的直线
            HashMap<Double, Integer> map = new HashMap<Double, Integer>();
            //初始化注意
            int sameX = 1;
            int samePos = 0;
            for(int j = 0; j < points.length; j++) {
                if(j != i) {
                    //首先判断同样的点，因为在后面判断sameX也会包括这其中的一种，所以要先判断
                    if((points[i].x == points[j].x)&& (points[i].y == points[j].y)) {
                        samePos++;
                    }
                    //是上面判断条件的补集
                    if(points[i].x == points[j].x) {
                        sameX++;
                        continue;
                    }
                    //斜率，注意是double
                    double k = (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);
                    if(map.containsKey(k)) {
                        map.put(k, map.get(k) + 1);
                    }
                    else {
                        //如果是出现斜率一样的话，那么就应该是有两个点在一条线上，所以map中put的是2
                        map.put(k, 2);
                    }
                    //同样的斜率加上重合的点
                    res = Math.max(res, map.get(k) + samePos);
                }
            }
            //在与x轴垂直与不与x轴垂直的直线中找到最大的点
            res = Math.max(res, sameX);
        }
        return res;
    }
}


//second write
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0) {
            return 0;
        }
        int res = 0;
        for(int i = 0; i < points.length; i++) {
            HashMap<Double, Integer> map = new HashMap<Double, Integer>();
            int sameX = 1;
            int samePos = 0;
            for(int j = 0; j < points.length; j++) {
                if(j != i) {
                    if(points[i].x == points[j].x && points[i].y == points[j].y) {
                        samePos++;
                    }
                    if(points[i].x == points[j].x) {
                        sameX++;
                        continue;
                    }
                    double k = (double)(points[i].y - points[j].y) / (double)(points[i].x - points[j].x);
                    if(map.containsKey(k)) {
                        map.put(k, map.get(k) + 1);
                    }
                    else {
                        map.put(k, 2);
                    }
                    res = Math.max(res, map.get(k) + samePos);
                }
            }
            res = Math.max(res, sameX);
        }
        return res;
    }
}
// A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A), write a program to output the skyline formed by these buildings collectively (Figure B).

//  Buildings  Skyline Contour
// The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.

// For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .

// The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.

// For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].

// Notes:

// The number of buildings in any input list is guaranteed to be in the range [0, 10000].
// The input list is already sorted in ascending order by the left x position Li.
// The output list must be sorted by the x position.
// There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]



public class Solution {
public List<int[]> getSkyline(int[][] buildings) {
    List<int[]> result = new ArrayList<int[]>();
    ArrayList<Point> points = new ArrayList<Point>();
    int n = buildings.length;
    for (int i = 0; i < n; ++i) {
        points.add(new Point(buildings[i][0], buildings[i][2], 0));
        points.add(new Point(buildings[i][1], buildings[i][2], 1));
    }
    Collections.sort(points, new Comparator<Point>() {
        public int compare(Point a, Point b) {
            if (a.val != b.val) return a.val - b.val;
            if (a.flag != b.flag) return a.flag - b.flag;  // Starting point first.
            if (a.flag == 0 && b.flag == 0) return b.height - a.height; // Both starting points, with larger height first.
            return a.height - b.height;     // Both ending points, with smaller height first.
        }
    });
    // Max heap of heights.
    PriorityQueue<Integer> heights = new PriorityQueue<Integer>(9, Collections.reverseOrder());
    for(Point p : points) {
        if (p.flag == 0) {      
        // p is a starting point.
           if (heights.isEmpty() || p.height > heights.peek()) {
               int[] keyPoint = new int[2];
               keyPoint[0] = p.val;
               keyPoint[1] = p.height;
               result.add(keyPoint);
           }
           heights.add(p.height);
        } else {
            // This is an ending point.
            if (p.height == heights.peek()) {
                // This happens to be the highest point.
                heights.poll();
                if (heights.isEmpty() || p.height > heights.peek()) {
                    int[] keyPoint = new int[2];
                    keyPoint[0] = p.val;
                    keyPoint[1] = heights.isEmpty() ? 0 : heights.peek();
                    result.add(keyPoint);
                }
            } else {
                // Does not affect the current height. 
                heights.remove(p.height);
            }
        }
    }
    return result;
}

public static class Point {
    int val;
    int height;
    int flag;       // 0 for start and 1 for end.
    Point(int val, int height, int flag) {
        this.val = val;
        this.height = height;
        this.flag = flag;
    }
}}
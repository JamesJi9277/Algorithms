
 import java.util.*;

public class test {

	static class CPoint{
		double x;
		double y;
		CPoint(double a, double b){
			x = a;
			y = b;
		}
	}
	static class ComparatorDistance implements Comparator<CPoint>{
		private CPoint origin;
		ComparatorDistance(CPoint originPoint){
			origin = originPoint;
		}
		@Override
		public int compare(CPoint o1, CPoint o2){
			double distance1 = distance(o1, origin);
			double distance2 = distance(o2, origin);
			if( distance1 < distance2 ){
				return 1;
			}else if( distance1 > distance2 ){
				return -1;
			}else{
				return 0;
			}
		}
		private double distance(CPoint point, CPoint origin){	
			return Math.sqrt( (point.x - origin.x) * (point.x - origin.x) * 1.0 + (point.y - origin.y) * (point.y - origin.y) * 1.0 );
		}
	}
	
	public static CPoint[] findKclosestPoints(CPoint[] array, CPoint original, int k){
		
		CPoint[] res = new CPoint[k];
		if( k == 0 ){
			return res;
		}
		ComparatorDistance comp = new ComparatorDistance(original);
		PriorityQueue<CPoint> maxHeap = new PriorityQueue<CPoint>(comp);
		for(int i = 0; i < array.length; i++){
			if( maxHeap.size() < k ){
				maxHeap.offer(array[i]);
			}else{
				double peekDistance = distance(maxHeap.peek(), original);
				double crtDistance = distance(array[i], original);
				if(peekDistance > crtDistance){
					maxHeap.poll();
					maxHeap.offer(array[i]);
				}
			}
		}
		for(int i = k - 1; i >= 0; i--){
			res[i] = maxHeap.poll();
		}
		return res;
		
	}

	private static double distance(CPoint point, CPoint origin){	
		return Math.sqrt( (point.x - origin.x) * (point.x - origin.x) * 1.0 + (point.y - origin.y) * (point.y - origin.y) * 1.0 );
	}
	
	public static void main(String[] args) {
		Point p1 = new Point(1,1); // sqrt(2)
		Point p2 = new Point(3,7); // sqrt(58)
		Point p3 = new Point(5,4); // sqrt(39)
		Point p4 = new Point(5,0); // sqrt(25)
		Point p5 = new Point(2,2); // sqrt(8)
		Point p6 = new Point(1,4); // sqrt(17)
		Point p7 = new Point(0,3); // sqrt(9)
		Point p8 = new Point(2,1); // sqrt(5)
		Point p9 = new Point(3,1); // sqrt(10)
		Point p10 = new Point(5,1);// sqrt(26)
		
		Point target = new Point(0,0); // p1 < p8 < p5 < p7 < p9
		ArrayList<Point> pointsSet = new ArrayList<Point>();
		pointsSet.add(p10);pointsSet.add(p8);pointsSet.add(p5);pointsSet.add(p1);pointsSet.add(p2);
		pointsSet.add(p9);pointsSet.add(p6);pointsSet.add(p7);pointsSet.add(p4);pointsSet.add(p3);
		kNearestPoint k = new kNearestPoint();
		Point[] res = k.find(pointsSet, target, 5);
		for(Point item : res) {
			System.out.print("(" + item.getX() + " , " + item.getY() +  ")" + " ， ");
		}
	}
}
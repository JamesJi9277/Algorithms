import java.util.ArrayList;
import java.util.HashMap;

public class targetProduct {
	public ArrayList<Double> findTargetProduct(ArrayList<Double> nums, double target) {
		ArrayList<Double> res = new ArrayList<Double>();
		if(nums == null || nums.size() < 2) {
			return res;
		}
		HashMap<Double, Integer> map = new HashMap<Double, Integer>();
		for(int i = 0; i < nums.size(); i++) {
			if(map.containsKey(target / nums.get(i))) {
				res.add(target / nums.get(i));
				res.add(nums.get(i));
			}
			else {
				map.put(nums.get(i),i);
			}
		}
		return res;
	}
	public static void main(String[] args) {
		targetProduct t = new targetProduct();
		ArrayList<Double> nums = new ArrayList<Double>();
		nums.add(9.0);nums.add(2.0);nums.add(3.0);nums.add(4.0);nums.add(5.0);
		int target = 12;
		ArrayList<Double> res = t.findTargetProduct(nums, target);
		for(Double item : res) {
			System.out.print(item + " ");
		}
	}
}

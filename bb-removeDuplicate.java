import java.util.*;
public class removeDup {
	public void remove(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums1.length; i++) {
			if(!map.containsKey(nums1[i])) {
				map.put(nums1[i], 1);
			}
		}
		for(int i = 0; i < nums2.length; i++) {
			if(!map.containsKey(nums2[i])) {
				map.put(nums2[i], 1);
			}
		}
		for(Integer item : map.keySet()) {
			System.out.print(item + " ");
		}
	}
	public void remove1(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int index1 = 0;
		int index2 = 0;
		ArrayList<Integer> res = new ArrayList<Integer>();
		while(index1 < nums1.length && index2 < nums2.length) {
			if(nums1[index1] < nums2[index2]) {
				res.add(nums1[index1]);
				index1++;
			}
			else if(nums1[index1] == nums2[index2]) {
				res.add(nums1[index1]);
				index1++;
				index2++;
			}
			else if(nums1[index1] > nums2[index2]) {
				res.add(nums2[index2]);
				index2++;
			}
		}
		while(index1 < nums1.length) {
			res.add(nums1[index1++]);
		}
		while(index2 < nums2.length) {
			res.add(nums2[index2++]);
		}
		for(Integer item : res) {
			System.out.print(item + " ");
		}
	}
	public static void main(String[] args) {
		removeDup r = new removeDup();
		int[] nums1 = {1,2,3,4};
		int[] nums2 = {3,4,5,6};
		r.remove(nums1, nums2);
		System.out.println("");
		r.remove1(nums1, nums2);
	}
}
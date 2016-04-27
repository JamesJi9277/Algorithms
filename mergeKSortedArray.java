import java.util.ArrayList;

public class mergeKArray {
	public static void main(String[] args) {
		ArrayList<int[]> array = new ArrayList<int[]>();
		int[] arr0 = {1,5,7,9,13};
		int[] arr1 = {2,6,8,11,14};
		int[] arr2 = {0,3,4,10,15};
		int[] arr3 = {6,7,10,14,25};
		int[] arr4 = {9,18,23,25,27};
		array.add(arr0);array.add(arr1);array.add(arr2);array.add(arr3);array.add(arr4);
		ArrayList<int[]> res = mergeKSortedArray(array);
		for(int i = 0; i < res.get(0).length; i++) {
			System.out.print(res.get(0)[i] + " , ");
		}
	}
	private static ArrayList<int[]> mergeKSortedArray(ArrayList<int[]> array) {
		while(array.size() != 1) {
			ArrayList<int[]> temp = new ArrayList<int[]>();
			int length = array.size();
			for(int i = 0; i < length; i += 2) {
				if(i == length - 1) {
					temp.add(array.get(i));
				}
				else {
					temp.add(mergeTwoSortedArray(array.get(i), array.get(i + 1)));
				}
			}
			array = temp;
		}
		return array;
	}
	private static int[] mergeTwoSortedArray(int[] a, int[] b) {
		int length1 = a.length;
		int length2 = b.length;
		int i = 0;
		int j = 0;
		int[] res = new int[length1 + length2];
		int count = 0;
		while(i < length1 && j < length2) {
			if(a[i] <= b[j]) {
				res[count++] = a[i];
				i++;
			}
			else {
				res[count++] = b[j];
				j++;
			}
		}
		if(i < length1) {
			while(i != length1) {
				res[count++] = a[i];
				i++;
			}
		}
		if(j < length2) {
			while(j != length2) {
				res[count++] = b[j];
				j++;
			}
		}
		return res;
	}
}




class Elem {
    int row;
    int col;
    int val;
    public Elem(int row, int col, int val) {
        this.col = col;
        this.row = row;
        this.val = val;
    }
}
public class Solution {
    private class Comp implements Comparator<Elem> {
        public int compare(Elem e1, Elem e2) {
            return e1.val - e2.val;
        }
    }
    public List<Integer> mergekSortedArrays(int[][] arrays) {
        List<Integer> res = new ArrayList<Integer>();
        if(arrays == null || arrays.length == 0 || arrays[0].length == 0) {
            return res;
        }
        Comp cmp = new Comp();
        PriorityQueue<Elem> minHeap = new PriorityQueue<Elem>(arrays.length, cmp);
        for(int i = 0; i < arrays.length; i++) {
            if(arrays[i] != null) {
                Elem e = new Elem(i, 0, arrays[i][0]);
                minHeap.offer(e);
            }
        }
        while(!minHeap.isEmpty()) {
            Elem e = minHeap.poll();
            res.add(e.val);
            int row = e.row;
            int col = e.col;
            if(col + 1 < arrays[row].length) {
                e.col = col + 1;
                e.val = arrays[row][col + 1];
                minHeap.offer(e);
            }
        }
        return res;
    }
}
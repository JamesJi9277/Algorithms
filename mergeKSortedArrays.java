时间Onlogn
public class Solution {
    /**
     * @param arrays k sorted integer arrays
     * @return a sorted array
     */
    public List<Integer> mergekSortedArrays(int[][] arrays) {
        // Write your code here
        List<Integer> res = new ArrayList<Integer>();
        if(arrays == null || arrays.length == 0 || arrays[0].length == 0) {
            return res;
        }
        int m = arrays.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < arrays[i].length; j++) {
                minHeap.offer(arrays[i][j]);
            }
        }
        while(!minHeap.isEmpty()) {
            res.add(minHeap.poll());
        }
        return res;
    }
}

时间Onlogk
class Element {
    int row;
    int col;
    int val;
    Element(int row, int col, int val) {
        this.row = row;
        this.val = val;
        this.col = col;
    }
}
public class Solution {
    private class Comp implements Comparator<Element> {
        public int compare(Element e1, Element e2) {
            return e1.val - e2.val;
        }
    }
    public List<Integer> mergekSortedArrays(int[][] arrays) {
        List<Integer> res = new ArrayList<Integer>();
        if(arrays == null || arrays.length == 0 || arrays[0].length == 0) {
            return res;
        }
        Comp cmp = new Comp();
        PriorityQueue<Element> minHeap = new PriorityQueue<Element>(arrays.length, cmp);
        for(int i = 0; i < arrays.length; i++) {
            if(arrays[i] != null) {
                Element temp = new Element(i, 0, arrays[i][0]);
                minHeap.offer(temp);
            }
        }
        while(!minHeap.isEmpty()) {
            Element temp = minHeap.poll();
            res.add(temp.val);
            int row = temp.row;
            int col = temp.col;
            if(col + 1 < arrays[row].length) {
                temp.col = col + 1;
                temp.val = arrays[row][col + 1];
                minHeap.offer(temp);
            }
        }
        return res;
    }
}


分支递归
public class Solution {
    public List<Integer> mergekSortedArrays(int[][] arrays) {
        List<Integer> res = new ArrayList<Integer>();
        if(arrays == null || arrays.length == 0 || arrays[0].length == 0) {
            return res;
        }
        int length = arrays.length;
        int[] result = mergeK(arrays, 0, length - 1);
        for(Integer item : result) {
            res.add(item);
        }
        return res;
    }
    private int[] mergeK(int[][] arrays, int start, int end) {
        if(start == end) {
            return arrays[start];
        }
        int mid = start + (end - start) / 2;
        int[] left = mergeK(arrays, start, mid);
        int[] right = mergeK(arrays, mid + 1, end);
        return mergeTwo(left, right);
    }
    private int[] mergeTwo(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int newLength = length1 + length2;
        int[] res = new int[newLength];
        int index = newLength - 1;
        int index1 = length1 - 1;
        int index2 = length2 - 1;
        while(index1 >= 0 && index2 >= 0) {
            if(nums1[index1] >= nums2[index2]) {
                res[index--] = nums1[index1--];
            }
            else {
                res[index--] = nums2[index2--];
            }
        }
        while(index1 >= 0) {
            res[index--] = nums1[index1--];
        }
        while(index2 >= 0) {
            res[index--] = nums2[index2--];
        }
        return res;
    }
}
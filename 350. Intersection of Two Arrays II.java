public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) {
            return nums1 == null ? nums1 : nums2;
        }
        ArrayList<Integer> array = new ArrayList<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]) {
                array.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i] < nums2[j]) {
                i++;
            }
            else {
                j++;
            }
        }
        int[] res = new int[array.size()];
        for(int k = 0; k < array.size(); k++) {
            res[k] = array.get(k);
        }
        return res;
    }
}

@QiJi
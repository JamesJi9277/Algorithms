public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null ) {
            return nums1 == null ? nums1 : nums2;
        }
        ArrayList<Integer> re = new ArrayList<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums1.length; i++) {
            if(!set.contains(nums1[i])) {
                set.add(nums1[i]);
            }
        }
        for(int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i]) && !re.contains(nums2[i])) {
                re.add(nums2[i]);
            }
        }
        int[] res = new int[re.size()];
        for(int i = 0; i < re.size(); i++) {
            res[i] = re.get(i);
        }
        return res;
    }
}
sss
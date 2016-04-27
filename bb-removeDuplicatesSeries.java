remove duplicates from sorted array
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
        	return 0;
        }
        int length = nums.length;
        int count = 0;
        for(int i = 0; i < length; i++) {
        	if(i != 0 && nums[i - 1] == nums[i]) {
        		count++;
        	}
        	else {
        		nums[i - count] = nums[i];
        	}
        }
        return length - count;
    }
}
remove duplicates from sorted array II
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int count = 0;
        int increment = 0;
        int index = 0;
        for(int i = 0; i < length; i++) {
            if(nums[i] == nums[index]) {
                count++;
            }
            else {
                index = i;
                count = 1;
            }
            nums[i - increment] = nums[i];
            if(count > 2) {
                increment++;
            }
        }
        return length - increment;
    }
}
remove duplicated from sorted list
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        while(temp.next != null) {
            ListNode next = temp.next;
            if(temp.val == next.val) {
                temp.next = next.next;
            }
            else {
                temp = next;
            }
        }
        return head;
    }
}
remove duplicated from sorted listII
public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		while(head.next != null && head.next.next != null) {
			if(head.next.val == head.next.next.val) {
				int val = head.next.val;
				while(head.next != null && head.next.val == val) {
					head.next = head.next.next;
				}
			}
			else {
				head = head.next;
			}
		}
		return dummy.next;
	}
}
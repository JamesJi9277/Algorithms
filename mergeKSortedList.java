// Merge k sorted linked lists and return it as one sorted list.

// Analyze and describe its complexity.

// Have you met this question in a real interview? Yes
// Example
// Given lists:

// [
//   2->4->null,
//   null,
//   -1->null
// ],
// return -1->2->4->null.

//using heap
//因为java中heap要用priority queue来实现，并且要自己写一个comparator，所以这个方法要理解记忆

public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    private  class ListNodeComp implements Comparator<ListNode> {
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        if(lists == null || lists.size() == 0) {
            return null;
        }
        ListNodeComp cmp = new ListNodeComp();
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(lists.size(), cmp);
        for(int i = 0; i < lists.size(); i++) {
            if(lists.get(i) != null) {
                minHeap.offer(lists.get(i));
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(!minHeap.isEmpty()) {
            ListNode temp = minHeap.poll();
            head.next = temp;
            head = head.next;
            if(temp.next != null) {
                minHeap.offer(temp.next);
            }
        }
        return dummy.next;
    }
}


public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        if(lists == null || lists.size() == 0) {
            return null;
        }
        return merge(lists, 0, lists.size() - 1);
    }
    private ListNode merge(List<ListNode> lists,int start, int end) {
        if(start == end) {
          //代表只有一个list，直接返回这个即可
            return lists.get(start);
        }
        int mid = start + (end - start) / 2;
        ListNode left = merge(lists, start, mid);
        ListNode right = merge(lists, mid + 1, end);
        return mergeTwo(left, right);
    }
    private ListNode mergeTwo(ListNode head1, ListNode head2) {
        if(head1 == null || head2 == null) {
            return (head1 == null) ? head2 : head1;
        }
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(head1 != null && head2 != null) {
            if(head1.val < head2.val) {
                head.next = head1;
                head = head.next;
                head1 = head1.next;
            }
            else {
                head.next = head2;
                head = head.next;
                head2 = head2.next;
            }
        }
        if(head1 != null) {
            head.next = head1;
        }
        if(head2 != null) {
            head.next = head2;
        }
        return dummy.next;
    }
}




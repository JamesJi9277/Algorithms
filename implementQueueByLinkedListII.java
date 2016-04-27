Implement a Queue by linked list. Provide the following basic methods:

push_front(item). Add a new item to the front of queue.
push_back(item). Add a new item to the back of the queue.
pop_front(). Move the first item out of the queue, return it.
pop_back(). Move the last item out of the queue, return it.
Have you met this question in a real interview? Yes
Example
push_front(1)
push_back(2)
pop_back() // return 2
pop_back() // return 1
push_back(3)
push_back(4)
pop_front() // return 3
pop_front() // return 4


public class Dequeue {
    ListNode dummy;
    public Dequeue() {
        // do initialize if necessary
        dummy = new ListNode(0);
    }

    public void push_front(int item) {
        // Write your code here
        ListNode temp = new ListNode(item);
        if(dummy.next == null) {
            dummy.next = temp;
            temp.next = null;
            return;
        }
        else {
            ListNode next = dummy.next;
            dummy.next = temp;
            temp.next = next;
            return;
        }
    }

    public void push_back(int item) {
        // Write your code here
        ListNode temp = new ListNode(item);
        if(dummy.next == null) {
            dummy.next = temp;
            temp.next = null;
            return;
        }
        else {
            ListNode tail = dummy;
            while(tail.next != null) {
                tail = tail.next;
            }
            tail.next = temp;
            temp.next = null;
            return;
        }
    }

    public int pop_front() {
        // Write your code here
        if(dummy.next == null) {
            return -1;
        }
        else {
            ListNode next = dummy.next;
            int res = next.val;
            dummy.next = next.next;
            return res;
        }
    }

    public int pop_back() {
        // Write your code here
        if(dummy.next == null) {
            return -1;
        }
        else {
            ListNode tail = dummy;
            ListNode preTail = dummy;
            while(tail.next != null) {
                preTail = tail;
                tail = tail.next;
            }
            int res = tail.val;
            preTail.next = tail.next;
            return res;
        }
    }
}
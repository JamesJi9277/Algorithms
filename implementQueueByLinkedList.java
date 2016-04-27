Implement a Queue by linked list. Support the following basic methods:

enqueue(item). Put a new item in the queue.
dequeue(). Move the first item out of the queue, return it.
Have you met this question in a real interview? Yes
Example
enqueue(1)
enqueue(2)
enqueue(3)
dequeue() // return 1
enqueue(4)
dequeue() // return 2


public class Queue {
    ListNode head;
    ListNode tail;
    public Queue() {
        // do initialize if necessary
        head = new ListNode(0);
        tail = head;
    }

    public void enqueue(int item) {
        // Write your code here
        ListNode temp = new ListNode(item);
        tail.next = temp;
        tail = tail.next;
        temp.next = null;
    }

    public int dequeue() {
        // Write your code here
        int temp = 0;
        if(head.next != null) {
        	temp = head.next.val;
        	head = head.next;
        }
        return temp;
    }
}
class DoubleLinkedListNode {
    int key;
    int val;
    DoubleLinkedListNode pre;
    DoubleLinkedListNode next;
    public DoubleLinkedListNode(int key, int val) {
        this.key = key;
        this.val = val;
        pre = null;
        next = null;
    }
}
public class LRUCache {
    DoubleLinkedListNode head;
    DoubleLinkedListNode end;
    int length;
    int capacity;
    HashMap<Integer, DoubleLinkedListNode> map = new HashMap<Integer, DoubleLinkedListNode>();
    public LRUCache(int capacity) {
        head = null;
        end = null;
        length = 0;
        this.capacity = capacity;
        //map = new HashMap<Integer, DoubleLinkedListNode>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        else {
            DoubleLinkedListNode node = map.get(key);
            removeNode(node);
            setHead(node);
            return node.val;
        }
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)) {
            DoubleLinkedListNode node = map.get(key);
            removeNode(node);
            map.remove(key);
            node.val = value;
            setHead(node);
            map.put(key, node);
        }
        else {
            if(length < capacity) {
                length++;
                DoubleLinkedListNode node = new DoubleLinkedListNode(key, value);
                setHead(node);
                map.put(key, node);
            }
            else {
                DoubleLinkedListNode node = new DoubleLinkedListNode(key, value);
                map.remove(end.key);
                end = end.pre;
                if(end != null) {
                    end.next = null;
                }
                setHead(node);
                map.put(key, node);
            }
        }
    }
    public void setHead(DoubleLinkedListNode node) {
        node.pre = null;
        node.next = head;
        if(head != null) {
            head.pre = node;
        }
        head = node;
        if(end == null) {
            end = node;
        }
    }
    private void removeNode(DoubleLinkedListNode node) {
        DoubleLinkedListNode cur = node;
        DoubleLinkedListNode pre = cur.pre;
        DoubleLinkedListNode next = cur.next;
        if(pre != null) {
            pre.next = next;
        }
        else {
            head = next;
        }
        if(next != null) {
            next.pre = pre;
        }
        else {
            end = pre;
        }
    }
}
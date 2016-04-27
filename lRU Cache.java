// Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

// get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
// set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
// it should invalidate the least recently used item before inserting a new item.
// LRU = least recently used
// support get and set
// get: return positive value or return -1
// set: set or insert the value if the key is not already present. When reached the capacity, remove least recently used item before inserting new one
// 为了实现快速的删除最少访问次数的数据项和插入最新的数据项，我们将双向链表连接到cache结构中，这样子可以保证链表始终维持在最近访问到最久未访问的顺序，每次数据项被查询到时，
// 都将这个数据项移动到链表头部O（1）的时间复杂度，这样，在进行多次操作之后，最少访问的那个数据项就自动的排列到了队尾，LRU的基本思想就是"最近用到的数据被重用的概率比较早用到的大得多"。
// 双向链表+hashmap
// get（key）如果cache里面不存在要找的值，返回-1；如果存在，找到其值后，将node在元链表中删除，然后新建一个同样的node插到链表头部作为头结点
// set（key，value），当要set的值已经存在，那么就更新其value，然后将其在原链表中删除，然后新建一个更新后的node，再将这个node插入到linked list头部。
//                 ，当要set的值不存在，那么就新建一个node，如果当前len<capacity，那么就直接加入到hashmap中，然后将其作为头结点，更新长度。否则，
//                 删除链表中最后一个元素，然后在将其放入hashmap中并且将其设置为头结点，但是len不更新
public class LRUCache{
	private HashMap<Integer, DoubleLinkedListNode> map = new HashMap<Integer, DoubleLinkedListNode>();
	private DoubleLinkedListNode head;
	private DoubleLinkedListNode end;
	private int capacity;
	private int len;
	public LRUCache(int capacity){
		this.capacity = capacity;
		len = 0;     
	}

	public int get(int key){
		if(map.containsKey(key)){
			DoubleLinkedListNode latest = map.get(key);
			removeNode(latest);
			setHead(latest);
			return latest.val;
		}
		else{
			return -1;
		}
	}

	public void removeNode(DoubleLinkedListNode node){
		DoubleLinkedListNode cur = node;
		DoubleLinkedListNode pre = cur.pre;
		DoubleLinkedListNode post = cur.next;
		if(pre!=null){
			pre.next = post;
		}
		else{
			head = post;
		}
		if(post!=null)
		{
			post.pre = pre;
		}
		else{
			end = pre;
		}
	}

	public void setHead(DoubleLinkedListNode node){
		node.next = head;
		node.pre = null;
		if(head != null){
			head.pre = node;
		}
		head = node;
		if(end == null){
			end = node;
		}
	}

	public void set(int key, int value){
		if(map.containsKey(key)){
			DoubleLinkedListNode oldNode = map.get(key);
			oldNode.val = value;
			removeNode(oldNode);
			setHead(oldNode);
		}
		else{
			DoubleLinkedListNode newNode = new DoubleLinkedListNode(key, value);
			if(len < capacity){
				setHead(newNode);
				map.put(key, newNode);
				len++;
			}
			else{
				map.remove(end.key);
				end = end.pre;
				if(end != null){
					end.next = null;
				}
				setHead(newNode);
				map.put(key, newNode);
			}
		}
	}
}

class DoubleLinkedListNode{
	public int val;
	public int key;
	public DoubleLinkedListNode pre;
	public DoubleLinkedListNode next;

	public DoubleLinkedListNode(int key, int value){
		val = value;
		this.key = key;
	}
}
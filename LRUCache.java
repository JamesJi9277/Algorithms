// Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
//
// get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
// set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
//解析：这题是一个数据结构的设计题，是一道经典题，需要好好掌握和体会
//要求设计实现LRU cache的数据结构，实现set和get功能。cache作为缓存可以帮助快速存储数据
//但是容量比较小
//这一题比较快速的解决办法是双向链表+HashMap
//为了能够快速删除最久没有访问的数据项和增加最新的数据项，我们将双向链表连接cache里面的数据项，
//并保证链表维持数据项从最近访问到最旧访问的顺序，每次数据项被查询到的时候，都将这个数据项移动到链表头，
//这样子，在链表尾端的位置的那个数据项就是那个最少访问的数据项，当需要替换的时候，我们只需要将
//最新的数据项放在链表的头部，当cache满了的时候，淘汰链表最后一个位置就好了
//对于利用双向链表， 首先是cache中命令是随机的，和load进来的顺序无关
//其次，双向链表中的插入，删除很快，可以灵活的调整顺序，时间复杂度为O(1)，
//get(key),如果cache中不存在要get的值，就返回-1，否则，如果cache中存在要找的值，返回这个值并且在元链表中
//将这个值删除，然后将其作为头结点
//set(key, value)，当要set的key值已经存在，就更新其value，然后在原链表中删除，然后将新的节点作为头结点
//当要set的key不存在，那么就新建一个node，如果当前len < cap, 那么久将其加入hashmap,并将其作为头结点然后更新hashmap，
//否则的话，就删除链表中最后一个node然后将其放入map作为头结点，但是length不更新
//对链表有访问，就要更新链表顺序
class DoubleLinkedListNode {
    int key;
    int val;
    DoubleLinkedListNode pre;
    DoubleLinkedListNode next;
    DoubleLinkedListNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.pre = null;
        this.next = null;
    }
}
public class Solution {
    HashMap<Integer, DoubleLinkedListNode> map = new HashMap<Integer, DoubleLinkedListNode>();
    DoubleLinkedListNode head;
    DoubleLinkedListNode end;
    int capacity;
    int length;
    // @param capacity, an integer
    public Solution(int capacity) {
        this.capacity = capacity;
        length = 0;
        head = null;
        end = null;
    }

    // @return an integer
    public int get(int key) {
        // write your code here
        if(map.containsKey(key)) {
            DoubleLinkedListNode node = map.get(key);
            removeNode(node);
            setHead(node);
            return node.val;
        }
        else {
            return -1;
        }
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // write your code here
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
                DoubleLinkedListNode node = new DoubleLinkedListNode(key, value);
                map.put(key, node);
                length++;
                setHead(node);
            }
            else {
                DoubleLinkedListNode node = new DoubleLinkedListNode(key, value);
                map.remove(end.key);
                end = end.pre;
                if(end != null) {
                    end.next = null;
                }
                map.put(key, node);
                setHead(node);
            }
        }
    }
    private void setHead(DoubleLinkedListNode node) {
        node.pre = null;
        node.next = head;
        if(head != null) {
            head.pre = node;
        }
        head = node;
        //setHead之后一定要记住对end的再判断
        if(end == null) {
            end = node;
        }
    }
    private void removeNode(DoubleLinkedListNode node) {
        DoubleLinkedListNode cur = node;
        DoubleLinkedListNode pre = node.pre;
        DoubleLinkedListNode next = node.next;
        //这里的判断很重要，搞清楚方向关系
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


//nine的做法，代码简单易懂，只是run time慢一些
public class LRUCache {
  private class Node {
    Node prev;
    Node next;
    int key;
    int value;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
      this.prev = null;
      this.next = null;
    }
  }

  private int capacity;
  private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
  private Node head = new Node(-1, -1);
  private Node tail = new Node(-1, -1);

  public LRUCache(int capacity) {
    this.capacity = capacity;
    tail.prev = head;
    head.next = tail;
  }

  public int get(int key) {
    if(!map.containsKey(key)) {
      return -1;
    }

    //remove current
    Node current = map.get(key);
    current.prev.next = current.next;
    current.next.prev = current.prev;

    //move current to tail
    moveToTail(current);

    return map.get(key).value;
  }

  public void set(int key, int value) {
    if(get(key) != -1) {
      map.get(key).value = value;
      return;
    }

    if(map.size() == capacity) {
      map.remove(head.next.key);
      head.next = head.next.next;
      head.next.prev = head;
    }

    Node insert = new Node(key, value);
    map.put(key, insert);
    moveToTail(insert);
  }

  private void moveToTail(Node current) {
    current.prev = tail.prev;
    tail.prev = current;
    current.prev.next = current;
    current.next = tail;
  }
}


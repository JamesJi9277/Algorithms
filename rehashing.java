// The size of the hash table is not determinate at the very beginning. If the total size of keys is too large (e.g. size >= capacity / 10), we should double the size of the hash table and rehash every keys. Say you have a hash table looks like below:
//
// size=3, capacity=4
//
// [null, 21, 14, null]
//        ↓    ↓
//        9   null
//        ↓
//       null
// The hash function is:
//
// int hashcode(int key, int capacity) {
//     return key % capacity;
// }
// here we have three numbers, 9, 14 and 21, where 21 and 9 share the same position as they all have the same hashcode 1 (21 % 4 = 9 % 4 = 1). We store them in the hash table by linked list.
//
// rehashing this hash table, double the capacity, you will get:
//
// size=3, capacity=8
//
// index:   0    1    2    3     4    5    6   7
// hash : [null, 9, null, null, null, 21, 14, null]
// Given the original hash table, return the new hash table after rehashing .
//
// Have you met this question in a real interview? Yes
// Example
// Given [null, 21->9->null, 14->null, null],
//
// return [null, 9->null, null, null, null, 21->null, 14->null, null]
//
// Note
// For negative integer in hash table, the position can be calculated as follow:
//
// C++/Java: if you directly calculate -4 % 3 you will get -1. You can use function: a % b = (a % b + b) % b to make it is a non negative integer.
// Python: you can directly use -1 % 3, you will get 2 automatically.

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
import java.util.*;
public class Solution {
    public ListNode[] rehashing(ListNode[] hashTable) {
        if(hashTable == null || hashTable.length == 0) {
            return hashTable;
        }
        int cap = hashTable.length;
        int newCap = 2 * cap;
        ListNode[] res = new ListNode[newCap];
        for(int i = 0; i < cap; i++) {
            ListNode cur = hashTable[i];
            while(cur != null) {
                ListNode next = cur.next;
                cur.next = null;
                setNode(res, cur);
                cur = next;
            }
        }
        return res;
    }
    private void setNode(ListNode[] res, ListNode cur) {
        int cap = res.length;
        int key = cur.val;
        int index = 0;
        if(key > 0) {
            index = key % cap;
        }
        else {
            index = (key % cap + cap) % cap;
        }
        if(res[index] == null) {
            res[index] = cur;
        }
        else {
            ListNode temp = res[index];
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = cur;
            cur.next = null;
        }
    }
};


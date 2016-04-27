Given a list of words and an integer k, return the top k frequent words in the list.

Have you met this question in a real interview? Yes
Example
Given

[
    "yes", "lint", "code",
    "yes", "code", "baby",
    "you", "baby", "chrome",
    "safari", "lint", "code",
    "body", "lint", "code"
]
for k = 3, return ["code", "lint", "baby"].

for k = 4, return ["code", "lint", "baby", "yes"],


class Element {
    String key;
    int val;
    Element(String key, int val) {
        this.key = key;
        this.val = val;
    }
}
public class Solution {
    private class Comp implements Comparator<Element> {
        public int compare(Element e1, Element e2) {
            if(e1.val > e2.val) {
                return 1;
            }
            else if(e1.val < e2.val) {
                return -1;
            }
            else {
                return e2.key.compareTo(e1.key);
            }
        }
    }
    public String[] topKFrequentWords(String[] words, int k) {
        if(words == null || words.length == 0 || k < 1) {
            return new String[0];
        }
        String[] res = new String[k];
        int index = k - 1;
        Comp cmp = new Comp();
        PriorityQueue<Element> minHeap = new PriorityQueue<Element>(k, cmp);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String word : words) {
            if(map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            }
            else {
                map.put(word, 1);
            }
        }
        for(String str : map.keySet()) {
            Element elem = new Element(str, map.get(str));
            if(minHeap.size() < k) {
                minHeap.offer(elem);
            }
            else {
                if(cmp.compare(minHeap.peek(), elem) < 0) {
                    minHeap.poll();
                    minHeap.offer(elem);
                }
            }
        }
        while(!minHeap.isEmpty()) {
            res[index--] = minHeap.poll().key;
        }
        return res;
    }
}
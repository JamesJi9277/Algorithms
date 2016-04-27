class Element {
    String key;
    int count;
    public Element(String key, int count) {
        this.key = key;
        this.count = count;
    }
}
public class Solution {
    private class Comp implements Comparator<Element> {
        public int compare(Element e1, Element e2) {
            if(e1.count > e2.count) {
                return 1;
            }
            else if(e1.count < e2.count) {
                return -1;
            }
            else {
                return e2.key.compareTo(e1.key);
            }
        }
    }
    public String[] topKFrequentWords(String[] words, int k) {
        String[] res = new String[k];
        if(words == null || words.length == 0 || k < 1) {
            return res;
        }
        Comp cmp = new Comp();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String word : words) {
            if(map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            }
            else {
                map.put(word, 1);
            }
        }
        PriorityQueue<Element> minHeap = new PriorityQueue<Element>(k, cmp);
        for(String s : map.keySet()) {
            if(minHeap.size() < k) {
                Element elem = new Element(s, map.get(s));
                minHeap.offer(elem);
            }
            else {
                Element elem = new Element(s, map.get(s));
                if(cmp.compare(minHeap.peek(), elem) < 0) {
                    minHeap.poll();
                    minHeap.offer(elem);
                }
            }
        }
        int index = k - 1;
        while(!minHeap.isEmpty()) {
            res[index--] = minHeap.poll().key;
        }
        return res;
    }
}
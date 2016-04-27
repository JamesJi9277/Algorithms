N个streams，每个输入infinite ascending number,排序输出成一个有序的stream
Stream1 : 1,2,8,21,34,...
Stream2 : 1,3,5,8,13
```
priority queue, time On + nlogk, k is size of heap, space Ok
class Element {
	int number;
	int val;
	Element(int number, int val) {
		this.number = number;
		this.val = val;
	}
}
public class Solution {
	private class ElemCmp implements Comparator<Element> {
		public int compare(Element e1, Element e2) {
			return e1.val - e2.val;
		}
	}
	public ArrayList<Integer> nStream(ArrayList<Stream> source) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(source == null || source.size() == 0) {
			return res;
		}
		int size = source.size();
		ElemCmp cmp = new ElemCmp();
		PriorityQueue<Element> minHeap = new PriorityQueue<Element>(size, cmp);
		for(int i = 0; i < size; i++) {
			if(source.get(i).getNext() != null) {
				Element elem = new Element(i, source.get(i).getNext());
				minHeap.offer(elem);
			}
		}
		while(!minHeap.isEmpty()) {
			Element elem = minHeap.poll();
			res.add(elem.val);
			int number = elem.number;
			if(source.get(number).getNext() != null) {
				elem.val = source.get(number).getNext();
				minHeap.offer(elem);
			}
		}
		return res;
	}
}
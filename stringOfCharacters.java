// Given a stream of characters, find the last character that occurs only once.
// Stream需要用next()来取得下一个char
public class Solution {
	public Character findLastOccurOnce(CharacterStream head) {
		if(head == null) {
			return null;
		}
		if(head.next == null) {
			return head;
		}
		ArrayList<Character> array = new ArrayList<Character>();
		HashMap<Character, Integer> map = new HashMap<Character,Integer>();
		while(head != null) {
			array.add(head);
			if(map.containsKey(head)) {
				map.put(head, map.get(head) + 1);
			}
			map.put(head, 1);
			head = head.next;
		}
		for(int i = array.length() - 1; i >= 0; i--) {
			if(map.get(array.get(i)) == 1) {
				return array.get(i);
			}
		}
		return null;
	}
}
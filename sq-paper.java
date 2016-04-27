给一些paper，作者和reference paper
Example
paper1 : [David, Mark] : [paper2]
paper2 : [Linsey] : []
paper3: [Mark]:[paper2]
如果两个人合作一个paper，两者之间有一个连接
如果一个人的reference了另外一个人的paper也是一个连接
找到两个作者之间的一条path

class Element {
	int paperNum;
	String[] author;
	String[] references;
	public Element(int paperNum, String[] author, String[] references) {
		this.paperNum = paperNum;
		this.author = author;
		this.references = references;
	}
}
public class findPath {
	public String path(Element[] elems, String start, String end) {
		if(elem == null || elem.length == 0) {
			return "";
		}
		Element startElem = null;
		Element endElem = null;
		for(Element elem : elems) {
			for(String str : elem.author) {
				if(str.equals(start)) {
					startElem = elem;
				}
				if(str.equals(end)) {
					endElem = elem;
				}
			}
		}
		HashMap<Integer, Element> map = new HashMap<Integer, Element>();
		for(Element elem : elems) {
			map.put(elem.paperNum, elem);
		}
		StringBuffer sb = new StringBuffer();
		helper(elems, startElem, endElem, sb, map);
		return sb.toString();
	}
	private void helper(Element[] elems, Element startElem, Element endElem, StringBuffer sb, HashMap<Integer, Element> map) {
		if(startElem == endElem) {
			sb.append(startElem.paperNum);
			return;
		}
		for(String str : startElem.references) {
			Element next = map.get(Integer.parseInt(str));
			sb.append(next.paperNum);
			helper(elems, next, endElem, sb, map);
			sb.deleteCharAt(sb.size() - 1);
		}

	}
}
import java.io.UnsupportedEncodingException; 
import java.util.*;
class Node {
	String key;
	ArrayList<Node> childrens;

	Node(String key) {
		this.key = key;
		childrens = new ArrayList<Node>();
	}

	public void addChild(Node node) {
		this.childrens.add(node);
		return;
	}

	public static String serialization(Node root) {
		StringBuffer sb = new StringBuffer();
		if(root == null) {
			return sb.toString();
		}
		sb.append(".");
		sb.append(root.key);
		sb.append(".");
		for(Node children : root.childrens) {
			sb.append(Node.serialization(children));
		}
		sb.append(")");
		return sb.toString();
	}

	public static Node deserialization(String s) {
		if(s == null || s.length() == 0) {
			return null;
		}
		s = s.trim();
		Node root = null;
		boolean isData = false;
		StringBuffer data = null;
		Stack<Node> stack = new Stack<Node>();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == '.') {
				isData = !isData;
				if(isData) {
					data = new StringBuffer();
				}
				else {
					Node child = new Node(data.toString());
					if(stack.isEmpty()) {
						root = child;
					}
					else {
						Node parent = stack.peek();
						parent.addChild(child);
					}
					stack.push(child);
				}
			}
			else {
				if(isData) {
					data.append(c);
				}
				else if(c == ')') {
					stack.pop();
				}
			}
		}
		return root;
	}
}

public class naryTree {  
    public static void main(String[] args) throws UnsupportedEncodingException {  
        Node root = new Node("5");  
        Node ch1 = new Node("8");  
        Node ch2 = new Node("9");  
        Node ch3 = new Node("11");  
        root.addChild(ch1);  
        root.addChild(ch2);  
        root.addChild(ch3);  
        Node ch4 = new Node("13");  
        Node ch5 = new Node("17");  
        Node ch6 = new Node("18");  
        Node ch7 = new Node("20");  
        Node ch8 = new Node("22");  
        ch1.addChild(ch4);  
        ch1.addChild(ch5);  
        ch4.addChild(ch6);  
        ch6.addChild(ch7);  
        ch7.addChild(ch8);  
        Node ch9 = new Node("23");  
        Node ch10 = new Node("25");  
        Node ch11 = new Node("27");  
        Node ch12 = new Node("28");  
        Node ch13 = new Node("32");  
        Node ch14 = new Node("31");  
        Node ch15 = new Node("33");  
        Node ch16 = new Node("34");  
        Node ch17 = new Node("29");  
        ch5.addChild(ch9);  
        ch3.addChild(ch10);  
        ch3.addChild(ch11);  
        ch10.addChild(ch12);  
        ch10.addChild(ch14);  
        ch12.addChild(ch13);  
        ch14.addChild(ch15);  
        ch14.addChild(ch16);  
        ch14.addChild(ch17);  
        String packed = Node.serialization(root);  
        System.out.println(packed);  
        Node compareTo = Node.deserialization(packed);  
        System.out.println(root.equals(compareTo));  
    }  
}  


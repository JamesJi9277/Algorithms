// 49.	Given a binary tree, print it vertically. The following example illustrates vertical order traversal.
//           1
//         /    \
//        2      3
//       / \     / \
//      4   5  6   7
//              \   \ 
//               8   9 
// The output of print this tree vertically will be:
// 4
// 2
// 1 5 6
// 3 8
// 7
// 9
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

public class verticalOrderPrint {
	public static TreeMap<Integer, ArrayList> ht = new TreeMap<>();;
	public static int  level;
	public ArrayList<Integer> al;
	public int vertical(Node root, int level, boolean leftCall){
		if(root!=null){
			level = vertical(root.right,++level, true);
			if(ht.get(level)!=null){
				ArrayList x = ht.get(level) ;
				x.add(root.data);
				ht.put(level, x);
			}else{
				al = new ArrayList<>();
				al.add(root.data);
				ht.put(level, al);
			}
			vertical(root.left,--level,false);
			return level;
		}else if(leftCall){
			return --level;
		}else{
			return ++level;
		}
	}
	public void printResult(TreeMap ht){
		Set<Integer> i = ht.keySet();
		for(int keys:i){
			System.out.println(ht.get(keys));
		}
	}
	public static void main(String args[]){
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		verticalOrderPrint p = new verticalOrderPrint();
		p.vertical(root, 0, false);
		p.printResult(ht);

	}
}
class Node{
	int data;
	Node left;
	Node right;
	public Node (int data){
		this.data = data;
		left = null;
		right = null;
	}
}




public class Solution {
	public ArrayList<ArrayList<Integer>> verticalPrint(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new Arrayist<ArrayList<Integer>>();
		if(root == null) {
			return res;
		}
		int minLevel = Integer.MAX_VALUE;
		int maxLevel = Integer.MIN_VALUE;
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		helper(root, 0, map, minLevel, maxLevel);
		for(int i = minLevel; i <= maxLevel; i++) {
			ArrayList<Integer> temp = map.get(i);
			res.add(temp);
		}
		return res;
	}
	private void helper(TreeNode root, int level, HashMap<Integer, ArrayList<Integer>> map, int minLevel, int maxLevel) {
		if(root == null) {
			return;
		}
		if(!map.containsKey(level)) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
		    temp.add(root.val);
		    map.put(0, new ArrayList<Integer>(temp));
		}
		else {
			ArrayList<Integer> temp = map.get(level);
			temp.add(root.val);
			map.put(level, new ArrayList<Integer>(temp));
		}
		minLevel = Math.min(minLevel, level);
		maxLevel = Math.max(maxLevel, level);
		helper(root.left, level - 1, map, minLevel, maxLevel);
		helper(root.right, level + 1, map, minLevel, maxLevel);
	}
}
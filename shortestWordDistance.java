/* This class will be given a list of words (such as tokenized words from a paragraph of text).
* It will also provide a method that takes two words and returns the shortest distance(in words)
* between these two words in the provided text.
* Example:
* WordDistanceFinder finder = new WordDistanceFinder(Arrays.asList(“the”, “quick”, “brown”, “fox”, “quick”));
* assert(finder.distance(“fox”, “the”) == 3);
* assert(finder.distance(“quick”, “fox”) == 1);

要注意的是，输入List中的words会有重复。
*/
//在很多情况下，多设几个变量便会减少时间复杂度

public class Solution {
	public int shortestDistance(String[] str, String a, String b) {
		if(str == null || str.length == 0) {
			return 0;
		}
		int minDis = Integer.MAX_VALUE;
		int first = -1;
		int second = -1;
		int length = str.length;
		for(int i = 0; i < length; i++) {
			if(!str[i].equals(a) && !str[i].equals(b)) {
				continue;
			}
			if(str[i].equals(a)) {
				first = i;
			}
			if(str[i].equals(b)) {
				second = i;
			}
			if((str[i].equals(a) || str[i].equals(b)) && first != -1 && second != -1) {
				minDis = Math.min(minDis, Math.abs(first - second));
			}
		}
		return minDis;
	}
}

//
import java.util.ArrayList;
import java.util.HashMap;

public class shortestWordDistance {
	public int findDistance(String[] str, String a, String b) {
		if(str == null || str.length == 0) {
			return 0;
		}
		HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
		for(int i = 0; i < str.length; i++) {
			if(map.containsKey(str[i])) {
				ArrayList<Integer> temp = map.get(str[i]);
				temp.add(i);
				map.put(str[i], new ArrayList<Integer>(temp));
			}
			else {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(i);
				map.put(str[i], new ArrayList<Integer>(temp));
			}
		}
		ArrayList<Integer> aList = new ArrayList<Integer>();
		ArrayList<Integer> bList = new ArrayList<Integer>();
		aList = map.get(a);
		bList = map.get(b);
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < aList.size(); i++) {
			for(int j = 0; j < bList.size(); j++) {
				min = Math.min(min, Math.abs(aList.get(i) - bList.get(j)));
			}
		}
		return min;
	}
	public static void main(String[] args) {
		String[] str = {"the","quick","brown", "fox", "quick"};
		shortestWordDistance helper = new shortestWordDistance();
		System.out.println("distance is : " + helper.findDistance(str, "fox", "the"));
		System.out.println("distance is : " + helper.findDistance(str, "quick", "fox"));
		System.out.println("distance is : " + helper.findDistance(str, "quick", "brown"));
	}
}


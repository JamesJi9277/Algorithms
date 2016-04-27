// Design and implement a TwoSum class. It should support the following operations: add and find.
//
// add - Add the number to an internal data structure.
// find - Find if there exists any pair of numbers which sum is equal to the value.
//
// For example,
// add(1); add(3); add(5);
// find(4) -> true
// find(7) -> false
public class TwoSum {
    List<Integer> res = new ArrayList<Integer>();
	public void add(int number) {
	    res.add(number);
	}

	public boolean find(int value) {
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for(int i = 0; i < res.size(); i++) {
	        if(map.containsKey(value - res.get(i))) {
	            return true;
	        }
	        else {
	            map.put(res.get(i), i);
	        }
	    }
	    return false;
	}
}


//second write
public class TwoSum {
    List<Integer> res = new ArrayList<Integer>();
	public void add(int number) {
	    res.add(number);
	}

	public boolean find(int value) {
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for(int i = 0; i < res.size(); i++) {
	        if(map.containsKey(value - res.get(i))) {
	            return true;
	        }
	        else {
	            map.put(res.get(i), 1);
	        }
	    }
	    return false;
	}
}

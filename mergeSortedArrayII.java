// Merge two given sorted integer array A and B into a new sorted integer array.

// Have you met this question in a real interview? Yes
// Example
// A=[1,2,3,4]

// B=[2,4,5,6]

// return [1,2,2,3,4,4,5,6]


class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        //ArrayList<Integer> res1 = new ArrayList<Integer>();
        if(A == null || B == null) {
        	return (A == null)? B:A;
        }
        int aSize = A.size();
        int bSize = B.size();
        while(aSize > 0 && bSize > 0) {
        	if(A.get(aSize - 1) >= B.get(bSize - 1)) {
        		res.add(0,A.get(aSize - 1));
        		aSize--;
        	}
        	else if(A.get(aSize - 1) < B.get(bSize - 1)) {
        		res.add(0,B.get(bSize - 1));
        		bSize--;
        	}
        }
        while(aSize > 0) {
        	res.add(0,A.get(aSize - 1));
        	aSize--;
        }while(bSize > 0){
        	res.add(0,B.get(bSize - 1));
        	bSize--;
        }
        return res;
    }
}

// Challenge
// How can you optimize your algorithm if one array is very large and the other is very small?
class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
        // write your code here
        int len = B.size();
        for (int i = 0; i < len; i++) 
            A.add(B.get(i));
        Collections.sort(A);
        return A;
    }
}

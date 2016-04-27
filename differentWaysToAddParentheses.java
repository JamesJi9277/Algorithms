// Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.


// Example 1
// Input: "2-1-1".

// ((2-1)-1) = 0
// (2-(1-1)) = 2
// Output: [0, 2]


// Example 2
// Input: "2*3-4*5"

// (2*(3-(4*5))) = -34
// ((2*3)-(4*5)) = -14
// ((2*(3-4))*5) = -10
// (2*((3-4)*5)) = -10
// (((2*3)-4)*5) = 10
// Output: [-34, -14, -10, -10, 10]
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new LinkedList<Integer>();
        for(int i = 0; i < input.length(); i++) {
        	if(input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '+') {
        		String part1 = input.substring(0, i);
        		String part2 = input.substring(i+1);
        		List<Integer> part1Res = diffWaysToCompute(part1);
        		List<Integer> part2Res = diffWaysToCompute(part2);
        		for(Integer p1 : part1Res) {
        			for(Integer p2 : part2Res) {
        				int c = 0;
        				switch(input.charAt(i)) {
        					case '+' : c = p1 + p2;
        					break;
        					case '-' : c = p1 - p2;
        					break;
        					case '*' : c = p1 * p2;
        					break;
        				}
        				res.add(c);
        			}
        		}
        	}
        }
        if(res.size() == 0) {
        	res.add(Integer.valueOf(input));
        }
        return res;
    }
}

public class Solution{
    public List<Integer> diffWaysToCompute(String input) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        ArrayList<Character> ops = new ArrayList<Character>();
        generateSymboles(nums, ops, input);
        return diffWaysUtill(ops, nums, 0, nums.size()-1);
    }
    public List<Integer> diffWaysUtill( List<Character> ops, List<Integer> nums, int numsBegin, int numsEnd){ 
        ArrayList<Integer> possibleNums = new ArrayList<Integer>();
        if(numsBegin == numsEnd){
            possibleNums.add(nums.get(numsBegin));
            return possibleNums;   
        }
        for(int i = numsBegin; i < numsEnd; ++i){
            List<Integer> leftSide = diffWaysUtill( ops, nums, numsBegin, i);
            List<Integer> rightSide = diffWaysUtill( ops, nums, i+1, numsEnd);
            char operation = ops.get(i);
            possibleNums.addAll( mergeListsWithOperation(leftSide, rightSide, operation) );
        }
        return possibleNums;
    }
    public void generateSymboles(ArrayList<Integer> nums, ArrayList<Character> ops, String input){
        TreeSet<Character> validOps = new TreeSet<Character>() {{ add('+'); add('-'); add('*'); }};
        int length = input.length();
        int start = 0;
        for(int i = 0; i < length; ++i){
            char c = input.charAt(i);
            if(validOps.contains(c)){
                ops.add(c);
                nums.add(Integer.parseInt(input.substring(start, i)) );
                start = i + 1;
            }
        }
        nums.add(Integer.parseInt(input.substring(start, length)));
    }
    public List<Integer> mergeListsWithOperation(List<Integer> leftSide, List<Integer> rightSide, char operation){
        int leftSize = leftSide.size();
        int rightSize = rightSide.size();
        List<Integer> merged = new ArrayList<Integer>(leftSize * rightSize);
        if(operation == '+')
            for(int i = 0; i < leftSize; ++i)
                for(int j = 0; j < rightSize; ++j)
                    merged.add(leftSide.get(i)+rightSide.get(j));
                else if(operation == '-') 
                    for(int i = 0; i < leftSize; ++i)
                        for(int j = 0; j < rightSize; ++j)
                            merged.add(leftSide.get(i)-rightSide.get(j));          
                        else
                            for(int i = 0; i < leftSize; ++i)
                                for(int j = 0; j < rightSize; ++j)
                                    merged.add(leftSide.get(i)*rightSide.get(j));          
                                return merged;
    }
}
// // Given a digit string, return all possible letter combinations that the number could represent.

// // A mapping of digit to letters (just like on the telephone buttons) is given below.
// Given "23"

// Return ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
//这一题要好好理解
public class Solution {
	public ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> res = new ArrayList<String>();
		StringBuffer sb = new StringBuffer();
		if(digits == null || digits.length() == 0) {
			return res;
		}
		findCombination(0, digits, sb, res);
		return res;
	}
	private void findCombination(int start, String digits, StringBuffer sb, ArrayList<String> res) {
		if(start == digits.length()) {
			res.add(new String(sb.toString()));
			return;
		}
		char ch = digits.charAt(start);
		String tmp = getNumbersFromChar(ch);
		for(int i = 0; i < tmp.length(); i++) {
			sb.append(tmp.charAt(i));
			findCombination(start + 1, digits, sb, res);
			sb.deleteCharAt(sb.length() - 1);
		}




        if(index == digits.length()&&sb.length() == digits.length()) {
            res.add(new String(sb));
            return;
        }
        for(int i = index; i < digits.length(); i++) {
            String crt = getString(digits.charAt(i));
            for(int j = 0; j < crt.length(); j++) {
            sb.append(crt.charAt(j));
            findCombination(digits, res, sb, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        }




	}
	private String getNumbersFromChar(char ch)
    {
        switch(ch)
        {
            case '1':
                return "";
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            case '0':
                return " ";
            default:
                return null;
        }
    }
}
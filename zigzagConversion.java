//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this
public class Solution{
	public String convert(String s, int nRows){
		if(s == null || s.length() == 0|| nRows <1)
			return "";
		if(nRows == 1)
			return s;
		StringBuilder res = new StringBuilder();
		int size = 2*nRows -2;
		for(int i =0;i<nRows;i++)
		{
			for(int j =i; j<s.length();j= j+size)
			{
				res.append(s.charAt(j));
				if(i!=0 && i!=nRows -1 && j+size -2*i < s.length())
					res.append(s.charAt(j+size -2*i));//记住这个公式， j+size -2*i
			}
		}
		return res.toString();
	}
}

//second write, bug free
public class Solution {
    public String convert(String s, int numRows) {
        if(s == null || s.length() == 0 || numRows < 1) {
            return "";
        }
        //一定要记住这个情况的考虑
        if(numRows == 1) {
            return s;
        }
        int size = 2 * numRows - 2;
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < numRows; i++) {
            for(int j = i; j < s.length(); j = j + size) {
                sb.append(s.charAt(j));
                if(i != 0 && i != numRows - 1 && j + size - 2 * i < s.length()) {
                    sb.append(s.charAt(j + size - 2 * i));
                }
            }
        }
        return sb.toString();
    }
}
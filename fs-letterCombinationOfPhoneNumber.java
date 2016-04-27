public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if(digits == null || digits.length() == 0) {
            return res;
        }
        StringBuffer sb = new StringBuffer();
        helper(0, digits, sb, res);
        return res;
    }
    
    private void helper(int index, String digits, StringBuffer sb, List<String> res) {
        //index是从0开始的，所以等于length代表已经遍历完了一个分支
        if(index == digits.length()) {
            //已经找到了一种情况,可以直接return
            res.add(new String(sb));
            return;
        }
        String temp = getNumber(digits.charAt(index));
        for(int i = 0; i < temp.length(); i++) {
            sb.append(temp.charAt(i));
            helper(index + 1, digits, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    private String getNumber(char ch)
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
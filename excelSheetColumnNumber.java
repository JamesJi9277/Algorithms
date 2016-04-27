	// Related to question Excel Sheet Column Title

// Given a column title as appear in an Excel sheet, return its corresponding column number.

// For example:

//     A -> 1
//     B -> 2
//     C -> 3
//     ...
//     Z -> 26
//     AA -> 27
//     AB -> 28 
//这题与SheetColumnTitle类似，都是考察的进制转换的问题，但是此题比较简单，思路也是类似
//注意设置一个每一位的权重，再得到数值后与权重相乘，再加到sum上
//再就是注意数值转换的优先级要高一些，所以可以直接像26行那样写
public class Solution {
    public int titleToNumber(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        char[] array = s.toCharArray();
        int res = 0;
        int weight = 1;
        for(int i = array.length - 1 ; i >= 0; i--) {
            res += (array[i] - 'A' + 1) * weight;
            weight *= 26;
        }
        return res;
    }
}
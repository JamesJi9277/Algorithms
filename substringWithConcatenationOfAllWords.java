// You are given a string, s, and a list of words, words, 
// that are all of the same length. Find all starting indices of substring(s) in s 
// that is a concatenation of each word in words exactly once and without any intervening characters.
//时间复杂度是O（n），空间复杂度是单词总共的长度 O（ml）
//在对于String的处理中，滑动窗口的方法使用的很频繁，要掌握
public class Solution{
    public ArrayList<Integer> findSubstring(String S, String[] L){
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(S == null || S.length() == 0 || L == null || L.length == 0)
            return res;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i =0;i < L.length; i++)
        {
            if(map.containsKey(L[i]))
                map.put(L[i], map.get(L[i])+1);
            else map.put(L[i],1);
        }
        for(int i =0; i<L[0].length();i++)
        {
            HashMap<String, Integer> curMap = new HashMap<String, Integer>();
            int count = 0;
            int left = i;
            for(int j =i; j<=S.length() - L[0].length(); j = j+L[0].length())
            {
                String str = S.substring(j, j+L[0].length());
                if(map.containsKey(str))
                {
                    if(curMap.containsKey(str))
                        curMap.put(str, curMap.get(str)+1);
                    else curMap.put(str, 1);
                    if(curMap.get(str) <= map.get(str))
                        count++;
                    else
                    {
                        while(curMap.get(str) > map.get(str))
                        {
                            String temp = S.substring(left, left+L[0].length());
                            if(curMap.containsKey(temp))
                            {
                                curMap.put(temp, curMap.get(temp)-1);
                                if(curMap.get(temp) < map.get(temp))
                                    count--;
                            }
                            left += L[0].length();
                        }
                    }
                    if(count == L.length)
                    {
                        res.add(left);
                        String temp = S.substring(left, left + L[0].length());
                        if(curMap.containsKey(temp))
                            curMap.put(temp, curMap.get(temp)-1);
                        count--;
                        left += L[0].length();
                    }
                }
                else
                {
                    curMap.clear();
                    count = 0;
                    left = j + L[0].length();
                }
            }
        }
        return res;
    }
}


//自己写的版本,correct but got TLE on OJ
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class substringOfContentation {
    public ArrayList<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(s == null || s.length() == 0 || words == null || words.length == 0) {
            return res;
        }
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        HashSet<Character> set = new HashSet<Character>();
        int blockLength = 0;
        for(int i = 0; i < words.length; i++) {
            if(!map.containsKey(words[i])) {
                map.put(words[i], 1);
            }
            else {
                map.put(words[i], map.get(words[i]) + 1);
            }
            blockLength = words[i].length();
            if(!set.contains(words[i].charAt(0))) {
                set.add(words[i].charAt(0));
            }
        }
        for(int i = 0; i <= s.length() - words.length * blockLength; i++) {
            if(set.contains(s.charAt(i))) {
                String temp = s.substring(i, words.length * blockLength + i );
                if(equals(temp, words, map)) {
                    res.add(i);
                }
                map.clear();
                for(int j = 0; j < words.length; j++) {
                    if(!map.containsKey(words[j])) {
                        map.put(words[j], 1);
                    }
                    else {
                        map.put(words[j], map.get(words[j]) + 1);
                    }
                }
            }
        }
        return res;
    }
    private boolean equals(String s, String[] words, HashMap<String, Integer> map) {
        int length = words[0].length();
        for(int i = 0; i < s.length(); i += length) {
            String temp = s.substring(i, i + length);
            if(!map.containsKey(temp)) {
                return false;
            }
            else{
                if(map.get(temp) < 0) {
                    return false;
                }
                else {
                    map.put(temp, map.get(temp) - 1);
                }
            }
        }
        for(int i = 0; i < words.length; i++) {
            if(map.get(words[i]) != 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        substringOfContentation s = new substringOfContentation();
        String S = "abababababababababababababababababababababababab";
        String[] words = {"ab"};
        System.out.println("The result is : " + s.findSubstring(S, words));
    }
}



public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<Integer>();

        // -------------------- Corner Case -------------------------- //
        if( (s == null || s.length() == 0) && (words == null || words.length == 0) ){
            result.add(0);
            return result;
        }
        if( (s != null && s.length() != 0) && (words == null || words.length == 0) ){
            result.add(0);
            return result;
        }
        if( (s == null || s.length() == 0) && (words != null && words.length != 0) ){
            return result;
        }
        // -------------------- Corner Case -------------------------- //
        
        int length1 = s.length();
        int length2 = words.length;
        int length3 = words[0].length(); // length of each word

        // map1存储words以及出现的次数，相当于一个词库
        HashMap<String, Integer> map1 = new HashMap<String, Integer>();
        for(int i = 0; i < length2; i++){
            if( map1.containsKey(words[i]) ){
                map1.put(words[i], map1.get(words[i]) + 1);
            }else{
                map1.put(words[i], 1);
            }
        }
        // 用sliding window的方法来解题
        int windowStart = 0;
        int windowEnd = 0;

        // 注意外层循环，只需要循环每个word的长度那么多次即可！！！
        
        for(int i = 0; i < length3; i++){
            windowStart = i;
            //count totoal qualified words so far
            int count = 0; 
            // 这个map2用于存储扫描字符串时, 针对一个有效window, 已经扫到了哪些相关的字符串，以及他们出现的次数。
            HashMap<String, Integer> map2 = new HashMap<String, Integer>();
            for(int j = i; j +  length3 <= length1; j = j + length3){
                windowEnd = j + length3;
                String curWord = s.substring(j, windowEnd);
                if( map1.containsKey(curWord) ){
                    if( map2.containsKey(curWord) ){
                        map2.put( curWord, map2.get(curWord)+1 );
                    }else{
                        map2.put(curWord,1);
                    }
                    count++;
                    // 这一步骤是说，如果当前出现的curWord的出现使得已经大于了词库中该word的出现情况，
                    // 那就要开始收缩window
                    // 根据左起点 windowStart 收缩滑块，直到收缩到与当前单词相同的字符串片段，将其剔除之后，滑块的收缩工作完成
                    // 这一步跟longest substring without duplicate character那个题目很像。
                    // 举例比如 abc def ghi jkl ghi abc def lmn, 词库为abc def ghi jkl lmn
                    // 当遍历到第二组ghi时因为它一定是多余的，因此前面的abc def ghi jkl一定不会是答案，因此要将他们剔除。
                    // 从新从jkl ghi abc def lmn开始算作一个有效的答案。
                    while(map2.get(curWord) > map1.get(curWord) ){
                        String temp = s.substring(windowStart, windowStart+length3);
                        map2.put(temp, map2.get(temp)-1);
                        count--;
                        windowStart = windowStart + length3;
                    }
                    // 说明一个有效的窗口形成了。
                    if( count == length2 ){
                        result.add(windowStart); // 加入window起始的index
                        //shift right and reset map2, count & start point         
                        String temp = s.substring(windowStart, windowStart+length3);
                        map2.put(temp, map2.get(temp)-1);
                        count--;
                        windowStart = windowStart + length3;
                    }

                }else{
                    // 说明出现了不在词库中的word, 那么这一次扫描window无效，所以map2清空，准备下一次
                    map2.clear();
                    count = 0; // 复位准备下一次统计
                    // 注意这里windowStart是有在更新移动的！！！
                    windowStart = j + length3;
                }
            }
        }
        return result;
    }
}

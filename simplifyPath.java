//Given an absolute path for a file (Unix-style), simplify it.
// For example,
// path = "/home/", => "/home"
// path = "/a/./b/../../c/", => "/c"
// Corner Case: path = "/../"?
// In this case, you should return "/".
// Another corner case is the path might contain multiple slashes '/' together, 
// such as "/home//foo/".
// In this case, you should ignore redundant slashes and return "/home/foo".
// 这道题目是Linux内核中比较常见的一个操作，就是对一个输入的文件路径进行简化。
// 思路比较明确，就是维护一个栈，对于每一个块（以‘/’作为分界）进行分析，
// 如果遇到‘../’则表示要上一层，那么就是进行出栈操作，
// 如果遇到‘./’则是停留当前，直接跳过，其他文件路径则直接进栈即可。
// 最后根据栈中的内容转换成路径即可（这里是把栈转成数组，然后依次添加）。
// 时间上不会超过两次扫描（一次是进栈得到简化路径，一次是出栈获得最后结果），
// 所以时间复杂度是O(n)，空间上是栈的大小，也是O(n)。

public class Solution {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0) {
            return path;
        }
        String[] paths = path.split("/");
        List<String> list = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        sb.append("/");
        for(int i = 0; i < paths.length; i++) {
            if(paths[i].equals(".") || paths[i].equals("")) {
                continue;
            }
            else if(paths[i].equals("..")) {
                if(list.size() > 0) {
                    list.remove(list.size() - 1);
                }
            }
            else {
                list.add(paths[i]);
            }
        }
        for(int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if(i != list.size() - 1) {
                sb.append("/");
            }
        }
        return sb.toString();
    }
}


















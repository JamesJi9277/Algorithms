// Compare two version numbers version1 and version2.
// If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

// You may assume that the version strings are non-empty and contain only digits and the . character.
// The . character does not represent a decimal point and is used to separate number sequences.
// For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

// Here is an example of version numbers ordering:

// 0.1 < 1.1 < 1.2 < 13.37
// The tricky part of the problem is to handle cases like 1.0 and 1. 
// They should be equal.
//补充，Java 正则表达式的特殊字符。
// 特别字符

// 说明

// $

// 匹配输入字符串的结尾位置。如果设置了 RegExp 对象的 Multiline 属性，则 $ 也匹配 ‘\n' 或‘\r'。要匹配 $ 字符本身，请使用 \$。

// ( )

// 标记一个子表达式的开始和结束位置。子表达式可以获取供以后使用。要匹配这些字符，请使用 \( 和 \)。

// *

// 匹配前面的子表达式零次或多次。要匹配 * 字符，请使用 \*。

// +

// 匹配前面的子表达式一次或多次。要匹配 + 字符，请使用 \+。

// .

// 匹配除换行符 \n之外的任何单字符。要匹配 .，请使用 \。

// [ ]

// 标记一个中括号表达式的开始。要匹配 [，请使用 \[。

// ?

// 匹配前面的子表达式零次或一次，或指明一个非贪婪限定符。要匹配 ? 字符，请使用 \?。

// \

// 将下一个字符标记为或特殊字符、或原义字符、或向后引用、或八进制转义符。例如， ‘n' 匹配字符 ‘n'。'\n' 匹配换行符。序列 ‘\\' 匹配 “\”，而 ‘\(' 则匹配 “(”。

// ^

// 匹配输入字符串的开始位置，除非在方括号表达式中使用，此时它表示不接受该字符集合。要匹配 ^ 字符本身，请使用 \^。

// { }

// 标记限定符表达式的开始。要匹配 {，请使用 \{。

// |

// 指明两项之间的一个选择。要匹配 |，请使用 \|。



public class Solution {
    public int compareVersion(String version1, String version2) {
        if(version1 == null || version2 == null) {
            return 0;
        }
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int index1 = 0;
        int index2 = 0;
        while(index1 < v1.length && index2 < v2.length) {
            if(Integer.parseInt(v1[index1]) == Integer.parseInt(v2[index2])) {
                index1++;
                index2++;
            }
            else if(Integer.parseInt(v1[index1]) > Integer.parseInt(v2[index2])) {
                return 1;
            }
            else if(Integer.parseInt(v1[index1]) < Integer.parseInt(v2[index2])) {
                return -1;
            }
        }
        if(index1 == v1.length && index2 == v2.length) {
            return 0;
        }
        else if(index1 < v1.length) {
            while(index1 < v1.length && Integer.parseInt(v1[index1]) == 0) {
                index1++;
            }
            if(index1 == v1.length) {
                return 0;
            }
            else {
                return 1;
            }
        }
        else  {
            while(index2 < v2.length && Integer.parseInt(v2[index2]) == 0) {
                index2++;
            }
            if(index2 == v2.length) {
                return 0;
            }
            else {
                return -1;
            }
        }
    }
}
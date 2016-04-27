// Given a positive integer, return its corresponding column title as appear in an Excel sheet.
// For example:

//     1 -> A
//     2 -> B
//     3 -> C
//     ...
//     26 -> Z
//     27 -> AA
//     28 -> AB 
public class Solution{
	public String convertToTitle(int n){
		StringBuffer res = new StringBuffer();
		if(n <= 0)
			return res.toString();
		while(n >0)
		{
			int k = n%26;
			n = n/26;
			if(k == 0)
			{
				res.insert(0,'Z');
				n--;
			}
			else
				res.insert(0, (char)(k-1+'A'));//数值的优先级高，所以相加后是ASCII，然后再将ASC转变成char
		}
		return res.toString();
	}
}

//两个在OJ memory limit exceed版本
import java.util.HashMap;

public class convertTitle {
    public String convertToTitle(int n) {
        if(n < 1) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
//        HashMap<Integer, String> map = new HashMap<Integer, String>();
//        map.put(1,"A");map.put(5,"E");map.put(9,"I");map.put(13,"M");map.put(17,"Q");map.put(21,"U");map.put(25,"Y");
//        map.put(2,"B");map.put(6,"F");map.put(10,"J");map.put(14,"N");map.put(18,"R");map.put(22,"V");map.put(26,"Z");
//        map.put(3,"C");map.put(7,"G");map.put(11,"K");map.put(15,"O");map.put(19,"S");map.put(23,"W");
//        map.put(4,"D");map.put(8,"H");map.put(12,"L");map.put(16,"P");map.put(20,"T");map.put(24,"X");
//        if(n <= 26) {
//            sb.append(map.get(n));
//            return sb.toString();
//        }
//        int rem = n % 26;
//        int count = n / 26;
//        for(int i = 0; i < count; i++) {
//            sb.append("A");
//        }
//        sb.append(map.get(rem));
//        return sb.toString();
        if(n <= 26) {
            sb.append((char)(n + 64) + "");
            return sb.toString();
        }
        int rem = n % 26;
        int count = n / 26;
        for(int i = 0; i < count; i++) {
            sb.append("A");
        }
        sb.append((char)(rem + 64) + "");
        return sb.toString();
    }
    public static void main(String[] args) {
    	convertTitle c = new convertTitle();
    	int m = 54;
    	System.out.print("The result is : " + c.convertToTitle(m));
    }
}
// All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, 
// for example: "ACGAATTCCG". When studying DNA, 
// 	it is sometimes useful to identify repeated sequences within the DNA.

// Write a function to find all the 10-letter-long sequences (substrings) 
// that occur more than once in a DNA molecule.

// 首先考虑到用hash，但是时间复杂度是O(n^2)，空间复杂度是On，并且如果序列特别长而且不重复的话，会存在Hash爆掉的情况出现memory limit exceeded
//所以考虑到bit manipulation,不过hash这个方法还是要知道的比较好
public class Solution1{
	public List<String> findRepeatedDnaSequences(String s){
		List<String> res = new ArrayList<String>();
		if(s == null || s.length() == 0)
			return res;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i =0; i< s.length() -9;i++)
		{
			StringBuffer temp = new StringBuffer();
			for(int j = 0; j< 10;j++)
				temp.append(s.charAt(i+j));
			if(map.containsKey(temp.toString()))
				res.add(temp.toString());
			else
				map.put(temp.toString(),1);
		}
		return res;
	}
}

//coding 
public class Solution{
	public List<String> findRepeatedDnaSequences(String s){
		HashSet<Integer> hash = new HashSet<Integer>();
		HashSet<String> dna = new HashSet<String>();
		for(int i =9; i< s.length(); i++)
		{
			String subString = s.subString(i-9, i+1);
			int encoded = encode(subString);
			if(hash.contains(encoded))
				dna.add(subString);
			else
				hash.add(encoded);
		}
		List<String> result = new ArrayList<String>();
		for(String d: dna)
			result.add(d);
		return result;
	}
	private int encode(String s){
		int sum = 0;
		for(int i =0; i< s.length();i++)
		{
			if(s.charAt(i) == 'A')
				sum = sum*4;
			else if(s.charAt(i) == 'C')
				sum = sum*4 +1;
			else if(s.charAt(i) == 'G')
				sum = sum*4 +2;
			else sum = sum*4 +3;
		}
		return sum;
	}
}


//bit manipulation
//假如s为 “AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT”， 则第一个子串为AAAAACCCCC，下一个子串是AAAACCCCCA，我们可以发现
//每次下一个子串对应的整数表示应该是上一个整数表示左移2位后在加上新的子串的最后一个字母的二进制表示。

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
  		HashMap<Integer,Integer> repeatHash = new HashMap<Integer,Integer>(); 
  		HashMap<Integer,Integer> addedHash = new HashMap<Integer,Integer>();     
  		List<String> repeatList = new ArrayList<String>();
  		HashMap<Character,Integer> encoding = new HashMap<Character,Integer>(); //用于存储字符的二进制编码
  		encoding.put('A',0); 
  		encoding.put('C',1);
  		encoding.put('G',2);
  		encoding.put('T',3);
  		if(s.length()==0||s.length()<10)
  			return repeatList;
  		int length = s.length();
  		int iMax = length - 10;
  		int binaryRepresent = 0; // 这是每个子串对应的20-bits的二进制表示, 注意本身int是32bits
  		for(int i = 0; i<=iMax;i++){
  			if(i==0)
  			{
  				String subStr = s.substring(i,i+10);
  				int subLength = subStr.length();
  				for(int j = 0; j<subLength;j++)
  					binaryRepresent = (binaryRepresent<<2) + encoding.get(subStr.charAt(j));
  				repeatHash.put(binaryRepresent,1);
  			}
  			else
  			{	
  				//当确定了一个新的substring后, 我们希望能够利用上一个substring对应的二进制表示,因此我们需要先左移2位, 由于20位左移2位后还是在有效的32bit内，
  				//而我们希望始终维护一个20位的概念因此，我们需要让20位以后的那些位始终都为0需要一个mask即0x000fffff
  				String subStr = s.substring(i,i+10);
  				binaryRepresent = ( (binaryRepresent<<2) + encoding.get(subStr.charAt(9)) ) &  ( (1<<20) - 1 ); // 这个 ( (1<<20) - 1 )即0x000fffff
  				if(repeatHash.containsKey(binaryRepresent)&&!addedHash.containsKey(binaryRepresent))
  				{
  					repeatList.add(subStr);
  					addedHash.put(binaryRepresent,1);
  				}
  				else
  					repeatHash.put(binaryRepresent,1);
  			}
  		}
		return repeatList;
    }
}







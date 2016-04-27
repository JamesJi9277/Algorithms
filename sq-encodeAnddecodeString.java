public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();
        if(strs == null || strs.size() == 0) {
        	return sb.toString();
        }
        for(String s : strs) {
        	sb.append(s.length());
        	sb.append("/");
        	sb.append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() == 0) {
        	return res;
        }
        int i = 0;
        while(i < s.length()) {
        	int slash = s.indexOf("/", i);
        	int size = Integer.parseInt(s.substring(i, slash));
        	res.add(s.substring(slash + 1, slash + size + 1));
        	i = slash + size + 1;
        }
        return res;
    }
}
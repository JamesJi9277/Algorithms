public class Solution {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0) {
        	return new String();
        }
        ArrayList<String> res = new ArrayList<String>();
        String[] paths = path.split("/");
        StringBuffer sb = new StringBuffer("/");
        for(String s : paths) {
        	if(s.equals("..")) {
        		if(res.size() > 0) {
        			res.remove(res.size() - 1);
        		}
        	}
        	else if(s.equals("") || s.equals(".")) {
        		continue;
        	}
        	else {
        		res.add(s);
        	}
        }
        for(int i = 0; i < res.size(); i++) {
        	if(i == res.size() - 1) {
        		sb.append(res.get(i));
        	}
        	else {
        		sb.append(res.get(i));
        		sb.append("/");
        	}
        }
        return sb.toString();
    }
}
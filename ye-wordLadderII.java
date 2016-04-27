public class Solution {
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		List<List<String>> res = new ArrayList<List<String>>();
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		HashMap<String, Integer> distance = new HashMap<String, Integer>();
		dict.add(start);
		dict.add(end);
		doBFS(map, distance, start, end, dict);
		List<String> path = new ArrayList<String>();
		doDFS(res, path, end, start, distance, map);
		return res;
	}
	private void doDFS(List<List<String>> res, List<String> path, String crt, String start, HashMap<String, Integer> distance, HashMap<String, List<String>> map) {
		path.add(crt);
		//反向相加
		if(crt.equals(start)) {
			Collections.reverse(path);
			res.add(new ArrayList<String>(path));
			Collections.reverse(path);
		}
		else {
			for(String next : map.get(crt)) {
				if(distance.containsKey(next) && distance.get(crt) == distance.get(next) + 1) {
					doDFS(res, path, next, start, distance, map);
				}
			}
		}
		path.remove(path.size() - 1);
	}
	private void doBFS(HashMap<String, List<String>> map, HashMap<String, Integer> distance, String start, String end, Set<String> dict) {
		Queue<String> queue = new LinkedList<String>();
		queue.offer(start);
		distance.put(start, 0);
		for(String s : dict) {
			map.put(s, new ArrayList<String>());
		}
		while(!queue.isEmpty()) {
			String crt = queue.poll();
			List<String> nextList = expand(crt, dict);
			for(String next : nextList) {
				map.get(next).add(crt);
				if(!distance.containsKey(next)) {
					distance.put(next, distance.get(crt) + 1);
					queue.offer(next);
				}
			}
		}
	}
	private List<String> expand(String crt, Set<String> dict) {
		List<String> expansion = new ArrayList<String>();
		for(int i = 0; i < crt.length(); i++) {
			for(char c = 'a'; c <= 'z'; c++) {
				if(c != crt.charAt(i)) {
					String expanded = crt.substring(0, i) + c + crt.substring(i + 1);
					if(dict.contains(expanded)) {
						expansion.add(expanded);
					}
				}
			}
		}
		return expansion;
	}
}
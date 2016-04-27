*Direction*|*Condition*|*Action*
1->2       |not(" or ,)|Append character to buffer
1->3       |"          |Nothing
2->2       |not ,      |append character to field
1|2|4->1   |,          |Output complete field and create buffer for next field
3->3       |not "      |Append character to buffer
3->4       |"          |Nothing

public class Solution {
	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("example.csv"));
			String s = "";
			ArrayList<String> res = new ArrayList<String>();
			while((s = reader.nextLine()) != null) {
				helper(res, s);
			}
		}
		throw Exception e {
			e.printStackTrace();
		}
	}
	private void helper(ArrayList<String> res, String line) {
		if(line == null || line.length() == 0) {
			return;
		}
		StringBuffer sb = new StringBuffer();
		for(Character c : line) {
			switch(state) {
				case ParseState.Initial:
				switch(c) {
					case QUOTE :
						state = ParseState.withDoubleQuote;
						break;
					
					case COMMA :
						state = ParseState.Initial;
						break;
					
					default:
					sb.append(c);
					state = ParseState.withoutDoubleQuote;
					break;
				}
				break;

				case ParseState.withoutDoubleQuote:
				switch(c) {
					case COMMA :
						state = ParseState.Initial;
						break;
					default:
					sb.append(c);
					break;
				}

				case ParseState.withDoubleQuote:
				switch(c) {
					case QUOTE:
						state = ParseState.endOfDoubleQuote;
						break;
					//已经有一对双影号了，所以主要还没有读到下一个的话，我就全部append					
					default:
					sb.append(c);
					break;
				}

				case ParseState.endOfDoubleQuote:
				switch(c) {
					case COMMA :
						state = ParseState.Initial;
						break;
					
					default:
					break;
				}
				break;
			}
		}
		res.add(sb.toString());
	}
}
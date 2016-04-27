public class print {
	public void printWithComma(int num) {
		StringBuffer sb = new StringBuffer();
		int count = 0;
		while(num > 0) {
			int digit = num % 10;
			if((sb.length() - count) % 3 != 0) {
				sb.append(digit + "");
			}
			else if((sb.length() - count) % 3 == 0){
				if(sb.length() != 0) {
					sb.append(",");
					count++;
				}
				sb.append(digit + "");
			}
			num /= 10;
		}
		int start = 0;
		int end = sb.length() - 1;
		for(int i = 0; start + i < end - i; i++) {
			char temp = sb.charAt(start + i);
			sb.setCharAt(start + i, sb.charAt(end - i));
			sb.setCharAt(end - i, temp);
		}
		System.out.println(sb.toString());
	}
	public static void main(String[] args) {
		print p = new print();
		p.printWithComma(10009999);
	}
}

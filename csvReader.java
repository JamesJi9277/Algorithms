public class test {
	public static void main(String[] args) {
		try{
			BufferedReader reader = new BufferedReader(new FileReader("a.csv"))//换成文件名
			reader.readLine();//第一行信息，为标题信息，不用，如果需要，注释掉
			String s = null;
			while((s = reader.readLine()) != null) {
				String[] str = line.split(",");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
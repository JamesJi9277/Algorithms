public class Solution {
	public void setBoard(int[][] board, int bomb) {
		Random r = new Random();
		if(board == null || board.length == 0 || board[0].length == 0) {
			return;
		}
		int row = board.length;
		int col = board[0].length;
		for(int i = 0; i < bomb; i++) {
			int k = r.nextInt() % (row * col);
			int x = k / col;
			int y = k % col;
			set(board, x, y);
		}
		return;
	}
	private void set(int[][] board, int x, int y) {
		//将周围的格子全部加1
	}
}
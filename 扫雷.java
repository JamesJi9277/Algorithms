地图一般为矩形，用一个a*b的矩形表示
/**
* 20 标志该位置为地雷
* <=10的数字表示未翻开的方块及周围的地雷数目
* >=10的数字表示已翻开的方块及周围的地雷数目
**/
class gameLogic {
	private static final int row = 8;
	private static final int col = 8;
	private static final int target = 20;
	private static final int initialBombNum = 15;
	private int[][] board;
	private Random random; //用来指定哪些地方放地雷
	private int bombNum = 0;//统计地雷总数
	private boolean isOver;
	//接下里就是初始化地图，地图上首先要放一个雷，放完了之后遍历一次地图
	//初始化数组，生成地图
	public void initialMap() {
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				board[i][j] = 0;
			}
		}
		randomMap();
		//如果这个地方不是雷，那么被点开之后，这里会显示其周围雷的个数
		countBomb();
		bombNum = getBomb();
	}
	//统计地雷总数
	private int getBomb() {
		int count = 0;
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(board[i][j] == target) {
					count++;
				}
			}
		}
		return count;
	}
	//随机安排地雷位置
	private void randomMap() {
		int i,j,k;
		for(int r = 0; r < initialBombNum; r++) {
			k = java.lang.Math.abs(random.nextInt()) % (row * col);
			i = k / col;
			j = k % col;
			this.board[i][j] = target;
		}
	}
	//统计棋盘上的数据
	private void countBomb() {
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				int count = 0;
				//当需要检测的单元格本身无泪的情况下，统计周围的地雷哥舒
				if(board[i][j] != target) {
					//左上
					if((i - 1 >= 0) && (j - 1 >= 0)) {
						if(board[i - 1][j - 1] == target) {
							count++;
						}
					}
					//上
					if(i - 1 >= 0) {
						if(board[i - 1][j] == target) {
							count++;
						}
					}
					//右上
					if((i - 1 >= 0) && (j + 1 < col)) {
						if(board[i - 1][j + 1] == target) {
							count++;
						}
					}
					//左边
					if(j - 1 >= 0) {
						if(board[i][j - 1] == target) {
							count++;
						}
					}
					//右边
					if(i >= 0 && j + 1 < col) {
						if(board[i][j + 1] == target) {
							count++;
						}
					}
					//左下
					if(i + 1 < row && j - 1 >= 0) {
						if(board[i + 1][j - 1] == target) {
							count++;
						}
					}
					//下
					if(i + 1 < row) {
						if(board[i + 1][j] == target) {
							count++;
						}
					}
					//右下
					if(i + 1 < row && j + 1 < col) {
						if(board[i + 1][j + 1] == target) {
							count++;
						}
					}
					board[i][j] == count;
				}
			}
		}
	}
	//检测已经被揭开的位置总和
	private int countOpen() {
		int count = 0;
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				//因为按照定义，如果被揭开了将会+10
				if(board[i][j] < target && board[i][j] > 9) {
					count++;
				}
			}
		}
		return count;
	}
	//检测是否胜利
	public boolean isWin() {
		if(bombNum + countOpen == row * col) {
			this.isOver = true;
			return true;
		}
		return false;
	}
	//选中棋盘上的位置，并翻开
	public void open(int matrix) {
		int temp = getBomb(matrix);
		if(temp == 20) {
			setGameOver();
			break;
		}
		else if(temp == 0) {
			isNull(matrix);//当前选中的为空，则翻开周围的
			break;
		}
		else {
			this.isNotNull(matrix);//否则，翻开当前位置，并做标记
		}
	}
	private void isNull(int matrix) {
		int i,j;
		i = matrix / 8;
		j = matrix % 8;
		if(board[i][j] < 9) {
			board[i][j] += 10;
		}
		//检查左上是否为空
		if(i - 1 >= 0 && j - 1 >= 0) {
			if(board[i - 1][j - 1] == 0) {
				isNull((i - 1) * 8 + j - 1);
			}
			if(board[i - 1][j - 1] < 9) {
				board[i - 1][j - 1] += 10;
			}
		}
		if ( (i - 1 >= 0)) { // 检测上方空格是否为空
    　　　　if (pan[i - 1][j] == 0) {
    　　　　　　isNull( (i - 1) * 8 + j);
    　　　　}
    　　　　if (pan[i - 1][j] < 9) {
    　　　　　　pan[i - 1][j] += 10;
    　　　　}
    　　}
    if ( (i - 1 >= 0) && (j + 1 <= 7)) { // 检测右上方是否为空
231 　　　　if (pan[i - 1][j + 1] == 0) {
232 　　　　　　isNull( (i - 1) * 8 + (j + 1));
233 　　　　}
234 　　　　if (pan[i - 1][j + 1] < 9) {
235 　　　　　　pan[i - 1][j + 1] += 10;
236 　　　　}
237 　　}
238 
239 　　if ( (j - 1 >= 0)) { // 检测左边是否为空
240 　　　　if (pan[i][j - 1] == 0) {
241 　　　　　　isNull(i * 8 + (j - 1));
242 　　　　}
243 　　　　if (pan[i][j - 1] < 9) {
244 　　　　　　pan[i][j - 1] += 10;
245 　　　　}
246 　　}
247 
248 　　if ( (i >= 0) && (j + 1 <= 7)) { // 右边
249 　　　　if (pan[i][j + 1] == 0) {
250 　　　　　　isNull(i * 8 + (j + 1));
251 　　　　}
252 　　　　if (pan[i][j + 1] < 9) {
253 　　　　　　pan[i][j + 1] += 10;
254 　　　　}
255 　　}
256 
257 　　if ( (j - 1 >= 0) && (i + 1 <= 7)) { // 左下
258 　　　　if (pan[i + 1][j - 1] == 0) {
259 　　　　　　isNull( (i + 1) * 8 + (j - 1));
260 　　　　}
261 　　　　if (pan[i + 1][j - 1] < 9) {
262 　　　　　　pan[i + 1][j - 1] += 10;
263 　　　　}
264 　　}
265 
266 　　if ( (i + 1 <= 7)) { // 下
267 　　　　if (pan[i + 1][j] == 0) {
268 　　　　　　isNull( (i + 1) * 8 + j);
269 　　　　}
270 　　　　if (pan[i + 1][j] < 9) {
271 　　　　　　pan[i + 1][j] += 10;
272 　　　　}
273 　　}
274 
275 　　if ( (j + 1 <= 7) && (i + 1 <= 7)) { // 右下
276 　　　　if (pan[i + 1][j + 1] == 0) {
277 　　　　　　isNull( (i + 1) * 8 + (j + 1));
278 　　　　}
279 　　　　if (pan[i + 1][j + 1] < 9) {
280 　　　　　　pan[i + 1][j + 1] += 10;
281 　　　　}
282 　　}
283 }
	}
	//选中棋盘上的位置，并翻开当前的位置
	private void isNotNull(int matrix) {
		int i, int j;
		i = matrix / col;
		j = matrix % col;
		board[i][j] += 10;
	}
	//取得指定位置的数据
	private int getBomb(int matrix) {
		int i = matrix / col;
		int j = matrix % col;
		return this.board[i][j];
	}
	//检测游戏是否结束
	private boolean isGameOver() {
		return gameOver;
	}
	//设置游戏结束
	private boolean setGameOver() {
		isGameOver = true;
	}
	//新开局
	public void setNew() {
		this.isGameOver = false;
	}
	//指定位置是否被揭开
	public boolean isFree(int matrix) {
		int i = matrix / col;
		int j = matrix % col;
		return board[i][j] < 8 || board[i][j] == 20;
	}
}
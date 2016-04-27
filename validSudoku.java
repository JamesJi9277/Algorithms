// Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

// The Sudoku board could be partially filled, 
// where empty cells are filled with the character '.'.
//注意数独的定义，分九个格子··而不是每一个小方块都要检查，
//剩下的就是对于每一个block找规律
// block       i     j
// 0           0    0
// 1           0    3
// 2           0    6
// 3           3    0
// 4           3    3
// 5           3    6
// 6           6    0
// 7           6    3
// 8           6    6
public class Solution{
	public boolean isValidSudoku(char[][] board){
		if(board == null || board.length != 9 || board[0].length != 9)
			return false;
		for(int i =0; i < board.length;i++)
		{
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			for(int j =0; j< board[0].length; j++)
			{
				if(board[i][j] == '.')
					continue;
				if(map.containsKey(board[i][j]))
					return false;
				else
					map.put(board[i][j],1);
			}
		}
		//因为这里用i定义的列，j定义的行，所以说board要写成ji而不是ij
		for(int i =0; i < board[0].length;i++)
		{
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			for(int j =0; j< board.length; j++)
			{
				if(board[j][i] == '.')
					continue;
				if(map.containsKey(board[j][i]))
					return false;
				else
					map.put(board[j][i],1);
			}
		}
		for(int block = 0; block < 9; block++)
		{
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			for(int i = block/3*3; i< block/3*3 +3; i++)
			{
				for(int j = (block%3)*3; j<(block%3)*3 +3; j++)
				{
					if(board[i][j] == '.')
						continue;
				    if(map.containsKey(board[i][j]))
						return false;
					else map.put(board[i][j], 1);
				}
			}
		}
		return true;
	}
}
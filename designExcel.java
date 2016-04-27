design an Excel sheet data structure
You need to perform operations like addition
Index for a cel is known and the excel sheet is very sparse and is used to store numbers in the range 1-65K


//http://www.careercup.com/question?id=14949056
//https://www.quora.com/How-would-you-design-a-software-like-Microsoft-Excel-Basically-the-interviewer-wanted-to-know-how-I-would-store-the-cells-and-the-relationship-between-cells-For-examples-let-there-be-4-cells-A1-B1-C1-and-D1-Let-values-of-the-cells-be-followin
//首先想到的是我们能够用哪些数据结构来表示grid
// 2D matrix, array of linkedlist, graph linkedlist, hashmap with hashmap
/*
1.setValue是给定col,row与value，将指定的grid上值变为value，可以是setValue或者modifyValue
2.getValue是给定row与col，返回对应grid上的值
3.利用HashMap来加快查找速度，HashMap<rowNum, HashMap<colNum, String>>
4.insert a new row to table
5.insert a new column to table
6.delete an existing column
7.delete an existing row
8.indirectly set one grid, the data in this grid depends on other grid, when other grid's value changed, the value in this grid should also change
*/
class SpreadSheet {
	private static final int MAX_CELL_INDEX = 65000;
	private final Map<Integer, Map<Integer, String>> data = new Map<Integer, Map<Integer, String>>();

	public void setValue(int row, int column, String value) {
		if(!checkRowAndColumnIndex(row, column)) {
			return;
		}
		Map<Integer, String> columnMap = data.get(row);
		if(columnMap == null) {
			columnMap = new HashMap<>();
			data.put(row, columnMap);
		}
		columnMap.put(column, value);
	}

	public String getValue(int row, int column) {
		if(!checkRowAndColumnIndex(row, column)) {
			return;
		}
		Map<Integer, String> columnMap = data.get(row);
		if(columnMap != null) {
			return columnMap.get(column);
		}
		return "";
	}

	private boolean checkRowAndColumnIndex(int row, int column) {
		if(row < 1 || row > MAX_CELL_INDEX || colNum < 1 || column > MAX_CELL_INDEX) {
			return false;
		}
		return true;
	}

	public void addNewRow() {
		int size = data.size();
		Map<Integer, String> newCol = new HashMap<Integer, String>();
		data.put(size + 1, newCol);
	}

	public void addNewCol() {
		for(Integer i : data.keySet()) {
			HashMap curCol = data.get(i);
			int size = curCol.size();
			curCol.put(size + 1, new String());
			data.put(i, curCol);
		}
	}

	public void deleteRow(int row) {
		if(row < 1 || row > MAX_CELL_INDEX){
			return;
		}
		for(Integer i : data.keySet()) {
			if(i < row) {
				continue;
			}
			if(i > row) {
				Map<Integer, String> curRow = data.get(i);
				data.put(i - 1, curRow);
			}
			if(i == data.size()) {
				data.put(i, new Map<Integer, String>());
			}
		}
	}

	public void deleteCol(int col) {
		if(col < 1 || col > MAX_CELL_INDEX) {
			return;
		}
		for(Integer i : data.keySet()) {
			Map<Integer, String> curCol = data.get(i);
			for(Integer j : curCol.keySet()) {
				if(j == curCol.size()) {
					curCol.put(j, new String());
				}
			}
		}
	}
}
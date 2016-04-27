public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> record=new ArrayList<Integer>();
    if(matrix.length==0)return record;
    int m=matrix.length;
    int n=matrix[0].length;
    int col=n;
    int lrow=0;
    int row=m;
    int lcol=0;
    int count=0;
    while(true){
        for(int i=lcol;i<col;i++)
        {
            record.add(matrix[lrow][i]);
            count++;
            if(count==m*n)return record;
        }
        lrow++;
        for(int i=lrow;i<row;i++)
        {
            record.add(matrix[i][col-1]);
            count++;
            if(count==m*n)return record;
        }
        col--;
        for(int i=col-1;i>=lcol;i--)
        {
            record.add(matrix[row-1][i]);
            count++;
            if(count==m*n)return record;
        }
        row--;
        for(int i=row-1;i>=lrow;i--)
        {
            record.add(matrix[i][lcol]);
            count++;
            if(count==m*n)return record;
        }
        lcol++;

    }

}

    }

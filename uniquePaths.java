
//记录一个状态矩阵，时间复杂度O（n^2）空间复杂度O（mn）
public class Solution2 {
    public int uniquePaths(int m, int n) {
        if(m <= 0|| n <= 0)
        return 0;
        int[][] res = new int[m][n];//这里的说的是有m行n列，而不是说下标从1开始来计算的
        for(int i =0;i<m;i++)
        res[i][0]=1;
        for(int i=0;i<n;i++)
        res[0][i]=1;
        for(int i =1;i<m;i++){
            for(int j=1;j<n;j++){
                res[i][j] = res[i-1][j] + res[i][j-1];
            }
        }
        return res[m-1][n-1];
    }
}



package com.algorithms;

/**
 * Created by 6estates on 11-May-17.
 */
public class FindPath2Solution {
    static int row;
    static int col;

    public static void main(String[] args){
        FindPath2Solution findPath2Solution = new FindPath2Solution();
        System.out.println(findPath2Solution.findPaths(2,2,2,0,0));
    }
    public int findPaths(int m, int n, int N, int i, int j) {

        row = m;
        col = n;

        if (N == 0) return 0;

        int MOD = 1000000000 + 7;
        int[][][] dp = new int[m][n][N];

        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        dp[i][j][0] = 1;

        int ret = 0;
        for (int k = 1; k < N; k++){
            for (int x = 0; x < m; x++){
                for (int y = 0; y < n; y++){
                    for (int l = 0; l < 4; l++){
                        int curr_x = x + directions[l][0];
                        int curr_y = y + directions[l][1];
                        if (valid(curr_x, curr_y)){
                            dp[x][y][k] = (dp[x][y][k] + dp[curr_x][curr_y][k - 1]) % MOD;
                        }else{
                            ret += dp[x][y][k-1];
                            ret %= MOD;
                        }
                    }
                }
            }
        }

        for (int x = 0; x < m; x++){
            for (int y = 0; y < n; y++){
                for (int l = 0; l < 4; l++){
                    int curr_x = x + directions[l][0];
                    int curr_y = y + directions[l][1];
                    if (!valid(curr_x, curr_y)){
                        ret += dp[x][y][N-1];
                        ret %= MOD;
                    }
                }
            }
        }

        return ret;
    }

    private boolean valid(int x, int y){
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}

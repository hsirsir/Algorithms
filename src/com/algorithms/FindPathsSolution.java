package com.algorithms;

/**
 * Created by 6estates on 10-May-17.
 */
public class FindPathsSolution {
    public static void main(String[] args){
        FindPathsSolution findPathsSolution = new FindPathsSolution();
        System.out.println(findPathsSolution.findPaths(8,7,16,1,5));
    }
    public long pathsNumber = 0l;
    public int findPaths(int m, int n, int N, int i, int j) {
        int res = 0;
        getPathNumber(m-1,n-1,N,i,j);
        long modNumber = 1000000000;
        long modRes = pathsNumber % (modNumber + 7);
        res = (int)modRes;
        return res;
    }
    public void getPathNumber(int m,int n,int N,int i,int j){
      /*  if(N >= 0 && isOutBoundary(m,n,i,j)) {
            pathsNumber += 1;
            return;
        }*/
        if((i < 0 || j < 0 || i > m || j > n) && N >= 0){
            pathsNumber+=1;
            return;
        }
        int distTop = i;
        int distLeft = j;
        int distRight = n - j;
        int distDown = m - i;
        int min = 200;
        if(min > distTop) min = distTop;
        if(min > distDown) min = distDown;
        if(min > distLeft) min = distLeft;
        if(min > distRight) min = distRight;
        if(N <= min) return;
        if(N > 0){
            //向上移动
            getPathNumber(m,n,N-1,i-1,j);
            //向下移动
            getPathNumber(m,n,N-1,i+1,j);
            //向左移动
            getPathNumber(m,n,N-1,i,j-1);
            //向右移动
            getPathNumber(m,n,N-1,i,j+1);
        }
    }
    public boolean isOutBoundary(int m,int n,int posm,int posn){
        if(posm < 0 || posn < 0){
            return true;
        }
        if(posm > m || posn > n){
            return true;
        }
        return false;
    }
}

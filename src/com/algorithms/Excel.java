package com.algorithms;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;


public class Excel {

    public static void main(String[] args){
        /**
         ["Excel","set","set","set","sum","get","set","get","sum","set","get","get","sum","set","get","get","get","get"]
         [[5,"E"],[1,"A",5],[1,"B",3],[1,"C",2],[1,"C",["A1","A1:B1"]],[1,"C"],[1,"B",5],[1,"C"],[1,"B",["A1:A5"]],[5,"A",10],[1,"B"],[1,"C"],[3,"C",["A1:C1","A1:A5"]],[3,"A",3],[1,"B"],[1,"C"],[3,"C"],[5,"A"]]
         */
       /* Excel excel = new Excel(3,'C');
        excel.set(1,'A',2);
        out.println(excel.sum(3,'C',new String[]{"A1","A1:B2"}));
        excel.set(2,'B',2);*/
       out.println('A'+1);
    }
    class Cell{
        public int val = 0;
        public List<Cell> connectCells = new ArrayList<Cell>();
        public int getVal(){
            if(connectCells.size() == 0){
                return val;
            }
            return calVal();
        }
        public int calVal(){
           int res = 0;
           for(int i = 0;i<connectCells.size();i++){
               res += connectCells.get(i).getVal();
           }
           return res;
        }
        public int sum(Excel excel,String[] strs){
            val = 0;
            connectCells = new ArrayList<Cell>();
            for(int i = 0;i < strs.length;i++)
            {
                String connectStr = strs[i];
                if(connectStr.contains(":")){
                    addConRect(excel,connectStr);
                }else{
                    addSingleCell(excel ,connectStr);
                }
            }
            return  val = getVal();
        }
        public void addSingleCell(Excel excel,String singleCellStr){
            int colIndex = singleCellStr.charAt(0) - 'A';
            int rowIndex = Integer.parseInt(singleCellStr.substring(1,singleCellStr.length())) - 1;
            connectCells.add(excel.cells[excel.colLen*rowIndex + colIndex]);
        }

        public void addConRect(Excel excel,String rectStr){
            String leftTopStr = rectStr.split(":")[0];
            String bottomRightStr = rectStr.split(":")[1];
            int colStartIndex = leftTopStr.charAt(0);
            int rowStartIndex = Integer.parseInt(leftTopStr.substring(1,leftTopStr.length())) - 1;
            int rectColLen = bottomRightStr.charAt(0) - leftTopStr.charAt(0) + 1;
            int rectRowLen = Integer.parseInt(bottomRightStr.substring(1,bottomRightStr.length())) - Integer.parseInt(leftTopStr.substring(1,leftTopStr.length())) + 1;
            for(int i = 0;i < rectRowLen;i++){
                for(int m = 0;m < rectColLen;m++){
                    connectCells.add(excel.cells[(rowStartIndex + i) * excel.colLen + (colStartIndex + m) - 65]);
                }
            }
        }
    }
    public Cell[] cells;
    public int colLen = 0;
    public Excel(int H, char W) {
        cells = new Cell[H * (W - 'A'+1)];
        for(int i = 0;i < cells.length;i++){
            cells[i] = new Cell();
        }
        colLen = (W - 'A') + 1;
    }
    public int getColIndex(char c){
        return c - 'A';
    }
    public void set(int r, char c, int v) {
        cells[(r-1)*colLen + getColIndex(c)].val = v;
        cells[(r-1)*colLen + getColIndex(c)].connectCells = new ArrayList<Cell>();
    }

    public int get(int r, char c) {
        return cells[(r - 1)*colLen + getColIndex(c)].getVal();
    }

    public int sum(int r, char c, String[] strs) {
        return cells[(r-1)*colLen + getColIndex(c)].sum(this,strs);
    }

}

/**
 * Your Excel object will be instantiated and called as such:
 * Excel obj = new Excel(H, W);
 * obj.set(r,c,v);
 * int param_2 = obj.get(r,c);
 * int param_3 = obj.sum(r,c,strs);
 */

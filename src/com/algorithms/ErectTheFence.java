package com.algorithms;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.zip.DeflaterOutputStream;

/**
 *
 *
 *
 *
 *
 * Created by 6estates on 17-May-17.
 */
public class ErectTheFence{
    public static void main(String[] args){
        //[[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]

        ErectTheFence erectTheFence = new ErectTheFence();
        Point[] points = new Point[]{new Point(1,1),new Point(2,2),new Point(2,0),new Point(2,4),
                new Point(3,3),new Point(4,2)};
        List<Point> resLs = erectTheFence.outerTrees(points);
        System.out.println(resLs);
    }
    public List<Point> outerTrees(Point[] points) {
        List<Point> resPoints = new ArrayList<>();
        int leftPointIndex = findLeftPoint(points);
        Point startPoint = points[leftPointIndex];
        resPoints.add(startPoint);
        HashMap<Integer,Integer> flagMap = new HashMap<>();
        flagMap.put(leftPointIndex,1);
        Point scanPoint = startPoint;
        Point pointOne = new Point(startPoint.getX(),startPoint.getY()- 1);
        while (true){
            double angle = Double.MAX_VALUE;
            Point nextPoint = null;
            int nextPos = -1;
            for(int i = 0;i < points.length;i++){
                if(!flagMap.containsKey(i)){
                    Vector v1 = new Vector(scanPoint,pointOne);
                    Vector v2 = new Vector(points[i],scanPoint);
                    double tmpAngle = Vector.getVectorAngle(v1,v2);
                    if(tmpAngle < angle){
                        nextPoint = points[i];
                        angle = tmpAngle;
                        nextPos = i;
                    }
                }
            }
            if(nextPoint == null){
                System.out.println("nextPoint is null!!!!");
                return resPoints;
            }else{
                resPoints.add(nextPoint);
                flagMap.put(nextPos,1);
                pointOne = scanPoint;
                scanPoint = nextPoint;
            }
            System.out.println("pointX = " + nextPoint.getX() +" pointY = " + nextPoint.getY());
            if(nextPoint.getX() == startPoint.getX() && nextPoint.getY() == startPoint.getY()) break;
        }
        return resPoints;
    }
    public int findLeftPoint(Point[] points){
        int pos = 0;
        Point point = points[pos];
        for(int i = 1;i < points.length;i++){
            if(points[i].getX() < point.getX()){
                point = points[i];
                pos = i;
            }
            if(points[i].getX() == point.getX() && points[i].getY() < point.getY()){
                point = points[i];
                pos = i;
            }
        }
        return pos;
    }
}
class Vector{
    public static double getVectorAngle(Vector v1,Vector v2){
        double angle = Double.MIN_VALUE;
        //向量积
        double productVal = (v1.cordX * v2.cordX) + (v1.cordY + v2.cordY);
        //v1的模
        double v1_val = v1.getMod();
        //v2的模
        double v2_val = v2.getMod();
        //余弦值
        double cosVal = productVal / (v1_val * v2_val);
        if(cosVal < -1d && cosVal > -2d){
            cosVal = -1d;
        }else if(cosVal > 1d && cosVal < 2d){
            cosVal = 1d;
            //cosVal = 2 - cosVal;
        }
        angle = Math.acos(cosVal)*180/Math.PI;
        return angle;
    }
    public double cordX;
    public double cordY;
    Vector(Point pointA,Point pointB){
        cordX = (double)(pointA.getX() - pointB.getX());
        cordY = (double)(pointA.getY() - pointB.getY());
    }
    public double getMod(){
        return Math.sqrt(cordX*cordX+cordY*cordY);
    }
}
class Point{
    public int x;
    public int y;
    Point(){
        x = 0;
        y = 0;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    Point(int a, int b){
        x = a;
        y = b;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

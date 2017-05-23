package com.algorithms;

/**
 * Created by 6estates on 22-May-17.
 */
public class StackTest {
    public static void main(String[] args){
        StackTest stackTest = new StackTest();
        stackTest.methodA();
    }
    public void methodA(){
        System.out.println("Enter methodA---------------------");
        methodB();
    }
    public void methodB(){
        System.out.println("Enter methodB-------------------");
        StackTraceElement elements[] = Thread.currentThread().getStackTrace();
        for(int i = 0;i < elements.length;i++){
            StackTraceElement element = elements[i];
            String className = element.getClassName();
            String methodName = element.getMethodName();
            String fileName = element.getFileName();
            int lineNumber = element.getLineNumber();
            System.out.println("StackTraceElement下标i="+i+",fileName="+fileName+",className="+className+",methodName="+methodName
                    +",lineNumber="+lineNumber);
        }
    }

}

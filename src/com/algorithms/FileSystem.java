package com.algorithms;

import java.util.*;

public class FileSystem {

    FileObj rootFileSys;
    public FileSystem() {
        rootFileSys = new FileObj(1,null);
    }

    public List<String> ls(String path) {
        String[] pathArr = path.split("/");
        //path /
        if(pathArr.length == 0){
            return rootFileSys.ls();
        }
        FileObj endFileObj = FileObj.findLastFileObj(rootFileSys,path);
        List<String> resLs = new ArrayList<>();
        if(endFileObj.fileType == 0) {
            resLs.add(pathArr[pathArr.length - 1]);
        }else{
            resLs = endFileObj.ls();
        }
        return resLs;
    }

    public void mkdir(String path) {
        String[] pathArr = path.split("/");
        FileObj startFileObj = rootFileSys;
        if(pathArr.length > 0){
            for(int i = 1;i < pathArr.length;i++){
                startFileObj = startFileObj.addDir(pathArr[i]);
            }
        }
    }

    public void addContentToFile(String filePath, String content) {
        String[] pathArr = filePath.split("/");
        FileObj parentObj = rootFileSys;
        for(int i = 1; i < pathArr.length - 1;i++){
            parentObj = parentObj.addDir(pathArr[i]);
        }
        parentObj.addContent(pathArr[pathArr.length - 1],content);
    }

    public String readContentFromFile(String filePath) {
        FileObj endFileObj = FileObj.findLastFileObj(rootFileSys,filePath);
        return  endFileObj.content;
    }
}
class FileObj{
    /**
     * 0 文件
     * 1 文件夹
     */
    public int fileType;
    public String content;
    public TreeMap<String,FileObj> files;
    public List<String> paths;
    //public String allPathName;
    public FileObj(int ftype,String fcontent){
        this.fileType = ftype;
        if(ftype == 0){
            content = fcontent;
        }else{
            paths = new ArrayList<>();
            files = new TreeMap<>();
        }
    }
    public void addContent(String fileName, String con){
       if(files.containsKey(fileName)){
           FileObj fileObj = files.remove(fileName);
           StringBuilder stringBuilder = new StringBuilder();
           stringBuilder.append(fileObj.content);
           stringBuilder.append(con);
           fileObj.content = stringBuilder.toString();
           files.put(fileName,fileObj);
       }else{
           FileObj fileObj = new FileObj(0,con);
           paths.add(fileName);
           files.put(fileName,fileObj);
       }
    }
    public FileObj addDir(String dirName){
        FileObj tmpDir = null;
        if(fileType == 1){
            if(!files.containsKey(dirName)){
                tmpDir = new FileObj(1,null);
                files.put(dirName,tmpDir);
                paths.add(dirName);
            }else{
                tmpDir = files.get(dirName);
            }
        }
        return tmpDir;
    }
    public List<String> ls(){
        if(fileType == 0) return null;
       if(fileType == 1){
           Collections.sort(paths);
       }
       return paths;
    }

    public static FileObj findLastFileObj(FileObj rootFileObj,String path){
        if(path.equals("/")) return null;
        String[] pathArr = path.split("/");
        FileObj endFileObj = rootFileObj;
        for(int i = 1;i < pathArr.length;i++){
            endFileObj = endFileObj.files.get(pathArr[i]);
        }
        return endFileObj;
    }

}
/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
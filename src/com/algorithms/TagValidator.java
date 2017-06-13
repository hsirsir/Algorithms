package com.algorithms;
import java.util.Stack;

/**
 * Created by 6estates on 08-Jun-17.
 */
public class TagValidator {

    public boolean isValid(String code) {
        if(code.startsWith("</")) return false;
        if(code.startsWith("<![CDATA[")) return false;
        if(!(code.startsWith("<") || code.startsWith("<![CDATA["))){
            return false;
        }
        Stack<String> tagStack = new Stack<>();
        int startPos = 0;

        int preTagFlag = -1;
        int isHave = 0;
        int emptyFlag = 0;
        while (true){
            //<A><A></A>< /A>
            if(startPos >= (code.length() - 1) && !tagStack.isEmpty()) return false;
            int cTagPos1 = code.indexOf("<",startPos);
            //处理<A>123</A>123
            if(tagStack.isEmpty() && startPos+1 >= (code.length() - 1)) return false;

            if(cTagPos1 < 0 && tagStack.isEmpty()) return false;
            //跳过</
            String tagFlag = code.substring(cTagPos1,cTagPos1+2);

            //跳过<![CDATA[
            int cdataEnd = cTagPos1 + 9;
            if(cdataEnd > (code.length() - 1)) cdataEnd = code.length() - 1;
            String  cDataFlag = code.substring(cTagPos1,cdataEnd);
            if(cTagPos1 >= 0 && !tagFlag.equals("</") && !cDataFlag.equals("<![CDATA[")){
                int cTagPos2 = code.indexOf(">",cTagPos1+1);
                if(cTagPos2 < 0) return false;
                if(!isValidTag(code,cTagPos1+1,cTagPos2)) return false;
                if(emptyFlag == 1) return false;
                tagStack.push(code.substring(cTagPos1+1,cTagPos2));
                startPos = cTagPos2 + 1;
                preTagFlag = 0;
                isHave += 1;
                continue;
            }
            int cdataPos1 = code.indexOf("<![CDATA[",startPos);
            if(cdataPos1 >= 0){
                int cdataPos2 = code.indexOf("]]>",cdataPos1+9);
                if(cdataPos2 < 0) return false;
                //if(!isValidTag(code,cdataPos1+9,cdataPos2)) return false;
                startPos = cdataPos2+3;
                preTagFlag = 1;
                continue;
            }

            //处理标签内容为空
            //<DIV>This is the first line <![CDATA[<div>]]></DIV>
            //<A><A>/A></A></A>
            //<A><A>/A></A></A>
            //<A></A>

            int endTagPos1 = code.indexOf("</",startPos);
            if(endTagPos1 > 0){
                int endTagPos2 = code.indexOf(">",endTagPos1+2);
                if(endTagPos2 < 0) return false;
                if(!isValidTag(code,endTagPos1+2,endTagPos2)) return false;
                String endTagName = code.substring(endTagPos1+2,endTagPos2);
                if(tagStack.isEmpty()) return false;
                String startTagName = tagStack.pop();
                if(tagStack.isEmpty()) emptyFlag = 1;
                if(!endTagName.equals(startTagName)) return false;
                startPos = endTagPos2 + 1;
                if(endTagPos2 == (code.length() - 1)) return true;
                preTagFlag = 1;
                continue;
            }
        }
    }
    public boolean isValidTag(String code,int start,int end){
        if(start == end) return false;
        if(end - start > 9) return false;
        String tag = code.substring(start,end);
        boolean b = true;
        for(int i = 0;i < tag.length();i++){
            b = Character.isUpperCase(tag.charAt(i));
            if(b == false) break;
        }
        return b;
    }
}

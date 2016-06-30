package com.company;

import java.io.*;
import java.util.Vector;
import java.io.IOException;

/**
 * Created by Terryblade on 2016/6/26.
 */
public class Pos {
    public Vector<String> vs;       //第二阶段
    public Pos(){
        vs=new Vector<String>();
    }
    public Pos(String args){
        vs=new Vector<String>();
        String s1="";
        try{
            FileReader fr=new FileReader(args);
            BufferedReader bf=new BufferedReader(fr);
            while(bf.ready()){
                String s=bf.readLine();
                s=s.replaceAll(" ","");
                switch (s.charAt(0)){
                    case '[':
                        break;
                    case ']':
                        break;
                    case '\'':
                        s1=s.substring(s.indexOf("'")+1,s.lastIndexOf("'"));
                        vs.add(s1);
                        break;
                }
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Terryblade on 2016/6/29.
 */
public class MemberList {
    public Vector<Member> vs;

    public MemberList(){
        vs=new Vector<Member>();
    }

    public MemberList(String args){
        vs=new Vector<Member>();
        Member it;
        String s1;
        try{
            FileReader fr=new FileReader(args);
            BufferedReader br=new BufferedReader(fr);
            while(br.ready()){
                String s=br.readLine();
                s=s.replaceAll(" ","");
                switch (s.charAt(0)){
                    case '{':
                        break;
                    case '\'':
                        it=new Member();
                        for(s=br.readLine(),s=s.replaceAll(" ","");s.charAt(0)!='}';s=br.readLine(),s=s.replaceAll(" ","")){
                            switch (s.substring(0,3)){
                                case "\"na":
                                    s1=s.substring(s.indexOf("'")+1,s.lastIndexOf("'"));
                                    it.setName(s1);
                                    break;
                                case "\"is":
                                    s1=s.substring(s.indexOf(":")+1);
                                    it.setVip(Boolean.parseBoolean(s1));
                                    break;
                                case "\"in":
                                    s1=s.substring(s.indexOf(":")+1);
                                    it.setIntegral(Integer.parseInt(s1));
                            }
                        }vs.add(it);
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

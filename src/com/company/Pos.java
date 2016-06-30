package com.company;

import java.io.*;
import java.util.Vector;
import java.io.IOException;

/**
 * Created by Terryblade on 2016/6/20.
 */
public class Pos {
    public Vector<Item> vs;       //第二阶段
    public Pos(){
        vs=new Vector<Item>();
    }
    public Pos(String args){
        vs=new Vector<Item>();
        Item it;
        String s1="";
        try{
            FileReader fr=new FileReader(args);
            BufferedReader br=new BufferedReader(fr);
            while(br.ready()){
                String s=br.readLine();
                s=s.replaceAll(" ","");
                if(s.length()>3) {
                    switch (s.substring(0, 3)) {
                        case "bar":
                            it=new Item();
                            s1 = s.substring(s.indexOf('\''), s.lastIndexOf('\''));
                            it.setBarcode(s1);
                            for(s=br.readLine(),s=s.replaceAll(" ","");s.charAt(0)!='}';s=br.readLine(),s=s.replaceAll(" ","")){
                                switch (s.substring(0,3)){
                                    case "nam":
                                        s1=s.substring(s.indexOf("'")+1,s.lastIndexOf("'"));
                                        it.setName(s1);
                                        break;
                                    case "uni":
                                        s1=s.substring(s.indexOf("'")+1,s.lastIndexOf("'"));
                                        it.setUnit(s1);
                                        break;
                                    case "pri":
                                        s1=s.substring(s.indexOf(":")+1);
                                        it.setPrice(Double.parseDouble(s1));
                                        break;
                                    case "dis":
                                        s1=s.substring(s.indexOf(":")+1);
                                        it.setDiscount(Double.parseDouble(s1));
                                }
                            }vs.add(it);
                            break;
                    }
                }
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}

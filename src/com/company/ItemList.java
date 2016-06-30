package com.company;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;


/**
 * Created by Terryblade on 2016/6/25.
 */
public class ItemList {
    public Vector<Item> vs;         //商品索引文件
    public ItemList(){
        vs=new Vector<Item>();
    }
    public ItemList(String args){
        vs=new Vector<Item>();
//        vs.clear();
        Item it;
        String s1="";
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
                        it=new Item();
                        s1=s.substring(s.indexOf("'")+1,s.lastIndexOf("'"));
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
                                    break;
                                case "pro":
                                    s1=s.substring(s.indexOf(":")+1);
                                    it.setPromotion(Boolean.parseBoolean(s1));
                                    break;
                                case "vip":
                                    s1=s.substring(s.indexOf(":")+1);
                                    it.setVipdiscount(Double.parseDouble(s1));
                                    it.setIsvipitem(true);
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

    ItemList(Vector<Item>vs){this.vs=vs;}

    public double SubTotal(){
        double result =0.00;
        if(vs.get(0).getPromotion()==false) {
            for (Item it : vs) {
                result += it.getPrice() * it.getDiscount();
            }
        }
        if(vs.get(0).getPromotion()==true){
            if(vs.size()>2) {
                for (Item it : vs) {
                    result += it.getPrice();
                }
                result -= vs.get(0).getPrice();
            }
            else{
                if(vs.size()==1)
                {result+=vs.get(0).getPrice();}
                else{
                    result+=vs.get(0).getPrice();
                    result+=vs.get(0).getPrice();
                }
            }
        }
        return result;
    }
    public double Save(){
        double result=0.00;
        if(vs.get(0).getPromotion()==false) {
            for (Item it : vs) {
                result += it.getPrice() * (1 - it.getDiscount());
            }
        }
        if(vs.get(0).getPromotion()==true){
            if(vs.size()>2){
                result=vs.get(0).getPrice();
            }
            else{
                result=0;
            }
        }
        return result;
    }

    public double VipSutatol(){
        double result=0;
        if(vs.get(0).getPromotion()==false) {
            for (Item it : vs) {
                result += it.getPrice() * it.getDiscount()*it.getVipdiscount();
            }
        }
        if(vs.get(0).getPromotion()==true){
            if(vs.size()>2) {
                for (Item it : vs) {
                    result += it.getPrice();
                }
                result -= vs.get(0).getPrice();
            }
            else{
                if(vs.size()==1)
                {result+=vs.get(0).getPrice();}
                else{
                    result+=vs.get(0).getPrice();
                    result+=vs.get(0).getPrice();
                }
            }
        }
        return result;
    }

    public double VipSave(){
        double result=0.00;
        if(vs.get(0).getPromotion()==false) {
            for (Item it : vs) {
                result += (it.getPrice() * (1 - it.getDiscount())+it.getPrice()*it.getDiscount()*(1-it.getVipdiscount()));
            }
        }
        if(vs.get(0).getPromotion()==true){
            if(vs.size()>2){
                result=vs.get(0).getPrice();
            }
            else{
                result=0;
            }
        }

        return result;
    }



}

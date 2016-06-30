package com.company;

import com.company.Item;
import com.company.ItemList;
import org.hamcrest.core.Is;

import java.util.Vector;

/**
 * Created by Terryblade on 2016/6/26.
 */
public class ReadList {
    public Vector<ItemList>vs;
    public MemberList memberList;
    public String User;
    boolean Isvip;
    int Integral;
    public ReadList(){
        vs=new Vector<ItemList>();
    }


    public ReadList(Pos p,ItemList i){              //第二阶段
        vs=new Vector<ItemList>();
        String str=p.vs.get(0);
        ItemList il=new ItemList();
        User=p.getUser();
        for(String str1:p.vs){
            if(!str.equals(str1)){
                vs.add(il);
                il=new ItemList();
            }
            for(Item it:i.vs){
                if(str1.equals(it.getBarcode())){
                    il.vs.add(it);
                }
            }
            str=str1;
        }
        vs.add(il);
    }

    public ReadList(Pos p,ItemList i,MemberList m){
        vs=new Vector<ItemList>();
        String str=p.vs.get(0);
        ItemList il=new ItemList();
        User=p.getUser();
        for(Member me:m.vs){
            if(me.getName().equals(User)){
                Isvip=me.getIsVip();
                Integral=me.getIntegral();
            }
        }
        for(String str1:p.vs){
            if(!str.equals(str1)){
                vs.add(il);
                il=new ItemList();
            }
            for(Item it:i.vs){
                if(str1.equals(it.getBarcode())){
                    il.vs.add(it);
                }
            }
            str=str1;
        }
        vs.add(il);

    }

    ReadList(Vector<ItemList>vs){this.vs=vs;}

    public double GetTotal(){
        double result=0;
        if(Isvip==false) {
            for (ItemList lte : vs) {
                result += lte.SubTotal();
            }
        }
        if(Isvip==true) {
            for (ItemList lte : vs) {
                result += lte.VipSutatol();
            }
        }
        return result;
    }
    public double GetSave(){
        double result=0.00;
        if(Isvip==false) {
            for (ItemList lte : vs) {
                result += lte.Save();
            }
        }
        if(Isvip==true) {
            for (ItemList lte : vs) {
                result += lte.VipSave();
            }
        }
        return result;
    }

    public String GetDisplay(){
        double result1=0.00;
        double result2=0.00;
        int integral=0;
        result1=GetTotal();
        result2=GetSave();
        StringBuilder shoppinglist=new StringBuilder()
                .append("***商店购物清单***\n");
        if(Isvip==false) {
            for (ItemList itl : vs) {
                shoppinglist.append(
                        new StringBuilder()
                                .append("名称:").append(itl.vs.get(0).getName())
                                .append(",数量:").append(itl.vs.size() + itl.vs.get(0).getUnit())
                                .append(",单价:").append(String.format("%.2f", itl.vs.get(0).getPrice()))
                                .append("(元),小计:").append(String.format("%.2f", itl.SubTotal())).append("(元)").append("\n")
                );
            }
        }
        if(Isvip==true){
            if(Integral>=0&&Integral<=200) {
                integral=(int)result1/5;
                Integral+=integral;
                shoppinglist.append(
                        new StringBuilder()
                                .append("会员编号:").append(User).append("    ").append("会员积分:").append(Integral).append("\n")
                );
            }
            else if(Integral>200&Integral<=500){
                integral=(int)result1/5;
                Integral+=integral*3;
                shoppinglist.append(
                        new StringBuilder()
                                .append("会员编号:").append(User).append("    ").append("会员积分:").append(Integral).append("\n")
                );
            }
            else if(Integral>500) {
                integral=(int)result1/5;
                Integral+=integral*5;
                shoppinglist.append(
                        new StringBuilder()
                                .append("会员编号:").append(User).append("    ").append("会员积分:").append(Integral).append("\n")
                );
            }
            for (ItemList itl : vs) {
                shoppinglist.append(
                        new StringBuilder()
                                .append("名称:").append(itl.vs.get(0).getName())
                                .append(",数量:").append(itl.vs.size() + itl.vs.get(0).getUnit())
                                .append(",单价:").append(String.format("%.2f", itl.vs.get(0).getPrice()))
                                .append("(元),小计:").append(String.format("%.2f", itl.VipSutatol())).append("(元)").append("\n")
                );
            }
        }
        for(ItemList itl:vs){
            if(itl.vs.size()>2&&itl.vs.get(0).getPromotion()==true){
                shoppinglist.append(
                        new StringBuilder()
                                .append("----------------------\n")
                                .append("挥泪赠送商品:")
                                .append(itl.vs.get(0).getName())
                                .append(",数量:1")
                                .append(itl.vs.get(0).getUnit())
                                .append("\n")
                );
            }
        }
        StringBuilder subString=shoppinglist
                .append("----------------------\n")
                .append("总计:").append(String.format("%.2f",result1)).append("(元)").append("\n");
        if(result2==0){
            return subString
                    .append("**********************\n").toString();
        }
        return subString
                .append("节省:").append(String.format("%.2f",result2)).append("元").append("\n")
                .append("**********************\n").toString();
    }

}

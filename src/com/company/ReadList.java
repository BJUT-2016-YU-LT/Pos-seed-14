package com.company;

import com.company.Item;
import com.company.ItemList;

import java.util.Vector;

/**
 * Created by Terryblade on 2016/6/26.
 */
public class ReadList {
    Vector<ItemList>vs;
    public ReadList(){
        vs=new Vector<ItemList>();
    }

    public ReadList(Pos p){

    }

    public ReadList(Pos p,ItemList i){              //第二阶段
        vs=new Vector<ItemList>();
        String str=p.vs.get(0);
        ItemList il=new ItemList();
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
        for(ItemList lte:vs){
            result+=lte.SubTotal();
        }
        return result;
    }
    public double GetSave(){
        double result=0.00;
        for(ItemList lte:vs){
            result +=lte.Save();
        }
        return result;
    }
    public void Display(){
        double result1=0.00;
        double result2=0.00;
        System.out.println("***商店购物清单***");
        for(ItemList itl:vs) {
            System.out.println("名称:" + itl.vs.get(0).getName() + ",数量：" + itl.vs.size() + itl.vs.get(0).getUnit() + ",单价：" + itl.vs.get(0).getPrice()  + "(元),小计:" + itl.SubTotal() + "(元)");
            //     result1+=itl.SubTotal();
            //     result2+=itl.Save();
        }
        System.out.println("----------------------");
        for(ItemList itl:vs){
            if(itl.vs.size()>1){
                System.out.println("挥泪赠送商品：");
                System.out.println("名称:"+itl.vs.get(0).getName()+",数量:1"+itl.vs.get(0).getUnit());
            }
        }
        result1=GetTotal();
        result2=GetSave();
        System.out.println("----------------------");
        System.out.println("总计:"+result1+"(元)");
        System.out.println("节省:"+result2+"(元)");
    }

    public String GetDisplay(){
        double result1=0.00;
        double result2=0.00;
        result1=GetTotal();
        result2=GetSave();
        StringBuilder shoppinglist=new StringBuilder()
                .append("***商店购物清单***\n");
        for(ItemList itl:vs){
            shoppinglist.append(
                    new StringBuilder()
                            .append("名称:").append(itl.vs.get(0).getName())
                            .append(",数量:").append(itl.vs.size() + itl.vs.get(0).getUnit())
                            .append(",单价:").append(String.format("%.2f",itl.vs.get(0).getPrice()))
                            .append("(元),小计:").append(String.format("%.2f",itl.SubTotal())).append("(元)").append("\n")
            );
        }
        for(ItemList itl:vs){
            if(itl.vs.size()>2){
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
                .append("节省:").append(result2).append("元").append("\n")
                .append("**********************\n").toString();
    }

}

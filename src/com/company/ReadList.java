package com.company;

import java.util.Vector;

/**
 * Created by Terryblade on 2016/6/20.
 */
public class ReadList {
    public Vector<ItemList> vs;
    public ReadList(){
        vs=new Vector<ItemList>();
    }

    public ReadList(Pos p){
        vs=new Vector<ItemList>();
        String str=p.vs.get(0).getBarcode();
       // Item item=p.vs.get(0);
        ItemList il=new ItemList();
        for(Item i:p.vs){
            if(!str.equals(i.getBarcode())){
                vs.add(il);
                il=new ItemList();
                il.vs.add(i);
            }
            if(str.equals(i.getBarcode())){
                il.vs.add(i);
            }
            str=i.getBarcode();
        }
        vs.add(il);
    }

    public double GetTotal(){
        double result=0;
        for (ItemList lte : vs) {
            result += lte.SubTotal();
        }
        return result;
    }

    public double GetSave(){
        double result=0;
        for (ItemList lte : vs) {
            result += lte.Save();
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
        for (ItemList itl : vs) {
            shoppinglist.append(
                    new StringBuilder()
                            .append("名称:").append(itl.vs.get(0).getName())
                            .append(",数量:").append(itl.vs.size() + itl.vs.get(0).getUnit())
                            .append(",单价:").append(String.format("%.2f", itl.vs.get(0).getPrice()))
                            .append("(元),小计:").append(String.format("%.2f", itl.SubTotal())).append("(元)").append("\n")
                );
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

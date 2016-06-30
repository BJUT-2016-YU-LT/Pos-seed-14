package com.company;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;


/**
 * Created by Terryblade on 2016/6/20.
 */
public class ItemList {
    public Vector<Item> vs;         //商品索引文件
    public ItemList(){
        vs=new Vector<Item>();
    }
    public ItemList(String args) {
        vs = new Vector<Item>();
    }

    public double SubTotal(){
        double result =0.00;
        for (Item it : vs) {
            result += it.getPrice() * it.getDiscount();
        }
        return result;
    }
    public double Save(){
        double result=0.00;
        for (Item it : vs) {
            result += it.getPrice() * (1 - it.getDiscount());
        }
        return result;
    }
}
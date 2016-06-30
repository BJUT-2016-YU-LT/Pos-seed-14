package com.company;

public class Main {

    public static void main(String[] args) {
//        String ss="\"abc中国";
//        System.out.println(ss.substring(0,3));
        String arg1="E://1.txt";
        String arg2="E://ThreeSameItemIme.txt";
        ItemList s=new ItemList(arg1);
        Pos p=new Pos(arg2);
        ReadList rd=new ReadList(p,s);
        //rd.Display();
        System.out.println(rd.GetDisplay());
    }
}

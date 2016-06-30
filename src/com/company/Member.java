package com.company;

/**
 * Created by Terryblade on 2016/6/29.
 */
public class Member {
    private String Name;
    private boolean IsVip;
    public Member(){
        Name="";
        IsVip=false;
    }
    public Member(String Name,boolean IsVip){
        this.Name = Name;
        this.IsVip=IsVip;
    }

    public void setName(String Name){
        this.Name = Name;
    }

    public void setVip(boolean IsVip){
        this.IsVip=IsVip;
    }

    public String getName(){return Name;}

    public boolean getIsVip(){return IsVip;}
}

package com.company;

/**
 * Created by Terryblade on 2016/6/25.
 */
public class Item {
    private String barcode;
    private String name;
    private String unit;
    private double price;
    private double discount;
    private  boolean promotion;
    private double vipdiscount;
    private boolean isvipitem;
    public Item() {

    }

    public Item(String barcode, String name, String unit, double price) {

        this.setBarcode(barcode);
        this.setName(name);
        this.setUnit(unit);
        this.setPrice(price);
    }
    public Item(String barcode, String name, String unit, double price, double discount) {
        this(barcode, name, unit, price);
        this.setDiscount(discount);
    }

    public Item(String barcode, String name, String unit, double price, boolean promotion) {
        this(barcode, name, unit, price);
        this.setPromotion(promotion);
    }

    public Item(String barcode,String name,String unit, double price,boolean promotion,double vipdiscount){
        this(barcode, name, unit, price, promotion);
        this.setVipdiscount(vipdiscount);
    }

    public Item(String barcode,String name,String unit, double price,boolean promotion,double vipdiscount,boolean isvipitem){
        this(barcode, name, unit, price, promotion,vipdiscount);
        this.setIsvipitem(isvipitem);
    }

    public String getName() {
        return name;
    }
    public String getUnit() {
        return unit;
    }

    public double getPrice() {
        return price;
    }

    public String getBarcode() { return barcode; }

    public double getDiscount() {
        if (discount == 0.00)
            return 1.00;
        return discount;
    }

    public boolean getPromotion(){return promotion;}

    public double getVipdiscount(){
        if(vipdiscount==0.00){
            return 1.00;
        }
        return vipdiscount;
    }

    public boolean getIsVipItem(){return isvipitem;}

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setPromotion(boolean promotion){this.promotion=promotion;}

    public void setVipdiscount(double vipdiscount){this.vipdiscount=vipdiscount;}

    public void setIsvipitem(boolean isvipitem){this.isvipitem=isvipitem;}
}

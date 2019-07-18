package com.table;

public class Goodsinfo {

//    CREATE TABLE `goodsinfo` (
//            `id` int(11) NOT NULL AUTO_INCREMENT,
//  `goodsinfo_name` varchar(20) DEFAULT NULL,
//  `goodsinfo_pic` varchar(300) DEFAULT NULL,
//  `goodsinfo_price` double DEFAULT NULL,
//            `goodsinfo_description` varchar(300) DEFAULT NULL,
//  `goodsinfo_stock` int(11) DEFAULT NULL
    private String id;
    private String goodsinfoName;
    private String goodsinfoPic;
    private String goodsinfoPrice;
    private String goodsinfoDescription;
    private String goodsinfoStock;

    public Goodsinfo(String goodsinfoName) {
        this.goodsinfoName = goodsinfoName;
    }

    @Override
    public String toString() {
        return "Goodsinfo{" +
                "id=" + id +
                ", goodsinfoName='" + goodsinfoName + '\'' +
                ", goodsinfoPic='" + goodsinfoPic + '\'' +
                ", goodsinfoPrice='" + goodsinfoPrice + '\'' +
                ", goodsinfoDescription='" + goodsinfoDescription + '\'' +
                ", goodsinfoStock='" + goodsinfoStock + '\'' +
                '}';
    }

    public Goodsinfo() {
    }

    public String getGoodsinfoName() {

        return goodsinfoName;
    }

    public void setGoodsinfoName(String goodsinfoName) {
        this.goodsinfoName = goodsinfoName;
    }

    public String getGoodsinfoPic() {
        return goodsinfoPic;
    }

    public void setGoodsinfoPic(String goodsinfoPic) {
        this.goodsinfoPic = goodsinfoPic;
    }

    public String getGoodsinfoPrice() {
        return goodsinfoPrice;
    }

    public void setGoodsinfoPrice(String goodsinfoPrice) {
        this.goodsinfoPrice = goodsinfoPrice;
    }

    public String getGoodsinfoDescription() {
        return goodsinfoDescription;
    }

    public void setGoodsinfoDescription(String goodsinfoDescription) {
        this.goodsinfoDescription = goodsinfoDescription;
    }

    public String getGoodsinfoStock() {
        return goodsinfoStock;
    }

    public void setGoodsinfoStock(String goodsinfoStock) {
        this.goodsinfoStock = goodsinfoStock;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Goodsinfo(String goodsinfoName, String goodsinfoPic, String goodsinfoPrice, String goodsinfoDescription, String goodsinfoStock) {
        this.goodsinfoName = goodsinfoName;
        this.goodsinfoPic = goodsinfoPic;
        this.goodsinfoPrice = goodsinfoPrice;
        this.goodsinfoDescription = goodsinfoDescription;
        this.goodsinfoStock = goodsinfoStock;
    }
}
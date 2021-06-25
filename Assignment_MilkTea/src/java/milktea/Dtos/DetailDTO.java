/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milktea.Dtos;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class DetailDTO implements Serializable{
    private int detailID;
    private float price;
    private int quantity;
    private int orderID;
    private productDTO pro;

    public DetailDTO() {
    }

    public DetailDTO(int detailID, float price, int quantity, int orderID, productDTO pro) {
        this.detailID = detailID;
        this.price = price;
        this.quantity = quantity;
        this.orderID = orderID;
        this.pro = pro;
    }

    public int getDetailID() {
        return detailID;
    }

    public void setDetailID(int detailID) {
        this.detailID = detailID;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public productDTO getPro() {
        return pro;
    }

    public void setPro(productDTO pro) {
        this.pro = pro;
    }
}

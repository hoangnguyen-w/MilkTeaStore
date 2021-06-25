/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milktea.Dtos;

/**
 *
 * @author DELL
 */
public class orderDTO {
    private int orderID;
    private String dateOfOrder;
    private float total;
    private int userID;

    public orderDTO() {
    }

    public orderDTO(int orderID, String dateOfOrder, float total, int userID) {
        this.orderID = orderID;
        this.dateOfOrder = dateOfOrder;
        this.total = total;
        this.userID = userID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(String dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milktea.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import milktea.Dtos.DetailDTO;
import milktea.Dtos.orderDTO;
import milktea.ultils.DBUtils;

/**
 *
 * @author DELL
 */
public class checkOutDAO {

    public boolean insertOrder(orderDTO order) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "insert into tblOrder(dateOrder, total, userID)\n"
                        + "values(?, ?, ?)";
                stm = conn.prepareStatement(sql);

                stm.setString(1, order.getDateOfOrder());
                stm.setFloat(2, order.getTotal());
                stm.setInt(3, order.getUserID());
                check = stm.executeUpdate() > 0 ? true : check;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean insertDetail(DetailDTO detail) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "insert into tblDetail(price, quantity, orderID, productID)\n"
                        + "values(?, ?, ?, ?)";
                stm = conn.prepareStatement(sql);
                stm.setFloat(1, detail.getPrice());
                stm.setInt(2, detail.getQuantity());
                stm.setInt(3, detail.getOrderID());
                stm.setInt(4, detail.getPro().getProductID());
                check = stm.executeUpdate() > 0 ? true : check;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public int getLastOrderid() throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        int orderID = 0;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "select top 1 orderID\n"
                        + "from tblOrder\n"
                        + "order by orderID desc";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                if (rs.next()) {
                    orderID = rs.getInt("orderID");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return orderID;
    }
}

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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import milktea.Dtos.categoryDTO;
import milktea.Dtos.productDTO;
import milktea.ultils.DBUtils;

/**
 *
 * @author DELL
 */
public class productDAO {
    
    public List<productDTO> getAllProduct() throws SQLException{
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        List<productDTO> list = new ArrayList<>();
        String sql = "select productID, productName, image, price, quantity, categoryID\n" +
                        "from tblProduct";
        try{
            conn = new DBUtils().getConnection();
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while(rs.next()){
                list.add(new productDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getInt(6)));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
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
        return list;
    }
    
    public List<categoryDTO> getAllCategory() throws SQLException{
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        List<categoryDTO> list = new ArrayList<>();
        String sql = "select categoryID, categoryName\n" +
                        "from tblCategory";
        try{
            conn = new DBUtils().getConnection();
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while(rs.next()){
                list.add(new categoryDTO(rs.getInt(1), rs.getString(2)));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
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
        return list;
    }
    
    public categoryDTO getNameCate(int id) throws SQLException{
        categoryDTO dto = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        String sql = "select categoryName\n" +
                     "from tblCategory "
                +    "where categoryID= ?";
        try{
            conn = new DBUtils().getConnection();
            stm = conn.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if(rs.next()){
                String name = rs.getString("categoryName");
                dto = new categoryDTO(0, name);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
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
        return dto;
    }
    
    public productDTO getLast() throws SQLException{
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        String sql = "select top 1 productID, productName, image, price, quantity, categoryID\n" +
                        "from tblProduct\n" +
                        "order by productID desc";
        try{
            conn = new DBUtils().getConnection();
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while(rs.next()){
                return new productDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getInt(6));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
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
        return null;
    }
    
    public List<productDTO> getProductCate(String categoryID) throws SQLException{
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        List<productDTO> listProductCate = new ArrayList<>();
        String sql = "select productID, productName, image, price, quantity, categoryID\n" +
                        "from tblProduct\n" +
                        "where categoryID = ?";
        try{
            conn = new DBUtils().getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, categoryID);
            rs = stm.executeQuery();
            while(rs.next()){
                listProductCate.add(new productDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getInt(6)));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
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
        return listProductCate;
    }
    
    public List<productDTO> searchProduct(String search) throws SQLException{
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        List<productDTO> list = new ArrayList<>();
        try{
            conn = DBUtils.getConnection();
            if(conn != null){
                String sql = "select productID, productName, image, price, quantity, categoryID\n" +
                            "from tblProduct\n" +
                            "where productName like ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");
                rs = stm.executeQuery();
                while(rs.next()){
                list.add(new productDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getInt(6)));
            }   
        }
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(rs != null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        return list;
    }
    
    public productDTO getProductById(String productID) throws SQLException{
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        productDTO dto = new productDTO();
        String sql = "select productID, productName, image, price, quantity, categoryID\n" +
                    "from tblProduct\n" +
                    "where productID = ?";
        try{
            conn = new DBUtils().getConnection();
            if(conn != null){
            stm = conn.prepareStatement(sql);
            stm.setString(1, productID);
            rs = stm.executeQuery();
            if(rs.next()){
                int productId = rs.getInt("productID");
                String productName = rs.getString("productName");
                String image = rs.getString("image");
                float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                int categoryID = rs.getInt("categoryID");
                
                dto = new productDTO(productId, productName, image, price, quantity, categoryID);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if(rs != null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        return dto;
    }
    
    public boolean deleteProduct(int productId) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "DELETE FROM tblProduct WHERE productID=?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, productId);
                stm.executeUpdate();
                return true;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(productDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        
        return false;
    }
    
    public boolean addProduct(productDTO p) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "INSERT INTO tblProduct(productName, image, price, quantity, categoryID) "
                        + "VALUES(?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, p.getProductName());
                stm.setString(2, p.getImage());
                stm.setFloat(3, p.getPrice());
                stm.setInt(4, p.getQuantity());
                stm.setInt(5, p.getCategoryID());
                stm.executeUpdate();
                return true;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(productDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        
        return false;
    }
    
    public boolean updateProduct(productDTO p) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "UPDATE tblProduct SET productName=?, image=?, price=?, quantity=?, categoryID=? "
                        + " WHERE productID=? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, p.getProductName());
                stm.setString(2, p.getImage());
                stm.setFloat(3, p.getPrice());
                stm.setInt(4, p.getQuantity());
                stm.setInt(5, p.getCategoryID());
                stm.setInt(6, p.getProductID());
                stm.executeUpdate();
                return true;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(productDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        
        return false;
    }
}


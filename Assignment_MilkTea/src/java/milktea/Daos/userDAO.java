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
import milktea.Dtos.productDTO;
import milktea.Dtos.userDTO;
import milktea.ultils.DBUtils;

/**
 *
 * @author DELL
 */
public class userDAO {

    public userDTO checkLogin(String userName, String passWord) throws SQLException {
        userDTO user = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "select roleID, userID \n"
                        + "from tblUsers\n"
                        + "where userName= ? and passWord = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userName);
                stm.setString(2, passWord);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String roleID = rs.getString("roleID");
                    int userID = rs.getInt("userID");
                    user = new userDTO(userID, "", "", "", "", roleID);
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
        return user;
    }
    
    public boolean insertUser(userDTO user) throws SQLException{
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            conn = DBUtils.getConnection();
            if(conn != null){
                String sql="insert into tblUsers(userName,passWord,address,phone,roleID)\n" +
                            "values(?, ?, ?, ?, ?)";
                stm=conn.prepareStatement(sql);
                stm.setString(1, user.getUserName());
                stm.setString(2, user.getPassWord());
                stm.setString(3, user.getAddress());
                stm.setString(4, user.getPhone());
                stm.setString(5, user.getRoleID());
                check = stm.executeUpdate() > 0 ? true : check;
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
        return check;
    }
    
    public List<userDTO> getAllUser(String search) throws SQLException{
        List<userDTO> list = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            conn = DBUtils.getConnection();
            if(conn != null){
                String sql = "select userID, userName, passWord, address, phone, roleID\n" +
                                "from tblUsers\n" +
                                "where userName like ?";
                
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");
                rs = stm.executeQuery();
                while(rs.next()){
                    int userID = rs.getInt("userID");
                    String userName = rs.getString("userName");
                    String passWord = rs.getString("passWord");
                    String address = rs.getString("address");
                    String phone = rs.getString("phone");
                    String roleID = rs.getString("roleID");
                    if(list == null){ // chú ý list == null
                        list = new ArrayList<>();
                    }
                    list.add(new userDTO(userID, userName, passWord, address, phone, roleID));
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
    
    public boolean deleteUser(String userID) throws SQLException{
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            conn = DBUtils.getConnection();
            if(conn != null){
                String sql="delete from tblUsers\n" +
                            "where userID = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                check = stm.executeUpdate() > 0 ? true : check;
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
        return check;
    }
    
    public boolean updateUser(userDTO user) throws SQLException{
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            conn = DBUtils.getConnection();
            if(conn != null){
                String sql = "update tblUsers\n" +
                                "set userName = ?, passWord = ?, address = ?, phone = ?, roleID = ?\n" +
                                "where userID = ?";
                stm = conn.prepareStatement(sql);
                
                stm.setString(1, user.getUserName());
                stm.setString(2, user.getPassWord());
                stm.setString(3, user.getAddress());
                stm.setString(4, user.getPhone());
                stm.setString(5, user.getRoleID());
                stm.setInt(6, user.getUserID());
                
                check = stm.executeUpdate() > 0 ? true : check;
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
        return check;
    } 

}

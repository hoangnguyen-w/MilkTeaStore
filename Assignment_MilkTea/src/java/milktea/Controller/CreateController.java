/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milktea.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import milktea.Daos.userDAO;
import milktea.Daos.userError;
import milktea.Dtos.userDTO;

/**
 *
 * @author DELL
 */
@WebServlet(name = "CreateController", urlPatterns = {"/CreateController"})
public class CreateController extends HttpServlet {
    private static final String ERROR="createUser.jsp";
    private static final String SUCCESS="Login.html";
    

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=ERROR;
        userError error = new userError(0, "", "", "", "", "");
        try {
            String userName=request.getParameter("userName");
            String passWord=request.getParameter("passWord");
            String confirm=request.getParameter("confirm");
            String address=request.getParameter("address");
            String phone=request.getParameter("phone");
            String roleID= "2";
            boolean flag=true;
            if(userName.length()<2){
                flag=false;
                error.setUserNameError("UserName must be greater than 2");
            }
            
            if(!passWord.equals(confirm)){
                flag=false;
                error.setPassWordError("RePassWord is not the same");
            }
            
            if(address.length()<2){
                flag=false;
                error.setAddressError("Address must be greater than 2");
            }
            
            if(phone.length() > 10){
                flag=false;
                error.setPhoneError("Phone must be less than 10");
            }
            
            if(flag){
                userDAO dao = new userDAO();
                userDTO user = new userDTO(0, userName, passWord, address, phone, roleID);
                dao.insertUser(user);
                url=SUCCESS;
            }          
        }catch(Exception e){
            log("Error at CreateController: " + e.toString());
        }finally{
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

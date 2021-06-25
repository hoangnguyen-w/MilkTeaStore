/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milktea.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import milktea.Daos.productDAO;
import milktea.Daos.userDAO;
import milktea.Dtos.categoryDTO;
import milktea.Dtos.productDTO;
import milktea.Dtos.userDTO;

/**
 *
 * @author DELL
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    private final static String ERROR="Login.html";
    private final static String SUCCESS="manageAccount.jsp";
    private final static String HOME="Home.jsp";
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String userName = request.getParameter("userName");
            String passWord = request.getParameter("passWord");
            
            userDAO dao = new userDAO();
            productDAO proDao = new productDAO();
            userDTO user = dao.checkLogin(userName, passWord);
            
            if(user != null){ 
                request.setAttribute("LOGIN_USER", user);
                
                List<productDTO> list = proDao.getAllProduct(); // List product
                List<categoryDTO> listCate = proDao.getAllCategory(); 
                productDTO last = proDao.getLast();
                
                HttpSession session = request.getSession();
                session.setAttribute("listProduct", list);
                session.setAttribute("listCate", listCate);
                session.setAttribute("LastProduct", last);
                
                
                if("1".equals(user.getRoleID())){
                    url=SUCCESS;
                }
                else if ("2".equals(user.getRoleID())){
                    url=HOME;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
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

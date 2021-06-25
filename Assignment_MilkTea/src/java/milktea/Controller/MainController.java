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

/**
 *
 * @author DELL
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {
    
    private final static String ERROR="Login.html";
    private final static String LOGIN="LoginController";
    private final static String LOGOUT="LogoutController";
    private final static String CREATE="CreateController";
    private final static String SEARCH="SearchController";
    private final static String DELETE="DeleteController";
    private final static String UPDATE="UpdateController";
    private final static String CATEGORY="CategoryController";
    private final static String SEARCHPRODUCT="SearchProductController";
    private final static String ADDCART="AddCartController";
    private final static String DELETECART="DeleteCartController";
    private final static String CHECKOUT="CheckOutController";
    private final static String PRODUCT="LoadListController";
    private final static String RETURN="ReturnController";
    private final static String DELETEPRO="DeletePController";
    
    
    

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            if("Login".equals(action)){
                url=LOGIN;
            }else if("Create".equals(action)){
                url=CREATE;
            }else if("Search".equals(action)){
                url=SEARCH;
            }else if("Logout".equals(action)){
                url=LOGOUT;
            }else if("Delete".equals(action)){
                url=DELETE;
            }else if("Update".equals(action)){
                url=UPDATE;
            }else if("Category".equals(action)){
                url=CATEGORY;
            }else if("searchProduct".equals(action)){
                url=SEARCHPRODUCT;
            }else if("addProduct".equals(action)){
                url=ADDCART;
            }else if("deleteProduct".equals(action)){
                url=DELETECART;
            }else if("checkOut".equals(action)){
                url=CHECKOUT;
            }else if("Product".equals(action)){
                url=PRODUCT;
            }else if("Return".equals(action)){
                url=RETURN;
            }else if("DeleteP".equals(action)){
                url=DELETEPRO;
            }
            
        }catch(Exception e){
            log("Error at MainController:" + e.toString());
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

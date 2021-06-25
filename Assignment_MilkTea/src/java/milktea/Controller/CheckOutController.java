/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milktea.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import milktea.Daos.checkOutDAO;
import milktea.Dtos.DetailDTO;
import milktea.Dtos.orderDTO;
import milktea.Dtos.userDTO;

/**
 *
 * @author DELL
 */
@WebServlet(name = "CheckOutController", urlPatterns = {"/CheckOutController"})
public class CheckOutController extends HttpServlet {
    
    private static final String ERROR = "Home.jsp";
    private static final String SUCCESS = "Home.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            userDTO usDTO = (userDTO) session.getAttribute("LOGIN_USER");
            
            int userID = usDTO.getUserID();
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            
            String dateOrder = format.format(date);
            String total = request.getParameter("total");
            
            if (total.equals("0")) {
                orderDTO ODdto = new orderDTO(0, dateOrder, Float.parseFloat(total), userID);
                
                checkOutDAO checkOut = new checkOutDAO();
                
                if (checkOut.insertOrder(ODdto)) {
                    List<DetailDTO> listDetail = (List<DetailDTO>) session.getAttribute("listProductID");
                    int lastOrder = checkOut.getLastOrderid();
                    
                    for (DetailDTO detailDTO : listDetail) {
                        detailDTO.setOrderID(lastOrder);
                        if (checkOut.insertDetail(detailDTO)) {
                            session.setAttribute("listProductID", null);
                            session.removeAttribute("listProductID");
                            url = SUCCESS;
                        }
                    }
                }
                
            }
            /*
            insert order
            get last order id 
            
            fore edit Delist.setOrderID() = lastorderid
            insert detail
            
            url = success
            session.setAttribute("", null)
            session.remove ""
            
             */
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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

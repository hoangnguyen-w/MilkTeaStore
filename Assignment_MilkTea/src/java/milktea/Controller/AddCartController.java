/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milktea.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import milktea.Daos.productDAO;
import milktea.Dtos.DetailDTO;
import milktea.Dtos.productDTO;

/**
 *
 * @author DELL
 */
@WebServlet(name = "AddCartController", urlPatterns = {"/AddCartController"})
public class AddCartController extends HttpServlet {

    private static final String ERROR = "error.jsp";
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
            String productID = request.getParameter("productID");

            productDAO dao = new productDAO();
            productDTO proDto = dao.getProductById(productID);
            HttpSession session = request.getSession();
            boolean flag = true;
            if (proDto != null) {
                // ban đầu list rỗng
                List<DetailDTO> list = (List<DetailDTO>) session.getAttribute("listProductID"); // đã có sản phẩm rồi add vào thêm
                DetailDTO Ddto = new DetailDTO(0, proDto.getPrice(), 1, 0, proDto);// moi them

                if (list == null) {
                    list = new ArrayList<>();
                }

                for (DetailDTO detail : list) {
                    //if neu tung
                    //set quantity vs price
                    //else add
                    if (detail.getPro().getProductID() == Ddto.getPro().getProductID()) {// da trung
                        int quantity = detail.getQuantity();
                        float price = detail.getPrice();

                        detail.setQuantity(quantity + 1);
                        detail.setPrice(price * quantity);
                        flag = false;
                    }
                }
                if (flag) {
                    list.add(Ddto);
                }
                session.setAttribute("listProductID", list);
                url = SUCCESS;
            }

        } catch (Exception e) {

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

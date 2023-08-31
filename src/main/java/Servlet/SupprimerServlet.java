package Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Produit;
import repository.ProduitDataContext;

import java.io.IOException;

public class SupprimerServlet extends HttpServlet {
    private  ProduitDataContext dc=new ProduitDataContext();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("numero")!=null){
            int num=Integer.parseInt(request.getParameter("numero"));
            dc.remove(num);
        }
        response.sendRedirect("/GestProduits/HomeServlet");// RedirectToAction

    }


}

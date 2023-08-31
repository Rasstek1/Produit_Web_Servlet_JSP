package Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Produit;
import repository.ProduitDataContext;

import java.io.IOException;


public class ModifierServlet extends HttpServlet {
    private  MyDataContext dc=new MyDataContext();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Produit p=dc.find(Integer.parseInt(request.getParameter("numero")));
        request.setAttribute("produit", p);

        RequestDispatcher disp= request.getRequestDispatcher("/ModifierProduit.jsp");
        disp.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Produit p=new Produit();
        p.Mapper(request);
        dc.update(p);
        response.sendRedirect("/GestProduits/HomeServlet");
    }

}


package Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.ProduitDataContext;

import java.io.IOException;

public class ListeProduitsServlet extends HttpServlet {

    private void view(String viewname, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(viewname).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("listeproduits", new ProduitDataContext().getListeProduits());
        view("/ListeProduits.jsp", request, response);


    }


}

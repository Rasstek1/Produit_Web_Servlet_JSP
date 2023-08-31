package Servlet;

public class AjouterServlet extends HttpServlet {
    private  ProduitDataContext dc=new ProduitDataContext();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int nextNum=dc.getListeProduits().stream().max(
                        (e1,e2)->Integer.compare(e1.getNumero(), e2.getNumero()))
                .get().getNumero()+1;
        Request.setAttribute("NetNum", nextNum) ;
        RequestDispatcher disp= request.getRequestDispatcher("/AjouterProduit.jsp");
        disp.forward(request, response);  // return View(…)

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Produit p= new Produit();
        p.Mapper(request);
        dc.add(p);
        //   request.setAttribute("listeproduits", new ProduitDataContext().getListeProduits());
        //    view("/ListeProduits.jsp", request, response);
//request.getRequestDispatcher(viewname).forward(request, response);


        response.sendRedirect("/GestProduits/ListeProduitsServlet");//RedirecTotAction asp
    }

}


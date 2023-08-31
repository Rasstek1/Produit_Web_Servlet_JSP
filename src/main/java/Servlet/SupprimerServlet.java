package Servlet;

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

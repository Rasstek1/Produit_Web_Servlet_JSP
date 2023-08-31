<%--
  Created by IntelliJ IDEA.
  User: nitra
  Date: 2023-08-31
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Models.Produit" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Liste produits servlet</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>
<body>


<h1>La liste des produits</h1>
<table class="table">
    <tr><td colspan="3">
        <a href="AjouterServlet" >Ajouter</a></td>
    </tr>

    <tr><th>Numéro</th><th>Description</th><th>Prix</th><th>Taxe</th><th>Commande</th>
            <% for(Produit p:(List<Produit>)request.getAttribute("listeproduits")){%>
    <tr><td><%= p.getNumero()%></td>
        <td><%= p.getDescription()%></td>
        <td><%= p.getPrix()%></td>
        <% if(p.getTaxe()=='A'){%>
        <td>Avec taxe</td>
        <%}else{%>
        <td>Sans taxe</td>
        <%}%>
        <td>
            <a href="SupprimerServlet?numero=<%= p.getNumero()%>" class="btn btn-danger btn-lg">Supprimer</a> |
            <a href="ModifierServlet?numero=<%= p.getNumero()%>" class="btn btn-primary btn-lg">Modifier</a>
        </td>
    </tr>
        <%}%>

    <table>

</body>
</html>

Le servlet ajouter produit

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

<%--
  Created by IntelliJ IDEA.
  User: nitra
  Date: 2023-08-31
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="MesServlets.Produit" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<% Produit produit = (Produit)request.getAttribute("produit");%>
<h2>Formulaire pour modifier un produit</h2>

<form method="post" action="/GestProduits/ModifierServlet">
    <table>
        <tr>
            <td>Le numéro:</td>
            <td>                     <input type="text" id="numero" name="numero" value="<%=produit.getNumero()%>"  readonly/></td>
        </tr>
        <tr>
            <td>La description:</td>
            <td><input type="text" id="description" name="description" value="<%=produit.getDescription()%>"/></td>
        </tr>
        <tr>
            <td>Le prix</td>
            <td><input type="text" id="prix" name="prix" value="<%=produit.getPrix()%>"/></td>
        </tr>
        <tr>
            <td>
                <% if(produit.getTaxe()=='A'){%>
                <input type="radio" id="taxeA" name="taxe" value="A" checked/>Avec taxe
                <input type="radio" id="taxeS" name="taxe" value="S"/>Sans taxe
                <%}else{%>
                <input type="radio" id="taxeA" name="taxe" value="A" />Avec taxe
                <input type="radio" id="taxeS" name="taxe" value="S" checked/>Sans taxe
                <%}%>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" id="submit" name="submit" value="Valider" /> |
                <input type="reset" id="annuler" name="annuler" value="Annuler" />
            </td>
        </tr>
    </table>
</form>

</body>
</html>


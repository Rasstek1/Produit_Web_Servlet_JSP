<%--
  Created by IntelliJ IDEA.
  User: nitra
  Date: 2023-08-31
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<h2>Formulaire pour créer un produit</h2>
<form method="post" action="/GestProduits/AjouterServlet">
    <table>
        <tr>
            <td>Le numéro:</td>
            <td><input type="text" id="numero" name="numero" value="<%= request.getAttribute("NetNum") %>" readonly /></td>
        </tr>
        <tr>
            <td>La description:</td>
            <td><input type="text" id="description" name="description" /></td>
        </tr>
        <tr>
            <td>Le prix</td>
            <td><input type="text" id="prix" name="prix" /></td>
        </tr>
        <tr>
            <td>La taxe</td>
            <td>
                <input type="radio" id="taxeA" name="taxe" value="A" checked/>Avec taxe
                <input type="radio" id="taxeS" name="taxe" value="S"/>Sans taxe
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" id="submit" name="submit" value="Valider" /> |
                <input type="button" id="annuler" name="annuler" value="Annuler" />
            </td>
        </tr>
    </table>
</form>
</body>
</html>

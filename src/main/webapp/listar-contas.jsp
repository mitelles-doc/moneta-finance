<%--
  Created by IntelliJ IDEA.
  User: WIN10
  Date: 24/05/2025
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="br.com.fiap.tech.model.Conta" %>
<%@ page import="java.util.List"%>
<html>
<head>
    <title>Contas Cadastradas</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <h2>Minhas Contas</h2>
     <table border="1">
         <tr>
             <th>ID</th>
             <th>Nome</th>
             <th>Tipo</th>
             <th>Saldo</th>
             <th>Data de Criação</th>
         </tr>
         <%
             List<Conta> contas = (List<Conta>) request.getAttribute("contas");
             if (contas != null) {
                 for (Conta c : contas) {
         %>
         <tr>
             <td><%= c.getIdConta() %></td>
             <td><%= c.getNomeConta() %></td>
             <td><%= c.getTipoConta() %></td>
             <td><%= c.getSaldo() %></td>
             <td><%= c.getDataCriacao() %></td>
         </tr>
         <%
                 }
             }
         %>
     </table>
</body>
</html>

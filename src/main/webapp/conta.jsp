<%--
  Created by IntelliJ IDEA.
  User: WIN10
  Date: 24/05/2025
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastrar Conta</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <h2>Nova Conta</h2>
     <form action="conta" method="post">
         ID Conta: <input type="number" name="idConta" required ><br>
         ID Usuario: <input type="number" name="usuario" required ><br>
         Nome da Conta: <input type="text" name="nomeConta" required ><br>
         Tipo da Conta: <input type="text" name="tipoConta" required ><br>
         Saldo: <input type="number" step="0.01" name="saldo" required><br>
         <input type="submit" value="Cadastrar Conta">
     </form>
</body>
</html>

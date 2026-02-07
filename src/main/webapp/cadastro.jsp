<%--
  Created by IntelliJ IDEA.
  User: WIN10
  Date: 24/05/2025
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>

    <title>Cadastro de Usuário</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="form-container">
     <h2 class="cadastro-titulo">Cadastro de Usuário</h2>
      <form action="cadastro" method="post">

          <label for="nome">Nome:</label><br>
          <input type="text" name="nome" id="nome" required><br><br>

          <label for="email">E-mail:</label><br>
          <input type="email" name="email" id="email" required><br><br>

          <label for="cpf">CPF:</label><br>
          <input type="text" name="cpf" id="cpf" required><br><br>

          <label for="senha">Senha:</label><br>
          <input type="password" name="senha" id="senha" required><br><br>

          <label for="confirmarSenha">Confirmar Senha:</label>
          <input type="password" name="confirmarSenha" id="confirmarSenha" required><br><br>

          <input type="submit" value="Cadastrar">
      </form>
      <br>
      <a href="index.jsp" class="botao-voltar">Voltar</a>
</div>
</body>
</html>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login - Moneta</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="login">
     <h1>Login</h1>
<!-- mensagem de erro, caso tenha-->
<% if ("1".equals(request.getParameter("erro"))) { %>
     <p style="color:red;">Usuário ou senha inválidos.</p>
     <% } %>

<form action="login" method="post">
    <label for="email">Email:</label><br>
    <input type="email" name="email" id="email" class="form-input" required><br><br>

    <label for="senha">Senha:</label><br>
    <input type="password" name="senha" id="senha" required><br><br>

    <button type="submit" >Entrar</button>
</form>
</div>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="br.com.fiap.tech.model.Usuario" %>
<%
    HttpSession sessao = request.getSession();
    Usuario usuario = (Usuario) sessao.getAttribute("usuario");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menu - Moneta</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>
<div class="menu-container">
    <h1>Moneta</h1>

    <% if (usuario != null) { %>
    <p class="usuario-nome">Olá, <%= usuario.getNome() %>!</p>
    <% } %>

    <div class="menu-grid">
        <a href="receita" class="menu-button"><i class="fas fa-coins"></i> Receita</a>
        <a href="gastos" class="menu-button"><i class="fas fa-wallet"></i> Gastos</a>
        <a href="conta" class="menu-button"><i class="fas fa-university"></i> Meu Banco</a>
        <a href="economia" class="menu-button"><i class="fas fa-piggy-bank"></i> Economias</a>

        <a href="#" class="menu-button" title="Em breve: acompanhe suas metas financeiras.">
            <i class="fas fa-bullseye"></i> Metas
        </a>
        <a href="#" class="menu-button" title="Em breve: organize suas finanças por categoria.">
            <i class="fas fa-th-list"></i> Categorias
        </a>
        <a href="#" class="menu-button" title="Em breve: veja o extrato completo das suas movimentações.">
            <i class="fas fa-file-invoice-dollar"></i> Extrato
        </a>
        <a href="#" class="menu-button" title="Em breve: personalize as configurações da sua conta.">
            <i class="fas fa-cog"></i> Ajustes
        </a>
    </div>

    <br>
    <a href="login.jsp" class="sair-button">Sair</a>
</div>
</body>
</html>


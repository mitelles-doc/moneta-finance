<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="br.com.fiap.tech.model.Gasto" %>
<%
    List<Gasto> listaGastos = (List<Gasto>) request.getAttribute("gastos");
    String mensagem = (String) request.getAttribute("mensagem");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gastos</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
    <h1>Gastos</h1>

    <form action="gastos" method="post" class="form-padrao">
        <input type="text" name="nomeGasto" placeholder="Nome do gasto" required>
        <input type="number" name="valorGasto" step="0.01" placeholder="Valor do gasto" required>
        <button type="submit" class="btn-adicionar">Adicionar</button>
    </form>

    <div class="lista-dados">
        <% if (mensagem != null) { %>
        <p class="mensagem"><%= mensagem %></p>
        <% } else if (listaGastos != null && !listaGastos.isEmpty()) { %>
        <ul>
            <% for (Gasto gasto : listaGastos) { %>
            <li>
                <strong><%= gasto.getNomeGasto() %></strong> - R$ <%= gasto.getValorGasto() %>
                <form action="gastos" method="post" style="display:inline;">
                    <input type="hidden" name="idGasto" value="<%= gasto.getIdGasto() %>">
                    <button type="submit" name="acao" value="excluir" class="btn-excluir">Excluir</button>
                </form>
            </li>
            <% } %>
        </ul>
        <% } else { %>
        <p class="mensagem">Você não possui gastos cadastrados.</p>
        <% } %>
    </div>

    <a href="menu.jsp" class="btn-voltar">Voltar ao Menu</a>
</div>
</body>
</html>


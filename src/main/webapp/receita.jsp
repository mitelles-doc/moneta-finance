<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, br.com.fiap.tech.model.Receita" %>
<%
    List<Receita> receitas = (List<Receita>) request.getAttribute("receitas");
%>
<html>
<head>
    <title>Receitas</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="container">
<h1>Receitas</h1>

<% if (receitas == null || receitas.isEmpty()) { %>
<p>Você ainda não possui uma receita cadastrada.</p>
<% } else { %>
<table border="1">
    <tr>
        <th>Descrição</th>
        <th>Valor</th>
        <th>Data</th>
        <th>Ação</th>
    </tr>
    <% for (Receita receita : receitas) { %>
    <tr>
        <td><%= receita.getDescricao() %></td>
        <td>R$ <%= receita.getValor() %></td>
        <td><%= receita.getDataReceita() %></td>
        <td>
            <form method="post" action="excluir-receita">
                <input type="hidden" name="id" value="<%= receita.getId() %>"/>
                <button type="submit">Excluir</button>
            </form>
        </td>
    </tr>
    <% } %>
</table>
<% } %>

<hr>

<h3>Adicionar Receita</h3>
<form method="post" action="receita">
    Descrição: <input type="text" name="descricao" required><br>
    Valor: <input type="number" name="valor" step="0.01" required><br>
    Data: <input type="date" name="dataReceita" required><br>
    <button type="submit">Cadastrar</button>
    <a href="menu.jsp" class="voltar-button">Voltar ao Menu</a>
</form>
</div>
</body>
</html>


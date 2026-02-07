<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="br.com.fiap.tech.model.Economia" %>
<html>
<head>
  <title>Economia</title>
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2>Objetivos de Economia</h2>

<form action="economia" method="post">
  <label>Nome do Objetivo:</label>
  <input type="text" name="nomeObjetivo" required><br>

  <label>Valor Objetivo:</label>
  <input type="number" step="0.01" name="valorObjetivo" required><br>

  <label>Valor Atual:</label>
  <input type="number" step="0.01" name="valorAtual" required><br>

  <label>Data de Início:</label>
  <input type="date" name="dataInicio" required><br>

  <input type="submit" value="Salvar">
</form>

<hr>

<table border="1">
  <tr>
    <th>Objetivo</th>
    <th>Valor Objetivo</th>
    <th>Valor Atual</th>
    <th>Data Início</th>
  </tr>
  <%
    List<Economia> economias = (List<Economia>) request.getAttribute("economias");
    if (economias != null) {
      for (Economia eco : economias) {
  %>
  <tr>
    <td><%= eco.getNomeObjetivo() %></td>
    <td>R$ <%= eco.getValorObjetivo() %></td>
    <td>R$ <%= eco.getValorAtual() %></td>
    <td><%= eco.getDataInicio() %></td>
  </tr>
  <% }
  }
  %>
</table>
</body>
</html>


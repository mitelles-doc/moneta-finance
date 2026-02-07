<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nova Economia</title>
</head>
<body>
<h2>Cadastro de Objetivo de Economia</h2>
<form action="cadastrar-economia" method="post">
    Nome do Objetivo: <input type="text" name="nomeObjetivo" required><br>
    Valor Objetivo: <input type="number" step="0.01" name="valorObjetivo" required><br>
    Valor Atual: <input type="number" step="0.01" name="valorAtual" required><br>
    Data de Início: <input type="date" name="dataInicio" required><br>
    <input type="submit" value="Salvar">
</form>
</body>
</html>

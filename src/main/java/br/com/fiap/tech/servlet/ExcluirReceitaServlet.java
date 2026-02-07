package br.com.fiap.tech.servlet;

import br.com.fiap.tech.dao.ReceitaDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/excluir-receita")
public class ExcluirReceitaServlet extends HttpServlet {
    private ReceitaDAO dao = new ReceitaDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        dao.excluir(id);
        resp.sendRedirect("receita");
    }
}


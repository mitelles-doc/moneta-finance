package br.com.fiap.tech.servlet;

import br.com.fiap.tech.dao.ReceitaDAO;
import br.com.fiap.tech.model.Receita;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/receita")
public class ReceitaServlet extends HttpServlet {

    private ReceitaDAO dao = new ReceitaDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Receita> lista = dao.listar();
        req.setAttribute("receitas", lista);
        req.getRequestDispatcher("receita.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String descricao = req.getParameter("descricao");
        double valor = Double.parseDouble(req.getParameter("valor"));
        Date data = Date.valueOf(req.getParameter("dataReceita"));

        Receita receita = new Receita(descricao, valor, data);
        dao.cadastrar(receita);

        resp.sendRedirect("receita");
    }
}


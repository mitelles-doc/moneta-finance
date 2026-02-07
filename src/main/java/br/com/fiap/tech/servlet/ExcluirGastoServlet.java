package br.com.fiap.tech.servlet;

import br.com.fiap.tech.dao.GastoDAO;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/excluir-gasto")
public class ExcluirGastoServlet extends HttpServlet {

    private GastoDAO dao = new GastoDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        dao.excluir(id);
        resp.sendRedirect("gastos");
    }
}


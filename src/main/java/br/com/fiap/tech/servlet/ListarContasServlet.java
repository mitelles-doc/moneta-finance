package br.com.fiap.tech.servlet;

import br.com.fiap.tech.dao.ContaDAO;
import br.com.fiap.tech.model.Conta;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/listar-Contas")
public class ListarContasServlet extends HttpServlet {

    private ContaDAO contaDAO;

    @Override
    public void init() {
        contaDAO = new ContaDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idUsuario = 1;

        List<Conta> contas = contaDAO.listarContas(idUsuario);
        request.setAttribute("contas", contas);
        request.getRequestDispatcher("/listar-contas.jsp").forward(request, response);
    }
}

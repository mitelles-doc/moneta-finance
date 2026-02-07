package br.com.fiap.tech.servlet;

import br.com.fiap.tech.dao.ContaDAO;
import br.com.fiap.tech.model.Conta;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/conta")
public class ContaServlet  extends HttpServlet {

    private ContaDAO contaDAO;

    @Override
    public void init() throws ServletException {
        contaDAO = new ContaDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Conta conta = new Conta();
            conta.setIdConta(Integer.parseInt(request.getParameter("idConta")));
            conta.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario")));
            conta.setNomeConta(request.getParameter("nomeConta"));
            conta.setTipoConta(request.getParameter("tipoConta"));
            conta.setSaldo(Double.parseDouble(request.getParameter("saldo")));
            conta.setDataCriacao(LocalDate.parse(request.getParameter("dataCriacao")));

            contaDAO.cadastrarConta(conta);

            response.sendRedirect("menu.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("erro.jsp");
        }
    }
}
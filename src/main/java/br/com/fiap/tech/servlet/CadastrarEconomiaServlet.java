package br.com.fiap.tech.servlet;

import br.com.fiap.tech.dao.EconomiaDAO;
import br.com.fiap.tech.model.Economia;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/cadastrar-economia")
public class CadastrarEconomiaServlet extends HttpServlet {

    private EconomiaDAO economiaDAO;

    @Override
    public void init() {
        economiaDAO = new EconomiaDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nomeObjetivo = request.getParameter("nomeObjetivo");
        double valorObjetivo = Double.parseDouble(request.getParameter("valorObjetivo"));
        double valorAtual = Double.parseDouble(request.getParameter("valorAtual"));
        LocalDate dataInicio = LocalDate.parse(request.getParameter("dataInicio"));

        Economia economia = new Economia();
        economia.setIdUsuario(1); // Substitua pelo ID real da sessão
        economia.setNomeObjetivo(nomeObjetivo);
        economia.setValorObjetivo(valorObjetivo);
        economia.setValorAtual(valorAtual);
        economia.setDataInicio(dataInicio);

        economiaDAO.cadastrar(economia);

        response.sendRedirect("menu.jsp");
    }
}


package br.com.fiap.tech.servlet;


import br.com.fiap.tech.dao.EconomiaDAO;
import br.com.fiap.tech.model.Economia;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/economia")
public class EconomiaServlet extends HttpServlet {

    private EconomiaDAO economiaDAO;

    @Override
    public void init() {
        economiaDAO = new EconomiaDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idUsuario = 1; // Substituir pelo ID da sessão se aplicável
        List<Economia> economias = economiaDAO.listar(idUsuario);
        request.setAttribute("economias", economias);
        request.getRequestDispatcher("economia.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nomeObjetivo = request.getParameter("nomeObjetivo");
        double valorObjetivo = Double.parseDouble(request.getParameter("valorObjetivo"));
        double valorAtual = Double.parseDouble(request.getParameter("valorAtual"));
        LocalDate dataInicio = LocalDate.parse(request.getParameter("dataInicio"));

        Economia economia = new Economia();
        economia.setIdUsuario(1); // Substituir depois pela sessão
        economia.setNomeObjetivo(nomeObjetivo);
        economia.setValorObjetivo(valorObjetivo);
        economia.setValorAtual(valorAtual);
        economia.setDataInicio(dataInicio);

        economiaDAO.cadastrar(economia);
        response.sendRedirect("economia");
    }
}



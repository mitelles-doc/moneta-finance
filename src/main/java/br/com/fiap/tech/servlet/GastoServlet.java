package br.com.fiap.tech.servlet;

import br.com.fiap.tech.dao.GastoDAO;
import br.com.fiap.tech.model.Gasto;
import br.com.fiap.tech.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/gastos")
public class GastoServlet extends HttpServlet {

    private GastoDAO gastoDAO;

    @Override
    public void init() throws ServletException {
        gastoDAO = new GastoDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// Recuperar o usuário da sessão
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

        if (usuario == null) {
            response.sendRedirect("login.jsp");
            return;
        }

// Capturar parâmetros do formulário
        String nomeConta = request.getParameter("nomeConta");
        String tipoConta = request.getParameter("tipoConta");
        String valorStr = request.getParameter("valor");

// Validação básica
        if (nomeConta == null || tipoConta == null || valorStr == null ||
                nomeConta.isEmpty() || tipoConta.isEmpty() || valorStr.isEmpty()) {
            response.sendRedirect("gastos.jsp?erro=campos-obrigatorios");
            return;
        }

        try {
            double valor = Double.parseDouble(valorStr);

            Gasto gasto = new Gasto();
            gasto.setIdUsuario(usuario.getIdUsuario());
            gasto.setNomeConta(nomeConta);
            gasto.setTipoConta(tipoConta);
            gasto.setSaldo(valor);
            gasto.setDataCriacao(LocalDate.now());

            gastoDAO.inserir(gasto);

            response.sendRedirect("gastos.jsp");

        } catch (NumberFormatException e) {
            response.sendRedirect("gastos.jsp?erro=valor-invalido");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("erro.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}


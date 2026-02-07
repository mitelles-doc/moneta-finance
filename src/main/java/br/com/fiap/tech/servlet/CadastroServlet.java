package br.com.fiap.tech.servlet;

import br.com.fiap.tech.dao.UsuarioDAO;
import br.com.fiap.tech.model.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

@WebServlet("/cadastro")
public class CadastroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String cpf = request.getParameter("cpf");
        String confirmarSenha = request.getParameter("confirmarSenha");

        if (!senha.equals(confirmarSenha)) {
            request.setAttribute("mensagem", "Senhas não coincidem!");
            request.getRequestDispatcher("/cadastro.jsp").forward(request, response);
            return;
        }

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setCpf(cpf);
        usuario.setDataCriacao(Date.valueOf(LocalDate.now()));

        UsuarioDAO dao = new UsuarioDAO();
        dao.cadastrar(usuario);

        response.sendRedirect("login.jsp");
    }
}

package br.com.fiap.tech.servlet;


import br.com.fiap.tech.dao.UsuarioDAO;
import br.com.fiap.tech.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/login")
    public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = dao.buscarPorEmailESenha(email, senha);

        if (usuario != null) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);
            response.sendRedirect("menu.jsp");
        } else {
            request.setAttribute("erro","Email ou senha inválidos. Tente novamente.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        }
}
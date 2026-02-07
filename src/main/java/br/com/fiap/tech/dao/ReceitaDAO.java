package br.com.fiap.tech.dao;

import br.com.fiap.tech.model.Receita;
import br.com.fiap.tech.db.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReceitaDAO {

    public void cadastrar(Receita receita) {
        String sql = "INSERT INTO receita (descricao, valor, data_receita) VALUES (?, ?, ?)";

        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, receita.getDescricao());
            stmt.setDouble(2, receita.getValor());
            stmt.setDate(3, receita.getDataReceita());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Receita> listar() {
        List<Receita> receitas = new ArrayList<>();
        String sql = "SELECT * FROM receita";

        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Receita receita = new Receita();
                receita.setId(rs.getInt("id"));
                receita.setDescricao(rs.getString("descricao"));
                receita.setValor(rs.getDouble("valor"));
                receita.setDataReceita(rs.getDate("data_receita"));
                receitas.add(receita);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return receitas;
    }

    public void excluir(int id) {
        String sql = "DELETE FROM receita WHERE id = ?";

        try (Connection con = ConnectionManager.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


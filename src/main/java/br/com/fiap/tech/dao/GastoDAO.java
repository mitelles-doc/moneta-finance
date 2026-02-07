package br.com.fiap.tech.dao;

import br.com.fiap.tech.model.Gasto;
import br.com.fiap.tech.db.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GastoDAO {

    public void inserir(Gasto gasto) {
        String sql = "INSERT INTO gasto (id_usuario, nome_gasto, valor_gasto, data_gasto) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, gasto.getIdUsuario());
            stmt.setString(2, gasto.getNomeGasto());
            stmt.setDouble(3, gasto.getValorGasto());
            stmt.setDate(4, Date.valueOf(gasto.getDataGasto()));

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Gasto> listarPorUsuario(int idUsuario) {
        List<Gasto> lista = new ArrayList<>();
        String sql = "SELECT * FROM gasto WHERE id_usuario = ? ORDER BY data_gasto DESC";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Gasto g = new Gasto();
                g.setIdGasto(rs.getInt("id_gasto"));
                g.setIdUsuario(rs.getInt("id_usuario"));
                g.setNomeGasto(rs.getString("nome_gasto"));
                g.setValorGasto(rs.getDouble("valor_gasto"));
                g.setDataGasto(rs.getDate("data_gasto").toLocalDate());
                lista.add(g);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    public void excluir(int idGasto) {
        String sql = "DELETE FROM gasto WHERE id_gasto = ?";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idGasto);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}


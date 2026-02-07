package br.com.fiap.tech.dao;

import br.com.fiap.tech.model.Economia;
import br.com.fiap.tech.db.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EconomiaDAO {

    public void cadastrar(Economia economia) {
        String sql = "INSERT INTO economia (ID_USUARIO, NOME_OBJETIVO, VALOR_OBJETIVO, VALOR_ATUAL, DATA_INICIO) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, economia.getIdUsuario());
            stmt.setString(2, economia.getNomeObjetivo());
            stmt.setDouble(3, economia.getValorObjetivo());
            stmt.setDouble(4, economia.getValorAtual());
            stmt.setDate(5, java.sql.Date.valueOf(economia.getDataInicio()));

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Economia> listar(int idUsuario) {
        List<Economia> lista = new ArrayList<>();
        String sql = "SELECT * FROM economia WHERE ID_USUARIO = ?";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Economia economia = new Economia();
                economia.setIdEconomia(rs.getInt("ID_ECONOMIA"));
                economia.setIdUsuario(rs.getInt("ID_USUARIO"));
                economia.setNomeObjetivo(rs.getString("NOME_OBJETIVO"));
                economia.setValorObjetivo(rs.getDouble("VALOR_OBJETIVO"));
                economia.setValorAtual(rs.getDouble("VALOR_ATUAL"));
                economia.setDataInicio(rs.getDate("DATA_INICIO").toLocalDate());

                lista.add(economia);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }


}


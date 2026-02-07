package br.com.fiap.tech.dao;

import br.com.fiap.tech.model.Conta;
import br.com.fiap.tech.db.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ContaDAO {

    public void cadastrarConta(Conta conta) {
        String sql = "INSERT INTO conta (ID_CONTA, ID_USUARIO, NOME_CONTA, TIPO_CONTA, SALDO, DATA_CRIACAO)" +
                "VALUES (seq_conta.nextval, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionManager.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, conta.getIdConta());
            stmt.setInt(2, conta.getIdUsuario());
            stmt.setString(3, conta.getNomeConta());
            stmt.setString(4, conta.getTipoConta());
            stmt.setDouble(5, conta.getSaldo());
            stmt.setDate(6,  java.sql.Date.valueOf(conta.getDataCriacao()));

            stmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e ) {
            e.printStackTrace();
        }
    }
    public List<Conta> listarContas(int idUsuario) {
        List<Conta> lista = new ArrayList<>();
        String sql = "SELECT * FROM conta WHERE ID_USUARIO = ?";

        try (Connection conn = ConnectionManager.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Conta conta = new Conta();
                conta.setIdConta(rs.getInt("ID_CONTA"));
                conta.setIdUsuario(rs.getInt("ID_USUARIO"));
                conta.setNomeConta(rs.getString("NOME_CONTA"));
                conta.setTipoConta(rs.getString("TIPO_CONTA"));
                conta.setSaldo(rs.getDouble("SALDO"));
                conta.setDataCriacao(rs.getDate("DATA_CRIACAO").toLocalDate());
                lista.add(conta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }



}

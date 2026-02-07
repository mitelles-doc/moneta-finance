package br.com.fiap.tech.db;

import br.com.fiap.tech.dao.UsuarioDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
   public static Connection getConnection() throws SQLException, ClassNotFoundException {
       Class.forName("oracle.jdbc.driver.OracleDriver");
       String url ="jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
       String user = "RM560473";
       String password = "271095";
       return DriverManager.getConnection(url, user, password);
   }


}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.SingleConnection;
import model.ModelLogin;

public class DaoLoginRepository {
	private Connection connection;

	public DaoLoginRepository() {
		connection = SingleConnection.getConnection();
	}

	public boolean validarAutenticacao(ModelLogin modellogin) throws SQLException {
		String sql = "select * from modellogin where login = ? and senha = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, modellogin.getLogin());
		statement.setString(2,modellogin.getSenha());
		ResultSet resultSet = statement.executeQuery();
		if(resultSet.next()) {
			return true;
		}

         return false;
	}


}

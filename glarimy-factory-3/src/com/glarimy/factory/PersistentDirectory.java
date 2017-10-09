package com.glarimy.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PersistentDirectory implements Directory {
	private Connection connection;
	private PreparedStatement statement;

	public PersistentDirectory() throws DirectoryException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/glarimy?user=root&password=admin");
			statement = connection.prepareStatement("select * from directory where name=?");
		} catch (Exception e) {
			throw new DirectoryException(e);
		}
	}

	public long find(String name) throws DirectoryException {
		try {
			statement.setString(1, name);
			ResultSet rs = null;
			try {
				rs = statement.executeQuery();
				if (rs.next())
					return rs.getLong("phonenumber");
				else
					throw new DirectoryException("No contact found!");
			} finally {
				rs.close();
			}
		} catch (Exception e) {
			throw new DirectoryException(e);
		}
	}

	public void finalize() {
		try {
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

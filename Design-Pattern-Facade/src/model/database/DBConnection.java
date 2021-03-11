package model.database;

import java.sql.Connection;

public interface DBConnection {
	DBConnection clone();
	Connection getConnection();
}

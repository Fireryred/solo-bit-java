package model;

import java.sql.Connection;

public interface DBConnection {
	DBConnection clone();
	Connection getConnection();
}

package utility;

public class DBUtility {
	public static String CREATETABLEPRODUCT = "CREATE TABLE IF NOT EXISTS product("
			+ "id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,"
			+ "name VARCHAR(150),"
			+ "img VARCHAR(255),"
			+ "price DOUBLE(10, 2))";
	public static String CREATETABLEPRODUCTDETAILS = "CREATE TABLE IF NOT EXISTS product_details("
			+ "processor VARCHAR(150),"
			+ "product_id INT(6) UNSIGNED,"
			+ "FOREIGN KEY (product_id) REFERENCES product(id))";
	public static String CREATETABLEUSER = "CREATE TABLE IF NOT EXISTS user("
			+ "id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,"
			+ "username VARCHAR(255),"
			+ "password VARCHAR(255),"
			+ "email VARCHAR(255))";
	public static String CREATETABLEUSERDETAILS = "CREATE TABLE IF NOT EXISTS user_details("
			+ "credit_card VARCHAR(255),"
			+ "user_id INT(6) UNSIGNED,"
			+ "FOREIGN KEY (user_id) REFERENCES user(id))";
	public static String CREATETABLEORDER = "CREATE TABLE IF NOT EXISTS orders("
			+ "id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,"
			+ "has_ordered BIT,"
			+ "user_id INT(6) UNSIGNED,"
			+ "FOREIGN KEY (user_id) REFERENCES user(id))";
	public static String CREATETABLEORDERDETAILS = "CREATE TABLE IF NOT EXISTS order_details("
			+ "quantity INT(11),"
			+ "order_id INT(6) UNSIGNED,"
			+ "FOREIGN KEY (order_id) REFERENCES orders(id),"
			+ "product_id INT(6) UNSIGNED,"
			+ "FOREIGN KEY (product_id) REFERENCES product(id))";
	
	public static String INSERTPRODUCT = "INSERT INTO product(name, img, price) VALUES(?,?,?)";
	public static String INSERTPRODUCTDETAILS = "INSERT INTO product_details(product_id, processor) VALUES(?,?)";
	public static String INSERTUSER = "INSERT INTO user(username, password, email) VALUE(?,?,?)";
	public static String INSERTORDER = "INSERT INTO orders(user_id, has_ordered) VALUE(?, 0)";
	public static String INSERTORDERDETAILS = "INSERT INTO order_details(quantity, order_id, product_id) VALUES(?,?,?)";
	
	public static String UPDATEORDER =
			"UPDATE orders SET has_ordered = ? "
			+ "WHERE user_id = ? AND has_ordered = 0";
	
	public static String SELECTALLPRODUCTS = 
			"SELECT * FROM product "
			+ "INNER JOIN product_details "
			+ "ON product.id = product_details.product_id";
	public static String SELECTPRODUCT = 
			"SELECT product.id, product.name, product.img, product.price, product_details.processor FROM product "
			+ "INNER JOIN product_details "
			+ "ON product.id = product_details.product_id "
			+ "WHERE product.name LIKE ?";
	public static String SELECTIDPRODUCT = 
			"SELECT id FROM product "
			+ "WHERE name LIKE ?";
	public static String SELECTUSERNAME = 
			"SELECT * FROM user "
			+ "WHERE username = ?";
	public static String SELECTUSER = 
			"SELECT username FROM user "
			+ "WHERE username = ? AND password = ?";
	public static String SELECTORDERNUMBER = 
			"SELECT id, has_ordered FROM orders "
			+ "WHERE user_id = ? AND has_ordered = 0";
	public static String SELECTORDERDETAILS = 
			"SELECT * FROM order_details "
			+ "WHERE product_id = ? AND order_id = ?";
	public static String SELECTORDERS = 
			"SELECT product_id, product.name, product.img, product.price, quantity, orders.user_id, orders.has_ordered "
			+ "FROM order_details "
			+ "INNER JOIN orders ON orders.id = order_details.order_id "
			+ "INNER JOIN product ON product.id = order_details.product_id "
			+ "WHERE order_id = ? AND orders.has_ordered = 0";
}
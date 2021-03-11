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
	
	public static String INSERTPRODUCT = "INSERT INTO product(name, img, price) VALUES(?,?,?)";
	public static String INSERTPRODUCTDETAILS = "INSERT INTO product_details(product_id, processor) VALUES(?,?)";
	
	public static String SELECTALLPRODUCTS = 
			"SELECT * FROM product "
			+ "INNER JOIN product_details "
			+ "ON product.id = product_details.product_id";
	public static String SELECTPRODUCT = 
			"SELECT product.name, product.img, product.price, product_details.processor FROM product "
			+ "INNER JOIN product_details "
			+ "ON product.id = product_details.product_id "
			+ "WHERE product.name LIKE ?";
	public static String SELECTIDPRODUCT = 
			"SELECT id FROM product"
			+ "WHERE name LIKE ?";
}
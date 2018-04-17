package store.entity;

import java.util.Arrays;
import java.util.Formatter;

public class ProductManager extends User {
	public static final int MAX_PRODUCTS = 100;
	
	private Product[] managedProducts = new Product[MAX_PRODUCTS];
	private int numProducts = 0;
	
	public Product[] getProducts() {
		return Arrays.copyOf(managedProducts, numProducts);
	}

	public ProductManager() {
	}

	public ProductManager(long id) {
		super(id);
	}

	public ProductManager(String username, String email, String fName, String lName, String password, Role role) {
		super(username, email, fName, lName, password, role);
	}

	public ProductManager(String username, String email, String fName, String lName, String password) {
		super(username, email, fName, lName, password);
	}
	
	public ProductManager(String username, String email, String fName, String lName, 
			String password, Product[] products) {
		super(username, email, fName, lName, password);
		for(Product p: products)
			addProduct(p);
	}

	public void addProduct(Product newProduct) {
		managedProducts[numProducts++] = newProduct;
		Arrays.sort(managedProducts, 0, numProducts);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder
				.append("ID: ").append(getId())
				.append("\nUsername: ").append(getUsername())
				.append("\nEmail: ").append(getEmail())
				.append("\nName: ").append(getfName()).append(" ").append(getlName())
				.append("\nRole: ").append(getRole())
				.append("Products:");
		Product[] products = getProducts();
		for(Product p : products) {
			builder.append(String.format("\n   %-25s | %-15s | %7.2f", p.getName(), p.getSupplier(), p.getPrice()));
		}
		builder.append("\n");
		return builder.toString();
	}

	
}

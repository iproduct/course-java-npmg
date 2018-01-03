package store.entity;

import java.util.Arrays;

public class ProductManager extends User {
	public static final int MAX_PRODUCTS = 100;
	
	private Product[] managedProducts = new Product[MAX_PRODUCTS];
	private int numProducts = 0;
	
	public Product[] getProducts() {
		return Arrays.copyOf(managedProducts, numProducts);
	}

	public void addProducts(Product newProduct) {
		managedProducts[numProducts++] = newProduct;
		Arrays.sort(managedProducts, 0, numProducts);
	}

}

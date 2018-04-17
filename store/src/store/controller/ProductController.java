package store.controller;

import java.util.Arrays;

import store.entity.Product;
import store.entity.ProductManager;
import store.entity.Unit;

public class ProductController {
	public static final int MAX_PRODUCTS = 1000;
	private Product[] products;
	private int size = 0;
	
	public ProductController() {
		products = new Product[MAX_PRODUCTS];
	}	
	
	public ProductController(int capacity) {
		products = new Product[capacity];
	}

	public Product findById(long id) {
		int indexFound = Arrays.binarySearch(products, new Product(id));
		if (indexFound < 0) return null;
		return products[indexFound];
	}

	public static void main(String[] args) {
		Product[] products = {
				new Product("DVD R/W", 5.90, 50, "Sony", Unit.UNITS),
				new Product("Wireless Mouse", 19, 150, "Microsoft", Unit.UNITS),
				new Product("NVIDIA GeForce 1080 TI", 1150, 25, "Sony", Unit.UNITS),
		};
		
		ProductManager pm1 = new ProductManager("ipetrov", "ipetrov@gmail.com", 
				"Ivan", "Petrov", "abcd123", Arrays.copyOfRange(products, 1, 3));
		
		System.out.println(pm1);
		
	}

}

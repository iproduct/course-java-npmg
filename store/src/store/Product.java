package store;

public class Product {
	private static long counter = 0;
	private long id = Product.counter++;
	private String name;
	private double price;
	private double weight;
	private String supplier;
	private Unit unit = Unit.UNITS;
	
	public Product() {
	}

	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public Product(String name, double price, double weight, String supplier, Unit unit) {
		super();
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.supplier = supplier;
		this.unit = unit;
	}
	
	public Product(Product other) {
		id = other.id;
	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [id=").append(id).append(", name=").append(name).append(", price=").append(price)
				.append(", weight=").append(weight).append(", supplier=").append(supplier).append(", unit=")
				.append(unit).append("]");
		return builder.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

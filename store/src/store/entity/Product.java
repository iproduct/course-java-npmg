package store.entity;

public class Product implements Comparable<Product> {
	private static long counter = 0;
	private long id = Product.counter++;
	private String name;
	private double price;
	private double weight;
	private String supplier;
	private Unit unit = Unit.UNITS;
	
	public Product() {
	}
	
	public Product(long id) {
		this.id = id;
	}

	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public Product(String name, double price, double weight, String supplier, Unit unit) {
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.supplier = supplier;
		this.unit = unit;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	/**
	 * Copy constructor
	 * @param other product to be copied
	 */
	public Product(Product other) {
		id = other.id;
		name = other.name;
		price = other.price;
		weight = other.weight;
		supplier = other.supplier;
		unit = other.unit;
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

	@Override
	public int compareTo(Product other) {
		return (int) Math.signum(getId() - other.getId());
	}

}

package properties;

public class Toys {
	
	private String name;
	private String type;
	private double price;
	private int version;
	
	public Toys(String name, String type, double price, int version) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.version = version;
	}
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getVersion() {
		return version;
	}

}

package properties;

public class Toy {
	
	private String name;
	private String type;
	private double price;
	private int version;
	private String icon; 
	
	public Toy(String name, String type, double price, int version, String icon) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.version = version;
		this.icon = icon; 
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
	
	public String getIcon() {
		return icon; 
	}

}

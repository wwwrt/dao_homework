package pojo;
import java.sql.Date;
import java.time.LocalDate;
public class cars {

	private int id;
	private String name;
	private double price;
	LocalDate manufactured = LocalDate.now();
	
	public cars(int id, String name, double price, LocalDate manufactured) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.manufactured = manufactured;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public LocalDate getManufactured() {
		return manufactured;
	}

	public void setManufactured(LocalDate manufactured) {
		this.manufactured = manufactured;
	}
	
	
	
}
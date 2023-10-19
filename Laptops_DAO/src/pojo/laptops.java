package pojo;
import java.sql.Date;
import java.time.LocalDate;
public class laptops {

	private int id;
	private String brand;
	private double price;
	LocalDate manufactured = LocalDate.now();
	
	public laptops(int id, String brand, double price, LocalDate manufactured) {
		super();
		this.id = id;
		this.brand = brand;
		this.price = price;
		this.manufactured = manufactured;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
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
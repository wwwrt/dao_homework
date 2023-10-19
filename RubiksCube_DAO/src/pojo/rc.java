package pojo;
import java.sql.Date;
import java.time.LocalDate;
public class rc {

	private String brand;
	private double weight;
	private int sides;
	LocalDate manufactured = LocalDate.now();
	
	public rc(String brand, double weight, int sides, LocalDate manufactured) {
		super();
		this.brand = brand;
		this.weight = weight;
		this.sides = sides;
		this.manufactured = manufactured;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public int getSides() {
		return sides;
	}
	public void setSides(int sides) {
		this.sides = sides;
	}
	public LocalDate getManufactured() {
		return manufactured;
	}
	public void setManufactured(LocalDate manufactured) {
		this.manufactured = manufactured;
	}
	public void setManufactured(Date date) {
		// TODO Auto-generated method stub
		
	}
	
	
}

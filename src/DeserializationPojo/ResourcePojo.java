package DeserializationPojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResourcePojo {
	private int id;
	private String name;
	private int year;
	private String color;
	@JsonProperty("pantone_value")
	private String pantoneValue;
	
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
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getPantoneValue() {
		return pantoneValue;
	}
	public void setPantone_value(String pantoneValue) {
		this.pantoneValue = pantoneValue;
	}
}

package app.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Region{

	@Id
	private String id;
	
	@NotNull(message = "error.name.notnull")
	private String name;
	
	@NotNull(message = "error.coefficient.notnull")
	private Double coefficient;
	
	public Region() {
		super();
	}
	
	public Region(String name, Double coefficient) {
		super();
		this.name = name;
		this.coefficient = coefficient;
	}

	//@Override
	public String getId() {
		return id;
	}
	
	//@Override
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Double getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(Double coefficient) {
		this.coefficient = coefficient;
	}

	@Override
	public String toString() {
		return "Region [id=" + id + ", name=" + name + ", coefficient=" + coefficient + "]";
	}

	
}

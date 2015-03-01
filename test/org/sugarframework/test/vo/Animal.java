package org.sugarframework.test.vo;

import java.util.Date;
import java.util.Random;

public class Animal {
	private int id;

	private int weight;

	private String name;

	private String family;

	private Date birthdate;

	private Long longNumber;

	private Boolean hasAntlers = Boolean.FALSE;

	public Animal() {
		super();
		this.setId(new Random().nextInt());
	}

	public Animal(int weight, String name, String family, Date birthdate, Long longNumber, Boolean hasAntlers) {
		super();
		this.setId(new Random().nextInt());
		this.weight = weight;
		this.name = name;
		this.family = family;
		this.birthdate = birthdate;
		this.longNumber = longNumber;
		this.hasAntlers = hasAntlers;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Long getLongNumber() {
		return longNumber;
	}

	public void setLongNumber(Long longNumber) {
		this.longNumber = longNumber;
	}

	public Boolean getHasAntlers() {
		return hasAntlers;
	}

	public void setHasAntlers(Boolean hasAntlers) {
		this.hasAntlers = hasAntlers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "AnimalVO [weight=" + weight + ", name=" + name + ", family=" + family + ", birthdate=" + birthdate
				+ ", longNumber=" + longNumber + ", hasAntlers=" + hasAntlers + "]";
	}

}

package com.mongo.example.mongodemo.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="cars")
public class RestCar {
	@Id
	private int id;
	private int level;
	private int speed;
	private String door;
	private String trunk;
	private String ac;
	private int minTemp = 16;
	private int maxTemp = 30;
	
//	@Size(min = 0, max = 5)
	private int sunroofSlider;
	
	

	public RestCar(int id, int level, int speed, String door, String trunk, String ac, int minTemp, int maxTemp,
		int sunroofSlider) {
	super();
	this.id = id;
	this.level = level;
	this.speed = speed;
	this.door = door;
	this.trunk = trunk;
	this.ac = ac;
	this.minTemp = minTemp;
	this.maxTemp = maxTemp;
	this.sunroofSlider = sunroofSlider;
}

	public RestCar() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getDoor() {
		return door;
	}

	public void setDoor(String door) {
		this.door = door;
	}

	public int getMinTemp() {
		return minTemp;
	}

	public void setMinTemp(int minTemp) {
		this.minTemp = minTemp;
	}

	public int getMaxTemp() {
		return maxTemp;
	}

	public void setMaxTemp(int maxTemp) {
		this.maxTemp = maxTemp;
	}

	public int getSunroofSlider() {
		return sunroofSlider;
	}

	public void setSunroofSlider(int sunroofSlider) {
		this.sunroofSlider = sunroofSlider;
	}
	
	public String getTrunk() {
		return trunk;
	}

	public void setTrunk(String trunk) {
		this.trunk = trunk;
	}

	public String getAc() {
		return ac;
	}

	public void setAc(String ac) {
		this.ac = ac;
	}

	@Override
	public String toString() {
		return "RestCar [id=" + id + ", level=" + level + ", speed=" + speed + ", door=" + door + ", minTemp=" + minTemp
				+ ", maxTemp=" + maxTemp + ", sunroofSlider=" + sunroofSlider + "]";
	}
}

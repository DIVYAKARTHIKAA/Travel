package com.example.demo.travel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Travel2")
public class Travel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String Source;
	private String Destination;
	private String Passenger_name;
	private String Cost;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSource() {
		return Source;
	}
	public void setSource(String source) {
		Source = source;
	}
	public String getDestination() {
		return Destination;
	}
	public void setDestination(String destination) {
		Destination = destination;
	}
	public String getPassenger_name() {
		return Passenger_name;
	}
	public void setPassenger_name(String passenger_name) {
		Passenger_name = passenger_name;
	}
	public String getCost() {
		return Cost;
	}
	public void setCost(String cost) {
		Cost = cost;
	}
	public Travel(Long id, String source, String destination, String passenger_name, String cost) {
		super();
		this.id = id;
		Source = source;
		Destination = destination;
		Passenger_name = passenger_name;
		Cost = cost;
	}
	@Override
	public String toString() {
		return "Travel [id=" + id + ", Source=" + Source + ", Destination=" + Destination + ", Passenger_name="
				+ Passenger_name + ", Cost=" + Cost + "]";
	}
	
	public Travel() {
		
	}

}

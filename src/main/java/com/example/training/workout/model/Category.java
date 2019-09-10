package com.example.training.workout.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	private long id;

	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

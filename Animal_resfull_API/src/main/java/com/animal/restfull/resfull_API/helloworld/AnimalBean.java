package com.animal.restfull.resfull_API.helloworld;

public class AnimalBean {

	private Object message;

	public AnimalBean(String message) {
		// TODO Auto-generated constructor stub
		this.message = message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}

	public Object getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "AnimalBean [message=" + message + "]";
	}

	
}

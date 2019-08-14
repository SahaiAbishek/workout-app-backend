package com.training.assignment1;

public class User {

	private double salary;
	private double increment;
	private int incrementFrequency;
	private double deductions;
	private int deductionsFrequency;

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getIncrement() {
		return increment;
	}

	public void setIncrement(double increment) {
		this.increment = increment;
	}

	public int getIncrementFrequency() {
		return incrementFrequency;
	}

	public void setIncrementFrequency(int incrementFrequency) {
		this.incrementFrequency = incrementFrequency;
	}

	public double getDeductions() {
		return deductions;
	}

	public void setDeductions(double deductions) {
		this.deductions = deductions;
	}

	public int getDeductionsFrequency() {
		return deductionsFrequency;
	}

	public void setDeductionsFrequency(int deductionsFrequency) {
		this.deductionsFrequency = deductionsFrequency;
	}

	@Override
	public String toString() {
		return "User [salary=" + salary + ", increment=" + increment + ", incrementFrequency=" + incrementFrequency
				+ ", deductions=" + deductions + ", deductionsFrequency=" + deductionsFrequency + "]";
	}

}

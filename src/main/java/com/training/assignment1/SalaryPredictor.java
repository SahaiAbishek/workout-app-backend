package com.training.assignment1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SalaryPredictor {

	private class Record {
		private double salary;
		private double incAmount;
		private double decAmount;

		public Record(double salary, double incAmount, double decAmount) {
			super();
			this.salary = salary;
			this.incAmount = incAmount;
			this.decAmount = decAmount;
		}

	}

	private List<Record> records = new ArrayList<>();

	public void incrementReport(User user, int years) {
		System.out.println("Increment REPORT----------------------------");
		double startSal = user.getSalary();
		int incFreq = user.getIncrementFrequency();
		double ded = user.getDeductions();
		double inc = user.getIncrement();
		for (int i = 0; i < years; i++) {
			double incAmount = 0;
			double dedAmount = 0;
			for (int j = 0; j < incFreq; j++) {

				incAmount = (startSal * inc) / 100;
				dedAmount = (startSal * ded) / 100;
				System.out.println("Starting salary : " + startSal + " Number of Increments : " + incFreq
						+ " Increment % :" + inc + " Increment Amount : " + incAmount);
				Record record = new Record(startSal, incAmount, dedAmount);
				records.add(record);
				startSal += incAmount;
			}

		}
	}

	public void deductionReport(User user, int years) {
		System.out.println("Decrement REPORT----------------------------");
		int dedFreq = user.getDeductionsFrequency();
		double ded = user.getDeductions();
		for (Record record : records) {
			System.out.println("Starting salary : " + record.salary + " Number of Decrements : " + dedFreq
					+ " Decrement % :" + ded + " Decrement Amount : " + record.decAmount);
		}
	}

	public void precdition() {
		System.out.println("Prediction --------------------------------");
		for (Record record : records) {
			double salGrowth = record.salary + record.incAmount - record.decAmount;
			System.out.println("Starting salary : " + record.salary + " Increment Amount : " + record.incAmount
					+ " Deduction Amount : " + record.decAmount + " Salary Growth :" + salGrowth);
		}
	}

	public void predictIncrement() {
		User user = new User();
		Scanner sc = new Scanner(System.in);
		System.out.println("Input the starting salary :");
		double sal = sc.nextDouble();
		if (sal < 1) {
			System.out.println("Please make sure your staring salary is greater than 1");
			sal = sc.nextDouble();
		}
		user.setSalary(sal);
		System.out.println("Input the increment % : ");
		double inc = sc.nextDouble();
		if (inc < 0) {
			System.out.println("Please enter a positive value(-ve means decrement)");
			inc = sc.nextDouble();
		}
		user.setIncrement(inc);
		System.out.println("Please input increment Frequency : ");
		int freq = sc.nextInt();
		if (freq < 1) {
			System.out.println("Please enter value greater than or equal to 1");
			freq = sc.nextInt();
		}
		user.setIncrementFrequency(freq);
		System.out.println("Input the Deduction % : ");
		double ded = sc.nextDouble();
		if (ded < 0) {
			System.out.println("Please enter a positive value :");
			ded = sc.nextDouble();
		}
		user.setDeductions(ded);
		System.out.println("Please input deduction Frequency : ");
		int dedFreq = sc.nextInt();
		if (dedFreq < 1) {
			System.out.println("Please enter value greater than or equal to 1");
			dedFreq = sc.nextInt();
		}
		user.setDeductionsFrequency(dedFreq);
		System.out.println("Please input time farme in years for the report");
		int years = sc.nextInt();
		incrementReport(user, years);
		deductionReport(user, years);
		precdition();
		sc.close();
	}

	public static void main(String[] args) {
		SalaryPredictor predictor = new SalaryPredictor();
		predictor.predictIncrement();
	}

}

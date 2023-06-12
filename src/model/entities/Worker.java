package model.entities;

import java.util.ArrayList;
import java.util.List;

import model.entities.enums.WorkerLevel;

public class Worker {

	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	private List<HourContract> contracts = new ArrayList<>();
	private Department department;
	
	public Worker() {
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	public Double income(Integer year, Integer month) {		
		
		double total = baseSalary;
		for (HourContract c : contracts) {
			int cYear = c.getDate().getYear();
			int cMonth = c.getDate().getMonthValue();
			
			if (cYear == year && cMonth == month) {
				total += c.totalValue();
			}
		}
		return total;
	}
}

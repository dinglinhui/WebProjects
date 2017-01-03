package com.journaldev.utils;

import java.util.*;

public class EmployeeSortTest {

	public static void main(String[] args) {

		Employee[] staff = new Employee[3];
		staff[0] = new Employee("harry Hacker", 35000);
		staff[1] = new Employee("carl cracke", 75000);
		staff[2] = new Employee("tony Tester", 38000);
		Arrays.sort(staff); // sort方法可以实现对对象数组排序，但是必须实现 Comparable接口
		/*
		 * Comparable接口原型为： public interface Comparable<T> { int compareTo（T
		 * other);//接口的中方法自动属于public方法 }
		 */
		for (Employee e : staff)
			System.out.println("id=" + e.getId() + "  name=" + e.getName()
					+ ".salary=" + e.getSalary());
	}
}

/*
 * 因为要实现对Employee对象的排序，所以在Employee类中要实现Comparable接口， 也就是要实现comepareTo()方法
 */
class Employee implements Comparable<Employee> {
	public Employee(String n, double s) {
		name = n;
		salary = s;
		Random ID = new Random();
		id = ID.nextInt(10000000);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}

	public int compareTo(Employee other) {
		if (id < other.id) // 这里比较的是什么 sort方法实现的就是按照此比较的东西从小到大排列
			return -1;
		if (id > other.id)
			return 1;
		return 0;
	}

	private int id;
	private String name;
	private double salary;
}
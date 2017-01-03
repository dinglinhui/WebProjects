package com.journaldev.designpattern.creational.abstractfactory;

public class ComputerFactory {

	public static Computer getComputer(AbstractComputerFactory factory) {
		return factory.createComputer();
	}
}
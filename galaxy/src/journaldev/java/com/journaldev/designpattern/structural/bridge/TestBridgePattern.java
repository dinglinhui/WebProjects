package com.journaldev.designpattern.structural.bridge;

public class TestBridgePattern {

	public static void main(String[] args) {
		Shape tri = new Triangle(new RedColor());
		tri.applyColor();

		Shape pent = new Pentagon(new GreenColor());
		pent.applyColor();
	}

}
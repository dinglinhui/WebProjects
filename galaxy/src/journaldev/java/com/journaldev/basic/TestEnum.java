package com.journaldev.basic;

public class TestEnum {

	public static void main(String[] args) {

		for (EnumTest e : EnumTest.values()) {
			System.out.println(e.toString());
		}

		EnumTest test = EnumTest.TUE;
		switch (test) {
		case MON:
			System.out.println("今天是星期一");
			break;
		case TUE:
			System.out.println("今天是星期二");
			break;
		default:
			System.out.println(test);
			break;
		}
	}
}
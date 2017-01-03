package com.journaldev.java8.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JButton;

public class Lambda {

	public static void main(String[] args) {

		String[] players = { "Rafael Nadal", "Novak Djokovic", "Stanislas Wawrinka", "David Ferrer", "Roger Federer",
				"Andy Murray", "Tomas Berdych", "Juan Martin Del Potro", "Richard Gasquet", "John Isner" };

		// 1.1 使用匿名内部类根据 name 排序 players
		Arrays.sort(players, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return (s1.compareTo(s2));
			}
		});

		Arrays.sort(players, (String s1, String s2) -> (s1.compareTo(s2)));
		Arrays.asList(players).forEach(n -> System.out.println(n));

		//
		List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
		List<Integer> distinct = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
		System.out.printf("Original List : %s, " + "Square Without duplicates : %s %n", numbers, distinct);

		//
		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
		IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
		System.out.println("Highest prime number in List : " + stats.getMax());
		System.out.println("Lowest prime number in List : " + stats.getMin());
		System.out.println("Sum of all prime numbers : " + stats.getSum());
		System.out.println("Average of all prime numbers : " + stats.getAverage());

		// Java 8 way:
		new Thread(() -> System.out.println("In Java8, Lambda expression rocks !!")).start();

		JButton show = new JButton("Show");
		show.addActionListener((e) -> {
			System.out.println("Light, Camera, Action !! Lambda expressions Rocks");
		});

		// In Java 8:
		Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API")
				.forEach(n -> System.out.println(n));

		System.out.println(Arrays.asList(1, 2, 3).stream().mapToInt((x) -> x).summaryStatistics().getSum());

		Object o = (Runnable) () -> {
			System.out.println("hi");
		}; // correct
		System.out.println((Runnable) () -> {
		});
	}
}

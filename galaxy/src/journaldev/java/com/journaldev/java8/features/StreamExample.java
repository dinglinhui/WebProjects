package com.journaldev.java8.features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {

	public static void main(String[] args) {
		// Stream filter() example
		List<Integer> myList = new ArrayList<>();
		for (int i = 0; i < 100; i++)
			myList.add(i);

		// sequential stream
		Stream<Integer> sequentialStream = myList.stream();

		// parallel stream
		Stream<Integer> parallelStream = myList.parallelStream();

		// using lambda with Stream API, filter example
		Stream<Integer> highNums = parallelStream.filter(p -> p > 90);

		// using lambda in forEach
		highNums.forEach(p -> System.out.println("High Nums parallel=" + p));

		Stream<Integer> highNumsSeq = sequentialStream.filter(p -> p > 90);
		highNumsSeq.forEach(p -> System.out.println("High Nums sequential=" + p));

		// Stream map() example
		Stream<String> names = Stream.of("aBc", "d", "ef");
		System.out.println(names.map(s -> {
			return s.toUpperCase();
		}).collect(Collectors.toList()));
		// prints [ABC, D, EF]

		// Stream sorted() example
		Stream<String> names2 = Stream.of("aBc", "d", "ef", "123456");
		List<String> reverseSorted = names2.sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(reverseSorted); // [ef, d, aBc, 123456]

		Stream<String> names3 = Stream.of("aBc", "d", "ef", "123456");
		List<String> naturalSorted = names3.sorted().collect(Collectors.toList());
		System.out.println(naturalSorted); // [123456, aBc, d, ef]

		// Stream flatMap() example
		Stream<List<String>> namesOriginalList = Stream.of(Arrays.asList("Pankaj"), Arrays.asList("David", "Lisa"),
				Arrays.asList("Amit"));
		// flat the stream from List<String> to String stream
		Stream<String> flatStream = namesOriginalList.flatMap(strList -> strList.stream());
		flatStream.forEach(System.out::println);

		// Stream reduce() example
		Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);
		Optional<Integer> intOptional = numbers.reduce((i, j) -> {
			return i * j;
		});
		if (intOptional.isPresent())
			System.out.println("Multiplication = " + intOptional.get()); // 120

		// Stream count() example
		Stream<Integer> numbers1 = Stream.of(1, 2, 3, 4, 5);

		System.out.println("Number of elements in stream=" + numbers1.count()); // 5

		// Stream forEach() example
		Stream<Integer> numbers2 = Stream.of(1, 2, 3, 4, 5);
		numbers2.forEach(i -> System.out.print(i + ",")); // 1,2,3,4,5,

		// Stream match() examples
		Stream<Integer> numbers3 = Stream.of(1, 2, 3, 4, 5);
		System.out.println("Stream contains 4? " + numbers3.anyMatch(i -> i == 4));
		// Stream contains 4? true

		Stream<Integer> numbers4 = Stream.of(1, 2, 3, 4, 5);
		System.out.println("Stream contains all elements less than 10? " + numbers4.allMatch(i -> i < 10));
		// Stream contains all elements less than 10? true

		Stream<Integer> numbers5 = Stream.of(1, 2, 3, 4, 5);
		System.out.println("Stream doesn't contain 10? " + numbers5.noneMatch(i -> i == 10));
		// Stream doesn't contain 10? true

		// Stream findFirst() example
		Stream<String> names4 = Stream.of("Pankaj", "Amit", "David", "Lisa");
		Optional<String> firstNameWithD = names4.filter(i -> i.startsWith("D")).findFirst();
		if (firstNameWithD.isPresent()) {
			System.out.println("First Name starting with D=" + firstNameWithD.get()); // David
		}
	}

}
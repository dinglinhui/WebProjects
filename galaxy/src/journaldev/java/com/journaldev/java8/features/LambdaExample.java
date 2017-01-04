package com.journaldev.java8.features;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

//()->{} // No parameters; void result
//
//()->42 // No parameters, expression body
//()->null // No parameters, expression body
//()->{return 42;} // No parameters, block body with return
//()->{System.gc();} // No parameters, void block body
//
//// Complex block body with multiple returns
//()->{if(true)return 10;else{int result=15;for(int i=1;i<10;i++)result*=i;return result;}}
//
//(int x)->x+1 // Single declared-type argument
//(int x)->{return x+1;} // same as above
//(x)->x+1 // Single inferred-type argument, same as below
//x->x+1 // Parenthesis optional for single inferred-type case
//
//(String s)->s.length() // Single declared-type argument
//(Thread t)->{t.start();} // Single declared-type argument
//s->s.length() // Single inferred-type argument
//t->{t.start();} // Single inferred-type argument
//
//(int x,int y)->x+y // Multiple declared-type parameters
//(x,y)->x+y // Multiple inferred-type parameters
//(x,final y)->x+y // Illegal: can't modify inferred-type parameters
//(x,int y)->x+y // Illegal: can't mix inferred and declared types

public class LambdaExample {
	private static boolean isPrime(int number) {
		IntPredicate isDivisible = index -> number % index == 0;

		return number > 1 && IntStream.range(2, number).noneMatch(isDivisible);
	}

	public static int sumWithCondition(List<Integer> numbers, Predicate<Integer> predicate) {
		return numbers.parallelStream().filter(predicate).mapToInt(i -> i).sum();
	}

	public static int findSquareOfMaxOdd(List<Integer> numbers) {
		return numbers.stream().filter(LambdaExample::isOdd).filter(LambdaExample::isGreaterThan3)
				.filter(LambdaExample::isLessThan11).max(Comparator.naturalOrder()).map(i -> i * i).get();
	}

	public static boolean isOdd(int i) {
		return i % 2 != 0;
	}

	public static boolean isGreaterThan3(int i) {
		return i > 3;
	}

	public static boolean isLessThan11(int i) {
		return i < 11;
	}

	public static void main(String[] args) {
//		Integer[] data = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
//		List<Integer> numbers = Arrays.asList(data);
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
		// sum of all numbers
		System.out.println(sumWithCondition(numbers, n -> true));
		// sum of all even numbers
		System.out.println(sumWithCondition(numbers, i -> i % 2 == 0));
		// sum of all numbers greater than 5
		System.out.println(sumWithCondition(numbers, i -> i > 5));

		System.out.println(findSquareOfMaxOdd(numbers));

		System.out.println(isPrime(2));
	}
}

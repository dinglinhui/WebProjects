package com.journaldev.utils;

import java.util.TreeSet;
import java.util.Comparator;

class NameTag {
	
	private String name;
	private int number;

	public NameTag(String name, int number) {
		super();
		this.name = name;
		this.number = number;
	}

	public NameTag() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "NameTag [name=" + name + ", number=" + number + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}

class NumComparator implements Comparator<NameTag> {
	public int compare(NameTag left, NameTag right) {
		return (left.getNumber() - right.getNumber());
	}
}

public class CollectionNine {
	public static void main(String arg[]) {
		new CollectionNine();
	}

	CollectionNine() {
		NumComparator comparator = new NumComparator();
		TreeSet<NameTag> set = new TreeSet<NameTag>(comparator);
		set.add(new NameTag("Agamemnon", 300));
		set.add(new NameTag("Cato", 400));
		set.add(new NameTag("Plato", 100));
		set.add(new NameTag("Zeno", 200));
		set.add(new NameTag("Archimedes", 500));
		for (NameTag tag : set)
			System.out.println(tag);
	}
}
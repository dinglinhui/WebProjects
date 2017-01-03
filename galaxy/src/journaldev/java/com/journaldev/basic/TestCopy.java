package com.journaldev.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

class Weiz implements Serializable {// 对象序列化，要实现这个接口
	private static final long serialVersionUID = 123L;// 序列化版本
	double x;

	public Weiz(double a) {
		x = a;
	}
}

public class TestCopy {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO code application logic here
		List<Weiz> lst = new ArrayList<Weiz>();
		lst.add(new Weiz(1.1));
		lst.add(new Weiz(1.2));
		lst.add(new Weiz(1.3));
		System.out.println("复制前，原始lst：");
		for (int i = 0; i < lst.size(); ++i) {
			System.out.println(lst.get(i) + " " + lst.get(i).x);
		}
		// System.out.println();
		// 构造函数复制 浅拷贝
		List<Weiz> lst2 = new ArrayList<Weiz>(lst);
		// lst2.set(1, new Weiz(2.1));
		lst2.get(0).x = 2.1;
		System.out.println("构造函数复制且修改后，新的lst2：");
		for (int i = 0; i < lst2.size(); ++i) {
			System.out.println(lst2.get(i) + " " + lst2.get(i).x);
		}
		System.out.println("构造函数复制且修改后，原始lst:");
		for (int i = 0; i < lst.size(); ++i) {
			System.out.println(lst.get(i) + " " + lst.get(i).x);
		}

		List<Weiz> lst3 = deepCopy(lst);
		lst3.get(0).x = 3.1;
		System.out.println("对象序列化复制且修改后，新的lst3：");
		for (int i = 0; i < lst3.size(); ++i) {
			System.out.println(lst3.get(i) + " " + lst3.get(i).x);
		}
		System.out.println("对象序列化复制且修改后，原始lst:");
		for (int i = 0; i < lst.size(); ++i) {
			System.out.println(lst.get(i) + " " + lst.get(i).x);
		}

		List<Weiz> lst4 = deepCopy(lst);
		lst4.get(0).x = 4.1;
		System.out.println("对象序列化复制且修改后，新的lst4：");
		for (int i = 0; i < lst4.size(); ++i) {
			System.out.println(lst4.get(i) + " " + lst4.get(i).x);
		}
		System.out.println("对象序列化复制且修改后，原始lst:");
		for (int i = 0; i < lst.size(); ++i) {
			System.out.println(lst.get(i) + " " + lst.get(i).x);
		}
	}

	// 关键代码 执行序列化和反序列化 进行深度拷贝
	public static <T> List<T> deepCopy(List<T> src) throws IOException, ClassNotFoundException {
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(byteOut);
		out.writeObject(src);

		ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
		ObjectInputStream in = new ObjectInputStream(byteIn);
		@SuppressWarnings("unchecked")
		List<T> dest = (List<T>) in.readObject();
		return dest;
	}

	// 关键代码 执行序列化和反序列化 进行深度拷贝，写法不同而已，作用一样
	// 个人习惯 怎么喜欢怎么来！
	public List deepCopy2(List src) throws IOException, ClassNotFoundException {
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(byteOut);
		out.writeObject(src);
		ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
		ObjectInputStream in = new ObjectInputStream(byteIn);
		List dest = (List) in.readObject();
		return dest;
	}
}
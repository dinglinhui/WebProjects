package com.journaldev.basic;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author User
 */
public class TestInteger {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
		List<Integer> lst = new LinkedList<Integer>();
		lst.add(new Integer(1));
		lst.add(3);
		lst.add(5);
		lst.add(7);
		lst.add(9);
		// test1
		for (int i = 0; i < 10; ++i) {
			if (lst.contains(i) == false)
				lst.add(i);
			else
				System.out.println("true:" + i);// 结果显示，直接用int型的i值来判断包含关系，可以正确判断
		}
		for (int i = 0; i < lst.size(); ++i) {// 输出
			System.out.print(lst.get(i) + " ");
		}
		System.out.println();
		// test2
		lst.remove(1);// 结果显示，删除了索引1号位的元素
		for (int i = 0; i < lst.size(); ++i) {// 输出
			System.out.print(lst.get(i) + " ");
		}
		System.out.println();
		// test3
		lst.remove(new Integer(1));// 结果显示，删除了值为1的元素
		for (int i = 0; i < lst.size(); ++i) {// 输出
			System.out.print(lst.get(i) + " ");
		}
		System.out.println();
	}
}

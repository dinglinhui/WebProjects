package com.journaldev.designpattern.visitor;

public interface ItemElement {

	public int accept(ShoppingCartVisitor visitor);
}
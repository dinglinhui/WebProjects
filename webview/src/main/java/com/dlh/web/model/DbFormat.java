package com.dlh.web.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class DbFormat {

	@NumberFormat(style = Style.NUMBER, pattern = "#.##")
	private double money;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date date;

	public double getMoney() {
		return money;
	}

	public Date getDate() {
		return date;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}

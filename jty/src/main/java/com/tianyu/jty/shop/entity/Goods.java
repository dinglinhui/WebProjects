package com.tianyu.jty.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 */
@Entity
@Table(name = "goods")
public class Goods implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer id;
	private GoodsType goodsType;
	private String name;
	private String cover;
	private String img;
	private Double price;
	private Double marketPrice;
	private String introduce;
	private String brief;
	private String isSold;
	private Integer sales;
	private Double postage;
	private Integer pv;

	// Constructors

	/** default constructor */
	public Goods() {
	}

	/** minimal constructor */
	public Goods(GoodsType goodsType, String name, String cover, String img,
			Double price) {
		this.goodsType = goodsType;
		this.name = name;
		this.cover = cover;
		this.img = img;
		this.price = price;
	}

	/** full constructor */
	public Goods(GoodsType goodsType, String name, String cover, String img,
			Double price, Double marketPrice, String introduce, String brief,
			String isSold, Integer sales, Double postage, Integer pv) {
		this.goodsType = goodsType;
		this.name = name;
		this.cover = cover;
		this.img = img;
		this.price = price;
		this.marketPrice = marketPrice;
		this.introduce = introduce;
		this.brief = brief;
		this.isSold = isSold;
		this.sales = sales;
		this.postage = postage;
		this.pv = pv;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TYPE_ID", nullable = false)
	public GoodsType getGoodsType() {
		return this.goodsType;
	}

	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}

	@Column(name = "NAME", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "COVER", nullable = false)
	public String getCover() {
		return this.cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	@Column(name = "IMG", nullable = false)
	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Column(name = "PRICE", nullable = false, precision = 22, scale = 0)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "MARKET_PRICE", precision = 22, scale = 0)
	public Double getMarketPrice() {
		return this.marketPrice;
	}

	public void setMarketPrice(Double marketPrice) {
		this.marketPrice = marketPrice;
	}

	@Column(name = "INTRODUCE")
	public String getIntroduce() {
		return this.introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	@Column(name = "BRIEF")
	public String getBrief() {
		return this.brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	@Column(name = "IS_SOLD")
	public String getIsSold() {
		return this.isSold;
	}

	public void setIsSold(String isSold) {
		this.isSold = isSold;
	}

	@Column(name = "SALES")
	public Integer getSales() {
		return this.sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

	@Column(name = "POSTAGE", precision = 22, scale = 0)
	public Double getPostage() {
		return this.postage;
	}

	public void setPostage(Double postage) {
		this.postage = postage;
	}

	@Column(name = "PV")
	public Integer getPv() {
		return this.pv;
	}

	public void setPv(Integer pv) {
		this.pv = pv;
	}

}
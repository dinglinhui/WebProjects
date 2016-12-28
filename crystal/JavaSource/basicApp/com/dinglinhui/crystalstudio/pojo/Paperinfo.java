package com.dinglinhui.crystalstudio.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Paperinfo")
public class Paperinfo implements Serializable {

	private static final long serialVersionUID = -2029487649168634808L;

	private String PAPERID;
	private String TITLE;
	private String ABSTRACT;
	private String SUBJECT;
	private String PROFESSION;
	private String DIRECT;
	private String PROGRAME;
	private String DATABASE;
	private String SUMMARY;
	private Date INPUTDATE;
	private String COMPOSITE;
	private Integer ISCODE;
	private String SCORE;
	private String PRICE;
	private Integer BUYTIMES;
	private String PATH;
	private String PROVIDER;
	private String PAPERINDEX;
	private String PAPERDATE;
	private String FJPRICE;
	private String BZ;
	private String TEACHER;

	public Paperinfo() {
	}

	public Paperinfo(String PAPERID, String TITLE, String ABSTRACT,
			String SUBJECT, String PROFESSION, String DIRECT, String PROGRAME,
			String DATABASE, String SUMMARY, Date INPUTDATE, String COMPOSITE,
			Integer ISCODE, String SCORE, String PRICE, Integer BUYTIMES,
			String PATH, String PROVIDER, String PAPERINDEX, String PAPERDATE,
			String FJPRICE, String BZ, String TEACHER) {
		this.PAPERID = PAPERID;
		this.TITLE = TITLE;
		this.ABSTRACT = ABSTRACT;
		this.SUBJECT = SUBJECT;
		this.PROFESSION = PROFESSION;
		this.DIRECT = DIRECT;
		this.PROGRAME = PROGRAME;
		this.DATABASE = DATABASE;
		this.SUMMARY = SUMMARY;
		this.INPUTDATE = INPUTDATE;
		this.COMPOSITE = COMPOSITE;
		this.ISCODE = ISCODE;
		this.SCORE = SCORE;
		this.PRICE = PRICE;
		this.BUYTIMES = BUYTIMES;
		this.PATH = PATH;
		this.PROVIDER = PROVIDER;
		this.PAPERINDEX = PAPERINDEX;
		this.PAPERDATE = PAPERDATE;
		this.FJPRICE = FJPRICE;
		this.BZ = BZ;
		this.TEACHER = TEACHER;
	}

	public String getPAPERID() {
		return PAPERID;
	}

	public void setPAPERID(String pAPERID) {
		PAPERID = pAPERID;
	}

	public String getTITLE() {
		return TITLE;
	}

	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}

	public String getABSTRACT() {
		return ABSTRACT;
	}

	public void setABSTRACT(String aBSTRACT) {
		ABSTRACT = aBSTRACT;
	}

	public String getSUBJECT() {
		return SUBJECT;
	}

	public void setSUBJECT(String sUBJECT) {
		SUBJECT = sUBJECT;
	}

	public String getPROFESSION() {
		return PROFESSION;
	}

	public void setPROFESSION(String pROFESSION) {
		PROFESSION = pROFESSION;
	}

	public String getDIRECT() {
		return DIRECT;
	}

	public void setDIRECT(String dIRECT) {
		DIRECT = dIRECT;
	}

	public String getPROGRAME() {
		return PROGRAME;
	}

	public void setPROGRAME(String pROGRAME) {
		PROGRAME = pROGRAME;
	}

	public String getDATABASE() {
		return DATABASE;
	}

	public void setDATABASE(String dATABASE) {
		DATABASE = dATABASE;
	}

	public String getSUMMARY() {
		return SUMMARY;
	}

	public void setSUMMARY(String sUMMARY) {
		SUMMARY = sUMMARY;
	}

	public Date getINPUTDATE() {
		return INPUTDATE;
	}

	public void setINPUTDATE(Date iNPUTDATE) {
		INPUTDATE = iNPUTDATE;
	}

	public String getCOMPOSITE() {
		return COMPOSITE;
	}

	public void setCOMPOSITE(String cOMPOSITE) {
		COMPOSITE = cOMPOSITE;
	}

	public int getISCODE() {
		return ISCODE;
	}

	public void setISCODE(Integer iSCODE) {
		ISCODE = iSCODE;
	}

	public String getSCORE() {
		return SCORE;
	}

	public void setSCORE(String sCORE) {
		SCORE = sCORE;
	}

	public String getPRICE() {
		return PRICE;
	}

	public void setPRICE(String pRICE) {
		PRICE = pRICE;
	}

	public int getBUYTIMES() {
		return BUYTIMES;
	}

	public void setBUYTIMES(Integer bUYTIMES) {
		BUYTIMES = bUYTIMES;
	}

	public String getPATH() {
		return PATH;
	}

	public void setPATH(String pATH) {
		PATH = pATH;
	}

	public String getPROVIDER() {
		return PROVIDER;
	}

	public void setPROVIDER(String pROVIDER) {
		PROVIDER = pROVIDER;
	}

	public String getPAPERINDEX() {
		return PAPERINDEX;
	}

	public void setPAPERINDEX(String pAPERINDEX) {
		PAPERINDEX = pAPERINDEX;
	}

	public String getPAPERDATE() {
		return PAPERDATE;
	}

	public void setPAPERDATE(String pAPERDATE) {
		PAPERDATE = pAPERDATE;
	}

	public String getFJPRICE() {
		return FJPRICE;
	}

	public void setFJPRICE(String fJPRICE) {
		FJPRICE = fJPRICE;
	}

	public String getBZ() {
		return BZ;
	}

	public void setBZ(String bZ) {
		BZ = bZ;
	}

	public String getTEACHER() {
		return TEACHER;
	}

	public void setTEACHER(String tEACHER) {
		TEACHER = tEACHER;
	}

}

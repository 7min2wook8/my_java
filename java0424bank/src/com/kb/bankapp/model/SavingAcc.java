package com.kb.bankapp.model;

public class SavingAcc {
	private String sano;	// 예금번호
	private KbCust kbcu;	// 고객
	private Account ac;		// 계좌
	private String sadate;
	private String saInOut;
	private int saMoney;
	private int saJango;
	private String transfer;
	public SavingAcc(String sano, KbCust kbcu, Account ac, 
		String sadate, String saInOut, int saMoney, int saJango,
		String transfer) {
		super();
		this.sano = sano;
		this.kbcu = kbcu;
		this.ac = ac;
		this.sadate = sadate;
		this.saInOut = saInOut;
		this.saMoney = saMoney;
		this.saJango = saJango;
		this.transfer = transfer;
	}
	public String getSano() {
		return sano;
	}
	public void setSano(String sano) {
		this.sano = sano;
	}
	public KbCust getKbcu() {
		return kbcu;
	}
	public void setKbcu(KbCust kbcu) {
		this.kbcu = kbcu;
	}
	public Account getAc() {
		return ac;
	}
	public void setAc(Account ac) {
		this.ac = ac;
	}
	public String getSadate() {
		return sadate;
	}
	public void setSadate(String sadate) {
		this.sadate = sadate;
	}
	public String getSaInOut() {
		return saInOut;
	}
	public void setSaInOut(String saInOut) {
		this.saInOut = saInOut;
	}
	public int getSaMoney() {
		return saMoney;
	}
	public void setSaMoney(int saMoney) {
		this.saMoney = saMoney;
	}
	public int getSaJango() {
		return saJango;
	}
	public void setSaJango(int saJango) {
		this.saJango = saJango;
	}
	public String getTransfer() {
		return transfer;
	}
	public void setTransfer(String transfer) {
		this.transfer = transfer;
	}
}

package com.iztek.dd.rapor.isiyalitim;

public class IsiYalitimProjesiBean {
	private String yapiBileseni;
	private String yonetmelikIGD;
	private String IGD;
	private String IGK;
	private String alan;
	private String ozgulIsiKaybi;
	
	public IsiYalitimProjesiBean(
			String yapiBileseni, 
			String yonetmelikIGD,
			String IGD,
			String IGK,
			String alan,
			String ozgulIsiKaybi) 
	{
		this.yapiBileseni = yapiBileseni;
		this.yonetmelikIGD = yonetmelikIGD;
		this.IGD = IGD;
		this.IGK = IGK;
		this.alan = alan;
		this.ozgulIsiKaybi = ozgulIsiKaybi;
	}
	
	public String getAlan() {
		return alan;
	}
	
	public String getIGD() {
		return IGD;
	}
	
	public String getIGK() {
		return IGK;
	}
	
	public String getOzgulIsiKaybi() {
		return ozgulIsiKaybi;
	}
	
	public String getYapiBileseni() {
		return yapiBileseni;
	}
	
	public String getYonetmelikIGD() {
		return yonetmelikIGD;
	}
	
	public void setAlan(String alan) {
		this.alan = alan;
	}
	
	public void setIGD(String igd) {
		IGD = igd;
	}
	
	public void setIGK(String igk) {
		IGK = igk;
	}
	
	public void setOzgulIsiKaybi(String ozgulIsiKaybi) {
		this.ozgulIsiKaybi = ozgulIsiKaybi;
	}
	
	public void setYapiBileseni(String yapiBileseni) {
		this.yapiBileseni = yapiBileseni;
	}
	
	public void setYonetmelikIGD(String yonetmelikIGD) {
		this.yonetmelikIGD = yonetmelikIGD;
	}
}

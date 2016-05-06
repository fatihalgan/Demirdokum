package com.iztek.dd.rapor.isikaybicizelgesi;


public class IsiKaybiCizelgesiBean {
	private String isaret;
	private String yon;
	private String kalinlik;
	private String uzunluk;
	private String yukseklikVeyagenislik;
	private String toplamAlan;
	private String miktar;
	private String cikarilanAlan;
	private String hesabaGirenAlan;
	private String toplamIGK;
	private String sicaklikFarki;
	private String arttirimsizIsiKaybi;
	private String birlesik;
	private String katYuksekligi;
	private String zamlarYon;
	private String zamlarToplam;
	private String toplamIsiIhtiyaci;
		
	public IsiKaybiCizelgesiBean(
			String isaret,
			String yon,
			String kalinlik,
			String uzunluk,
			String yukseklikVeyagenislik,
			String toplamAlan,
			String miktar,
			String cikarilanAlan,
			String hesabaGirenAlan,
			String toplamIGK,
			String sicaklikFarki,
			String arttirimsizIsiKaybi,
			String birlesik,
			String katYuksekligi,
			String zamlarYon,
			String zamlarToplam,
			String toplamIsiIhtiyaci)
	{
		this.isaret = isaret;
		this.yon = yon;
		this.kalinlik = kalinlik;
		this.uzunluk = uzunluk;
		this.yukseklikVeyagenislik = yukseklikVeyagenislik;
		this.toplamAlan = toplamAlan;
		this.miktar = miktar;
		this.cikarilanAlan = cikarilanAlan;
		this.hesabaGirenAlan = hesabaGirenAlan;
		this.toplamIGK = toplamIGK;
		this.sicaklikFarki = sicaklikFarki;
		this.arttirimsizIsiKaybi = arttirimsizIsiKaybi;
		this.birlesik = birlesik;
		this.katYuksekligi = katYuksekligi;
		this.zamlarYon = zamlarYon;
		this.zamlarToplam = zamlarToplam;
		this.toplamIsiIhtiyaci = toplamIsiIhtiyaci;
	}
	
	/**
	 * @return Returns the arttirimsizIsiKaybi.
	 */
	public String getArttirimsizIsiKaybi() {
		return arttirimsizIsiKaybi;
	}
	/**
	 * @param arttirimsizIsiKaybi The arttirimsizIsiKaybi to set.
	 */
	public void setArttirimsizIsiKaybi(String arttirimsizIsiKaybi) {
		this.arttirimsizIsiKaybi = arttirimsizIsiKaybi;
	}
	/**
	 * @return Returns the birlesik.
	 */
	public String getBirlesik() {
		return birlesik;
	}
	/**
	 * @param birlesik The birlesik to set.
	 */
	public void setBirlesik(String birlesik) {
		this.birlesik = birlesik;
	}
	/**
	 * @return Returns the cikarilanAlan.
	 */
	public String getCikarilanAlan() {
		return cikarilanAlan;
	}
	/**
	 * @param cikarilanAlan The cikarilanAlan to set.
	 */
	public void setCikarilanAlan(String cikarilanAlan) {
		this.cikarilanAlan = cikarilanAlan;
	}
	/**
	 * @return Returns the hesabaGirenAlan.
	 */
	public String getHesabaGirenAlan() {
		return hesabaGirenAlan;
	}
	/**
	 * @param hesabaGirenAlan The hesabaGirenAlan to set.
	 */
	public void setHesabaGirenAlan(String hesabaGirenAlan) {
		this.hesabaGirenAlan = hesabaGirenAlan;
	}
	/**
	 * @return Returns the isaret.
	 */
	public String getIsaret() {
		return isaret;
	}
	/**
	 * @param isaret The isaret to set.
	 */
	public void setIsaret(String isaret) {
		this.isaret = isaret;
	}
	/**
	 * @return Returns the kalinlik.
	 */
	public String getKalinlik() {
		return kalinlik;
	}
	/**
	 * @param kalinlik The kalinlik to set.
	 */
	public void setKalinlik(String kalinlik) {
		this.kalinlik = kalinlik;
	}
	/**
	 * @return Returns the katYuksekligi.
	 */
	public String getKatYuksekligi() {
		return katYuksekligi;
	}
	/**
	 * @param katYuksekligi The katYuksekligi to set.
	 */
	public void setKatYuksekligi(String katYuksekligi) {
		this.katYuksekligi = katYuksekligi;
	}
	/**
	 * @return Returns the miktar.
	 */
	public String getMiktar() {
		return miktar;
	}
	/**
	 * @param miktar The miktar to set.
	 */
	public void setMiktar(String miktar) {
		this.miktar = miktar;
	}
	/**
	 * @return Returns the sicaklikFarki.
	 */
	public String getSicaklikFarki() {
		return sicaklikFarki;
	}
	/**
	 * @param sicaklikFarki The sicaklikFarki to set.
	 */
	public void setSicaklikFarki(String sicaklikFarki) {
		this.sicaklikFarki = sicaklikFarki;
	}
	/**
	 * @return Returns the toplamAlan.
	 */
	public String getToplamAlan() {
		return toplamAlan;
	}
	/**
	 * @param toplamAlan The toplamAlan to set.
	 */
	public void setToplamAlan(String toplamAlan) {
		this.toplamAlan = toplamAlan;
	}
	/**
	 * @return Returns the toplamIGK.
	 */
	public String getToplamIGK() {
		return toplamIGK;
	}
	/**
	 * @param toplamIGK The toplamIGK to set.
	 */
	public void setToplamIGK(String toplamIGK) {
		this.toplamIGK = toplamIGK;
	}
	/**
	 * @return Returns the toplamIsiIhtiyaci.
	 */
	public String getToplamIsiIhtiyaci() {
		return toplamIsiIhtiyaci;
	}
	/**
	 * @param toplamIsiIhtiyaci The toplamIsiIhtiyaci to set.
	 */
	public void setToplamIsiIhtiyaci(String toplamIsiIhtiyaci) {
		this.toplamIsiIhtiyaci = toplamIsiIhtiyaci;
	}
	/**
	 * @return Returns the uzunluk.
	 */
	public String getUzunluk() {
		return uzunluk;
	}
	/**
	 * @param uzunluk The uzunluk to set.
	 */
	public void setUzunluk(String uzunluk) {
		this.uzunluk = uzunluk;
	}
	/**
	 * @return Returns the yon.
	 */
	public String getYon() {
		return yon;
	}
	/**
	 * @param yon The yon to set.
	 */
	public void setYon(String yon) {
		this.yon = yon;
	}
	/**
	 * @return Returns the yukseklikVeyagenislik.
	 */
	public String getYukseklikVeyagenislik() {
		return yukseklikVeyagenislik;
	}
	/**
	 * @param yukseklikVeyagenislik The yukseklikVeyagenislik to set.
	 */
	public void setYukseklikVeyagenislik(String yukseklikVeyagenislik) {
		this.yukseklikVeyagenislik = yukseklikVeyagenislik;
	}
	/**
	 * @return Returns the zamlarToplam.
	 */
	public String getZamlarToplam() {
		return zamlarToplam;
	}
	/**
	 * @param zamlarToplam The zamlarToplam to set.
	 */
	public void setZamlarToplam(String zamlarToplam) {
		this.zamlarToplam = zamlarToplam;
	}
	/**
	 * @return Returns the zamlarYon.
	 */
	public String getZamlarYon() {
		return zamlarYon;
	}
	/**
	 * @param zamlarYon The zamlarYon to set.
	 */
	public void setZamlarYon(String zamlarYon) {
		this.zamlarYon = zamlarYon;
	}
}

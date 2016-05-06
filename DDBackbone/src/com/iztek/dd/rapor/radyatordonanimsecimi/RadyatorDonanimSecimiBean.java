package com.iztek.dd.rapor.radyatordonanimsecimi;

public class RadyatorDonanimSecimiBean {
	private String odaNo;
	private String odaAdi;
	private String odaSicakligi;
	private String odaIsiKaybi;
	private String radyatorBirimVerim;
	private String radyatorVerimi;
	private String radyatorCinsi;
	private String radyatorMDilim;
	private String donanimGrup;
	private String donanimKonsol;
	private String donanimKelepce;
	private String muslukCapBirBoluIki;
	private String muslukCapUcBoluDort;
	private String muslukCapBir;
	private String rekorCapBirBoluIki;
	private String rekorCapUcBoluDort;
	private String rekorCapBir;
	
	public RadyatorDonanimSecimiBean(
			String odaNo,
			String odaAdi,
			String odaSicakligi,
			String odaIsiKaybi,
			String radyatorBirimVerim,
			String radyatorVerimi,
			String radyatorCinsi,
			String radyatorMDilim,
			String donanimGrup,
			String donanimKonsol,
			String donanimKelepce,
			String muslukCapBirBoluIki,
			String muslukCapUcBoluDort,
			String muslukCapBir,
			String rekorCapBirBoluIki,
			String rekorCapUcBoluDort,
			String rekorCapBir) 
	{
		this.odaNo = odaNo;
		this.odaAdi = odaAdi;
		this.odaSicakligi = odaSicakligi;
		this.odaIsiKaybi = odaIsiKaybi;
		this.radyatorBirimVerim = radyatorBirimVerim;
		this.radyatorVerimi = radyatorVerimi;
		this.radyatorCinsi = radyatorCinsi;
		this.radyatorMDilim = radyatorMDilim;
		this.donanimGrup = donanimGrup;
		this.donanimKonsol = donanimKonsol;
		this.donanimKelepce = donanimKelepce;
		this.muslukCapBirBoluIki = muslukCapBirBoluIki;
		this.muslukCapUcBoluDort = muslukCapUcBoluDort;
		this.muslukCapBir = muslukCapBir;
		this.rekorCapBirBoluIki = rekorCapBirBoluIki;
		this.rekorCapUcBoluDort = rekorCapUcBoluDort;
		this.rekorCapBir = rekorCapBir;
	}
	
	public String getDonanimGrup() {
		return donanimGrup;
	}
	public String getDonanimKelepce() {
		return donanimKelepce;
	}
	public String getDonanimKonsol() {
		return donanimKonsol;
	}
	public String getMuslukCapBir() {
		return muslukCapBir;
	}
	public String getMuslukCapBirBoluIki() {
		return muslukCapBirBoluIki;
	}
	public String getMuslukCapUcBoluDort() {
		return muslukCapUcBoluDort;
	}
	public String getOdaAdi() {
		return odaAdi;
	}
	public String getOdaIsiKaybi() {
		return odaIsiKaybi;
	}
	public String getOdaNo() {
		return odaNo;
	}
	public String getOdaSicakligi() {
		return odaSicakligi;
	}
	public String getRadyatorBirimVerim() {
		return radyatorBirimVerim;
	}
	public String getRadyatorCinsi() {
		return radyatorCinsi;
	}
	public String getRadyatorMDilim() {
		return radyatorMDilim;
	}
	public String getRadyatorVerimi() {
		return radyatorVerimi;
	}
	public String getRekorCapBir() {
		return rekorCapBir;
	}
	public String getRekorCapBirBoluIki() {
		return rekorCapBirBoluIki;
	}
	public String getRekorCapUcBoluDort() {
		return rekorCapUcBoluDort;
	}
	public void setDonanimGrup(String donanimGrup) {
		this.donanimGrup = donanimGrup;
	}
	public void setDonanimKelepce(String donanimKelepce) {
		this.donanimKelepce = donanimKelepce;
	}
	public void setDonanimKonsol(String donanimKonsol) {
		this.donanimKonsol = donanimKonsol;
	}
	public void setMuslukCapBir(String muslukCapBir) {
		this.muslukCapBir = muslukCapBir;
	}
	public void setMuslukCapBirBoluIki(String muslukCapBirBoluIki) {
		this.muslukCapBirBoluIki = muslukCapBirBoluIki;
	}
	public void setMuslukCapUcBoluDort(String muslukCapUcBoluDort) {
		this.muslukCapUcBoluDort = muslukCapUcBoluDort;
	}
	public void setOdaAdi(String odaAdi) {
		this.odaAdi = odaAdi;
	}
	public void setOdaIsiKaybi(String odaIsiKaybi) {
		this.odaIsiKaybi = odaIsiKaybi;
	}
	public void setOdaNo(String odaNo) {
		this.odaNo = odaNo;
	}
	public void setOdaSicakligi(String odaSicakligi) {
		this.odaSicakligi = odaSicakligi;
	}
	public void setRadyatorBirimVerim(String radyatorBirimVerim) {
		this.radyatorBirimVerim = radyatorBirimVerim;
	}
	public void setRadyatorCinsi(String radyatorCinsi) {
		this.radyatorCinsi = radyatorCinsi;
	}
	public void setRadyatorMDilim(String radyatorMDilim) {
		this.radyatorMDilim = radyatorMDilim;
	}
	public void setRadyatorVerimi(String radyatorVerimi) {
		this.radyatorVerimi = radyatorVerimi;
	}
	public void setRekorCapBir(String rekorCapBir) {
		this.rekorCapBir = rekorCapBir;
	}
	public void setRekorCapBirBoluIki(String rekorCapBirBoluIki) {
		this.rekorCapBirBoluIki = rekorCapBirBoluIki;
	}
	public void setRekorCapUcBoluDort(String rekorCapUcBoluDort) {
		this.rekorCapUcBoluDort = rekorCapUcBoluDort;
	}
}

package com.iztek.dd.rapor.zetacizelgesi;

public class ZetaCizelgesiBean {
	private String no;
	private String boruCapi;
	private String kazanVeyaRadyator;
	private String kollektorGirisCikis;
	private String pantolonParcasi;
	private String sParcasi;
	private String ciftDirsekGenis;
	private String ciftDirsekDar;
	private String tBirlesme;
	private String tAyrilma;
	private String tKarsitAkim;
	private String tGirisAyrilma;
	private String tGecisAyrilma;
	private String deveBoynu;
	private String dirsek;
	private String siberVana;
	private String kolonVanasiDuz;
	private String kolonVanasiEgik;
	private String radyatorVentiliDuz;
	private String radyatorVentiliKose;
	private String toplam;
	
	public ZetaCizelgesiBean(
			String no,
			String boruCapi,
			String kazanVeyaRadyator,
			String kollektorGirisCikis,
			String pantolonParcasi,
			String sParcasi,
			String ciftDirsekGenis,
			String ciftDirsekDar,
			String tBirlesme,
			String tAyrilma,
			String tKarsitAkim,
			String tGirisAyrilma,
			String tGecisAyrilma,
			String deveBoynu,
			String dirsek,
			String siberVana,
			String kolonVanasiDuz,
			String kolonVanasiEgik,
			String radyatorVentiliDuz,
			String radyatorVentiliKose,
			String toplam) 
	{
		this.no = no;
		this.boruCapi = boruCapi;
		this.kazanVeyaRadyator = kazanVeyaRadyator;
		this.kollektorGirisCikis = kollektorGirisCikis;
		this.pantolonParcasi = pantolonParcasi;
		this.sParcasi = sParcasi;
		this.ciftDirsekGenis = ciftDirsekGenis;
		this.ciftDirsekDar = ciftDirsekDar;
		this.tBirlesme = tBirlesme;
		this.tAyrilma = tAyrilma;
		this.tKarsitAkim = tKarsitAkim;
		this.tGirisAyrilma = tGirisAyrilma;
		this.tGecisAyrilma = tGecisAyrilma;
		this.deveBoynu = deveBoynu;
		this.dirsek = dirsek;
		this.siberVana = siberVana;
		this.kolonVanasiDuz = kolonVanasiDuz;
		this.kolonVanasiEgik = kolonVanasiEgik;
		this.radyatorVentiliDuz = radyatorVentiliDuz;
		this.radyatorVentiliKose = radyatorVentiliKose;
		this.toplam = toplam;
	}
	public String getBoruCapi() {
		return boruCapi;
	}
	public String getCiftDirsekDar() {
		return ciftDirsekDar;
	}
	public String getCiftDirsekGenis() {
		return ciftDirsekGenis;
	}
	public String getDeveBoynu() {
		return deveBoynu;
	}
	public String getDirsek() {
		return dirsek;
	}
	public String getTKarsitAkim() {
		return tKarsitAkim;
	}
	public String getKazanVeyaRadyator() {
		return kazanVeyaRadyator;
	}
	public String getKollektorGirisCikis() {
		return kollektorGirisCikis;
	}
	public String getKolonVanasiDuz() {
		return kolonVanasiDuz;
	}
	public String getKolonVanasiEgik() {
		return kolonVanasiEgik;
	}
	public String getNo() {
		return no;
	}
	public String getPantolonParcasi() {
		return pantolonParcasi;
	}
	public String getRadyatorVentiliDuz() {
		return radyatorVentiliDuz;
	}
	public String getRadyatorVentiliKose() {
		return radyatorVentiliKose;
	}
	public String getSiberVana() {
		return siberVana;
	}
	public String getSParcasi() {
		return sParcasi;
	}
	public String getTAyrilma() {
		return tAyrilma;
	}
	public String getTBirlesme() {
		return tBirlesme;
	}
	public String getTGecisAyrilma() {
		return tGecisAyrilma;
	}
	public String getTGirisAyrilma() {
		return tGirisAyrilma;
	}
	public String getToplam() {
		return toplam;
	}
	public void setBoruCapi(String boruCapi) {
		this.boruCapi = boruCapi;
	}
	public void setCiftDirsekDar(String ciftDirsekDar) {
		this.ciftDirsekDar = ciftDirsekDar;
	}
	public void setCiftDirsekGenis(String ciftDirsekGenis) {
		this.ciftDirsekGenis = ciftDirsekGenis;
	}
	public void setDeveBoynu(String deveBoynu) {
		this.deveBoynu = deveBoynu;
	}
	public void setDirsek(String dirsek) {
		this.dirsek = dirsek;
	}
	public void setTKarsitAkim(String tKarsitAkim) {
		this.tKarsitAkim = tKarsitAkim;
	}
	public void setKazanVeyaRadyator(String kazanVeyaRadyator) {
		this.kazanVeyaRadyator = kazanVeyaRadyator;
	}
	public void setKollektorGirisCikis(String kollektorGirisCikis) {
		this.kollektorGirisCikis = kollektorGirisCikis;
	}
	public void setKolonVanasiDuz(String kolonVanasiDuz) {
		this.kolonVanasiDuz = kolonVanasiDuz;
	}
	public void setKolonVanasiEgik(String kolonVanasiEgik) {
		this.kolonVanasiEgik = kolonVanasiEgik;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public void setPantolonParcasi(String pantolonParcasi) {
		this.pantolonParcasi = pantolonParcasi;
	}
	public void setRadyatorVentiliDuz(String radyatorVentiliDuz) {
		this.radyatorVentiliDuz = radyatorVentiliDuz;
	}
	public void setRadyatorVentiliKose(String radyatorVentiliKose) {
		this.radyatorVentiliKose = radyatorVentiliKose;
	}
	public void setSiberVana(String siberVana) {
		this.siberVana = siberVana;
	}
	public void setSParcasi(String parcasi) {
		sParcasi = parcasi;
	}
	public void setTAyrilma(String ayrilma) {
		tAyrilma = ayrilma;
	}
	public void setTBirlesme(String birlesme) {
		tBirlesme = birlesme;
	}
	public void setTGecisAyrilma(String gecisAyrilma) {
		tGecisAyrilma = gecisAyrilma;
	}
	public void setTGirisAyrilma(String girisAyrilma) {
		tGirisAyrilma = girisAyrilma;
	}
	public void setToplam(String toplam) {
		this.toplam = toplam;
	}
}

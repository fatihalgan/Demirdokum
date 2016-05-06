package com.iztek.dd.rapor.borucapicizelgesi;

public class BoruCapiCizelgesiBean {
	private String boruNo;
	private String isiMiktari;
	private String uzunluk;
	private String cap;
	private String suHizi;
	private String basincKaybi;
	private String surtunmeKaybi;
	private String ozelDirenc;
	private String ozelKayip;
	private String toplamBasinc;
	
	public BoruCapiCizelgesiBean(
			String boruNo,
			String isiMiktari,
			String uzunluk,
			String cap,
			String suHizi,
			String basincKaybi,
			String surtunmeKaybi,
			String ozelDirenc,
			String ozelKayip,
			String toplamBasinc) 
	{
		this.boruNo = boruNo;
		this.isiMiktari = isiMiktari;
		this.uzunluk = uzunluk;
		this.cap = cap;
		this.suHizi = suHizi;
		this.basincKaybi = basincKaybi;
		this.surtunmeKaybi = surtunmeKaybi;
		this.ozelDirenc = ozelDirenc;
		this.ozelKayip = ozelKayip;
		this.toplamBasinc = toplamBasinc;
	}
	
	public String getBasincKaybi() {
		return basincKaybi;
	}
	public String getBoruNo() {
		return boruNo;
	}
	public String getCap() {
		return cap;
	}
	public String getIsiMiktari() {
		return isiMiktari;
	}
	public String getOzelDirenc() {
		return ozelDirenc;
	}
	public String getOzelKayip() {
		return ozelKayip;
	}
	public String getSuHizi() {
		return suHizi;
	}
	public String getSurtunmeKaybi() {
		return surtunmeKaybi;
	}
	public String getToplamBasinc() {
		return toplamBasinc;
	}
	public String getUzunluk() {
		return uzunluk;
	}
	public void setBasincKaybi(String basincKaybi) {
		this.basincKaybi = basincKaybi;
	}
	public void setBoruNo(String boruNo) {
		this.boruNo = boruNo;
	}
	public void setCap(String cap) {
		this.cap = cap;
	}
	public void setIsiMiktari(String isiMiktari) {
		this.isiMiktari = isiMiktari;
	}
	public void setOzelDirenc(String ozelDirenc) {
		this.ozelDirenc = ozelDirenc;
	}
	public void setOzelKayip(String ozelKayip) {
		this.ozelKayip = ozelKayip;
	}
	public void setSuHizi(String suHizi) {
		this.suHizi = suHizi;
	}
	public void setSurtunmeKaybi(String surtunmeKaybi) {
		this.surtunmeKaybi = surtunmeKaybi;
	}
	public void setToplamBasinc(String toplamBasinc) {
		this.toplamBasinc = toplamBasinc;
	}
	public void setUzunluk(String uzunluk) {
		this.uzunluk = uzunluk;
	}
}

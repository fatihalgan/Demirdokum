package com.iztek.dd.rapor.cizelge2;

import java.util.List;

public class YapiElemaniBean {
	private String yapiElemaniAdi;
	private List bilesenler;
	double isiIletkenlikKatsayisi;
	double isiKaybedenYuzey;
	double isiKaybi;
	
	public YapiElemaniBean(String yapiElemaniAdi, List bilesenler,double isiIletkenlikKatsayisi, double isiKaybedenYuzey, double isiKaybi){
		this.yapiElemaniAdi = yapiElemaniAdi;
		this.bilesenler = bilesenler;
		this.isiIletkenlikKatsayisi = isiIletkenlikKatsayisi;
		this.isiKaybedenYuzey = isiKaybedenYuzey;
		this.isiKaybi = isiKaybi;
	}
	
//	public static List createYapiElemanlari() {
//		List list = new ArrayList();
//		list.add(new YapiElemaniBean("Duvar Yüzeyleri",BilesenBean.createBilesenler()));
//		list.add(new YapiElemaniBean("Taban/Döþeme",BilesenBean.createBilesenler2()));
//		return list;
//	}
	
    public List getBilesenler() {
        return bilesenler;
    }
    
    public String getYapiElemaniAdi() {
        return yapiElemaniAdi;
    }
    
    public void setBilesenler(List bilesenler) {
        this.bilesenler = bilesenler;
    }
    
    public void setYapiElemaniAdi(String yapiElemaniAdi) {
        this.yapiElemaniAdi = yapiElemaniAdi;
    }
    
    public double getIsiIletkenlikKatsayisi() {
        return isiIletkenlikKatsayisi;
    }
    
    public void setIsiIletkenlikKatsayisi(double isiIletkenlikKatsayisi) {
        this.isiIletkenlikKatsayisi = isiIletkenlikKatsayisi;
    }
    
    public double getIsiKaybedenYuzey() {
        return isiKaybedenYuzey;
    }
    
    public void setIsiKaybedenYuzey(double isiKaybedenYuzey) {
        this.isiKaybedenYuzey = isiKaybedenYuzey;
    }
    
    public double getIsiKaybi() {
        return isiKaybi;
    }
    
    public void setIsiKaybi(double isiKaybi) {
        this.isiKaybi = isiKaybi;
    }
    
    public String toString() {
        return yapiElemaniAdi;
    }
}

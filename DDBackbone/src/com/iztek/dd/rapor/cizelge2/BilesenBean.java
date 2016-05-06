package com.iztek.dd.rapor.cizelge2;

import java.util.ArrayList;
import java.util.List;

public class BilesenBean {
	private String bilesenAdi;
	private double kalinlik;
	private double iletkenlik;
	private double dBoluLambda;
	
	public BilesenBean(String bilesenAdi, double kalinlik, double iletkenlik, double dBoluLambda) {
		this.bilesenAdi = bilesenAdi;
		this.kalinlik = kalinlik;
		this.iletkenlik = iletkenlik;
		this.dBoluLambda = dBoluLambda;
	}
	
	public static List createBilesenler() {
		List list = new ArrayList();
		list.add(new BilesenBean("Sýva", 0.020, 0.870, 0.023));
		list.add(new BilesenBean("Yatay delikli tuðla", 0.190, 0.450, 0.42));
		list.add(new BilesenBean("Isý yalýtým malzemesi", 0.060, 0.040, 1.500));
		list.add(new BilesenBean("Sýva", 0.005, 0.870, 0.0));
		return list;
	}
	
	public static List createBilesenler2() {
		List list = new ArrayList();
		list.add(new BilesenBean("PVC", 0.020, 0.870, 0.023));
		list.add(new BilesenBean("Þap", 0.190, 0.450, 0.42));
		return list;
	}
	
    public String getBilesenAdi() {
        return bilesenAdi;
    }
    
    public double getDBoluLambda() {
        return dBoluLambda;
    }
    
    public double getIletkenlik() {
        return iletkenlik;
    }
    
    public double getKalinlik() {
        return kalinlik;
    }
    
    public void setBilesenAdi(String bilesenAdi) {
        this.bilesenAdi = bilesenAdi;
    }
    
    public void setDBoluLambda(double boluLambda) {
        dBoluLambda = boluLambda;
    }
    
    public void setIletkenlik(double iletkenlik) {
        this.iletkenlik = iletkenlik;
    }
    
    public void setKalinlik(double kalinlik) {
        this.kalinlik = kalinlik;
    }
    
    public String toString() {
        return bilesenAdi;
    }
}

/*
 * Created on 21.Ara.2004
 *
 */
package com.iztek.dd.domain.Havalandirma;


/**
 * @author Selim HENDRICKSON
 *
 */
public class MekanikHavalandirma extends HavalandirmaImpl {
	private double havaGirisDebisi = 0;
	private double havaCýkýsDebisi = 0;	
	private double fansizHavaDegisimDebisi = 0;
	private double feedbackVerim;
	private double beta = 0;
	private double n50 = 0;
	private double e = 0;
	private double f = 0;
	private static final double ROC = 1191.104;
	private boolean surekliCalisiyor = false;
	private boolean aralikliCalisiyor = false;
	private boolean feedbackVar = false;

	/**
	 * @return Returns the hESAP_KATSAYISI.
	 */
	public double getROC() {
		return ROC;
	}


	/**
	 * @return Returns the e.
	 */
	public double getE() {
		return e;
	}
	/**
	 * @param e The e to set.
	 */
	public void setE(double e) {
		this.e = e;
	}
	/**
	 * @return Returns the f.
	 */
	public double getF() {
		return f;
	}
	/**
	 * @param f The f to set.
	 */
	public void setF(double f) {
		this.f = f;
	}
	/**
	 * @return Returns the n50.
	 */
	public double getN50() {
		return n50;
	}
	/**
	 * @param n50 The n50 to set.
	 */
	public void setN50(double n50) {
		this.n50 = n50;
	}
	/**
	 * @return Returns the havaCýkýsDebisi.
	 */
	public double getHavaCýkýsDebisi() {
		return havaCýkýsDebisi;
	}
	/**
	 * @param havaCýkýsDebisi The havaCýkýsDebisi to set.
	 */
	public void setHavaCýkýsDebisi(
			double toplamHacimselHavaCýkýsDebisi) {
		this.havaCýkýsDebisi = toplamHacimselHavaCýkýsDebisi;
	}
	/**
	 * @return Returns the havaGirisDebisi.
	 */
	public double getHavaGirisDebisi() {
		return havaGirisDebisi;
	}
	/**
	 * @param havaGirisDebisi The havaGirisDebisi to set.
	 */
	public void setHavaGirisDebisi(
			double toplamHacimselHavaDegisimDebisi) {
		this.havaGirisDebisi = toplamHacimselHavaDegisimDebisi;
	}
	
	public double hesaplaHavalandirmaOzgulIsiKaybi() {
		return getROC() * hesaplaToplamHacimselHavaDegisimDebisi();
	}

    public double hesaplaToplamHacimselHavaDegisimDebisi() {
        double base = hesaplaSistemFanlariCalisirken() + hesaplaRuzgarEtkisi();
        if(aralikliCalisiyor) base = ((hesaplaHacimselHavaDegisimDebisi() * (1-beta)) + (base * beta));
        if(feedbackVar) return (hesaplaSistemFanlariCalisirken() * (1 - feedbackVerim)) + hesaplaRuzgarEtkisi();
        return base;
    }


    private double hesaplaHacimselHavaDegisimDebisi() {
        return havaCýkýsDebisi > havaGirisDebisi ? havaCýkýsDebisi : havaGirisDebisi;
    }


    public double hesaplaSistemFanlariCalisirken(){
		return getHavaCýkýsDebisi() > getHavaGirisDebisi() ? getHavaCýkýsDebisi() : getHavaGirisDebisi();
	}
	
	public double hesaplaRuzgarEtkisi(){
		double ruzgarEtkisi = 0;
		
		ruzgarEtkisi = (getHavalandirilanHacim() * getN50() * getE())/(1+((getF()/getE())*(getHavaCýkýsDebisi()*getHavaGirisDebisi())/(getHavalandirilanHacim()-getN50())));
		return ruzgarEtkisi;
	}
	
	
    public boolean isAralikliCalisiyor() {
        return aralikliCalisiyor;
    }
    
    public void setAralikliCalisiyor(boolean aralikliCalisiyor) {
        this.aralikliCalisiyor = aralikliCalisiyor;
    }
    
    public double getBeta() {
        return beta;
    }
    
    public void setBeta(double beta) {
        this.beta = beta;
    }
    
    public boolean isFeedbackVar() {
        return feedbackVar;
    }
    
    public void setFeedbackVar(boolean feedbackVar) {
        this.feedbackVar = feedbackVar;
    }
    
    public boolean isSurekliCalisiyor() {
        return surekliCalisiyor;
    }
    
    public void setSurekliCalisiyor(boolean surekliCalisiyor) {
        this.surekliCalisiyor = surekliCalisiyor;
    }
    
    public double getFeedbackVerim() {
        return feedbackVerim;
    }
    
    public void setFeedbackVerim(double verim) {
        this.feedbackVerim = verim;
    }
    
    public double getFansizHavaDegisimDebisi() {
        return fansizHavaDegisimDebisi;
    }
    
    public void setFansizHavaDegisimDebisi(double fansizHavaDegisimDebisi) {
        this.fansizHavaDegisimDebisi = fansizHavaDegisimDebisi;
    }


    public double getHavaDegisimSayisi() {
        return 0;
    }
}

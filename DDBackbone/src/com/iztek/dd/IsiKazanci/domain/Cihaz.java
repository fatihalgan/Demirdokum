/*
 * Created on 09.Þub.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.iztek.dd.IsiKazanci.domain;

/**
 * @author db2admin
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Cihaz implements IsiKazandiran {

    private boolean davlumbazli = false;
	private double guc;
	private int calistigiToplamSaat = 2;
	private int isletmeyeAlindiktanSonraGecenSaat = 1;
	
	public int getIsletmeyeAlindiktanSonraGecenSaat() {
		return isletmeyeAlindiktanSonraGecenSaat;
	}

	public void setIsletmeyeAlindiktanSonraGecenSaat(
			int isletmeyeAlindiktanSonraGecenSaat) {
		this.isletmeyeAlindiktanSonraGecenSaat = isletmeyeAlindiktanSonraGecenSaat;
	}

	public int getCalistigiToplamSaat() {
		return calistigiToplamSaat;
	}
	
	public void setCalistigiToplamSaat(int calistigiToplamSaat) {
		this.calistigiToplamSaat = calistigiToplamSaat;
	}

	public double getGuc() {
		return guc;
	}

	public void setGuc(double guc) {
		this.guc = guc;
	}
	
    public boolean isDavlumbazli() {
        return davlumbazli;
    }
    
    public void setDavlumbazli(boolean davlumbazli) {
        this.davlumbazli = davlumbazli;
    }
    
	public Cihaz() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double getDuyulurToplamIsiKazanci(IsiKazanan isiKazanan) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getGizliToplamIsiKazanci(IsiKazanan isiKazanan) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int hesaplaIletimYoluylaToplamIsiKazanci(IsiKazanan isiKazanan) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int hesaplaToplamIsiKazanci(IsiKazanan isiKazanan) {
		return (int)(getGuc() * isiKazanan.hesaplaDuzeltmeFaktoru() * hesaplaCLF(isiKazanan));
	}
	
	private double hesaplaCLF(IsiKazanan isiKazanan) {
	    double value = 0;
		if(isDavlumbazli()) {	
		    value = DoylumBazliCihazCLFs.getInstance().getCLFValue(calistigiToplamSaat,isletmeyeAlindiktanSonraGecenSaat);
		} else {
		    value = DoylumBazsizCihazCLFs.getInstance().getCLFValue(calistigiToplamSaat,isletmeyeAlindiktanSonraGecenSaat);
		}
		return value;
	}

}

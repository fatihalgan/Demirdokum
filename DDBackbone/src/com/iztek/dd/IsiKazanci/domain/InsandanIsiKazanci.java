/*
 * Created on 03.Þub.2005
 *
 */


package com.iztek.dd.IsiKazanci.domain;

public class InsandanIsiKazanci {

	private String aktiviteTuru = "";
	private String tipikOrnek="";
	private IsiUretimi isiUretimi= new IsiUretimi();
	
	
	/**
	 * @return Returns the aktiviteTuru.
	 */
	public String getAktiviteTuru() {
		return aktiviteTuru;
	}
	/**
	 * @param aktiviteTuru The aktiviteTuru to set.
	 */
	public void setAktiviteTuru(String aktiviteTuru) {
		this.aktiviteTuru = aktiviteTuru;
	}
	/**
	 * @return Returns the isiUretimi.
	 */
	public IsiUretimi getIsiUretimi() {
		return isiUretimi;
	}
	/**
	 * @param isiUretimi The isiUretimi to set.
	 */
	public void setIsiUretimi(IsiUretimi isiUretimi) {
		this.isiUretimi = isiUretimi;
	}
	/**
	 * @return Returns the tipikOrnek.
	 */
	public String getTipikOrnek() {
		return tipikOrnek;
	}
	/**
	 * @param tipikOrnek The tipikOrnek to set.
	 */
	public void setTipikOrnek(String tipikOrnek) {
		this.tipikOrnek = tipikOrnek;
	}
	
	public int getToplamIsi(){
		return this.isiUretimi.getDuyulurIsiUretimi()+
				this.isiUretimi.getGizliIsiUretimi();
	}
}

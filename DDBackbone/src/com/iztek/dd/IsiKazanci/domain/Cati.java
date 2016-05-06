/*
 * Created on 09.Þub.2005
 *
 */
package com.iztek.dd.IsiKazanci.domain;




/**
 * @author db2admin
 *
 */
public class Cati extends YapiElemani {

	private String catiTipi;
	private String catiTipiKodu;
		

	/**
	 * @return Returns the catiTipiKodu.
	 */
	public String getCatiTipiKodu() {
		return catiTipiKodu;
	}
	/**
	 * @param catiTipiKodu The catiTipiKodu to set.
	 */
	public void setCatiTipiKodu(String catiTipiKodu) {
		this.catiTipiKodu = catiTipiKodu;
	}
	/**
	 * @return Returns the catiTipi.
	 */
	public String getCatiTipi() {
		return catiTipi;
	}
	/**
	 * @param catiTipi The catiTipi to set.
	 */
	public void setCatiTipi(String catiTipi) {
		this.catiTipi = catiTipi;
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.iztek.dd.IsiKazanci.domain.YapiElemani#hesaplaCLTD(int)
	 */
	public int hesaplaCLTD(IsiKazanan isiKazanan) {
		//Check Tablo.1 Çatý Tipi ve Saate göre CLTD deðer döndür
	    int retVal = 0;
	    if(getCatiTipi()!=null){
			CatiCLTD cltd = CatiCLTDs.getInstance().getCatiCLDT(getCatiTipi().trim());
			retVal = cltd.getCLDTForSaat(isiKazanan.getSaat() + 1);
			//Check if isiKazanan.altCLTD
			if(isiKazanan.getIcSicaklik() != 25.5 || isiKazanan.getDisSicaklik() != 35 || isiKazanan.isAltCLTD()) {
				retVal = (int)(retVal + (25.5 - isiKazanan.getIcSicaklik()) + (isiKazanan.getOrtalamaDisOrtamSicakligi() - 29.4));
			}	        
	    }
		return retVal;
	}
	/* (non-Javadoc)
	 * @see com.iztek.dd.IsiKazanci.domain.YapiElemani#hesaplaRadyasyondanYalouylaGelenIsiKazanci(com.iztek.dd.IsiKazanci.domain.IsiKazanan)
	 */
	public int hesaplaRadyasyonYoluylaGelenIsiKazanci(IsiKazanan isiKazanan) {
		return 0;
	}
	/* (non-Javadoc)
	 * @see com.iztek.dd.IsiKazanci.domain.IsiKazandiran#getDuyulurToplamIsiKazanci()
	 */
	public double getDuyulurToplamIsiKazanci(IsiKazanan isiKazanan) {
		// TODO Auto-generated method stub
		return 0;
	}
	/* (non-Javadoc)
	 * @see com.iztek.dd.IsiKazanci.domain.IsiKazandiran#getGizliToplamIsiKazanci()
	 */
	public int getGizliToplamIsiKazanci(IsiKazanan isiKazanan) {
		// TODO Auto-generated method stub
		return 0;
	}
	/* (non-Javadoc)
	 * @see com.iztek.dd.IsiKazanci.domain.IsiKazandiran#hesaplaToplamIsiKazanci(com.iztek.dd.IsiKazanci.domain.IsiKazanan)
	 */
	public int hesaplaToplamIsiKazanci(IsiKazanan isiKazanan) {
		return hesaplaIletimYoluylaToplamIsiKazanci(isiKazanan);
	}
	

}

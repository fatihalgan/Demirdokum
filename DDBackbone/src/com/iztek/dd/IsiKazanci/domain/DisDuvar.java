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
public class DisDuvar extends YoneBagliIsiKazandiran {
    IsiKazanan mahal = null;
    
	public DisDuvar(String identifier,IsiKazanan mahal){
	    this.mahal = mahal;
	    this.identifier = identifier;
	}
	
	/* (non-Javadoc)
	 * @see com.iztek.dd.IsiKazanci.domain.YapiElemani#hesaplaCLTD()
	 */
	public int hesaplaCLTD(IsiKazanan isiKazanan) {
		//Check Tablo.3 Yön ve Saate göre CLTD deðer döndür.
	    int retVal = 0;
	    if(getYon()!=null){
			DuvarCLTD cldt = DuvarCLTDs.getInstance().getDuvarCLDT(getYon().trim());
			retVal = cldt.getCLDTForSaat(isiKazanan.getSaat());
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
	
	/**
     *
     */

    public float getIsiTransferiKatsayisi() {
        return mahal.getDisDuvarIsiTransferKatsayisi();
    }
}

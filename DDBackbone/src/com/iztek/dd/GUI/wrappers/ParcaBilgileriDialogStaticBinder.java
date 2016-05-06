/*
 * Created on 10.Oca.2005
 *
 */
package com.iztek.dd.GUI.wrappers;

import com.iztek.dd.GUI.ParcaBilgileriDialog;
import com.iztek.dd.GUI.util.BoruParcasiCaplar;
import com.iztek.dd.GUI.util.BoruParcasiCaplar.Cap;

/**
 * @author Burak AYDIN
 *
 */
public class ParcaBilgileriDialogStaticBinder {

	private double parcaninUzunlugu;
	private double parcaninIsiYuku;
	private double parcaninCapi;
	
	private int kazanVeRadyatorAdeti;
	private int kollektorGirisVeyaCikisAdeti;
	private int pantalonParcasiAdeti;
	private int sParcasiAdeti;
	private int genisCiftDirsekAdeti;
	private int darCiftDirsekAdeti;
	private int tBirlesmeAdeti;
	private int tAyrilmaAdeti;
	private int tKarsitAkimAdeti;
	private int tGecisAdeti;
	private int tGirisAdeti;
	private int deveBoynuAdeti;
	private int dirsekAdeti;
	private int siberVanaAdeti;
	private int duzKolonVanasiAdeti;
	private int egikKolonVanasiAdeti;
	private int duzRadyatorVentiliAdediAdeti;
	private int koseliRadyatorVentiliAdeti;

	private ParcaBilgileriDialogStaticBinder(){
	}
	
	public static ParcaBilgileriDialogStaticBinder getInstance(ParcaBilgileriDialog dialog){
		ParcaBilgileriDialogStaticBinder binder = new ParcaBilgileriDialogStaticBinder();
		
		binder.setParcaninUzunlugu(defaultNullDoubleToZero(dialog.getParcaUzunluguTextField().getDouble()));
		binder.setParcaninIsiYuku(defaultNullDoubleToZero(dialog.getParcaninIsiYukuTextField().getDouble()));
		BoruParcasiCaplar.Cap cap = (Cap) dialog.getParcaninCapiComboBox().getSelectedItem();
		if (cap == null)
			binder.setParcaninCapi(0.0);
		else
			binder.setParcaninCapi(cap.getCap());
		
		binder.setKazanVeRadyatorAdeti(defaultNullIntegerToZero(dialog.getKazanVeRadyatorTextField().getInteger()));
		binder.setKollektorGirisVeyaCikisAdeti(defaultNullIntegerToZero(dialog.getKollektorGirisVeyaCikisTextField().getInteger()));
		binder.setPantalonParcasiAdeti(defaultNullIntegerToZero(dialog.getPantalonParcasiTextField().getInteger()));
		binder.setSParcasiAdeti(defaultNullIntegerToZero(dialog.getSParcasiTextField().getInteger()));
		binder.setGenisCiftDirsekAdeti(defaultNullIntegerToZero(dialog.getGenisCiftDirsekTextField().getInteger()));
		binder.setDarCiftDirsekAdeti(defaultNullIntegerToZero(dialog.getDarCiftDirsekTextField().getInteger()));
		binder.setTBirlesmeAdeti(defaultNullIntegerToZero(dialog.getTBirleþmeTextField().getInteger()));
		binder.setTKarsitAkimAdeti(defaultNullIntegerToZero(dialog.getTKarsitAkimTextField().getInteger()));
		binder.setTGecisAdeti(defaultNullIntegerToZero(dialog.getTGecisTextField().getInteger()));
		binder.setTGirisAdeti(defaultNullIntegerToZero(dialog.getTGirisTextField().getInteger()));
		binder.setDeveBoynuAdeti(defaultNullIntegerToZero(dialog.getDeveBoynuTextField().getInteger()));
		binder.setDirsekAdeti(defaultNullIntegerToZero(dialog.getDirsekTextField().getInteger()));
		binder.setSiberVanaAdeti(defaultNullIntegerToZero(dialog.getSiberVanaTextField().getInteger()));
		binder.setDuzKolonVanasiAdeti(defaultNullIntegerToZero(dialog.getDuzKolonVanasiTextField().getInteger()));
		binder.setEgikKolonVanasiAdeti(defaultNullIntegerToZero(dialog.getEgikKolonVanasiTextField().getInteger()));
		binder.setDuzRadyatorVentiliAdediAdeti(defaultNullIntegerToZero(dialog.getDuzRadyatorVentiliTextField().getInteger()));
		binder.setKoseliRadyatorVentiliAdeti(defaultNullIntegerToZero(dialog.getKoseliRadyatorVentiliTextField().getInteger()));
		binder.setTAyrilmaAdeti(defaultNullIntegerToZero(dialog.getTAyrilmaTextField().getInteger()));
		return binder;
	}
	
	/**
	 * @param integer
	 * @return
	 */
	private static int defaultNullIntegerToZero(Integer integer) {
		if (integer == null)
			return 0;
		else
			return integer.intValue();
	}

	/**
	 * @param double1
	 * @return
	 */
	private static double defaultNullDoubleToZero(Double double1) {
		if (double1 == null)
			return 0;
		else
			return double1.doubleValue();
	}

	/**
	 * @return Returns the darCiftDirsekAdeti.
	 */
	public int getDarCiftDirsekAdeti() {
		return darCiftDirsekAdeti;
	}
	/**
	 * @param darCiftDirsekAdeti The darCiftDirsekAdeti to set.
	 */
	public void setDarCiftDirsekAdeti(int darCiftDirsekAdeti) {
		this.darCiftDirsekAdeti = darCiftDirsekAdeti;
	}
	/**
	 * @return Returns the deveBoynuAdeti.
	 */
	public int getDeveBoynuAdeti() {
		return deveBoynuAdeti;
	}
	/**
	 * @param deveBoynuAdeti The deveBoynuAdeti to set.
	 */
	public void setDeveBoynuAdeti(int deveBoynuAdeti) {
		this.deveBoynuAdeti = deveBoynuAdeti;
	}
	/**
	 * @return Returns the dirsekAdeti.
	 */
	public int getDirsekAdeti() {
		return dirsekAdeti;
	}
	/**
	 * @param dirsekAdeti The dirsekAdeti to set.
	 */
	public void setDirsekAdeti(int dirsekAdeti) {
		this.dirsekAdeti = dirsekAdeti;
	}
	/**
	 * @return Returns the duzKolonVanasiAdeti.
	 */
	public int getDuzKolonVanasiAdeti() {
		return duzKolonVanasiAdeti;
	}
	/**
	 * @param duzKolonVanasiAdeti The duzKolonVanasiAdeti to set.
	 */
	public void setDuzKolonVanasiAdeti(int duzKolonVanasiAdeti) {
		this.duzKolonVanasiAdeti = duzKolonVanasiAdeti;
	}
	/**
	 * @return Returns the duzRadyatorVentiliAdediAdeti.
	 */
	public int getDuzRadyatorVentiliAdediAdeti() {
		return duzRadyatorVentiliAdediAdeti;
	}
	/**
	 * @param duzRadyatorVentiliAdediAdeti The duzRadyatorVentiliAdediAdeti to set.
	 */
	public void setDuzRadyatorVentiliAdediAdeti(int duzRadyatorVentiliAdediAdeti) {
		this.duzRadyatorVentiliAdediAdeti = duzRadyatorVentiliAdediAdeti;
	}
	/**
	 * @return Returns the egikKolonVanasiAdeti.
	 */
	public int getEgikKolonVanasiAdeti() {
		return egikKolonVanasiAdeti;
	}
	/**
	 * @param egikKolonVanasiAdeti The egikKolonVanasiAdeti to set.
	 */
	public void setEgikKolonVanasiAdeti(int egikKolonVanasiAdeti) {
		this.egikKolonVanasiAdeti = egikKolonVanasiAdeti;
	}
	/**
	 * @return Returns the genisCiftDirsekAdeti.
	 */
	public int getGenisCiftDirsekAdeti() {
		return genisCiftDirsekAdeti;
	}
	/**
	 * @param genisCiftDirsekAdeti The genisCiftDirsekAdeti to set.
	 */
	public void setGenisCiftDirsekAdeti(int genisCiftDirsekAdeti) {
		this.genisCiftDirsekAdeti = genisCiftDirsekAdeti;
	}
	/**
	 * @return Returns the kazanVeRadyatorAdeti.
	 */
	public int getKazanVeRadyatorAdeti() {
		return kazanVeRadyatorAdeti;
	}
	/**
	 * @param kazanVeRadyatorAdeti The kazanVeRadyatorAdeti to set.
	 */
	public void setKazanVeRadyatorAdeti(int kazanVeRadyatorAdeti) {
		this.kazanVeRadyatorAdeti = kazanVeRadyatorAdeti;
	}
	/**
	 * @return Returns the kollektorGirisVeyaCikisAdeti.
	 */
	public int getKollektorGirisVeyaCikisAdeti() {
		return kollektorGirisVeyaCikisAdeti;
	}
	/**
	 * @param kollektorGirisVeyaCikisAdeti The kollektorGirisVeyaCikisAdeti to set.
	 */
	public void setKollektorGirisVeyaCikisAdeti(int kollektorGirisVeyaCikisAdeti) {
		this.kollektorGirisVeyaCikisAdeti = kollektorGirisVeyaCikisAdeti;
	}
	/**
	 * @return Returns the koseliRadyatorVentiliAdeti.
	 */
	public int getKoseliRadyatorVentiliAdeti() {
		return koseliRadyatorVentiliAdeti;
	}
	/**
	 * @param koseliRadyatorVentiliAdeti The koseliRadyatorVentiliAdeti to set.
	 */
	public void setKoseliRadyatorVentiliAdeti(int koseliRadyatorVentiliAdeti) {
		this.koseliRadyatorVentiliAdeti = koseliRadyatorVentiliAdeti;
	}
	/**
	 * @return Returns the pantalonParcasiAdeti.
	 */
	public int getPantalonParcasiAdeti() {
		return pantalonParcasiAdeti;
	}
	/**
	 * @param pantalonParcasiAdeti The pantalonParcasiAdeti to set.
	 */
	public void setPantalonParcasiAdeti(int pantalonParcasiAdeti) {
		this.pantalonParcasiAdeti = pantalonParcasiAdeti;
	}
	/**
	 * @return Returns the parcaninIsiYuku.
	 */
	public double getParcaninIsiYuku() {
		return parcaninIsiYuku;
	}
	/**
	 * @param parcaninIsiYuku The parcaninIsiYuku to set.
	 */
	public void setParcaninIsiYuku(double parcaninIsiYuku) {
		this.parcaninIsiYuku = parcaninIsiYuku;
	}
	/**
	 * @return Returns the parcaninUzunlugu.
	 */
	public double getParcaninUzunlugu() {
		return parcaninUzunlugu;
	}
	/**
	 * @param parcaninUzunlugu The parcaninUzunlugu to set.
	 */
	public void setParcaninUzunlugu(double parcaninUzunlugu) {
		this.parcaninUzunlugu = parcaninUzunlugu;
	}
	/**
	 * @return Returns the siberVanaAdeti.
	 */
	public int getSiberVanaAdeti() {
		return siberVanaAdeti;
	}
	/**
	 * @param siberVanaAdeti The siberVanaAdeti to set.
	 */
	public void setSiberVanaAdeti(int siberVanaAdeti) {
		this.siberVanaAdeti = siberVanaAdeti;
	}
	/**
	 * @return Returns the sParcasiAdeti.
	 */
	public int getSParcasiAdeti() {
		return sParcasiAdeti;
	}
	/**
	 * @param parcasiAdeti The sParcasiAdeti to set.
	 */
	public void setSParcasiAdeti(int parcasiAdeti) {
		sParcasiAdeti = parcasiAdeti;
	}
	/**
	 * @return Returns the tAyrilmaAdeti.
	 */
	public int getTAyrilmaAdeti() {
		return tAyrilmaAdeti;
	}
	/**
	 * @param ayrilmaAdeti The tAyrilmaAdeti to set.
	 */
	public void setTAyrilmaAdeti(int ayrilmaAdeti) {
		tAyrilmaAdeti = ayrilmaAdeti;
	}
	/**
	 * @return Returns the tBirlesmeAdeti.
	 */
	public int getTBirlesmeAdeti() {
		return tBirlesmeAdeti;
	}
	/**
	 * @param birlesmeAdeti The tBirlesmeAdeti to set.
	 */
	public void setTBirlesmeAdeti(int birlesmeAdeti) {
		tBirlesmeAdeti = birlesmeAdeti;
	}
	/**
	 * @return Returns the tKarsitAkimAdeti.
	 */
	public int getTKarsitAkimAdeti() {
		return tKarsitAkimAdeti;
	}
	/**
	 * @param karsitAkimAdeti The tKarsitAkimAdeti to set.
	 */
	public void setTKarsitAkimAdeti(int karsitAkimAdeti) {
		tKarsitAkimAdeti = karsitAkimAdeti;
	}
	/**
	 * @return Returns the tGecisAdeti.
	 */
	public int getTGecisAdeti() {
		return tGecisAdeti;
	}
	/**
	 * @param gecisAdeti The tGecisAdeti to set.
	 */
	public void setTGecisAdeti(int gecisAdeti) {
		tGecisAdeti = gecisAdeti;
	}
	/**
	 * @return Returns the tGirisAdeti.
	 */
	public int getTGirisAdeti() {
		return tGirisAdeti;
	}
	/**
	 * @param girisAdeti The tGirisAdeti to set.
	 */
	public void setTGirisAdeti(int girisAdeti) {
		tGirisAdeti = girisAdeti;
	}
	/**
	 * @return Returns the parcaninCapi.
	 */
	public double getParcaninCapi() {
		return parcaninCapi;
	}
	/**
	 * @param parcaninCapi The parcaninCapi to set.
	 */
	public void setParcaninCapi(double parcaninCapi) {
		this.parcaninCapi = parcaninCapi;
	}
}

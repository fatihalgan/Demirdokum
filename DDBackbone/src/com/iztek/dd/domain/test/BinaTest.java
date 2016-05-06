/*
 * Created on 20.Ara.2004
 *
 */
package com.iztek.dd.domain.test;

import junit.framework.TestCase;

import com.iztek.dd.domain.Bilesen;
import com.iztek.dd.domain.Bina;
import com.iztek.dd.domain.BinaDuvari;
import com.iztek.dd.domain.Bolge3;
import com.iztek.dd.domain.DisaAcikDuvar;
import com.iztek.dd.domain.GunesEnerjisiKazanci;
import com.iztek.dd.domain.Pencere;
import com.iztek.dd.domain.Taban;
import com.iztek.dd.domain.Tavan;
import com.iztek.dd.domain.Havalandirma.DogalHavalandirma;
import com.iztek.dd.domain.Havalandirma.MekanikHavalandirma;
import com.iztek.dd.domain.IsiGecirgenligi.AcikGecitUzeri;
import com.iztek.dd.domain.IsiGecirgenligi.Catili;
import com.iztek.dd.domain.IsiGecirgenligi.DIsitilmayan;
import com.iztek.dd.domain.IsiGecirgenligi.DTopragaTemasli;
import com.iztek.dd.domain.IsiGecirgenligi.DisaAcik;
import com.iztek.dd.domain.IsiGecirgenligi.TIsitilmayan;
import com.iztek.dd.domain.IsiGecirgenligi.TTopragaTemasli;
import com.iztek.dd.domain.IsiGecirgenligi.UzeriAcik;

/**
 * @author Selim HENDRICKSON
 *
 */
public class BinaTest extends TestCase {
	Bina bina  = null;
	
	Taban topragaTemasliTaban = null;
	Taban isitilmayanTaban = null;
	Taban acikGecitUzeriTaban = null;
	
	Tavan catiliTavan = null;
	Tavan uzeriAcikTavan = null;
	
	BinaDuvari isitilmayanDuvar = null;
	BinaDuvari topragaTemasliDuvar = null;
	BinaDuvari disaAcikDuvar = null; 
	
	Pencere pencere = null;
	
	public static void main(String[] args) {
	}

	protected void setUp() throws Exception {
		super.setUp();
		bina = new Bina();
		
		topragaTemasliTaban = new Taban(new TTopragaTemasli());
		topragaTemasliTaban.setAlan(90);
		topragaTemasliTaban.addBilesen(new Bilesen(0.030,1.400));
		topragaTemasliTaban.addBilesen(new Bilesen(0.080,0.040));
		topragaTemasliTaban.addBilesen(new Bilesen(0.020,1.400));
		topragaTemasliTaban.addBilesen(new Bilesen(0.100,1.100));
		topragaTemasliTaban.addBilesen(new Bilesen(0.150,1.740));
		bina.addYapiElemani(topragaTemasliTaban);
		
		isitilmayanTaban = new Taban(new TIsitilmayan());
		isitilmayanTaban.setAlan(90);
		isitilmayanTaban.addBilesen(new Bilesen(0.030,0.870));
		isitilmayanTaban.addBilesen(new Bilesen(0.030,0.028));
		isitilmayanTaban.addBilesen(new Bilesen(0.120,2.100));
		isitilmayanTaban.addBilesen(new Bilesen(0.020,1.400));
		bina.addYapiElemani(isitilmayanTaban);
		
		acikGecitUzeriTaban = new Taban(new AcikGecitUzeri());
		acikGecitUzeriTaban.setAlan(40);
		acikGecitUzeriTaban.addBilesen(new Bilesen(0.030,0.870));
		acikGecitUzeriTaban.addBilesen(new Bilesen(0.030,0.028));
		acikGecitUzeriTaban.addBilesen(new Bilesen(0.120,2.100));
		acikGecitUzeriTaban.addBilesen(new Bilesen(0.020,1.400));
		bina.addYapiElemani(acikGecitUzeriTaban);
		
		catiliTavan = new Tavan(new Catili());
		catiliTavan.setAlan(90);
		catiliTavan.addBilesen(new Bilesen(0.100,0.040));
		catiliTavan.addBilesen(new Bilesen(0.120,2.100));
		catiliTavan.addBilesen(new Bilesen(0.020,0.870));
		bina.addYapiElemani(catiliTavan);
		
		uzeriAcikTavan = new Tavan(new UzeriAcik());
		uzeriAcikTavan.setAlan(90);
		uzeriAcikTavan.addBilesen(new Bilesen(0.100,0.040));
		uzeriAcikTavan.addBilesen(new Bilesen(0.120,2.100));
		uzeriAcikTavan.addBilesen(new Bilesen(0.020,0.870));
		bina.addYapiElemani(uzeriAcikTavan);
		
		isitilmayanDuvar = new BinaDuvari("1. duvar",new DIsitilmayan());
		isitilmayanDuvar.setAlan(90);
		isitilmayanDuvar.addBilesen(new Bilesen(0.020,0.870));
		isitilmayanDuvar.addBilesen(new Bilesen(0.190,0.450));
		isitilmayanDuvar.addBilesen(new Bilesen(0.040,0.031));
		isitilmayanDuvar.addBilesen(new Bilesen(0.030,1.400));
		bina.addYapiElemani(isitilmayanDuvar);
		
		topragaTemasliDuvar = new BinaDuvari("1. duvar",new DTopragaTemasli());
		topragaTemasliDuvar.setAlan(40);
		topragaTemasliDuvar.addBilesen(new Bilesen(0.020,0.870));
		topragaTemasliDuvar.addBilesen(new Bilesen(0.190,0.450));
		topragaTemasliDuvar.addBilesen(new Bilesen(0.040,0.031));
		topragaTemasliDuvar.addBilesen(new Bilesen(0.030,1.400));
		bina.addYapiElemani(topragaTemasliDuvar);
		
		disaAcikDuvar = new DisaAcikDuvar("1. duvar",new DisaAcik());
		disaAcikDuvar.setAlan(189);
		disaAcikDuvar.addBilesen(new Bilesen(0.02,0.870));
		disaAcikDuvar.addBilesen(new Bilesen(0.19,0.450));
		disaAcikDuvar.addBilesen(new Bilesen(0.04,0.031));
		disaAcikDuvar.addBilesen(new Bilesen(0.03,1.4));
		bina.addYapiElemani(disaAcikDuvar);

		pencere = new Pencere(2.6,238.20);
		bina.addYapiElemani(pencere);

		
		GunesEnerjisiKazanci kazanc = new GunesEnerjisiKazanci();
		kazanc.setGunesEnerjisiGecirmeFaktoru(0.6);
		kazanc.setPencereAlani(10);
		kazanc.setYon("GUNEY");
		bina.addGunesEnerjisiKazanci(kazanc);
		
		kazanc = new GunesEnerjisiKazanci();
		kazanc.setGunesEnerjisiGecirmeFaktoru(0.6);
		kazanc.setPencereAlani(2);
		kazanc.setYon("KUZEY");
		bina.addGunesEnerjisiKazanci(kazanc);

		kazanc = new GunesEnerjisiKazanci();
		kazanc.setGunesEnerjisiGecirmeFaktoru(0.6);
		kazanc.setPencereAlani(4);
		kazanc.setYon("BATI/DOGU");
		bina.addGunesEnerjisiKazanci(kazanc);

		kazanc = new GunesEnerjisiKazanci();
		kazanc.setGunesEnerjisiGecirmeFaktoru(0.6);
		kazanc.setPencereAlani(4);
		kazanc.setYon("BATI/DOGU");
		bina.addGunesEnerjisiKazanci(kazanc);
		
		bina.setGolgelenmeFaktoru(0.6);
		bina.setIcSicaklik(19);
		bina.setOdaYuksekligi(2.65);
		bina.getProje().setBolge(Bolge3.getInstance());
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		bina = null;
	}

	public void testAddYapiElemani() {
		BinaDuvari testDuvar = new DisaAcikDuvar("1. duvar",new DisaAcik());
		testDuvar.setAlan(189);
		Bilesen bilesen1 = new Bilesen(0.02,0.870);
		Bilesen bilesen2 = new Bilesen(0.19,0.450);
		Bilesen bilesen3 = new Bilesen(0.04,0.031);
		Bilesen bilesen4 = new Bilesen(0.03,1.4);
		bina.addYapiElemani(testDuvar);
		
		assertTrue(bina.getYapiElemanlari().contains(testDuvar));
	}

	public void testHesaplaOzgulIletimselIsiKaybi() {
		assertEquals("Binanýn özgül iletimsel ýsý kaybý yanlýþ hesaplandý!",879.904,bina.hesaplaOzgulIletimselIsiKaybi(),0.1);
	}

	public void testHesaplaToplamOzgulIsiKaybiWithDogal(){
		DogalHavalandirma havalandirma = new DogalHavalandirma();
		havalandirma.setBrutHacim(200);
		havalandirma.setHavaDegisimSayisi(1);
		bina.setHavalandirma(havalandirma);
		assertEquals("Binanýn toplam özgül ýsý kaybý yanlýþ hesaplandý!",932.704,bina.hesaplaToplamOzgulIsiKaybi(),0.1);
	}
	
	public void testHesaplaToplamOzgulIsiKaybiWithMekanik(){
		MekanikHavalandirma havalandirma = new MekanikHavalandirma();
		//havalandirma.setHavaDegisimSayisi(1);
		havalandirma.setBrutHacim(200);
		havalandirma.setHavaGirisDebisi(5);
		havalandirma.setHavaCýkýsDebisi(10);
		havalandirma.setF(20);
		havalandirma.setE(0.1);
		havalandirma.setN50(4);
		bina.setHavalandirma(havalandirma);
		assertEquals("Binanýn toplam özgül ýsý kaybý yanlýþ hesaplandý!",883.524,bina.hesaplaToplamOzgulIsiKaybi(),0.1);
	}

		public void testHesaplaGunesEnerjisiKazanci(){
			assertEquals("Güneþ enerjisi kazancý yanlýþ hesaplandý!",6818.22,bina.hesaplaGunesEnerjisiKazanci(),5);
		}
		
		public void testHesaplaIcIsiKazanci(){
			bina.setBrutHacim(200);
			bina.setEnerjiKullanimKatsayisi(5);
			assertEquals("Ýç ýsý kazancý yanlýþ hesaplandý!",320,bina.hesaplaIcIsiKazanci(),1);
		}
		
		public void testHesaplaAyaBolgeyeGoreSicaklikFarki(){
			assertEquals("Aya bölgeye göre sýcaklýk farký hatalý hesaplandý!",17.7,bina.hesaplaAyaBolgeyeGoreSicaklikFarki("1"),0.1);
			assertEquals("Aya bölgeye göre sýcaklýk farký hatalý hesaplandý!",0.9,bina.hesaplaAyaBolgeyeGoreSicaklikFarki("6"),0.1);
			assertEquals("Aya bölgeye göre sýcaklýk farký hatalý hesaplandý!",12.5,bina.hesaplaAyaBolgeyeGoreSicaklikFarki("11"),0.1);
			assertEquals("Aya bölgeye göre sýcaklýk farký hatalý hesaplandý!",14,bina.hesaplaAyaBolgeyeGoreSicaklikFarki("3"),0.1);
		}
		
		public void testHesaplaIsiKaybi(){
			DogalHavalandirma havalandirma = new DogalHavalandirma();
			havalandirma.setBrutHacim(200);
			havalandirma.setHavaDegisimSayisi(1);
			bina.setHavalandirma(havalandirma);
			assertEquals("Isý kaybý hatalý hesaplandý!",4570.2496,bina.hesaplaAylikIsiKaybi("5"),1);
			MekanikHavalandirma mhavalandirma = new MekanikHavalandirma();
			//mhavalandirma.setHavaDegisimSayisi(1);
			mhavalandirma.setBrutHacim(200);
			mhavalandirma.setHavaGirisDebisi(5);
			mhavalandirma.setHavaCýkýsDebisi(10);
			mhavalandirma.setF(20);
			mhavalandirma.setE(0.1);
			mhavalandirma.setN50(4);
			bina.setHavalandirma(mhavalandirma);
			assertEquals("Isý kaybý hatalý hesaplandý!",11044.05,bina.hesaplaAylikIsiKaybi("11"),2);
		}
		
		public void testHesaplaAylikGunesEnerjisiKazanci(){
		    assertEquals("Aylýk güneþ enerjisi toplamý hatalý hesaplandý!",402,bina.hesaplaAylikGunesEnerjisiKazanci("1"),1);
		}
		
		public void testHesaplaToplamAylikIsiKazanci(){
			bina.setBrutHacim(495);
			bina.setEnerjiKullanimKatsayisi(5);
		    assertEquals("Aylýk ýsý kazancý hatalý hesaplandý!",1194,bina.hesaplaToplamAylikIsiKazanci("1"),1);
		}
		
//		public void testHesaplaKazancKullanimOrani(){
//			DogalHavalandirma havalandirma = new DogalHavalandirma();
//			havalandirma.setBrutHacim(495);
//			havalandirma.setHavaDegisimSayisi(1);
//			bina.setHavalandirma(havalandirma);
//		    assertEquals("Kazanç kullaným oraný hatalý hesaplandý!",0.21,bina.hesaplaKazancKullanimOrani("1"),0.01);
//		}
		
		public void testHesaplaYillikIsitmaEnerjisiIhtiyaci(){			
			bina.setBrutHacim(200);
			assertEquals("Standart yýllýk ýsýtma enerjisi ihtiyacý yanlýþ hesaplandý!",39,bina.hesaplaStandartYillikIsitmaEnerjisiIhtiyaci(),1);
			bina.setBrutHacim(1000);
			assertEquals("Standart yýllýk ýsýtma enerjisi ihtiyacý yanlýþ hesaplandý!",36.85,bina.hesaplaStandartYillikIsitmaEnerjisiIhtiyaci(),1);
		}
		
}

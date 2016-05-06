/*
 * Created on 29.Ara.2004
 *
 */
package com.iztek.dd.utilities;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.iztek.dd.domain.Bolge1;
import com.iztek.dd.domain.Bolge2;
import com.iztek.dd.domain.Bolge3;
import com.iztek.dd.domain.Bolge4;

/**
 * @author Selim HENDRICKSON
 *
 */
public class IllerBean {
	private static ArrayList iller = new ArrayList();
	private static IllerBean instance = null;
	
	public IllerBean(){
		iller.add(new Il(Bolge1.getInstance(),"ADANA",new Rectangle2D.Double(233,148,27,20),0));
		iller.add(new Il(Bolge2.getInstance(),"ADIYAMAN",new Rectangle2D.Double(303,139,26,11),-9));
		iller.add(new Il(Bolge4.getInstance(),"AÐRI",new Rectangle2D.Double(422,68,38,14),-24));
		iller.add(new Il(Bolge3.getInstance(),"AFYON",new Rectangle2D.Double(108,105,24,19),-12));	
		iller.add(new Il(Bolge3.getInstance(),"AKSARAY",new Rectangle2D.Double(189,118,26,14),-15));
		iller.add(new Il(Bolge2.getInstance(),"AMASYA",new Rectangle2D.Double(236,45,26,10),-12));
		iller.add(new Il(Bolge3.getInstance(),"ANKARA",new Rectangle2D.Double(146,62,45,32),-12));
		iller.add(new Il(Bolge1.getInstance(),"ANTALYA",new Rectangle2D.Double(96,168,69,27),3));
		iller.add(new Il(Bolge4.getInstance(),"ARDAHAN",new Rectangle2D.Double(421,15,23,15),0)); //EKSÝK
		iller.add(new Il(Bolge3.getInstance(),"ARTVÝN",new Rectangle2D.Double(391,15,25,22),-9));
		iller.add(new Il(Bolge1.getInstance(),"AYDIN",new Rectangle2D.Double(28,138,35,15),-3));
		iller.add(new Il(Bolge2.getInstance(),"BALIKESÝR",new Rectangle2D.Double(31,66,36,24),-3));
		iller.add(new Il(Bolge2.getInstance(),"BARTIN",new Rectangle2D.Double(161,14,13,12),0)); //EKSÝK
		iller.add(new Il(Bolge2.getInstance(),"BATMAN",new Rectangle2D.Double(396,120,11,25),-9));
		iller.add(new Il(Bolge4.getInstance(),"BAYBURT",new Rectangle2D.Double(357,52,15,14),-15));
		iller.add(new Il(Bolge3.getInstance(),"BÝLECÝK",new Rectangle2D.Double(101,61,12,13),-9));
		iller.add(new Il(Bolge3.getInstance(),"BÝNGÖL",new Rectangle2D.Double(371,87,23,18),-18));
		iller.add(new Il(Bolge4.getInstance(),"BÝTLÝS",new Rectangle2D.Double(415,102,20,17),-15));
		iller.add(new Il(Bolge3.getInstance(),"BOLU",new Rectangle2D.Double(127,40,31,19),-15));
		iller.add(new Il(Bolge3.getInstance(),"BURDUR",new Rectangle2D.Double(88,148,32,14),-9));
		iller.add(new Il(Bolge2.getInstance(),"BURSA",new Rectangle2D.Double(61,57,34,20),-6));
		iller.add(new Il(Bolge2.getInstance(),"ÇANAKKALE",new Rectangle2D.Double(4,50,27,26),-3));
		iller.add(new Il(Bolge3.getInstance(),"ÇANKIRI",new Rectangle2D.Double(180,41,27,16),-15));
		iller.add(new Il(Bolge3.getInstance(),"ÇORUM",new Rectangle2D.Double(210,47,25,17),-15));
		iller.add(new Il(Bolge2.getInstance(),"DENÝZLÝ",new Rectangle2D.Double(70,135,18,22),-6));
		iller.add(new Il(Bolge2.getInstance(),"DÝYARBAKIR",new Rectangle2D.Double(356,126,32,17),-9));
		iller.add(new Il(Bolge2.getInstance(),"EDÝRNE",new Rectangle2D.Double(7,3,13,39),-9));
		iller.add(new Il(Bolge3.getInstance(),"ELAZIÐ",new Rectangle2D.Double(328,107,36,13),-12));
		iller.add(new Il(Bolge4.getInstance(),"ERZÝNCAN",new Rectangle2D.Double(322,76,39,7),-18));
		iller.add(new Il(Bolge4.getInstance(),"ERZURUM",new Rectangle2D.Double(375,51,45,29),-21));
		iller.add(new Il(Bolge3.getInstance(),"ESKÝÞEHÝR",new Rectangle2D.Double(115,77,30,21),-12));
		iller.add(new Il(Bolge2.getInstance(),"GAZÝANTEP",new Rectangle2D.Double(281,163,30,9),-9));
		iller.add(new Il(Bolge2.getInstance(),"GÝRESUN",new Rectangle2D.Double(310,41,22,22),-3));
		iller.add(new Il(Bolge4.getInstance(),"GÜMÜÞHANE",new Rectangle2D.Double(332,48,21,21),-12));
		iller.add(new Il(Bolge4.getInstance(),"HAKKARÝ",new Rectangle2D.Double(460,133,26,18),-24));
		iller.add(new Il(Bolge1.getInstance(),"HATAY",new Rectangle2D.Double(259,176,16,25),0));
		iller.add(new Il(Bolge3.getInstance(),"IÐDIR",new Rectangle2D.Double(448,56,30,9),0)); //EKSÝK
		iller.add(new Il(Bolge3.getInstance(),"ISPARTA",new Rectangle2D.Double(114,132,23,17),-9));
		iller.add(new Il(Bolge1.getInstance(),"ÝÇEL",new Rectangle2D.Double(185,176,34,12),3));
		iller.add(new Il(Bolge2.getInstance(),"ÝSTANBUL",new Rectangle2D.Double(62,23,27,20),-3));
		iller.add(new Il(Bolge1.getInstance(),"ÝZMÝR",new Rectangle2D.Double(25,120,21,14),0));			
		iller.add(new Il(Bolge2.getInstance(),"KAHRAMANMARAÞ",new Rectangle2D.Double(270,130,29,23),-9));
		iller.add(new Il(Bolge3.getInstance(),"KARABÜK",new Rectangle2D.Double(165,29,12,15),0)); //EKSÝK
		iller.add(new Il(Bolge3.getInstance(),"KARAMAN",new Rectangle2D.Double(176,161,22,11),-12));
		iller.add(new Il(Bolge4.getInstance(),"KARS",new Rectangle2D.Double(425,40,27,15),-27));
		iller.add(new Il(Bolge4.getInstance(),"KASTAMONU",new Rectangle2D.Double(176,10,33,24),-12));
		iller.add(new Il(Bolge4.getInstance(),"KAYSERÝ",new Rectangle2D.Double(238,109,29,27),-15));
		iller.add(new Il(Bolge3.getInstance(),"KIRIKKALE",new Rectangle2D.Double(196,63,8,22),0)); //EKSÝK
		iller.add(new Il(Bolge3.getInstance(),"KIRKLARELÝ",new Rectangle2D.Double(27,0,24,22),-12));
		iller.add(new Il(Bolge3.getInstance(),"KIRÞEHÝR",new Rectangle2D.Double(197,91,22,15),-12));
		iller.add(new Il(Bolge2.getInstance(),"KÝLÝS",new Rectangle2D.Double(279,172,17,19),0)); //EKSÝK
		iller.add(new Il(Bolge2.getInstance(),"KOCAELÝ",new Rectangle2D.Double(93,35,14,14),-3));		
		iller.add(new Il(Bolge3.getInstance(),"KONYA",new Rectangle2D.Double(145,116,41,38),-12));		
		iller.add(new Il(Bolge3.getInstance(),"KÜTAHYA",new Rectangle2D.Double(79,86,28,20),-12));
		iller.add(new Il(Bolge3.getInstance(),"MALATYA",new Rectangle2D.Double(298,110,27,20),-12));
		iller.add(new Il(Bolge2.getInstance(),"MANÝSA",new Rectangle2D.Double(38,99,30,20),-3));
		iller.add(new Il(Bolge2.getInstance(),"MARDÝN",new Rectangle2D.Double(367,149,42,11),-6));
		iller.add(new Il(Bolge1.getInstance(),"MUÐLA",new Rectangle2D.Double(33,158,41,20),-3));
		iller.add(new Il(Bolge4.getInstance(),"MUÞ",new Rectangle2D.Double(395,89,26,12),-18));
		iller.add(new Il(Bolge3.getInstance(),"NEVÞEHÝR",new Rectangle2D.Double(215,109,16,15),-15));		
		iller.add(new Il(Bolge3.getInstance(),"NÝÐDE",new Rectangle2D.Double(213,134,16,20),-15));
		iller.add(new Il(Bolge2.getInstance(),"ORDU",new Rectangle2D.Double(284,36,25,13),-3));
		iller.add(new Il(Bolge1.getInstance(),"OSMANÝYE",new Rectangle2D.Double(258,154,14,12),0)); //EKSÝK
		iller.add(new Il(Bolge2.getInstance(),"RÝZE",new Rectangle2D.Double(368,25,22,14),-3));
		iller.add(new Il(Bolge2.getInstance(),"SAKARYA",new Rectangle2D.Double(111,35,11,23),0));
		iller.add(new Il(Bolge2.getInstance(),"SAMSUN",new Rectangle2D.Double(239,20,37,21),-3));
		iller.add(new Il(Bolge2.getInstance(),"SÝÝRT",new Rectangle2D.Double(410,127,21,12),0)); //EKSÝK
		iller.add(new Il(Bolge2.getInstance(),"SÝNOP",new Rectangle2D.Double(215,8,24,21),0)); //EKSÝK
		iller.add(new Il(Bolge4.getInstance(),"SÝVAS",new Rectangle2D.Double(260,74,56,26),0)); //EKSÝK
		iller.add(new Il(Bolge2.getInstance(),"ÞANLIURFA",new Rectangle2D.Double(312,154,59,15),-6)); 
		iller.add(new Il(Bolge2.getInstance(),"ÞIRNAK",new Rectangle2D.Double(416,142,35,11),-6));
		iller.add(new Il(Bolge2.getInstance(),"TEKÝRDAÐ",new Rectangle2D.Double(26,24,26,22),-6));
		iller.add(new Il(Bolge3.getInstance(),"TOKAT",new Rectangle2D.Double(255,57,37,11),-15));		
		iller.add(new Il(Bolge2.getInstance(),"TRABZON",new Rectangle2D.Double(338,34,33,12),-3));
		iller.add(new Il(Bolge3.getInstance(),"TUNCELÝ",new Rectangle2D.Double(334,89,28,13),-18));		
		iller.add(new Il(Bolge3.getInstance(),"UÞAK",new Rectangle2D.Double(74,113,18,11),-9));
		iller.add(new Il(Bolge4.getInstance(),"VAN",new Rectangle2D.Double(445,82,35,47),-15));
		iller.add(new Il(Bolge2.getInstance(),"YALOVA",new Rectangle2D.Double(80,48,9,4),-3));
		iller.add(new Il(Bolge4.getInstance(),"YOZGAT",new Rectangle2D.Double(218,76,35,20),-15));
		iller.add(new Il(Bolge2.getInstance(),"ZONGULDAK",new Rectangle2D.Double(141,24,18,12),-3));							
		
		//Farklýlýk gösteren ilçeler
		iller.add(new Il(Bolge4.getInstance(),"ULUDAÐ",new Rectangle2D.Double(0,0,0,0),-3));
		iller.add(new Il(Bolge4.getInstance(),"KELEÞ",new Rectangle2D.Double(0,0,0,0),-3));
		iller.add(new Il(Bolge1.getInstance(),"AYVALIK",new Rectangle2D.Double(0,0,0,0),-3));
		iller.add(new Il(Bolge3.getInstance(),"DURSUNBEY",new Rectangle2D.Double(0,0,0,0),-3));
		iller.add(new Il(Bolge1.getInstance(),"MÝLAS",new Rectangle2D.Double(0,0,0,0),-3));
		iller.add(new Il(Bolge1.getInstance(),"BODRUM",new Rectangle2D.Double(0,0,0,0),-3));
		iller.add(new Il(Bolge1.getInstance(),"KÖYCEÐÝZ",new Rectangle2D.Double(0,0,0,0),-3));
		iller.add(new Il(Bolge1.getInstance(),"GÖKOVA",new Rectangle2D.Double(0,0,0,0),-3));
		iller.add(new Il(Bolge1.getInstance(),"DATÇA",new Rectangle2D.Double(0,0,0,0),-3));
		iller.add(new Il(Bolge1.getInstance(),"MARMARÝS",new Rectangle2D.Double(0,0,0,0),-3));
		iller.add(new Il(Bolge1.getInstance(),"DALAMAN",new Rectangle2D.Double(0,0,0,0),-3));
		iller.add(new Il(Bolge1.getInstance(),"FETHÝYE",new Rectangle2D.Double(0,0,0,0),-3));
		iller.add(new Il(Bolge3.getInstance(),"KORKUTELÝ",new Rectangle2D.Double(0,0,0,0),-3));
		iller.add(new Il(Bolge2.getInstance(),"DÜZCE",new Rectangle2D.Double(0,0,0,0),-3));
		iller.add(new Il(Bolge3.getInstance(),"ULUS",new Rectangle2D.Double(0,0,0,0),-3));
		iller.add(new Il(Bolge2.getInstance(),"CÝDE",new Rectangle2D.Double(0,0,0,0),-3));
		iller.add(new Il(Bolge2.getInstance(),"ABANA",new Rectangle2D.Double(0,0,0,0),-3));
		iller.add(new Il(Bolge2.getInstance(),"ÇATALZEYTÝN",new Rectangle2D.Double(0,0,0,0),-3));
		iller.add(new Il(Bolge2.getInstance(),"ÝNEBOLU",new Rectangle2D.Double(0,0,0,0),-3));
		iller.add(new Il(Bolge2.getInstance(),"BOZKURT",new Rectangle2D.Double(0,0,0,0),-3));
		iller.add(new Il(Bolge2.getInstance(),"DOÐANYURT",new Rectangle2D.Double(0,0,0,0),-3));
		iller.add(new Il(Bolge3.getInstance(),"TOSYA",new Rectangle2D.Double(0,0,0,0),-3));
		iller.add(new Il(Bolge3.getInstance(),"MERZÝFON",new Rectangle2D.Double(0,0,0,0),-3));
		iller.add(new Il(Bolge3.getInstance(),"POZANTI",new Rectangle2D.Double(0,0,0,0),-3));
		iller.add(new Il(Bolge4.getInstance(),"MESUDÝYE",new Rectangle2D.Double(0,0,0,0),-3));
		iller.add(new Il(Bolge4.getInstance(),"ÞEBÝNKARAHÝSAR",new Rectangle2D.Double(0,0,0,0),-3));
		iller.add(new Il(Bolge4.getInstance(),"ELBÝSTAN",new Rectangle2D.Double(0,0,0,0),-3));
		iller.add(new Il(Bolge4.getInstance(),"AFÞÝN",new Rectangle2D.Double(0,0,0,0),-3));
		iller.add(new Il(Bolge4.getInstance(),"GÖKSUN",new Rectangle2D.Double(0,0,0,0),-3));
		iller.add(new Il(Bolge2.getInstance(),"HOPA",new Rectangle2D.Double(0,0,0,0),-3));
		iller.add(new Il(Bolge2.getInstance(),"ARHAVÝ",new Rectangle2D.Double(0,0,0,0),-3));
		iller.add(new Il(Bolge4.getInstance(),"PÜLÜMÜR",new Rectangle2D.Double(0,0,0,0),-3));
		iller.add(new Il(Bolge4.getInstance(),"KIÐI",new Rectangle2D.Double(0,0,0,0),-3));
		iller.add(new Il(Bolge4.getInstance(),"SELHAN",new Rectangle2D.Double(0,0,0,0),-3));
	}
	
	public static IllerBean getInstance(){
	    if(instance == null) instance = new IllerBean();
	    return instance;
	}
		
	public List getIller(){	    
	    return Collections.unmodifiableList(iller);
	}
	
	public Il getIl(String ad){
	    Il il = null;
	    Iterator it = iller.iterator();
	    while(it.hasNext()){
	        il = (Il)it.next();
	        if(il.getAd()==ad) return il;
	    }
	    return il;
	}
	
	public Il getIl(Point2D point){
	    Il il = null;
	    Iterator it = iller.iterator();
	    while(it.hasNext()){
	        il = (Il)it.next();
	        if(il.getRectangle().contains(point)) return il;
	    }
	    return null;
	}

}

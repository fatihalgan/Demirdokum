package com.iztek.dd.utilities;

import java.util.Comparator;

public class AlphabeticalOrder implements Comparator {
            public int compare(Object obj1, Object obj2) {
               Il il1 = (Il)obj1;  
               Il il2 = (Il)obj2;
               String ilAdi1 = il1.getAd().toLowerCase();  
			   String ilAdi2 = il2.getAd().toLowerCase();
               return ilAdi1.compareTo(ilAdi2);
            }
         }

/*
 * Created on 12.Þub.2005
 *
 */
package com.iztek.dd.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.DecimalFormat;
import java.util.Iterator;

import javax.swing.JPanel;

import com.iztek.dd.domain.Bilesen;
import com.iztek.dd.domain.BilesikYapiElemani;
import com.iztek.dd.domain.BinaDuvari;
import com.iztek.dd.domain.Yogusabilen;

/**
 * @author Selim HENDRICKSON
 *
 */
public class GrafikPanel extends JPanel {
	private BilesikYapiElemani selectedEleman = null;
	DecimalFormat oneDigit = new DecimalFormat("0.0"); 

	/**
	 * This is the default constructor
	 */
	public GrafikPanel(BilesikYapiElemani selectedEleman) {
		super();
		initialize();
		this.selectedEleman = selectedEleman;
	}

	public void paint(Graphics g) {
		super.paint(g);
		((Yogusabilen)selectedEleman).getYogusmaCizelgesi();
		Iterator it2 = ((BinaDuvari)selectedEleman).getBilesenler().iterator();
		double toplamHavaTabakasiKalinligi = 0;
		while(it2.hasNext()){						
			Bilesen bilesen = ((Bilesen)it2.next());
			 toplamHavaTabakasiKalinligi += bilesen.hesaplaDifuzyonDengiHavaTabakasiKalinligi(); 
		}

		
		int chartLength = (new Double(selectedEleman.hesaplaBilesenlerinDifuzyonDengiHavaTabakasiKalinligi()*100)).intValue();;
		int magnifier = (30000/chartLength); 
		int xOffset = 30;
		int yOffset = 310;
		int legendOffset = 25;
		double legend = 0;
		Iterator it = (selectedEleman.getBilesenler()).iterator();
		g.setFont(new Font("Arial",1,10));
		for(int i=0; i < 10; i++){
			g.drawString(""+(i*300),1,10+yOffset-(i*30));
		}
		g.drawString("Pa",10,30);
		g.drawLine(xOffset,10,xOffset,10+yOffset);
		g.drawString("0",xOffset,legendOffset+yOffset);
		g.setFont(new Font("Arial",1,14));
		g.drawString("Yoðuþma grafiði",xOffset,legendOffset+50+yOffset);
		g.setFont(new Font("Arial",1,10));
		int xBilesen = 0;
		int yBilesen = 0;
		int xi = 0;
		int yi = (new Double(selectedEleman.hesaplaIcYuzeySuBuhariBasinci()/10)).intValue();
		int yst1 = (new Double(selectedEleman.getIC_SU_BUHARI_KISMI_BASINCI()/10)).intValue();
		int yst2 = (new Double(selectedEleman.getDisSuBuhariKismiBasinci()/10)).intValue();		
		while(it.hasNext()){	
			Bilesen bilesen = (Bilesen) it.next();						
			xBilesen += (new Double(bilesen.hesaplaDifuzyonDengiHavaTabakasiKalinligi()*magnifier)).intValue();
			yBilesen = (new Double(bilesen.hesaplaDoymusSuBuhariBasinci()/10)).intValue();
			legend += bilesen.hesaplaDifuzyonDengiHavaTabakasiKalinligi();
			g.setColor( new Color(0,0,0));
			g.drawLine(xOffset+xBilesen,10,xOffset+xBilesen,10+yOffset);
			g.drawLine(xOffset,10+yOffset,xOffset+xBilesen,10+yOffset);
			g.drawString(oneDigit.format(legend),xOffset+xBilesen,legendOffset+yOffset);
			g.setColor(new Color(255,0,0));			
			g.drawLine(xOffset+xi,yOffset-yi,xOffset+xBilesen,yOffset-yBilesen);
			xi = xBilesen;
			yi = yBilesen;
		}
		g.setColor(new Color(0,0,0));
		g.drawString("m",xOffset+xi+20,yOffset+25);
		
		g.setColor(new Color(0,0,255));
		g.drawLine(xOffset,yOffset-yst1,xOffset+xBilesen,yOffset-yst2);
		
		g.setColor(new Color(0,0,0));
		xOffset = 400;
		yOffset = 310;
		it = (selectedEleman.getBilesenler()).iterator();
		g.setFont(new Font("Arial",1,10));
		for(int i=0; i < 10; i++){
			g.drawString(""+(i*300),1+xOffset-30,10+yOffset-(i*30));
		}
		g.drawString("Pa",xOffset-20,30);
		g.drawLine(xOffset,10,xOffset,10+yOffset);
		g.drawString("0",xOffset,legendOffset+yOffset);
		g.setFont(new Font("Arial",1,14));
		g.drawString("Buharlaþma grafiði",xOffset,legendOffset+50+yOffset);
		g.setFont(new Font("Arial",1,10));
		xBilesen = 0;
		yBilesen = 0;
		legend = 0;
		while(it.hasNext()){	
			Bilesen bilesen = (Bilesen) it.next();						
			xBilesen += (new Double(bilesen.hesaplaDifuzyonDengiHavaTabakasiKalinligi()*magnifier)).intValue();
			yBilesen = (new Double(bilesen.hesaplaDoymusSuBuhariBasinci()/10)).intValue();
			legend += bilesen.hesaplaDifuzyonDengiHavaTabakasiKalinligi();
			g.setColor( new Color(0,0,0));
			g.drawLine(xOffset+xBilesen,10,xOffset+xBilesen,10+yOffset);
			g.drawLine(xOffset,10+yOffset,xOffset+xBilesen,10+yOffset);
			g.drawString(oneDigit.format(legend),xOffset+xBilesen,legendOffset+yOffset);
		}
		g.setColor(new Color(0,0,0));
		g.drawString("m",xOffset+xi+20,yOffset+25);

		g.setColor(new Color(255,0,0));
		int yBuharlasma = (new Double(selectedEleman.getBUHARLASMA_DOYMUS_SU_BUHARI_BASINCI()/10)).intValue();
		g.drawLine(xOffset,yOffset-yBuharlasma,xOffset+xBilesen,yOffset-yBuharlasma);
		g.setColor(new Color(0,0,255));
		yBuharlasma = (new Double(selectedEleman.getBUHARLASMA_SU_BUHARI_KISMI_BASINCI()/10)).intValue();
		g.drawLine(xOffset,yOffset-yBuharlasma,xOffset+xBilesen,yOffset-yBuharlasma);

	}
	private  void initialize() {
		this.setSize(300,200);
	}
}

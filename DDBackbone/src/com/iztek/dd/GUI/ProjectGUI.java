package com.iztek.dd.GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import com.iztek.dd.GUI.ddtree.DDTree;
import com.iztek.dd.GUI.ddtree.MyRenderer;
import com.iztek.dd.GUI.ddtree.item.DuvarTreeItemPanel;
import com.iztek.dd.GUI.ddtree.item.KapiTreeItemPanel;
import com.iztek.dd.GUI.ddtree.item.KatTreeItemPanel;
import com.iztek.dd.GUI.ddtree.item.KirisTreeItemPanel;
import com.iztek.dd.GUI.ddtree.item.KolonTreeItemPanel;
import com.iztek.dd.GUI.ddtree.item.MahalTreeItemPanel;
import com.iztek.dd.GUI.ddtree.item.PencereTreeItemPanel;
import com.iztek.dd.GUI.ddtree.item.TreeItemPanel;
import com.iztek.dd.GUI.util.SwingUtils;
import com.iztek.dd.IsiKaybi.domain.IsiYalitimiTableModel;
import com.iztek.dd.IsiKaybi.domain.Isitici;
import com.iztek.dd.IsiKaybi.domain.KritikHat;

public class ProjectGUI extends JPanel
{    
	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 5509589994637340640L;
	
	PropertyChangeSupport propertySupport = null;
	DecimalFormat twoDigits = null;
	
    public ProjectGUI()
    {
    	propertySupport = new PropertyChangeSupport(this);
    	
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator('.');
		twoDigits = new DecimalFormat("##.##",symbols);

        jPanel = null;
        projectTabbedPane = null;
        ts825Panel = null;
        isiKaybiPanel = null;
        tanimlarPanel = null;
        isiKaybiTabbedPane = null;
        jPanel5 = null;
        kritikHatPanel = null;
        jPanel7 = null;
        jSplitPane = null;
        ddTreePanel = null;
        ddTreeCardLayoutPanel = null;
        illerScrollPane = null;
        illerList = null;
        illerLabel = null;
        secilenIlLabel = null;
        secilenLabel = null;
        konutRadioButton = null;
        enerjiRadioButton = null;
        binaTipiPanel = null;
        netOdaYuksekligiPanel = null;
        yuksek26RadioButton = null;
        esit26RadioButton = null;
        havalandirmaPanel = null;
        dogalRadioButton = null;
        mekanikRadioButton = null;
        yerlesimBolgesiPanel = null;
        ayrikRadioButton = null;
        mahfuzRadioButton = null;
        bitisikRadioButton = null;
        haritaLabel = null;
        ts825TabbedPane = null;
        binaKonumBilgileriPanel = null;
        ozgulIsiKaybiPanel = null;
        yillikIsitmaIhtiyaciPanel = null;
        tanimlarTabbedPane = null;
        bolgePanel = null;
        projePanel = null;
        projeAdiTextField = null;
        projeAdiLabel = null;
        muhendisAdTextField = null;
        muhendisAdLabel = null;
        muhendisPanel = null;
        muhendisUnvanLabel = null;
        muhendisSicilLabel = null;
        muhendisUnvanTextField = null;
        muhendisSicilTextField = null;
        binaPanel = null;
        adaParselLabel = null;
        binaTanimLabel = null;
        caddeLabel = null;
        ilIlceLabel = null;
        yakitLabel = null;
        adaParselTextField = null;
        binaTanimTextField = null;
        caddeTextField = null;
        ilIlceTextField = null;
        yakitTextField = null;
        ozgulIsiKaybiSplitPane = null;
        jPanel21 = null;
        jPanel22 = null;
        yapiElemanTipleriTree = null;
        disDuvarPanel = null;
        isitilmayanDuvarPanel = null;
        topragaTemasliDuvarPanel = null;
        uzeriAcikTavanPanel = null;
        catiliTavanPanel = null;
        topragaTemasliTabanPanel = null;
        isitilmayanTabanPanel = null;
        acikGecitUzeriTabanPanel = null;
        pencerePanel = null;
        havalandirmaSecButton = null;        
        disDuvarModelTable = null;
        disDuvarModelScrollPane = null;
        disDuvarlarList = null;
        disDuvarlarScrollPane = null;
        disDuvarEkleButton = null;
        disDuvarCikarButton = null;
        disDuvarAlanLabel = null;
        disDuvarAlanTextField = null;
        disDuvarULabel = null;
        disDuvarUTextField = null;
        birimLabel = null;
        birimLabel1 = null;
        jPanel33 = null;
        toplamAlanLabel = null;
        brutHacimLabel = null;
        alanHacimOraniLabel = null;
        toplamAlanTextField = null;
        brutHacimTextField = null;
        alanHacimOraniTextField = null;
        birimLabel2 = null;
        birimLabel3 = null;
        birimLabel5 = null;
        jPanel34 = null;
        icOrtamSicakligiLabel = null;
        ozgunIsiKaybiLabel = null;
        icOrtamSicakligiTextField = null;
        iletimselOzgulIsiKaybiTextField = null;
        birimLabel4 = null;
        birimLabel6 = null;
        jPanel35 = null;
        havaDegisimKatsayisiLabel = null;
        ozgunIsiKaybiLabel1 = null;
        toplamOzgulIsiKaybiLabel = null;
        havaDegisimKatsayisiTextField = null;
        havalandirmaOzgulIsiKaybiTextField = null;
        toplamOzgulIsiKaybiTextField = null;
        birimLabel7 = null;
        birimLabel8 = null;
        birimLabel9 = null;
        jPanel36 = null;
        qLabel = null;
        qTextField = null;
        jPanel37 = null;
        jSplitPane2 = null;
        jPanel38 = null;
        jPanel40 = null;
        gDikDoguLabel = null;
        gDikBatiLabel = null;
        gDikGuneyLabel = null;
        gDikKuzeyLabel = null;
        gDikDoguBRadioButton = null;
        gDikDoguORadioButton = null;
        gDikDoguKRadioButton = null;
        gDikBatiBRadioButton = null;
        gDikBatiORadioButton = null;
        gDikBatiKRadioButton = null;
        gDikGuneyBRadioButton = null;
        gDikGuneyORadioButton = null;
        gDikGuneyKRadioButton = null;
        gDikKuzeyBRadioButton = null;
        gDikKuzeyORadioButton = null;
        gDikKuzeyKRadioButton = null;
        jPanel41 = null;
        toplamPencereAlaniLabel = null;
        doguPencereRadioButton = null;
        batiPencereRadioButton = null;
        guneyPencereRadioButton = null;
        kuzeyPencereRadioButton = null;
        yoneGorePencereAlaniTextField = null;
        toplamPencereAlaniTextField = null;
        birimLabel24 = null;
        isiYalitimiPanel = null;
        initialize();
    }

    private void initialize()
    {
        setLayout(new BorderLayout());
        add(getJPanel(), "Center");
        setSize(710, 520);
        this.setPreferredSize(new java.awt.Dimension(710,550));
    }

    private JPanel getJPanel()
    {
        if(jPanel == null)
        {
            jPanel = new JPanel();
            jPanel.setLayout(new BorderLayout());
            jPanel.add(getProjectTabbedPane(), "Center");
        }
        return jPanel;
    }

    private JTabbedPane getProjectTabbedPane()
    {
        if(projectTabbedPane == null)
        {
            projectTabbedPane = new JTabbedPane();
            projectTabbedPane.addTab("Genel Tanýmlar", null, getTanimlarPanel(), null);
            projectTabbedPane.addTab("TS 825", null, getTs825Panel(), null);
            projectTabbedPane.addTab("ISI KAYBI", null, getIsiKaybiPanel(), null);
            projectTabbedPane.addTab("ISI KAZANCI", null, getIsiKazanciPanel1(), null);
        }
        return projectTabbedPane;
    }

    private JPanel getTs825Panel()
    {
        if(ts825Panel == null)
        {
            ts825Panel = new JPanel();
            ts825Panel.setLayout(new BorderLayout());
            ts825Panel.add(getTs825TabbedPane(), BorderLayout.CENTER);
            ts825Panel.setName("TS 825");
        }
        return ts825Panel;
    }

    private JPanel getIsiKaybiPanel()
    {
        if(isiKaybiPanel == null)
        {
            isiKaybiPanel = new JPanel();
            isiKaybiPanel.setLayout(new BorderLayout());
            isiKaybiPanel.add(getIsiKaybiTabbedPane(), BorderLayout.CENTER);
        }
        return isiKaybiPanel;
    }

    private JPanel getTanimlarPanel()
    {
        if(tanimlarPanel == null)
        {
            tanimlarPanel = new JPanel();
            tanimlarPanel.setLayout(new BorderLayout());
            tanimlarPanel.add(getTanimlarTabbedPane(), "Center");
        }
        return tanimlarPanel;
    }

    private JTabbedPane getIsiKaybiTabbedPane()
    {
        if(isiKaybiTabbedPane == null)
        {
            isiKaybiTabbedPane = new JTabbedPane();
            isiKaybiTabbedPane.addTab("Genel Katsayýlar", null, getJPanel8(), null);
            isiKaybiTabbedPane.addTab("TesisatBilgileri", null, getJPanel13(), null);
            isiKaybiTabbedPane.addTab("Bina Modeli", null, getJPanel15(), null);
            isiKaybiTabbedPane.addTab("Kritik Hat", null, getJPanel17(), null);
            isiKaybiTabbedPane.addTab("Isý Yalýtýmý", null, getJPanel19(), null);
            isiKaybiTabbedPane.addTab("Isýtýcý ve Aksesuarlarý", null, getJPanel23(), null);
        }
        return isiKaybiTabbedPane;
    }

    private JPanel getJPanel5()
    {
        if(jPanel5 == null)
        {
            jPanel5 = new JPanel();
            jPanel5.setLayout(new BorderLayout());
            jPanel5.add(getJSplitPane(), "Center");
        }
        return jPanel5;
    }

    private JPanel getKritikHatPanel()
    {
        if(kritikHatPanel == null)
            kritikHatPanel = new KritikHatPanel();
            kritikHatPanel.setPreferredSize(new java.awt.Dimension(453,440));
        return kritikHatPanel;
    }

    private JPanel getJPanel7()
    {
        if(jPanel7 == null)
            jPanel7 = new JPanel(new BorderLayout());
            jPanel7.add(getIsiYalitimiPanel(),BorderLayout.CENTER);                        
        return jPanel7;
    }

    public IsiYalitimiPanel getIsiYalitimiPanel(){
    	if(isiYalitimiPanel == null) isiYalitimiPanel = new IsiYalitimiPanel();
    	return isiYalitimiPanel;
    }
    
    private JSplitPane getJSplitPane()
    {
        if(jSplitPane == null)
        {
            jSplitPane = new JSplitPane();
            jSplitPane.setLeftComponent(getDdTreePanel());
            jSplitPane.setRightComponent(getDdTreeCardLayoutPanel());
            jSplitPane.setDividerLocation(270);
        }
        return jSplitPane;
    }

    private JPanel getDdTreePanel()
    {
        if(ddTreePanel == null)
        {
            ddTreePanel = new DDTree(getDdTreeCardLayoutPanel());
        }
        return ddTreePanel;
    }

    private JPanel getDdTreeCardLayoutPanel()
    {
        if(ddTreeCardLayoutPanel == null){
            ddTreeCardLayoutPanel = new JPanel();
            ddTreeCardLayoutPanel.setLayout(new java.awt.CardLayout());
            ddTreeCardLayoutPanel.add(new JPanel(),"Bina");
            ddTreeCardLayoutPanel.add(new KatTreeItemPanel(),"Kat");
            ddTreeCardLayoutPanel.add(new MahalTreeItemPanel(),"Mahal");
            ddTreeCardLayoutPanel.add(new DuvarTreeItemPanel(),"Duvar/Döþeme/Tavan");
            ddTreeCardLayoutPanel.add(new KolonTreeItemPanel(),"Kolon");
            ddTreeCardLayoutPanel.add(new KirisTreeItemPanel(),"Kiriþ");
            ddTreeCardLayoutPanel.add(new PencereTreeItemPanel(),"Pencere");
            ddTreeCardLayoutPanel.add(new KapiTreeItemPanel(),"Kapý");
        }
        return ddTreeCardLayoutPanel;
    }

    private JScrollPane getIllerScrollPane()
    {
        if(illerScrollPane == null)
        {
            illerScrollPane = new JScrollPane();
            illerScrollPane.setViewportView(getIllerList());
            illerScrollPane.setBounds(53, 65, 171, 119);
        }
        return illerScrollPane;
    }

    private JList getIllerList()
    {
        if(illerList == null)
        {
            illerList = new JList();
        }
        return illerList;
    }

    private JLabel getIllerLabel()
    {
        if(illerLabel == null)
        {
            illerLabel = new JLabel();
            illerLabel.setBounds(53, 33, 171, 24);
            illerLabel.setText("Hesabýn yapýlacaðý ili seçiniz:");
        }
        return illerLabel;
    }

    private JLabel getSecilenIlLabel()
    {
        if(secilenIlLabel == null)
        {
            secilenIlLabel = new JLabel();
            secilenIlLabel.setBounds(332, 33, 319, 24);
            secilenIlLabel.setText("");
        }
        return secilenIlLabel;
    }

    private JLabel getSecilenLabel()
    {
        if(secilenLabel == null)
        {
            secilenLabel = new JLabel();
            secilenLabel.setBounds(275, 33, 45, 24);
            secilenLabel.setText("Seçilen:");
        }
        return secilenLabel;
    }

    private JRadioButton getKonutRadioButton()
    {
        if(konutRadioButton == null)
        {
            konutRadioButton = new JRadioButton();
            konutRadioButton.setText("Konutlar, okullar normal donan\u0131ml\u0131 binalar");            
        }
        return konutRadioButton;
    }

    private JRadioButton getEnerjiRadioButton()
    {
        if(enerjiRadioButton == null)
        {
            enerjiRadioButton = new JRadioButton();
            enerjiRadioButton.setText("Enerji kullan\u0131m\u0131 y\374ksek binalar");
        }
        return enerjiRadioButton;
    }

    private JPanel getBinaTipiPanel()
    {
        if(binaTipiPanel == null)
        {
            binaTipiPanel = new JPanel();
            ButtonGroup buttonGroup = new ButtonGroup();
            buttonGroup.add(getKonutRadioButton());
            buttonGroup.add(getEnerjiRadioButton());
            binaTipiPanel.add(getKonutRadioButton(), null);
            binaTipiPanel.add(getEnerjiRadioButton(), null);
            binaTipiPanel.setBounds(63, 38, 491, 68);
            binaTipiPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder(null, "", 0, 0, null, null), "Bina Tipi", 0, 0, new Font("Dialog", 1, 12), Color.black));
            binaTipiPanel.setToolTipText("<HTML>	<P>Aylýk ortalama iç kazançlar " +
					"(\u03A6<sub>i,ay</sub>) olup, konutlar ve " +
					"bürolar gibi normal donanýmlý <BR> binalarda birim " +
					"döþeme alaný baþýna en fazla 5 W/m<SUP>2</SUP> " +
					"alýnýrken; etrafa çok miktarda <BR> ýsýnýn verildiði " +
					"binalarda (içinde sanayi cihazlarý, piþirme iþlemleri olan) " +
					" birim <BR>döþeme alaný baþýna en fazla 10 W/m<SUP>2</SUP>" +
					" deðeri alýnýr. </HTML>");
        }
        return binaTipiPanel;
    }

    private JPanel getNetOdaYuksekligiPanel()
    {
        if(netOdaYuksekligiPanel == null)
        {
            netOdaYuksekligiPanel = new JPanel();
            ButtonGroup buttonGroup = new ButtonGroup();
            buttonGroup.add(getEsit26RadioButton());
            buttonGroup.add(getYuksek26RadioButton());
            netOdaYuksekligiPanel.add(getEsit26RadioButton(), null);
            netOdaYuksekligiPanel.add(getYuksek26RadioButton(), null);
            netOdaYuksekligiPanel.setBounds(63, 144, 157, 68);
            netOdaYuksekligiPanel.setBorder(BorderFactory.createTitledBorder(null, "Net oda y\374ksekli\u011Fi", 0, 0, null, null));
            netOdaYuksekligiPanel.setToolTipText("<HTML><P>	Net oda yüksekliðine baðlý olarak " +
            									"TS825'de bina kullaným alaný<BR>veya bina brüt " +
            									"hacmi ile iliþkilendirilmiþ yýllýk ýsýtma ihtiyacýný " +
            									"<BR>sýnýrlayan formüller getirilmiþtir. Net oda" +
            									" yüksekliðinin 2.60 <BR>metre'den küçük olmasý" +
            									" durumunda A<SUB>n</SUB> li formül, büyük <BR>	" +
            									"olmasý durumunda V<SUB>brüt</SUB>' lü formül " +
            									"kullanýlýr.</P></HTML>");
        }
        return netOdaYuksekligiPanel;
    }

    private JRadioButton getYuksek26RadioButton()
    {
        if(yuksek26RadioButton == null)
        {
            yuksek26RadioButton = new JRadioButton();
            yuksek26RadioButton.setText("> 2.6 m");
        }
        return yuksek26RadioButton;
    }

    private JRadioButton getEsit26RadioButton()
    {
        if(esit26RadioButton == null)
        {
            esit26RadioButton = new JRadioButton();
            esit26RadioButton.setText("= 2.6 m");
        }
        return esit26RadioButton;
    }

    private JPanel getHavalandirmaPanel()
    {
        if(havalandirmaPanel == null)
        {
            havalandirmaPanel = new JPanel();
            havalandirmaPanel.setLayout(null);
            ButtonGroup buttonGroup = new ButtonGroup();
            buttonGroup.add(getMekanikRadioButton());
            buttonGroup.add(getDogalRadioButton());
            havalandirmaPanel.add(getMekanikRadioButton(), null);
            havalandirmaPanel.add(getDogalRadioButton(), null);
            havalandirmaPanel.setBounds(316, 144, 238, 92);
            havalandirmaPanel.setBorder(BorderFactory.createTitledBorder(null, "Havalandýrma Tipi", 0, 0, null, null));
            havalandirmaPanel.add(getHavalandirmaSecButton(), null);
        }
        return havalandirmaPanel;
    }

    private JRadioButton getDogalRadioButton()
    {
        if(dogalRadioButton == null)
        {
            dogalRadioButton = new JRadioButton();
            dogalRadioButton.setBounds(7, 52, 137, 24);
            dogalRadioButton.setText("Doðal havalandýrma");
        }
        return dogalRadioButton;
    }

    private JRadioButton getMekanikRadioButton()
    {
        if(mekanikRadioButton == null)
        {
            mekanikRadioButton = new JRadioButton();
            mekanikRadioButton.setBounds(7, 20, 153, 24);
            mekanikRadioButton.setText("Mekanik havaland\u0131rma");
        }
        return mekanikRadioButton;
    }

    private JPanel getYerlesimBolgesiPanel()
    {
        if(yerlesimBolgesiPanel == null)
        {
            yerlesimBolgesiPanel = new JPanel();
            yerlesimBolgesiPanel.setLayout(null);
            ButtonGroup buttonGroup = new ButtonGroup();
            buttonGroup.add(getAyrikRadioButton());
            buttonGroup.add(getMahfuzRadioButton());
            buttonGroup.add(getBitisikRadioButton());
            yerlesimBolgesiPanel.add(getAyrikRadioButton(), null);
            yerlesimBolgesiPanel.add(getMahfuzRadioButton(), null);
            yerlesimBolgesiPanel.add(getBitisikRadioButton(), null);
            yerlesimBolgesiPanel.setBounds(63, 274, 528, 127);
            yerlesimBolgesiPanel.setBorder(BorderFactory.createTitledBorder(null, "Binan\u0131n Bulundu\u011Fu Yerle\u015Fim B\366lgesinin \326zelli\u011Fi", 0, 0, null, null));
            yerlesimBolgesiPanel.setToolTipText("<HTML><P> Hesaplanmýþ deðerler yoksa, saydam " +
            									"yüzeylerin aylýk ortalama gölgelenme<BR>faktörü " +
            									"r<SUB>i,ay</SUB> 'ýn ýsýtma periyodu boyunca sabit " +
            									"kaldýðý kabul edilir ve<BR> aþaðýdaki sýraya göre " +
            									"0.6, 0.5 ve 0.8 deðerlerinden birini alýr.</P></HTML>");
        }
        return yerlesimBolgesiPanel;
    }

    private JRadioButton getAyrikRadioButton()
    {
        if(ayrikRadioButton == null)
        {
            ayrikRadioButton = new JRadioButton();
            ayrikRadioButton.setBounds(47, 89, 388, 24);
            ayrikRadioButton.setText("Etrafýnda, Ayrýk ve az katlý binalarýn bulunduðu yerleþim bölgeleri");
            ayrikRadioButton.setToolTipText("3 kata kadar");
        }
        return ayrikRadioButton;
    }

    private JRadioButton getMahfuzRadioButton()
    {
        if(mahfuzRadioButton == null)
        {
            mahfuzRadioButton = new JRadioButton();
            mahfuzRadioButton.setBounds(47, 25, 405, 21);
            mahfuzRadioButton.setText("Etrafýnda, Aðaçlardan kaynaklanan gölgelenmeye maruz kalýyorsa");
        }
        return mahfuzRadioButton;
    }

    private JRadioButton getBitisikRadioButton()
    {
        if(bitisikRadioButton == null)
        {
            bitisikRadioButton = new JRadioButton();
            bitisikRadioButton.setBounds(47, 57, 388, 21);
            bitisikRadioButton.setText("Etrafýnda, Bitiþik nizam veya çok katlý binalar bulunuyorsa");
        }
        return bitisikRadioButton;
    }

    private JLabel getHaritaLabel()
    {
        if(haritaLabel == null)
        {
            haritaLabel = new JLabel();
            haritaLabel.setBounds(53, 199, 504, 209);
            haritaLabel.setText("");
            haritaLabel.setIcon(new javax.swing.ImageIcon(
								getClass().getResource(
									"/com/iztek/dd/GUI/images/Turkiye_sized.gif")));
        }
        return haritaLabel;
    }

    public void setJLabel1(String text)
    {
        secilenIlLabel = getSecilenIlLabel();
        secilenIlLabel.setText(text);
    }

    public void setMahfuzRadioButton(JRadioButton button)
    {
        mahfuzRadioButton = button;
    }

    private JTabbedPane getTs825TabbedPane()
    {
        if(ts825TabbedPane == null)
        {
            ts825TabbedPane = new JTabbedPane();
            ts825TabbedPane.addTab("Bina ve Konum Bilgileri", null, getBinaKonumBilgilerijPanel(), null);
            ts825TabbedPane.addTab("Özgül  Isý Kaybý Çizelgesi", null, getOzgulIsiKaybiPanel1(), null);
            ts825TabbedPane.addTab("Yýllýk Isýtma Ýhtiyacý Çizelgesi", null, getJPanel10(), null);
        }
        return ts825TabbedPane;
    }

    private JPanel getBinaKonumBilgileriPanel()
    {
        if(binaKonumBilgileriPanel == null)
        {
            binaKonumBilgileriPanel = new JPanel();
            binaKonumBilgileriPanel.setLayout(null);
            binaKonumBilgileriPanel.add(getBinaTipiPanel(), null);
            binaKonumBilgileriPanel.add(getYerlesimBolgesiPanel(), null);
            binaKonumBilgileriPanel.add(getNetOdaYuksekligiPanel(), null);
            binaKonumBilgileriPanel.add(getHavalandirmaPanel(), null);
            binaKonumBilgileriPanel.setName("");
        }
        return binaKonumBilgileriPanel;
    }

    private JPanel getOzgulIsiKaybiPanel()
    {
        if(ozgulIsiKaybiPanel == null)
        {
            ozgulIsiKaybiPanel = new JPanel();
            ozgulIsiKaybiPanel.setLayout(new BorderLayout());
            ozgulIsiKaybiPanel.add(getOzgulIsiKaybiSplitPane(), "Center");
        }
        return ozgulIsiKaybiPanel;
    }

    private JPanel getYillikIsitmaIhtiyaciPanel()
    {
        if(yillikIsitmaIhtiyaciPanel == null)
        {
            yillikIsitmaIhtiyaciPanel = new JPanel();
            yillikIsitmaIhtiyaciPanel.setLayout(new BorderLayout());
            yillikIsitmaIhtiyaciPanel.add(getJSplitPane2(), "Center");
        }
        return yillikIsitmaIhtiyaciPanel;
    }

    private JTabbedPane getTanimlarTabbedPane()
    {
        if(tanimlarTabbedPane == null)
        {
            tanimlarTabbedPane = new JTabbedPane();
            tanimlarTabbedPane.addTab("Proje Bilgileri", null, getJPanel2(), null);
            tanimlarTabbedPane.addTab("Ýl & Bölge Tanýmlarý", null, getJPanel4(), null);
        }
        return tanimlarTabbedPane;
    }

    private JPanel getBolgePanel()
    {
        if(bolgePanel == null)
        {
            bolgePanel = new JPanel();
            bolgePanel.setLayout(null);
            bolgePanel.add(getIllerScrollPane(), null);
            bolgePanel.add(getIllerLabel(), null);
            bolgePanel.add(getSecilenIlLabel(), null);
            bolgePanel.add(getSecilenLabel(), null);
            bolgePanel.add(getHaritaLabel(), null);
        }
        return bolgePanel;
    }

    private JPanel getProjePanel()
    {
        if(projePanel == null)
        {
            projePanel = new JPanel();
            projePanel.setLayout(null);
            projePanel.add(getProjeAdiTextField(), null);
            projePanel.add(getProjeAdiLabel(), null);
            projePanel.add(getMuhendisPanel(), null);
            projePanel.add(getBinaPanel(), null);
        }
        return projePanel;
    }

    private JTextField getProjeAdiTextField()
    {
        if(projeAdiTextField == null)
        {
            projeAdiTextField = new JTextField();
            projeAdiTextField.setBounds(285, 27, 187, 24);
            projeAdiTextField.addFocusListener(new java.awt.event.FocusAdapter() { 
            	public void focusLost(java.awt.event.FocusEvent e) {    
            		propertySupport.firePropertyChange("title",new String(""),new String(projeAdiTextField.getText()));            				
            	}
            });
        }
        return projeAdiTextField;
    }

    private JLabel getProjeAdiLabel()
    {
        if(projeAdiLabel == null)
        {
            projeAdiLabel = new JLabel();
            projeAdiLabel.setText("Proje Ad\u0131:");
            projeAdiLabel.setBounds(103, 27, 68, 24);
        }
        return projeAdiLabel;
    }

    private JTextField getMuhendisAdTextField()
    {
        if(muhendisAdTextField == null)
        {
            muhendisAdTextField = new JTextField();
            muhendisAdTextField.setBounds(216, 23, 187, 24);
        }
        return muhendisAdTextField;
    }

    private JLabel getMuhendisAdLabel()
    {
        if(muhendisAdLabel == null)
        {
            muhendisAdLabel = new JLabel();
            muhendisAdLabel.setBounds(34, 23, 68, 24);
            muhendisAdLabel.setText("Ad\u0131 Soyad\u0131:");
        }
        return muhendisAdLabel;
    }

    private JPanel getMuhendisPanel()
    {
        if(muhendisPanel == null)
        {
            muhendisPanel = new JPanel();
            muhendisPanel.setLayout(null);
            muhendisPanel.add(getMuhendisAdLabel(), null);
            muhendisPanel.add(getMuhendisAdTextField(), null);
            muhendisPanel.add(getMuhendisUnvanLabel(), null);
            muhendisPanel.add(getMuhendisSicilLabel(), null);
            muhendisPanel.add(getMuhendisUnvanTextField(), null);
            muhendisPanel.add(getMuhendisSicilTextField(), null);
            muhendisPanel.setBorder(BorderFactory.createTitledBorder(null, "Projeyi Yapan\u0131n", 0, 0, null, null));
            muhendisPanel.setBounds(69, 71, 455, 135);
        }
        return muhendisPanel;
    }

    private JLabel getMuhendisUnvanLabel()
    {
        if(muhendisUnvanLabel == null)
        {
            muhendisUnvanLabel = new JLabel();
            muhendisUnvanLabel.setBounds(34, 62, 68, 24);
            muhendisUnvanLabel.setText("\334nvan\u0131:");
        }
        return muhendisUnvanLabel;
    }

    private JLabel getMuhendisSicilLabel()
    {
        if(muhendisSicilLabel == null)
        {
            muhendisSicilLabel = new JLabel();
            muhendisSicilLabel.setBounds(34, 101, 68, 24);
            muhendisSicilLabel.setText("Sicil No:");
        }
        return muhendisSicilLabel;
    }

    private JTextField getMuhendisUnvanTextField()
    {
        if(muhendisUnvanTextField == null)
        {
            muhendisUnvanTextField = new JTextField();
            muhendisUnvanTextField.setBounds(216, 62, 187, 24);
        }
        return muhendisUnvanTextField;
    }

    private JTextField getMuhendisSicilTextField()
    {
        if(muhendisSicilTextField == null)
        {
            muhendisSicilTextField = new JTextField();
            muhendisSicilTextField.setBounds(216, 101, 187, 24);
        }
        return muhendisSicilTextField;
    }

    private JPanel getBinaPanel()
    {
        if(binaPanel == null)
        {
            binaPanel = new JPanel();
            binaPanel.setLayout(null);
            binaPanel.add(getBinaTanimLabel(), null);
            binaPanel.add(getAdaParselLabel(), null);
            binaPanel.add(getCaddeLabel(), null);
            binaPanel.add(getIlIlceLabel(), null);
            binaPanel.add(getYakitLabel(), null);
            binaPanel.add(getAdaParselTextField(), null);
            binaPanel.add(getBinaTanimTextField(), null);
            binaPanel.add(getCaddeTextField(), null);
            binaPanel.add(getIlIlceTextField(), null);
            binaPanel.add(getYakitTextField(), null);
            binaPanel.setBorder(BorderFactory.createTitledBorder(null, "Bina Bilgileri", 0, 0, null, null));
            binaPanel.setBounds(69, 226, 455, 200);
        }
        return binaPanel;
    }

    private JLabel getAdaParselLabel()
    {
        if(adaParselLabel == null)
        {
            adaParselLabel = new JLabel();
            adaParselLabel.setBounds(31, 21, 143, 24);
            adaParselLabel.setText("Ada/Parsel:");
        }
        return adaParselLabel;
    }

    private JLabel getBinaTanimLabel()
    {
        if(binaTanimLabel == null)
        {
            binaTanimLabel = new JLabel();
            binaTanimLabel.setBounds(31, 56, 143, 24);
            binaTanimLabel.setText("Binan\u0131n tan\u0131m\u0131:");
        }
        return binaTanimLabel;
    }

    private JLabel getCaddeLabel()
    {
        if(caddeLabel == null)
        {
            caddeLabel = new JLabel();
            caddeLabel.setBounds(31, 91, 143, 24);
            caddeLabel.setText("Cadde ve bina numaras\u0131:");
        }
        return caddeLabel;
    }

    private JLabel getIlIlceLabel()
    {
        if(ilIlceLabel == null)
        {
            ilIlceLabel = new JLabel();
            ilIlceLabel.setBounds(31, 126, 143, 24);
            ilIlceLabel.setText("Semt/\u0130l\347e/\u0130l:");
        }
        return ilIlceLabel;
    }

    private JLabel getYakitLabel()
    {
        if(yakitLabel == null)
        {
            yakitLabel = new JLabel();
            yakitLabel.setBounds(31, 161, 143, 24);
            yakitLabel.setText("Kullan\u0131lacak yak\u0131t t\374r\374:");
        }
        return yakitLabel;
    }

    private JTextField getAdaParselTextField()
    {
        if(adaParselTextField == null)
        {
            adaParselTextField = new JTextField();
            adaParselTextField.setBounds(216, 21, 187, 24);
        }
        return adaParselTextField;
    }

    private JTextField getBinaTanimTextField()
    {
        if(binaTanimTextField == null)
        {
            binaTanimTextField = new JTextField();
            binaTanimTextField.setBounds(216, 56, 187, 24);
        }
        return binaTanimTextField;
    }

    private JTextField getCaddeTextField()
    {
        if(caddeTextField == null)
        {
            caddeTextField = new JTextField();
            caddeTextField.setBounds(216, 91, 187, 24);
        }
        return caddeTextField;
    }

    private JTextField getIlIlceTextField()
    {
        if(ilIlceTextField == null)
        {
            ilIlceTextField = new JTextField();
            ilIlceTextField.setBounds(216, 126, 187, 24);
        }
        return ilIlceTextField;
    }

    private JTextField getYakitTextField()
    {
        if(yakitTextField == null)
        {
            yakitTextField = new JTextField();
            yakitTextField.setBounds(216, 161, 187, 24);
        }
        return yakitTextField;
    }

    private JSplitPane getOzgulIsiKaybiSplitPane()
    {
        if(ozgulIsiKaybiSplitPane == null)
        {
            ozgulIsiKaybiSplitPane = new JSplitPane();
            ozgulIsiKaybiSplitPane.setLeftComponent(getJPanel21());
            ozgulIsiKaybiSplitPane.setRightComponent(getJPanel22());
            ozgulIsiKaybiSplitPane.setDividerLocation(230);
            ozgulIsiKaybiSplitPane.setDividerSize(10);
            ozgulIsiKaybiSplitPane.setOneTouchExpandable(true);
        }
        return ozgulIsiKaybiSplitPane;
    }

    private JPanel getJPanel21()
    {
        if(jPanel21 == null)
        {
            jPanel21 = new JPanel();
            jPanel21.setLayout(new BorderLayout());
            jPanel21.add(getYapiElemanTipleriTree(), "Center");
        }
        return jPanel21;
    }

    private JPanel getJPanel22()
    {
        if(jPanel22 == null)
        {
            jPanel22 = new JPanel(new CardLayout());
            jPanel22.add(getDisDuvarPanel(), getDisDuvarPanel().getName());
            jPanel22.add(getIsitilmayanDuvarPanel(), getIsitilmayanDuvarPanel().getName());
            jPanel22.add(getTopragaTemasliDuvarPanel(), getTopragaTemasliDuvarPanel().getName());
            jPanel22.add(getUzeriAcikTavanPanel(), getUzeriAcikTavanPanel().getName());
            jPanel22.add(getCatiliTavanPanel(), getCatiliTavanPanel().getName());
            jPanel22.add(getTopragaTemasliTabanPanel(), getTopragaTemasliTabanPanel().getName());
            jPanel22.add(getIsitilmayanTabanPanel(), getIsitilmayanTabanPanel().getName());
            jPanel22.add(getAcikGecitUzeriTabanPanel(), getAcikGecitUzeriTabanPanel().getName());
            jPanel22.add(getPencerePanel(), getPencerePanel().getName());
        }
        return jPanel22;
    }

    private JTree getYapiElemanTipleriTree()
    {
        if(yapiElemanTipleriTree == null)
        {
            DefaultMutableTreeNode root = processHierarchy(menuStructure);
            yapiElemanTipleriTree = new JTree(root);
            yapiElemanTipleriTree.addTreeSelectionListener(new TreeSelectionListener() {

                public void valueChanged(TreeSelectionEvent e)
                {
                    CardLayout cl = (CardLayout)jPanel22.getLayout();
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode)yapiElemanTipleriTree.getLastSelectedPathComponent();
                    if(node == null)
                    {
                        return;
                    } else
                    {
                        PanelInfo nodeInfo = (PanelInfo)node.getUserObject();
                        String panelName = nodeInfo.getPanelName();
                        cl.show(jPanel22, panelName);
                        return;
                    }
                }

            });
        }
        return yapiElemanTipleriTree;
    }

    private DefaultMutableTreeNode processHierarchy(Object hierarchy[])
    {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(hierarchy[0]);
        for(int i = 1; i < hierarchy.length; i++)
        {
            Object nodeSpecifier = hierarchy[i];
            DefaultMutableTreeNode child;
            if(nodeSpecifier instanceof Object[])
                child = processHierarchy((Object[])nodeSpecifier);
            else
                child = new DefaultMutableTreeNode(nodeSpecifier);
            node.add(child);
        }

        return node;
    }

    private JPanel getDisDuvarPanel()
    {
        if(disDuvarPanel == null)
        {
            birimLabel1 = new JLabel();
            birimLabel = new JLabel();
            disDuvarULabel = new JLabel();
            disDuvarAlanLabel = new JLabel();
            disDuvarPanel = new JPanel();
            disDuvarPanel.setLayout(null);
            disDuvarPanel.setName("disDuvarPanel");
            disDuvarAlanLabel.setText("Alan");
            disDuvarAlanLabel.setLocation(103, 339);
            disDuvarAlanLabel.setSize(60, 24);
            disDuvarULabel.setText("U deðeri");
            disDuvarULabel.setLocation(103, 385);
            disDuvarULabel.setSize(60, 24);
            birimLabel.setBounds(318, 339, 48, 24);
            birimLabel.setText("<HTML>m<SUP>2</SUP></HTML>");
            birimLabel1.setBounds(318, 385, 48, 24);
            birimLabel1.setText("<HTML>W/m<SUP>2</SUP></HTML>");
            disDuvarPanel.add(getDisDuvarModelScrollPane(), null);
            disDuvarPanel.add(getDisDuvarlarScrollPane(), null);
            disDuvarPanel.add(getDisDuvarEkleButton(), null);
            disDuvarPanel.add(getDisDuvarCikarButton(), null);
            disDuvarPanel.add(disDuvarAlanLabel, null);
            disDuvarPanel.add(getDisDuvarAlanTextField(), null);
            disDuvarPanel.add(disDuvarULabel, null);
            disDuvarPanel.add(getDisDuvarUTextField(), null);
            disDuvarPanel.add(birimLabel, null);
            disDuvarPanel.add(birimLabel1, null);
            disDuvarPanel.add(getDisDuvarBilesenEkleButton(), null);
            disDuvarPanel.add(getDisDuvarBilesenCikarButton(), null);
            disDuvarPanel.add(getYogusmaButton(), null);
        }
        return disDuvarPanel;
    }

    private JPanel getIsitilmayanDuvarPanel()
    {
        if(isitilmayanDuvarPanel == null)
        {
            birimLabel11 = new JLabel();
            birimLabel10 = new JLabel();
            isitilmayanDuvarULabel = new JLabel();
            isitilmayanDuvarAlanLabel = new JLabel();
            isitilmayanDuvarPanel = new JPanel();
            isitilmayanDuvarPanel.setLayout(null);
            isitilmayanDuvarPanel.setName("isitilmayanDuvarPanel");
            isitilmayanDuvarAlanLabel.setText("Alan");
            isitilmayanDuvarAlanLabel.setLocation(103, 243);
            isitilmayanDuvarAlanLabel.setSize(60, 24);
            isitilmayanDuvarULabel.setText("u deðeri");
            isitilmayanDuvarULabel.setSize(60, 24);
            isitilmayanDuvarULabel.setLocation(103, 289);
            birimLabel10.setText("<HTML>m<SUP>2</SUP></HTML>");
            birimLabel10.setLocation(318, 243);
            birimLabel10.setSize(48, 24);
            birimLabel11.setText("<HTML>W/m<SUP>2</SUP></HTML>");
            birimLabel11.setLocation(318, 289);
            birimLabel11.setSize(48, 24);
            isitilmayanDuvarPanel.add(getIsitilmayanDuvarModelScrollPane(), null);
            isitilmayanDuvarPanel.add(getIsitilmayanDuvarBilesenEkleButton(), null);
            isitilmayanDuvarPanel.add(getIsitilmayanDuvarBilesenCikarButton(), null);
            isitilmayanDuvarPanel.add(isitilmayanDuvarAlanLabel, null);
            isitilmayanDuvarPanel.add(getIsitilmayanDuvarAlanTextField(), null);
            isitilmayanDuvarPanel.add(isitilmayanDuvarULabel, null);
            isitilmayanDuvarPanel.add(getIsitilmayanDuvarUTextField(), null);
            isitilmayanDuvarPanel.add(birimLabel10, null);
            isitilmayanDuvarPanel.add(birimLabel11, null);
        }
        return isitilmayanDuvarPanel;
    }

    private JPanel getTopragaTemasliDuvarPanel()
    {
        if(topragaTemasliDuvarPanel == null)
        {
            birimLabel13 = new JLabel();
            birimLabel12 = new JLabel();
            topragaTemasliDuvarULabel = new JLabel();
            topragaTemasliDuvarAlanLabel = new JLabel();
            topragaTemasliDuvarPanel = new JPanel();
            topragaTemasliDuvarPanel.setLayout(null);
            topragaTemasliDuvarPanel.setName("topragaTemasliDuvarPanel");
            topragaTemasliDuvarAlanLabel.setText("Alan");
            topragaTemasliDuvarAlanLabel.setLocation(103, 243);
            topragaTemasliDuvarAlanLabel.setSize(60, 24);
            topragaTemasliDuvarULabel.setText("u deðeri");
            topragaTemasliDuvarULabel.setSize(60, 24);
            topragaTemasliDuvarULabel.setLocation(103, 289);
            birimLabel12.setText("<HTML>m<SUP>2</SUP></HTML>");
            birimLabel12.setLocation(318, 243);
            birimLabel12.setSize(48, 24);
            birimLabel13.setText("<HTML>W/m<SUP>2</SUP></HTML>");
            birimLabel13.setLocation(318, 289);
            birimLabel13.setSize(48, 24);
            topragaTemasliDuvarPanel.add(getTopragaTemasliDuvarScrollPane(), null);
            topragaTemasliDuvarPanel.add(topragaTemasliDuvarAlanLabel, null);
            topragaTemasliDuvarPanel.add(topragaTemasliDuvarULabel, null);
            topragaTemasliDuvarPanel.add(getTopragaTemasliDuvarBilesenEkleButton(), null);
            topragaTemasliDuvarPanel.add(getTopragaTemasliDuvarBilesenCikarButton(), null);
            topragaTemasliDuvarPanel.add(getTopragaTemasliDuvarAlanTextField(), null);
            topragaTemasliDuvarPanel.add(getTopragaTemasliDuvarUTextField(), null);
            topragaTemasliDuvarPanel.add(birimLabel12, null);
            topragaTemasliDuvarPanel.add(birimLabel13, null);
        }
        return topragaTemasliDuvarPanel;
    }

    private JPanel getUzeriAcikTavanPanel()
    {
        if(uzeriAcikTavanPanel == null)
        {
            birimLabel15 = new JLabel();
            birimLabel14 = new JLabel();
            uzeriAcikTavanULabel = new JLabel();
            uzeriAcikTavanAlanLabel = new JLabel();
            uzeriAcikTavanPanel = new JPanel();
            uzeriAcikTavanPanel.setLayout(null);
            uzeriAcikTavanPanel.setName("uzeriAcikTavanPanel");
            uzeriAcikTavanAlanLabel.setText("Alan");
            uzeriAcikTavanAlanLabel.setLocation(103, 243);
            uzeriAcikTavanAlanLabel.setSize(60, 24);
            uzeriAcikTavanULabel.setText("u deðeri");
            uzeriAcikTavanULabel.setLocation(103, 289);
            uzeriAcikTavanULabel.setSize(60, 24);
            birimLabel14.setText("<HTML>m<SUP>2</SUP></HTML>");
            birimLabel14.setLocation(318, 243);
            birimLabel14.setSize(48, 24);
            birimLabel14.setName("");
            birimLabel15.setText("<HTML>W/m<SUP>2</SUP></HTML>");
            birimLabel15.setLocation(318, 289);
            birimLabel15.setSize(48, 24);
            birimLabel15.setName("");
            uzeriAcikTavanPanel.add(getUzeriAcikTavanScrollPane(), null);
            uzeriAcikTavanPanel.add(getUzeriAcikTavanBilesenEkleButton(), null);
            uzeriAcikTavanPanel.add(getUzeriAcikTavanBilesenCikarButton(), null);
            uzeriAcikTavanPanel.add(uzeriAcikTavanAlanLabel, null);
            uzeriAcikTavanPanel.add(uzeriAcikTavanULabel, null);
            uzeriAcikTavanPanel.add(getUzeriAcikTavanAlanTextField(), null);
            uzeriAcikTavanPanel.add(getUzeriAcikTavanUTextField(), null);
            uzeriAcikTavanPanel.add(birimLabel14, null);
            uzeriAcikTavanPanel.add(birimLabel15, null);
            uzeriAcikTavanPanel.add(getUzeriAcikTavanYogusmaButton(), null);
        }
        return uzeriAcikTavanPanel;
    }

    private JPanel getCatiliTavanPanel()
    {
        if(catiliTavanPanel == null)
        {
            birimLabel17 = new JLabel();
            birimLabel16 = new JLabel();
            catiliTavanULabel = new JLabel();
            catiliTavanAlanLabel = new JLabel();
            catiliTavanPanel = new JPanel();
            catiliTavanPanel.setLayout(null);
            catiliTavanPanel.setName("catiliTavanPanel");
            catiliTavanAlanLabel.setText("Alan");
            catiliTavanAlanLabel.setLocation(103, 243);
            catiliTavanAlanLabel.setSize(60, 24);
            catiliTavanULabel.setText("u deðeri");
            catiliTavanULabel.setLocation(103, 289);
            catiliTavanULabel.setSize(60, 24);
            birimLabel16.setText("<HTML>m<SUP>2</SUP></HTML>");
            birimLabel16.setLocation(318, 243);
            birimLabel16.setSize(48, 24);
            birimLabel16.setName("");
            birimLabel17.setText("<HTML>W/m<SUP>2</SUP></HTML>");
            birimLabel17.setLocation(318, 289);
            birimLabel17.setSize(48, 24);
            birimLabel17.setName("");
            catiliTavanPanel.add(getCatiliTavanScrollPane(), null);
            catiliTavanPanel.add(getCatiliTavanBilesenEkleButton(), null);
            catiliTavanPanel.add(getCatiliTavanBilesenCikarButton(), null);
            catiliTavanPanel.add(catiliTavanAlanLabel, null);
            catiliTavanPanel.add(catiliTavanULabel, null);
            catiliTavanPanel.add(getCatiliTavanAlanTextField(), null);
            catiliTavanPanel.add(getCatiliTavanUTextField(), null);
            catiliTavanPanel.add(birimLabel16, null);
            catiliTavanPanel.add(birimLabel17, null);
            catiliTavanPanel.add(getCatiliTavanYogusmaButton(), null);
        }
        return catiliTavanPanel;
    }

    private JPanel getTopragaTemasliTabanPanel()
    {
        if(topragaTemasliTabanPanel == null)
        {
            birimLabel19 = new JLabel();
            birimLabel18 = new JLabel();
            topragaTemasliTabanULabel = new JLabel();
            topragaTemasliTabanAlanLabel = new JLabel();
            topragaTemasliTabanPanel = new JPanel();
            topragaTemasliTabanPanel.setLayout(null);
            topragaTemasliTabanPanel.setName("topragaTemasliTabanPanel");
            topragaTemasliTabanAlanLabel.setText("Alan");
            topragaTemasliTabanAlanLabel.setLocation(103, 243);
            topragaTemasliTabanAlanLabel.setSize(60, 24);
            topragaTemasliTabanULabel.setText("u deðeri");
            topragaTemasliTabanULabel.setLocation(103, 289);
            topragaTemasliTabanULabel.setSize(60, 24);
            birimLabel18.setText("<HTML>m<SUP>2</SUP></HTML>");
            birimLabel18.setLocation(318, 243);
            birimLabel18.setSize(48, 24);
            birimLabel18.setName("");
            birimLabel19.setText("<HTML>W/m<SUP>2</SUP></HTML>");
            birimLabel19.setLocation(318, 289);
            birimLabel19.setSize(48, 24);
            birimLabel19.setName("");
            topragaTemasliTabanPanel.add(getTopragaTemasliTabanScrollPane(), null);
            topragaTemasliTabanPanel.add(getTopragaTemasliTabanBilesenEkleButton(), null);
            topragaTemasliTabanPanel.add(getTopragaTemasliTabanBilesenCikarButton(), null);
            topragaTemasliTabanPanel.add(topragaTemasliTabanAlanLabel, null);
            topragaTemasliTabanPanel.add(topragaTemasliTabanULabel, null);
            topragaTemasliTabanPanel.add(getTopragaTemasliTabanAlanTextField(), null);
            topragaTemasliTabanPanel.add(getTopragaTemasliTabanUTextField(), null);
            topragaTemasliTabanPanel.add(birimLabel18, null);
            topragaTemasliTabanPanel.add(birimLabel19, null);
        }
        return topragaTemasliTabanPanel;
    }

    private JPanel getIsitilmayanTabanPanel()
    {
        if(isitilmayanTabanPanel == null)
        {
            birimLabel21 = new JLabel();
            birimLabel20 = new JLabel();
            isitilmayanTabanULabel = new JLabel();
            isitilmayanTabanAlanLabel = new JLabel();
            isitilmayanTabanPanel = new JPanel();
            isitilmayanTabanPanel.setLayout(null);
            isitilmayanTabanPanel.setName("isitilmayanTabanPanel");
            isitilmayanTabanAlanLabel.setText("Alan");
            isitilmayanTabanAlanLabel.setLocation(103, 243);
            isitilmayanTabanAlanLabel.setSize(60, 24);
            isitilmayanTabanULabel.setText("u deðeri");
            isitilmayanTabanULabel.setLocation(103, 289);
            isitilmayanTabanULabel.setSize(60, 24);
            birimLabel20.setText("<HTML>m<SUP>2</SUP></HTML>");
            birimLabel20.setLocation(318, 243);
            birimLabel20.setSize(48, 24);
            birimLabel20.setName("");
            birimLabel21.setText("<HTML>W/m<SUP>2</SUP></HTML>");
            birimLabel21.setLocation(318, 289);
            birimLabel21.setSize(48, 24);
            birimLabel21.setName("");
            isitilmayanTabanPanel.add(getIsitilmayanTabanScrollPane(), null);
            isitilmayanTabanPanel.add(getIsitilmayanTabanBilesenEkleButton(), null);
            isitilmayanTabanPanel.add(getIsitilmayanTabanBilesenCikarButton(), null);
            isitilmayanTabanPanel.add(isitilmayanTabanAlanLabel, null);
            isitilmayanTabanPanel.add(isitilmayanTabanULabel, null);
            isitilmayanTabanPanel.add(getIsitilmayanTabanAlanTextField(), null);
            isitilmayanTabanPanel.add(getIsitilmayanTabanUTextField(), null);
            isitilmayanTabanPanel.add(birimLabel20, null);
            isitilmayanTabanPanel.add(birimLabel21, null);
        }
        return isitilmayanTabanPanel;
    }

    private JPanel getAcikGecitUzeriTabanPanel()
    {
        if(acikGecitUzeriTabanPanel == null)
        {
            birimLabel23 = new JLabel();
            birimLabel22 = new JLabel();
            acikGecitUzeriULabel = new JLabel();
            acikGecitUzeriAlanLabel = new JLabel();
            acikGecitUzeriTabanPanel = new JPanel();
            acikGecitUzeriTabanPanel.setLayout(null);
            acikGecitUzeriTabanPanel.setName("acikGecitUzeriTabanPanel");
            acikGecitUzeriAlanLabel.setText("Alan");
            acikGecitUzeriAlanLabel.setLocation(103, 243);
            acikGecitUzeriAlanLabel.setSize(60, 24);
            acikGecitUzeriULabel.setText("u deðeri");
            acikGecitUzeriULabel.setLocation(103, 289);
            acikGecitUzeriULabel.setSize(60, 24);
            birimLabel22.setText("<HTML>m<SUP>2</SUP></HTML>");
            birimLabel22.setLocation(318, 243);
            birimLabel22.setSize(48, 24);
            birimLabel22.setName("");
            birimLabel23.setText("<HTML>W/m<SUP>2</SUP></HTML>");
            birimLabel23.setLocation(318, 289);
            birimLabel23.setSize(48, 24);
            birimLabel23.setName("");
            acikGecitUzeriTabanPanel.add(getAcikGecitUzeriScrollPane(), null);
            acikGecitUzeriTabanPanel.add(getAcikGecitUzeriBilesenEkleButton(), null);
            acikGecitUzeriTabanPanel.add(getAcikGecitUzeriBilesenCikarButton(), null);
            acikGecitUzeriTabanPanel.add(acikGecitUzeriAlanLabel, null);
            acikGecitUzeriTabanPanel.add(acikGecitUzeriULabel, null);
            acikGecitUzeriTabanPanel.add(getAcikGecitUzeriAlanTextField(), null);
            acikGecitUzeriTabanPanel.add(getAcikGecitUzeriUTextField(), null);
            acikGecitUzeriTabanPanel.add(birimLabel22, null);
            acikGecitUzeriTabanPanel.add(birimLabel23, null);
            acikGecitUzeriTabanPanel.add(getAcikGecitUzeriYogusmaButton(), null);
        }
        return acikGecitUzeriTabanPanel;
    }

    private JPanel getPencerePanel()
    {
        if(pencerePanel == null)
        {
            pencereULabel = new JLabel();
            pencereAlanLabel = new JLabel();
            pencerePanel = new JPanel();
            pencerePanel.setLayout(null);
            pencerePanel.setName("pencerePanel");
            pencereAlanLabel.setText("Alan");
            pencereAlanLabel.setLocation(126, 48);
            pencereAlanLabel.setSize(60, 24);
            pencereULabel.setText("u deðeri");
            pencereULabel.setLocation(126, 95);
            pencereULabel.setSize(60, 24);
            pencerePanel.add(pencereAlanLabel, null);
            pencerePanel.add(getPencereAlanTextField(), null);
            pencerePanel.add(pencereULabel, null);
            pencerePanel.add(getPencereUTextField(), null);
            pencerePanel.add(getJScrollPane(), null);
        }
        return pencerePanel;
    }

    private JButton getHavalandirmaSecButton()
    {
        if(havalandirmaSecButton == null)
        {
            havalandirmaSecButton = new JButton();
            havalandirmaSecButton.setBounds(177, 20, 34, 24);
            havalandirmaSecButton.setText("...");
            havalandirmaSecButton.setEnabled(false);
        }
        return havalandirmaSecButton;
    }

    private JTable getDisDuvarModelTable()
    {
    	if(disDuvarModelTable==null){
    		disDuvarModelTable = new JTable();
    	}
        return disDuvarModelTable;
    }

    private JScrollPane getDisDuvarModelScrollPane()
    {
        if(disDuvarModelScrollPane == null)
        {
            disDuvarModelScrollPane = new JScrollPane();
            disDuvarModelScrollPane.setBounds(25, 159, 403, 99);
            disDuvarModelScrollPane.setViewportView(getDisDuvarModelTable());
        }
        return disDuvarModelScrollPane;
    }

    private JList getDisDuvarlarList()
    {
        if(disDuvarlarList == null)
        {
            DefaultListModel listModel = new DefaultListModel();
            disDuvarlarList = new JList(listModel);
        }
        return disDuvarlarList;
    }

    private JScrollPane getDisDuvarlarScrollPane()
    {
        if(disDuvarlarScrollPane == null)
        {
            disDuvarlarScrollPane = new JScrollPane();
            disDuvarlarScrollPane.setBounds(195, 34, 211, 92);
            disDuvarlarScrollPane.setViewportView(getDisDuvarlarList());
        }
        return disDuvarlarScrollPane;
    }

    private JButton getDisDuvarEkleButton()
    {
        if(disDuvarEkleButton == null)
        {
            disDuvarEkleButton = new JButton();
            disDuvarEkleButton.setBounds(46, 41, 98, 24);
            disDuvarEkleButton.setText("Ekle");
        }
        return disDuvarEkleButton;
    }

    private JButton getDisDuvarCikarButton()
    {
        if(disDuvarCikarButton == null)
        {
            disDuvarCikarButton = new JButton();
            disDuvarCikarButton.setBounds(46, 73, 98, 24);
            disDuvarCikarButton.setText("Çýkar");
        }
        return disDuvarCikarButton;
    }

    private JTextField getDisDuvarAlanTextField()
    {
        if(disDuvarAlanTextField == null)
        {
            disDuvarAlanTextField = new JTextField();
            disDuvarAlanTextField.setLocation(193, 339);
            disDuvarAlanTextField.setSize(98, 24);
        }
        return disDuvarAlanTextField;
    }

    private JTextField getDisDuvarUTextField()
    {
        if(disDuvarUTextField == null)
        {
            disDuvarUTextField = new JTextField();
            disDuvarUTextField.setLocation(193, 385);
            disDuvarUTextField.setSize(98, 24);
            disDuvarUTextField.setEditable(false);
        }
        return disDuvarUTextField;
    }

    private JPanel getJPanel33()
    {
        if(jPanel33 == null)
        {
            birimLabel25 = new JLabel();
            binaKullanimAlaniLabel = new JLabel();
            birimLabel5 = new JLabel();
            birimLabel3 = new JLabel();
            birimLabel2 = new JLabel();
            alanHacimOraniLabel = new JLabel();
            brutHacimLabel = new JLabel();
            toplamAlanLabel = new JLabel();
            jPanel33 = new JPanel();
            jPanel33.setLayout(null);
            jPanel33.setBorder(BorderFactory.createTitledBorder(null, "A/V", 0, 0, null, null));
            jPanel33.setToolTipText("Binanýn ýsý kaybeden yüzeylerinin toplam alaný / binanýn brüt hacmi");
            jPanel33.setBounds(18, 15, 428, 113);
            toplamAlanLabel.setBounds(16, 19, 80, 24);
            toplamAlanLabel.setText("A toplam");
            brutHacimLabel.setBounds(16, 47, 80, 24);
            brutHacimLabel.setText("V brüt");
            alanHacimOraniLabel.setBounds(16, 76, 80, 24);
            alanHacimOraniLabel.setText("A/V");
            birimLabel2.setBounds(205, 20, 31, 21);
            birimLabel2.setText("<HTML>m<SUP>2</SUP></HTML>");
            birimLabel3.setBounds(205, 48, 31, 21);
            birimLabel3.setText("<HTML>m<SUP>3</SUP></HTML>");
            birimLabel5.setBounds(205, 77, 31, 21);
            birimLabel5.setText("1/m");
            binaKullanimAlaniLabel.setBounds(276, 19, 134, 24);
            binaKullanimAlaniLabel.setText("Bina Kullaným Alaný An");
            birimLabel25.setBounds(369, 49, 31, 21);
            birimLabel25.setText("<HTML>m<SUP>2</SUP></HTML>");
            jPanel33.add(toplamAlanLabel, null);
            jPanel33.add(brutHacimLabel, null);
            jPanel33.add(alanHacimOraniLabel, null);
            jPanel33.add(getToplamAlanTextField(), null);
            jPanel33.add(getBrutHacimTextField(), null);
            jPanel33.add(getAlanHacimOraniTextField(), null);
            jPanel33.add(birimLabel2, null);
            jPanel33.add(birimLabel3, null);
            jPanel33.add(birimLabel5, null);
            jPanel33.add(binaKullanimAlaniLabel, null);
            jPanel33.add(getBinaKullanimAlaniTextField(), null);
            jPanel33.add(birimLabel25, null);
        }
        return jPanel33;
    }

    private JTextField getToplamAlanTextField()
    {
        if(toplamAlanTextField == null)
        {
            toplamAlanTextField = new JTextField();
            toplamAlanTextField.setBounds(112, 19, 81, 24);
            toplamAlanTextField.setEditable(false);
        }
        return toplamAlanTextField;
    }

    private JTextField getBrutHacimTextField()
    {
        if(brutHacimTextField == null)
        {
            brutHacimTextField = new JTextField();
            brutHacimTextField.setBounds(112, 47, 81, 24);
        }
        return brutHacimTextField;
    }

    private JTextField getAlanHacimOraniTextField()
    {
        if(alanHacimOraniTextField == null)
        {
            alanHacimOraniTextField = new JTextField();
            alanHacimOraniTextField.setBounds(112, 76, 81, 24);
            alanHacimOraniTextField.setEditable(false);
        }
        return alanHacimOraniTextField;
    }

    private JPanel getJPanel34()
    {
        if(jPanel34 == null)
        {
            jPanel34 = new JPanel();
            icOrtamSicakligiLabel = new JLabel();
            ozgunIsiKaybiLabel = new JLabel();
            birimLabel4 = new JLabel();
            birimLabel6 = new JLabel();
            jPanel34.setLayout(null);
            jPanel34.setBorder(BorderFactory.createTitledBorder(null, "", 0, 0, null, null));
            jPanel34.setLocation(18, 133);
            jPanel34.setSize(385, 82);
            icOrtamSicakligiLabel.setText("\u0130\347 ortam s\u0131cakl\u0131\u011F\u0131 Ti");
            icOrtamSicakligiLabel.setBounds(18, 13, 115, 24);
            ozgunIsiKaybiLabel.setText("Ýletimsel Özgül Isý kaybý Hi");
            ozgunIsiKaybiLabel.setToolTipText("Is\u0131 ge\347i\u015Fi yoluyla ger\347ekle\u015Fen \u0131s\u0131 kayb\u0131");
            ozgunIsiKaybiLabel.setLocation(18, 47);
            ozgunIsiKaybiLabel.setSize(150, 24);
            birimLabel4.setText("\u00B0C");
            birimLabel4.setSize(39, 24);
            birimLabel4.setLocation(280, 13);
            birimLabel6.setText("W/K");
            birimLabel6.setSize(39, 24);
            birimLabel6.setLocation(280, 47);
            jPanel34.add(icOrtamSicakligiLabel, null);
            jPanel34.add(ozgunIsiKaybiLabel, null);
            jPanel34.add(getIcOrtamSicakligiTextField(), null);
            jPanel34.add(getIletimselOzgulIsiKaybiTextField(), null);
            jPanel34.add(birimLabel4, null);
            jPanel34.add(birimLabel6, null);
        }
        return jPanel34;
    }

    private JTextField getIcOrtamSicakligiTextField()
    {
        if(icOrtamSicakligiTextField == null)
        {
            icOrtamSicakligiTextField = new JTextField();
            icOrtamSicakligiTextField.setLocation(180, 13);
            icOrtamSicakligiTextField.setSize(88, 24);
            icOrtamSicakligiTextField.setText("19");
        }
        return icOrtamSicakligiTextField;
    }

    private JTextField getIletimselOzgulIsiKaybiTextField()
    {
        if(iletimselOzgulIsiKaybiTextField == null)
        {
            iletimselOzgulIsiKaybiTextField = new JTextField();
            iletimselOzgulIsiKaybiTextField.setEnabled(true);
            iletimselOzgulIsiKaybiTextField.setSize(88, 24);
            iletimselOzgulIsiKaybiTextField.setLocation(180, 47);
            iletimselOzgulIsiKaybiTextField.setEditable(false);
        }
        return iletimselOzgulIsiKaybiTextField;
    }

    private JPanel getJPanel35()
    {
        if(jPanel35 == null)
        {
            jPanel35 = new JPanel();
            havaDegisimKatsayisiLabel = new JLabel();
            ozgunIsiKaybiLabel1 = new JLabel();
            toplamOzgulIsiKaybiLabel = new JLabel();
            birimLabel7 = new JLabel();
            birimLabel8 = new JLabel();
            birimLabel9 = new JLabel();
            jPanel35.setLayout(null);
            jPanel35.setBorder(BorderFactory.createTitledBorder(null, "", 0, 0, null, null));
            jPanel35.setLocation(18, 221);
            jPanel35.setSize(384, 99);
            jPanel35.setToolTipText("<HTML><P>1,0 h<SUP>-1</SUP> Pencere sistemleri" +
            		" (uygunluk belgesine sahip)</P><P>2,0 h<SUP>-1</SUP> Pencere " +
            		"sistemleri (uygunluk belgesine sahip deðil)</P><P>Veya ölçme sonucuna" +
            		" dayanan bir deðer varsa</P></HTML>");

            havaDegisimKatsayisiLabel.setText("Hava de\u011Fi\u015Fim katsay\u0131s\u0131 nh");
            havaDegisimKatsayisiLabel.setLocation(17, 8);
            havaDegisimKatsayisiLabel.setSize(172, 24);
            ozgunIsiKaybiLabel1.setBounds(17, 38, 172, 24);
            ozgunIsiKaybiLabel1.setText("HavalandýrmaÖzgül ýsý kaybý");
            ozgunIsiKaybiLabel1.setToolTipText("Havaland\u0131rma yoluyla ger\347ekle\u015Fen \u0131s\u0131 kayb\u0131");
            toplamOzgulIsiKaybiLabel.setBounds(17, 68, 172, 22);
            toplamOzgulIsiKaybiLabel.setText("Toplam \366zg\374l \u0131s\u0131 kayb\u0131");
            birimLabel7.setBounds(297, 8, 30, 24);
            birimLabel7.setText("1/h");
            birimLabel8.setBounds(296, 38, 32, 24);
            birimLabel8.setText("W/K");
            birimLabel9.setBounds(296, 68, 33, 22);
            birimLabel9.setText("W/K");
            jPanel35.add(havaDegisimKatsayisiLabel, null);
            jPanel35.add(ozgunIsiKaybiLabel1, null);
            jPanel35.add(toplamOzgulIsiKaybiLabel, null);
            jPanel35.add(getHavaDegisimKatsayisiTextField(), null);
            jPanel35.add(getHavalandirmaOzgulIsiKaybiTextField(), null);
            jPanel35.add(getToplamOzgulIsiKaybiTextField(), null);
            jPanel35.add(birimLabel7, null);
            jPanel35.add(birimLabel8, null);
            jPanel35.add(birimLabel9, null);
        }
        return jPanel35;
    }

    private JTextField getHavaDegisimKatsayisiTextField()
    {
        if(havaDegisimKatsayisiTextField == null)
        {
            havaDegisimKatsayisiTextField = new JTextField();
            havaDegisimKatsayisiTextField.setBounds(202, 8, 87, 24);
        }
        return havaDegisimKatsayisiTextField;
    }

    private JTextField getHavalandirmaOzgulIsiKaybiTextField()
    {
        if(havalandirmaOzgulIsiKaybiTextField == null)
        {
            havalandirmaOzgulIsiKaybiTextField = new JTextField();
            havalandirmaOzgulIsiKaybiTextField.setBounds(202, 38, 87, 24);
            havalandirmaOzgulIsiKaybiTextField.setEnabled(true);
            havalandirmaOzgulIsiKaybiTextField.setEditable(false);
        }
        return havalandirmaOzgulIsiKaybiTextField;
    }

    private JTextField getToplamOzgulIsiKaybiTextField()
    {
        if(toplamOzgulIsiKaybiTextField == null)
        {
            toplamOzgulIsiKaybiTextField = new JTextField();
            toplamOzgulIsiKaybiTextField.setBounds(202, 68, 87, 22);
            toplamOzgulIsiKaybiTextField.setEnabled(true);
            toplamOzgulIsiKaybiTextField.setEditable(false);
        }
        return toplamOzgulIsiKaybiTextField;
    }

    private JPanel getJPanel36()
    {
        if(jPanel36 == null)
        {
            jLabel = new JLabel();
            jPanel36 = new JPanel();
            qLabel = new JLabel();
            jPanel36.setLayout(null);
            jPanel36.setBorder(BorderFactory.createTitledBorder(null, "Y\u0131ll\u0131k Is\u0131tma Enerjisi \u0130htiyac\u0131", 0, 0, new Font("Dialog", 1, 12), new Color(51, 51, 51)));
            jPanel36.setBounds(18, 327, 193, 87);
            qLabel.setText("Q");
            qLabel.setLocation(19, 21);
            qLabel.setSize(60, 24);
            jLabel.setBounds(140, 50, 47, 24);
            jLabel.setText("<HTML>kWh/m<SUP>3</SUP></HTML>");
            jPanel36.add(qLabel, null);
            jPanel36.add(getQTextField(), null);
            jPanel36.add(jLabel, null);
        }
        return jPanel36;
    }

    private JTextField getQTextField()
    {
        if(qTextField == null)
        {
            qTextField = new JTextField();
            qTextField.setLocation(19, 50);
            qTextField.setSize(111, 24);
            qTextField.setEditable(false);
        }
        return qTextField;
    }

    private JPanel getJPanel37()
    {
        if(jPanel37 == null)
        {
            standartaUygunlukLabel = new JLabel();
            jPanel37 = new JPanel();
            jPanel37.setLayout(null);
            jPanel37.setSize(166, 385);
            standartaUygunlukLabel.setBounds(57, 420, 313, 17);
            standartaUygunlukLabel.setText(" ");
            jPanel37.add(getJPanel33(), null);
            jPanel37.add(getJPanel34(), null);
            jPanel37.add(getJPanel35(), null);
            jPanel37.add(getJPanel36(), null);
            jPanel37.add(getJPanel1(), null);
            jPanel37.add(standartaUygunlukLabel, null);
        }
        return jPanel37;
    }

    private JSplitPane getJSplitPane2()
    {
        if(jSplitPane2 == null)
        {
            jSplitPane2 = new JSplitPane();
            jSplitPane2.setLeftComponent(getJPanel37());
            jSplitPane2.setDividerLocation(400);
            jSplitPane2.setOneTouchExpandable(true);
            jSplitPane2.setRightComponent(getJPanel38());
        }
        return jSplitPane2;
    }

    private JPanel getJPanel38()
    {
        if(jPanel38 == null)
        {
            jLabel3 = new JLabel();
            toplamGunesEnerjisiLabel = new JLabel();
            jPanel38 = new JPanel();
            jPanel38.setLayout(null);
            toplamGunesEnerjisiLabel.setText("Toplam güneþ enerjisi kazancý");
            toplamGunesEnerjisiLabel.setLocation(39, 306);
            toplamGunesEnerjisiLabel.setSize(206, 24);
            jLabel3.setBounds(140, 336, 19, 24);
            jLabel3.setText("W");
            jPanel38.add(getJPanel40(), null);
            jPanel38.add(getJPanel41(), null);
            jPanel38.add(toplamGunesEnerjisiLabel, null);
            jPanel38.add(getToplamGunesEnerjisiTextField(), null);
            jPanel38.add(jLabel3, null);
        }
        return jPanel38;
    }

    private JPanel getJPanel40()
    {
        if(jPanel40 == null)
        {
            ButtonGroup buttonGroup1 = new ButtonGroup();
            ButtonGroup buttonGroup2 = new ButtonGroup();
            ButtonGroup buttonGroup3 = new ButtonGroup();
            ButtonGroup buttonGroup4 = new ButtonGroup();
            jPanel40 = new JPanel();
            gDikDoguLabel = new JLabel();
            gDikBatiLabel = new JLabel();
            gDikGuneyLabel = new JLabel();
            gDikKuzeyLabel = new JLabel();
            jPanel40.setLayout(null);
            jPanel40.setBorder(BorderFactory.createTitledBorder(null, "g dik", 0, 0, null, null));
            jPanel40.setLocation(24, 32);
            jPanel40.setSize(277, 153);
            jPanel40.setToolTipText("<HTML>g<SUB>dik:</SUB> Laboratuvar þartlarýnda ölçülen ve yüzeye" +
            		"dik gelen ýþýn için güneþ enerjisi geçirme faktörüdür.<BR> Ölçü deðerinin " +
            		"olmamasý durumunda g<SUB>dik</SUB> için aþaðýdaki deðerler kullanýlabilir:" +
            		"<UL><LI>Tek cam için: g<SUB>dik</SUB>=0.85</LI><LI>Çok katlý cam(berrak) için: g<SUB>dik</SUB>=0.75</LI><LI>u<=2.0 olan ýsý yalýtým birimleri için g<SUB>dik</SUB>=0.50</LI></UL></HTML>");
            gDikDoguLabel.setText("g dik (doðu)");
            gDikDoguLabel.setLocation(10, 19);
            gDikDoguLabel.setSize(88, 25);
            gDikBatiLabel.setBounds(10, 52, 88, 25);
            gDikBatiLabel.setText("g dik (batý)");
            gDikGuneyLabel.setBounds(10, 85, 88, 25);
            gDikGuneyLabel.setText("g dik (güney)");
            gDikKuzeyLabel.setBounds(10, 118, 88, 25);
            gDikKuzeyLabel.setText("g dik (kuzey)");
            jPanel40.add(gDikDoguLabel, null);
            jPanel40.add(gDikBatiLabel, null);
            jPanel40.add(gDikGuneyLabel, null);
            jPanel40.add(gDikKuzeyLabel, null);
            buttonGroup1.add(getGDikDoguBRadioButton());
            buttonGroup1.add(getGDikDoguORadioButton());
            buttonGroup1.add(getGDikDoguKRadioButton());
            buttonGroup2.add(getGDikBatiBRadioButton());
            buttonGroup2.add(getGDikBatiORadioButton());
            buttonGroup2.add(getGDikBatiKRadioButton());
            buttonGroup3.add(getGDikGuneyBRadioButton());
            buttonGroup3.add(getGDikGuneyORadioButton());
            buttonGroup3.add(getGDikGuneyKRadioButton());
            buttonGroup4.add(getGDikKuzeyBRadioButton());
            buttonGroup4.add(getGDikKuzeyORadioButton());
            buttonGroup4.add(getGDikKuzeyKRadioButton());            
            jPanel40.add(getGDikDoguBRadioButton(), null);
            jPanel40.add(getGDikDoguORadioButton(), null);
            jPanel40.add(getGDikDoguKRadioButton(), null);
            jPanel40.add(getGDikBatiBRadioButton(), null);
            jPanel40.add(getGDikBatiORadioButton(), null);
            jPanel40.add(getGDikBatiKRadioButton(), null);
            jPanel40.add(getGDikGuneyBRadioButton(), null);
            jPanel40.add(getGDikGuneyORadioButton(), null);
            jPanel40.add(getGDikGuneyKRadioButton(), null);
            jPanel40.add(getGDikKuzeyBRadioButton(), null);
            jPanel40.add(getGDikKuzeyORadioButton(), null);
            jPanel40.add(getGDikKuzeyKRadioButton(), null);
        }
        return jPanel40;
    }

    private JRadioButton getGDikDoguBRadioButton()
    {
        if(gDikDoguBRadioButton == null)
        {
            gDikDoguBRadioButton = new JRadioButton();
            gDikDoguBRadioButton.setLocation(108, 21);
            gDikDoguBRadioButton.setSize(52, 21);
            gDikDoguBRadioButton.setText("0,85");
        }
        return gDikDoguBRadioButton;
    }

    private JRadioButton getGDikDoguORadioButton()
    {
        if(gDikDoguORadioButton == null)
        {
            gDikDoguORadioButton = new JRadioButton();
            gDikDoguORadioButton.setBounds(164, 21, 52, 21);
            gDikDoguORadioButton.setText("0,75");
        }
        return gDikDoguORadioButton;
    }

    private JRadioButton getGDikDoguKRadioButton()
    {
        if(gDikDoguKRadioButton == null)
        {
            gDikDoguKRadioButton = new JRadioButton();
            gDikDoguKRadioButton.setBounds(220, 21, 52, 21);
            gDikDoguKRadioButton.setText("0,50");
        }
        return gDikDoguKRadioButton;
    }

    private JRadioButton getGDikBatiBRadioButton()
    {
        if(gDikBatiBRadioButton == null)
        {
            gDikBatiBRadioButton = new JRadioButton();
            gDikBatiBRadioButton.setBounds(108, 54, 52, 21);
            gDikBatiBRadioButton.setText("0,85");
        }
        return gDikBatiBRadioButton;
    }

    private JRadioButton getGDikBatiORadioButton()
    {
        if(gDikBatiORadioButton == null)
        {
            gDikBatiORadioButton = new JRadioButton();
            gDikBatiORadioButton.setBounds(164, 54, 52, 21);
            gDikBatiORadioButton.setText("0,75");
        }
        return gDikBatiORadioButton;
    }

    private JRadioButton getGDikBatiKRadioButton()
    {
        if(gDikBatiKRadioButton == null)
        {
            gDikBatiKRadioButton = new JRadioButton();
            gDikBatiKRadioButton.setBounds(220, 54, 52, 21);
            gDikBatiKRadioButton.setText("0,50");
        }
        return gDikBatiKRadioButton;
    }

    private JRadioButton getGDikGuneyBRadioButton()
    {
        if(gDikGuneyBRadioButton == null)
        {
            gDikGuneyBRadioButton = new JRadioButton();
            gDikGuneyBRadioButton.setBounds(108, 87, 52, 21);
            gDikGuneyBRadioButton.setText("0,85");
        }
        return gDikGuneyBRadioButton;
    }

    private JRadioButton getGDikGuneyORadioButton()
    {
        if(gDikGuneyORadioButton == null)
        {
            gDikGuneyORadioButton = new JRadioButton();
            gDikGuneyORadioButton.setBounds(164, 87, 52, 21);
            gDikGuneyORadioButton.setText("0,75");
        }
        return gDikGuneyORadioButton;
    }

    private JRadioButton getGDikGuneyKRadioButton()
    {
        if(gDikGuneyKRadioButton == null)
        {
            gDikGuneyKRadioButton = new JRadioButton();
            gDikGuneyKRadioButton.setBounds(220, 87, 52, 21);
            gDikGuneyKRadioButton.setText("0,50");
        }
        return gDikGuneyKRadioButton;
    }

    private JRadioButton getGDikKuzeyBRadioButton()
    {
        if(gDikKuzeyBRadioButton == null)
        {
            gDikKuzeyBRadioButton = new JRadioButton();
            gDikKuzeyBRadioButton.setBounds(108, 120, 52, 21);
            gDikKuzeyBRadioButton.setText("0,85");
        }
        return gDikKuzeyBRadioButton;
    }

    private JRadioButton getGDikKuzeyORadioButton()
    {
        if(gDikKuzeyORadioButton == null)
        {
            gDikKuzeyORadioButton = new JRadioButton();
            gDikKuzeyORadioButton.setBounds(164, 120, 52, 21);
            gDikKuzeyORadioButton.setText("0,75");
        }
        return gDikKuzeyORadioButton;
    }

    private JRadioButton getGDikKuzeyKRadioButton()
    {
        if(gDikKuzeyKRadioButton == null)
        {
            gDikKuzeyKRadioButton = new JRadioButton();
            gDikKuzeyKRadioButton.setBounds(220, 120, 52, 21);
            gDikKuzeyKRadioButton.setText("0,50");
        }
        return gDikKuzeyKRadioButton;
    }

    private JPanel getJPanel41()
    {
        if(jPanel41 == null)
        {
            jPanel41 = new JPanel();
            toplamPencereAlaniLabel = new JLabel();
            birimLabel24 = new JLabel();
            jPanel41.setLayout(null);
            jPanel41.setLocation(24, 192);
            jPanel41.setSize(369, 92);
            jPanel41.setBorder(BorderFactory.createTitledBorder(null, "Ap", 0, 0, null, null));
            toplamPencereAlaniLabel.setBounds(14, 57, 73, 22);
            toplamPencereAlaniLabel.setText("Toplam");
            birimLabel24.setBounds(241, 55, 58, 22);
            birimLabel24.setText("<HTML>m<SUP>2</SUP></HTML>");
            jPanel41.add(toplamPencereAlaniLabel, null);
            
            ButtonGroup buttonGroup = new ButtonGroup();
            buttonGroup.add(getDoguPencereRadioButton());
            buttonGroup.add(getBatiPencereRadioButton());
            buttonGroup.add(getGuneyPencereRadioButton());
            buttonGroup.add(getKuzeyPencereRadioButton());
            
            jPanel41.add(getDoguPencereRadioButton(), null);
            jPanel41.add(getBatiPencereRadioButton(), null);
            jPanel41.add(getGuneyPencereRadioButton(), null);
            jPanel41.add(getKuzeyPencereRadioButton(), null);
            jPanel41.add(getYoneGorePencereAlaniTextField(), null);
            jPanel41.add(getToplamPencereAlaniTextField(), null);
            jPanel41.add(birimLabel24, null);
        }
        return jPanel41;
    }

    private JRadioButton getDoguPencereRadioButton()
    {
        if(doguPencereRadioButton == null)
        {
            doguPencereRadioButton = new JRadioButton();
            doguPencereRadioButton.setBounds(8, 18, 61, 22);
            doguPencereRadioButton.setText("Do\u011Fu");
        }
        return doguPencereRadioButton;
    }

    private JRadioButton getBatiPencereRadioButton()
    {
        if(batiPencereRadioButton == null)
        {
            batiPencereRadioButton = new JRadioButton();
            batiPencereRadioButton.setBounds(77, 18, 61, 22);
            batiPencereRadioButton.setText("Bat\u0131");
        }
        return batiPencereRadioButton;
    }

    private JRadioButton getGuneyPencereRadioButton()
    {
        if(guneyPencereRadioButton == null)
        {
            guneyPencereRadioButton = new JRadioButton();
            guneyPencereRadioButton.setBounds(146, 18, 61, 22);
            guneyPencereRadioButton.setText("G\374ney");
        }
        return guneyPencereRadioButton;
    }

    private JRadioButton getKuzeyPencereRadioButton()
    {
        if(kuzeyPencereRadioButton == null)
        {
            kuzeyPencereRadioButton = new JRadioButton();
            kuzeyPencereRadioButton.setBounds(215, 18, 61, 22);
            kuzeyPencereRadioButton.setText("Kuzey");
        }
        return kuzeyPencereRadioButton;
    }

    private JTextField getYoneGorePencereAlaniTextField()
    {
        if(yoneGorePencereAlaniTextField == null)
        {
            yoneGorePencereAlaniTextField = new JTextField();
            yoneGorePencereAlaniTextField.setBounds(284, 17, 75, 22);
        }
        return yoneGorePencereAlaniTextField;
    }

    private JTextField getToplamPencereAlaniTextField()
    {
        if(toplamPencereAlaniTextField == null)
        {
            toplamPencereAlaniTextField = new JTextField();
            toplamPencereAlaniTextField.setBounds(107, 55, 117, 22);
            toplamPencereAlaniTextField.setEditable(false);
            toplamPencereAlaniTextField.setEnabled(true);
        }
        return toplamPencereAlaniTextField;
    }

    private JPanel jPanel;
    private JTabbedPane projectTabbedPane;
    private JPanel ts825Panel;
    private JPanel isiKaybiPanel;
    private JPanel tanimlarPanel;
    private JTabbedPane isiKaybiTabbedPane;
    private JPanel jPanel5;
    private JPanel kritikHatPanel;
    private JPanel jPanel7;
    private JSplitPane jSplitPane;
    private JPanel ddTreePanel;
    private JPanel ddTreeCardLayoutPanel;
    private JScrollPane illerScrollPane;
    private JList illerList;
    private JLabel illerLabel;
    private JLabel secilenIlLabel;
    private JLabel secilenLabel;
    private JRadioButton konutRadioButton;
    private JRadioButton enerjiRadioButton;
    private JPanel binaTipiPanel;
    private JPanel netOdaYuksekligiPanel;
    private JRadioButton yuksek26RadioButton;
    private JRadioButton esit26RadioButton;
    private JPanel havalandirmaPanel;
    private JRadioButton dogalRadioButton;
    private JRadioButton mekanikRadioButton;
    private JPanel yerlesimBolgesiPanel;
    private JRadioButton ayrikRadioButton;
    private JRadioButton mahfuzRadioButton;
    private JRadioButton bitisikRadioButton;
    private JLabel haritaLabel;
    private JTabbedPane ts825TabbedPane;
    private JPanel binaKonumBilgileriPanel;
    private JPanel ozgulIsiKaybiPanel;
    private JPanel yillikIsitmaIhtiyaciPanel;
    private JTabbedPane tanimlarTabbedPane;
    private JPanel bolgePanel;
    private JPanel projePanel;
    private JTextField projeAdiTextField;
    private JLabel projeAdiLabel;
    private JTextField muhendisAdTextField;
    private JLabel muhendisAdLabel;
    private JPanel muhendisPanel;
    private JLabel muhendisUnvanLabel;
    private JLabel muhendisSicilLabel;
    private JTextField muhendisUnvanTextField;
    private JTextField muhendisSicilTextField;
    private JPanel binaPanel;
    private JLabel adaParselLabel;
    private JLabel binaTanimLabel;
    private JLabel caddeLabel;
    private JLabel ilIlceLabel;
    private JLabel yakitLabel;
    private JTextField adaParselTextField;
    private JTextField binaTanimTextField;
    private JTextField caddeTextField;
    private JTextField ilIlceTextField;
    private JTextField yakitTextField;
    private JSplitPane ozgulIsiKaybiSplitPane;
    private JPanel jPanel21;
    private JPanel jPanel22;
    private JTree yapiElemanTipleriTree;
    private JPanel disDuvarPanel;
    private JPanel isitilmayanDuvarPanel;
    private JPanel topragaTemasliDuvarPanel;
    private JPanel uzeriAcikTavanPanel;
    private JPanel catiliTavanPanel;
    private JPanel topragaTemasliTabanPanel;
    private JPanel isitilmayanTabanPanel;
    private JPanel acikGecitUzeriTabanPanel;
    private JPanel pencerePanel;
    private Object menuStructure[] = {
        new PanelInfo("Menu", "mainPanel"), new PanelInfo("Duvar (Dýþ havaya açýk)", "disDuvarPanel"), new PanelInfo("Duvar (Isýtýlmayan iç ort. bitiþik)", "isitilmayanDuvarPanel"), new PanelInfo("Duvar (Topraða temas eden)", "topragaTemasliDuvarPanel"), new PanelInfo("Tavan (Üzeri açýk)", "uzeriAcikTavanPanel"), new PanelInfo("Tavan (Çatýlý)", "catiliTavanPanel"), new PanelInfo("Taban (Topraða temas eden)", "topragaTemasliTabanPanel"), new PanelInfo("Taban (Isýtýlmayan iç. ort. bitiþik)", "isitilmayanTabanPanel"), new PanelInfo("Taban (Açýk geçit üzeri)", "acikGecitUzeriTabanPanel"),new PanelInfo("Pencere", "pencerePanel")};
    private JButton havalandirmaSecButton;
    private JTable disDuvarModelTable;
    private JScrollPane disDuvarModelScrollPane;
    private JList disDuvarlarList;
    private JScrollPane disDuvarlarScrollPane;
    private JButton disDuvarEkleButton;
    private JButton disDuvarCikarButton;
    private JLabel disDuvarAlanLabel;
    private JTextField disDuvarAlanTextField;
    private JLabel disDuvarULabel;
    private JTextField disDuvarUTextField;
    private JLabel birimLabel;
    private JLabel birimLabel1;
    private JPanel jPanel33;
    private JLabel toplamAlanLabel;
    private JLabel brutHacimLabel;
    private JLabel alanHacimOraniLabel;
    private JTextField toplamAlanTextField;
    private JTextField brutHacimTextField;
    private JTextField alanHacimOraniTextField;
    private JLabel birimLabel2;
    private JLabel birimLabel3;
    private JLabel birimLabel5;
    private JPanel jPanel34;
    private JLabel icOrtamSicakligiLabel;
    private JLabel ozgunIsiKaybiLabel;
    private JTextField icOrtamSicakligiTextField;
    private JTextField iletimselOzgulIsiKaybiTextField;
    private JLabel birimLabel4;
    private JLabel birimLabel6;
    private JPanel jPanel35;
    private JLabel havaDegisimKatsayisiLabel;
    private JLabel ozgunIsiKaybiLabel1;
    private JLabel toplamOzgulIsiKaybiLabel;
    private JTextField havaDegisimKatsayisiTextField;
    private JTextField havalandirmaOzgulIsiKaybiTextField;
    private JTextField toplamOzgulIsiKaybiTextField;
    private JLabel birimLabel7;
    private JLabel birimLabel8;
    private JLabel birimLabel9;
    private JPanel jPanel36;
    private JLabel qLabel;
    private JTextField qTextField;
    private JPanel jPanel37;
    private JSplitPane jSplitPane2;
    private JPanel jPanel38;
    private JPanel jPanel40;
    private JLabel gDikDoguLabel;
    private JLabel gDikBatiLabel;
    private JLabel gDikGuneyLabel;
    private JLabel gDikKuzeyLabel;
    private JRadioButton gDikDoguBRadioButton;
    private JRadioButton gDikDoguORadioButton;
    private JRadioButton gDikDoguKRadioButton;
    private JRadioButton gDikBatiBRadioButton;
    private JRadioButton gDikBatiORadioButton;
    private JRadioButton gDikBatiKRadioButton;
    private JRadioButton gDikGuneyBRadioButton;
    private JRadioButton gDikGuneyORadioButton;
    private JRadioButton gDikGuneyKRadioButton;
    private JRadioButton gDikKuzeyBRadioButton;
    private JRadioButton gDikKuzeyORadioButton;
    private JRadioButton gDikKuzeyKRadioButton;
    private JPanel jPanel41;
    private JLabel toplamPencereAlaniLabel;
    private JRadioButton doguPencereRadioButton;
    private JRadioButton batiPencereRadioButton;
    private JRadioButton guneyPencereRadioButton;
    private JRadioButton kuzeyPencereRadioButton;
    private JTextField yoneGorePencereAlaniTextField;
    private JTextField toplamPencereAlaniTextField;
    private JLabel birimLabel24;



	private javax.swing.JPanel genelKatsayilarPanel = null;
	private javax.swing.JPanel binaKatsayisiPanel = null;
	private javax.swing.JLabel jLabel49 = null;
	private javax.swing.JRadioButton normalBolgeDurumuRadioButton = null;
	private javax.swing.JRadioButton ruzgarliBolgeDurumuRadioButton = null;
	private javax.swing.JRadioButton mahfuzBinaDurumuRadioButton = null;
	private javax.swing.JRadioButton serbestBinaDurumuRadioButton = null;
	private javax.swing.JRadioButton cokSerbestBinaDurumuRadioButton = null;
	private javax.swing.JLabel jLabel50 = null;
	private javax.swing.JRadioButton bitisikNizamRadioButton = null;
	private javax.swing.JRadioButton ayrikNizamRadioButton = null;
	private javax.swing.JTextField binaKatsayisiTextField = null;
	private javax.swing.JTextField sizdirganlikKatsayisiTextField = null;
	private javax.swing.JLabel jLabel47 = null;
	private javax.swing.JLabel jLabel48 = null;
	private javax.swing.JLabel jLabel491 = null;
	private javax.swing.JPanel odaDurumKatsayisiPanel = null;
	private javax.swing.JRadioButton odaDurumKatsayisi07RadioButton = null;
	private javax.swing.JRadioButton odaDurumKatsayisi09RadioButton = null;
	private javax.swing.JPanel sizdirganlikKatsayisiPanel = null;
	private javax.swing.JLabel jLabel492 = null;
	private javax.swing.JLabel jLabel493 = null;
	private javax.swing.JRadioButton ahsapMalzemeRadioButton = null;
	private javax.swing.JRadioButton plastikMalzemeRadioButton = null;
	private javax.swing.JRadioButton metalMalzemeRadioButton = null;
	private javax.swing.JRadioButton tekAcilirliTipRadioButton = null;
	private javax.swing.JRadioButton ciftCamliTipRadioButton = null;
	private javax.swing.JRadioButton ciftAcilirliTipRadioButton = null;
	private javax.swing.JLabel jLabel494 = null;
	private javax.swing.JPanel isletmeTipiPanel = null;
	private javax.swing.JPanel tesisatBilgileriPanel = null;
	private javax.swing.JPanel cogunluklaKullanilanYapiElemanlariPanel = null;
	private javax.swing.JLabel jLabel495 = null;
	private javax.swing.JLabel jLabel496 = null;
	private javax.swing.JLabel jLabel497 = null;
	private javax.swing.JLabel jLabel498 = null;
	private javax.swing.JLabel jLabel499 = null;
	private javax.swing.JTextField disDuvarTextField = null;
	private javax.swing.JTextField icDuvarTextField = null;
	private javax.swing.JTextField pencereTextField = null;
	private javax.swing.JTextField disKapiTextField = null;
	private javax.swing.JTextField icKapiTextField = null;
	private javax.swing.JButton disDuvarSecButton = null;
	private javax.swing.JButton icDuvarSecButton = null;
	private javax.swing.JButton pencereSecButton = null;
	private javax.swing.JButton disKapiSecButton = null;
	private javax.swing.JButton icKapiSecButton = null;
	private javax.swing.JPanel radyatorModeliPanel = null;
	private javax.swing.JLabel jLabel4910 = null;
	private javax.swing.JTextField radyatorModeliTextField = null;
	private javax.swing.JButton radyatorModeliSecButton = null;
	private javax.swing.JLabel jLabel4911 = null;
	private javax.swing.JComboBox isitmaSistemiComboBox = null;
	private javax.swing.JLabel jLabel4912 = null;
	private javax.swing.JRadioButton kazanIsiticiTuruRadioButton = null;
	private javax.swing.JRadioButton kombiIsiticiTuruRadioButton = null;
	private JButton disDuvarBilesenEkleButton = null;
	private JButton disDuvarBilesenCikarButton = null;
	private JTable isitilmayanDuvarModelTable = null;
	private JScrollPane isitilmayanDuvarModelScrollPane = null;
	private JButton isitilmayanDuvarBilesenEkleButton = null;
	private JButton isitilmayanDuvarBilesenCikarButton = null;
	private JLabel isitilmayanDuvarAlanLabel = null;
	private JTextField isitilmayanDuvarAlanTextField = null;
	private JLabel isitilmayanDuvarULabel = null;
	private JTextField isitilmayanDuvarUTextField = null;
	private JLabel birimLabel10 = null;
	private JLabel birimLabel11 = null;
	private JTable topragaTemasliDuvarTable = null;
	private JScrollPane topragaTemasliDuvarScrollPane = null;
	private JLabel topragaTemasliDuvarAlanLabel = null;
	private JLabel topragaTemasliDuvarULabel = null;
	private JButton topragaTemasliDuvarBilesenEkleButton = null;
	private JButton topragaTemasliDuvarBilesenCikarButton = null;
	private JTextField topragaTemasliDuvarAlanTextField = null;
	private JTextField topragaTemasliDuvarUTextField = null;
	private JLabel birimLabel12 = null;
	private JLabel birimLabel13 = null;
	private JTable uzeriAcikTavanTable = null;
	private JScrollPane uzeriAcikTavanScrollPane = null;
	private JTable catiliTavanTable = null;
	private JScrollPane catiliTavanScrollPane = null;
	private JTable topragaTemasliTabanTable = null;
	private JScrollPane topragaTemasliTabanScrollPane = null;
	private JTable isitilmayanTabanTable = null;
	private JScrollPane isitilmayanTabanScrollPane = null;
	private JTable acikGecitUzeriTable = null;
	private JScrollPane acikGecitUzeriScrollPane = null;
	private JButton uzeriAcikTavanBilesenEkleButton = null;
	private JButton catiliTavanBilesenEkleButton = null;
	private JButton topragaTemasliTabanBilesenEkleButton = null;
	private JButton isitilmayanTabanBilesenEkleButton = null;
	private JButton acikGecitUzeriBilesenEkleButton = null;
	private JButton uzeriAcikTavanBilesenCikarButton = null;
	private JButton catiliTavanBilesenCikarButton = null;
	private JButton topragaTemasliTabanBilesenCikarButton = null;
	private JButton isitilmayanTabanBilesenCikarButton = null;
	private JButton acikGecitUzeriBilesenCikarButton = null;
	private JLabel uzeriAcikTavanAlanLabel = null;
	private JLabel uzeriAcikTavanULabel = null;
	private JLabel catiliTavanAlanLabel = null;
	private JLabel catiliTavanULabel = null;
	private JLabel topragaTemasliTabanAlanLabel = null;
	private JLabel topragaTemasliTabanULabel = null;
	private JLabel isitilmayanTabanAlanLabel = null;
	private JLabel isitilmayanTabanULabel = null;
	private JLabel acikGecitUzeriAlanLabel = null;
	private JLabel acikGecitUzeriULabel = null;
	private JTextField uzeriAcikTavanAlanTextField = null;
	private JTextField uzeriAcikTavanUTextField = null;
	private JTextField catiliTavanAlanTextField = null;
	private JTextField catiliTavanUTextField = null;
	private JTextField topragaTemasliTabanAlanTextField = null;
	private JTextField topragaTemasliTabanUTextField = null;
	private JTextField isitilmayanTabanAlanTextField = null;
	private JTextField isitilmayanTabanUTextField = null;
	private JTextField acikGecitUzeriAlanTextField = null;
	private JTextField acikGecitUzeriUTextField = null;
	private JLabel birimLabel14 = null;
	private JLabel birimLabel15 = null;
	private JLabel birimLabel16 = null;
	private JLabel birimLabel17 = null;
	private JLabel birimLabel18 = null;
	private JLabel birimLabel19 = null;
	private JLabel birimLabel20 = null;
	private JLabel birimLabel21 = null;
	private JLabel birimLabel22 = null;
	private JLabel birimLabel23 = null;
	private JLabel pencereAlanLabel = null;
	private JTextField pencereAlanTextField = null;
	private JLabel pencereULabel = null;
	private JTextField pencereUTextField = null;
	private JEditorPane jEditorPane = null;
	private JScrollPane jScrollPane = null;
	private JLabel binaKullanimAlaniLabel = null;
	private JTextField binaKullanimAlaniTextField = null;
	private JLabel birimLabel25 = null;
	private JLabel toplamGunesEnerjisiLabel = null;
	private JTextField toplamGunesEnerjisiTextField = null;
	private JLabel jLabel = null;
	private JRadioButton isletme1RadioButton = null;
	private JRadioButton isletme2RadioButton = null;
	private JRadioButton isletme3RadioButton = null;
	public IsiKazanciPanel isiKazanciPanel1 = null;
	private IsiYalitimiPanel isiYalitimiPanel = null;
	private JPanel jPanel1 = null;
	private JLabel jLabel1 = null;
	private JTextField standartQTextField = null;
	private JLabel jLabel2 = null;
	public JLabel standartaUygunlukLabel = null;
	private JButton yogusmaButton = null;
	private JButton uzeriAcikTavanYogusmaButton = null;
	private JButton catiliTavanYogusmaButton = null;
	private JButton acikGecitUzeriYogusmaButton = null;
	private JPanel kazanSecimiPanel = null;
	private JPanel jPanel2 = null;
	private JPanel jPanel3 = null;
	private JPanel jPanel4 = null;
	private JPanel jPanel6 = null;
	private JButton jButton1 = null;
	private JButton jButton2 = null;
	private JPanel binaKonumBilgilerijPanel = null;
	private JPanel jPanel9 = null;
	private JPanel jPanel10 = null;
	private JPanel jPanel11 = null;
	private JPanel ozgulIsiKaybiPanel1 = null;
	private JPanel yillikIsitmaIhtiyaciPanel1 = null;
	private JButton jButton = null;
	private JButton jButton4 = null;
	private JButton jButton5 = null;
	private JButton jButton6 = null;
	private JPanel jPanel8 = null;
	private JPanel jPanel12 = null;
	private JPanel jPanel13 = null;
	private JPanel jPanel14 = null;
	private JPanel jPanel15 = null;
	private JPanel jPanel16 = null;
	private JPanel jPanel17 = null;
	private JPanel jPanel18 = null;
	private JPanel jPanel19 = null;
	private JPanel jPanel20 = null;
	private JPanel jPanel23 = null;
	private JPanel jPanel24 = null;
	private JButton jButton3 = null;
	private JButton jButton7 = null;
	private JButton jButton8 = null;
	private JButton jButton9 = null;
	private JButton jButton10 = null;
	private JButton jButton11 = null;
	private JButton jButton12 = null;
	private JButton jButton13 = null;
	private JButton jButton14 = null;
	private JButton jButton15 = null;
	private JLabel jLabel3 = null;
		/**
	 * This method initializes genelKatsayilarPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getGenelKatsayilarPanel() {
		if(genelKatsayilarPanel == null) {
			genelKatsayilarPanel = new javax.swing.JPanel();
			genelKatsayilarPanel.setLayout(null);
			genelKatsayilarPanel.add(getBinaKatsayisiPanel(), null);
			genelKatsayilarPanel.add(getOdaDurumKatsayisiPanel(), null);
			genelKatsayilarPanel.add(getSizdirganlikKatsayisiPanel(), null);
			genelKatsayilarPanel.add(getIsletmeTipiPanel(), null);
		}
		return genelKatsayilarPanel;
	}
	/**
	 * This method initializes binaKatsayisiPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getBinaKatsayisiPanel() {
		if(binaKatsayisiPanel == null) {
			binaKatsayisiPanel = new javax.swing.JPanel();
			binaKatsayisiPanel.setLayout(null);
			ButtonGroup group1 = new ButtonGroup();
			ButtonGroup group2 = new ButtonGroup();
			ButtonGroup group3 = new ButtonGroup();
			group1.add(getNormalBolgeDurumuRadioButton());
			group1.add(getRuzgarliBolgeDurumuRadioButton());
			group2.add(getMahfuzBinaDurumuRadioButton());
			group2.add(getSerbestBinaDurumuRadioButton());
			group2.add(getCokSerbestBinaDurumuRadioButton());
			group3.add(getBitisikNizamRadioButton());
			group3.add(getAyrikNizamRadioButton());
			binaKatsayisiPanel.add(getNormalBolgeDurumuRadioButton(), null);
			binaKatsayisiPanel.add(getRuzgarliBolgeDurumuRadioButton(), null);
			binaKatsayisiPanel.add(getMahfuzBinaDurumuRadioButton(), null);
			binaKatsayisiPanel.add(getSerbestBinaDurumuRadioButton(), null);
			binaKatsayisiPanel.add(getCokSerbestBinaDurumuRadioButton(), null);
			binaKatsayisiPanel.add(getJLabel50(), null);
			binaKatsayisiPanel.add(getBitisikNizamRadioButton(), null);
			binaKatsayisiPanel.add(getAyrikNizamRadioButton(), null);
			binaKatsayisiPanel.add(getBinaKatsayisiTextField(), null);
			binaKatsayisiPanel.add(getJLabel472(), null);
			binaKatsayisiPanel.add(getJLabel48(), null);
			binaKatsayisiPanel.add(getJLabel491(), null);
			binaKatsayisiPanel.setBounds(40, 12, 562, 156);
			binaKatsayisiPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bina Katsayýsý (H)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12), java.awt.Color.black));
			binaKatsayisiPanel.setToolTipText("<html><head></head><body><table width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"0\"><tr>" +
							"<td width=\"25%\">&nbsp;</td><td width=\"25%\">&nbsp;</td><td colspan=\"2\" align=\"center\">Bina durumu katsayýsý</td></tr><tr>" +
							"<td align=\"center\">Bölgenin durumu</td><td align=\"center\">Binanýn durumu</td><td width=\"25%\" align=\"center\">Bitiþik nizam</td>" +
							"<td width=\"25%\" align=\"center\">Ayrýk nizam</td></tr><tr><td rowspan=\"3\" align=\"center\">Normal Bölge</td>" +
							"<td align=\"center\">Mahfuz</td><td align=\"center\">1.00</td><td align=\"center\">1.42</td></tr><tr><td align=\"center\">Serbest</td>" +
							"<td align=\"center\">1.72</td><td align=\"center\">2.43</td></tr><tr><td align=\"center\">Çok serbest</td><td align=\"center\">2.51</td>" +
							"<td align=\"center\">3.52</td></tr><tr><td rowspan=\"3\" align=\"center\">Rüzgarlý bölge</td><td align=\"center\">Mahfuz</td>" +
							"<td align=\"center\">1.72</td><td align=\"center\">2.43</td></tr><tr><td align=\"center\">Serbest</td><td align=\"center\">2.51</td>" +
							"<td align=\"center\">3.52</td></tr><tr><td align=\"center\">Çok serbest</td><td align=\"center\">2.60</td><td align=\"center\">4.73</td>" +
							"</tr></table></body></html>");
		}
		return binaKatsayisiPanel;
	}
	/**
	 * This method initializes jRadioButton37
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private javax.swing.JRadioButton getNormalBolgeDurumuRadioButton() {
		if(normalBolgeDurumuRadioButton == null) {
			normalBolgeDurumuRadioButton = new javax.swing.JRadioButton();
			normalBolgeDurumuRadioButton.setBounds(164, 26, 95, 21);
			normalBolgeDurumuRadioButton.setText("Normal");
			normalBolgeDurumuRadioButton.setSelected(true);
		}
		return normalBolgeDurumuRadioButton;
	}
	/**
	 * This method initializes jRadioButton38
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private javax.swing.JRadioButton getRuzgarliBolgeDurumuRadioButton() {
		if(ruzgarliBolgeDurumuRadioButton == null) {
			ruzgarliBolgeDurumuRadioButton = new javax.swing.JRadioButton();
			ruzgarliBolgeDurumuRadioButton.setBounds(283, 26, 95, 21);
			ruzgarliBolgeDurumuRadioButton.setText("Rüzgarlý");
		}
		return ruzgarliBolgeDurumuRadioButton;
	}
	/**
	 * This method initializes jRadioButton39
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private javax.swing.JRadioButton getMahfuzBinaDurumuRadioButton() {
		if(mahfuzBinaDurumuRadioButton == null) {
			mahfuzBinaDurumuRadioButton = new javax.swing.JRadioButton();
			mahfuzBinaDurumuRadioButton.setBounds(164, 57, 95, 21);
			mahfuzBinaDurumuRadioButton.setText("Mahfuz");
			mahfuzBinaDurumuRadioButton.setSelected(true);
		}
		return mahfuzBinaDurumuRadioButton;
	}
	/**
	 * This method initializes jRadioButton40
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private javax.swing.JRadioButton getSerbestBinaDurumuRadioButton() {
		if(serbestBinaDurumuRadioButton == null) {
			serbestBinaDurumuRadioButton = new javax.swing.JRadioButton();
			serbestBinaDurumuRadioButton.setBounds(283, 57, 95, 21);
			serbestBinaDurumuRadioButton.setText("Serbest");
		}
		return serbestBinaDurumuRadioButton;
	}
	/**
	 * This method initializes jRadioButton41
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private javax.swing.JRadioButton getCokSerbestBinaDurumuRadioButton() {
		if(cokSerbestBinaDurumuRadioButton == null) {
			cokSerbestBinaDurumuRadioButton = new javax.swing.JRadioButton();
			cokSerbestBinaDurumuRadioButton.setBounds(402, 57, 95, 21);
			cokSerbestBinaDurumuRadioButton.setText("Çok Serbest");
		}
		return cokSerbestBinaDurumuRadioButton;
	}
	/**
	 * This method initializes jLabel50
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel50() {
		if(jLabel50 == null) {
			jLabel50 = new javax.swing.JLabel();
			jLabel50.setBounds(31, 119, 101, 20);
			jLabel50.setText("                             H");
			jLabel50.setHorizontalTextPosition(javax.swing.SwingConstants.TRAILING);
		}
		return jLabel50;
	}
	/**
	 * This method initializes jRadioButton42
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private javax.swing.JRadioButton getBitisikNizamRadioButton() {
		if(bitisikNizamRadioButton == null) {
			bitisikNizamRadioButton = new javax.swing.JRadioButton();
			bitisikNizamRadioButton.setBounds(164, 88, 95, 21);
			bitisikNizamRadioButton.setText("Bitiþik");
			bitisikNizamRadioButton.setSelected(true);
		}
		return bitisikNizamRadioButton;
	}
	/**
	 * This method initializes jRadioButton43
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private javax.swing.JRadioButton getAyrikNizamRadioButton() {
		if(ayrikNizamRadioButton == null) {
			ayrikNizamRadioButton = new javax.swing.JRadioButton();
			ayrikNizamRadioButton.setBounds(283, 88, 95, 21);
			ayrikNizamRadioButton.setText("Ayrýk");
		}
		return ayrikNizamRadioButton;
	}
	/**
	 * This method initializes jTextField22
	 * 
	 * @return javax.swing.JTextField
	 */
	private javax.swing.JTextField getBinaKatsayisiTextField() {
		if(binaKatsayisiTextField == null) {
			binaKatsayisiTextField = new javax.swing.JTextField();
			binaKatsayisiTextField.setBounds(164, 119, 101, 20);
			binaKatsayisiTextField.setEnabled(true);
			binaKatsayisiTextField.setText("1.00");
			binaKatsayisiTextField.setEditable(false);
		}
		return binaKatsayisiTextField;
	}
	/**
	 * This method initializes jLabel47
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel472() {
		if(jLabel47 == null) {
			jLabel47 = new javax.swing.JLabel();
			jLabel47.setBounds(31, 26, 101, 20);
			jLabel47.setText("Bölgenin Durumu");
		}
		return jLabel47;
	}
	/**
	 * This method initializes jLabel48
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel48() {
		if(jLabel48 == null) {
			jLabel48 = new javax.swing.JLabel();
			jLabel48.setBounds(31, 57, 101, 20);
			jLabel48.setText("Binanýn Durumu");
		}
		return jLabel48;
	}
	/**
	 * This method initializes jLabel491
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel491() {
		if(jLabel491 == null) {
			jLabel491 = new javax.swing.JLabel();
			jLabel491.setBounds(31, 88, 101, 20);
			jLabel491.setText("Nizam");
		}
		return jLabel491;
	}
	/**
	 * This method initializes jPanel44
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getOdaDurumKatsayisiPanel() {
		if(odaDurumKatsayisiPanel == null) {
			odaDurumKatsayisiPanel = new javax.swing.JPanel();
			odaDurumKatsayisiPanel.setLayout(null);
			ButtonGroup group = new ButtonGroup();
			group.add(getOdaDurumKatsayisi07RadioButton());
			group.add(getOdaDurumKatsayisi09RadioButton());
			odaDurumKatsayisiPanel.add(getOdaDurumKatsayisi07RadioButton(), null);
			odaDurumKatsayisiPanel.add(getOdaDurumKatsayisi09RadioButton(), null);
			odaDurumKatsayisiPanel.setBounds(40, 176, 184, 58);
			odaDurumKatsayisiPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Oda durum katsayýsý (R)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12), java.awt.Color.black));
			odaDurumKatsayisiPanel.setToolTipText("<HTML>Bütün kapý ve pencerelerden odaya sýzýntý yoluyla giren hava " +
					"akýmýna oda durumunun gösterdiði direnci belirtir.<BR> Normal ebatta pencere ve kapýlarý olan " +
					"odalar için R=0.9<BR>Büyük pencereleri buna karþýlýk bir tek iç kapýsý olan odalar için R=0.7 </HTML>");
		}
		return odaDurumKatsayisiPanel;
	}
	/**
	 * This method initializes jRadioButton44
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private javax.swing.JRadioButton getOdaDurumKatsayisi07RadioButton() {
		if(odaDurumKatsayisi07RadioButton == null) {
			odaDurumKatsayisi07RadioButton = new javax.swing.JRadioButton();
			odaDurumKatsayisi07RadioButton.setBounds(18, 21, 64, 21);
			odaDurumKatsayisi07RadioButton.setText("0.7");
			odaDurumKatsayisi07RadioButton.setSelected(true);
		}
		return odaDurumKatsayisi07RadioButton;
	}
	/**
	 * This method initializes jRadioButton45
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private javax.swing.JRadioButton getOdaDurumKatsayisi09RadioButton() {
		if(odaDurumKatsayisi09RadioButton == null) {
			odaDurumKatsayisi09RadioButton = new javax.swing.JRadioButton();
			odaDurumKatsayisi09RadioButton.setBounds(100, 21, 64, 21);
			odaDurumKatsayisi09RadioButton.setText("0.9");
		}
		return odaDurumKatsayisi09RadioButton;
	}
	/**
	 * This method initializes jPanel45
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getSizdirganlikKatsayisiPanel() {
		if(sizdirganlikKatsayisiPanel == null) {
			sizdirganlikKatsayisiPanel = new javax.swing.JPanel();
			sizdirganlikKatsayisiPanel.setLayout(null);
			sizdirganlikKatsayisiPanel.add(getJLabel492(), null);
			sizdirganlikKatsayisiPanel.add(getJLabel493(), null);
			ButtonGroup malzemeTipleri = new ButtonGroup();
			malzemeTipleri.add(getAhsapMalzemeRadioButton());
			malzemeTipleri.add(getMetalMalzemeRadioButton());
			malzemeTipleri.add(getPlastikMalzemeRadioButton());
			ButtonGroup acilimTipleri = new ButtonGroup();
			acilimTipleri.add(getCiftAcilirliTipRadioButton());
			acilimTipleri.add(getCiftCamliTipRadioButton());
			acilimTipleri.add(getTekAcilirliTipRadioButton());
			sizdirganlikKatsayisiPanel.add(getAhsapMalzemeRadioButton(), null);
			sizdirganlikKatsayisiPanel.add(getPlastikMalzemeRadioButton(), null);
			sizdirganlikKatsayisiPanel.add(getMetalMalzemeRadioButton(), null);
			sizdirganlikKatsayisiPanel.add(getTekAcilirliTipRadioButton(), null);
			sizdirganlikKatsayisiPanel.add(getCiftCamliTipRadioButton(), null);
			sizdirganlikKatsayisiPanel.add(getCiftAcilirliTipRadioButton(), null);
			sizdirganlikKatsayisiPanel.add(getJLabel494(), null);
			sizdirganlikKatsayisiPanel.add(getSizdirganlikKatsayisiTextField(), null);
			sizdirganlikKatsayisiPanel.setBounds(40, 244, 564, 139);
			sizdirganlikKatsayisiPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sýzdýrganlýk Katsayýsý (a)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			sizdirganlikKatsayisiPanel.setToolTipText("Pencere veya kapý için");
		}
		return sizdirganlikKatsayisiPanel;
	}
	/**
	 * This method initializes jLabel492
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel492() {
		if(jLabel492 == null) {
			jLabel492 = new javax.swing.JLabel();
			jLabel492.setSize(101, 20);
			jLabel492.setText("Malzeme");
			jLabel492.setLocation(28, 34);
		}
		return jLabel492;
	}
	/**
	 * This method initializes jLabel493
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel493() {
		if(jLabel493 == null) {
			jLabel493 = new javax.swing.JLabel();
			jLabel493.setBounds(28, 69, 101, 20);
			jLabel493.setText("Tip");
		}
		return jLabel493;
	}
	/**
	 * This method initializes jRadioButton46
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private javax.swing.JRadioButton getAhsapMalzemeRadioButton() {
		if(ahsapMalzemeRadioButton == null) {
			ahsapMalzemeRadioButton = new javax.swing.JRadioButton();
			ahsapMalzemeRadioButton.setBounds(157, 34, 95, 21);
			ahsapMalzemeRadioButton.setText("Ahþap");
			ahsapMalzemeRadioButton.setSelected(true);
		}
		return ahsapMalzemeRadioButton;
	}
	/**
	 * This method initializes jRadioButton47
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private javax.swing.JRadioButton getPlastikMalzemeRadioButton() {
		if(plastikMalzemeRadioButton == null) {
			plastikMalzemeRadioButton = new javax.swing.JRadioButton();
			plastikMalzemeRadioButton.setBounds(280, 34, 95, 21);
			plastikMalzemeRadioButton.setText("Plastik");
		}
		return plastikMalzemeRadioButton;
	}
	/**
	 * This method initializes jRadioButton48
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private javax.swing.JRadioButton getMetalMalzemeRadioButton() {
		if(metalMalzemeRadioButton == null) {
			metalMalzemeRadioButton = new javax.swing.JRadioButton();
			metalMalzemeRadioButton.setBounds(403, 34, 95, 21);
			metalMalzemeRadioButton.setText("Metal");
		}
		return metalMalzemeRadioButton;
	}
	/**
	 * This method initializes jRadioButton49
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private javax.swing.JRadioButton getTekAcilirliTipRadioButton() {
		if(tekAcilirliTipRadioButton == null) {
			tekAcilirliTipRadioButton = new javax.swing.JRadioButton();
			tekAcilirliTipRadioButton.setSize(95, 21);
			tekAcilirliTipRadioButton.setText("Tek açýlýrlý");
			tekAcilirliTipRadioButton.setLocation(157, 69);
			tekAcilirliTipRadioButton.setSelected(true);
		}
		return tekAcilirliTipRadioButton;
	}
	/**
	 * This method initializes jRadioButton50
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private javax.swing.JRadioButton getCiftCamliTipRadioButton() {
		if(ciftCamliTipRadioButton == null) {
			ciftCamliTipRadioButton = new javax.swing.JRadioButton();
			ciftCamliTipRadioButton.setBounds(280, 69, 95, 21);
			ciftCamliTipRadioButton.setText("Çift camlý");
		}
		return ciftCamliTipRadioButton;
	}
	/**
	 * This method initializes jRadioButton51
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private javax.swing.JRadioButton getCiftAcilirliTipRadioButton() {
		if(ciftAcilirliTipRadioButton == null) {
			ciftAcilirliTipRadioButton = new javax.swing.JRadioButton();
			ciftAcilirliTipRadioButton.setBounds(403, 69, 95, 21);
			ciftAcilirliTipRadioButton.setText("Çift açýlýrlý");
		}
		return ciftAcilirliTipRadioButton;
	}
	/**
	 * This method initializes jLabel494
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel494() {
		if(jLabel494 == null) {
			jLabel494 = new javax.swing.JLabel();
			jLabel494.setBounds(28, 99, 101, 20);
			jLabel494.setText("                             a");
		}
		return jLabel494;
	}
	/**
	 * This method initializes jTextField23
	 * 
	 * @return javax.swing.JTextField
	 */
	private javax.swing.JTextField getSizdirganlikKatsayisiTextField() {
		if(sizdirganlikKatsayisiTextField == null) {
			sizdirganlikKatsayisiTextField = new javax.swing.JTextField();
			sizdirganlikKatsayisiTextField.setBounds(157, 99, 101, 20);
			sizdirganlikKatsayisiTextField.setEditable(false);
			sizdirganlikKatsayisiTextField.setText("3.0");
		}
		return sizdirganlikKatsayisiTextField;
	}
	/**
	 * This method initializes jPanel46
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getIsletmeTipiPanel() {
		if(isletmeTipiPanel == null) {
			isletmeTipiPanel = new javax.swing.JPanel();
			isletmeTipiPanel.setLayout(null);
			isletmeTipiPanel.setBounds(237, 176, 366, 58);
			isletmeTipiPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ýþletme Tipi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12), java.awt.Color.black));
			isletmeTipiPanel.setToolTipText("Ýþletme tipine göre artýrým katsaýlarý");
			ButtonGroup group = new ButtonGroup();
			group.add(getIsletme1RadioButton());
			group.add(getIsletme2RadioButton());
			group.add(getIsletme3RadioButton());
			isletmeTipiPanel.add(getIsletme1RadioButton(), null);
			isletmeTipiPanel.add(getIsletme2RadioButton(), null);
			isletmeTipiPanel.add(getIsletme3RadioButton(), null);
		}
		return isletmeTipiPanel;
	}
	/**
	 * This method initializes jPanel47
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getTesisatBilgileriPanel() {
		if(tesisatBilgileriPanel == null) {
			tesisatBilgileriPanel = new javax.swing.JPanel();
			tesisatBilgileriPanel.setLayout(null);
			tesisatBilgileriPanel.add(getCogunluklaKullanilanYapiElemanlariPanel(), null);
			tesisatBilgileriPanel.add(getRadyatorModeliPanel(), null);
		}
		return tesisatBilgileriPanel;
	}
	/**
	 * This method initializes jPanel48
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getCogunluklaKullanilanYapiElemanlariPanel() {
		if(cogunluklaKullanilanYapiElemanlariPanel == null) {
			cogunluklaKullanilanYapiElemanlariPanel = new javax.swing.JPanel();
			cogunluklaKullanilanYapiElemanlariPanel.setLayout(null);
			cogunluklaKullanilanYapiElemanlariPanel.add(getJLabel495(), null);
			cogunluklaKullanilanYapiElemanlariPanel.add(getJLabel496(), null);
			cogunluklaKullanilanYapiElemanlariPanel.add(getJLabel497(), null);
			cogunluklaKullanilanYapiElemanlariPanel.add(getJLabel498(), null);
			cogunluklaKullanilanYapiElemanlariPanel.add(getJLabel499(), null);
			cogunluklaKullanilanYapiElemanlariPanel.add(getDisDuvarTextField(), null);
			cogunluklaKullanilanYapiElemanlariPanel.add(getIcDuvarTextField(), null);
			cogunluklaKullanilanYapiElemanlariPanel.add(getPencereTextField(), null);
			cogunluklaKullanilanYapiElemanlariPanel.add(getDisKapiTextField(), null);
			cogunluklaKullanilanYapiElemanlariPanel.add(getÝcKapiTextField(), null);
			cogunluklaKullanilanYapiElemanlariPanel.add(getDisDuvarSecButton(), null);
			cogunluklaKullanilanYapiElemanlariPanel.add(getÝcDuvarSecButton(), null);
			cogunluklaKullanilanYapiElemanlariPanel.add(getPencereSecButton(), null);
			cogunluklaKullanilanYapiElemanlariPanel.add(getDisKapiSecButton(), null);
			cogunluklaKullanilanYapiElemanlariPanel.add(getÝcKapiSecButton(), null);
			cogunluklaKullanilanYapiElemanlariPanel.setBounds(33, 24, 300, 210);
			cogunluklaKullanilanYapiElemanlariPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Çoðunlukla kullanýlan yapý elemanlarý", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
		}
		return cogunluklaKullanilanYapiElemanlariPanel;
	}
	/**
	 * This method initializes jLabel495
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel495() {
		if(jLabel495 == null) {
			jLabel495 = new javax.swing.JLabel();
			jLabel495.setBounds(26, 32, 79, 24);
			jLabel495.setText("Dýþ duvar");
		}
		return jLabel495;
	}
	/**
	 * This method initializes jLabel496
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel496() {
		if(jLabel496 == null) {
			jLabel496 = new javax.swing.JLabel();
			jLabel496.setBounds(26, 66, 79, 24);
			jLabel496.setText("Ýç duvar");
		}
		return jLabel496;
	}
	/**
	 * This method initializes jLabel497
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel497() {
		if(jLabel497 == null) {
			jLabel497 = new javax.swing.JLabel();
			jLabel497.setBounds(26, 100, 79, 24);
			jLabel497.setText("Pencere");
		}
		return jLabel497;
	}
	/**
	 * This method initializes jLabel498
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel498() {
		if(jLabel498 == null) {
			jLabel498 = new javax.swing.JLabel();
			jLabel498.setBounds(26, 134, 79, 24);
			jLabel498.setText("Dýþ kapý");
		}
		return jLabel498;
	}
	/**
	 * This method initializes jLabel499
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel499() {
		if(jLabel499 == null) {
			jLabel499 = new javax.swing.JLabel();
			jLabel499.setBounds(26, 168, 79, 24);
			jLabel499.setText("Ýç kapý");
		}
		return jLabel499;
	}
	/**
	 * This method initializes jTextField28
	 * 
	 * @return javax.swing.JTextField
	 */
	private javax.swing.JTextField getDisDuvarTextField() {
		if(disDuvarTextField == null) {
			disDuvarTextField = new javax.swing.JTextField();
			disDuvarTextField.setBounds(124, 32, 85, 24);
		}
		return disDuvarTextField;
	}
	/**
	 * This method initializes jTextField29
	 * 
	 * @return javax.swing.JTextField
	 */
	private javax.swing.JTextField getIcDuvarTextField() {
		if(icDuvarTextField == null) {
			icDuvarTextField = new javax.swing.JTextField();
			icDuvarTextField.setBounds(123, 66, 86, 24);
		}
		return icDuvarTextField;
	}
	/**
	 * This method initializes jTextField30
	 * 
	 * @return javax.swing.JTextField
	 */
	private javax.swing.JTextField getPencereTextField() {
		if(pencereTextField == null) {
			pencereTextField = new javax.swing.JTextField();
			pencereTextField.setBounds(123, 100, 86, 24);
		}
		return pencereTextField;
	}
	/**
	 * This method initializes jTextField31
	 * 
	 * @return javax.swing.JTextField
	 */
	private javax.swing.JTextField getDisKapiTextField() {
		if(disKapiTextField == null) {
			disKapiTextField = new javax.swing.JTextField();
			disKapiTextField.setBounds(122, 134, 89, 24);
		}
		return disKapiTextField;
	}
	/**
	 * This method initializes jTextField32
	 * 
	 * @return javax.swing.JTextField
	 */
	private javax.swing.JTextField getÝcKapiTextField() {
		if(icKapiTextField == null) {
			icKapiTextField = new javax.swing.JTextField();
			icKapiTextField.setBounds(121, 168, 90, 24);
		}
		return icKapiTextField;
	}
	/**
	 * This method initializes jButton4
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getDisDuvarSecButton() {
		if(disDuvarSecButton == null) {
			disDuvarSecButton = new javax.swing.JButton();
			disDuvarSecButton.setBounds(228, 32, 39, 24);
			disDuvarSecButton.setText("...");
			disDuvarSecButton.setActionCommand("Dis Duvar");
		}
		return disDuvarSecButton;
	}
	/**
	 * This method initializes jButton5
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getÝcDuvarSecButton() {
		if(icDuvarSecButton == null) {
			icDuvarSecButton = new javax.swing.JButton();
			icDuvarSecButton.setBounds(228, 66, 39, 24);
			icDuvarSecButton.setText("...");
			icDuvarSecButton.setActionCommand("Ic Duvar");
		}
		return icDuvarSecButton;
	}
	/**
	 * This method initializes jButton6
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getPencereSecButton() {
		if(pencereSecButton == null) {
			pencereSecButton = new javax.swing.JButton();
			pencereSecButton.setBounds(228, 100, 39, 24);
			pencereSecButton.setText("...");
			pencereSecButton.setActionCommand("Pencere");
		}
		return pencereSecButton;
	}
	/**
	 * This method initializes jButton7
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getDisKapiSecButton() {
		if(disKapiSecButton == null) {
			disKapiSecButton = new javax.swing.JButton();
			disKapiSecButton.setBounds(228, 134, 39, 24);
			disKapiSecButton.setText("...");
			disKapiSecButton.setActionCommand("Dis Kapi");
		}
		return disKapiSecButton;
	}
	/**
	 * This method initializes jButton8
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getÝcKapiSecButton() {
		if(icKapiSecButton == null) {
			icKapiSecButton = new javax.swing.JButton();
			icKapiSecButton.setBounds(228, 168, 39, 24);
			icKapiSecButton.setText("...");
			icKapiSecButton.setActionCommand("Ic Kapi");
		}
		return icKapiSecButton;
	}
	/**
	 * This method initializes jPanel49
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getRadyatorModeliPanel() {
		if(radyatorModeliPanel == null) {
			radyatorModeliPanel = new javax.swing.JPanel();
			radyatorModeliPanel.setLayout(null);
			ButtonGroup group = new ButtonGroup();
			group.add(getKazanIsiticiTuruRadioButton());
			group.add(getKombiIsiticiTuruRadioButton());
			radyatorModeliPanel.add(getJLabel4910(), null);
			radyatorModeliPanel.add(getRadyatorModeliTextField(), null);
			radyatorModeliPanel.add(getRadyatorModeliSecButton(), null);
			radyatorModeliPanel.add(getJLabel4911(), null);
			radyatorModeliPanel.add(getÝsitmaSistemiComboBox(), null);
			radyatorModeliPanel.add(getJLabel4912(), null);
			radyatorModeliPanel.add(getKazanIsiticiTuruRadioButton(), null);
			radyatorModeliPanel.add(getKombiIsiticiTuruRadioButton(), null);
			radyatorModeliPanel.setBounds(241, 249, 351, 176);
			radyatorModeliPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
		}
		return radyatorModeliPanel;
	}
	/**
	 * This method initializes jLabel4910
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel4910() {
		if(jLabel4910 == null) {
			jLabel4910 = new javax.swing.JLabel();
			jLabel4910.setSize(93, 24);
			jLabel4910.setText("Radyatör modeli");
			jLabel4910.setLocation(21, 20);
		}
		return jLabel4910;
	}
	/**
	 * This method initializes jTextField33
	 * 
	 * @return javax.swing.JTextField
	 */
	private javax.swing.JTextField getRadyatorModeliTextField() {
		if(radyatorModeliTextField == null) {
			radyatorModeliTextField = new javax.swing.JTextField();
			radyatorModeliTextField.setSize(90, 24);
			radyatorModeliTextField.setLocation(128, 20);
		}
		return radyatorModeliTextField;
	}
	/**
	 * This method initializes jButton9
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getRadyatorModeliSecButton() {
		if(radyatorModeliSecButton == null) {
			radyatorModeliSecButton = new javax.swing.JButton();
			radyatorModeliSecButton.setSize(39, 24);
			radyatorModeliSecButton.setLocation(233, 20);
			radyatorModeliSecButton.setText("...");
		}
		return radyatorModeliSecButton;
	}
	/**
	 * This method initializes jLabel4911
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel4911() {
		if(jLabel4911 == null) {
			jLabel4911 = new javax.swing.JLabel();
			jLabel4911.setBounds(21, 56, 93, 24);
			jLabel4911.setText("Isýtma sistemi");
		}
		return jLabel4911;
	}
	/**
	 * This method initializes jComboBox
	 * 
	 * @return javax.swing.JComboBox
	 */
	private javax.swing.JComboBox getÝsitmaSistemiComboBox() {
		if(isitmaSistemiComboBox == null) {
			isitmaSistemiComboBox = new javax.swing.JComboBox();
			isitmaSistemiComboBox.setBounds(128, 56, 90, 24);
			isitmaSistemiComboBox.addItem("90/70");
			isitmaSistemiComboBox.addItem("70/50");
			isitmaSistemiComboBox.addItem("50/40");
			isitmaSistemiComboBox.addItem("40/30");
		}
		return isitmaSistemiComboBox;
	}
	/**
	 * This method initializes jLabel4912
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel4912() {
		if(jLabel4912 == null) {
			jLabel4912 = new javax.swing.JLabel();
			jLabel4912.setBounds(21, 91, 93, 24);
			jLabel4912.setText("Kazan türü");
		}
		return jLabel4912;
	}
	/**
	 * This method initializes jRadioButton52
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private javax.swing.JRadioButton getKazanIsiticiTuruRadioButton() {
		if(kazanIsiticiTuruRadioButton == null) {
			kazanIsiticiTuruRadioButton = new javax.swing.JRadioButton();
			kazanIsiticiTuruRadioButton.setBounds(128, 93, 60, 21);
			kazanIsiticiTuruRadioButton.setText("Kazan");
			kazanIsiticiTuruRadioButton.setSelected(true);
		}
		return kazanIsiticiTuruRadioButton;
	}
	/**
	 * This method initializes jRadioButton53
	 * 
	 * @return javax.swing.JRadioButton
	 */
	private javax.swing.JRadioButton getKombiIsiticiTuruRadioButton() {
		if(kombiIsiticiTuruRadioButton == null) {
			kombiIsiticiTuruRadioButton = new javax.swing.JRadioButton();
			kombiIsiticiTuruRadioButton.setBounds(128, 122, 148, 21);
			kombiIsiticiTuruRadioButton.setText("Kombi / Kat kaloriferi");
		}
		return kombiIsiticiTuruRadioButton;
	}
	
	public JDialog showMekanikHavalandirmaDialog(){
        MekanikHavalandirmaDialog dialog = new MekanikHavalandirmaDialog();
		dialog.setSize(600,600);
		Dimension dim = getToolkit().getScreenSize();
		dialog.setLocation((dim.width-600)/2,(dim.height-600)/2);
		dialog.setTitle("Mekanik havalandýrma bilgileri");

        dialog.setVisible(true);
        return dialog;
	}
	
	/**
	 * This method initializes pencereAlanTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getPencereAlanTextField() {
		if (pencereAlanTextField == null) {
			pencereAlanTextField = new JTextField();
			pencereAlanTextField.setLocation(218, 48);
			pencereAlanTextField.setSize(98, 24);
		}
		return pencereAlanTextField;
	}
	/**
	 * This method initializes pencereUTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getPencereUTextField() {
		if (pencereUTextField == null) {
			pencereUTextField = new JTextField();
			pencereUTextField.setLocation(218, 95);
			pencereUTextField.setSize(98, 24);
		}
		return pencereUTextField;
	}
	/**
	 * This method initializes jEditorPane	
	 * 	
	 * @return javax.swing.JEditorPane	
	 */    
	private JEditorPane getJEditorPane() {
		if (jEditorPane == null) {
			jEditorPane = new JEditorPane();
			jEditorPane.setEditable(false);
			jEditorPane.setContentType("text/html");
			try {
                jEditorPane.setPage(getClass().getResource("camlar.htm"));
            } catch (IOException e) {
                e.printStackTrace();
            }
		}
		return jEditorPane;
	}
	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */    
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getJEditorPane());
			jScrollPane.setLocation(5, 134);
			jScrollPane.setSize(440, 320);
		}
		return jScrollPane;
	}

	
	//********************************************************************************************************
	// MVP Methods *******************************************************************************************
	//********************************************************************************************************

	public void addPropertyChangeListener (	PropertyChangeListener listener){
		propertySupport.addPropertyChangeListener (listener);
	}

	public void removePropertyChangeListener (PropertyChangeListener listener){
		propertySupport.removePropertyChangeListener (listener);
	}
			
	public void setProjeAdiTextFieldText(String projeAdi){
		getProjeAdiTextField().setText(projeAdi);
	}
	
	public String getProjeAdiTextFieldText(){
		return getProjeAdiTextField().getText();
	}

	public void addProjeAdiTextFieldFocusListener(FocusListener listener){
		getProjeAdiTextField().addFocusListener(listener);
	}

	public void setMuhendisAdTextFieldText(String muhendisAdi){
		getMuhendisAdTextField().setText(muhendisAdi);
	}
	
	public String getMuhendisAdTextFieldText(){
		return getMuhendisAdTextField().getText();
	}

	public void addMuhendisAdTextFieldFocusListener(FocusListener listener){
		getMuhendisAdTextField().addFocusListener(listener);
	}

	public void setMuhendisUnvanTextFieldText(String muhendisUnvani){
		getMuhendisUnvanTextField().setText(muhendisUnvani);
	}
	
	public String getMuhendisUnvanTextFieldText(){
		return getMuhendisUnvanTextField().getText();
	}

	public void addMuhendisUnvanTextFieldFocusListener(FocusListener listener){
		getMuhendisUnvanTextField().addFocusListener(listener);
	}

	public void setMuhendisSicilTextFieldText(String muhendisSicili){
		getMuhendisSicilTextField().setText(muhendisSicili);
	}
	
	public String getMuhendisSicilTextFieldText(){
		return getMuhendisSicilTextField().getText();
	}

	public void addMuhendisSicilTextFieldFocusListener(FocusListener listener){
		getMuhendisSicilTextField().addFocusListener(listener);
	}

	public void setAdaParselTextFieldText(String adaParseli){
		getAdaParselTextField().setText(adaParseli);
	}
	
	public String getAdaParselTextFieldText(){
		return getAdaParselTextField().getText();
	}

	public void addAdaParselTextFieldFocusListener(FocusListener listener){
		getAdaParselTextField().addFocusListener(listener);
	}

	public void setBinaTanimTextFieldText(String binaTanimi){
		getBinaTanimTextField().setText(binaTanimi);
	}
	
	public String getBinaTanimTextFieldText(){
		return getBinaTanimTextField().getText();
	}

	public void addBinaTanimTextFieldFocusListener(FocusListener listener){
		getBinaTanimTextField().addFocusListener(listener);
	}

	public void setCaddeTextFieldText(String cadde){
		getCaddeTextField().setText(cadde);
	}
	
	public String getCaddeTextFieldText(){
		return getCaddeTextField().getText();
	}

	public void addCaddeTextFieldFocusListener(FocusListener listener){
		getCaddeTextField().addFocusListener(listener);
	}

	public void setIlIlceTextFieldText(String ilIlce){
		getIlIlceTextField().setText(ilIlce);
	}
	
	public String getIlIlceTextFieldText(){
		return getIlIlceTextField().getText();
	}

	public void addIlIlceTextFieldFocusListener(FocusListener listener){
		getIlIlceTextField().addFocusListener(listener);
	}

	public void setYakitTextFieldText(String yakiti){
		getYakitTextField().setText(yakiti);
	}
	
	public String getYakitTextFieldText(){
		return getYakitTextField().getText();
	}

	public void addYakitTextFieldFocusListener(FocusListener listener){
		getYakitTextField().addFocusListener(listener);
	}
	
	public void setIllerListModel(ListModel model){
		getIllerList().setModel(model);
	}

    public void addHaritaLabelMouseListener(MouseAdapter adapter) {        
        getHaritaLabel().addMouseListener(adapter);
    }
    
    public void setIllerListSetSelected(Object il){
        getIllerList().setSelectedValue(il,true);
    }
    
    public void setSecilenIlLabelText(String secilenIlBilgisi){
        getSecilenIlLabel().setText(secilenIlBilgisi);
    }

    public void addIllerListSelectionListener(ListSelectionListener listener) {
        getIllerList().addListSelectionListener(listener);        
    }
    
    public void setKonutRadioButtonActionCommand(String actionCommand){
    	getKonutRadioButton().setActionCommand(actionCommand);
    }
    
    public void setEnerjiRadioButtonActionCommand(String actionCommand){
    	getEnerjiRadioButton().setActionCommand(actionCommand);
    }

	public void addKonutRadioButtonActionListener(ActionListener radioButtonActionListener) {
		getKonutRadioButton().addActionListener(radioButtonActionListener);
	}

	public void addEnerjiRadioButtonActionListener(ActionListener radioButtonActionListener) {
		getEnerjiRadioButton().addActionListener(radioButtonActionListener);
	}

	public void setEsit26RadioButtonActionCommand(String string) {
		getEsit26RadioButton().setActionCommand(string);
	}

	public void setYuksek26RadioButtonActionCommand(String string) {
		getYuksek26RadioButton().setActionCommand(string);
	}

	public void addEsit26RadioButtonActionListener(ActionListener radioButtonActionListener) {
		getEsit26RadioButton().addActionListener(radioButtonActionListener);
	}

	public void addYuksek26RadioButtonActionListener(ActionListener radioButtonActionListener) {
		getYuksek26RadioButton().addActionListener(radioButtonActionListener);
	}

	public void setAyrikRadioButtonActionCommand(String string) {
		getAyrikRadioButton().setActionCommand(string);
	}

	public void addAyrikRadioButtonActionListener(ActionListener radioButtonActionListener) {
		getAyrikRadioButton().addActionListener(radioButtonActionListener);
	}

	public void setMahfuzRadioButtonActionCommand(String string) {
		getMahfuzRadioButton().setActionCommand(string);
	}

	public void addMahfuzRadioButtonActionListener(ActionListener radioButtonActionListener) {
		getMahfuzRadioButton().addActionListener(radioButtonActionListener);
	}

	public void setBitisikRadioButtonActionCommand(String string) {
		getBitisikRadioButton().setActionCommand(string);
	}

	public void addBitisikRadioButtonActionListener(ActionListener radioButtonActionListener) {
		getBitisikRadioButton().addActionListener(radioButtonActionListener);
	}

	public void setMekanikRadioButtonActionCommand(String string) {
		getMekanikRadioButton().setActionCommand(string);
	}

	public void addMekanikRadioButtonActionListener(ActionListener radioButtonActionListener) {
		getMekanikRadioButton().addActionListener(radioButtonActionListener);
	}

	public void setDogalRadioButtonActionCommand(String string) {
		getDogalRadioButton().setActionCommand(string);
	}

	public void addDogalRadioButtonActionListener(ActionListener radioButtonActionListener) {
		getDogalRadioButton().addActionListener(radioButtonActionListener);
	}
	
	public void addHavalandirmaSecButtonActionListener(ActionListener listener) {
		getHavalandirmaSecButton().addActionListener(listener);
	}

	public void setHavalandirmaSecButtonEnabled(boolean state) {
		getHavalandirmaSecButton().setEnabled(state);
	}

	public void addDisDuvarEkleButtonActionListener(ActionListener listener) {
		getDisDuvarEkleButton().addActionListener(listener);		
	}

	public DefaultListModel getDisDuvarlarListModel() {
		return (DefaultListModel) getDisDuvarlarList().getModel();
	}

	public void setDisDuvarModelTableModel(DefaultTableModel tableModel) {
		getDisDuvarModelTable().setModel(tableModel);
	}
	
	public DefaultTableModel getDisDuvarModelTableModel(){
		return (DefaultTableModel) getDisDuvarModelTable().getModel();
	}

	public void setDisDuvarModelTableColumnWidths() {
		TableColumn column = getDisDuvarModelTable().getColumnModel().getColumn(0);
		column.setPreferredWidth(10);
	}
	/**
	 * This method initializes disDuvarBilesenEkleButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getDisDuvarBilesenEkleButton() {
		if (disDuvarBilesenEkleButton == null) {
			disDuvarBilesenEkleButton = new JButton();
			disDuvarBilesenEkleButton.setLocation(107, 274);
			disDuvarBilesenEkleButton.setSize(110, 24);
			disDuvarBilesenEkleButton.setText("Bileþen Ekle");
		}
		return disDuvarBilesenEkleButton;
	}
	
	private JButton getDisDuvarBilesenCikarButton() {
		if (disDuvarBilesenCikarButton == null) {
			disDuvarBilesenCikarButton = new JButton();
			disDuvarBilesenCikarButton.setLocation(240, 274);
			disDuvarBilesenCikarButton.setSize(110, 24);
			disDuvarBilesenCikarButton.setText("Bileþen Çýkar");
		}
		return disDuvarBilesenCikarButton;
	}
	
	public JDialog showBilesenEkleDialog(DefaultTreeModel treeModel) {
        BilesenEkleDialog dialog = new BilesenEkleDialog();
        dialog.setMalzemeTreeModel(treeModel);
		dialog.setSize(600,600);
		Dimension dim = getToolkit().getScreenSize();
		dialog.setLocation((dim.width-600)/2,(dim.height-600)/2);
		dialog.setTitle("Bileþen seçiniz");
        dialog.setVisible(true);
        return dialog;
	}

	public void addDisDuvarBilesenEkleActionListener(ActionListener listener) {
		getDisDuvarBilesenEkleButton().addActionListener(listener);
	}

	public void addDisDuvarListListSelectionListener(ListSelectionListener listener) {
		getDisDuvarlarList().addListSelectionListener(listener);
	}

	public String getDisDuvarListSelectedValue() {
		return (String)getDisDuvarlarList().getSelectedValue();
	}

	public void setDisDuvarSelectedElement(String identifier) {
		getDisDuvarlarList().setSelectedValue(identifier,true);
	}

	public void addDisDuvarModelTableModelListener(TableModelListener listener) {
		getDisDuvarModelTable().getModel().addTableModelListener(listener);
	}

	public void addDisDuvarBilesenCikarButtonActionListener(ActionListener listener) {
		getDisDuvarBilesenCikarButton().addActionListener(listener);
	}

	public void removeDisDuvarModelTableSelectedRow() {
		int selectedRow = getDisDuvarModelTable().getSelectedRow();
		if(selectedRow!=-1)getDisDuvarModelTableModel().removeRow(selectedRow);
	}

	public void addDisDuvarCikarButtonActionListener(ActionListener listener) {
		getDisDuvarCikarButton().addActionListener(listener);
	}

	public void removeDuvarFromList(String disDuvarListSelectedValue) {
		getDisDuvarlarListModel().removeElement(disDuvarListSelectedValue);
	}

	public String getDisDuvarAlanTextFieldText(){
		return getDisDuvarAlanTextField().getText();
	}
	
	public void setDisDuvarAlanTextFieldText(String disDuvarAlani){
		getDisDuvarAlanTextField().setText(disDuvarAlani);
	}

	public void addDisDuvarAlaniTextFieldActionListener(FocusAdapter adapter) {
		getDisDuvarAlanTextField().addFocusListener(adapter);		
	}
	
	public void setDisDuvarUTextFieldText(String uDegeri){
		getDisDuvarUTextField().setText(uDegeri);
	}

	public void setToplamAlanTextFieldText(double d) {
		getToplamAlanTextField().setText(""+twoDigits.format(d));
	}

	public void addDisDuvarAlaniTextFieldKeyListener(KeyListener listener) {
		getDisDuvarAlanTextField().addKeyListener(listener);
	}

	public void removeFocusFromDisDuvarAlanTextField() {
		getDisDuvarAlanTextField().transferFocus();
	}

	public void removeFocusFromAlanHacimOraniTextField() {
		getAlanHacimOraniTextField().transferFocus();
	}

	public String getBrutHacimTextFieldText(){
		return getBrutHacimTextField().getText();
	}
	
	public void setBrutHacimTextFieldText(String text){
		getBrutHacimTextField().setText(text);
	}

	public void addBrutHacimTextFieldFocusListener(FocusAdapter adapter) {
		getBrutHacimTextField().addFocusListener(adapter);
	}

	public void setAlanHacimOraniTextFieldText(String string) {
		getAlanHacimOraniTextField().setText(string);
	}

	public void addBrutHacimTextFieldKeyListener(KeyListener listener) {
		getBrutHacimTextField().addKeyListener(listener);
	}

	public void addIcOrtamSicakligiTextFieldFocusListener(FocusAdapter adapter) {
		getIcOrtamSicakligiTextField().addFocusListener(adapter);
	}

	public void addIcOrtamSicakligiTextFieldKeyListener(KeyAdapter adapter) {
		getIcOrtamSicakligiTextField().addKeyListener(adapter);
	}

	public String getIcOrtamSicakligiTextFieldText() {
		return getIcOrtamSicakligiTextField().getText();
	}

	public void removeFocusFromIcOrtamSicakligiTextField() {
		getIcOrtamSicakligiTextField().transferFocus();
	}

	/**
	 * This method initializes isitilmayanDuvarModelTable	
	 * 	
	 * @return javax.swing.JTable	
	 */    
	private JTable getIsitilmayanDuvarModelTable() {
		if (isitilmayanDuvarModelTable == null) {
			isitilmayanDuvarModelTable = new JTable();
		}
		return isitilmayanDuvarModelTable;
	}
	/**
	 * This method initializes isitilmayanDuvarModelScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */    
	private JScrollPane getIsitilmayanDuvarModelScrollPane() {
		if (isitilmayanDuvarModelScrollPane == null) {
			isitilmayanDuvarModelScrollPane = new JScrollPane();
			isitilmayanDuvarModelScrollPane.setViewportView(getIsitilmayanDuvarModelTable());
			isitilmayanDuvarModelScrollPane.setLocation(25, 68);
			isitilmayanDuvarModelScrollPane.setSize(403, 99);
		}
		return isitilmayanDuvarModelScrollPane;
	}
	/**
	 * This method initializes isitilmayanDuvarBilesenEkleButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getIsitilmayanDuvarBilesenEkleButton() {
		if (isitilmayanDuvarBilesenEkleButton == null) {
			isitilmayanDuvarBilesenEkleButton = new JButton();
			isitilmayanDuvarBilesenEkleButton.setLocation(107, 186);
			isitilmayanDuvarBilesenEkleButton.setSize(110, 24);
			isitilmayanDuvarBilesenEkleButton.setText("Bileþen Ekle");
		}
		return isitilmayanDuvarBilesenEkleButton;
	}
	/**
	 * This method initializes isitilmayanDuvarBilesenCikarButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getIsitilmayanDuvarBilesenCikarButton() {
		if (isitilmayanDuvarBilesenCikarButton == null) {
			isitilmayanDuvarBilesenCikarButton = new JButton();
			isitilmayanDuvarBilesenCikarButton.setSize(110, 24);
			isitilmayanDuvarBilesenCikarButton.setLocation(240, 186);
			isitilmayanDuvarBilesenCikarButton.setText("Bileþen Çýkar");
		}
		return isitilmayanDuvarBilesenCikarButton;
	}
	/**
	 * This method initializes isitilmayanDuvarAlanTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getIsitilmayanDuvarAlanTextField() {
		if (isitilmayanDuvarAlanTextField == null) {
			isitilmayanDuvarAlanTextField = new JTextField();
			isitilmayanDuvarAlanTextField.setLocation(193, 243);
			isitilmayanDuvarAlanTextField.setSize(98, 24);
		}
		return isitilmayanDuvarAlanTextField;
	}
	/**
	 * This method initializes isitilmayanDuvarUTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getIsitilmayanDuvarUTextField() {
		if (isitilmayanDuvarUTextField == null) {
			isitilmayanDuvarUTextField = new JTextField();
			isitilmayanDuvarUTextField.setLocation(193, 289);
			isitilmayanDuvarUTextField.setSize(98, 24);
			isitilmayanDuvarUTextField.setEnabled(true);
			isitilmayanDuvarUTextField.setEditable(false);
		}
		return isitilmayanDuvarUTextField;
	}

	public void addIsitilmayanDuvarBilesenEkleActionListener(ActionListener listener) {
		getIsitilmayanDuvarBilesenEkleButton().addActionListener(listener);
	}

	public DefaultTableModel getIsitilmayanDuvarModelTableModel() {
		return (DefaultTableModel)getIsitilmayanDuvarModelTable().getModel();
	}

	public void setIsitilmayanDuvarUTextFieldText(String string) {
		getIsitilmayanDuvarUTextField().setText(string);
	}

	public void addIsitilmayanDuvarModelTableModelListener(TableModelListener listener) {
		getIsitilmayanDuvarModelTable().getModel().addTableModelListener(listener);
	}

	public void setIsitilmayanDuvarModelTableModel(DefaultTableModel tableModel) {
		getIsitilmayanDuvarModelTable().setModel(tableModel);
	}

	public void setIsitilmayanDuvarModelTableColumnWidths() {
		TableColumn column = getIsitilmayanDuvarModelTable().getColumnModel().getColumn(0);
		column.setPreferredWidth(10);
	}
	
	/**
	 * This method initializes topragaTemasliDuvarTable	
	 * 	
	 * @return javax.swing.JTable	
	 */    
	private JTable getTopragaTemasliDuvarTable() {
		if (topragaTemasliDuvarTable == null) {
			topragaTemasliDuvarTable = new JTable();
		}
		return topragaTemasliDuvarTable;
	}
	/**
	 * This method initializes topragaTemasliDuvarScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */    
	private JScrollPane getTopragaTemasliDuvarScrollPane() {
		if (topragaTemasliDuvarScrollPane == null) {
			topragaTemasliDuvarScrollPane = new JScrollPane();
			topragaTemasliDuvarScrollPane.setViewportView(getTopragaTemasliDuvarTable());
			topragaTemasliDuvarScrollPane.setLocation(25, 68);
			topragaTemasliDuvarScrollPane.setSize(403, 99);
		}
		return topragaTemasliDuvarScrollPane;
	}
	/**
	 * This method initializes topragaTemasliDuvarBilesenEkleButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getTopragaTemasliDuvarBilesenEkleButton() {
		if (topragaTemasliDuvarBilesenEkleButton == null) {
			topragaTemasliDuvarBilesenEkleButton = new JButton();
			topragaTemasliDuvarBilesenEkleButton.setLocation(107, 186);
			topragaTemasliDuvarBilesenEkleButton.setSize(110, 24);
			topragaTemasliDuvarBilesenEkleButton.setText("Bileþen Ekle");
		}
		return topragaTemasliDuvarBilesenEkleButton;
	}
	/**
	 * This method initializes topragaTemasliDuvarBilesenCikarButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getTopragaTemasliDuvarBilesenCikarButton() {
		if (topragaTemasliDuvarBilesenCikarButton == null) {
			topragaTemasliDuvarBilesenCikarButton = new JButton();
			topragaTemasliDuvarBilesenCikarButton.setLocation(240, 186);
			topragaTemasliDuvarBilesenCikarButton.setSize(110, 24);
			topragaTemasliDuvarBilesenCikarButton.setText("Bileþen Çýkar");
		}
		return topragaTemasliDuvarBilesenCikarButton;
	}
	/**
	 * This method initializes topragaTemasliDuvarAlanTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getTopragaTemasliDuvarAlanTextField() {
		if (topragaTemasliDuvarAlanTextField == null) {
			topragaTemasliDuvarAlanTextField = new JTextField();
			topragaTemasliDuvarAlanTextField.setLocation(193, 243);
			topragaTemasliDuvarAlanTextField.setSize(98, 24);
		}
		return topragaTemasliDuvarAlanTextField;
	}
	/**
	 * This method initializes topragaTemasliDuvarUTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getTopragaTemasliDuvarUTextField() {
		if (topragaTemasliDuvarUTextField == null) {
			topragaTemasliDuvarUTextField = new JTextField();
			topragaTemasliDuvarUTextField.setLocation(193, 289);
			topragaTemasliDuvarUTextField.setSize(98, 24);
			topragaTemasliDuvarUTextField.setEnabled(true);
			topragaTemasliDuvarUTextField.setEditable(false);
		}
		return topragaTemasliDuvarUTextField;
	}
	/**
	 * This method initializes uzeriAcikTavanTable	
	 * 	
	 * @return javax.swing.JTable	
	 */    
	private JTable getUzeriAcikTavanTable() {
		if (uzeriAcikTavanTable == null) {
			uzeriAcikTavanTable = new JTable();
		}
		return uzeriAcikTavanTable;
	}
	/**
	 * This method initializes uzeriAcikTavanScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */    
	private JScrollPane getUzeriAcikTavanScrollPane() {
		if (uzeriAcikTavanScrollPane == null) {
			uzeriAcikTavanScrollPane = new JScrollPane();
			uzeriAcikTavanScrollPane.setViewportView(getUzeriAcikTavanTable());
			uzeriAcikTavanScrollPane.setLocation(25, 68);
			uzeriAcikTavanScrollPane.setSize(403, 99);
		}
		return uzeriAcikTavanScrollPane;
	}
	/**
	 * This method initializes catiliTavanTable	
	 * 	
	 * @return javax.swing.JTable	
	 */    
	private JTable getCatiliTavanTable() {
		if (catiliTavanTable == null) {
			catiliTavanTable = new JTable();
		}
		return catiliTavanTable;
	}
	/**
	 * This method initializes catiliTavanScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */    
	private JScrollPane getCatiliTavanScrollPane() {
		if (catiliTavanScrollPane == null) {
			catiliTavanScrollPane = new JScrollPane();
			catiliTavanScrollPane.setViewportView(getCatiliTavanTable());
			catiliTavanScrollPane.setLocation(25, 68);
			catiliTavanScrollPane.setSize(403, 99);
		}
		return catiliTavanScrollPane;
	}
	/**
	 * This method initializes topragaTemasliTabanTable	
	 * 	
	 * @return javax.swing.JTable	
	 */    
	private JTable getTopragaTemasliTabanTable() {
		if (topragaTemasliTabanTable == null) {
			topragaTemasliTabanTable = new JTable();
		}
		return topragaTemasliTabanTable;
	}
	/**
	 * This method initializes topragaTemasliTabanScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */    
	private JScrollPane getTopragaTemasliTabanScrollPane() {
		if (topragaTemasliTabanScrollPane == null) {
			topragaTemasliTabanScrollPane = new JScrollPane();
			topragaTemasliTabanScrollPane.setViewportView(getTopragaTemasliTabanTable());
			topragaTemasliTabanScrollPane.setLocation(25, 68);
			topragaTemasliTabanScrollPane.setSize(403, 99);
		}
		return topragaTemasliTabanScrollPane;
	}
	/**
	 * This method initializes isitilmayanTabanTable	
	 * 	
	 * @return javax.swing.JTable	
	 */    
	private JTable getIsitilmayanTabanTable() {
		if (isitilmayanTabanTable == null) {
			isitilmayanTabanTable = new JTable();
		}
		return isitilmayanTabanTable;
	}
	/**
	 * This method initializes isitilmayanTabanScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */    
	private JScrollPane getIsitilmayanTabanScrollPane() {
		if (isitilmayanTabanScrollPane == null) {
			isitilmayanTabanScrollPane = new JScrollPane();
			isitilmayanTabanScrollPane.setViewportView(getIsitilmayanTabanTable());
			isitilmayanTabanScrollPane.setLocation(25, 68);
			isitilmayanTabanScrollPane.setSize(403, 99);
		}
		return isitilmayanTabanScrollPane;
	}
	/**
	 * This method initializes acikGecitUzeriTable	
	 * 	
	 * @return javax.swing.JTable	
	 */    
	private JTable getAcikGecitUzeriTable() {
		if (acikGecitUzeriTable == null) {
			acikGecitUzeriTable = new JTable();
		}
		return acikGecitUzeriTable;
	}
	/**
	 * This method initializes acikGecitUzeriScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */    
	private JScrollPane getAcikGecitUzeriScrollPane() {
		if (acikGecitUzeriScrollPane == null) {
			acikGecitUzeriScrollPane = new JScrollPane();
			acikGecitUzeriScrollPane.setViewportView(getAcikGecitUzeriTable());
			acikGecitUzeriScrollPane.setLocation(25, 68);
			acikGecitUzeriScrollPane.setSize(403, 99);
		}
		return acikGecitUzeriScrollPane;
	}
	/**
	 * This method initializes uzeriAcikTavanBilesenEkleButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getUzeriAcikTavanBilesenEkleButton() {
		if (uzeriAcikTavanBilesenEkleButton == null) {
			uzeriAcikTavanBilesenEkleButton = new JButton();
			uzeriAcikTavanBilesenEkleButton.setLocation(107, 186);
			uzeriAcikTavanBilesenEkleButton.setSize(110, 24);
			uzeriAcikTavanBilesenEkleButton.setText("Bileþen Ekle");
		}
		return uzeriAcikTavanBilesenEkleButton;
	}
	/**
	 * This method initializes catiliTavanBilesenEkleButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getCatiliTavanBilesenEkleButton() {
		if (catiliTavanBilesenEkleButton == null) {
			catiliTavanBilesenEkleButton = new JButton();
			catiliTavanBilesenEkleButton.setLocation(107, 186);
			catiliTavanBilesenEkleButton.setSize(110, 24);
			catiliTavanBilesenEkleButton.setText("Bileþen Ekle");
		}
		return catiliTavanBilesenEkleButton;
	}
	/**
	 * This method initializes topragaTemasliTabanBilesenEkleButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getTopragaTemasliTabanBilesenEkleButton() {
		if (topragaTemasliTabanBilesenEkleButton == null) {
			topragaTemasliTabanBilesenEkleButton = new JButton();
			topragaTemasliTabanBilesenEkleButton.setLocation(107, 186);
			topragaTemasliTabanBilesenEkleButton.setSize(110, 24);
			topragaTemasliTabanBilesenEkleButton.setText("Bileþen Ekle");
		}
		return topragaTemasliTabanBilesenEkleButton;
	}
	/**
	 * This method initializes isitilmayanTabanBilesenEkleButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getIsitilmayanTabanBilesenEkleButton() {
		if (isitilmayanTabanBilesenEkleButton == null) {
			isitilmayanTabanBilesenEkleButton = new JButton();
			isitilmayanTabanBilesenEkleButton.setLocation(107, 186);
			isitilmayanTabanBilesenEkleButton.setSize(110, 24);
			isitilmayanTabanBilesenEkleButton.setText("Bileþen Ekle");
		}
		return isitilmayanTabanBilesenEkleButton;
	}
	/**
	 * This method initializes acikGecitUzeriBilesenEkleButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getAcikGecitUzeriBilesenEkleButton() {
		if (acikGecitUzeriBilesenEkleButton == null) {
			acikGecitUzeriBilesenEkleButton = new JButton();
			acikGecitUzeriBilesenEkleButton.setLocation(107, 186);
			acikGecitUzeriBilesenEkleButton.setSize(110, 24);
			acikGecitUzeriBilesenEkleButton.setText("Bileþen Ekle");
		}
		return acikGecitUzeriBilesenEkleButton;
	}
	/**
	 * This method initializes uzeriAcikTavanBilesenCikarButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getUzeriAcikTavanBilesenCikarButton() {
		if (uzeriAcikTavanBilesenCikarButton == null) {
			uzeriAcikTavanBilesenCikarButton = new JButton();
			uzeriAcikTavanBilesenCikarButton.setLocation(240, 186);
			uzeriAcikTavanBilesenCikarButton.setSize(110, 24);
			uzeriAcikTavanBilesenCikarButton.setText("Bileþen Çýkar");
		}
		return uzeriAcikTavanBilesenCikarButton;
	}
	/**
	 * This method initializes catiliTavanBilesenCikarButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getCatiliTavanBilesenCikarButton() {
		if (catiliTavanBilesenCikarButton == null) {
			catiliTavanBilesenCikarButton = new JButton();
			catiliTavanBilesenCikarButton.setLocation(240, 186);
			catiliTavanBilesenCikarButton.setSize(110, 24);
			catiliTavanBilesenCikarButton.setText("Bileþen Çýkar");
		}
		return catiliTavanBilesenCikarButton;
	}
	/**
	 * This method initializes topragaTemasliTabanBilesenCikarButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getTopragaTemasliTabanBilesenCikarButton() {
		if (topragaTemasliTabanBilesenCikarButton == null) {
			topragaTemasliTabanBilesenCikarButton = new JButton();
			topragaTemasliTabanBilesenCikarButton.setLocation(240, 186);
			topragaTemasliTabanBilesenCikarButton.setSize(110, 24);
			topragaTemasliTabanBilesenCikarButton.setText("Bileþen Çýkar");
		}
		return topragaTemasliTabanBilesenCikarButton;
	}
	/**
	 * This method initializes isitilmayanTabanBilesenCikarButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getIsitilmayanTabanBilesenCikarButton() {
		if (isitilmayanTabanBilesenCikarButton == null) {
			isitilmayanTabanBilesenCikarButton = new JButton();
			isitilmayanTabanBilesenCikarButton.setLocation(240, 186);
			isitilmayanTabanBilesenCikarButton.setSize(110, 24);
			isitilmayanTabanBilesenCikarButton.setText("Bileþen Çýkar");
		}
		return isitilmayanTabanBilesenCikarButton;
	}
	/**
	 * This method initializes acikGecitUzeriBilesenCikarButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getAcikGecitUzeriBilesenCikarButton() {
		if (acikGecitUzeriBilesenCikarButton == null) {
			acikGecitUzeriBilesenCikarButton = new JButton();
			acikGecitUzeriBilesenCikarButton.setLocation(240, 186);
			acikGecitUzeriBilesenCikarButton.setSize(110, 24);
			acikGecitUzeriBilesenCikarButton.setText("Bileþen Çýkar");
		}
		return acikGecitUzeriBilesenCikarButton;
	}
	/**
	 * This method initializes uzeriAcikTavanAlanTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getUzeriAcikTavanAlanTextField() {
		if (uzeriAcikTavanAlanTextField == null) {
			uzeriAcikTavanAlanTextField = new JTextField();
			uzeriAcikTavanAlanTextField.setLocation(193, 243);
			uzeriAcikTavanAlanTextField.setSize(98, 24);
		}
		return uzeriAcikTavanAlanTextField;
	}
	/**
	 * This method initializes uzeriAcikTavanUTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getUzeriAcikTavanUTextField() {
		if (uzeriAcikTavanUTextField == null) {
			uzeriAcikTavanUTextField = new JTextField();
			uzeriAcikTavanUTextField.setLocation(193, 289);
			uzeriAcikTavanUTextField.setSize(98, 24);
			uzeriAcikTavanUTextField.setEnabled(true);
			uzeriAcikTavanUTextField.setEditable(false);
		}
		return uzeriAcikTavanUTextField;
	}
	/**
	 * This method initializes catiliTavanAlanTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getCatiliTavanAlanTextField() {
		if (catiliTavanAlanTextField == null) {
			catiliTavanAlanTextField = new JTextField();
			catiliTavanAlanTextField.setLocation(193, 243);
			catiliTavanAlanTextField.setSize(98, 24);
		}
		return catiliTavanAlanTextField;
	}
	/**
	 * This method initializes catiliTavanUTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getCatiliTavanUTextField() {
		if (catiliTavanUTextField == null) {
			catiliTavanUTextField = new JTextField();
			catiliTavanUTextField.setLocation(193, 289);
			catiliTavanUTextField.setSize(98, 24);
			catiliTavanUTextField.setEnabled(true);
			catiliTavanUTextField.setEditable(false);
		}
		return catiliTavanUTextField;
	}
	/**
	 * This method initializes topragaTemasliTabanAlanTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getTopragaTemasliTabanAlanTextField() {
		if (topragaTemasliTabanAlanTextField == null) {
			topragaTemasliTabanAlanTextField = new JTextField();
			topragaTemasliTabanAlanTextField.setLocation(193, 243);
			topragaTemasliTabanAlanTextField.setSize(98, 24);
		}
		return topragaTemasliTabanAlanTextField;
	}
	/**
	 * This method initializes topragaTemasliTabanUTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getTopragaTemasliTabanUTextField() {
		if (topragaTemasliTabanUTextField == null) {
			topragaTemasliTabanUTextField = new JTextField();
			topragaTemasliTabanUTextField.setLocation(193, 289);
			topragaTemasliTabanUTextField.setSize(98, 24);
			topragaTemasliTabanUTextField.setEnabled(true);
			topragaTemasliTabanUTextField.setEditable(false);
		}
		return topragaTemasliTabanUTextField;
	}
	/**
	 * This method initializes isitilmayanTabanAlanTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getIsitilmayanTabanAlanTextField() {
		if (isitilmayanTabanAlanTextField == null) {
			isitilmayanTabanAlanTextField = new JTextField();
			isitilmayanTabanAlanTextField.setLocation(193, 243);
			isitilmayanTabanAlanTextField.setSize(98, 24);
		}
		return isitilmayanTabanAlanTextField;
	}
	/**
	 * This method initializes isitilmayanTabanUTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getIsitilmayanTabanUTextField() {
		if (isitilmayanTabanUTextField == null) {
			isitilmayanTabanUTextField = new JTextField();
			isitilmayanTabanUTextField.setLocation(193, 289);
			isitilmayanTabanUTextField.setSize(98, 24);
			isitilmayanTabanUTextField.setEnabled(true);
			isitilmayanTabanUTextField.setEditable(false);
		}
		return isitilmayanTabanUTextField;
	}
	/**
	 * This method initializes acikGecitUzeriAlanTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getAcikGecitUzeriAlanTextField() {
		if (acikGecitUzeriAlanTextField == null) {
			acikGecitUzeriAlanTextField = new JTextField();
			acikGecitUzeriAlanTextField.setLocation(193, 243);
			acikGecitUzeriAlanTextField.setSize(98, 24);
		}
		return acikGecitUzeriAlanTextField;
	}
	/**
	 * This method initializes acikGecitUzeriUTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getAcikGecitUzeriUTextField() {
		if (acikGecitUzeriUTextField == null) {
			acikGecitUzeriUTextField = new JTextField();
			acikGecitUzeriUTextField.setLocation(193, 289);
			acikGecitUzeriUTextField.setSize(98, 24);
			acikGecitUzeriUTextField.setEnabled(true);
			acikGecitUzeriUTextField.setEditable(false);
		}
		return acikGecitUzeriUTextField;
	}

    public void addTopragaTemasliDuvarBilesenEkleActionListener(ActionListener listener) {
        getTopragaTemasliDuvarBilesenEkleButton().addActionListener(listener);
    }

    public void addTopragaTemasliDuvarModelTableModelListener(TableModelListener listener) {
        getTopragaTemasliDuvarModelTableModel().addTableModelListener(listener);
    }

    public DefaultTableModel getTopragaTemasliDuvarModelTableModel() {
        return (DefaultTableModel)getTopragaTemasliDuvarTable().getModel();
    }

    public void setTopragaTemasliDuvarUTextFieldText(String string) {
        getTopragaTemasliDuvarUTextField().setText(string);
    }

    public void setTopragaTemasliDuvarModelTableModel(DefaultTableModel tableModel) {
        getTopragaTemasliDuvarTable().setModel(tableModel);
    }

    public void setTopragaTemasliDuvarModelTableColumnWidths() {
		TableColumn column = getTopragaTemasliDuvarTable().getColumnModel().getColumn(0);
		column.setPreferredWidth(10);
    }
                                    
	public void addIsitilmayanDuvarBilesenCikarButtonActionListener(ActionListener listener) {
		getIsitilmayanDuvarBilesenCikarButton().addActionListener(listener);
	}
	
	public void addTopragaTemasliDuvarBilesenCikarButtonActionListener(ActionListener listener) {
		getTopragaTemasliDuvarBilesenCikarButton().addActionListener(listener);
	}
	
	public void removeIsitilmayanDuvarModelTableSelectedRow() {
		int selectedRow = getIsitilmayanDuvarModelTable().getSelectedRow();
		if(selectedRow!=-1)getIsitilmayanDuvarModelTableModel().removeRow(selectedRow);
	}

	public void removeTopragaTemasliDuvarModelTableSelectedRow() {
		int selectedRow = getTopragaTemasliDuvarTable().getSelectedRow();
		if(selectedRow!=-1)getTopragaTemasliDuvarModelTableModel().removeRow(selectedRow);
	}

    public void addIsitilmayanDuvarAlaniTextFieldActionListener(FocusAdapter adapter) {
        getIsitilmayanDuvarAlanTextField().addFocusListener(adapter);
    }

    public void addIsitilmayanDuvarAlaniTextFieldKeyListener(KeyListener listener) {
        getIsitilmayanDuvarAlanTextField().addKeyListener(listener);        
    }

    public String getIsitilmayanDuvarAlanTextFieldText() {
        return getIsitilmayanDuvarAlanTextField().getText();
    }

    public void addTopragaTemasliDuvarAlaniTextFieldActionListener(FocusAdapter adapter) {
        getTopragaTemasliDuvarAlanTextField().addFocusListener(adapter);
    }

    public void addTopragaTemasliDuvarAlaniTextFieldKeyListener(KeyListener listener) {
        getTopragaTemasliDuvarAlanTextField().addKeyListener(listener);        
    }

    public String getTopragaTemasliDuvarAlanTextFieldText() {
        return getTopragaTemasliDuvarAlanTextField().getText();
    }

    public void addUzeriAcikTavanBilesenEkleActionListener(ActionListener listener) {
        getUzeriAcikTavanBilesenEkleButton().addActionListener(listener);
    }

    public void addUzeriAcikTavanModelTableModelListener(TableModelListener listener) {
        getUzeriAcikTavanModelTableModel().addTableModelListener(listener);
    }

    public DefaultTableModel getUzeriAcikTavanModelTableModel() {
        return (DefaultTableModel)getUzeriAcikTavanTable().getModel();
    }

    public void setUzeriAcikTavanUTextFieldText(String string) {
        getUzeriAcikTavanUTextField().setText(string);
    }

    public void setUzeriAcikTavanModelTableModel(DefaultTableModel tableModel) {
        getUzeriAcikTavanTable().setModel(tableModel);
    }

    public void setUzeriAcikTavanModelTableColumnWidths() {
		TableColumn column = getUzeriAcikTavanTable().getColumnModel().getColumn(0);
		column.setPreferredWidth(10);
    }

	public void addUzeriAcikTavanBilesenCikarButtonActionListener(ActionListener listener) {
		getUzeriAcikTavanBilesenCikarButton().addActionListener(listener);
	}
	
	public void removeUzeriAcikTavanModelTableSelectedRow() {
		int selectedRow = getUzeriAcikTavanTable().getSelectedRow();
		if(selectedRow!=-1)getUzeriAcikTavanModelTableModel().removeRow(selectedRow);
	}

    public void addUzeriAcikTavanAlaniTextFieldActionListener(FocusAdapter adapter) {
        getUzeriAcikTavanAlanTextField().addFocusListener(adapter);
    }

    public void addUzeriAcikTavanAlaniTextFieldKeyListener(KeyListener listener) {
        getUzeriAcikTavanAlanTextField().addKeyListener(listener);        
    }

    public String getUzeriAcikTavanAlanTextFieldText() {
        return getUzeriAcikTavanAlanTextField().getText();
    }

    public void addCatiliTavanBilesenEkleActionListener(ActionListener listener) {
        getCatiliTavanBilesenEkleButton().addActionListener(listener);
    }

    public void addCatiliTavanModelTableModelListener(TableModelListener listener) {
        getCatiliTavanModelTableModel().addTableModelListener(listener);
    }

    public DefaultTableModel getCatiliTavanModelTableModel() {
        return (DefaultTableModel)getCatiliTavanTable().getModel();
    }

    public void setCatiliTavanUTextFieldText(String string) {
        getCatiliTavanUTextField().setText(string);
    }

    public void setCatiliTavanModelTableModel(DefaultTableModel tableModel) {
        getCatiliTavanTable().setModel(tableModel);
    }

    public void setCatiliTavanModelTableColumnWidths() {
		TableColumn column = getCatiliTavanTable().getColumnModel().getColumn(0);
		column.setPreferredWidth(10);
    }

	public void addCatiliTavanBilesenCikarButtonActionListener(ActionListener listener) {
		getCatiliTavanBilesenCikarButton().addActionListener(listener);
	}
	
	public void removeCatiliTavanModelTableSelectedRow() {
		int selectedRow = getCatiliTavanTable().getSelectedRow();
		if(selectedRow!=-1)getCatiliTavanModelTableModel().removeRow(selectedRow);
	}

    public void addCatiliTavanAlaniTextFieldActionListener(FocusAdapter adapter) {
        getCatiliTavanAlanTextField().addFocusListener(adapter);
    }

    public void addCatiliTavanAlaniTextFieldKeyListener(KeyListener listener) {
        getCatiliTavanAlanTextField().addKeyListener(listener);        
    }

    public String getCatiliTavanAlanTextFieldText() {
        return getCatiliTavanAlanTextField().getText();
    } 
    
    public void addTopragaTemasliTabanBilesenEkleActionListener(ActionListener listener) {
        getTopragaTemasliTabanBilesenEkleButton().addActionListener(listener);
    }

    public void addTopragaTemasliTabanModelTableModelListener(TableModelListener listener) {
        getTopragaTemasliTabanModelTableModel().addTableModelListener(listener);
    }

    public DefaultTableModel getTopragaTemasliTabanModelTableModel() {
        return (DefaultTableModel)getTopragaTemasliTabanTable().getModel();
    }

    public void setTopragaTemasliTabanUTextFieldText(String string) {
        getTopragaTemasliTabanUTextField().setText(string);
    }

    public void setTopragaTemasliTabanModelTableModel(DefaultTableModel tableModel) {
        getTopragaTemasliTabanTable().setModel(tableModel);
    }

    public void setTopragaTemasliTabanModelTableColumnWidths() {
		TableColumn column = getTopragaTemasliTabanTable().getColumnModel().getColumn(0);
		column.setPreferredWidth(10);
    }

	public void addTopragaTemasliTabanBilesenCikarButtonActionListener(ActionListener listener) {
		getTopragaTemasliTabanBilesenCikarButton().addActionListener(listener);
	}
	
	public void removeTopragaTemasliTabanModelTableSelectedRow() {
		int selectedRow = getTopragaTemasliTabanTable().getSelectedRow();
		if(selectedRow!=-1)getTopragaTemasliTabanModelTableModel().removeRow(selectedRow);
	}

    public void addTopragaTemasliTabanAlaniTextFieldActionListener(FocusAdapter adapter) {
        getTopragaTemasliTabanAlanTextField().addFocusListener(adapter);
    }

    public void addTopragaTemasliTabanAlaniTextFieldKeyListener(KeyListener listener) {
        getTopragaTemasliTabanAlanTextField().addKeyListener(listener);        
    }

    public String getTopragaTemasliTabanAlanTextFieldText() {
        return getTopragaTemasliTabanAlanTextField().getText();
    }
   
    public void addIsitilmayanTabanBilesenEkleActionListener(ActionListener listener) {
        getIsitilmayanTabanBilesenEkleButton().addActionListener(listener);
    }

    public void addIsitilmayanTabanModelTableModelListener(TableModelListener listener) {
        getIsitilmayanTabanModelTableModel().addTableModelListener(listener);
    }

    public DefaultTableModel getIsitilmayanTabanModelTableModel() {
        return (DefaultTableModel)getIsitilmayanTabanTable().getModel();
    }

    public void setIsitilmayanTabanUTextFieldText(String string) {
        getIsitilmayanTabanUTextField().setText(string);
    }

    public void setIsitilmayanTabanModelTableModel(DefaultTableModel tableModel) {
        getIsitilmayanTabanTable().setModel(tableModel);
    }

    public void setIsitilmayanTabanModelTableColumnWidths() {
		TableColumn column = getIsitilmayanTabanTable().getColumnModel().getColumn(0);
		column.setPreferredWidth(10);
    }

	public void addIsitilmayanTabanBilesenCikarButtonActionListener(ActionListener listener) {
		getIsitilmayanTabanBilesenCikarButton().addActionListener(listener);
	}
	
	public void removeIsitilmayanTabanModelTableSelectedRow() {
		int selectedRow = getIsitilmayanTabanTable().getSelectedRow();
		if(selectedRow!=-1)getIsitilmayanTabanModelTableModel().removeRow(selectedRow);
	}

    public void addIsitilmayanTabanAlaniTextFieldActionListener(FocusAdapter adapter) {
        getIsitilmayanTabanAlanTextField().addFocusListener(adapter);
    }

    public void addIsitilmayanTabanAlaniTextFieldKeyListener(KeyListener listener) {
        getIsitilmayanTabanAlanTextField().addKeyListener(listener);        
    }

    public String getIsitilmayanTabanAlanTextFieldText() {
        return getIsitilmayanTabanAlanTextField().getText();
    }


    
    
    public void addAcikGecitUzeriTabanBilesenEkleActionListener(ActionListener listener) {
        getAcikGecitUzeriBilesenEkleButton().addActionListener(listener);
    }

    public void addAcikGecitUzeriTabanModelTableModelListener(TableModelListener listener) {
        getAcikGecitUzeriTabanModelTableModel().addTableModelListener(listener);
    }

    public DefaultTableModel getAcikGecitUzeriTabanModelTableModel() {
        return (DefaultTableModel)getAcikGecitUzeriTable().getModel();
    }

    public void setAcikGecitUzeriTabanUTextFieldText(String string) {
        getAcikGecitUzeriUTextField().setText(string);
    }

    public void setAcikGecitUzeriTabanModelTableModel(DefaultTableModel tableModel) {
        getAcikGecitUzeriTable().setModel(tableModel);
    }

    public void setAcikGecitUzeriTabanModelTableColumnWidths() {
		TableColumn column = getAcikGecitUzeriTable().getColumnModel().getColumn(0);
		column.setPreferredWidth(10);
    }

	public void addAcikGecitUzeriTabanBilesenCikarButtonActionListener(ActionListener listener) {
		getAcikGecitUzeriBilesenCikarButton().addActionListener(listener);
	}
	
	public void removeAcikGecitUzeriTabanModelTableSelectedRow() {
		int selectedRow = getAcikGecitUzeriTable().getSelectedRow();
		if(selectedRow!=-1)getAcikGecitUzeriTabanModelTableModel().removeRow(selectedRow);
	}

    public void addAcikGecitUzeriTabanAlaniTextFieldActionListener(FocusAdapter adapter) {
        getAcikGecitUzeriAlanTextField().addFocusListener(adapter);
    }

    public void addAcikGecitUzeriTabanAlaniTextFieldKeyListener(KeyListener listener) {
        getAcikGecitUzeriAlanTextField().addKeyListener(listener);        
    }

    public String getAcikGecitUzeriTabanAlanTextFieldText() {
        return getAcikGecitUzeriAlanTextField().getText();
    }

    public void setHavalandirmaOzgulIsiKaybiTextFieldText(double d) {
        DecimalFormat twoDigits = new DecimalFormat("0.00");
        getHavalandirmaOzgulIsiKaybiTextField().setText(""+twoDigits.format(d));
    }

    public void setDoguPencereRadioButtonActionCommand(String string) {
        getDoguPencereRadioButton().setActionCommand(string);
    }

    public void setBatiPencereRadioButtonActionCommand(String string) {
        getBatiPencereRadioButton().setActionCommand(string);
    }

    public void setGuneyPencereRadioButtonActionCommand(String string) {
       getGuneyPencereRadioButton().setActionCommand(string);
    }

    public void setKuzeyPencereRadioButtonActionCommand(String string) {
        getKuzeyPencereRadioButton().setActionCommand(string);
    }

    public void addDoguPencereRadioButtonActionCommand(ActionListener radioButtonActionListener) {
        getDoguPencereRadioButton().addActionListener(radioButtonActionListener);
    }

    public void addBatiPencereRadioButtonActionCommand(ActionListener radioButtonActionListener) {
        getBatiPencereRadioButton().addActionListener(radioButtonActionListener);
    }

    public void addGuneyPencereRadioButtonActionCommand(ActionListener radioButtonActionListener) {
        getGuneyPencereRadioButton().addActionListener(radioButtonActionListener);
    }

    public void addKuzeyPencereRadioButtonActionCommand(ActionListener radioButtonActionListener) {
        getKuzeyPencereRadioButton().addActionListener(radioButtonActionListener);
    }    

    public String getYoneGorePencereAlaniTextFieldText(){
        return getYoneGorePencereAlaniTextField().getText();
    }
    
    public void setYoneGorePencereAlaniTextFieldText(String pencereAlani){
        getYoneGorePencereAlaniTextField().setText(pencereAlani);
    }
    
    public void setToplamPencereAlaniTextFieldText(String toplamPencereAlani){
        getToplamPencereAlaniTextField().setText(toplamPencereAlani);
    }

    public void addYoneGorePencereAlaniTextFieldFocusListener(FocusAdapter adapter) {
        getYoneGorePencereAlaniTextField().addFocusListener(adapter);
    }

    public void addYoneGorePencereAlaniTextFieldKeyListener(KeyListener listener) {
        getYoneGorePencereAlaniTextField().addKeyListener(listener);
    }
    
    public void removeFocusFromYoneGorePencereAlani(){
        getYoneGorePencereAlaniTextField().transferFocus();
    }
    
    public String getHavaDegisimKatsayisiTextFieldText(){
        return getHavaDegisimKatsayisiTextField().getText();
    }
    
    public void setHavaDegisimKatsayisiTextFieldText(String havaDegisimKatsayisi){
        getHavaDegisimKatsayisiTextField().setText(havaDegisimKatsayisi);
    }

    public void setHavaDegisimKatsayisiTextFieldEnabled(boolean state){
        getHavaDegisimKatsayisiTextField().setEnabled(state);
    }

    public void addHavaDegisimKatsayisiTextFieldFocusListener(FocusAdapter adapter) {
        getHavaDegisimKatsayisiTextField().addFocusListener(adapter);
    }

    public void addHavaDegisimKatsayisiTextFieldKeyListener(KeyListener listener) {
        getHavaDegisimKatsayisiTextField().addKeyListener(listener);
    }

    public void removeFocusFromHavaDegisimKatsayisiTextField() {
        getHavaDegisimKatsayisiTextField().transferFocus();
    }
    
    public boolean isDoguPencereRadioButtonSelected(){
        return getDoguPencereRadioButton().isSelected();
    }
    
    public boolean isBatiPencereRadioButtonSelected(){
        return getBatiPencereRadioButton().isSelected();
    }

    public boolean isKuzeyPencereRadioButtonSelected(){
        return getKuzeyPencereRadioButton().isSelected();
    }

    public boolean isGuneyPencereRadioButtonSelected(){
        return getGuneyPencereRadioButton().isSelected();
    }
    
    public void setDoguPencereRadioButtonSelected(boolean state){
        getDoguPencereRadioButton().setSelected(state);
    }
    
    public void setBatiPencereRadioButtonSelected(boolean state){
        getBatiPencereRadioButton().setSelected(state);
    }

    public void setKuzeyPencereRadioButtonSelected(boolean state){
        getKuzeyPencereRadioButton().setSelected(state);
    }

    public void setGuneyPencereRadioButtonSelected(boolean state){
        getGuneyPencereRadioButton().setSelected(state);
    }

    public void addPencereAlanTextFieldFocusListener(FocusAdapter adapter) {
        getPencereAlanTextField().addFocusListener(adapter);        
    }

    public void addPencereAlanTextFieldKeyListener(KeyListener listener) {
        getPencereAlanTextField().addKeyListener(listener);
    }

    public void removeFocusFromPencereAlanTextField() {
        getPencereAlanTextField().transferFocus();
    }

    public void addPencereUTextFieldFocusListener(FocusAdapter adapter) {
        getPencereUTextField().addFocusListener(adapter);
    }

    public void addPencereUTextFieldKeyListener(KeyListener listener) {
        getPencereUTextField().addKeyListener(listener);
    }

    public String getPencereUTextFieldText() {
        return getPencereUTextField().getText();
    }

    public void removeFocusFromPencereUTextField() {
        getPencereUTextField().transferFocus();
    }

    public String getPencereAlanTextFieldText() {
        return getPencereAlanTextField().getText();
    }

	/**
	 * This method initializes binaKullanimAlaniTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getBinaKullanimAlaniTextField() {
		if (binaKullanimAlaniTextField == null) {
			binaKullanimAlaniTextField = new JTextField();
			binaKullanimAlaniTextField.setBounds(276, 47, 81, 24);
			binaKullanimAlaniTextField.setEnabled(true);
			binaKullanimAlaniTextField.setEditable(false);
		}
		return binaKullanimAlaniTextField;
	}

    public void setBinaKullanimAlaniTextFieldText(double binaKullanimAlani) {
        getBinaKullanimAlaniTextField().setText(""+binaKullanimAlani);
    }
    
    public void setIletimselOzgulIsiKaybiTextFieldText(String text){
        getIletimselOzgulIsiKaybiTextField().setText(text);
    }
    
    public void setToplamOzgulIsiKaybiTextFieldText(String toplamOzgulIsiKaybi){
        getToplamOzgulIsiKaybiTextField().setText(toplamOzgulIsiKaybi);
    }
	/**
	 * This method initializes toplamGunesEnerjisiTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getToplamGunesEnerjisiTextField() {
		if (toplamGunesEnerjisiTextField == null) {
			toplamGunesEnerjisiTextField = new JTextField();
			toplamGunesEnerjisiTextField.setBounds(39, 336, 88, 24);
			toplamGunesEnerjisiTextField.setEditable(false);
		}
		return toplamGunesEnerjisiTextField;
	}

    public void setGDikDoguBRadioButtonActionCommand(String command) {
        getGDikDoguBRadioButton().setActionCommand(command);
    }

    public void setGDikBatiBRadioButtonActionCommand(String command) {
        getGDikBatiBRadioButton().setActionCommand(command);     
    }

    public void setGDikKuzeyBRadioButtonActionCommand(String command) {
        getGDikKuzeyBRadioButton().setActionCommand(command);
    }

    public void setGDikGuneyBRadioButtonActionCommand(String command) {
        getGDikGuneyBRadioButton().setActionCommand(command);
    }

    public void addGDikDoguBRadioButtonActionListener(ActionListener radioButtonActionListener) {
        getGDikDoguBRadioButton().addActionListener(radioButtonActionListener);
    }

    public void addGDikBatiBRadioButtonActionListener(ActionListener radioButtonActionListener) {
        getGDikBatiBRadioButton().addActionListener(radioButtonActionListener);
    }

    public void addGDikKuzeyBRadioButtonActionListener(ActionListener radioButtonActionListener) {
        getGDikKuzeyBRadioButton().addActionListener(radioButtonActionListener);
    }

    public void addGDikGuneyBRadioButtonActionListener(ActionListener radioButtonActionListener) {
        getGDikGuneyBRadioButton().addActionListener(radioButtonActionListener);
    }

    public void setGDikDoguORadioButtonActionCommand(String command) {
        getGDikDoguORadioButton().setActionCommand(command);
    }

    public void setGDikBatiORadioButtonActionCommand(String command) {
        getGDikBatiORadioButton().setActionCommand(command);     
    }

    public void setGDikKuzeyORadioButtonActionCommand(String command) {
        getGDikKuzeyORadioButton().setActionCommand(command);
    }

    public void setGDikGuneyORadioButtonActionCommand(String command) {
        getGDikGuneyORadioButton().setActionCommand(command);
    }

    public void addGDikDoguORadioButtonActionListener(ActionListener radioButtonActionListener) {
        getGDikDoguORadioButton().addActionListener(radioButtonActionListener);
    }

    public void addGDikBatiORadioButtonActionListener(ActionListener radioButtonActionListener) {
        getGDikBatiORadioButton().addActionListener(radioButtonActionListener);
    }

    public void addGDikKuzeyORadioButtonActionListener(ActionListener radioButtonActionListener) {
        getGDikKuzeyORadioButton().addActionListener(radioButtonActionListener);
    }

    public void addGDikGuneyORadioButtonActionListener(ActionListener radioButtonActionListener) {
        getGDikGuneyORadioButton().addActionListener(radioButtonActionListener);
    }

    public void setGDikDoguKRadioButtonActionCommand(String command) {
        getGDikDoguKRadioButton().setActionCommand(command);
    }

    public void setGDikBatiKRadioButtonActionCommand(String command) {
        getGDikBatiKRadioButton().setActionCommand(command);     
    }

    public void setGDikKuzeyKRadioButtonActionCommand(String command) {
        getGDikKuzeyKRadioButton().setActionCommand(command);
    }

    public void setGDikGuneyKRadioButtonActionCommand(String command) {
        getGDikGuneyKRadioButton().setActionCommand(command);
    }

    public void addGDikDoguKRadioButtonActionListener(ActionListener radioButtonActionListener) {
        getGDikDoguKRadioButton().addActionListener(radioButtonActionListener);
    }

    public void addGDikBatiKRadioButtonActionListener(ActionListener radioButtonActionListener) {
        getGDikBatiKRadioButton().addActionListener(radioButtonActionListener);
    }

    public void addGDikKuzeyKRadioButtonActionListener(ActionListener radioButtonActionListener) {
        getGDikKuzeyKRadioButton().addActionListener(radioButtonActionListener);
    }

    public void addGDikGuneyKRadioButtonActionListener(ActionListener radioButtonActionListener) {
        getGDikGuneyKRadioButton().addActionListener(radioButtonActionListener);
    }

    public void setToplamGunesEnerjisiTextFieldText(String text) {
        getToplamGunesEnerjisiTextField().setText(text);
    }

    public void setQtextFieldText(String q){
        getQTextField().setText(q);
    }

	/**
	 * @param binaKatsayisiRadioButtonListener
	 */
	public void addNormalBolgeDurumuRadioButtonListener(ActionListener binaKatsayisiRadioButtonListener) {
		getNormalBolgeDurumuRadioButton().addActionListener(binaKatsayisiRadioButtonListener);
	}

	/**
	 * @param string
	 */
	public void setNormalBolgeDurumuRadioButtonActionCommand(String string) {
		getNormalBolgeDurumuRadioButton().setActionCommand(string);		
	}

	/**
	 * @param binaKatsayisiRadioButtonListener
	 */
	public void addRuzgarliBolgeDurumuRadioButtonListener(ActionListener binaKatsayisiRadioButtonListener) {
		getRuzgarliBolgeDurumuRadioButton().addActionListener(binaKatsayisiRadioButtonListener);
	}

	/**
	 * @param string
	 */
	public void setRuzgarliBolgeDurumuRadioButtonActionCommand(String string) {
		getRuzgarliBolgeDurumuRadioButton().setActionCommand(string);		
	}

	/**
	 * @param binaKatsayisiRadioButtonListener
	 */
	public void addMahfuzBinaDurumuRadioButtonListener(ActionListener binaKatsayisiRadioButtonListener) {
		getMahfuzBinaDurumuRadioButton().addActionListener(binaKatsayisiRadioButtonListener);		
	}

	/**
	 * @param string
	 */
	public void setMahfuzBinaDurumuRadioButtonActionCommand(String string) {
		getMahfuzBinaDurumuRadioButton().setActionCommand(string);		
	}

	/**
	 * @param binaKatsayisiRadioButtonListener
	 */
	public void addSerbestBinaDurumuRadioButtonListener(ActionListener binaKatsayisiRadioButtonListener) {
		getSerbestBinaDurumuRadioButton().addActionListener(binaKatsayisiRadioButtonListener);		
	}

	/**
	 * @param string
	 */
	public void setSerbestBinaDurumuRadioButtonActionCommand(String string) {
		getSerbestBinaDurumuRadioButton().setActionCommand(string);		
	}

	/**
	 * @param binaKatsayisiRadioButtonListener
	 */
	public void addCokSerbestBinaDurumuRadioButtonListener(ActionListener binaKatsayisiRadioButtonListener) {
		getCokSerbestBinaDurumuRadioButton().addActionListener(binaKatsayisiRadioButtonListener);		
	}

	/**
	 * @param string
	 */
	public void setCokSerbestBinaDurumuRadioButtonActionCommand(String string) {
		getCokSerbestBinaDurumuRadioButton().setActionCommand(string);		
	}

	/**
	 * @param binaKatsayisiRadioButtonListener
	 */
	public void addBitisikNizamRadioButtonListener(ActionListener binaKatsayisiRadioButtonListener) {
		getBitisikNizamRadioButton().addActionListener(binaKatsayisiRadioButtonListener);		
	}

	/**
	 * @param string
	 */
	public void setBitisikNizamRadioButtonActionCommand(String string) {
		getBitisikNizamRadioButton().setActionCommand(string);		
	}

	/**
	 * @param binaKatsayisiRadioButtonListener
	 */
	public void addAyrikNizamRadioButtonListener(ActionListener binaKatsayisiRadioButtonListener) {
		getAyrikNizamRadioButton().addActionListener(binaKatsayisiRadioButtonListener);		
	}

	/**
	 * @param string
	 */
	public void setAyrikNizamRadioButtonActionCommand(String string) {
		getAyrikNizamRadioButton().setActionCommand(string);		
	}

	/**
	 * @param odaDurumKatsayisiRadioButtonListener
	 */
	public void addOdaDurumKatsayisi07RadioButtonListener(ActionListener odaDurumKatsayisiRadioButtonListener) {
		getOdaDurumKatsayisi07RadioButton().addActionListener(odaDurumKatsayisiRadioButtonListener);		
	}

	/**
	 * @param string
	 */
	public void setOdaDurumKatsayisi07RadioButtonActionCommand(String string) {
		getOdaDurumKatsayisi07RadioButton().setActionCommand(string);		
	}

	/**
	 * @param odaDurumKatsayisiRadioButtonListener
	 */
	public void addOdaDurumKatsayisi09RadioButtonListener(ActionListener odaDurumKatsayisiRadioButtonListener) {
		getOdaDurumKatsayisi09RadioButton().addActionListener(odaDurumKatsayisiRadioButtonListener);		
	}

	/**
	 * @param string
	 */
	public void setOdaDurumKatsayisi09RadioButtonActionCommand(String string) {
		getOdaDurumKatsayisi09RadioButton().setActionCommand(string);		
	}


	/**
	 * @param sizdirganlikKatsayisiRadioButtonListener
	 */
	public void addMalzemeAhsapRadioButtonListener(ActionListener sizdirganlikKatsayisiRadioButtonListener) {
		getAhsapMalzemeRadioButton().addActionListener(sizdirganlikKatsayisiRadioButtonListener);	
	}

	/**
	 * @param sizdirganlikKatsayisiRadioButtonListener
	 */
	public void addMalzemePlastikRadioButtonListener(ActionListener sizdirganlikKatsayisiRadioButtonListener) {
		getPlastikMalzemeRadioButton().addActionListener(sizdirganlikKatsayisiRadioButtonListener);		
	}

	/**
	 * @param sizdirganlikKatsayisiRadioButtonListener
	 */
	public void addMalzemeMetalRadioButtonListener(ActionListener sizdirganlikKatsayisiRadioButtonListener) {
		getMetalMalzemeRadioButton().addActionListener(sizdirganlikKatsayisiRadioButtonListener);		
	}

	/**
	 * @param sizdirganlikKatsayisiRadioButtonListener
	 */
	public void addTipTekAcilirliRadioButtonListener(ActionListener sizdirganlikKatsayisiRadioButtonListener) {
		getTekAcilirliTipRadioButton().addActionListener(sizdirganlikKatsayisiRadioButtonListener);		
	}

	/**
	 * @param string
	 */
	public void setTipTekAcilirliRadioButtonActionCommand(String string) {
		getTekAcilirliTipRadioButton().setActionCommand(string);		
	}

	/**
	 * @param sizdirganlikKatsayisiRadioButtonListener
	 */
	public void addTipCiftCamliRadioButtonListener(ActionListener sizdirganlikKatsayisiRadioButtonListener) {
		getCiftCamliTipRadioButton().addActionListener(sizdirganlikKatsayisiRadioButtonListener);		
	}

	/**
	 * @param string
	 */
	public void setTipCiftCamliRadioButtonActionCommand(String string) {
		getCiftCamliTipRadioButton().setActionCommand(string);		
	}

	/**
	 * @param sizdirganlikKatsayisiRadioButtonListener
	 */
	public void addTipCiftAcilirliRadioButtonListener(ActionListener sizdirganlikKatsayisiRadioButtonListener) {
		getCiftAcilirliTipRadioButton().addActionListener(sizdirganlikKatsayisiRadioButtonListener);		
	}

	/**
	 * @param string
	 */
	public void setTipCiftAcilirliRadioButtonActionCommand(String string) {
		getCiftAcilirliTipRadioButton().setActionCommand(string);		
	}
	
	public void setBinaKatsayisiTextFieldText(double d) {
		getBinaKatsayisiTextField().setText(String.valueOf(d));
	}
	
	public String getBinaKatsayisiTextFieldText() {
		return getBinaKatsayisiTextField().getText();
	}
	
	public void setSizdirganlikKatsayisiTextFieldText(double d) {
		getSizdirganlikKatsayisiTextField().setText(String.valueOf(d));
	}
	
	public double getSizdirganlikKatsayisiTextFieldText() {
		return Double.parseDouble(getSizdirganlikKatsayisiTextField().getText());
	}

	/**
	 * @param cogunluklaKullanilanYapiElemaniSecButtonListener
	 */
	public void addDisDuvarCogunluklaKullanilanYapiElemaniButtonListener(ActionListener cogunluklaKullanilanYapiElemaniSecButtonListener) {
		getDisDuvarSecButton().addActionListener(cogunluklaKullanilanYapiElemaniSecButtonListener);
		
	}

	/**
	 * @param string
	 */
	public void setDisDuvarCogunluklaKullanilanYapiElemaniButtonActionCommand(String string) {
		getDisDuvarSecButton().setActionCommand(string);
	}

	/**
	 * @param cogunluklaKullanilanYapiElemaniSecButtonListener
	 */
	public void addIcDuvarCogunluklaKullanilanYapiElemaniButtonListener(ActionListener cogunluklaKullanilanYapiElemaniSecButtonListener) {
		getÝcDuvarSecButton().addActionListener(cogunluklaKullanilanYapiElemaniSecButtonListener);		
	}

	/**
	 * @param string
	 */
	public void setIcDuvarCogunluklaKullanilanYapiElemaniButtonActionCommand(String string) {
		getÝcDuvarSecButton().setActionCommand(string);		
	}

	/**
	 * @param cogunluklaKullanilanYapiElemaniSecButtonListener
	 */
	public void addPencereCogunluklaKullanilanYapiElemaniButtonListener(ActionListener cogunluklaKullanilanYapiElemaniSecButtonListener) {
		getPencereSecButton().addActionListener(cogunluklaKullanilanYapiElemaniSecButtonListener);		
	}

	/**
	 * @param string
	 */
	public void setPencereCogunluklaKullanilanYapiElemaniButtonActionCommand(String string) {
		getPencereSecButton().setActionCommand(string);		
	}

	/**
	 * @param cogunluklaKullanilanYapiElemaniSecButtonListener
	 */
	public void addDisKapiCogunluklaKullanilanYapiElemaniButtonListener(ActionListener cogunluklaKullanilanYapiElemaniSecButtonListener) {
		getDisKapiSecButton().addActionListener(cogunluklaKullanilanYapiElemaniSecButtonListener);	
	}

	/**
	 * @param string
	 */
	public void setDisKapiCogunluklaKullanilanYapiElemaniButtonActionCommand(String string) {
		getDisKapiSecButton().setActionCommand(string);
	}

	/**
	 * @param cogunluklaKullanilanYapiElemaniSecButtonListener
	 */
	public void addIcKapiCogunluklaKullanilanYapiElemaniButtonListener(ActionListener cogunluklaKullanilanYapiElemaniSecButtonListener) {
		getÝcKapiSecButton().addActionListener(cogunluklaKullanilanYapiElemaniSecButtonListener);
	}

	/**
	 * @param string
	 */
	public void setIcKapiCogunluklaKullanilanYapiElemaniButtonActionCommand(String string) {
		getÝcKapiSecButton().setActionCommand(string);		
	}

	/**
	 * @param isitmaSistemiComboBoxListener
	 */
	public void addIsitmasistemiComboBoxActionListener(ActionListener isitmaSistemiComboBoxListener) {
		getÝsitmaSistemiComboBox().addActionListener(isitmaSistemiComboBoxListener);		
	}

	/**
	 * @param isiticiTuruRadioButtonListener
	 */
	public void addKazanIsiticiTuruRadioButtonactionListener(ActionListener isiticiTuruRadioButtonListener) {
		getKazanIsiticiTuruRadioButton().addActionListener(isiticiTuruRadioButtonListener);		
	}

	/**
	 * @param string
	 */
	public void setKazanIsiticiTuruRadioButtonActionCommand(String string) {
		getKazanIsiticiTuruRadioButton().setActionCommand(string);		
	}

	/**
	 * @param isiticiTuruRadioButtonListener
	 */
	public void addKombiIsiticiTuruRadioButtonactionListener(ActionListener isiticiTuruRadioButtonListener) {
		getKombiIsiticiTuruRadioButton().addActionListener(isiticiTuruRadioButtonListener);
	}

	/**
	 * @param string
	 */
	public void setKombiIsiticiTuruRadioButtonActionCommand(String string) {
		getKombiIsiticiTuruRadioButton().setActionCommand(string);		
	}

    public boolean isNormalBolgeDurumuRadioButtonSelected() {
        return getNormalBolgeDurumuRadioButton().isSelected();
    }

    public boolean isRuzgarliBolgeDurumuRadioButtonSelected() {
        return getRuzgarliBolgeDurumuRadioButton().isSelected();
    }

    public boolean isMahfuzBinaDurumuRadioButtonSelected() {
        return getMahfuzBinaDurumuRadioButton().isSelected();
    }

    public boolean isSerbestBinaDurumuRadioButtonSelected() {
        return getSerbestBinaDurumuRadioButton().isSelected();
    }

    public boolean isCokSerbestBinaDurumuRadioButtonSelected() {
        return getCokSerbestBinaDurumuRadioButton().isSelected();
    }

    public boolean isAyrikNizamRadioButtonSelected() {
        return getAyrikNizamRadioButton().isSelected();
    }

    public boolean isBitisikNizamRadioButtonSelected() {
        return getBitisikNizamRadioButton().isSelected();
    }
	/**
	 * This method initializes isletme1RadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getIsletme1RadioButton() {
		if (isletme1RadioButton == null) {
			isletme1RadioButton = new JRadioButton();
			isletme1RadioButton.setBounds(29, 24, 83, 21);
			isletme1RadioButton.setText("1. Ýþletme");
			isletme1RadioButton.setToolTipText("Konutlar (Sürekli çalýþýr)");
			isletme1RadioButton.setSelected(true);
		}
		return isletme1RadioButton;
	}
	/**
	 * This method initializes isletme2RadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getIsletme2RadioButton() {
		if (isletme2RadioButton == null) {
			isletme2RadioButton = new JRadioButton();
			isletme2RadioButton.setBounds(141, 24, 83, 21);
			isletme2RadioButton.setText("2. Ýþletme");
			isletme2RadioButton.setToolTipText("Ýþyerleri (10 saat söndürülür)");
		}
		return isletme2RadioButton;
	}
	/**
	 * This method initializes isletme3RadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */    
	private JRadioButton getIsletme3RadioButton() {
		if (isletme3RadioButton == null) {
			isletme3RadioButton = new JRadioButton();
			isletme3RadioButton.setBounds(253, 24, 83, 21);
			isletme3RadioButton.setText("3. Ýþletme");
			isletme3RadioButton.setToolTipText("Ýþyerleri (14 saat söndürülür)");
		}
		return isletme3RadioButton;
	}

    public void addIsletme1RadioButtonactionListener(ActionListener isletmeTipiRadioButtonListener) {
        getIsletme1RadioButton().addActionListener(isletmeTipiRadioButtonListener);
    }

    public void setIsletme1RadioButtonActionCommand(String string) {
        getIsletme1RadioButton().setActionCommand(string);        
    }

    public void addIsletme2RadioButtonactionListener(ActionListener isletmeTipiRadioButtonListener) {
        getIsletme2RadioButton().addActionListener(isletmeTipiRadioButtonListener);
        
    }

    public void setIsletme2RadioButtonActionCommand(String string) {
        getIsletme2RadioButton().setActionCommand(string);        
    }

    public void addIsletme3RadioButtonactionListener(ActionListener isletmeTipiRadioButtonListener) {
        getIsletme3RadioButton().addActionListener(isletmeTipiRadioButtonListener);        
    }

    public void setIsletme3RadioButtonActionCommand(String string) {
        getIsletme3RadioButton().setActionCommand(string);
    }

    public boolean AhsapMalzemeRadioButtonSelected() {
        return getAhsapMalzemeRadioButton().isSelected();
    }

    public boolean PlastikMalzemeRadioButtonSelected() {
        return getPlastikMalzemeRadioButton().isSelected();
    }

    public boolean MetalMalzemeRadioButtonSelected() {
        return getMetalMalzemeRadioButton().isSelected();
    }

    public boolean isTekAcilirliTipRadioButtonSelected() {
        return getTekAcilirliTipRadioButton().isSelected();
    }

    public boolean isCiftCamliTipRadioButtonSelected() {
        return getCiftCamliTipRadioButton().isSelected();
    }

    public boolean isCiftAcilirliTipRadioButtonSelected() {
        return getCiftAcilirliTipRadioButton().isSelected();
    }
    
    public CardLayout getDDTreeCardLayoutPanelLayout() {
        return (CardLayout)getDdTreeCardLayoutPanel().getLayout();
    }

    public void addDDTreePanelTreeSelectionListener(TreeSelectionListener ddTreePanelTreeSelectionListener) {       
        ((DDTree)getDdTreePanel()).getJTree().addTreeSelectionListener(ddTreePanelTreeSelectionListener);
    }

    public Object getDDTreeLastSelectedPathComponent() {
        return ((DDTree)getDdTreePanel()).getJTree().getLastSelectedPathComponent();
    }
    
    public void showDdTreeCardLayoutPanelSelectedPanel(String identifier){
        ((CardLayout)getDdTreeCardLayoutPanel().getLayout()).show(getDdTreeCardLayoutPanel(),identifier);
//        getDdTreeCardLayoutPanel().get
    }
    
    public void setDdTreePanelBinaTreeModel(TreeModel customBinaTreeModel) {
        ((DDTree)getDdTreePanel()).setTreeModel(customBinaTreeModel);
    }

    public void addPanelToDdTreeCardLayoutPanel(TreeItemPanel panel, String panelName) {
        getDdTreeCardLayoutPanel().add(panel,panelName);
    }

    public void setDdTreePanelBinaTreeRenderer(MyRenderer renderer) {
        ((DDTree)getDdTreePanel()).getJTree().setCellRenderer(renderer);
    }

    public void setDdTreePanelBinaTreemouseListener(MouseAdapter popupListener) {
        ((DDTree)getDdTreePanel()).getJTree().addMouseListener(popupListener);
    }
    
    public void scrollTree(TreePath path){
        ((DDTree)getDdTreePanel()).getJTree().scrollPathToVisible(path);
    }

    /**
	 * @param cogunluklaKullanilanYapiElemaniSecButtonListener
	 */
	public void addCogunluklaKullanilanYapiElemaniSecButtonListener(
			ActionListener cogunluklaKullanilanYapiElemaniSecButtonListener) {
		getDisDuvarSecButton().addActionListener(
				cogunluklaKullanilanYapiElemaniSecButtonListener);
		getÝcDuvarSecButton().addActionListener(
				cogunluklaKullanilanYapiElemaniSecButtonListener);
		getPencereSecButton().addActionListener(
				cogunluklaKullanilanYapiElemaniSecButtonListener);
		getDisKapiSecButton().addActionListener(
				cogunluklaKullanilanYapiElemaniSecButtonListener);
		getÝcKapiSecButton().addActionListener(
				cogunluklaKullanilanYapiElemaniSecButtonListener);
	}

	/**
	 * @return
	 */
	public YapiElemaniSecimiDialog showYapiElemaniSecimiDialog() {
		YapiElemaniSecimiDialog dialog = new YapiElemaniSecimiDialog();
		SwingUtils.centerAndShowComponent(dialog);

		dialog.setVisible(true);
		return dialog;
	}

    /**
     * @param yapiElemaniKodu
     */
    public void setDisDuvarTextFieldText(String yapiElemaniKodu) {
        getDisDuvarTextField().setText(yapiElemaniKodu);
    }

    /**
     * @param yapiElemaniKodu
     */
    public void setIcDuvarTextFieldText(String yapiElemaniKodu) {
       getIcDuvarTextField().setText(yapiElemaniKodu);
    }

    /**
     * @param yapiElemaniKodu
     */
    public void setPencereTextFieldText(String yapiElemaniKodu) {
        getPencereTextField().setText(yapiElemaniKodu);
    }

    /**
     * @param yapiElemaniKodu
     */
    public void setDisKapiTextFieldText(String yapiElemaniKodu) {
        getDisKapiTextField().setText(yapiElemaniKodu);
    }

    /**
     * @param yapiElemaniKodu
     */
    public void setIcKapiTextFieldText(String yapiElemaniKodu) {
        getÝcKapiTextField().setText(yapiElemaniKodu);
    }

    /**
     * @return
     */
    public RadyatorModeliSecimiDialog showRadyatorModeliSecimiDialog() {
        RadyatorModeliSecimiDialog dialog = new RadyatorModeliSecimiDialog(); 
        SwingUtils.centerAndShowComponent(dialog);		
		return dialog;
    }
    
    public void addRadyatorModeliSecButtonListener(ActionListener radyatorModeliSecButtonListener) {
        getRadyatorModeliSecButton().addActionListener(radyatorModeliSecButtonListener);
    }

    /**
     * @param model
     */
    public void setRadyatorModeliTextFieldText(String model) {
        getRadyatorModeliTextField().setText(model);
    }
	/**
	 * This method initializes isiKazanciPanel1	
	 * 	
	 * @return com.iztek.dd.GUI.IsiKazanciPanel	
	 */    
	public IsiKazanciPanel getIsiKazanciPanel1() {
		if (isiKazanciPanel1 == null) {
			isiKazanciPanel1 = new IsiKazanciPanel();
		}
		return isiKazanciPanel1;
	}
	
	public void setKritikHatTableModel(TableModel model){
	    ((KritikHatPanel)getKritikHatPanel()).setKritikHatTableModel(model);
	}
	public void addKritikHatEkleButtonListener(ActionListener listener){
	    ((KritikHatPanel)getKritikHatPanel()).addEkleButtonListener(listener);
	}
//	public void addKritikHatDuzeltButtonListener(ActionListener listener){
//	    ((KritikHatPanel)getKritikHatPanel()).addDuzeltButtonListener(listener);
//	}
	public void addKritikHatSilButtonListener(ActionListener listener){
	    ((KritikHatPanel)getKritikHatPanel()).addSilButtonListener(listener);
	}
	public ParcaBilgileriDialog showParcaBilgileriDialog(){
        return ((KritikHatPanel)getKritikHatPanel()).showParcaBilgileriDialog();
	}

    /**
     * @return
     */
    public TableModel getKritikHatTableModel() {
        return ((KritikHatPanel)getKritikHatPanel()).getKritikHatTableModel();
    }

	/**
	 * @return
	 */
	public int getKritikHatTableSelectedIndex() {
		return ((KritikHatPanel)getKritikHatPanel()).getKritikHatTableSelectedIndex();
	}

	/**
	 * @return
	 */
//	public IcSicaklikSecimiDialog showIcSicaklikSecimiDialog() {
//        IcSicaklikSecimiDialog dialog = new IcSicaklikSecimiDialog(); 
//        SwingUtils.centerAndShowComponent(dialog);
//		dialog.setVisible(true);
//		return dialog;
//	}

	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			jLabel1 = new JLabel();
			jLabel2 = new JLabel();
			jPanel1.setLayout(null);
			jPanel1.setBounds(218, 326, 193, 87);
			jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Standart Isýtma Enerjisi Ýhtiyacý", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			jLabel1.setText("Q'");
			jLabel1.setLocation(19, 21);
			jLabel1.setSize(60, 24);
			jLabel2.setText("<HTML>kWh/m<SUP>3</SUP></HTML>");
			jLabel2.setLocation(140, 50);
			jLabel2.setSize(47, 24);
			jPanel1.add(jLabel1, null);
			jPanel1.add(getStandartQTextField(), null);
			jPanel1.add(jLabel2, null);
		}
		return jPanel1;
	}
	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */    
	private JTextField getStandartQTextField() {
		if (standartQTextField == null) {
			standartQTextField = new JTextField();
			standartQTextField.setLocation(19, 50);
			standartQTextField.setSize(111, 24);
			standartQTextField.setEditable(false);
		}
		return standartQTextField;
	}

	public void setStandartaUygunlukTextFieldText(String string) {
		standartaUygunlukLabel.setText(string);		
	}

	public void setStandartQTextFieldText(String string) {		
		getStandartQTextField().setText(string);
	}

	public void setStandartaUygunlukTextFieldColor(Color color) {
		standartaUygunlukLabel.setForeground(color);
	}

	public void expandAll() { 
		int row = 0; 
		JTree tree = ((DDTree)getDdTreePanel()).getJTree();
	    while (row < tree.getRowCount()) {
	    	tree.expandRow(row);
	    	row++;
	    }
	} 

	/**
	 * This method initializes yogusmaButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	public JButton getYogusmaButton() {
		if (yogusmaButton == null) {
			yogusmaButton = new JButton();
			yogusmaButton.setLocation(186, 426);
			yogusmaButton.setSize(110, 24);
			yogusmaButton.setText("Yoðuþma");			
		}
		return yogusmaButton;
	}
	/**
	 * This method initializes uzeriAcikTavanYogusmaButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getUzeriAcikTavanYogusmaButton() {
		if (uzeriAcikTavanYogusmaButton == null) {
			uzeriAcikTavanYogusmaButton = new JButton();
			uzeriAcikTavanYogusmaButton.setLocation(186, 328);
			uzeriAcikTavanYogusmaButton.setSize(110, 24);
			uzeriAcikTavanYogusmaButton.setText("Yoðuþma");
		}
		return uzeriAcikTavanYogusmaButton;
	}
	/**
	 * This method initializes catiliTavanYogusmaButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getCatiliTavanYogusmaButton() {
		if (catiliTavanYogusmaButton == null) {
			catiliTavanYogusmaButton = new JButton();
			catiliTavanYogusmaButton.setLocation(186, 328);
			catiliTavanYogusmaButton.setSize(110, 24);
			catiliTavanYogusmaButton.setText("Yoðuþma");
		}
		return catiliTavanYogusmaButton;
	}
	/**
	 * This method initializes acikGecitUzeriYogusmaButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getAcikGecitUzeriYogusmaButton() {
		if (acikGecitUzeriYogusmaButton == null) {
			acikGecitUzeriYogusmaButton = new JButton();
			acikGecitUzeriYogusmaButton.setSize(110, 24);
			acikGecitUzeriYogusmaButton.setLocation(186, 328);
			acikGecitUzeriYogusmaButton.setText("Yoðuþma");
		}
		return acikGecitUzeriYogusmaButton;
	}

    public void setJPanel7ComponentListener(ComponentAdapter adapter) {
        getJPanel19().addComponentListener(adapter);       
    }

    public void setStandartBilesenlerTableModel(DefaultTableModel tableModel) {    
        getIsiYalitimiPanel().setStandartBilesenlerTableModel(tableModel);
    }
	/**
	 * This method initializes kazanSecimiPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	public JPanel getKazanSecimiPanel() {
		if (kazanSecimiPanel == null) {
			kazanSecimiPanel = new KazanSecimiPanel();
			kazanSecimiPanel.setPreferredSize(new java.awt.Dimension(453,340));
		}
		return kazanSecimiPanel;
	}

    public void setJPanel2ComponentListener(ComponentAdapter adapter) {
        getJPanel23().addComponentListener(adapter);
    }

	public void updateKazanPanel(Isitici kazan,KritikHat hat) {
		((KazanSecimiPanel)getKazanSecimiPanel()).updateSelf(kazan,hat);
	}

	public void setKazanSecimiPanelLabels(String string) {
		((KazanSecimiPanel)getKazanSecimiPanel()).setLabels(string);
	}

	public void addKazanSecButtonActionListener(ActionListener listener) {
		((KazanSecimiPanel)getKazanSecimiPanel()).addKazanSecButtonActionListener(listener);
	}

    /**
     * @param listener
     */
    public void addDisDuvarPanelYogusmaButtonListener(ActionListener listener) {        
        getYogusmaButton().addActionListener(listener);
    }

	public void addUzeriAcikTavanYogusmaButtonActionListener(ActionListener listener) {
		getUzeriAcikTavanYogusmaButton().addActionListener(listener);
	}

	public void addCatiliTavanYogusmaButtonActionListener(ActionListener listener) {
		getCatiliTavanYogusmaButton().addActionListener(listener);
	}

	public void addAcikGecitUzeriYogusmaButtonActionListener(ActionListener listener) {
		getAcikGecitUzeriYogusmaButton().addActionListener(listener);
	}

	public void addGenlesmeDeposuDegistirButtonActionListener(ActionListener listener) {
		((KazanSecimiPanel)getKazanSecimiPanel()).addGenlesmeDeposuDegistirButtonActionListener(listener);
	}

	public String getGenlesmeDeposuHacmiTextFieldText() {
		return ((KazanSecimiPanel)getKazanSecimiPanel()).getGenlesmeDeposuHacmiTextFieldText();
	}

	public void setSelectedDepoModeliTextFieldText(String depoModeli) {
		((KazanSecimiPanel)getKazanSecimiPanel()).setSelectedDepoModeliTextFieldText(depoModeli);
	}

    public void setKazanModeliTextFieldText(String model) {
        ((KazanSecimiPanel)getKazanSecimiPanel()).setKazanModeliTextFieldText(model);
    }

    public void addProjePanelComponentShownListener(ComponentAdapter adapter) {
        getJPanel2().addComponentListener(adapter);
    }

    public void addBolgePanelComponentShownListener(ComponentAdapter adapter) {
        getJPanel4().addComponentListener(adapter);        
    }

    public void addBinaKonumBilgileriComponentShownListener(ComponentAdapter adapter) {
        getBinaKonumBilgilerijPanel().addComponentListener(adapter);
    }

    public void setKonutRadioButtonSelected(boolean b) {
        getKonutRadioButton().setSelected(b);
    }

    public void setEnerjiRadioButtonSelected(boolean b) {
        getEnerjiRadioButton().setSelected(b);
    }

    public void setEsit26RadioButtonSelected(boolean b) {
        getEsit26RadioButton().setSelected(b);
    }

    public void setYuksek26RadioButtonSelected(boolean b) {
        getYuksek26RadioButton().setSelected(b);
    }

    public void setAyrikRadioButtonSelected(boolean b) {
        getAyrikRadioButton().setSelected(b);
    }

    public void setMahfuzRadioButtonSelected(boolean b) {
        getMahfuzRadioButton().setSelected(b);
    }

    public void setBitisikRadioButtonSelected(boolean b) {
        getBitisikRadioButton().setSelected(b);
    }

    public void setDogalRadioButtonSelected(boolean b) {
        getDogalRadioButton().setSelected(b);
    }

    public void setMekanikRadioButtonSelected(boolean b) {
        getMekanikRadioButton().setSelected(b);
        getHavalandirmaSecButton().setEnabled(b);
    }

    public void addOzgulIsiKaybiComponentShownListener(ComponentAdapter adapter) {
        getOzgulIsiKaybiPanel1().addComponentListener(adapter);
    }

    public void setPencereAlaniTextFieldText(double alan) {
        getPencereAlanTextField().setText(""+alan);
    }

    public void setPencereUDegeriTextFieldText(double isiGecirgenlikKatsayisi) {
        getPencereUTextField().setText(""+isiGecirgenlikKatsayisi);
    }

    public void setIcOrtamSicakligiTextFieldText(String string) {
        getIcOrtamSicakligiTextField().setText(string);
    }

    public void setGDikDoguBRadioButtonSelected() {
        getGDikDoguBRadioButton().setSelected(true);
    }

    public void setGDikDoguORadioButtonSelected() {
        getGDikDoguORadioButton().setSelected(true);
    }

    public void setGDikDoguKRadioButtonSelected() {
        getGDikDoguKRadioButton().setSelected(true);
    }

    public void setGDikBatiBRadioButtonSelected() {
        getGDikBatiBRadioButton().setSelected(true);
    }

    public void setGDikBatiORadioButtonSelected() {
        getGDikBatiORadioButton().setSelected(true);
    }

    public void setGDikBatiKRadioButtonSelected() {
        getGDikBatiKRadioButton().setSelected(true);
    }

    public void setGDikKuzeyBRadioButtonSelected() {
        getGDikKuzeyBRadioButton().setSelected(true);
    }

    public void setGDikKuzeyORadioButtonSelected() {
        getGDikKuzeyORadioButton().setSelected(true);
    }

    public void setGDikKuzeyKRadioButtonSelected() {
        getGDikKuzeyKRadioButton().setSelected(true);
    }

    public void setGDikGuneyBRadioButtonSelected() {
        getGDikGuneyBRadioButton().setSelected(true);
    }

    public void setGDikGuneyORadioButtonSelected() {
        getGDikGuneyORadioButton().setSelected(true);
    }

    public void setGDikGuneyKRadioButtonSelected() {
        getGDikGuneyKRadioButton().setSelected(true);
    }

    public void setIsitilmayanDuvarAlanTextFieldText(String string) {
        getIsitilmayanDuvarAlanTextField().setText(string);      
    }

    public void setTopragaTemasliDuvarAlanTextFieldText(String string) {
        getTopragaTemasliDuvarAlanTextField().setText(string);
    }

    public void setUzeriAcikTavanAlanTextFieldText(String string) {
        getUzeriAcikTavanAlanTextField().setText(string);
    }

    public void setCatiliTavanAlanTextFieldText(String string) {
        getCatiliTavanAlanTextField().setText(string);
    }

    public void setTopragaTemasliTabanAlanTextFieldText(String string) {
        getTopragaTemasliTabanAlanTextField().setText(string);
    }

    public void setIsitilmayanTabanAlanTextFieldText(String string) {
        getIsitilmayanTabanAlanTextField().setText(string);
    }

    public void setAcikGecitUzeriTabanAlanTextFieldText(String string) {
        getAcikGecitUzeriAlanTextField().setText(string);
    }

    public void addYillikIsitmaIhtiyaciPanelComponentShownListener(ComponentAdapter adapter) {
        getJPanel10().addComponentListener(adapter);
    }

    public void setNormalBolgeDurumuRadioButtonSelected(boolean b) {
        getNormalBolgeDurumuRadioButton().setSelected(b);
    }

    public void setRuzgarliBolgeDurumuRadioButtonSelected(boolean b) {
        getRuzgarliBolgeDurumuRadioButton().setSelected(b);
    }

    public void setMahfuzBinaDurumuRadioButtonSelected(boolean b) {
        getMahfuzBinaDurumuRadioButton().setSelected(b);
    }

    public void setSerbestBinaDurumuRadioButtonSelected(boolean b) {
        getSerbestBinaDurumuRadioButton().setSelected(b);
    }

    public void setCokSerbestBinaDurumuRadioButtonSelected(boolean b) {
        getCokSerbestBinaDurumuRadioButton().setSelected(b);
    }

    public void setBitisikNizamRadioButtonSelected(boolean b) {
        getBitisikNizamRadioButton().setSelected(b);
    }

    public void setAyrikNizamRadioButtonSelected(boolean b) {
        getAyrikNizamRadioButton().setSelected(b);
    }

    public void setOdaDurumKatsayisi07RadioButtonActionSelected(boolean b) {
        getOdaDurumKatsayisi07RadioButton().setSelected(b);
    }

    public void setOdaDurumKatsayisi09RadioButtonActionSelected(boolean b) {
        getOdaDurumKatsayisi09RadioButton().setSelected(b);
    }

    public void setIsletme1RadioButtonSelected(boolean b) {
        getIsletme1RadioButton().setSelected(b);
    }

    public void setIsletme2RadioButtonSelected(boolean b) {
        getIsletme2RadioButton().setSelected(b);
    }

    public void setIsletme3RadioButtonSelected(boolean b) {
        getIsletme3RadioButton().setSelected(b);
    }

    public void setMalzemeAhsapRadioButtonSelected(boolean b) {
        getAhsapMalzemeRadioButton().setSelected(b);
    }

    public void setMalzemePlastikRadioButtonSelected(boolean b) {
        getPlastikMalzemeRadioButton().setSelected(b);
    }

    public void setMalzemeMetalRadioButtonSelected(boolean b) {
        getMetalMalzemeRadioButton().setSelected(b);
    }

    public void setTipTekAcilirliRadioButtonSelected(boolean b) {
        getTekAcilirliTipRadioButton().setSelected(b);
    }

    public void setTipCiftCamliRadioButtonSelected(boolean b) {
        getCiftCamliTipRadioButton().setSelected(b);
    }

    public void setTipCiftAcilirliRadioButtonSelected(boolean b) {
        getCiftAcilirliTipRadioButton().setSelected(b);
    }

    public void setDolasimIsiKaybiSelectedItem(String dolasimIsiKaybi) {
        ((KazanSecimiPanel)kazanSecimiPanel).setDolasimIsiKaybiSelectedItem(dolasimIsiKaybi);
    }


	/**
	 * This method initializes jPanel2	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jPanel2 = new JPanel();
			jPanel2.setLayout(new BorderLayout());
			jPanel2.add(getProjePanel(), java.awt.BorderLayout.CENTER);
			jPanel2.add(getJPanel3(), java.awt.BorderLayout.SOUTH);
		}
		return jPanel2;
	}
	/**
	 * This method initializes jPanel3	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel3() {
		if (jPanel3 == null) {
			jPanel3 = new JPanel();
			jPanel3.add(getJButton1(), null);
		}
		return jPanel3;
	}
	/**
	 * This method initializes jPanel4	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel4() {
		if (jPanel4 == null) {
			jPanel4 = new JPanel();
			jPanel4.setLayout(new BorderLayout());
			jPanel4.add(getBolgePanel(), java.awt.BorderLayout.CENTER);
			jPanel4.add(getJPanel6(), java.awt.BorderLayout.SOUTH);
		}
		return jPanel4;
	}
	/**
	 * This method initializes jPanel6	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel6() {
		if (jPanel6 == null) {
			jPanel6 = new JPanel();
			jPanel6.add(getJButton2(), null);
		}
		return jPanel6;
	}
	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Ýleri>>");
			jButton1.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
				    tanimlarTabbedPane.setSelectedIndex(1);
				}
			});
		}
		return jButton1;
	}
	/**
	 * This method initializes jButton2	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setText("<<Geri");
			jButton2.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
				    tanimlarTabbedPane.setSelectedIndex(0);
				}
			});
		}
		return jButton2;
	}
	
	/**
	 * This method initializes binaKonumBilgilerijPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getBinaKonumBilgilerijPanel() {
		if (binaKonumBilgilerijPanel == null) {
			binaKonumBilgilerijPanel = new JPanel();
			binaKonumBilgilerijPanel.setLayout(new BorderLayout());
			binaKonumBilgilerijPanel.add(getBinaKonumBilgileriPanel(), java.awt.BorderLayout.CENTER);
			binaKonumBilgilerijPanel.add(getJPanel9(), java.awt.BorderLayout.SOUTH);
		}
		return binaKonumBilgilerijPanel;
	}
	/**
	 * This method initializes jPanel9	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel9() {
		if (jPanel9 == null) {
			jPanel9 = new JPanel();
			jPanel9.add(getJButton(), null);
		}
		return jPanel9;
	}
	/**
	 * This method initializes jPanel10	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel10() {
		if (jPanel10 == null) {
			jPanel10 = new JPanel();
			jPanel10.setLayout(new BorderLayout());
			jPanel10.add(getYillikIsitmaIhtiyaciPanel(), java.awt.BorderLayout.CENTER);
			jPanel10.add(getJPanel11(), java.awt.BorderLayout.SOUTH);
		}
		return jPanel10;
	}
	/**
	 * This method initializes jPanel11	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel11() {
		if (jPanel11 == null) {
			jPanel11 = new JPanel();
			jPanel11.add(getJButton4(), null);
		}
		return jPanel11;
	}
	/**
	 * This method initializes ozgulIsiKaybiPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getOzgulIsiKaybiPanel1() {
		if (ozgulIsiKaybiPanel1 == null) {
			ozgulIsiKaybiPanel1 = new JPanel();
			ozgulIsiKaybiPanel1.setLayout(new BorderLayout());
			ozgulIsiKaybiPanel1.add(getOzgulIsiKaybiPanel(), java.awt.BorderLayout.CENTER);
			ozgulIsiKaybiPanel1.add(getYillikIsitmaIhtiyaciPanel1(), java.awt.BorderLayout.SOUTH);
		}
		return ozgulIsiKaybiPanel1;
	}
	/**
	 * This method initializes yillikIsitmaIhtiyaciPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getYillikIsitmaIhtiyaciPanel1() {
		if (yillikIsitmaIhtiyaciPanel1 == null) {
			yillikIsitmaIhtiyaciPanel1 = new JPanel();
			yillikIsitmaIhtiyaciPanel1.add(getJButton5(), null);
			yillikIsitmaIhtiyaciPanel1.add(getJButton6(), null);
		}
		return yillikIsitmaIhtiyaciPanel1;
	}
	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("Ýleri>>");
			jButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					ts825TabbedPane.setSelectedIndex(1);
				}
			});
		}
		return jButton;
	}
	/**
	 * This method initializes jButton4	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getJButton4() {
		if (jButton4 == null) {
			jButton4 = new JButton();
			jButton4.setText("<<Geri");
			jButton4.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
				    ts825TabbedPane.setSelectedIndex(1);
				}
			});
		}
		return jButton4;
	}
	/**
	 * This method initializes jButton5	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getJButton5() {
		if (jButton5 == null) {
			jButton5 = new JButton();
			jButton5.setText("<<Geri");
			jButton5.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
				    ts825TabbedPane.setSelectedIndex(0);
				}
			});
		}
		return jButton5;
	}
	/**
	 * This method initializes jButton6	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getJButton6() {
		if (jButton6 == null) {
			jButton6 = new JButton();
			jButton6.setText("Ýleri>>");
			jButton6.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
				    ts825TabbedPane.setSelectedIndex(2);
				}
			});
		}
		return jButton6;
	}
	/**
	 * This method initializes jPanel8	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel8() {
		if (jPanel8 == null) {
			jPanel8 = new JPanel();
			jPanel8.setLayout(new BorderLayout());
			jPanel8.add(getGenelKatsayilarPanel(), java.awt.BorderLayout.CENTER);
			jPanel8.add(getJPanel12(), java.awt.BorderLayout.SOUTH);
		}
		return jPanel8;
	}
	/**
	 * This method initializes jPanel12	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel12() {
		if (jPanel12 == null) {
			jPanel12 = new JPanel();
			jPanel12.add(getJButton3(), null);
		}
		return jPanel12;
	}
	/**
	 * This method initializes jPanel13	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel13() {
		if (jPanel13 == null) {
			jPanel13 = new JPanel();
			jPanel13.setLayout(new BorderLayout());
			jPanel13.add(getTesisatBilgileriPanel(), java.awt.BorderLayout.CENTER);
			jPanel13.add(getJPanel14(), java.awt.BorderLayout.SOUTH);
		}
		return jPanel13;
	}
	/**
	 * This method initializes jPanel14	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel14() {
		if (jPanel14 == null) {
			jPanel14 = new JPanel();
			jPanel14.add(getJButton7(), null);
			jPanel14.add(getJButton8(), null);
		}
		return jPanel14;
	}
	/**
	 * This method initializes jPanel15	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel15() {
		if (jPanel15 == null) {
			jPanel15 = new JPanel();
			jPanel15.setLayout(new BorderLayout());
			jPanel15.add(getJPanel5(), java.awt.BorderLayout.CENTER);
			jPanel15.add(getJPanel16(), java.awt.BorderLayout.SOUTH);
		}
		return jPanel15;
	}
	/**
	 * This method initializes jPanel16	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel16() {
		if (jPanel16 == null) {
			jPanel16 = new JPanel();
			jPanel16.add(getJButton9(), null);
			jPanel16.add(getJButton10(), null);
		}
		return jPanel16;
	}
	/**
	 * This method initializes jPanel17	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel17() {
		if (jPanel17 == null) {
			jPanel17 = new JPanel();
			jPanel17.setLayout(new BorderLayout());
			jPanel17.add(getKritikHatPanel(), java.awt.BorderLayout.CENTER);
			jPanel17.add(getJPanel18(), java.awt.BorderLayout.SOUTH);
		}
		return jPanel17;
	}
	/**
	 * This method initializes jPanel18	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel18() {
		if (jPanel18 == null) {
			jPanel18 = new JPanel();
			jPanel18.add(getJButton11(), null);
			jPanel18.add(getJButton12(), null);
		}
		return jPanel18;
	}
	/**
	 * This method initializes jPanel19	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel19() {
		if (jPanel19 == null) {
			jPanel19 = new JPanel();
			jPanel19.setLayout(new BorderLayout());
			jPanel19.add(getJPanel7(), java.awt.BorderLayout.CENTER);
			jPanel19.add(getJPanel20(), java.awt.BorderLayout.SOUTH);
		}
		return jPanel19;
	}
	/**
	 * This method initializes jPanel20	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel20() {
		if (jPanel20 == null) {
			jPanel20 = new JPanel();
			jPanel20.add(getJButton13(), null);
			jPanel20.add(getJButton14(), null);
		}
		return jPanel20;
	}
	/**
	 * This method initializes jPanel23	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel23() {
		if (jPanel23 == null) {
			jPanel23 = new JPanel();
			jPanel23.setLayout(new BorderLayout());			
			jPanel23.add(getKazanSecimiPanel(), java.awt.BorderLayout.CENTER);
			jPanel23.add(getJPanel24(), java.awt.BorderLayout.SOUTH);
		}
		return jPanel23;
	}
	/**
	 * This method initializes jPanel24	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getJPanel24() {
		if (jPanel24 == null) {
			jPanel24 = new JPanel();
			jPanel24.add(getJButton15(), null);
		}
		return jPanel24;
	}
	/**
	 * This method initializes jButton3	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setText("Ýleri>>");
			jButton3.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					isiKaybiTabbedPane.setSelectedIndex(1);
				}
			});
		}
		return jButton3;
	}
	/**
	 * This method initializes jButton7	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getJButton7() {
		if (jButton7 == null) {
			jButton7 = new JButton();
			jButton7.setText("<<Geri");
			jButton7.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
				    isiKaybiTabbedPane.setSelectedIndex(0);
				}
			});
		}
		return jButton7;
	}
	/**
	 * This method initializes jButton8	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getJButton8() {
		if (jButton8 == null) {
			jButton8 = new JButton();
			jButton8.setText("Ýleri>>");
			jButton8.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
				    isiKaybiTabbedPane.setSelectedIndex(2);
				}
			});
		}
		return jButton8;
	}
	/**
	 * This method initializes jButton9	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getJButton9() {
		if (jButton9 == null) {
			jButton9 = new JButton();
			jButton9.setText("<<Geri");
			jButton9.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
				    isiKaybiTabbedPane.setSelectedIndex(1);
				}
			});
		}
		return jButton9;
	}
	/**
	 * This method initializes jButton10	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getJButton10() {
		if (jButton10 == null) {
			jButton10 = new JButton();
			jButton10.setText("Ýleri>>");
			jButton10.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
				    isiKaybiTabbedPane.setSelectedIndex(3);
				}
			});
		}
		return jButton10;
	}
	/**
	 * This method initializes jButton11	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getJButton11() {
		if (jButton11 == null) {
			jButton11 = new JButton();
			jButton11.setText("<<Geri");
			jButton11.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
				    isiKaybiTabbedPane.setSelectedIndex(2);
				}
			});
		}
		return jButton11;
	}
	/**
	 * This method initializes jButton12	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getJButton12() {
		if (jButton12 == null) {
			jButton12 = new JButton();
			jButton12.setText("Ýleri>>");
			jButton12.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
				    isiKaybiTabbedPane.setSelectedIndex(4);
				}
			});
		}
		return jButton12;
	}
	/**
	 * This method initializes jButton13	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getJButton13() {
		if (jButton13 == null) {
			jButton13 = new JButton();
			jButton13.setText("<<Geri");
			jButton13.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
				    isiKaybiTabbedPane.setSelectedIndex(3);
				}
			});
		}
		return jButton13;
	}
	/**
	 * This method initializes jButton14	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getJButton14() {
		if (jButton14 == null) {
			jButton14 = new JButton();
			jButton14.setText("Ýleri>>");
			jButton14.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
				    isiKaybiTabbedPane.setSelectedIndex(5);
				}
			});
		}
		return jButton14;
	}
	/**
	 * This method initializes jButton15	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getJButton15() {
		if (jButton15 == null) {
			jButton15 = new JButton();
			jButton15.setText("<<Geri");
			jButton15.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
				    isiKaybiTabbedPane.setSelectedIndex(4);
				}
			});
		}
		return jButton15;
	}

    public void setKombiIsiticiTuruRadioButtonSelected() {
        getKombiIsiticiTuruRadioButton().setSelected(true);
    }

    public void setKazanIsiticiTuruRadioButtonSelected() {
        getKazanIsiticiTuruRadioButton().setSelected(true);
    }

    public void setIsiYalitimiBilesenleriTableModel(IsiYalitimiTableModel tableModel) {
        ((IsiYalitimiPanel)getIsiYalitimiPanel()).setIsiYalitimiBilesenleriTableModel(tableModel);
    }

}  //  @jve:decl-index=0:visual-constraint="10,10"
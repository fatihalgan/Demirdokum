package com.iztek.dd.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
public class MainGUI extends JFrame
{
    /**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -7728501004035690075L;
	
	private JPanel jContentPane;
    private JMenuBar toolMenuBar;
    private JDesktopPane jDesktopPane;
    private JToolBar toolBar;
    private JButton yeniButton;
    private JButton kaydetButton;
    private JButton acButton;
    private JMenu dosyaMenu;
    private JMenuItem acMenuItem;
    private JMenuItem kaydetMenuItem;
	private JMenuItem yeniMenuItem = null;

	private JMenu raporlarMenu = null;
	private JMenuItem yillikIsitmaEnerjisiIhtiyaciItem = null;
	private JMenuItem isiIhtiyaciKimlikBelgesiMenuItem = null;
	private JMenuItem isiKaybiCizelgesiMenuItem = null;
	private JMenuItem cizelge2MenuItem = null;
	private JMenuItem radyatorSecimMenuItem = null;
	private JMenu tanimlarMenu = null;
	private JMenu yardimMenu = null;
	private JMenuItem genelTanimlarMenuItem = null;
	private JMenuItem malzemeTanimlariMenuItem = null;
	private JMenuItem alfaDegeriTanimlarMenuItem = null;
	private JMenuItem uDegeriKayitlariMenuItem = null;
	private JMenuItem jMenuItem4 = null;
	private JMenuItem guncelleMenuItem = null;
	private JMenuItem hakkindaMenuItem = null;
	private JMenuItem isiYalitimMenuItem = null;
	private JMenuItem zetaDegerleriMenuItem = null;
	private JMenuItem boruCapiMenuItem = null;
	private JMenuItem cikisMenuItem = null;
    public MainGUI()
    {
        jContentPane = null;
        toolMenuBar = null;
        jDesktopPane = null;
        toolBar = null;
        yeniButton = null;
        kaydetButton = null;
        acButton = null;
        dosyaMenu = null;
        acMenuItem = null;
        kaydetMenuItem = null;
        initialize();
    }

    private void initialize()
    {
        setTitle("DemirDöküm KTH");
        setSize(800, 600);
        setExtendedState(6);
        setContentPane(getJContentPane());
        setJMenuBar(getToolMenuBar());
        this.addWindowListener(new java.awt.event.WindowAdapter() { 
        	public void windowClosing(java.awt.event.WindowEvent e) {    
        		System.exit(0);
        	}
        });
    }

    private JPanel getJContentPane()
    {
        if(jContentPane == null)
        {
            jContentPane = new JPanel();
            jContentPane.setLayout(new BorderLayout());
            jContentPane.add(getToolBar(), "North");
            jContentPane.add(getJDesktopPane(), "Center");
        }
        return jContentPane;
    }

    private JMenuBar getToolMenuBar()
    {
        if(toolMenuBar == null)
        {
            toolMenuBar = new JMenuBar();
            toolMenuBar.add(getDosyaMenu());
            toolMenuBar.add(getRaporlarMenu());
            toolMenuBar.add(getTanimlarMenu());
            toolMenuBar.add(getYardimMenu());
        }
        return toolMenuBar;
    }

    private JDesktopPane getJDesktopPane()
    {
        if(jDesktopPane == null)
            jDesktopPane = new JDesktopPane(){
			/**
				 * Comment for <code>serialVersionUID</code>
				 */
				private static final long serialVersionUID = 2317458862565482337L;

			public void paintComponent(java.awt.Graphics g) {
				super.paintComponent(g);
				Dimension screen = getJDesktopPane().getSize();
				int x = 0;
				int y = screen.height - 82;
				g.drawImage(new javax.swing.ImageIcon(getClass().getResource("/com/iztek/dd/GUI/images/KOCKOSE_resized.jpg")).getImage(), x, y, null);
				x = (screen.width - 1024) / 2;
				y = (screen.height - 709) / 2;
				g.drawImage(new javax.swing.ImageIcon(getClass().getResource("/com/iztek/dd/GUI/images/kth_fon.jpg")).getImage(), x, y, null);
			}

        };
        return jDesktopPane;
    }

    private JToolBar getToolBar()
    {
        if(toolBar == null)
        {
            toolBar = new JToolBar();
            toolBar.add(getYeniButton());
            toolBar.add(getAcButton());
            toolBar.add(getKaydetButton());
        }
        return toolBar;
    }

    private JButton getYeniButton()
    {
        if(yeniButton == null)
        {
            yeniButton = new JButton();
            yeniButton.setText("");
            yeniButton.setPreferredSize(new java.awt.Dimension(51,28));            
            yeniButton.setIcon(new ImageIcon(getClass().getResource("/com/iztek/dd/GUI/toolbarButtonGraphics/general/New24.gif")));
        }
        return yeniButton;
    }

    private JButton getKaydetButton()
    {
        if(kaydetButton == null)
        {
            kaydetButton = new JButton();
            kaydetButton.setText("");
            kaydetButton.setIcon(new ImageIcon(getClass().getResource("/com/iztek/dd/GUI/toolbarButtonGraphics/general/Save24.gif")));
        }
        return kaydetButton;
    }

    private JButton getAcButton()
    {
        if(acButton == null)
        {
            acButton = new JButton();
            acButton.setText("");
            acButton.setPreferredSize(new java.awt.Dimension(51,28));
            acButton.setIcon(new ImageIcon(getClass().getResource("/com/iztek/dd/GUI/toolbarButtonGraphics/general/Open24.gif")));
        }
        return acButton;
    }

    private JMenu getDosyaMenu()
    {
        if(dosyaMenu == null)
        {
            dosyaMenu = new JMenu();
            dosyaMenu.add(getYeniMenuItem());
            dosyaMenu.add(getAcMenuItem());
            dosyaMenu.add(getKaydetMenuItem());
            dosyaMenu.setText("Dosya");
            dosyaMenu.add(getCikisMenuItem());
        }
        return dosyaMenu;
    }

    private JMenuItem getAcMenuItem()
    {
        if(acMenuItem == null)
        {
            acMenuItem = new JMenuItem();
            acMenuItem.setText("Aç");
        }
        return acMenuItem;
    }

    private JMenuItem getKaydetMenuItem()
    {
        if(kaydetMenuItem == null)
        {
            kaydetMenuItem = new JMenuItem();
            kaydetMenuItem.setText("Kaydet");
        }
        return kaydetMenuItem;
    }

	private JMenuItem getYeniMenuItem() {
		if (yeniMenuItem == null) {
			yeniMenuItem = new JMenuItem();
			yeniMenuItem.setText("Yeni");
		}
		return yeniMenuItem;
	}
	
	public void addYeniActionListener(ActionListener listener){
		getYeniButton().addActionListener(listener);
		getYeniMenuItem().addActionListener(listener);		
	}
	
    public void createNewProject(ProjectGUI projectGUI)
    {
        PropertyListeningInternalFrame projectFrame = new PropertyListeningInternalFrame("Yeni Proje", true, true, true, true);
        projectGUI.addPropertyChangeListener(projectFrame);
        projectFrame.setSize(710, 600);
        projectFrame.getContentPane().setLayout(new BorderLayout());
        projectFrame.getContentPane().add(projectGUI, "Center");
        getJDesktopPane().add(projectFrame);
        projectFrame.setVisible(true);
    }    
	/**
	 * This method initializes raporlarMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */    
	private JMenu getRaporlarMenu() {
		if (raporlarMenu == null) {
			raporlarMenu = new JMenu();
			raporlarMenu.setText("Raporlar");
			raporlarMenu.add(getYillikIsitmaEnerjisiIhtiyaciItem());
			raporlarMenu.add(getIsiIhtiyaciKimlikBelgesiMenuItem());
			raporlarMenu.add(getÝsiKaybiCizelgesiMenuItem());
			raporlarMenu.add(getCizelge2MenuItem());
			raporlarMenu.add(getRadyatorSecimMenuItem());
			raporlarMenu.add(getIsiYalitimMenuItem());
			raporlarMenu.add(getZetaDegerleriMenuItem());
			raporlarMenu.add(getBoruCapiMenuItem());
		}
		return raporlarMenu;
	}
	/**
	 * This method initializes yillikIsitmaEnerjisiIhtiyaciItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */    
	private JMenuItem getYillikIsitmaEnerjisiIhtiyaciItem() {
		if (yillikIsitmaEnerjisiIhtiyaciItem == null) {
			yillikIsitmaEnerjisiIhtiyaciItem = new JMenuItem();
			yillikIsitmaEnerjisiIhtiyaciItem.setText("Yýllýk Isýtma Enerjisi Ýhtiyaci");
		}
		return yillikIsitmaEnerjisiIhtiyaciItem;
	}

    public void addRaporlarActionListener(ActionListener listener) {
        getYillikIsitmaEnerjisiIhtiyaciItem().addActionListener(listener);
        getIsiIhtiyaciKimlikBelgesiMenuItem().addActionListener(listener);
        getÝsiKaybiCizelgesiMenuItem().addActionListener(listener);
        getCizelge2MenuItem().addActionListener(listener);
        getRadyatorSecimMenuItem().addActionListener(listener);
        getIsiYalitimMenuItem().addActionListener(listener);
        getZetaDegerleriMenuItem().addActionListener(listener);
        getBoruCapiMenuItem().addActionListener(listener);
    }

    public void setOzgulIsiKaybiMenuItemActionCommand(String string) {
        getYillikIsitmaEnerjisiIhtiyaciItem().setActionCommand(string);        
    }

    public PropertyListeningInternalFrame getActiveProjectFrame(){
        return (PropertyListeningInternalFrame)getJDesktopPane().getSelectedFrame();
    }
    
    public ProjectGUI getActiveProjectGUI(){
    	JInternalFrame selectedFrame = getJDesktopPane().getSelectedFrame();
    	if(selectedFrame!=null){
    		return (ProjectGUI)selectedFrame.getContentPane().getComponent(0);	
    	}
        return null;
    }

    public String showFileChoser(boolean save) {
        setUILanguage();
        JFileChooser fileChooser = new JFileChooser("saves");
        if(save)fileChooser.setDialogTitle("Kaydet");
        if(!save)fileChooser.setDialogTitle("Aç");
        if(!save)fileChooser.addChoosableFileFilter(new MyFilter());
        Dimension dim = getToolkit().getScreenSize();
        fileChooser.setLocation((dim.width - fileChooser.getSize().width)/2,(dim.height - fileChooser.getSize().height)/2 );
        int returnVal;
        if(!save)returnVal = fileChooser.showOpenDialog(this);
        else returnVal = fileChooser.showSaveDialog(this);        
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            if(selectedFile!=null){
                String path = selectedFile.getPath();
                selectedFile = null;
                return path;
            }
        }
        return null;
    }
    class MyFilter extends javax.swing.filechooser.FileFilter {
        public boolean accept(File file) {
            String filename = file.getName();
            return filename.endsWith(".dds");
        }
        public String getDescription() {
            return "*.dds";
        }
    }

    public void setUILanguage() {
        Locale locale = new Locale("tr");
        UIManager.put
          ("FileChooser.lookInLabelText", "Þimdiki");
        UIManager.put
          ("FileChooser.filesOfTypeLabelText", "Dosya tipi");
        UIManager.put
          ("FileChooser.upFolderToolTipText", "Yukarý");
        UIManager.put
        ("FileChooser.fileNameLabelText", "Dosya adý");
        UIManager.put
        ("FileChooser.homeFolderToolTipText", "Kullanýcý klasörü");
        UIManager.put
        ("FileChooser.newFolderToolTipText", "Yeni klasör");
        UIManager.put
        ("FileChooser.listViewButtonToolTipText", "Liste görünümü");
        UIManager.put
        ("FileChooser.detailsViewButtonToolTipText", "Detay görünümü");
        UIManager.put
        ("FileChooser.saveButtonText", "Kaydet");
        UIManager.put
        ("FileChooser.openButtonText", "Aç");
        UIManager.put
        ("FileChooser.cancelButtonText", "Ýptal");
        UIManager.put
        ("FileChooser.updateButtonText", "Güncelle");
        UIManager.put
        ("FileChooser.helpButtonText", "Yardým");
        UIManager.put
        ("FileChooser.saveButtonToolTipText", "Kaydet");
        UIManager.put
        ("FileChooser.openButtonToolTipText", "Aç");
        UIManager.put
        ("FileChooser.cancelButtonToolTipText", "Ýptal");
        UIManager.put
        ("FileChooser.updateButtonToolTipText", "Güncelle");
        UIManager.put
        ("FileChooser.helpButtonToolTipText", "Yardým");
    }

	/**
	 * This method initializes isiIhtiyaciKimlikBelgesiMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */    
	private JMenuItem getIsiIhtiyaciKimlikBelgesiMenuItem() {
		if (isiIhtiyaciKimlikBelgesiMenuItem == null) {
			isiIhtiyaciKimlikBelgesiMenuItem = new JMenuItem();
			isiIhtiyaciKimlikBelgesiMenuItem.setText("Isý Ýhtiyaci Kimlik Belgesi");
		}
		return isiIhtiyaciKimlikBelgesiMenuItem;
	}

    public void setIsiIhtiyaciKimlikBelgesiActionCommand(String string) {
        getIsiIhtiyaciKimlikBelgesiMenuItem().setActionCommand(string);
    }
	/**
	 * This method initializes cizelge2MenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */    
	private JMenuItem getÝsiKaybiCizelgesiMenuItem() {
		if (isiKaybiCizelgesiMenuItem == null) {
			isiKaybiCizelgesiMenuItem = new JMenuItem();
			isiKaybiCizelgesiMenuItem.setText("Isý Kaybý Çizelgesi");
		}
		return isiKaybiCizelgesiMenuItem;
	}

	public void setIsiKaybiCizelgesiActionCommand(String string) {
		getÝsiKaybiCizelgesiMenuItem().setActionCommand(string);
	}

	public void setCizelge2ActionCommand(String string) {
		getCizelge2MenuItem().setActionCommand(string);
	}
	/**
	 * This method initializes cizelge2MenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */    
	private JMenuItem getCizelge2MenuItem() {
		if (cizelge2MenuItem == null) {
			cizelge2MenuItem = new JMenuItem();
			cizelge2MenuItem.setText("Binanýn Özgül Isý Kaybý");
		}
		return cizelge2MenuItem;
	}
	/**
	 * This method initializes genelTanimlarMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */    
	private JMenuItem getRadyatorSecimMenuItem() {
		if (radyatorSecimMenuItem == null) {
			radyatorSecimMenuItem = new JMenuItem();
			radyatorSecimMenuItem.setText("Radyatör ve Donanýmý Seçim Çizelgesi");
		}
		return radyatorSecimMenuItem;
	}

	public void setRadyatorSecimiActionCommand(String string) {
		getRadyatorSecimMenuItem().setActionCommand(string);
	}
	/**
	 * This method initializes tanimlarMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */    
	private JMenu getTanimlarMenu() {
		if (tanimlarMenu == null) {
			tanimlarMenu = new JMenu();
			tanimlarMenu.setText("Tanýmlar");
			tanimlarMenu.add(getGenelTanimlarMenuItem());
			tanimlarMenu.add(getMalzemeTanimlariMenuItem());
			tanimlarMenu.add(getAlfaDegeriTanimlarMenuItem());
			tanimlarMenu.add(getUDegeriKayitlariMenuItem());
		}
		return tanimlarMenu;
	}
	/**
	 * This method initializes yardimMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */    
	private JMenu getYardimMenu() {
		if (yardimMenu == null) {
			yardimMenu = new JMenu();
			yardimMenu.setText("Yardým");
			yardimMenu.add(getJMenuItem4());
			yardimMenu.add(getGuncelleMenuItem());
			yardimMenu.add(getHakkindaMenuItem());
		}
		return yardimMenu;
	}
	/**
	 * This method initializes genelTanimlarMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */    
	private JMenuItem getGenelTanimlarMenuItem() {
		if (genelTanimlarMenuItem == null) {
			genelTanimlarMenuItem = new JMenuItem();
			genelTanimlarMenuItem.setText("Genel Tanýmlar");
		}
		return genelTanimlarMenuItem;
	}
	/**
	 * This method initializes malzemeTanimlariMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */    
	private JMenuItem getMalzemeTanimlariMenuItem() {
		if (malzemeTanimlariMenuItem == null) {
			malzemeTanimlariMenuItem = new JMenuItem();
			malzemeTanimlariMenuItem.setText("Malzeme Tanýmlarý");
		}
		return malzemeTanimlariMenuItem;
	}
	/**
	 * This method initializes alfaDegeriTanimlarMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */    
	private JMenuItem getAlfaDegeriTanimlarMenuItem() {
		if (alfaDegeriTanimlarMenuItem == null) {
			alfaDegeriTanimlarMenuItem = new JMenuItem();
			alfaDegeriTanimlarMenuItem.setText("Alfa Deðeri Tanýmlarý");
		}
		return alfaDegeriTanimlarMenuItem;
	}
	/**
	 * This method initializes uDegeriKayitlariMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */    
	private JMenuItem getUDegeriKayitlariMenuItem() {
		if (uDegeriKayitlariMenuItem == null) {
			uDegeriKayitlariMenuItem = new JMenuItem();
			uDegeriKayitlariMenuItem.setText("U deðeri Kayýtlarý");
		}
		return uDegeriKayitlariMenuItem;
	}
	/**
	 * This method initializes jMenuItem4	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */    
	private JMenuItem getJMenuItem4() {
		if (jMenuItem4 == null) {
			jMenuItem4 = new JMenuItem();
			jMenuItem4.setText("Yardým...");
		}
		return jMenuItem4;
	}
	/**
	 * This method initializes guncelleMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */    
	private JMenuItem getGuncelleMenuItem() {
		if (guncelleMenuItem == null) {
			guncelleMenuItem = new JMenuItem();
			guncelleMenuItem.setText("Güncelleme Sihirbazý");
		}
		return guncelleMenuItem;
	}
	/**
	 * This method initializes hakkindaMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */    
	private JMenuItem getHakkindaMenuItem() {
		if (hakkindaMenuItem == null) {
			hakkindaMenuItem = new JMenuItem();
			hakkindaMenuItem.setText("Hakkýnda...");
		}
		return hakkindaMenuItem;
	}
	public void addGuncelleMenuItemActionListener(ActionListener listener) {
		getGuncelleMenuItem().addActionListener(listener);
	}

    public void addSaveActionListener(ActionListener listener) {
        getKaydetButton().addActionListener(listener);
    }

    public void addLoadActionListener(ActionListener listener) {
        getAcButton().addActionListener(listener);
    }

    public void addHelpMenuItemActionListener(ActionListener listener) {
        getJMenuItem4().addActionListener(listener);
    }

    public void addGenelTanimlarMenuItemActionListener(ActionListener listener) {
        getGenelTanimlarMenuItem().addActionListener(listener);
    }

    public void addMalzemeTanimlariMenuItemActionListener(ActionListener listener) {
        getMalzemeTanimlariMenuItem().addActionListener(listener);
    }

    public void addUDegeriTanimlariMenuItemActionListener(ActionListener listener) {
        getUDegeriKayitlariMenuItem().addActionListener(listener);
    }

    public void addHakkindaMenuItemActionListener(ActionListener listener) {
        hakkindaMenuItem.addActionListener(listener);
    }

    public void addAlfaDegeriTanimlarMenuItemActionListener(ActionListener listener) {
        alfaDegeriTanimlarMenuItem.addActionListener(listener);
    }

    public void addSaveMenuItemActionListener(ActionListener listener) {
        kaydetMenuItem.addActionListener(listener);
    }

    public void addLoadMenuItemActionListener(ActionListener listener) {
        acMenuItem.addActionListener(listener);
    }
	/**
	 * This method initializes isiYalitimMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */    
	private JMenuItem getIsiYalitimMenuItem() {
		if (isiYalitimMenuItem == null) {
			isiYalitimMenuItem = new JMenuItem();
			isiYalitimMenuItem.setText("Isý Yalýtým Projesi");
		}
		return isiYalitimMenuItem;
	}

    public void addIsiYalitimMenuItemActionCommand(String string) {
        getIsiYalitimMenuItem().setActionCommand(string);
    }
	/**
	 * This method initializes zetaDegerleriMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */    
	private JMenuItem getZetaDegerleriMenuItem() {
		if (zetaDegerleriMenuItem == null) {
			zetaDegerleriMenuItem = new JMenuItem();
			zetaDegerleriMenuItem.setText("Zeta Deðerleri Hesap Çizelgesi");
		}
		return zetaDegerleriMenuItem;
	}

    public void addZetaDegerleriMenuItemActionCommand(String string) {
        getZetaDegerleriMenuItem().setActionCommand(string);
    }
	/**
	 * This method initializes boruCapiMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */    
	private JMenuItem getBoruCapiMenuItem() {
		if (boruCapiMenuItem == null) {
			boruCapiMenuItem = new JMenuItem();
			boruCapiMenuItem.setText("Boru Çapý Hesap Çizelgesi");
		}
		return boruCapiMenuItem;
	}

    public void addBoruCapiMenuItemActionCommand(String string) {
        getBoruCapiMenuItem().setActionCommand(string);
    }
	/**
	 * This method initializes cikisMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */    
	private JMenuItem getCikisMenuItem() {
		if (cikisMenuItem == null) {
			cikisMenuItem = new JMenuItem();
			cikisMenuItem.setText("Çýkýþ");
			cikisMenuItem.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					System.exit(0);
				}
			});
		}
		return cikisMenuItem;
	}
    }
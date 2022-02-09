package Janelas;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;

public class Util {

	public static Font FONT_KG;

	
	public Util(){
		try {
		    //create the font to use. Specify the size!
		    FONT_KG = Font.createFont(Font.TRUETYPE_FONT, new File("figuras/KGHAPPY.ttf")).deriveFont(54f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(FONT_KG);
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
	}
	
		
	// Cores
	public static final Color COR_PADRAO_FUNDO = new Color(124,69,156);
	public static final Color COR_PADRAO_FONTE = new Color(255,223,211);
	public static final Color COR_PADRAO_FONTE2 = new Color(0,0,0);
	public static final Color COR_PADRAO_BFECHAR = new Color(255,105,97);
	public static final Color COR_PADRAO_BMINI = new Color(149,125,173);
	
	
	
	//figuras
	public static final ImageIcon CIRCUFERENCIA_1 = new ImageIcon(Util.class.getResource("/Apr.png"));
	public static final ImageIcon CIRCUFERENCIA_2 = new ImageIcon(Util.class.getResource("/Apr4.png"));
	public static final ImageIcon ICONE_VOLTAR = new ImageIcon(Util.class.getResource("/voltar2.png"));
	
	
}

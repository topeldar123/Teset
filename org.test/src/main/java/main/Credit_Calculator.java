package main;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

public class Credit_Calculator {
	
	/** СЃРѕР·РґР°РЅРёРµ РїРµСЂРµРјРµРЅРЅС‹С…, РґРѕСЃС‚СѓРїРЅС‹С… 
	 *  РІ Р»СЋР±РѕРј РјРµС‚РѕРґРµ РєР»Р°СЃСЃР° **/
	/** РџРµСЂРµРјРµРЅРЅР°СЏ - СЃСѓРјРјР° РєСЂРµРґРёС‚Р° **/
	private static double 	var_sum;
	/** РџРµСЂРµРјРµРЅРЅР°СЏ - СЃСЂРѕРє РєСЂРµРґРёС‚Р° **/
	private static int 		var_period;
	/** РџРµСЂРµРјРµРЅРЅР°СЏ - РїСЂРѕС†РµРЅС‚С‹ РїРѕ РєСЂРµРґРёС‚Сѓ **/
	private static double 	var_percent;
	/** РџРµСЂРµРјРµРЅРЅР°СЏ - РµР¶РµРјРµСЃСЏС‡РЅР°СЏ РєРѕРјРёСЃСЃРёСЏ **/
	private static double 	var_month_com;
	/** РџРµСЂРµРјРµРЅРЅР°СЏ - РµРґРёРЅРѕРІСЂРµРјРµРЅРЅР°СЏ РєРѕРјРёСЃСЃРёСЏ **/
	private static double 	var_onetime_com;
	/** РџРµСЂРµРјРµРЅРЅР°СЏ - РµРґРµРЅРёС†С‹ РёР·РјРµСЂРµРЅРёСЏ СЃСЂРѕРєР° РєСЂРµРґРёС‚Р° **/
	private static String 	var_box_period;
	/** РџРµСЂРµРјРµРЅРЅР°СЏ - РІРёРґ РїР»Р°С‚РµР¶РµР№ РєСЂРµРґРёС‚Р° **/
	private static String 	var_box_type;
	/** РњР°СЃСЃРёРІ РёР· 3 РїРµСЂРµРјРµРЅРЅС‹С… РґР»СЏ Р·Р°РїРёСЃРё РґР°С‚С‹ РЅР°С‡Р°Р»Р° РІС‹РїР»Р°С‚ **/
	private static int [] 	var_box_date = new int [3];

	/** Р­РєР·РµРјРїР»СЏСЂ РєР»Р°СЃСЃР° Р“СЂРёРіРѕСЂРёР°РЅСЃРєРёР№ РєР°Р»РµРЅРґР°СЂСЊ **/
	private static GregorianCalendar calendar = new GregorianCalendar();
	/** РџРµСЂРµРјРµРЅРЅР°СЏ, СЃРѕРґРµСЂР¶Р°С‰Р°СЏ РЅРѕРјРµСЂ РґРЅСЏ С‚РµРєСѓС‰РµР№ РґР°С‚С‹ **/
	private static int day_now = calendar.get(Calendar.DAY_OF_MONTH);
	/** РџРµСЂРµРјРµРЅРЅР°СЏ, СЃРѕРґРµСЂР¶Р°С‰Р°СЏ РЅРѕРјРµСЂ РјРµСЃСЏС†Р° С‚РµРєСѓС‰РµР№ РґР°С‚С‹ **/
	private static int month_now = calendar.get(Calendar.MONTH);
	/** РџРµСЂРµРјРµРЅРЅР°СЏ, СЃРѕРґРµСЂР¶Р°С‰Р°СЏ РЅРѕРјРµСЂ РіРѕРґР° С‚РµРєСѓС‰РµР№ РґР°С‚С‹ **/
	private static int year_now = calendar.get(Calendar.YEAR);
		
	public static void main(String[] args) {

		/* РіСЂР°С„РёС‡РµСЃРєРѕРµ РѕРєРЅРѕ СЃ РёРЅС‚РµСЂС„РµР№СЃРѕРј РїСЂРѕРіСЂР°РјРјС‹ */
		JFrame window = new JFrame("РљСЂРµРґРёС‚РЅС‹Р№ РєР°Р»СЊРєСѓР»СЏС‚РѕСЂ");
		/* РІС‹С…РѕРґ РёР· РїСЂРѕРіСЂР°РјРјС‹ РїСЂРё Р·Р°РєСЂС‹С‚РёРё РѕРєРЅР° */
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/* Р·Р°РґР°РЅРёРµ СЂР°Р·РјРµСЂРѕРІ РѕРєРЅР° */
		window.setSize(360, 560);
		/* Р·Р°РїСЂРµС‚ РЅР° РёР·РјРµРЅРµРЅРёРµ СЂР°Р·РјРµСЂРѕРІ РѕРєРЅР° */
		window.setResizable(false);
		/* СЂР°СЃРїРѕР»РѕР¶РµРЅРёРµ РѕРєРЅР° РїРѕ С†РµРЅС‚СЂСѓ СЌРєСЂР°РЅР° */
		window.setLocationRelativeTo(null);
		
		/* РїР°РЅРµР»СЊ РґР»СЏ СЂР°СЃРїРѕР»РѕР¶РµРЅРёСЏ РіСЂР°С„РёС‡РµСЃРєРёС… СЌР»РµРјРµРЅС‚РѕРІ РёРЅС‚РµСЂС„РµР№СЃР° */
		JPanel mainPanel=new JPanel();
		/* РѕС‚РєР»СЋС‡РµРЅРёРµ РґРёСЃРїРµС‚С‡РµСЂРѕРІ СЂР°Р·РјРµС‰РµРЅРёСЏ:
		 * СЂР°СЃРїРѕР»РѕР¶РµРЅРёРµ СЌР»РµРјРµРЅС‚РѕРІ РїСЂРѕРёР·РІРѕРґРёС‚СЃСЏ РІСЂСѓС‡РЅСѓСЋ */
		mainPanel.setLayout(null);
		
		/* СЃС‚РёР»СЊ С‚РµРєСЃС‚Р° РґР»СЏ С‚РµРєСЃС‚РѕРІС‹С… РїРѕР»РµР№ РІРІРѕРґР° 
		 * С€СЂРёС„С‚ Dialog, РЅР°С‡РµСЂС‚Р°РЅРёРµ РѕР±С‹С‡РЅРѕРµ, СЂР°Р·РјРµСЂ 25 */
		Font textfield_font = new Font("Dialog", Font.PLAIN, 25);
		
		/* СЃРѕР·РґР°РЅРёРµ С‚РµРєСЃС‚РѕРІС‹С… РїРѕР»РµР№ РІРІРѕРґР°*/
		
		/* РїРѕР»Рµ вЂ” СЃСѓРјРјР° РєСЂРµРґРёС‚Р° */
		final JTextField SummaField = new JTextField();
		/* РїРѕР»Рµ вЂ” СЃСЂРѕРє РєСЂРµРґРёС‚Р° */
		final JTextField PeriodField = new JTextField();
		/* РїРѕР»Рµ вЂ” РїСЂРѕС†РµРЅС‚ РїРѕ РєСЂРµРґРёС‚Сѓ */
		final JTextField PercentField = new JTextField();
		/* РїРѕР»Рµ вЂ” РµР¶РµРјРµСЃСЏС‡РЅР°СЏ РєРѕРјРёСЃСЃРёСЏ */
		final JTextField CommissionField = new JTextField();
		/* РїРѕР»Рµ вЂ” РµРґРёРЅРѕРІСЂРµРјРµРЅРЅР°СЏ РєРѕРјРёСЃСЃРёСЏ */
		final JTextField OnetimeField = new JTextField();
		
		/* СЌРєР·РµРјРїР»СЏСЂ РєР»Р°СЃСЃР° CreateFields */		
		CreateFields create = new CreateFields();
		/* РІС‹Р±РѕСЂ РїР°РЅРµР»Рё РґР»СЏ СЂР°Р·РјРµС‰РµРЅРёСЏ РѕР±СЉРµРєС‚РѕРІ */
		create.addPanel(mainPanel);
		
		/* Р·Р°РґР°РЅРёРµ РїР°СЂР°РјРµС‚СЂРѕРІ РґР»СЏ С‚РµРєСЃС‚РѕРІС‹С… РїРѕР»РµР№ РІРІРѕРґР°
		 * РїРѕ СЃС…РµРјРµ (РёРјСЏ РїРѕР»СЏ, РєРѕРѕСЂРґРёРЅР°С‚Р° РҐ, РєРѕРѕСЂРґРёРЅР°С‚Р° РЈ, С€РёСЂРёРЅР°, РІС‹СЃРѕС‚Р°, СЃС‚РёР»СЊ) */
		create.CreateTextField(SummaField, 20, 20, 300, 30, textfield_font);
		create.CreateTextField(PeriodField, 20, 80, 218, 30, textfield_font);
		create.CreateTextField(PercentField, 20, 140, 300, 30, textfield_font);
		create.CreateTextField(CommissionField, 20, 345, 300, 30, textfield_font);
		create.CreateTextField(OnetimeField, 20, 405, 300, 30, textfield_font);
		
		/* СЃС‚РёР»СЊ С‚РµРєСЃС‚Р° РґР»СЏ С‚РµРєСЃС‚РѕРІС‹С… РїРѕР»РµР№ РЅР°РґРїРёСЃРµР№ 
		 * С€СЂРёС„С‚ Arial, РЅР°С‡РµСЂС‚Р°РЅРёРµ Р¶РёСЂРЅРѕРµ, СЂР°Р·РјРµСЂ 15 */
		Font label_font = new Font("Arial", Font.BOLD, 15);
		
		/* СЃРѕР·РґР°РЅРёРµ С‚РµРєСЃС‚РѕРІС‹С… РїРѕР»РµР№ РЅР°РґРїРёСЃРµР№ */
		JLabel sum_label = new JLabel("РЎСѓРјРјР° РєСЂРµРґРёС‚Р°, СЂСѓР±");
		JLabel period_label = new JLabel("РЎСЂРѕРє РєСЂРµРґРёС‚Р°");
		JLabel percent_label = new JLabel("РџСЂРѕС†РµРЅС‚РЅР°СЏ СЃС‚Р°РІРєР° (РІ РіРѕРґ), %");
		JLabel type_label = new JLabel("Р’РёРґ РїР»Р°С‚РµР¶РµР№");
		JLabel day_label = new JLabel("Р”РµРЅСЊ");
		JLabel month_label = new JLabel("РњРµСЃСЏС†");
		JLabel year_label = new JLabel("Р“РѕРґ");
		JLabel date_label = new JLabel("Р”Р°С‚Р° РІС‹РґР°С‡Рё РєСЂРµРґРёС‚Р°");
		JLabel comission_label = new JLabel("Р•Р¶РµРјРµСЃСЏС‡РЅР°СЏ РєРѕРјРёСЃСЃРёСЏ, %");
		JLabel onetime_label = new JLabel("Р•РґРёРЅРѕРІСЂРµРјРµРЅРЅР°СЏ РєРѕРјРёСЃСЃРёСЏ, %");
		
		/* Р·Р°РґР°РЅРёРµ РїР°СЂР°РјРµС‚СЂРѕРІ РґР»СЏ С‚РµРєСЃС‚РѕРІС‹С… РїРѕР»РµР№ РЅР°РґРїРёСЃРµР№
		 * РїРѕ СЃС…РµРјРµ (РёРјСЏ РїРѕР»СЏ, РєРѕРѕСЂРґРёРЅР°С‚Р° РҐ, РєРѕРѕСЂРґРёРЅР°С‚Р° РЈ, С€РёСЂРёРЅР°, РІС‹СЃРѕС‚Р°, СЃС‚РёР»СЊ) */
		create.CreateLabel(sum_label, 20, 55, 390, 15, label_font);
		create.CreateLabel(period_label, 20, 115, 390, 15, label_font);
		create.CreateLabel(percent_label, 20, 175, 390, 15, label_font);
		create.CreateLabel(type_label, 20, 235, 390, 15, label_font);
		create.CreateLabel(day_label, 20, 295, 390, 15, label_font);
		create.CreateLabel(month_label, 100, 295, 390, 15, label_font);
		create.CreateLabel(year_label, 180, 295, 360, 15, label_font);
		create.CreateLabel(date_label, 20, 320, 390, 15, label_font);
		create.CreateLabel(comission_label, 20, 380, 390, 15, label_font);
		create.CreateLabel(onetime_label, 20, 440, 390, 15, label_font);

		/* СЃС‚РёР»СЊ С‚РµРєСЃС‚Р° РґР»СЏ РІС‹РїР°РґР°СЋС‰РёС… СЃРїРёСЃРєРѕРІ
		 * С€СЂРёС„С‚ Dialog, РЅР°С‡РµСЂС‚Р°РЅРёРµ РѕР±С‹С‡РЅРѕРµ, СЂР°Р·РјРµСЂ 20 */
		Font combobox_font = new Font("Dialog", Font.PLAIN, 20);
		
        /* С‚РµРєСЃС‚РѕРІС‹Р№ РјР°СЃСЃРёРІ вЂ” РµРґРёРЅРёС†С‹ РёР·РјРµСЂРµРЅРёСЏ СЃСЂРѕРєР° РєСЂРµРґРёС‚Р° */
		String[] period = {
				"РјРµСЃ.",
				"РіРѕРґ"
		};
		
		/* РІС‹РїР°РґР°СЋС‰РёР№ СЃРїРёСЃРѕРє вЂ” РµРґРёРЅРёС†С‹ РёР·РјРµСЂРµРЅРёСЏ СЃСЂРѕРєР° РєСЂРµРґРёС‚Р° */
		JComboBox period_box = new JComboBox(period);		
		/* Р·Р°РїРёСЃСЊ РІС‹Р±СЂР°РЅРЅРѕРіРѕ СЌР»РµРјРµРЅС‚Р° РёР· СЃРїРёСЃРєР° РІ РїРµСЂРµРјРµРЅРЅСѓСЋ */
		var_box_period = (String)period_box.getSelectedItem();
		
		/* СЃРѕР·РґР°РЅРёРµ СЃР»СѓС€Р°С‚РµР»СЏ РґРµР№СЃС‚РІРёР№ */
		ActionListener period_Listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* РґРѕР±Р°РІР»РµРЅРёРµ РѕР±СЉРµРєС‚Р° СЃРѕР±С‹С‚РёСЏ */
		    	JComboBox box = (JComboBox)e.getSource();
		    	
		    	/* Р·Р°РїРёСЃСЊ РІС‹Р±СЂР°РЅРЅРѕРіРѕ СЌР»РµРјРµРЅС‚Р° РёР· СЃРїРёСЃРєР° РІ РїРµСЂРµРјРµРЅРЅСѓСЋ */
		    	var_box_period = (String)box.getSelectedItem();
		    }
		};
		/* РґРѕР±Р°РІР»РµРЅРёРµ СЃР»СѓС€Р°С‚РµР»СЏ Рє РѕР±СЉРµРєС‚Сѓ */
		period_box.addActionListener(period_Listener);

		
		/* С‚РµРєСЃС‚РѕРІС‹Р№ РјР°СЃСЃРёРІ вЂ” РІРёРґС‹ РїР»Р°С‚РµР¶РµР№ РїРѕ РєСЂРµРґРёС‚Сѓ */
		String[] type = {
				"РђРЅРЅСѓРёС‚РµС‚РЅС‹Р№",
				"Р”РёС„С„РµСЂРµРЅС†РёСЂРѕРІР°РЅРЅС‹Р№"
		};
		
		/* РІС‹РїР°РґР°СЋС‰РёР№ СЃРїРёСЃРѕРє вЂ” РІРёРґС‹ РїР»Р°С‚РµР¶РµР№ РїРѕ РєСЂРµРґРёС‚Сѓ */
		JComboBox type_box = new JComboBox(type);
		/* Р·Р°РїРёСЃСЊ РІС‹Р±СЂР°РЅРЅРѕРіРѕ СЌР»РµРјРµРЅС‚Р° РёР· СЃРїРёСЃРєР° РІ РїРµСЂРµРјРµРЅРЅСѓСЋ */
		var_box_type = (String)type_box.getSelectedItem();
		
		/* СЃРѕР·РґР°РЅРёРµ СЃР»СѓС€Р°С‚РµР»СЏ РґРµР№СЃС‚РІРёР№ */	
		ActionListener type_Listener = new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	/* РґРѕР±Р°РІР»РµРЅРёРµ РѕР±СЉРµРєС‚Р° СЃРѕР±С‹С‚РёСЏ */
		    	JComboBox box = (JComboBox)e.getSource();
		    	
		    	/* Р·Р°РїРёСЃСЊ РІС‹Р±СЂР°РЅРЅРѕРіРѕ СЌР»РµРјРµРЅС‚Р° РёР· СЃРїРёСЃРєР° РІ РїРµСЂРµРјРµРЅРЅСѓСЋ */
		    	var_box_type = (String)box.getSelectedItem();
		    }
		};
		/* РґРѕР±Р°РІР»РµРЅРёРµ СЃР»СѓС€Р°С‚РµР»СЏ Рє РѕР±СЉРµРєС‚Сѓ */
		type_box.addActionListener(type_Listener);
				
		/* С‚РµРєСЃС‚РѕРІС‹Р№ РјР°СЃСЃРёРІ вЂ” РЅРѕРјРµСЂР° РґРЅРµР№ РјРµСЃСЏС†Р° */
		String[] days = new String [31];
		/* Р·Р°РїРѕР»РЅРµРЅРёРµ РјР°СЃСЃРёРІР° С‡РёСЃР»Р°РјРё РѕС‚ 1 РґРѕ 31 */
		for (int i = 1; i<=31; i++) {
			days[i-1] = "" + i;
		}
		
		/* РІС‹РїР°РґР°СЋС‰РёР№ СЃРїРёСЃРѕРє вЂ” РЅРѕРјРµСЂ РґРЅСЏ РґР°С‚С‹ РЅР°С‡Р°Р»Р° РІС‹РїР»Р°С‚ */
		final JComboBox day_box = new JComboBox(days);
		/* СѓСЃС‚Р°РЅРѕРІРєР° РІС‹Р±СЂР°РЅРЅРѕРіРѕ СЌР»РµРјРµРЅС‚Р° РЅР° С‚РµРєСѓС‰СѓСЋ РґР°С‚Сѓ */
		day_box.setSelectedIndex(day_now-1);
		/* Р·Р°РїРёСЃСЊ РІС‹Р±СЂР°РЅРЅРѕРіРѕ СЌР»РµРјРµРЅС‚Р° РёР· СЃРїРёСЃРєР° РІ РїРµСЂРµРјРµРЅРЅСѓСЋ */
		var_box_date[0] = Integer.parseInt((String)day_box.getSelectedItem());
		
		/* СЃРѕР·РґР°РЅРёРµ СЃР»СѓС€Р°С‚РµР»СЏ РґРµР№С‚СЃРІРёР№ */
		ActionListener day_Listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* РґРѕР±Р°РІР»РµРЅРёРµ РѕР±СЉРµРєС‚Р° СЃРѕР±С‹С‚РёСЏ */
		    	JComboBox box = (JComboBox)e.getSource();
		    	
		    	/* Р·Р°РїРёСЃСЊ РІС‹Р±СЂР°РЅРЅРѕРіРѕ СЌР»РµРјРµРЅС‚Р° РёР· СЃРїРёСЃРєР° РІ РїРµСЂРµРјРµРЅРЅСѓСЋ */
		    	String str = (String)box.getSelectedItem();
		    	/* РїРµСЂРµРІРѕРґ РёР· СЃС‚СЂРѕРєРѕРІРѕРіРѕ С‚РёРїР° РІ С†РµР»РѕС‡РёСЃР»РµРЅРЅС‹Р№ */
		    	var_box_date[0] = Integer.parseInt(str);
		    }
		};
		/* РґРѕР±Р°РІР»РµРЅРёРµ СЃР»СѓС€Р°С‚РµР»СЏ Рє РѕР±СЉРµРєС‚Сѓ */
		day_box.addActionListener(day_Listener);
		
		/* С‚РµРєСЃС‚РѕРІС‹Р№ РјР°СЃСЃРёРІ вЂ” РЅРѕРјРµСЂР° РјРµСЃСЏС†РµРІ */
		String[] month = new String [12];
		/* Р·Р°РїРѕР»РЅРµРЅРёРµ РјР°СЃСЃРёРІР° С‡РёСЃР»Р°РјРё РѕС‚ 1 РґРѕ 12 */
		for (int i = 1; i<=12; i++) {
			month[i-1] = "" + i;
		}
		
		/* РІС‹РїР°РґР°СЋС‰РёР№ СЃРїРёСЃРѕРє вЂ” РЅРѕРјРµСЂ РјРµСЃСЏС†Р° РґР°С‚С‹ РЅР°С‡Р°Р»Р° РІС‹РїР»Р°С‚ */
		final JComboBox month_box = new JComboBox(month);
		/* СѓСЃС‚Р°РЅРѕРІРєР° РІС‹Р±СЂР°РЅРЅРѕРіРѕ СЌР»РµРјРµРЅС‚Р° РЅР° С‚РµРєСѓС‰СѓСЋ РґР°С‚Сѓ */
		month_box.setSelectedIndex(month_now);
		/* Р·Р°РїРёСЃСЊ РІС‹Р±СЂР°РЅРЅРѕРіРѕ СЌР»РµРјРµРЅС‚Р° РёР· СЃРїРёСЃРєР° РІ РїРµСЂРµРјРµРЅРЅСѓСЋ */
		var_box_date[1] = Integer.parseInt((String)month_box.getSelectedItem());
		
		/* СЃРѕР·РґР°РЅРёРµ СЃР»СѓС€Р°С‚РµР»СЏ РґРµР№С‚СЃРІРёР№**/
		ActionListener month_Listener = new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	/* РґРѕР±Р°РІР»РµРЅРёРµ РѕР±СЉРµРєС‚Р° СЃРѕР±С‹С‚РёСЏ */
		    	JComboBox box = (JComboBox)e.getSource();
		    	
		    	/* Р·Р°РїРёСЃСЊ РІС‹Р±СЂР°РЅРЅРѕРіРѕ СЌР»РµРјРµРЅС‚Р° РёР· СЃРїРёСЃРєР° РІ РїРµСЂРµРјРµРЅРЅСѓСЋ */
		    	String str = (String)box.getSelectedItem();
		    	/* РїРµСЂРµРІРѕРґ РёР· СЃС‚СЂРѕРєРѕРІРѕРіРѕ С‚РёРїР° РІ С†РµР»РѕС‡РёСЃР»РµРЅРЅС‹Р№ */
		    	var_box_date[1] = Integer.parseInt(str);
		    }
		};
		/* РґРѕР±Р°РІР»РµРЅРёРµ СЃР»СѓС€Р°С‚РµР»СЏ Рє РѕР±СЉРµРєС‚Сѓ */
		month_box.addActionListener(month_Listener);
		
		/* С‚РµРєСЃС‚РѕРІС‹Р№ РјР°СЃСЃРёРІ вЂ” РЅРѕРјРµСЂР° РіРѕРґРѕРІ, 
		 * РєРѕРіРґР° РјРѕР¶РЅРѕ РѕС„РѕСЂРјРёС‚СЊ РєСЂРµРґРёС‚ */
		String[] years = new String [10];
		/* Р·Р°РїРѕР»РЅРµРЅРёРµ РјР°СЃСЃРёРІР° С‡РёСЃР»Р°РјРё: 
		 * РЅС‹РЅРµС€РЅРёР№ РіРѕРґ + 9 РїРѕСЃР»РµРґСѓСЋС‰РёС… Р»РµС‚ */
		for (int i = 0; i<10; i++) {
			years[i] = "" + (i + year_now);
		}
		
		/* РІС‹РїР°РґР°СЋС‰РёР№ СЃРїРёСЃРѕРє вЂ” РЅРѕРјРµСЂ РіРѕРґР° РґР°С‚С‹ РЅР°С‡Р°Р»Р° РІС‹РїР»Р°С‚ */
		final JComboBox year_box = new JComboBox(years);
		/* Р·Р°РїРёСЃСЊ РІС‹Р±СЂР°РЅРЅРѕРіРѕ СЌР»РµРјРµРЅС‚Р° РёР· СЃРїРёСЃРєР° РІ РїРµСЂРµРјРµРЅРЅСѓСЋ */
		var_box_date[2] = Integer.parseInt((String)year_box.getSelectedItem());
		
		/* СЃРѕР·РґР°РЅРёРµ СЃР»СѓС€Р°С‚РµР»СЏ РґРµР№С‚СЃРІРёР№ */
		ActionListener year_Listener = new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	/* СЃРѕР·РґР°РЅРёРµ РѕР±СЉРµРєС‚Р° СЃРѕР±С‹С‚РёСЏ */
		    	JComboBox box = (JComboBox)e.getSource();
		    	
		    	/* Р·Р°РїРёСЃСЊ РІС‹Р±СЂР°РЅРЅРѕРіРѕ СЌР»РµРјРµРЅС‚Р° РёР· СЃРїРёСЃРєР° РІ РїРµСЂРµРјРµРЅРЅСѓСЋ */
		    	String str = (String)box.getSelectedItem();
		    	/* РїРµСЂРµРІРѕРґ РёР· СЃС‚СЂРѕРєРѕРІРѕРіРѕ С‚РёРїР° РІ С†РµР»РѕС‡РёСЃР»РµРЅРЅС‹Р№ */
		    	var_box_date[2] = Integer.parseInt(str);
		    }
		};
		/* РґРѕР±Р°РІР»РµРЅРёРµ СЃР»СѓС€Р°С‚РµР»СЏ Рє РѕР±СЉРµРєС‚Сѓ */
		year_box.addActionListener(year_Listener);
		
		/* Р·Р°РґР°РЅРёРµ РїР°СЂР°РјРµС‚СЂРѕРІ РґР»СЏ РІС‹РїР°РґР°СЋС‰РёС… СЃРїРёСЃРєРѕРІ
		 * РїРѕ СЃС…РµРјРµ (РёРјСЏ РїРѕР»СЏ, РєРѕРѕСЂРґРёРЅР°С‚Р° РҐ, РєРѕРѕСЂРґРёРЅР°С‚Р° РЈ, С€РёСЂРёРЅР°, РІС‹СЃРѕС‚Р°, СЃС‚РёР»СЊ) */
		create.CreateComboBox(period_box, 243, 80, 77, 30, combobox_font);
		create.CreateComboBox(type_box, 20, 200, 300, 30, combobox_font);
		create.CreateComboBox(day_box, 20, 260, 60, 30, combobox_font);
		create.CreateComboBox(month_box, 100, 260, 60, 30, combobox_font);
		create.CreateComboBox(year_box, 180, 260, 85, 30, combobox_font);	

		/* СЃС‚РёР»СЊ С‚РµРєСЃС‚Р° РґР»СЏ РєРЅРѕРїРєРё
		 * С€СЂРёС„С‚ Arial, РЅР°С‡РµСЂС‚Р°РЅРёРµ РѕР±С‹С‡РЅРѕРµ, СЂР°Р·РјРµСЂ 25 */
		Font button_font = new Font("Arial", Font.PLAIN, 25);
		
		/* РєРЅРѕРїРєР° РґР»СЏ СЂР°СЃС‡РµС‚Р° Рё РІС‹РІРѕРґР° СЂРµР·СѓР»СЊС‚Р°С‚РѕРІ */
		JButton result_button = new JButton ("Р Р°СЃcС‡РёС‚Р°С‚СЊ");
		/* Р·Р°РґР°РЅРёРµ РїР°СЂР°РјРµС‚СЂРѕРІ РґР»СЏ РєРЅРѕРїРєРё РїРѕ СЃС…РµРјРµ 
		 * (РёРјСЏ РїРѕР»СЏ, РєРѕРѕСЂРґРёРЅР°С‚Р° РҐ, РєРѕРѕСЂРґРёРЅР°С‚Р° РЈ, С€РёСЂРёРЅР°, РІС‹СЃРѕС‚Р°, СЃС‚РёР»СЊ) */
		create.CreateButton(result_button, 20, 465, 300, 45, button_font);

		/* РґРѕР±Р°РІР»РµРЅРёРµ СЃР»СѓС€Р°С‚РµР»СЏ РґР»СЏ РєРЅРѕРїРєРё */
		result_button.addMouseListener( new MouseAdapter()			
		{
			/** РњРµС‚РѕРґ РѕР±СЂР°Р±РѕС‚РєРё РЅР°Р¶Р°С‚РёСЏ РЅР° РєРЅРѕРїРєСѓ **/
			public void mouseClicked(MouseEvent event) {
				/* Р·Р°РґР°РЅРёРµ Р·РЅР°С‡РµРЅРёСЏ РїРµСЂРµРјРµРЅРЅРѕР№ */
				check = true;
				
				/* РІС‹Р·РѕРІ РјРµС‚РѕРґР° РїСЂРѕРІРµСЂРєРё РІРІРµРґРµРЅРЅС‹С… РґР°РЅРЅС‹С…
				 * РїРѕ СЃС…РµРјРµ (РёРјСЏ РїРѕР»СЏ, РјРёРЅРёРјР°Р»СЊРЅРѕРµ Р·РЅР°С‡РµРЅРёРµ, РјР°РєСЃРёРјР°Р»СЊРЅРѕРµ Р·РЅР°С‡РµРЅРёРµ) */
				Credit_Calculator.control(SummaField, 10000, 5000000);
				Credit_Calculator.control(PeriodField, 1, 360);
				if (var_box_period == "РіРѕРґ") Credit_Calculator.control(PeriodField, 1, 30);
				Credit_Calculator.control(PercentField, 5, 40);
				Credit_Calculator.control(CommissionField, 0, 5);
				Credit_Calculator.control(OnetimeField, 0, 3);
				/* РѕСЃС‚Р°РЅРѕРІРєР° РІС‹РїРѕР»РЅРµРЅРёСЏ РјРµС‚РѕРґР° РїСЂРё РЅР°Р»РёС‡РёРё РѕС€РёР±РѕРє РІРІРѕРґР° */
				if (!check) return;

				/* РїСЂРёСЃРІРѕРµРЅРёРµ РїРµСЂРµРјРµРЅРЅС‹Рј РІРІРµРґРµРЅРЅС‹С… Р·РЅР°С‡РµРЅРёР№ РёР· РїРѕР»РµР№ */
				var_sum = Double.parseDouble(SummaField.getText());
				var_period = Integer.parseInt(PeriodField.getText());
				var_percent  = Double.parseDouble(PercentField.getText());
				var_month_com = Double.parseDouble(CommissionField.getText());
				var_onetime_com = Double.parseDouble(OnetimeField.getText());
				var_box_date[0] = Integer.parseInt((String)day_box.getSelectedItem());
				var_box_date[1] = Integer.parseInt((String)month_box.getSelectedItem());
				var_box_date[2] = Integer.parseInt((String)year_box.getSelectedItem());
				
				/* РІС‹Р·РѕРІ РјРµС‚РѕРґР° РѕР±СЂР°Р±РѕС‚РєРё РґР°С‚С‹ */
				Credit_Calculator.time();
				/* РІС‹Р·РѕРІ РјРµС‚РѕРґР° СЂР°СЃС‡РµС‚Р° СЃСѓРјРј РїР»Р°С‚РµР¶РµР№ РїРѕ РєРѕРјРёСЃСЃРёСЏРј*/
				Credit_Calculator.commission();
				
				/* РІС‹Р·РѕРІ РѕРїСЂРµРґРµР»РµРЅРЅРѕРіРѕ РјРµС‚РѕРґР°, РІ Р·Р°РІРёСЃРёРјРѕСЃС‚Рё РѕС‚ РІС‹Р±СЂР°РЅРЅРѕРіРѕ РІРёРґР° РїР»Р°С‚РµР¶РµР№ */
				if (var_box_type.equals("РђРЅРЅСѓРёС‚РµС‚РЅС‹Р№")) {
					Credit_Calculator.calculate_anuity(var_sum, var_period, var_percent, var_month_com, var_onetime_com);
					Credit_Calculator.window_anuity();
				}else {
					Credit_Calculator.calculate_diff(var_sum, var_period, var_percent, var_month_com, var_onetime_com);
					Credit_Calculator.window_diff();
				}
			}
		});
		/* РґРѕР±Р°РІР»РµРЅРёРµ РїР°РЅРµР»Рё РІ РѕРєРЅРѕ */
		window.setContentPane(mainPanel);
		/* Р·Р°РґР°РЅРёРµ РІРёРґРёРјРѕСЃС‚Рё РѕРєРЅР° */
		window.setVisible(true);
	}
	
	/** РћР±СЉРµРєС‚ вЂ“ С„РѕСЂРјР°С‚ Р·Р°РїРёСЃРё РґР°С‚С‹ **/
	private static DateFormat date_format = new SimpleDateFormat("dd.MM.yyyy");
	/** РњРµС‚РѕРґ РѕР±СЂР°Р±РѕС‚РєРё РґР°С‚С‹**/
	private static void time() {
		/* РџСЂРёСЃРІРѕРµРЅРёРµ С‚РµРєСѓС‰РµР№ РґР°С‚С‹ РѕР±СЉРµРєС‚Сѓ РєР°Р»РµРЅРґР°СЂСЊ */
		calendar.set(Calendar.YEAR, var_box_date[2]);
		calendar.set(Calendar.MONTH, var_box_date[1]-1);
		calendar.set(Calendar.DAY_OF_MONTH, var_box_date[0]);
		
		if (var_box_period == "РіРѕРґ") {
			var_period *= 12;
		}
	}
	
	/** РњРµС‚РѕРґ СЂР°СЃС‡РµС‚Р° СЃСѓРјРј РІС‹РїР»Р°С‚ РїРѕ РєРѕРјРёСЃСЃРёСЏРј **/
	private static void commission() {
		/* РІС‹С‡РёСЃР»РµРЅРёРµ СЃСѓРјРјС‹ РїР»Р°С‚РµР¶Р° РїРѕ РµР¶РµРјРµСЃСЏС‡РЅРѕР№ РєРѕРјРёСЃСЃРёРё */
		if (var_month_com != 0) {
			var_month_com = (Math.rint(100*((var_sum * var_month_com)/100)))/100;
		}
		/* РІС‹С‡РёСЃР»РµРЅРёРµ СЃСѓРјРјС‹ РїР»Р°С‚РµР¶Р° РїРѕ РµРґРёРЅРѕРІСЂРµРјРµРЅРЅРѕР№ РєРѕРјРёСЃСЃРёРё */
		if (var_onetime_com != 0) {
			var_onetime_com = (Math.rint(100*((var_sum * var_onetime_com)/100)))/100;
		}
	}
	

	/** РЎС‚СЂРѕРєРѕРІС‹Р№ РјР°СЃСЃРёРІ - СЂРµР·СѓР»СЊС‚Р°С‚С‹ СЂР°СЃС‡РµС‚РѕРІ Р°РЅРЅСѓРёС‚РµС‚РЅС‹С… РїР»Р°С‚РµР¶РµР№ **/
	public static String [] result_anuity = new String[4];
	
	/** РџСѓР±Р»РёС‡РЅС‹Р№ РјРµС‚РѕРґ СЂР°СЃС‡РµС‚Р° Р°РЅРЅСѓРёС‚РµС‚РЅС‹С… РїР»Р°С‚РµР¶РµР№ **/
	public static void calculate_anuity(double var_sum, int var_period, double var_percent, double var_month_com, double var_onetime_com) {
	
		/* СЂР°СЃС‡РµС‚ РґР°С‚С‹ РєРѕРЅС†Р° РІС‹РїР»Р°С‚ */
		calendar.add(Calendar.MONTH, var_period);
		/* Р·Р°РїРёСЃСЊ РєРѕРЅРµС‡РЅРѕР№ РґР°С‚С‹ РІ СЃС‚СЂРѕРєРѕРІСѓСЋ РїРµСЂРµРјРµРЅРЅСѓСЋ */
		String end_date = date_format.format(calendar.getTime());
		
		/* РїРµСЂРµРјРµРЅРЅР°СЏ - РµР¶РµРјРµСЃСЏС‡РЅС‹Р№ РїР»Р°С‚РµР¶ */
		double payment = 0;
		/* РїРµСЂРµРјРµРЅРЅР°СЏ - СЃСѓРјРјР° РІС‹РїР»Р°С‚ */
		double sum_payment;
		/* РїРµСЂРµРјРµРЅРЅР°СЏ - РїРµСЂРµРїР»Р°С‚Р° */
		double overpay;
		
		/* СЂР°СЃС‡РµС‚ РµР¶РµРјРµСЃСЏС‡РЅРѕР№ РїСЂРѕС†РµРЅС‚РЅРѕР№ СЃС‚Р°РІРєРё */
		var_percent = (Math.rint(100000000*(var_percent/(100*12))))/100000000;
		
		/* СЂР°СЃС‡РµС‚ РµР¶РµРјРµСЃСЏС‡РЅРѕРіРѕ РїР»Р°С‚РµР¶Р°, СЃСѓРјРјС‹ РІС‹РїР»Р°С‚ Рё РїРµСЂРµРїР»Р°С‚С‹ */
		payment = (var_sum*var_percent)/(1 - Math.pow((1+var_percent), -var_period)) + var_month_com;
		sum_payment = payment*var_period + var_onetime_com;
		sum_payment = (Math.rint(100*(sum_payment)))/100;
		payment = (Math.rint(100*(payment)))/100;
		overpay = sum_payment - var_sum;
	
		/* Р·Р°РїРёСЃСЊ СЂРµР·СѓР»СЊС‚Р°С‚РѕРІ РІ РѕР±СЉРµРєС‚С‹ BigDecimal
		 * РґР»СЏ РєРѕСЂСЂРµРєС‚РЅРѕРіРѕ РІС‹РІРѕРґР° Р±РѕР»СЊС€РёС… С‡РёСЃРµР»*/
		BigDecimal big_summ = new BigDecimal(sum_payment);
		BigDecimal big_overpay = new BigDecimal(overpay);
		/* Р·Р°РґР°РЅРёРµ РїР°СЂР°РјРµС‚СЂРѕРІ РІС‹РІРѕРґР°: 
		 * РєРѕР»РёС‡РµСЃС‚РІРѕ С†РёС„СЂ РїРѕСЃР»Рµ Р·Р°РїСЏС‚РѕР№, С‚РёРї РѕРєСЂСѓРіР»РµРЅРёСЏ*/
		big_summ = big_summ.setScale(2, BigDecimal.ROUND_HALF_DOWN);
		big_overpay = big_overpay.setScale(2, BigDecimal.ROUND_HALF_UP);
	
		/* Р·Р°РїРёСЃСЊ РїРµСЂРµРјРµРЅРЅС‹С… РІ РјР°СЃСЃРёРІ СЂРµР·СѓР»СЊС‚Р°С‚РѕРІ */
		result_anuity[0] = big_summ.toString();
		result_anuity[1] = big_overpay.toString();
		result_anuity[2] = Double.toString(payment);
		result_anuity[3] = end_date;
	}
	
	/** РџСѓР±Р»РёС‡РЅС‹Р№ РјРµС‚РѕРґ, РІРѕР·РІСЂР°С‰Р°СЋС‰РёР№ Р·РЅР°С‡РµРЅРёРµ 
	 *  СЃСѓРјРјС‹ РІС‹РїР»Р°С‚ РїРѕ Р°РЅРЅСѓРёС‚РµС‚РЅРѕРјСѓ РєСЂРµРґРёС‚Сѓ **/
	public static double getSumm_anuity() {
		double summ = Double.parseDouble(result_anuity[0]);
		return summ;
	}
	
	/** РџСѓР±Р»РёС‡РЅС‹Р№ РјРµС‚РѕРґ, РІРѕР·РІСЂР°С‰Р°СЋС‰РёР№ Р·РЅР°С‡РµРЅРёРµ 
	 *  РїРµСЂРµРїР»Р°С‚С‹ РїРѕ Р°РЅРЅСѓРёС‚РµС‚РЅРѕРјСѓ РєСЂРµРґРёС‚Сѓ **/
	public static double getOverpay_anuity() {
		double overpay= Double.parseDouble(result_anuity[1]);
		return overpay;
	}
	
	/** РџСѓР±Р»РёС‡РЅС‹Р№ РјРµС‚РѕРґ, РІРѕР·РІСЂР°С‰Р°СЋС‰РёР№ Р·РЅР°С‡РµРЅРёРµ 
	 *  РµР¶РµРјРµСЃСЏС‡РЅРѕРіРѕ РїР»Р°С‚РµР¶Р° РїРѕ Р°РЅРЅСѓРёС‚РµС‚РЅРѕРјСѓ РєСЂРµРґРёС‚Сѓ **/
	public static double getPayment_anuity() {
		double payment= Double.parseDouble(result_anuity[2]);
		return payment;
	}
	
	/** РњРµС‚РѕРґ, РІС‹РІРѕРґСЏС‰РёР№ РЅР° СЌРєСЂР°РЅ РІ РЅРѕРІРѕРј РѕРєРЅРµ
	 *  СЂРµР·СѓР»СЊС‚Р°С‚С‹ СЂР°СЃС‡РµС‚РѕРІ РїРѕ Р°РЅРЅСѓРёС‚РµС‚РЅРѕРјСѓ РїР»Р°С‚РµР¶Сѓ **/
	static void window_anuity() {

		/* СЃС‚РёР»СЊ С‚РµРєСЃС‚Р° РґР»СЏ С‚РµРєСЃС‚РѕРІС‹С… РїРѕР»РµР№ РЅР°РґРїРёСЃРµР№
		 * С€СЂРёС„С‚ Arial, РЅР°С‡РµСЂС‚Р°РЅРёРµ РѕР±С‹С‡РЅРѕРµ, СЂР°Р·РјРµСЂ 16 */
		Font label_result_font = new Font("Arial", Font.PLAIN, 16);
		
		/* РіСЂР°С„РёС‡РµСЃРєРѕРµ РѕРєРЅРѕ СЃ СЂРµР·СѓР»СЊС‚Р°С‚Р°РјРё СЂР°СЃС‡РµС‚РѕРІ */
		JFrame frame = new JFrame("РђРЅРЅСѓРёС‚РµС‚РЅС‹Р№ РєСЂРµРґРёС‚");
		/* Р·Р°РґР°РЅРёРµ СЂР°Р·РјРµСЂР° РѕРєРЅР° */
		frame.setSize(360, 200);
		/* Р·Р°РїСЂРµС‚ РЅР° РёР·РјРµРЅРµРЅРёРµ СЂР°Р·РјРµСЂРѕРІ РѕРєРЅР° */
		frame.setResizable(false);
		/* СЂР°СЃРїРѕР»РѕР¶РµРЅРёРµ РѕРєРЅР° РїРѕ С†РµРЅС‚СЂСѓ СЌРєСЂР°РЅР° */
		frame.setLocationRelativeTo(null);
		
		/* РїР°РЅРµР»СЊ РґР»СЏ СЂР°СЃРїРѕР»РѕР¶РµРЅРёСЏ РЅР°РґРїРёСЃРµР№ СЃ СЂРµР·СѓР»СЊС‚Р°С‚Р°РјРё СЂР°СЃС‡РµС‚РѕРІ */
		JPanel panel_result = new JPanel();
		/* РѕС‚РєР»СЋС‡РµРЅРёРµ РґРёСЃРїРµС‚С‡РµСЂРѕРІ СЂР°Р·РјРµС‰РµРЅРёСЏ:
		 * СЂР°СЃРїРѕР»РѕР¶РµРЅРёРµ СЌР»РµРјРµРЅС‚РѕРІ РїСЂРѕРёР·РІРѕРґРёС‚СЃСЏ РІСЂСѓС‡РЅСѓСЋ */
		panel_result.setLayout(null);
		
		/* СЃРѕР·РґР°РЅРёРµ С‚РµРєСЃС‚РѕРІС‹С… РїРѕР»РµР№ РЅР°РґРїРёСЃРµР№ */
		JLabel labelsum = new JLabel();
        JLabel labelpereplata = new JLabel();
        JLabel labelm_plata = new JLabel();
        JLabel labeldata = new JLabel();
        JLabel labelres = new JLabel("Р Р•Р—РЈР›Р¬РўРђРўР« Р РђРЎР§Р•РўРћР’:");
        
        /* СЌРєР·РµРјРїР»СЏСЂ РєР»Р°СЃСЃР° CreateFields */	
        CreateFields creator = new CreateFields();
		/* РІС‹Р±РѕСЂ РїР°РЅРµР»Рё РґР»СЏ СЂР°Р·РјРµС‰РµРЅРёСЏ РѕР±СЉРµРєС‚РѕРІ */
		creator.addPanel(panel_result);
		
        /* Р·Р°РґР°РЅРёРµ РїР°СЂР°РјРµС‚СЂРѕРІ РґР»СЏ С‚РµРєСЃС‚РѕРІС‹С… РїРѕР»РµР№ РЅР°РґРїРёСЃРµР№
		 * РїРѕ СЃС…РµРјРµ (РёРјСЏ РїРѕР»СЏ, РєРѕРѕСЂРґРёРЅР°С‚Р° РҐ, РєРѕРѕСЂРґРёРЅР°С‚Р° РЈ, С€РёСЂРёРЅР°, РІС‹СЃРѕС‚Р°, СЃС‚РёР»СЊ) */
        creator.CreateLabel(labelsum, 20, 55, 390, 15, label_result_font);
        creator.CreateLabel(labelpereplata, 20, 80, 390, 15, label_result_font);
        creator.CreateLabel(labelm_plata, 20, 105, 390, 15, label_result_font);
        creator.CreateLabel(labeldata, 20, 130, 390, 15, label_result_font);
        creator.CreateLabel(labelres, 60, 20, 390, 15, new Font("Arial", Font.PLAIN, 18));
		
        /* Р·Р°РїРѕР»РЅРµРЅРёРµ С‚РµРєСЃС‚РѕРј РЅР°РґРїРёСЃРµР№ */
		labelsum.setText("Р�С‚РѕРіРѕРІР°СЏ СЃСѓРјРјР° РІС‹РїР»Р°С‚: " + result_anuity[0] + " СЂСѓР±.");
		labelpereplata.setText("РџРµСЂРµРїР»Р°С‚Р°: " + result_anuity[1] + " СЂСѓР±.");
		labelm_plata.setText("Р•Р¶РµРјРµСЃСЏС‡РЅС‹Р№ РїР»Р°С‚РµР¶: " + result_anuity[2] + " СЂСѓР±."); 
		labeldata.setText("Р”Р°С‚Р° РѕРєРѕРЅС‡Р°РЅРёСЏ РІС‹РїР»Р°С‚: " + result_anuity[3]);
		
		/* РґРѕР±Р°РІР»РµРЅРёРµ РїР°РЅРµР»Рё РІ РѕРєРЅРѕ */
		frame.add(panel_result);
		/* Р·Р°РґР°РЅРёРµ РІРёРґРёРјРѕСЃС‚Рё РѕРєРЅР° */		
		frame.setVisible(true);
	}

	/** РЎС‚СЂРѕРєРѕРІС‹Р№ РјР°СЃСЃРёРІ - РЅР°Р·РІР°РЅРёСЏ СЃС‚РѕР»Р±С†РѕРІ РёС‚РѕРіРѕРІРѕР№ С‚Р°Р±Р»РёС†С‹ **/
	static String [] name_column_table = new String [1];
	/** Р”РІСѓРјРµСЂРЅС‹Р№ СЃС‚СЂРѕРєРѕРІС‹Р№ РјР°СЃСЃРёРІ - РґР°РЅРЅС‹Рµ РёС‚РѕРіРѕРІРѕР№ С‚Р°Р±Р»РёС†С‹ **/
	static String [][] data_table = new String [1][1];
	
	/** РњРµС‚РѕРґ СЂР°СЃС‡РµС‚Р° РґРёС„С„РµСЂРµРЅС†РёСЂРѕРІР°РЅРЅС‹С… РїР»Р°С‚РµР¶РµР№**/
	public static void calculate_diff(double var_sum, int var_period, double var_percent, double var_month_com, double var_onetime_com) {
		
		/* РїРµСЂРµРјРµРЅРЅС‹Рµ - СЂР°Р·РјРµСЂС‹ С‚Р°Р±Р»РёС†С‹ */
		/* РєРѕР»РёС‡РµСЃС‚РІРѕ СЃС‚СЂРѕРє */
		int difsize_line = var_period+3;
		/* РєРѕР»РёС‡РµСЃС‚РІРѕ СЃС‚РѕР»Р±С†РѕРІ */
		int difsize_column = 5;
		
		/* РёР·РјРµРЅРµРЅРёРµ СЂР°Р·РјРµСЂРѕРІ С‚Р°Р±Р»РёС†С‹ РїСЂРё РЅР°Р»РёС‡РёРё РєРѕРјРёСЃСЃРёР№ */
		if (var_onetime_com != 0) {
			difsize_line++;
			difsize_column=6;
		}
		if (var_month_com != 0) {
			difsize_column=6;
		}
		
		/* СЃС‚СЂРѕРєРѕРІС‹Р№ РјР°СЃСЃРёРІ - РЅР°Р·РІР°РЅРёСЏ СЃС‚РѕР»Р±С†РѕРІ */
		String [] name_column_dif = new String [difsize_column];
		/* РґРІСѓРјРµСЂРЅС‹Р№ СЃС‚СЂРѕРєРѕРІС‹Р№ РјР°СЃСЃРёРІ - РґР°РЅРЅС‹Рµ С‚Р°Р±Р»РёС†С‹ */
		String [][] data_dif = new String [difsize_line][difsize_column];
		
		/* РјР°СЃСЃРёРІ - РїР»Р°С‚РµР¶Рё РїРѕ РєСЂРµРґРёС‚Сѓ */
		double [] payment_dif = new double[difsize_line-2];
		/* РјР°СЃСЃРёРІ - Р·РЅР°С‡РµРЅРёСЏ РІС‹РїР»Р°С‡РµРЅРЅС‹С… РїСЂРѕС†РµРЅС‚РѕРІ */
		double [] percent_dif = new double[difsize_line-2];
		/* РјР°СЃСЃРёРІ - Р·РЅР°С‡РµРЅРёСЏ РѕСЃС‚Р°РІС€РµР№СЃСЏ СЃСѓРјРјС‹ РєСЂРµРґРёС‚Р° */
		double [] balance_dif = new double[difsize_line-2];
		
		/* РїРµСЂРµРјРµРЅРЅР°СЏ - СЃСѓРјРјР° РІС‹РїР»Р°С‚ */
		double sum_payment = var_sum;
		/* РїРµСЂРµРјРµРЅРЅР°СЏ - СЃСѓРјРјР° РІС‹РїР»Р°С‡РµРЅРЅС‹С… РїСЂРѕС†РµРЅС‚РѕРІ */
		double sum_percent = 0;
		/* РїРµСЂРµРјРµРЅРЅР°СЏ - СЃСѓРјРјР° РІС‹РїР»Р°С‚ РїРѕ РєРѕРјРёСЃСЃРёСЏРј */
		double sum_commission = var_month_com*var_period + var_onetime_com;;
		/* РїРµСЂРµРјРµРЅРЅР°СЏ РїРµСЂРµРїР»Р°С‚С‹ РїРѕ РєСЂРµРґРёС‚Сѓ */
		double overpay = 0;
		/* РїРµСЂРµРјРµРЅРЅС‹Рµ - С‚РµР»Рѕ РєСЂРµРґРёС‚Р° */
		double СЃredit_body = var_sum/var_period;
		double СЃredit_body_first = 0;
		
		/* Р·Р°РїРѕР»РЅРµРЅРёРµ РЅР°Р·РІР°РЅРёР№ СЃС‚РѕР»Р±С†РѕРІ С‚Р°Р±Р»РёС†С‹ */
		name_column_dif[0] = "Р”Р°С‚Р°";
		name_column_dif[1] = "РџР»Р°С‚РµР¶";
		name_column_dif[2] = "РџСЂРѕС†РµРЅС‚С‹";
		name_column_dif[3] = "РўРµР»Рѕ РєСЂРµРґРёС‚Р°";
		name_column_dif[4] = "РћСЃС‚Р°С‚РѕРє";
		
		/* СЂР°СЃС‡РµС‚ РµР¶РµРјРµСЃСЏС‡РЅРѕР№ РїСЂРѕС†РµРЅС‚РЅРѕР№ СЃС‚Р°РІРєРё */
		var_percent = (Math.rint(100000000*(var_percent/(100*12))))/100000000;
		
		/* С†РёРєР» СЂР°СЃС‡РµС‚Р° РІС‹РїР»Р°С‚, РїСЂРѕС†РµРЅС‚РѕРІ Р·Р° РІРµСЃСЊ РїРµСЂРёРѕРґ, Рё Р·Р°РїРёСЃСЊ Р·РЅР°С‡РµРЅРёР№ */
		for (int i = 0; i < var_period; i++) {
			СЃredit_body = (Math.rint(100*(СЃredit_body)))/100;
			if(i == var_period-1) {
				СЃredit_body_first = СЃredit_body;
				СЃredit_body = sum_payment;
			}
			payment_dif[i] = СЃredit_body + sum_payment*var_percent + var_month_com;
			percent_dif[i] = sum_payment*var_percent;
			sum_percent += percent_dif[i];
			balance_dif[i] = sum_payment;
			sum_payment -= СЃredit_body;
			sum_payment= (Math.rint(100*(sum_payment)))/100;
			
			payment_dif[i]= (Math.rint(100*(payment_dif[i])))/100;
			percent_dif[i]= (Math.rint(100*(percent_dif[i])))/100;
			balance_dif[i]= (Math.rint(100*(balance_dif[i])))/100;
		}
		balance_dif[var_period] = sum_payment;
		
		/* СЂР°СЃС‡РµС‚ РѕР±С‰РµР№ СЃСѓРјРјС‹ РІС‹РїР»Р°С‚ Рё РїРµСЂРµРїР»Р°С‚С‹ */
		for (int i=0; i < var_period; i++) {
			sum_payment += payment_dif[i];
		}
		sum_payment += var_onetime_com;
		overpay = sum_payment - var_sum;
						
		/* Р·Р°РїРѕР»РЅРµРЅРёРµ РІСЃРµС… СЏС‡РµРµРє С‚Р°Р±Р»РёС† СЃРѕРѕС‚РІРµС‚СЃС‚РІСѓСЋС‰РёРјРё РґР°РЅРЅС‹РјРё */
		data_dif[0][0] = date_format.format(calendar.getTime());
		for (int i = 0; i<var_period; i++) {
			calendar.add(Calendar.MONTH, 1);
			data_dif[i+1][0] = date_format.format(calendar.getTime());
			data_dif[i+1][1] = "" + payment_dif[i];
			data_dif[i+1][2] = "" + percent_dif[i];
			data_dif[i+1][3] = "" + СЃredit_body_first;
			data_dif[i][4] = "" + balance_dif[i];
		}
		data_dif[var_period][3] = "" + СЃredit_body;		
		data_dif[difsize_line-2][4] = "" + balance_dif[var_period];	
				
		/* Р·Р°РїРёСЃСЊ СЂРµР·СѓР»СЊС‚Р°С‚РѕРІ РІ РѕР±СЉРµРєС‚С‹ BigDecimal
		 * РґР»СЏ РєРѕСЂСЂРµРєС‚РЅРѕРіРѕ РІС‹РІРѕРґР° Р±РѕР»СЊС€РёС… С‡РёСЃРµР» */
		BigDecimal big_summ = new BigDecimal (sum_payment);
		BigDecimal big_percent = new BigDecimal(sum_percent);
		BigDecimal big_overpay = new BigDecimal(overpay);
		BigDecimal big_commission = new BigDecimal(sum_commission);
		/* Р·Р°РґР°РЅРёРµ РїР°СЂР°РјРµС‚СЂРѕРІ РІС‹РІРѕРґР°: 
		 * РєРѕР»РёС‡РµСЃС‚РІРѕ С†РёС„СЂ РїРѕСЃР»Рµ Р·Р°РїСЏС‚РѕР№, С‚РёРї РѕРєСЂСѓРіР»РµРЅРёСЏ */
		big_summ = big_summ.setScale(2, BigDecimal.ROUND_HALF_DOWN);
		big_percent = big_percent.setScale(2, BigDecimal.ROUND_HALF_UP);
		big_overpay = big_overpay.setScale(2, BigDecimal.ROUND_HALF_UP);
		big_commission = big_commission.setScale(2, BigDecimal.ROUND_HALF_UP);
		
		/* РёР·РјРµРЅРµРЅРёРµ Р·РЅР°С‡РµРЅРёР№ С‚Р°Р±Р»РёС†С‹ РїСЂРё РЅР°Р»РёС‡РёРё РµР¶РµРјРµСЃСЏС‡РЅРѕР№ РєРѕРјРёСЃСЃРёРё */
		if (var_month_com != 0.0) {
			for (int i = 0; i<var_period; i++) {
				data_dif[i+1][4] = "" + var_month_com;
				data_dif[i][5] = "" + balance_dif[i];
			}
			data_dif[0][4] = "0";
			data_dif[difsize_line-2][4] = "" + big_commission;
			data_dif[difsize_line-2][5] = "" + balance_dif[var_period];
			
			name_column_dif[4] = "РљРѕРјРёСЃСЃРёСЏ";
			name_column_dif[5] = "РћСЃС‚Р°С‚РѕРє";
		}
		
		/* РёР·РјРµРЅРµРЅРёРµ Р·РЅР°С‡РµРЅРёР№ С‚Р°Р±Р»РёС†С‹ РїСЂРё РЅР°Р»РёС‡РёРё РµРґРёРЅРѕРІСЂРµРјРµРЅРЅРѕР№ РєРѕРјРёСЃСЃРёРё */
		if (var_onetime_com != 0) {			
			/* СЃРјРµС‰РµРЅРёРµ СЃС‚СЂРѕРє РЅР° РѕРґРЅСѓ РІРЅРёР· */
			for (int i = var_period+1; i>=0; i--) {
				for (int j = 0; j<4; j++) {
					data_dif[i+1][j] = data_dif[i][j];
				}				
			}
			for (int i = 1; i<var_period+2; i++) {
				data_dif[i][4] = "" + var_month_com;
				data_dif[i][5] = "" + balance_dif[i-1];
			}
			data_dif[0][4] = "0";
			data_dif[0][0] = data_dif[1][0];
			data_dif[1][5] = data_dif[0][5] = "" + var_sum;
			data_dif[1][1] = "" + var_onetime_com;
			data_dif[1][4] = data_dif[1][1];
			data_dif[difsize_line-2][4] = "" + big_commission;
			data_dif[difsize_line-2][5] = "" + balance_dif[var_period];
			
			name_column_dif[4] = "РљРѕРјРёСЃСЃРёСЏ";
			name_column_dif[5] = "РћСЃС‚Р°С‚РѕРє";
		} 
		
		/* РґРѕР±Р°РІР»РµРЅРёРµ РєРѕРЅРµС‡РЅС‹С… Р·РЅР°С‡РµРЅРёР№ РІ С‚Р°Р±Р»РёС†Сѓ */
		data_dif[difsize_line-2][0] = "Р’СЃРµРіРѕ РІС‹РїР»Р°С‚";
		data_dif[difsize_line-2][1] = "" + big_summ;
		data_dif[difsize_line-2][2] = "" + big_percent;
		data_dif[difsize_line-2][3] = "" + var_sum;
		data_dif[difsize_line-1][0] = "РџРµСЂРµРїР»Р°С‚Р°";
		data_dif[difsize_line-1][1] = "" + big_overpay;
		
		/* Р·Р°РїРѕР»РЅРµРЅРёРµ РїСѓСЃС‚С‹С… СЏС‡РµРµРє РЅСѓР»СЏРјРё */
		for (int i=0; i<difsize_line-1; i++) {
			for (int j=0; j<difsize_column; j++) {
				if (data_dif[i][j] == null) {
					data_dif[i][j] = "0.0";
				}
			}
		}
		
 		/* Р·Р°РїРёСЃСЊ РїРѕР»СѓС‡РµРЅРЅС‹С… РґР°РЅРЅС‹С… РІ РёС‚РѕРіРѕРІСѓСЋ С‚Р°Р±Р»РёС†Сѓ РґР»СЏ РІС‹РІРѕРґР° */
		data_table = data_dif;
		name_column_table = name_column_dif;
		
		/* Р·Р°РїРёСЃСЊ СЂР°СЃС‡РµС‚РѕРІ СЃСѓРјРјС‹ РІС‹РїР»Р°С‚ Рё РїРµСЂРµРїР»Р°С‚С‹ РІ РїСѓР±Р»РёС‡РЅСѓСЋ РїРµСЂРµРјРµРЅРЅСѓСЋ */
		result_diff[0] = sum_payment;
		result_diff[1] = overpay;
	}
	/** РњР°СЃСЃРёРІ - СЂРµР·СѓР»СЊС‚Р°С‚С‹ СЂР°СЃС‡РµС‚РѕРІ РїРѕ РґРёС„С„РµСЂРµРЅС†РёСЂРѕРІР°РЅРЅРѕРјСѓ РєСЂРµРґРёС‚Сѓ **/
	static double  [] result_diff = new double [2];
	
	/** РњРµС‚РѕРґ, РІРѕР·РІСЂР°С‰Р°СЋС‰РёР№ СЃСѓРјРјСѓ РІС‹РїР»Р°С‚
	 * 	РїРѕ РґРёС„С„РµСЂРµРЅС†РёСЂРѕРІР°РЅРЅРѕРјСѓ РєСЂРµРґРёС‚Сѓ **/
	public static double getSumm_diff() {
		return result_diff[0];
	}
	/** РњРµС‚РѕРґ, РІРѕР·РІСЂР°С‰Р°СЋС‰РёР№ РїРµСЂРµРїР»Р°С‚Сѓ
	 *  РїРѕ РґРёС„С„РµСЂРµРЅС†РёСЂРѕРІР°РЅРЅРѕРјСѓ РєСЂРµРґРёС‚Сѓ **/
	public static double  getOverpay_diff() {
		return result_diff[1];
	}
		
	
	/** РњРµС‚РѕРґ РґР»СЏ РІС‹РІРѕРґР° РЅР° СЌРєСЂР°РЅ
	 *  РѕРєРЅР° СЃ С‚Р°Р±Р»РёС†РµР№, СЃРѕРґРµСЂР¶Р°С‰РµР№
	 *  СЂРµР·СѓР»СЊС‚Р°С‚С‹ СЂР°СЃС‡РµС‚РѕРІ
	 *  РїРѕ РґРёС„С„РµСЂРµРЅС†РёСЂРѕРІР°РЅРЅРѕРјСѓ РєСЂРµРґРёС‚Сѓ**/
	static void window_diff () {
		
		/* РіСЂР°С„РёС‡РµСЃРєРѕРµ РѕРєРЅРѕ СЃ СЂРµР·СѓР»СЊС‚Р°С‚Р°РјРё СЂР°СЃС‡РµС‚РѕРІ */
		JFrame frame = new JFrame("РџР»Р°РЅ РІС‹РїР»Р°С‚ РґРёС„С„РµСЂРµРЅС†РёСЂРѕРІР°РЅРЅС‹С… РїР»Р°С‚РµР¶РµР№");
		/* Р·Р°РґР°РЅРёРµ РїСЂРµРґРїРѕС‡С‚РёС‚РµР»СЊРЅРѕРіРѕ СЂР°Р·РјРµСЂР° РѕРєРЅР° */
		frame.setPreferredSize(new Dimension (770, 318));
		
		/* С‚Р°Р±Р»РёС†Р°, СЃРѕРґРµСЂР¶Р°С‰Р°СЏ РїР»Р°РЅ РІС‹РїР»Р°С‚
		 * РїРѕ РґРёС„С„РµСЂРµРЅС†РёСЂРѕРІР°РЅРЅРѕРјСѓ РєСЂРµРґРёС‚Сѓ */
		JTable table = new JTable(data_table, name_column_table);
		
		/* СѓСЃС‚Р°РЅРѕРІРєР° СЂР°Р·РјРµСЂРѕРІ РѕРєРЅР°, РїРѕРґС…РѕРґСЏС‰РёС… РїРѕРґ СЂР°Р·РјРµСЂС‹ СЃРѕРґРµСЂР¶РёРјРѕРіРѕ */
		frame.pack();
		/* РґРѕР±Р°РІР»РµРЅРёРµ РїР°РЅРµР»Рё РїСЂРѕРєСЂСѓС‚РєРё, СЃРѕРґРµСЂР¶Р°С‰СѓСЋ С‚Р°Р±Р»РёС†Сѓ */
		frame.add(new JScrollPane(table));

		/* РґРѕР±Р°РІР»РµРЅРёРµ СЂРµРЅРґРµСЂР° РґР»СЏ СЂР°СЃРїРѕР»РѕР¶РµРЅРёСЏ С‚РµРєСЃС‚Р° РІ С‚Р°Р±Р»РёС†Рµ РїРѕ С†РµРЅС‚СЂСѓ СЏС‡РµРµРє */
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		for(int x=0;x<table.getColumnCount();x++){
	         table.getColumnModel().getColumn(x).setCellRenderer( centerRenderer );
		}
		
		/* СЂР°СЃРїРѕР»РѕР¶РµРЅРёРµ РѕРєРЅР° РїРѕ С†РµРЅС‚СЂСѓ СЌРєСЂР°РЅР° */
		frame.setLocationRelativeTo(null);
		/* Р·Р°РґР°РЅРёРµ РІРёРґРёРјРѕСЃС‚Рё РѕРєРЅР° */		
		frame.setVisible(true);
	}
	
	
	/** РџРµСЂРµРјРµРЅРЅР°СЏ, РіРѕРІРѕСЂСЏС‰Р°СЏ Рѕ РЅР°Р»РёС‡РёРё РѕС€РёР±РѕРє РІ РІРІРµРґРµРЅРЅС‹С… РґР°РЅРЅС‹С….  
	 *  Р—РЅР°С‡РµРЅРёРµ true РѕР·РЅР°С‡Р°РµС‚ РѕС‚СЃСѓС‚СЃС‚РІРёРµ РѕС€РёР±РѕРє, false - РёС… РЅР°Р»РёС‡РёРµ**/
	private static boolean check = true;
	
	/** РњРµС‚РѕРґ РїСЂРѕРІРµСЂРєРё С‚РµРєСЃС‚РѕРІС‹С… РїРѕР»РµР№ РІРІРѕРґР° СЃ РІС…РѕРґРЅС‹РјРё РїР°СЂР°РјРµС‚СЂР°РјРё: 
	 *  РёРјСЏ РїРѕР»СЏ РІРІРѕРґР°, РјР°РєСЃРёРјР°Р»СЊРЅРѕРµ Р·РЅР°С‡РµРЅРёРµ, РјРёРЅРёРјР°Р»СЊРЅРѕРµ Р·РЅР°С‡РµРЅРёРµ**/
	public static boolean control(JTextField field, int min, int max) {
		
		/* РїСЂРѕРІРµСЂРєР° РїРѕР»СЏ РІРІРѕРґР° РЅР° РЅР°Р»РёС‡РёРµ СЃРёРјРІРѕР»РѕРІ */
		try {
			switch(field.getText()) {
			case(""):	throw new Exception();}
		}
		catch(Exception ex) {
			if (check) {
				JOptionPane.showMessageDialog(null, "Р—Р°РїРѕР»РЅРёС‚Рµ РІСЃРµ РїРѕР»СЏ!", "Р’РЅРёРјР°РЅРёРµ!" , JOptionPane.INFORMATION_MESSAGE);
			}			
			field.setText("0");
			check=false;
			return false;
		}
		
		/* РїСЂРѕРІРµСЂРєР° РїРѕР»СЏ РІРІРѕРґР° РЅР° С‚РёРї РІРІРµРґРµРЅРЅС‹С… РґР°РЅРЅС‹С… */
		try {Double.parseDouble(field.getText());}
		catch (NumberFormatException ex) {
			if (check) {
				JOptionPane.showMessageDialog(null, "РњРѕР¶РЅРѕ РІРІРѕРґРёС‚СЊ С‚РѕР»СЊРєРѕ С‡РёСЃР»Р°, РїРѕРІС‚РѕСЂРёС‚Рµ РІРІРѕРґ", "Р’РЅРёРјР°РЅРёРµ!" , JOptionPane.INFORMATION_MESSAGE);
			}
			check=false;
			return false;
		}
		
		/* РЅРѕСЂРјРёСЂРѕРІР°РЅРёРµ РІРІРµРґРµРЅРЅС‹С… РґР°РЅРЅС‹С…, СЃРѕРіР»Р°СЃРЅРѕ РєСЂР°Р№РЅРёРј Р·РЅР°С‡РµРЅРёСЏРј */
		try {
			/* С‡РёСЃР»РѕРІР°СЏ РїРµСЂРµРјРµРЅРЅР°СЏ РґР»СЏ РїСЂРѕРІРµСЂРєРё Р·РЅР°С‡РµРЅРёР№ */
			double x = Double.parseDouble(field.getText());
			if (x < min) {
				field.setText(Integer.toString(min));
				throw new Exception();
			}
			if (x > max) {
				field.setText(Integer.toString(max));
				throw new Exception();
			}
			/* РѕР±СЂР°Р±РѕС‚РєР° Р·РЅР°С‡РµРЅРёР№ СЃСЂРѕРєР° РєСЂРµРґРёС‚Р° */
			if (max == 360 | max == 30)	{
				/* РѕРєСЂСѓРіР»РµРЅРёРµ РІРІРµРґРµРЅРЅРѕРіРѕ Р·РЅР°С‡РµРЅРёСЏ РІ Р±РѕР»СЊС€СѓСЋ СЃС‚РѕСЂРѕРЅСѓ, 
				 * С‚Р°Рє РєР°Рє СЃСЂРѕРє РєСЂРµРґРёС‚Р° РјРѕР¶РµС‚ Р±С‹С‚СЊ С‚РѕР»СЊРєРѕ С†РµР»С‹Рј С‡РёСЃР»РѕРј*/
				x = Math.ceil(x);
				int x_int = (int) x;
				field.setText(Integer.toString(x_int));
			}else {
				x-=0;
				field.setText(Double.toString(x));
			}			
		}
		
		catch (Exception ex) {
			if (check) {
				JOptionPane.showMessageDialog(null, "Р’РІРµРґРµРЅС‹ РЅРµРєРѕСЂСЂРµРєС‚РЅС‹Рµ РґР°РЅРЅС‹Рµ", "Р’РЅРёРјР°РЅРёРµ!" , JOptionPane.INFORMATION_MESSAGE);
			}
			check=false;
			return false;
		}
		return check;
	}
}

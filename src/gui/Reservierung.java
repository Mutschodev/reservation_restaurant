package gui;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import java.util.Calendar;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Label;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;


public class Reservierung extends JFrame {

	private JPanel contentPane;
	static JButton buttonT1;
	static JButton buttonT2;
	static JButton buttonT3;
	static JButton buttonT4;
	static JButton buttonT5;
	static JButton buttonT6;
	static JButton buttonT7;
	static JButton buttonT8;
	static JButton buttonT9;
	static JButton buttonT10;
	private JTable liste;

	public static JButton getButton() {
		return buttonT1;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservierung frame = new Reservierung();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	Connection myConn=null;
	private JScrollPane scrollPane;
	public Reservierung() {
		setBackground(SystemColor.activeCaption);
		myConn=jdbc.dbConnector();
		setTitle("Reservierungssystem");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 740);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 440, 818, 262);
		contentPane.add(scrollPane);
		
		liste = new JTable();
		liste.setBackground(UIManager.getColor("Button.background"));
		scrollPane.setViewportView(liste);
		
		JButton btnReservierungenAnzeigen = new JButton("Alle Reservierungen");
		btnReservierungenAnzeigen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnReservierungenAnzeigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//gegebenenfalls noch Optionen für morgen hinzufügen
					// SQL Query für alle Reservierungen ab heutigen Tag
					String queryReservierung ="SELECT Reservierungid,Tischnummer, Zeitraum, Vorname, Nachname, Personenanzahl, Telefonnummer, email, Datum FROM reservierung WHERE Datum>=? ORDER BY DATUM, Zeitraum, Tischnummer"; //SQL QUERY
					PreparedStatement pst=myConn.prepareStatement(queryReservierung);
					java.sql.Date sqldate = new java.sql.Date(Calendar.getInstance().getTime().getTime()); // heutige Datum im sql format bekommen
					pst.setDate(1, sqldate);
					ResultSet rs= pst.executeQuery(); // PreparedStatement ausführen in ResultSet speichern
					liste.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception exc) {
					exc.printStackTrace();
					JOptionPane.showMessageDialog(contentPane, "Anfrage fehlgeschlagen");
			}
			    
				
			}
		});
		btnReservierungenAnzeigen.setBounds(838, 422, 162, 51);
		contentPane.add(btnReservierungenAnzeigen);
		
		JButton btnReservierungenAnzeigenHeute = new JButton("Heute Reservierungen");
		btnReservierungenAnzeigenHeute.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnReservierungenAnzeigenHeute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					// Datum = date funktioniert nicht // Date anders formatieren? 
					//Alle Reservierungen von heute anzeigen
					String queryReservierung ="SELECT Reservierungid, Tischnummer, Zeitraum, Vorname, Nachname, Personenanzahl, Telefonnummer, email, Datum FROM reservierung WHERE Datum=? ORDER BY Zeitraum, Tischnummer"; //SQL QUERY
					PreparedStatement pst=myConn.prepareStatement(queryReservierung);
					java.sql.Date sqldate = new java.sql.Date(Calendar.getInstance().getTime().getTime());  // heutige Datum im sql format bekommen
					pst.setDate(1, sqldate);
					ResultSet rs= pst.executeQuery(); // PreparedStatement ausführen in ResultSet speichern
					liste.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception exc) {
					exc.printStackTrace();
					JOptionPane.showMessageDialog(contentPane, "Anfrage fehlgeschlagen");
			}
			    
			    
				
			}
		});
		btnReservierungenAnzeigenHeute.setBounds(838, 483, 162, 51);
		contentPane.add(btnReservierungenAnzeigenHeute);
		
		Tischerzeugen tischerzeugen = new Tischerzeugen();
		buttonT1 = new JButton("T1");
		buttonT1.setBounds(28, 94, 156, 62);
		contentPane.add(buttonT1);
		buttonT1.addActionListener(tischerzeugen);
		
		buttonT2 = new JButton("T2");
		buttonT2.setBounds(194, 94, 156, 62);
		contentPane.add(buttonT2);
		buttonT2.addActionListener(tischerzeugen);
		
		buttonT3 = new JButton("T3");
		buttonT3.setBounds(360, 94, 156, 62);
		contentPane.add(buttonT3);
		buttonT3.addActionListener(tischerzeugen);
		
		buttonT4 = new JButton("T4");
		buttonT4.setBounds(527, 94, 156, 62);
		contentPane.add(buttonT4);
		buttonT4.addActionListener(tischerzeugen);
		
		buttonT5 = new JButton("T5");
		buttonT5.setBounds(693, 94, 156, 62);
		contentPane.add(buttonT5);
		buttonT5.addActionListener(tischerzeugen);
		
		buttonT6 = new JButton("T10");
		buttonT6.setBounds(693, 166, 156, 62);
		contentPane.add(buttonT6);
		buttonT6.addActionListener(tischerzeugen);
		
		buttonT7 = new JButton("T6");
		buttonT7.setBounds(28, 166, 156, 62);
		contentPane.add(buttonT7);
		buttonT7.addActionListener(tischerzeugen);
		
		buttonT8 = new JButton("T8");
		buttonT8.setBounds(360, 166, 156, 62);
		contentPane.add(buttonT8);
		buttonT8.addActionListener(tischerzeugen);
		
		buttonT9 = new JButton("T7");
		buttonT9.setBounds(194, 166, 156, 62);
		contentPane.add(buttonT9);
		buttonT9.addActionListener(tischerzeugen);
		
		buttonT10 = new JButton("T9");
		buttonT10.setBounds(527, 166, 156, 62);
		contentPane.add(buttonT10);
		
		JButton button = new JButton("Stornieren");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String eingabe = JOptionPane.showInputDialog(null,"Bitte geben Sie die zu löschende ID ein",
                        "Stornierung",
                        JOptionPane.PLAIN_MESSAGE);
				int eingabeint = Integer.parseInt(eingabe);			
				try {

					String insertReservierung = "DELETE FROM reservierung WHERE Reservierungid=?"; //SQL DELETE
					PreparedStatement pst =myConn.prepareStatement(insertReservierung);
					//Werte in values einsetzen
					pst.setInt(1, eingabeint);
					pst.executeUpdate(); // PreparedStatement ausführen in ResultSet speichern
				} catch (Exception exc) {
					exc.printStackTrace();
					JOptionPane.showMessageDialog(contentPane, "Überprüfen Sie ob eine gültige ID eingegeben haben!","Anfrage fehlgeschlagen", JOptionPane.INFORMATION_MESSAGE);


			}
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button.setBounds(838, 544, 162, 51);
		contentPane.add(button);
		
		JLabel bar = new JLabel("Bar");
		bar.setBackground(UIManager.getColor("Button.background"));
		bar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bar.setBounds(28, 28, 301, 43);
		contentPane.add(bar);
		buttonT10.addActionListener(tischerzeugen);
		Border border = BorderFactory.createLineBorder(Color.black, 3);
		bar.setBorder(border);
		

	}	
}
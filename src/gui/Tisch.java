package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import java.util.Calendar;
import javax.swing.SpinnerNumberModel;
import java.awt.SystemColor;

public class Tisch extends JFrame{	
	
	private JTable tableReservierungTisch;
	
	Connection myConn=null;
	public Tisch () {
		setBackground(SystemColor.activeCaption);
	myConn=jdbc.dbConnector();
	setBounds(100, 100, 1024, 740);
	JPanel contentPane = new JPanel();
	contentPane.setBackground(SystemColor.activeCaption);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	setLocationRelativeTo(null);
	
	// Cancel button
	JButton btnCancel = new JButton("Zurück");
	btnCancel.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			
		};
	});
	btnCancel.setBounds(355, 45, 104, 30);
	contentPane.add(btnCancel);
	/*// Belegt Button
	JButton btnBelegen = new JButton("belegen");
	btnBelegen.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JButton button = Reservierung.getButton();
			Color farbe = button.getBackground(); // Variable einfügen, die die Reservierungen der Datenbank bekommt
			if (farbe == Color.red) // Datenbankabfrage noch hinzufügen
			JOptionPane.showMessageDialog(contentPane, "Tisch schon belegt");					
			else button.setBackground(Color.red);

		}
	});
	btnBelegen.setBounds(700, 5, 104, 30);
	contentPane.add(btnBelegen); */
	JComboBox comboBox = new JComboBox();
	comboBox.setModel(new DefaultComboBoxModel(new String[] {"12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00"}));
	comboBox.setToolTipText("");
	comboBox.setBounds(10, 11, 95, 57);
	contentPane.add(comboBox);
	
	JDateChooser dateChooser = new JDateChooser();
	dateChooser.setBounds(115, 11, 183, 57);
	contentPane.add(dateChooser);
	dateChooser.setDateFormatString("yyyy-MM-dd");

	JSpinner personenanzahl = new JSpinner();
	personenanzahl.setModel(new SpinnerNumberModel(1, 1, 16, 1));
	personenanzahl.setBounds(115, 65, 50, 25);
	contentPane.add(personenanzahl);
	
	JTextField vorName = new JTextField();
	vorName.setBounds(10, 121, 96, 20);
	contentPane.add(vorName);
	vorName.setColumns(10);
	
	JTextField nachName = new JTextField();
	nachName.setBounds(111, 121, 96, 20);
	contentPane.add(nachName);
	nachName.setColumns(10);
	
	JLabel labelvorName = new JLabel("Vorname:");
	labelvorName.setBounds(10, 106, 83, 14);
	contentPane.add(labelvorName);
	
	JLabel labelnachName = new JLabel("Nachname:");
	labelnachName.setBounds(111, 106, 83, 14);
	contentPane.add(labelnachName);
	
	JTextField email = new JTextField();
	email.setBounds(217, 121, 96, 20);
	contentPane.add(email);
	email.setColumns(10);
	
	JTextField telefonNummer = new JTextField();
	telefonNummer.setToolTipText("");
	telefonNummer.setBounds(323, 121, 96, 20);
	contentPane.add(telefonNummer);
	telefonNummer.setColumns(10);
	
	JLabel labelEmail = new JLabel("EMAIL: ");
	labelEmail.setBounds(217, 106, 48, 14);
	contentPane.add(labelEmail);
	
	JLabel labelTelefonNummer = new JLabel("TelNr.:");
	labelTelefonNummer.setBounds(322, 106, 48, 14);
	contentPane.add(labelTelefonNummer);
	
	JScrollPane scrollTable = new JScrollPane();
	scrollTable.setBounds(10, 152, 746, 307);
	contentPane.add(scrollTable);
	
	tableReservierungTisch = new JTable();
	scrollTable.setViewportView(tableReservierungTisch);
	
	JLabel labelPersonenAnzahl = new JLabel("Personenanzahl");
	labelPersonenAnzahl.setBounds(20, 71, 83, 14);
	contentPane.add(labelPersonenAnzahl);
	
	JButton button = new JButton("Save");
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {

				String insertReservierung = "INSERT INTO reservierung (Datum, Zeitraum, Personenanzahl, Vorname, Nachname, email, Telefonnummer, Tischnummer, Reservierungid) "
						+ "values (?,?,?,?,?,?,?,?,null)";
				PreparedStatement pst =myConn.prepareStatement(insertReservierung);
				//Werte in values einsetzen
				java.sql.Date sqldate = new java.sql.Date(dateChooser.getDate().getTime());
				pst.setDate(1, sqldate);
				pst.setString(2, comboBox.getSelectedItem().toString());
				pst.setInt(3, (int) personenanzahl.getValue());
				pst.setString(4, vorName.getText());
				pst.setString(5, nachName.getText());
				pst.setString(6, email.getText());
				int tele = Integer.parseInt(telefonNummer.getText());
				pst.setInt(7, tele);
				Tischerzeugen nr = new Tischerzeugen();
				int id = nr.getTischnummer();
				pst.setInt(8, id);

				
				// Tischnummer noch einfügen; Variable muss von Tischerzeugen mitgegeben werden
				pst.executeUpdate(); // PreparedStatement ausführen in ResultSet speichern
			} catch (Exception exc) {
				exc.printStackTrace();
				JOptionPane.showMessageDialog(contentPane, "Überprüfen Sie ob eine Doppelreservierung vorliegt!","Anfrage fehlgeschlagen", JOptionPane.INFORMATION_MESSAGE);


		}
		    
		}
	});
	button.setBounds(355, 5, 104, 30);
	contentPane.add(button);
	
	JButton buttonReservierungenAnzeigen = new JButton("Alle anzeigen");
	buttonReservierungenAnzeigen.setBounds(766, 152, 162, 51);
	contentPane.add(buttonReservierungenAnzeigen);
	buttonReservierungenAnzeigen.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				//gegebenenfalls noch Optionen für morgen hinzufügen
				// SQL Query für alle Reservierungen ab heutigen Tag
				String queryReservierung ="SELECT Reservierungid, Zeitraum, Vorname, Nachname, Personenanzahl, Telefonnummer, email, Datum FROM reservierung WHERE Datum>=? AND Tischnummer=? ORDER BY DATUM, Zeitraum, Reservierungid"; //SQL QUERY
				PreparedStatement pst=myConn.prepareStatement(queryReservierung);
				java.sql.Date sqldate = new java.sql.Date(Calendar.getInstance().getTime().getTime()); // heutige Datum im sql format bekommen
				pst.setDate(1, sqldate);
				Tischerzeugen nr = new Tischerzeugen();
				int id = nr.getTischnummer();
				pst.setInt(2, id);
				ResultSet rs= pst.executeQuery(); // PreparedStatement ausführen in ResultSet speichern
				tableReservierungTisch.setModel(DbUtils.resultSetToTableModel(rs));
			} catch (Exception exc) {
				exc.printStackTrace();
				JOptionPane.showMessageDialog(contentPane, "Anfrage fehlgeschlagen");
		}
		    
			
		}
	});
	

	

}	
}	
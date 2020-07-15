package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//erzeugt Tische je nach Button gedrückt
	public class Tischerzeugen implements ActionListener {
		// Tischnummer an Tischklasse übergeben einfügen
		static int Tischnummer;
		public int getTischnummer() {
			return Tischnummer;
		}
		public void setTischnummer(int tischnummer) {
			Tischnummer = tischnummer;
		}


		public void actionPerformed(ActionEvent event) {
			if(event.getSource()==Reservierung.buttonT1) {
				Tisch Tisch1 = new Tisch();
				Tisch1.setVisible(true);
				setTischnummer(1);
				Tisch1.setTitle("Tisch"+Tischnummer);
			}
			else if(event.getSource()==Reservierung.buttonT2) {
				Tisch Tisch2 = new Tisch();
				Tisch2.setVisible(true);
				setTischnummer(2);
				Tisch2.setTitle("Tisch"+Tischnummer);
			}
				else if(event.getSource()==Reservierung.buttonT3) {
				Tisch Tisch3 = new Tisch();
				Tisch3.setVisible(true);
				setTischnummer(3);
				Tisch3.setTitle("Tisch"+Tischnummer);
		}
			else if(event.getSource()==Reservierung.buttonT4) {
				Tisch Tisch4 = new Tisch();
				Tisch4.setVisible(true);
				setTischnummer(4);
				Tisch4.setTitle("Tisch"+Tischnummer);
			}
			else if(event.getSource()==Reservierung.buttonT5) {
				Tisch Tisch5 = new Tisch();
				Tisch5.setVisible(true);
				setTischnummer(5);
				Tisch5.setTitle("Tisch"+Tischnummer);
			}
			else if(event.getSource()==Reservierung.buttonT6) {
				Tisch Tisch6 = new Tisch();
				Tisch6.setVisible(true);
				setTischnummer(6);
				Tisch6.setTitle("Tisch"+Tischnummer);
			}
			else if(event.getSource()==Reservierung.buttonT7) {
				Tisch Tisch7 = new Tisch();
				Tisch7.setVisible(true);
				setTischnummer(7);
				Tisch7.setTitle("Tisch"+Tischnummer);
			}
			else if(event.getSource()==Reservierung.buttonT8) {
				Tisch Tisch8 = new Tisch();
				Tisch8.setVisible(true);
				setTischnummer(8);
				Tisch8.setTitle("Tisch"+Tischnummer);
			}
			else if(event.getSource()==Reservierung.buttonT9) {
				Tisch Tisch9 = new Tisch();
				Tisch9.setVisible(true);
				setTischnummer(9);
				Tisch9.setTitle("Tisch"+Tischnummer);
			}
			else if(event.getSource()==Reservierung.buttonT10) {
				Tisch Tisch10 = new Tisch();
				Tisch10.setVisible(true);
				setTischnummer(10);
				Tisch10.setTitle("Tisch"+Tischnummer);
			}
		}}
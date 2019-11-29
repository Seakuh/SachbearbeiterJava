import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class SachbearbeiterAS extends JFrame {

	static JFrame frame;
	static AdminSachbearbeiterEditierenAAS edit = new AdminSachbearbeiterEditierenAAS();
	static JPanel editierenfenster = edit.gibPanel();
	static JPanel erzeugenfenster;
	static JPanel fallEditieren;
	static JMenuBar menuBar = new JMenuBar();
	static JMenu mnSachbearbeiter = new JMenu("Sachbearbeiter");
	static JToolBar toolAdmin = new JToolBar();
	static JMenuItem loeschen = new JMenuItem("Löschen");
	static JMenu mnZurck = new JMenu("Zurück");
	static JMenuItem zurueck = new JMenuItem("Zurück");
	static JMenuItem forbildungzuordnenLoeschen = new JMenuItem("Fortbildungzuordnung Löschen");

	static JButton btnEditieren = new JButton("Editieren");
	static JButton btnfortbildung_zuweisen = new JButton("Fortbildung zuweisen");
	static JButton btnFortbildungzuordnenLoeschne = new JButton("Fortbildungzuordnung löschen");
	static JButton btnZurueck = new JButton("Zurück");


	public static void start(JFrame f) {
		frame = f;
		frame.setTitle("Sachbearbeiter Verwaltung Sachbearbeiter");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setMinimumSize(new Dimension(600, 400));
		frame.repaint();
		frame.setVisible(true);

		System.out.println("In Sachbearbeiter SachbearbeiterEditierenAS");

		frame.setJMenuBar(menuBar);

		menuBar.add(mnSachbearbeiter);

		JMenuItem editieren = new JMenuItem("Editieren", KeyEvent.VK_D);
		KeyStroke editierenKeyStroke = KeyStroke.getKeyStroke("alt shift D");
		editieren.setAccelerator(editierenKeyStroke);
		editieren.setMnemonic(KeyEvent.VK_E);
		editieren.addActionListener(new editierenlistener());
		mnSachbearbeiter.add(editieren);

		JMenuItem folbildung_zuordnen = new JMenuItem("Fortbildung zuweisen");
		KeyStroke fortbildungZuordnenKeyStroke = KeyStroke.getKeyStroke("alt shift U");
		folbildung_zuordnen.setMnemonic(KeyEvent.VK_O);
		folbildung_zuordnen.setAccelerator(fortbildungZuordnenKeyStroke);
		folbildung_zuordnen.addActionListener(new zuweisenlistener());
		mnSachbearbeiter.add(folbildung_zuordnen);

		KeyStroke zurueckKeyStroke = KeyStroke.getKeyStroke("alt shift Z");
		zurueck.setAccelerator(zurueckKeyStroke);
		zurueck.setMnemonic(KeyEvent.VK_Z);
		mnZurck.add(zurueck);
		mnZurck.addActionListener(new zuruecklistener());
		menuBar.add(mnZurck);
		
		KeyStroke fortbildungzuordnungLoeschen = KeyStroke.getKeyStroke("alt shift O");
		forbildungzuordnenLoeschen.setAccelerator(fortbildungzuordnungLoeschen);
		forbildungzuordnenLoeschen.setMnemonic(KeyEvent.VK_L);
		forbildungzuordnenLoeschen.addActionListener(new fortbildungloeschenlistener());
		mnSachbearbeiter.add(forbildungzuordnenLoeschen);
		
		frame.add(toolAdmin, BorderLayout.NORTH);

		btnEditieren.addActionListener(new editierenlistener());
		toolAdmin.add(btnEditieren);

		btnfortbildung_zuweisen.addActionListener(new zuweisenlistener());
		toolAdmin.add(btnfortbildung_zuweisen);

		btnFortbildungzuordnenLoeschne.addActionListener(new fortbildungloeschenlistener());
		toolAdmin.add(btnFortbildungzuordnenLoeschne);

		btnZurueck.addActionListener(new zuruecklistener());
		toolAdmin.add(btnZurueck);
		
		btnZurueck.setMnemonic(KeyEvent.VK_Z);
		btnEditieren.setMnemonic(KeyEvent.VK_E);
		btnFortbildungzuordnenLoeschne.setMnemonic(KeyEvent.VK_L);
		btnfortbildung_zuweisen.setMnemonic(KeyEvent.VK_U);
		btnFortbildungzuordnenLoeschne.setMnemonic(KeyEvent.VK_O);


		frame = f;

	}

	void adminSachbearbeiterEditierenAbschliessen(JPanel adminEditPanel) {
		System.out.println("Im adminsachbearbeiterEditieren ");
	}

	public static void graumachen() {
		btnEditieren.setEnabled(false);
		btnfortbildung_zuweisen.setEnabled(false);
		btnFortbildungzuordnenLoeschne.setEnabled(false);
		btnZurueck.setEnabled(false);
	}

	public static void entgrauen() {
		btnEditieren.setEnabled(true);
		btnfortbildung_zuweisen.setEnabled(true);
		btnFortbildungzuordnenLoeschne.setEnabled(true);
		btnZurueck.setEnabled(true);
	}


	public static class editierenlistener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			SachbearbeiterAS.graumachen();
			SachbearbeiterSachbearbeiterEditierenAAS sachbearbeitereditieren =  new SachbearbeiterSachbearbeiterEditierenAAS();
			fallEditieren = sachbearbeitereditieren.oeffnen();
			frame.repaint();
			frame.add(fallEditieren);
			frame.setVisible(true);

		}
	}

	public static class zuweisenlistener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			SachbearbeiterAS.graumachen();
			FortbildungZuordnenAAS auswaehlen = new FortbildungZuordnenAAS();
			JPanel fortbildungZuweisen = auswaehlen.oeffnen();
			frame.repaint();
			frame.add(fortbildungZuweisen);
			frame.setVisible(true);

		}
	}

	public static class fortbildungloeschenlistener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			SachbearbeiterAS.graumachen();
			FortbildungLoeschenAAS loeschen = new FortbildungLoeschenAAS();
			JPanel fortbildungloeschen = loeschen.oeffnen();
			frame.repaint();
			frame.add(fortbildungloeschen);
			frame.setVisible(true);
		}
	}

	public static class zuruecklistener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {

			System.out.println("Im zurück Listener");
			LehrveranstaltungsVerwaltungHS.neuOeffnen();
			
		}
	}

}

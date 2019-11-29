import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.JButton;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class LehrveranstaltungsVerwaltungHS extends JFrame {

	static LehrveranstaltungsVerwaltungHS instance;
	static String name = "";
	static JFrame f = new JFrame();
	static JPanel loginPanel;
	static JToolBar toolBarMain;
	static JMenuBar menuBar = new JMenuBar();
	static JMenu mnBeenden = new JMenu("Beenden");
	static JMenuItem beenden = new JMenuItem("Beenden", KeyEvent.VK_E);
	static JPanel contentPane = new JPanel();
	static JToolBar toolBar = new JToolBar();
	static JButton btnLogin = new JButton("Login");
	static JMenu mnLogin = new JMenu("Login");
	static JButton btnBeenden = new JButton("Beenden");
	static JMenuItem miLogin = new JMenuItem("Login", KeyEvent.VK_L);

	/**
	 * Launch the application.
	 */
	
	
	public void oeffnen() {
		f.setVisible(true);
	}

	public LehrveranstaltungsVerwaltungHS(String name1) {
		name = name1;
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setTitle("Lehrveranstaltungs Verwaltung");
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 450, 300);
		f.setMinimumSize(new Dimension(600, 400));

		f.setJMenuBar(menuBar);

		KeyStroke beendenKeyStroke = KeyStroke.getKeyStroke("alt shift E");
		beenden.setAccelerator(beendenKeyStroke);
		beenden.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnBeenden.add(beenden);
		menuBar.add(mnBeenden);

//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
//		f.add(contentPane);
//		f.setContentPane(contentPane);

		toolBarMain = toolBar;
		f.add(toolBar, BorderLayout.NORTH);

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loginPanel = LoginAS.login();

				f.add(loginPanel);
				f.setVisible(true);
			}
		});
		toolBar.add(btnLogin);

		menuBar.add(mnLogin);
		KeyStroke keyLogin = KeyStroke.getKeyStroke("alt shift L");
		miLogin.setAccelerator(keyLogin);
		miLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				loginPanel = LoginAS.login();

				f.add(loginPanel);
				f.setVisible(true);
			}
		});

		mnLogin.add(miLogin);
		mnLogin.setMnemonic(KeyEvent.VK_L);


		btnBeenden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		toolBar.add(btnBeenden);
		btnBeenden.setMnemonic(KeyEvent.VK_B);

	}

	public static void loginBeenden(int akteur, JPanel loginPanel) {

		System.out.println("Im loginBeenden" + akteur);
		f.setVisible(true);
		f.getContentPane().removeAll();
		LehrveranstaltungsVerwaltungHS.loescheLoginPanel();
		LehrveranstaltungsVerwaltungHS.loescheToolBar();

		if (akteur == 1) {
			AdministratorAS.start(f);

		}
		if (akteur == 2) {
			SachbearbeiterAS.start(f);
		}
	}

	public JFrame getF() {
		return f;
	}

	public static JFrame getInstanceFrame(LehrveranstaltungsVerwaltungHS instance) {
		return f;
	}

	public static JPanel getLoginPanel() {

		return loginPanel;
	}

	public static void loescheLoginPanel() {
		loginPanel.setVisible(false);
		f.remove(loginPanel);
	}

	public static void loescheToolBar() {
		toolBar.setVisible(false);
	}

	
	
	public static void neuOeffnen() {
		f.dispose();
		f = null;
		f = new JFrame();
		LehrveranstaltungsVerwaltungHS neu = new LehrveranstaltungsVerwaltungHS("neu");
		toolBar = null;
		toolBar = new JToolBar();
		btnLogin = null;
		btnLogin = new JButton("Login");
		btnBeenden = null;
		btnBeenden = new JButton("Beenden");
		
		
		
		f.add(toolBar, BorderLayout.NORTH);

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loginPanel = LoginAS.login();

				f.add(loginPanel);
				f.setVisible(true);
			}
		});
		btnLogin.setMnemonic(KeyEvent.VK_L);
		btnBeenden.setMnemonic(KeyEvent.VK_B);
		toolBar.add(btnLogin);


		btnBeenden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		toolBar.add(btnBeenden);
		
		neu.setVisible(true);
		neu.getF().setExtendedState(JFrame.MAXIMIZED_BOTH);
		neu.oeffnen();
		
		
		
	}
}

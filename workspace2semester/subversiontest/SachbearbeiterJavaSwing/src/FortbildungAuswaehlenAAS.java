import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class FortbildungAuswaehlenAAS extends JComboBox {
	
	FortbildungAuswaehlenK kontrolle = new FortbildungAuswaehlenK();
	JComboBox auswahlBoxFortbildungen;
	String auswahl;
	
	
	
	public FortbildungAuswaehlenAAS(){
		auswahlBoxFortbildungen = new JComboBox(kontrolle.gibNamen());
		auswahlBoxFortbildungen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				auswahl = (String) auswahlBoxFortbildungen.getSelectedItem();
				System.out.println(auswahl);
			}
		});
		
	}
	
	
	
	public JComboBox oeffnen() {
		return auswahlBoxFortbildungen;
	}
	
	public String getAuswahl() {
		System.out.println(auswahl);
		return auswahl;
	}

}

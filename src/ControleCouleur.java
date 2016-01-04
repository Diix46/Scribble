import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class ControleCouleur extends JFrame{

	//private Panneau pan = new Panneau();
	JButton bouton = new JButton("Effacer");
	JPanel container = new JPanel();
	JLabel label = new JLabel("Choix de la couleur");
	private JComboBox combo = new JComboBox();
	Scribble scribble = new Scribble() ;

	public ControleCouleur(){
		this.setTitle("Scribble");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		this.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		container.add(scribble, BorderLayout.CENTER);

		bouton.addActionListener(new BoutonListener());     
		JPanel south = new JPanel();
		south.add(bouton);
		container.add(south, BorderLayout.SOUTH);

		combo.addItem("Noir");
		combo.addItem("Rouge");
		combo.addItem("Vert");
		combo.addItem("Bleu"); 
		
		combo.addActionListener(new FormeListener());
		JPanel top = new JPanel();
		top.add(label);
		top.add(combo);    
		container.add(top, BorderLayout.NORTH);
		this.setContentPane(container);
		this.setVisible(true); 
	}

	//Classe écoutant notre bouton
	public class BoutonListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			
			bouton.setEnabled(true);
		}
	}


	class FormeListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(combo.getSelectedItem().equals("Noir")){
				scribble.changeCouleur(Color.BLACK);
			}
			if(combo.getSelectedItem().equals("Rouge")){
				scribble.changeCouleur(Color.RED);
			}
			if(combo.getSelectedItem().equals("Vert")){
				scribble.changeCouleur(Color.GREEN);
			}
			if(combo.getSelectedItem().equals("Bleu")){
				scribble.changeCouleur(Color.BLUE);
			}
		}  
	}
  
}
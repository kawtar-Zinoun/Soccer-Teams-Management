
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.border.LineBorder;

import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Equipe1{

	private JFrame frame; // on crée un nouveau frame
   public void setFrameVisible() {
	   frame.setVisible(true);      // un setter qui nous permet de rendre le frame visible
   }
	public Equipe1() { // le constructeur de la classe Equipe1
		
		
		JComboBox comboBox1 = new JComboBox(); // initialization comboBox
		
			Connexion cr = new Connexion(); 
			cr.conection(); // initialization de la connexion à partir de la méthode conection()
			
			frame = new JFrame("Equipe"); // initialization du frame
        frame.setBounds(100, 100, 1000, 700); // pour definir la location et la longeur et la largeur
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // pour fermer le frame qu'on on clique sur fermer
			
			JPanel panel = new JPanel(); // initialization d'un nouveau Jpanel
			panel.setBackground(new Color(51, 51, 51)); // on change la couleur du background
	frame.getContentPane().add(panel); // on ajoute le panel au frame
			panel.setLayout(null); // pour pouvoir positioner le panel où on veut
			
			JPanel panel1 = new JPanel();
			panel1.setBackground(SystemColor.controlHighlight);
			panel1.setForeground(new Color(0, 0, 0)); // pour changer la couleur de texte
			panel1.setBounds(0, 0, 550, 800); 
			panel.add(panel1);
			panel1.setLayout(null);
			
			JLabel lblL = new JLabel("Liste des equipes"); // initialization JLabel
			lblL.setBounds(58, 79, 254, 40);
			panel1.add(lblL);
			lblL.setForeground(new Color(0, 0, 0));
lblL.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 30)); // changer le font family
			
			JLabel label1 = new JLabel("Equipe");
			label1.setForeground(new Color(204, 0, 0));
			label1.setBackground(new Color(255, 255, 255));
			label1.setBounds(59, 21, 159, 40);
			panel1.add(label1);
			label1.setFont(new Font("Century Gothic", Font.BOLD, 35));
			comboBox1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
			comboBox1.setBounds(150, 150, 200, 40);
			panel1.add(comboBox1);
			comboBox1.setMaximumRowCount(20); // on donne le nombre maximum de lignes dans le combobox
		
			
			JLabel lbl = new JLabel();
			lbl.setIcon(new ImageIcon("D:\\football2.jpg")); // on ajoute une icon au label
			                                                // et on utilise la photo en tant que label
			lbl.setBounds(0, 280, 800, 395);
			panel1.add(lbl); // on ajoute le label dans le panel
			
			JButton Button1 = new JButton("Ajouter"); // on initialize un nouveau Jbutton
			Button1.setBorder(new LineBorder(new Color(255, 255, 204), 3)); // on change la couleur du 
			                                                               // border du bouton
			
			Button1.setBounds(700, 48, 200, 50);
			panel.add(Button1); // on ajoute le bouton dans le premier panel


			Button1.setBackground(new Color(241, 57, 83));
			Button1.setForeground(new Color(255, 255, 255));
			Button1.setFont(new Font("Footlight MT Light", Font.BOLD, 27));
			
Button1.addActionListener(new ActionListener() { // on ajoute un action listener qui fait des opérations
				                                             // une fois le bouton est cliqué
				public void actionPerformed(ActionEvent arg0) {
				 AddEquipe eq =	new AddEquipe(); // on appelle le constructeur de AddEquipe 
		eq.setFrameVisible(); // ceci est un setter dans AddEquipe qui permet de rendre le frame visible
				frame.setVisible(false); // on cache cette fenetre 
				 
				 
				}
			});
			
			JButton button2 = new JButton("Modifier");
	        button2.setBorder(new LineBorder(new Color(255, 255, 204), 3));
			
			button2.setBounds(700, 190, 200, 50);
			panel.add(button2); // on refait la meme chose avec le bouton modifier


			button2.setBackground(new Color(241, 57, 83));
			button2.setForeground(new Color(255, 255, 255));
			button2.setFont(new Font("Footlight MT Light", Font.BOLD, 27));
			button2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ModifyEquipe md = new ModifyEquipe(); // on appelle le constructeur de ModifyEquipe
					
  md.nmEq = String.valueOf(comboBox1.getSelectedItem()); // on affecte la valeur de l'item selectionné
	//dans le combobox à l'attribut nmEq qui se trouve dans ModifyEquipe et qu'on va utiliser après
	     md.setTextField(String.valueOf(comboBox1.getSelectedItem())); // setTextField est un setter
	     // dans modify equipe qui nous permet de changer le texte du textField
		md.setframeVisible(); // setframevisible est aussi un setter pour rendre le frame visible
					frame.setVisible(false); // on cache le frame de Equipe1
					
					
				}
			});
			
			
			
		
			
			JButton button3 = new JButton("Supprimer");
			button3.setBounds(700, 335, 200, 50);
			panel.add(button3);
			button3.setBackground(new Color(241, 57, 83));
			button3.setForeground(new Color(255, 255, 255));
			button3.setBorder(new LineBorder(new Color(255, 255, 204), 3));
			button3.setFont(new Font("Footlight MT Light", Font.BOLD, 27));
			// on fait la meme chose avec le button supprimer
			button3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String item1 = String.valueOf(comboBox1.getSelectedItem());
				     Delete_Equipe dr = new Delete_Equipe();
int a=JOptionPane.showConfirmDialog(null,"Voulez vous vraiment supprimer l'équipe" + " " + item1 + "?");  
					   if(a==JOptionPane.YES_OPTION){ // si on clique sur oui sur le confirmDialog
                        dr.delete(item1); // on appelle la méthode delete de classe delete_equipe
                        // qui nous permet de supprimer l'equipe selectionée
						
			 comboBox1.removeItem(comboBox1.getSelectedItem()); // on enlève l'item après sa suppresion
	 JOptionPane.showMessageDialog(null, "l'equipe" + " " + item1 + " " + " a été supprimé avec succès.");
	 // On affiche un message que l'équipe est supprimée
						   comboBox1.revalidate(); // pour refraichir le combobox
							comboBox1.repaint(); // la meme chose
					   }
						
				}
			});
			
			
			JButton button4 = new JButton("Joueurs");
			button4.setBounds(700, 480, 200, 50);
			panel.add(button4);
			button4.setBackground(new Color(241, 57, 83));
			button4.setForeground(new Color(255, 255, 255));
			button4.setFont(new Font("Footlight MT Light", Font.BOLD, 27));
			button4.setBorder(new LineBorder(new Color(255, 255, 204), 3)); 
			// on refait la meme chose avec le bouton joueurs
			button4.setEnabled(true);
			button4.addActionListener(new ActionListener() {
				   public void actionPerformed(ActionEvent arg0) {
					   String eq = String.valueOf(comboBox1.getSelectedItem());
					   Joueurs j = new Joueurs(); // on appelle le constructeur de la classe joueurs
					   j.setframeVisible(); // pour rendre le frame de joueurs visible
					  
					   j.jouer(eq); // on appelle la méthode jouer qui prend en parametres la valeur
			 // de l'item selectioné dans la combobox et affiche les joueurs associés à l'equipe.
					
				}
			});
			
			try { // ici on va afficher les equipes qui se trouvent dans la bd dans le combobox
	Statement statement = cr.con.createStatement(); // on crée un statement qu'on va envoyer a la bd
		         String query = "SELECT * FROM equipe"; // on selectionne toutes les equipes
		         ResultSet rs = statement.executeQuery(query); // on execute le statement et on stocke
		         // le resultat dans un ResultSet

		       while (rs.next()) // la boucle ne s'arrete qu'une fois toutes les lignes sont parcourues 
		         {      
		                   
		       comboBox1.addItem(rs.getString(2)); // on ajoute le nom de l'equipe
		       // comme un item dans le combobox
		         }
				}
				catch (Exception ex) {
					System.out.print(ex.getMessage()); // on affiche le message d'erreur 
					// en cas d'exception generée
				}
	
	
	}


	public static void main(String[] args) {
		
				try {
					Equipe1 eq = new Equipe1(); // on initialize equipe1
					eq.frame.setVisible(true); // on rend le frame visible
				} catch (Exception e) {
					e.getMessage(); // on affiche un message en cas d'exception generée
				}
		
	}

	

}

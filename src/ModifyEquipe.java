
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.sql.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class ModifyEquipe {
	 protected String nmEq; // Ce string contient le nom de l'equipe selectionné dans la combobox 
	 // va etre affecté à partir de la classe equipe comme on a vu  precedement
	
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1; // declaration du frame et des textfield
	public void setframeVisible() {
		frame.setVisible(true);       // un setter pour rendre le frame visible
	}
	public void setTextField(String txt) {
		textField.setText(txt);            // un setter pour changer le texte du premier textfield
	}

	public ModifyEquipe() { // le constructeur de modifyEquipe
	frame = new JFrame("Modifier Equipe"); // initialization du frame
frame.setBounds(100, 100, 450, 300); // on change la location et la longeur et la largeur du frame
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //pour fermer le frame qu'on on clique sur fermer
		frame.getContentPane().setLayout(null); // on n'ajoute pas du layoutmanager pour
		// pouvoir positionner les composants librement
		
		JLabel modif = new JLabel("Modifier une equipe"); // initialization nouveau JLabel
		modif.setFont(new Font("Tahoma", Font.BOLD, 19)); // on change font family et la police
		modif.setBounds(99, 21, 224, 44);
		frame.getContentPane().add(modif); // on ajoute le label au frame
		
		JLabel NvNom = new JLabel("Nouveau nom"); 
		NvNom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		NvNom.setBounds(46, 98, 113, 14);
		frame.getContentPane().add(NvNom);
		// on refait la meme chose avec les labels NvNom et lbl
		JLabel lbl = new JLabel("Nouvelle ville");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl.setBounds(46, 165, 93, 14);
		frame.getContentPane().add(lbl);
		
		JLabel Retour = new JLabel("Retour"); 
		Retour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // le curseur devient sous 
		//forme d'une main qu'on on le passe sur Retour
		Retour.setForeground(new Color(153, 0, 0)); // pour changer la couleur du texte
		Retour.setFont(new Font("Tahoma", Font.BOLD, 16));
		Retour.setBounds(24, 11, 65, 20);
		frame.getContentPane().add(Retour);
		 Retour.addMouseListener(new MouseAdapter() { // on ajoute un mouseListener qui se declenche
			 // quand on clique sur retour
		        public void mouseClicked(MouseEvent e) {
		        	frame.dispose(); // on ferme ce frame
		          Equipe1 er = new Equipe1();
		          er.setFrameVisible(); // on appelle le setter pour rendre le frame de equipe visible
		           
		        }
		    });
		
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(218, 97, 141, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		// initialization des textfield
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setBounds(218, 164, 141, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btn1 = new JButton("Modifier"); // initialization nouveau bouton
		btn1.addActionListener(new ActionListener() { // on ajoute un action listener au bouton
			public void actionPerformed(ActionEvent e) {
				try {
				modifier(nmEq); // on appelle la méthode modifier qui prend en parametres le nom d'equipe
				 JOptionPane.showMessageDialog(null,"L'équipe a eté modifié avec succès"); 
				 // un message de confirmation
				}
				catch (Exception ex) {
					ex.getMessage();
				}
			}
		});
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn1.setBounds(150, 215, 89, 23);
		frame.getContentPane().add(btn1);
	}
	

	public void modifier(String nmEqr) {
		
		Connexion cr = new Connexion();
		cr.conection(); // on etablit la connexion avec la méthode conection() de la classe Connexion
		try {
			String sql = "update equipe" + " set Nom = ? , Ville = ?" + " where Nom LIKE ? ";
			// une requete Update pour changer le nom ou/et la ville de l'equipe selectionée
			PreparedStatement ps = cr.con.prepareStatement(sql); // on crée un prepared statement
			ps.setString(1, textField.getText()); // on met le premier parametre de la requete "?" qui
			// est le texte entré dans le textfield (nom d'equipe)
			ps.setString(2, textField_1.getText()); // on met la ville
			ps.setString(3, nmEqr); // on met le 3eme parametre qui est le nom de l'equipe selectionnée
			// dans le combobox et qui est passé en parametres
			ps.executeUpdate(); // on execute la requete sans rien retourner
			
		}
		catch (Exception ex) {
			ex.getMessage(); // on affiche un message en cas d'erreur
		}
	}

	public static void main(String[] args) {
		
				try {
					ModifyEquipe md = new ModifyEquipe();
					md.frame.setVisible(true); // on rend le frame visible
				} catch (Exception e) {
					e.getMessage();
				}
	}			
}

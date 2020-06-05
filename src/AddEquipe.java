
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Cursor;

public class AddEquipe {

	private JFrame frame2;
	private JTextField textField;
	private JTextField textField1; 
public void setFrameVisible() { // un setter pour rendre le frame visible
	frame2.setVisible(true);
}
	


	public AddEquipe() {
		Connexion cr = new Connexion(); 
		cr.conection(); // on initialize la classe Connexion et on appelle la méthode conection()
		// pour etablir la connexion avec la bd
		
		frame2 = new JFrame("Ajouter Equipe"); // on initialize le frame
		frame2.setBounds(100, 100, 450, 300); // on change sa location et sa largeur et longeur
frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // pour fermer le frame qu'on on clique sur fermer

		frame2.getContentPane().setLayout(null); // on n'ajoute pas de layoutmanager pour pouvoir 
		// positionner nous meme les composants du frame
		
		JPanel panel = new JPanel(); // on initialize le JPanel
		panel.setBounds(0, 0, 434, 261); // on change la longeur et la largeur
		frame2.getContentPane().add(panel); // on ajoute le panel au frame
		panel.setLayout(null); // on n'ajoute pas de layoutmanager
		
		JLabel lbl = new JLabel("Ajouter Equipe"); // on refait la meme chose avec le deuxième label
		lbl.setBounds(148, 11, 127, 21);
		lbl.setForeground(new Color(204, 0, 0)); // on change la couleur du texte
		lbl.setFont(new Font("Tahoma", Font.BOLD, 17)); // on changer le font family et la police
		panel.add(lbl);
		
		textField = new JTextField(); // on initialize un textfield
		
		textField.setBounds(162, 66, 142, 27); 
		panel.add(textField);
		textField.setColumns(10); // on donne le nombre de colones du textField
		
		textField1 = new JTextField(); // la meme chose avec le deuxième textField
		 
		textField1.setBounds(162, 137, 142, 27);
		panel.add(textField1);
		textField1.setColumns(10);
		
		JLabel label2 = new JLabel("Nom Equipe"); 
		label2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label2.setBounds(36, 72, 85, 21);
		panel.add(label2);
		// on refait la meme chose que le premier label avec label2 et label3
		JLabel label3 = new JLabel("Ville");
		label3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label3.setBounds(36, 143, 85, 14);
		panel.add(label3);
		  
		
		JLabel lblRetour = new JLabel("Retour"); // on initialize un label 
		lblRetour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // le curseur devient sous 
		//forme d'une main qu'on on le passe sur lblRetour
		lblRetour.setForeground(Color.BLACK);
		lblRetour.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRetour.setBounds(30, 14, 65, 20);
		panel.add(lblRetour);
		 lblRetour.addMouseListener(new MouseAdapter() { // on ajoute un mouseListener à lblRetour
		        public void mouseClicked(MouseEvent e) { // est appellée quand on clique sur lblRetour
		        	frame2.dispose(); // on ferme le frame actuel
		          Equipe1 er = new Equipe1();
		    er.setFrameVisible(); // on rend le frame de equipe1 visible grace au setter setframevisble
		           
		        }
		    });
		
		JButton buttonX = new JButton("Envoyer"); // initialization nouveau bouton
		buttonX.addActionListener(new ActionListener() { // on ajoute un actionListener
			public void actionPerformed(ActionEvent e) {
				try {
					
			String query = "INSERT into equipe(Nom,Ville) values(?,?)"; // une requete d'insertion
			     PreparedStatement ps = cr.con.prepareStatement(query); // on crée un Preparedstatement
			         ps.setString(1, textField.getText()); // on ajoute le texte du textfield 
			         // dans la premiere valeur ? de la requete SQL
			         ps.setString(2, textField1.getText()); // la meme chose pour la deuxième valeur 
			         ps.executeUpdate(); // on execute le prepared statement sans rien retourner
			         
			   JOptionPane.showMessageDialog(null, "Equipe ajouté avec succès"); // on affiche un
			   // message de confirmation
			      
			   
 			}
				catch (Exception ex) {
					System.out.print(ex.getMessage()); // en cas d'erreur on affiche le message
				}
				}
			
		});
		buttonX.setFont(new Font("Tahoma", Font.PLAIN, 13));
	buttonX.setBounds(152, 194, 104, 27); // on change la location et la longeur et la largeur du bouton
		panel.add(buttonX); // on ajoute le bouton au panel
	}
	public static void main(String[] args) {
		 try {
			AddEquipe add = new AddEquipe();
			add.frame2.setVisible(true); // on rend le frame visible
		} catch (Exception e) {
			e.getMessage(); // en cas d'erreur on affiche le message
		} 
		

}
}

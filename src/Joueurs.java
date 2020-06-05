
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Joueurs {

	private JFrame frame3;
public void setframeVisible() { // un setter pour rendre le frame visible
	frame3.setVisible(true);
}


	public Joueurs() { // constructeur de la classe joueurs
		frame3 = new JFrame("Joueurs"); // initialization du frame
		frame3.setBounds(100, 100, 450, 300); // on change la location et la largeur et longeur de frame
frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //pour fermer le frame qu'on on clique sur fermer
		frame3.setLayout(new BorderLayout()); // on donne un nouveau borderlayout à frame3
		  JLabel Retour = new JLabel("Retour"); // un label retour
		  JPanel pan = new JPanel(); // initialization nouveau panel
		  
		 Retour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // le curseur devient sous 
			//forme d'une main qu'on on le passe sur lblRetour
		   Retour.setForeground(new Color(153, 0, 0)); // couleur du texte
		   Retour.setFont(new Font("Tahoma", Font.BOLD, 16)); // font family et police
		   
		   pan.add(Retour); // on ajoute le label au panel
		   frame3.getContentPane().add(pan,
				   BorderLayout.SOUTH); // on positionne le panel dans le sud
		 Retour.addMouseListener(new MouseAdapter() {
		        public void mouseClicked(MouseEvent e) { 
		        	frame3.dispose(); // quand le label est cliqué on ferme ce frame
		          
		        }
		    }); 
		
	}

	public void jouer(String nomEq) { // cette méthode va nous afficher un jtableau des joueurs
		// associés à une equipe selectioné qu'on a passé son nom dans les parametres
		Connexion cr = new Connexion();
		cr.conection(); // on etablit la connexion
		try {
			
			JTable table = new JTable(); // on initialize un nouveau JTable
			table.setFont(new Font("Tahoma", Font.PLAIN, 16)); // on change la police du JTable
			 table.setRowHeight(30); // on change la taille des lignes du tableau
			 table.setDefaultEditor(Object.class, null); // on desactive le changement du tableau
			 // par l'utilisateur
			 
			DefaultTableModel model = new DefaultTableModel(new Object[]{"Nom","Prenom","Poste"},0 );
			// on declare un defaultTableModel qui prend en parametres un objet de colonnes
JScrollPane scrollPane = new JScrollPane(table); 
// JscrollPane nous donne une vue sur la table
String sql = "select * from joueur, equipe where joueur.ID_EQUIPE = equipe.ID_Equipe and equipe.Nom LIKE ? ";
// on fait la jointure entre equipe est joueur et on donne comme condition le nom de l'equipe qui est
//passé dans les parametres de la méthode
frame3.add(scrollPane); // on ajoute le scrollPane au frame
 PreparedStatement ps = cr.con.prepareStatement(sql); 
ps.setString(1, nomEq); // on met la variable nomEq qui est le nom de l'equipe dans le premier 
// parametre de la requete Sql

ResultSet rs = ps.executeQuery(); // on stocke le resultat dans un resultset
while (rs.next()) {
	// on obtient les resultats de la bd
String n = rs.getString("Nom_Joueur"); // on stocke la valeur de la colonne nom joueur dans un string
String p = rs.getString("Prenom_Joueur"); // on stocke la valeur de la colonne prenom joueur dans un string
String p2 = rs.getString("Poste"); // on stocke la valeur de la colonne poste dans un string
			Vector<String> row = new Vector<String>(); // on declare un vecteur de string
			row.addElement(n); 
			row.addElement(p); 
			row.addElement(p2); // on ajoute les resultats de la requete dans les elements du vecteur
			model.addRow(row); // on ajoute le vecteur dans le model qu'on a declaré au debut
            table.setModel(model); // on met ce model en tant que model du Jtable
            frame3.getContentPane().add(scrollPane); // on ajoute le scrollPane qui contient la table
            // au frame
		 } 
		}
		 catch (Exception ex) {
			 System.out.println(ex.getMessage()); // on affiche le message d'erreur en cas d'exception
		 }
		
	}
	public static void main(String[] args) {
		
		try {
			Joueurs window = new Joueurs();
			window.frame3.setVisible(true); // on rend le frame visible dès le debut du programme
		} catch (Exception e) {
			e.getMessage();
		}
}
	
}
